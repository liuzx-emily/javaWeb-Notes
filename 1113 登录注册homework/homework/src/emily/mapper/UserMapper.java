package emily.mapper;

import java.util.Map;

public interface UserMapper {

	public Map<String, Object> login(String username,String password);
	public Integer register(String username,String password,String nickname,Integer userType,Integer sex,String phone,String date,String id);
	public Boolean nameCheck(String username);
}
