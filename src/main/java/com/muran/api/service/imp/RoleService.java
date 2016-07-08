package com.muran.api.service.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.exception.Code;
import com.muran.api.exception.GeneralResponseCode;
import com.muran.api.exception.ServerException;
import com.muran.dao.IRoleDao;
import com.muran.model.Role;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IRoleService;
import com.muran.util.Data;


/**
 * 
 * @author mark
 * 
 */
public class RoleService extends AbstractService implements IRoleService {

	@Resource(name = "RoleDao")
	private IRoleDao dao;

	@Override
	@BussAnnotation(bussName = "新增角色", login = true, role = "")
	@Transactional(readOnly = false)
	public Role createRole(String roleName, String descpt, String key,
			long parentId, String category, boolean enable) {
		// TODO Auto-generated method stub
		Role role = new Role();
		// 验重复
		if (dao.checkRepeat(null, key, roleName)) {
			throw new ServerException(Code.RoleHasExisted);
		}
		role.setKeyCode(key);
		role.setDescpt(descpt);
		role.setRoleName(roleName);
		role.setParentId(parentId);
		role.setCategory(category);
		role.setEnable(enable);
		role = dao.merge(role);
		return role;
	}

	@BussAnnotation(bussName = "修改角色", login = true, role = "")
	@Transactional(readOnly = false)
	public Role modifyRole(Long id, String roleName, String descpt, String key,
			long parentId, String category, boolean enable) {
		// TODO Auto-generated method stub

		if (dao.checkRepeat(id, key, roleName)) {
			throw new ServerException(Code.RoleHasExisted);
		}
		Role role = new Role();
		role = dao.findOne(id);
		if (role == null) {
			throw new ServerException(Code.RoleNotFound);
		}

		List<Role> chiList = dao.getChildList(role.getAutoId());
		if (chiList != null && chiList.size() > 0) {
			if (category.equals("node")) {
				throw new ServerException(Code.RoleNodeNotAllowModify,
						"存在节点，不允许变更分类");
			}
		}
		role.setKeyCode(key);
		role.setDescpt(descpt);
		role.setRoleName(roleName);
		role.setParentId(parentId);
		role.setEnable(enable);
		role.setCategory(category);
		role = dao.update(role);
		return role;
	}

