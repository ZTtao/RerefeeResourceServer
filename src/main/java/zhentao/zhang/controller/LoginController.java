package zhentao.zhang.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		if(!loginService.checkAccountAndPassword(account, password).equals("error"))
		return loginService.checkAccountAndPassword(account, password);
		else
			return "’À∫≈ªÚ√‹¬Î¥ÌŒÛ";
	}
}
