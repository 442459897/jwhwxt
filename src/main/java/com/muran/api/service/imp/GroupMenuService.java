/**
 * 
 */
package com.muran.api.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.dao.IGroupMenuDao;
import com.muran.model.GroupMenu;
import com.muran.api.service.IGroupMenuService;
import com.muran.api.service.AbstractService;

/**
 * @author wxz
 * 
 */
public class GroupMenuService extends AbstractService implements
		IGroupMenuService {

	@Resource(name = "GroupMenuDao")
	private IGroupMenuDao dao;

	@Override
	@BussAnnotation(bussName = "建立菜单组-菜单关系", login = true, role = "menugroup_assign")
	@Transactional(readOnly = false)
	public void buildGroupMenu(Long groupId, String menus) {
		// TODO Auto-generated method stub
		// 删除原来的菜单组和菜单的关系
		dao.deleteGroupMenusByGroupId(groupId);
		// 新增关系
		if (menus != null && !menus.equals("")) {
			String[] array = menus.split("\\|");
			for (int i = 0; i < array.length; i++) {
				String[] array2 = array[i].split(":");

				Long menuId = Long.valueOf(array2[0]);
				String roleKeys = "";
				if (array2.length == 2) {
					roleKeys = "," + array2[1] + ",";
				}
				GroupMenu groupMenu = new GroupMenu();
				groupMenu.setGroupId(groupId);
				groupMenu.setMenuId(menuId);
				groupMenu.setRoleKey(roleKeys);
				dao.save(groupMenu);
			}
		}

	}

	@Override
	@BussAnnotation(bussName = "获取菜单组的菜单集合", login = true, role = "")
	@Transactional(readOnly = false)
	public String getMenuByGroup(Long groupId) {
		// TODO Auto-generated method stub
		List<GroupMenu> list = dao.getGroupMenusByGroupId(groupId);
		String result = "";
		if (list != null && list.size() > 0) {
			for (GroupMenu gm : list) {
				result += gm.getMenuId();
				if (gm.getRoleKey() != null && !gm.getRoleKey().equals("")) {
					result += gm.getRoleKey();
				} else {
					result += ",";
				}
			}
			log.info(result);
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
}