	@Override
	@BussAnnotation(bussName = "根据id查询角色", login = true, role = "")
	public Role findOneById(Long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	@Override
	@BussAnnotation(bussName = "根据id删除角色信息", login = true, role = "")
	public void deleteRole(Long id) {
		// TODO Auto-generated method stub
		List<Role> chiList = dao.getChildList(id);
		if (chiList != null && chiList.size() > 0) {
			throw new ServerException(Code.RoleNodeNotAllowModify, "存在节点，不允许删除");
		}
		dao.deleteById(id);

	}

	@Override
	@BussAnnotation(bussName = "查询角色信息不分页", login = true, role = "")
	public List<Role> getList(String name, String descpt, String roleKey,
			String category) {
		// TODO Auto-generated method stub
		return dao.getList(name, descpt, roleKey, category);
	}

	@Override
	@BussAnnotation(bussName = "查询角色信息分页", login = true, role = "")
	public Data<Role> getPageList(Integer pageSize, Integer pageIndex,
			String name, String descpt, String roleKey, String category) {
		// TODO Auto-generated method stub
		return dao.getPageList(pageSize, pageIndex, name, descpt, roleKey,
				category);
	}

	// 递归完毕释放
	private static List<Role> childList = new ArrayList<Role>();

	@Override
	public List<Role> getRoleTree() {
		// TODO Auto-generated method stub
		List<Role> list = dao.getChildList(0);
		if (list != null && list.size() > 0) {
			for (Role role : list) {
				if (role != null) {
					role = getListRecursion(role);
					if (childList != null)
						childList.clear();
				}
			}
		}
		return list;
	}

	private Role getListRecursion(Role role) {
		Role rRole = new Role();
		rRole = role;
		childList = dao.getChildList(role.getAutoId());
		rRole.setChildRoles(childList);
		if (childList != null && childList.size() > 0) {
			for (Role role2 : childList) {
				getListRecursion(role2);
			}
		}
		return rRole;
	}

	@Override
	public void isRoleOk(String userSys, String username, String roleKey) {
		// TODO Auto-generated method stub
		boolean isok = dao.isRoleOk(username, roleKey);
		if (!isok) {
			throw new ServerException(GeneralResponseCode.PersmissionForbid,
					"无权访问");
		}
	}

	@Override
	public void createAllRoleKey() {
//		// 检测数据库是否有数据
//		// List<Role> list = dao.getList(null, null, null, null);
//		// if (list != null && list.size() > 0) {
//		// throw new BaseException(Code.RoleHasInit, "权限已经初始化");
//		// }
//
//		// 1.获取class路径
//		String classesPath = this.getClass().getResource("/").getPath();
//		// 2.找到servic.imp的路径并取得service.imp包名称
//		String servicePath = findDir(classesPath, "service");
//		String impPath = findDir(servicePath, "imp");
//		String packageName = impPath.replace(classesPath, "").replace("/", ".");
//		// 3.判断系统
//		String sysName = "";
//		String sysKey = "";
//		if (packageName.contains(".sys.")) {
//			sysName = "幕然系统管理后台";
//			sysKey = "sys";
//		} else if (packageName.contains(".property.")) {
//			sysName = "物业系统管理后台";
//			sysKey = "property";
//		} else if (packageName.contains(".ad.")) {
//			sysName = "广告系统管理后台";
//			sysKey = "ad";
//		} else if (packageName.contains(".shopcenter.")) {
//			sysName = "商户系统管理后台";
//			sysKey = "shopcenter";
//		} else {
//			return;
//		}
//		// 新增root级别的权限
//		Role roleRoot = new Role();
//		roleRoot = dao.getRoleByKey(sysKey);
//		if (roleRoot == null) {
//			roleRoot = new Role();
//			roleRoot.setCategory("fold");
//			roleRoot.setDescpt(sysName);
//			roleRoot.setEnable(true);
//			roleRoot.setKeyCode(sysKey);
//			roleRoot.setParentId(0);
//			roleRoot.setRoleName(sysName);
//			roleRoot = dao.merge(roleRoot);
//		}
//
//		try {
//			// 获取imp文件夹下的文件
//			File dir = new File(impPath);
//			File[] fm2 = dir.listFiles();
//			for (File file : fm2) {
//				// 获取文件名称
//				String fileName = file.getName().replace(".class", "");
//				// 过滤掉临时文件
//				if (fileName.contains("$")) {
//					continue;
//				}
//				// 获取文件包路径
//				String className = packageName + "." + fileName;
//				String resource = sysKey + "_"
//						+ fileName.replace("Service", "").toLowerCase().trim();
//				// 转换为类对象
//				Class tmpClass = Class.forName(className);
//				// 获取类上的注解
//				String moduleName = "";
//
//				Annotation[] classAnnotation = tmpClass.getAnnotations();
//				for (Annotation cAnnotation : classAnnotation) {
//					Class annotationType = cAnnotation.annotationType();
//					if (annotationType.equals(SystemAnnotation.class)) {
//						String annotationStr = cAnnotation.toString();
//						// 获取注解参数字符串
//						String paramStr = annotationStr.replace("@", "")
//								.replace(annotationType.getName(), "")
//								.replace("(", "").replace(")", "");
//						// 拆分注解参数
//						String[] arrayParam = paramStr.split(",");
//						// 取得role和bussName
//						// sysName = arrayParam[0].replace("role=", "");
//						moduleName = arrayParam[0].replace("moduleName=", "")
//								.trim();
//						break;
//					}
//				}
//				if (moduleName.equals("")) {
//					continue;
//				}
//				//
//				Role roleParent = new Role();
//				roleParent = dao.getRoleByKey(resource);
//				if (roleParent == null) {
//					roleParent = new Role();
//					roleParent.setCategory("fold");
//					roleParent.setDescpt(moduleName);
//					roleParent.setEnable(true);
//					roleParent.setKeyCode(resource);
//					roleParent.setParentId(roleRoot.getAutoId());
//					roleParent.setRoleName(moduleName);
//					roleParent = dao.merge(roleParent);
//				}
//
//				// 获取类对象的所有方法
//				Method[] methods = tmpClass.getDeclaredMethods();
//
//				for (Method method : methods) {
//					String m = method.getName();
//					// 获取方法的所有注解
//					Annotation[] methodAnnotations = method.getAnnotations();
//					for (Annotation me : methodAnnotations) {
//						Class annotationType = me.annotationType();
//						// 如果注解是BussAnnotation
//						if (annotationType.equals(BussAnnotation.class)) {
//							// 注解全字符串
//							String annotationStr = me.toString();
//							// 获取注解参数字符串
//							String paramStr = annotationStr.replace("@", "")
//									.replace(annotationType.getName(), "")
//									.replace("(", "").replace(")", "");
//							// 拆分注解参数
//							String[] arrayParam = paramStr.split(",");
//							String role = "";
//							String bussName = "";
//							for (int i = 0; i < arrayParam.length; i++) {
//								if (arrayParam[i].contains("role=")) {
//									role = arrayParam[i].replace("role=", "")
//											.trim();
//								}
//								if (arrayParam[i].contains("bussName=")) {
//									bussName = arrayParam[arrayParam.length - 1]
//											.replace("bussName=", "").trim();
//								}
//							}
//							// 取得role和bussName
//
//							if (role == null || role.equals("")) {
//								break;
//							}
//							// 查询是否存在
//							Role roleNode = new Role();
//							roleNode = dao.getRoleByKey(role);
//							if (roleNode == null) {
//								roleNode = new Role();
//								roleNode.setCategory("node");
//								roleNode.setDescpt(bussName);
//								roleNode.setEnable(true);
//								roleNode.setKeyCode(role);
//								roleNode.setParentId(roleParent.getAutoId());
//								roleNode.setRoleName(bussName);
//								dao.create(roleNode);
//							} else {
//								roleNode.setCategory("node");
//								roleNode.setDescpt(bussName);
//								roleNode.setEnable(true);
//								roleNode.setKeyCode(role);
//								roleNode.setParentId(roleParent.getAutoId());
//								roleNode.setRoleName(bussName);
//								dao.update(roleNode);
//							}
//
//							break;
//						}
//					}
//
//				}
//
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("生成role发生错误:" + e.getMessage() + ","
//					+ e.getCause());
//			throw new BaseException(Code.RoleInitError, "权限初始化失败");
//		}

	}

	// 获取指定文件夹的历经
	public String findDir(String path, String objName) {
		File dir = new File(path);
		File[] fm = dir.listFiles();
		String tmpPath = "";
		for (File file : fm) {
			if (file.isDirectory()) {
				if (file.getName().equals(objName)) {
					tmpPath = file.getPath();
				} else {
					// System.out.println(path + file.getName() + "/");
					tmpPath = findDir(path + file.getName() + "/", objName);
				}
			}
			if (!tmpPath.equals("")) {
				break;
			}
		}
		return tmpPath;
	}
}
