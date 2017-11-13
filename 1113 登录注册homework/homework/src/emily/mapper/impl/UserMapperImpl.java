package emily.mapper.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import emily.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {


	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	// 能使用中文，url后面加上：useunicode=true;characterEncoding=UTF-8
	private String url = "jdbc:sqlserver://127.0.0.1\\\\ESINTSQLSERVER:1107;DatabaseName=homework;useunicode=true;characterEncoding=UTF-8";
	private String user = "liuzx";
	private String password = "123456";
	
	public Map<String, Object> login(String username, String password) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 加载驱动
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql = "select * from person where username=? and password=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("success", "true");
				map.put("username", rs.getString("username"));
				map.put("sex", rs.getString("sex"));
				map.put("nickname", rs.getString("nickname"));
				map.put("registerDate", rs.getString("createTime"));
				map.put("userType", rs.getString("type"));
				map.put("phone", rs.getString("phone"));
				return map;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	public Integer register(String username,String password,String nickname,Integer userType,Integer sex,String phone,String date,String id){

		Connection conn = null;
		PreparedStatement ps = null;
		Integer rs=null;

		// 加载驱动
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql="INSERT INTO [homework].[dbo].[person]([id],[nickname],[username],[password],[type],[createTime],[sex],[phone])VALUES(?,?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, nickname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setInt(5, userType);
			ps.setString(6, date.substring(0,date.indexOf(" ")));
			ps.setInt(7, sex);
			ps.setString(8, phone);
			rs = ps.executeUpdate();

			return rs;			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return 0;
	}

	public Boolean nameCheck(String username){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 加载驱动
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			String sql = "select * from person where username=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
}
