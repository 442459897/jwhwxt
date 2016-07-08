/**
 * 
 */
package com.muran.api.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.dao.IGroupMenuDao;
import com.muran.dao.IMenuGroupDao;
import com.muran.dao.IUserMenuGroupDao;
import com.muran.model.GroupMenu;
import com.muran.model.MenuGroup;
import com.muran.model.UserMenuGroup;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IMenuGroupService;

/**
 * @author wxz
 * 
 */
public class MenuGroupService extends AbstractService implements
		IMenuGroupService {

	@Resource(name = "MenuGroupDao")
	private IMenuGroupDao dao;
	
	@Resource(name = "GroupMenuDao")
	private IGroupMenuDao groupMenuDao;

	@Resource(name = "UserMenuGroupDao")
	private IUserMenuGroupDao userMenuGroupDao;

	@Override
	@BussAnnotation(bussName = "添加菜单组", login = true, role = "menugroup_add")
	@Transactional(readOnly = false)
	public MenuGroup addMenuGroup(String name,String code) {
		// TODO Auto-generated method stub
		MenuGroup menuGroup = new MenuGroup();
		menuGroup.setGroupName(name);
		menuGroup.setCode(code);
		menuGroup = dao.merge(menuGroup);
		return menuGroup;
	}

	@Override
	@BussAnnotation(bussName = "更新菜单组", login = true, role = "menugroup_update")
	@Transactional(readOnly = false)
	public MenuGroup updateMenuGroup(Long autoId, String name) {
		// TODO Auto-generated method stub
		MenuGroup menuGroup = new MenuGroup();
		menuGroup = dao.findOne(autoId);
		if (menuGroup == null) {
			throw new ServerException(Code.MenuGroupNotFound,
					" 菜单组信息不存在!");
		}
		menuGroup.setGroupName(name);
		menuGroup = dao.update(menuGroup);
		return menuGroup;
	}

	@Override
	@BussAnnotation(bussName = "删除菜单组", login = true, role = "menugroup_delete")
	@Transactional(readOnly = false)
	public void deleteMenuGroup(Long autoId) {
		// TODO Auto-generated method stub
		List<UserMenuGroup> list = userMenuGroupDao
				.getUserMenuGroupsByGroupId(autoId);
		List<GroupMenu> list2 = groupMenuDao.getGroupMenusByGroupId(autoId);
		if (list != null && list.size() > 0) {
			throw new ServerException(Code.MenuGroupToUserExist,
					" 菜单组-用户关系信息存在!不能删除！");
		}
		if (list2 != null && list2.size() > 0) {
			throw new ServerException(Code.MenuGroupToMenuExist,
					" 菜单组-菜单关系信息存在!不能删除！");
		}
		dao.deleteById(autoId);

	}

	@Override
	@BussAnnotation(bussName = "获取菜单组信息", login = true, role = "")
	public MenuGroup getMenuGroup(Long autoId) {
		// TODO Auto-generated method stub
		return dao.findOne(autoId);
	}

	@Override
	@BussAnnotation(bussName = "获取菜单组列表", login = true, role = "")
	public List<MenuGroup> getList(String code) {
		// TODO Auto-generated method stub
		// List<MenuGroup> list=new ArrayList<MenuGroup>();

			// 获取全部的菜单组
			return dao.getList(code);
		
		// return null;
	}
	

	

}
