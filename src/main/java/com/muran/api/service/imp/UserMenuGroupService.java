/**
 * 
 */
package com.muran.api.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.dao.IMenuGroupDao;
import com.muran.dao.IUserMenuGroupDao;
import com.muran.model.Admin;
import com.muran.model.MenuGroup;
import com.muran.model.UserMenuGroup;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IUserMenuGroupService;

/**
 * @author wxz
 * 
 */
public class UserMenuGroupService extends AbstractService implements
		IUserMenuGroupService {

	@Resource(name = "UserMenuGroupDao")
	private IUserMenuGroupDao dao;

	@Resource(name = "MenuGroupDao")
	private IMenuGroupDao menuGroupDao;

	@Override
	@BussAnnotation(bussName = "建立用户菜单组关系", login = true, role = "usermenugroup_assign")
	@Transactional(readOnly = false)
	public void buildUserMenuGroup(String username, String groups) {
		// TODO Auto-generated method stub
		// 删除原来的用户和菜单组的关系
		dao.deleteUserMenuGroupByUsername(username);

		// 新增关系
		if (groups != null && !groups.equals("")) {
			String[] array = groups.split(",");
			for (int i = 0; i < array.length; i++) {
				Long groupId = Long.valueOf(array[i]);
				UserMenuGroup userMenuGroup = new UserMenuGroup();
				userMenuGroup.setUsername(username);
				userMenuGroup.setGroupId(groupId);
				dao.save(userMenuGroup);
			}
		}

	}

	@Override
	@Transactional
	@BussAnnotation(bussName = "获取用户菜单组", login = true, role = "")
	public List<MenuGroup> getMenuGroupListByUsername(String username) {
		// TODO Auto-generated method stub
		return menuGroupDao.getMenuGroupsByUsername(username);
	}

	@Override
	@BussAnnotation(bussName = "建立用户菜单组关系", login = true, role = "menugroup_adduser")
	@Transactional(readOnly = false)
	public void buildUserMenuGroupByUser(String usernames, Long groupId) {
		// TODO Auto-generated method stub
		// 删除
		dao.deleteUserMenuGroupByGroup(groupId);
		
		if (usernames != null && !usernames.equals("")) {
			String[] array = usernames.split(",");
			for (int i = 0; i < array.length; i++) {
				UserMenuGroup userMenuGroup = new UserMenuGroup();
				userMenuGroup.setUsername(array[i]);
				userMenuGroup.setGroupId(groupId);
				dao.save(userMenuGroup);
			}
		}
	}

	@Override
	@Transactional(readOnly = false)
	public List<Admin> getAdminListByGroup(Long groupId) {
		// TODO Auto-generated method stub
		return dao.getAdminByGroup(groupId);
	}
}
