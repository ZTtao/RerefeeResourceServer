package zhentao.zhang.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.User;
import zhentao.zhang.service.impl.LoginServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private LoginServiceImpl loginService;
	
	@ResponseBody
	@RequestMapping("/loginAPI")
	public String loginAPI(HttpServletRequest request){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Map<String,Object> map = new HashMap<String,Object>();
		User user = loginService.checkAccountAndPassword(account, password);
		if(user != null){
			map.put("errorCode", 100);
			map.put("result", user);
		}else {
			map.put("errorCode", 101);
			map.put("result", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
		}
		return JSON.toJSONString(map);
	}
}
