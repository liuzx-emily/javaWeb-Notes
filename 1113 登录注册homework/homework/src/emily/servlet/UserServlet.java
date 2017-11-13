package emily.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emily.service.UserService;
import emily.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");
		String method = request.getParameter("method");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService userService = new UserServiceImpl();

		if (action.equals("login")) {
			// 登录
			Map<String, Object> loginResult = userService.login(username, password);
			if (method.equals("form")) {
				// 使用form表单
				if (loginResult.get("success").equals("false")) {
					// 失败
					response.sendRedirect("/homework/login.html?loginfail");
				} else {
					// 成功
					String info = "nickname="
							+ java.net.URLEncoder.encode((String) loginResult.get("nickname"),"utf-8")
							+ "&sex="
							+ java.net.URLEncoder.encode((String) loginResult.get("sex"), "utf-8")
							+ "&registerDate="
							+ java.net.URLEncoder.encode((String) loginResult.get("registerDate"),"utf-8")
							+ "&phone="
							+ java.net.URLEncoder.encode((String) loginResult.get("phone"), "utf-8")
							+ "&phoneLast3="
							+ java.net.URLEncoder.encode((String) loginResult.get("phone"), "utf-8").substring(8)
							+ "&userType="
							+ java.net.URLEncoder.encode((String) loginResult.get("userType"),"utf-8");
					response.sendRedirect("/homework/loginSuccess.html?" + info);
				}
			} else {
				// 使用ajax
				response.setContentType("application/json;charset=UTF-8");
				Map<String, Object> result = new HashMap<String, Object>();
				PrintWriter out = response.getWriter();
				if (loginResult.get("success").equals("false")) {
					// 失败
					result.put("success", "false");
				} else {
					// 成功
					result.put("success", "true");
					result.put("nickname", loginResult.get("nickname"));
					result.put("sex", loginResult.get("sex"));
					result.put("registerDate", loginResult.get("registerDate"));
					result.put("phone", loginResult.get("phone"));
					result.put("phoneLast3", loginResult.get("phoneLast3"));
					result.put("userType", loginResult.get("userType"));
				}
				out.print(result);
			}
		} else if (action.equals("register")) {
			// 注册

			String nickname = request.getParameter("nickname");
			Integer userType = Integer.parseInt(request.getParameter("userType"));
			Integer sex = Integer.parseInt(request.getParameter("sex"));
			String phone = request.getParameter("phone");

			Boolean registerResult = userService.register(username, password, nickname, userType,
					sex, phone);

			if (method.equals("form")) {
				// 使用form表单注册
				if (registerResult) {
					// 成功
					response.sendRedirect("/homework/login.html?registersucess");
				} else {
					// 失败
					response.sendRedirect("/homework/register.html?registerfail");
				}
			} else {
				// 使用ajax注册
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter out = response.getWriter();
				Boolean result;
				if (registerResult) {
					// 成功
					result = true;
				} else {
					// 失败
					result = false;
				}
				out.print(result);

			}

		} else if (action.equals("nameCheck")) {
			// 验证用户名是否已经被占用
			Boolean nameCheckResult = userService.nameCheck(username);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Boolean result;
			if (nameCheckResult) {
				// 用户名未使用，可以注册
				result = true;
			} else {
				// 用户名已经被占用
				result = false;
			}
			out.print(result);
		} else if (action.equals("infoChange")) {
			// 修改用户信息
			Boolean infoChangeResult = userService.nameCheck(username);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Boolean result;
			if (infoChangeResult) {
				// 用户名未使用，可以注册
				result = true;
			} else {
				// 用户名已经被占用
				result = false;
			}
			out.print(result);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
