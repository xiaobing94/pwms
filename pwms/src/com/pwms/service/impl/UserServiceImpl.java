package com.pwms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.pwms.dao.UserMapper;
import com.pwms.dao.UserinfoMapper;
import com.pwms.dao.VerifyUserinfoMapper;
import com.pwms.pojo.User;
import com.pwms.pojo.Userinfo;
import com.pwms.pojo.VerifyUserinfo;
import com.pwms.service.IUserService;
import com.pwms.tools.Md5Util;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userDao;
    @Resource
    private VerifyUserinfoMapper verifyuserinfoDao;
    private UserinfoMapper userinfoDao;
	public UserinfoMapper getUserinfoDao() {
		return userinfoDao;
	}
	public void setUserinfoDao(UserinfoMapper userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	public UserMapper getUserDao() {
		return userDao;
	}
	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}
	public VerifyUserinfoMapper getVerifyuserinfoDao() {
		return verifyuserinfoDao;
	}
	public void setVerifyuserinfoDao(VerifyUserinfoMapper verifyuserinfoDao) {
		this.verifyuserinfoDao = verifyuserinfoDao;
	}
	@Override
    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }
	@Override
	public boolean chkinfo(String identity, String name, String studentid) {
		// TODO Auto-generated method stub
		List<VerifyUserinfo> verifyUserinfoList = verifyuserinfoDao.selectByVerifyuserinfo(identity, name, studentid);
		System.out.println("verify:"+verifyUserinfoList.get(0).getName());
		if(verifyUserinfoList==null||verifyUserinfoList.size()==0)
		{
			return false;
		}
		return true;
	}
	//检查用户用户名和密码是否对应
	@Override
	public boolean chkpasswd(String loginfo, String password) {
		// TODO Auto-generated method stub
		User user=userDao.selectByNameOrFid(loginfo,password);
		if(user!=null)
		{
			return true;
		}
		return false;
	}
	//登陆
	@Override
	public boolean login(HttpSession session, String loginfo, String password) {
		// TODO Auto-generated method stub
		String passwdMd5=Md5Util.Convert2Md5(password);
		User user=userDao.selectByNameOrFid(loginfo,passwdMd5);
		if(user!=null)
		{
			session.setAttribute("user", user);
			return true;
		}
		return false;
	}
	//注销
	public void logout(HttpSession session)
	{
		session.removeAttribute("user");
	}
    //注册用户，在数据库中user表中保存
	@Override
	public boolean register(User user, String identity) {
		// TODO 
		User userDb=userDao.selectByLoginfo(user.getStuOrJobid());
		if(userDb!=null)
		{
			return false;
		}
		String passwordMd5=Md5Util.Convert2Md5(user.getPassword());
		user.setPassword(passwordMd5);
		userDao.insertSelective(user);
		return true;
	}
    //用户信息补全
//	@Override
//	public void completeUserinfo(Userinfo userinfo)
//	{
//		userinfoDao.insertSelective(userinfo);
//	}
}
