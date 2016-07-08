/**
 * 
 */
package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.exception.Code;
import com.muran.api.exception.GeneralResponseCode;
import com.muran.api.exception.ServerException;
import com.muran.dao.IGroupMenuDao;
import com.muran.dao.IMenuDao;
import com.muran.dao.IRoleDao;
import com.muran.dao.IUserMenuGroupDao;
import com.muran.dto.RoleKey;
import com.muran.model.Menu;
import com.muran.model.Role;
import com.muran.model.UserMenuGroup;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IMenuService;
import com.muran.util.DateUtil;

/**
 * @author wxz
 * 
 */
public class MenuService extends AbstractService implements IMenuService {

	@Resource(name = "MenuDao")
	private IMenuDao dao;

	@Resource(name = "RoleDao")
	private IRoleDao roleDao;

	@Resource(name = "GroupMenuDao")
	private IGroupMenuDao groupMenuDao;

	@Resource(name = "UserMenuGroupDao")
	private IUserMenuGroupDao userMenuGroupDao;

	@Override
	@BussAnnotation(bussName = "添加菜单", login = true, role = "")
	@Transactional(readOnly = false)
	public Menu addMenu(String type, String name, String descpt, String path,
			String icon, Integer order, Boolean enable, Long parentId,
			String roleKey, Boolean assign, Boolean isShow, String username,
			String userSys) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		if (parentId != 0) {
			menu = dao.findOne(parentId);
			if (menu == null) {
				throw new ServerException(GeneralResponseCode.BadRequestParams,
						"parentId参数错误！");
			}
		}
		menu = new Menu();
		menu.setCreateUser(userSys + "_" + username);
		menu.setDescpt(descpt);
		menu.setEnable(enable);
		menu.setIcon(icon);
		menu.setModifyUser(userSys + "_" + username);
		menu.setName(name);
		menu.setMenuOrder(order);
		menu.setParentId(parentId);
		menu.setPath(path);
		menu.setAssign(assign);
		menu.setShowMenu(isShow == null ? true : isShow);
		menu.setRoleKey(roleKey);
		menu.setType(type);
		menu = dao.merge(menu);
		return menu;
	}

	@Override
	@BussAnnotation(bussName = "更新菜单", login = true, role = "")
	@Transactional(readOnly = false)
	public Menu updateMenu(Long autoId, String type, String name,
			String descpt, String path, String icon, Integer order,
			Boolean enable, Long parentId, String roleKey, Boolean assign,
			Boolean isShow, String username, String userSys) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		if (parentId != 0) {
			menu = dao.findOne(parentId);
			if (menu == null) {
				throw new ServerException(GeneralResponseCode.BadRequestParams,
						"parentId参数错误！");
			}
		}
		menu = new Menu();
		menu = dao.findOne(autoId);
		if (menu == null) {
			throw new ServerException(GeneralResponseCode.BadRequestParams,
					"autoId参数错误！");
		}
		menu.setDescpt(descpt);
		menu.setEnable(enable);
		menu.setIcon(icon);
		menu.setModifyUser(userSys + "_" + username);
		menu.setName(name);
		menu.setMenuOrder(order);
		menu.setParentId(parentId);
		menu.setPath(path);
		menu.setAssign(assign);
		menu.setShowMenu(isShow);
		menu.setRoleKey(roleKey);
		menu.setType(type);
		menu = dao.update(menu);
		return menu;
	}

	@Override
	@BussAnnotation(bussName = "删除菜单", login = true, role = "")
	@Transactional(readOnly = false)
	public void deleteMenu(Long autoId) {
		// TODO Auto-generated method stub
		List<Menu> list = dao.getList(autoId);
		if (list != null && list.size() > 0) {
			throw new ServerException(Code.SubMenuExist, "存在子菜单，不能删除！");
		}
		dao.deleteById(autoId);
	}

	@Override
	@BussAnnotation(bussName = "获取菜单详细", login = true, role = "")
	public Menu getMenu(Long autoId) {
		// TODO Auto-generated method stub
		return dao.findOne(autoId);
	}

	@Override
	@BussAnnotation(bussName = "获取菜单列表", login = true, role = "")
	public List<Menu> getList(Long parentId) {
		// TODO Auto-generated method stub
		return dao.getList(parentId);
	}

	@Override
	@BussAnnotation(bussName = "获取用户菜单", login = true, role = "")
	public List<LinkedHashMap<String, Object>> getUserMenuTree(String username) {
		// TODO Auto-generated method stub
		List<Menu> list = dao.getListByUsernameAndParentId(username,
				Long.valueOf(0));
		List<LinkedHashMap<String, Object>> list2 = new ArrayList<LinkedHashMap<String, Object>>();
		for (Menu menu : list) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("autoId", menu.getAutoId());
			map.put("descpt", menu.getDescpt());
			map.put("enable", menu.isEnable());
			map.put("icon", menu.getIcon());
			map.put("name", menu.getName());
			map.put("order", menu.getMenuOrder());
			map.put("parentId", menu.getParentId());
			map.put("path", menu.getPath());
			map.put("roleKey",
					roleKeytoTree(getUserRoleKeys(menu.getAutoId(), username)));
			// map.put("roleKey", roleKeytoTree(menu.getRoleKey()));
			map.put("type", menu.getType());
			map.put("assign", menu.isAssign());
			map.put("isShow", menu.isShowMenu());
			map.put("menus", AddChildNodeByUsername(username, menu.getAutoId()));
			list2.add(map);
		}
		return list2;
	}

	@Override
	@BussAnnotation(bussName = "获取所有菜单", login = true, role = "")
	public List<LinkedHashMap<String, Object>> getAllMenuTree() {
		// TODO Auto-generated method stub
		List<Menu> list = dao.getList(Long.valueOf(0));
		List<LinkedHashMap<String, Object>> list2 = new ArrayList<LinkedHashMap<String, Object>>();
		for (Menu menu : list) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("autoId", menu.getAutoId());
			map.put("descpt", menu.getDescpt());
			map.put("enable", menu.isEnable());
			map.put("icon", menu.getIcon());
			map.put("name", menu.getName());
			map.put("order", menu.getMenuOrder());
			map.put("parentId", menu.getParentId());
			map.put("path", menu.getPath());
			map.put("roleKey", roleKeytoTree(menu.getRoleKey()));
			map.put("type", menu.getType());
			map.put("assign", menu.isAssign());
			map.put("isShow", menu.isShowMenu());
			map.put("menus", AddChildNode2(menu.getAutoId()));
			list2.add(map);
		}
		return list2;
	}

	private List<LinkedHashMap<String, Object>> AddChildNode2(Long autoId) {
		List<Menu> list = dao.getList(autoId);
		List<LinkedHashMap<String, Object>> list2 = new ArrayList<LinkedHashMap<String, Object>>();
		for (Menu menu : list) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("autoId", menu.getAutoId());
			map.put("descpt", menu.getDescpt());
			map.put("enable", menu.isEnable());
			map.put("icon", menu.getIcon());
			map.put("name", menu.getName());
			map.put("order", menu.getMenuOrder());
			map.put("parentId", menu.getParentId());
			map.put("path", menu.getPath());
			map.put("roleKey", roleKeytoTree(menu.getRoleKey()));
			map.put("type", menu.getType());
			map.put("assign", menu.isAssign());
			map.put("isShow", menu.isShowMenu());
			map.put("menus", AddChildNode2(menu.getAutoId()));
			list2.add(map);
		}
		return list2;
	}

	private List<LinkedHashMap<String, Object>> AddChildNodeByUsername(
			String username, Long autoId) {
		List<Menu> list = dao.getListByUsernameAndParentId(username, autoId);
		List<LinkedHashMap<String, Object>> list2 = new ArrayList<LinkedHashMap<String, Object>>();
		for (Menu menu : list) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("autoId", menu.getAutoId());
			map.put("descpt", menu.getDescpt());
			map.put("enable", menu.isEnable());
			map.put("icon", menu.getIcon());
			map.put("name", menu.getName());
			map.put("order", menu.getMenuOrder());
			map.put("parentId", menu.getParentId());
			map.put("path", menu.getPath());
			// map.put("roleKey", roleKeytoTree(menu.getRoleKey()));
			map.put("roleKey",
					roleKeytoTree(getUserRoleKeys(menu.getAutoId(), username)));
			map.put("type", menu.getType());
			map.put("assign", menu.isAssign());
			map.put("isShow", menu.isShowMenu());
			map.put("menus", AddChildNodeByUsername(username, menu.getAutoId()));
			list2.add(map);
		}
		return list2;
	}

	// 根据roleKey字符串组合roleKeyOnject
	private List<RoleKey> roleKeytoTree(String roleKey) {
		List<RoleKey> list = new LinkedList<RoleKey>();
		// 权限没有的直接返回空
		if (roleKey == null || roleKey.equals("") || roleKey.length() < 3) {
			return null;
		}
		// 去掉前后的逗号
		roleKey = roleKey.substring(1);
		roleKey = roleKey.substring(0, roleKey.length() - 1);

		// 循环获取rolekey
		String[] array = roleKey.split(",");
		for (int i = 0; i < array.length; i++) {

			Role role = roleDao.getRoleByKey(array[i]);
			if (role != null) {
				RoleKey roleKeyObj = new RoleKey();
				roleKeyObj.setAutoId(role.getKeyCode());
				roleKeyObj.setKeyCode(role.getKeyCode());
				roleKeyObj.setRoleName(role.getRoleName());
				roleKeyObj.setEnable(role.isEnable());
				list.add(roleKeyObj);
			}
		}
		return list;
	}

	private String getUserRoleKeys(Long menuId, String username) {
		List<UserMenuGroup> list = userMenuGroupDao
				.getUserMenuGroupsByUsername(username);
		String roleKeys = "";
		if (list != null) {
			for (UserMenuGroup userMenuGroup : list) {
				roleKeys += groupMenuDao.getRelationRoles(menuId,
						userMenuGroup.getGroupId());
			}
		}
		if (DateUtil.StringIsNull(roleKeys)) {
			return "";
		}
		String[] roleKeysArray = roleKeys.split(",");
		String str = ",";
		for (int i = 0; i < roleKeysArray.length; i++) {
			if (!DateUtil.StringIsNull(roleKeysArray[i])
					&& !str.contains(roleKeysArray[i])) {
				str += roleKeysArray[i] + ",";
			} else {
				continue;
			}
		}
		return str;

	}

}
