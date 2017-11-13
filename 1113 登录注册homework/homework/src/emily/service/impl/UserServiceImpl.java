package emily.service.impl;

import java.util.HashMap;
import java.util.Map;

import util.CommonUtil;
import emily.mapper.UserMapper;
import emily.mapper.impl.UserMapperImpl;
import emily.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper=new UserMapperImpl();
	public Map<String, Object> login(String username,String password) {		
		Map<String,Object> loginResult=userMapper.login(username,password);
		if(loginResult!=null){
			loginResult.put("success", "true");
			loginResult.put("phoneLast3", loginResult.get("phone").toString().substring(8));
			// 登录成功
		}else{
			// 登录失败
			loginResult=new HashMap<String, Object>();
			loginResult.put("success", "false");			
		}
		return loginResult;		
	}

	public Boolean register(String username, String password,String nickname,Integer userType,Integer sex,String phone) {
		String id =CommonUtil.newGuid();
		String date=CommonUtil.getDatetime();
		Integer loginResult=userMapper.register(username, password, nickname,
				userType, sex, phone,date,id);
		if(loginResult>0){
			return true;
		}else{
			return false;
		}		
	}

	public Boolean nameCheck(String username){
		Boolean nameCheckResult=userMapper.nameCheck(username);
		return !nameCheckResult;
	}
}
