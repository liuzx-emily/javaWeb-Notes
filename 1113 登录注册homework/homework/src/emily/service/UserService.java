/**
 * 
 */
package emily.service;

import java.util.Map;

/**
 * @author xinwei.fan
 *
 */
public interface UserService {
	public Map<String, Object> login(String username,String password);
	public Boolean register(String username, String password,String nickname,Integer userType,Integer sex,String phone);
	public Boolean nameCheck(String username);
}
