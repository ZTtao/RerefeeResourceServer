package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.User;
import zhentao.zhang.service.impl.RegisterServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Resource
	private RegisterServiceImpl registerService;
	
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request){
		String nickName = request.getParameter("nickName");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String note = request.getParameter("note");
		String gender = request.getParameter("gender");
		String registerTime = request.getParameter("registerTime");
		String isDelete = request.getParameter("isDelete");
		
		User user = new User();
		user.setNickName(nickName);
		if(realName != null)user.setRealName(realName);
		user.setPassword(password);
		user.setHeight(Float.valueOf(height));
		user.setWeight(Float.valueOf(weight));
		if(email != null)user.setEmail(email);
		if(phone != null)user.setPhone(phone);
		if(address != null)user.setAddress(address);
		if(note != null)user.setNote(note);
		user.setGender(gender);
		user.setRegisterTime(new Date(Long.parseLong(registerTime)));
		user.setIsDelete(Boolean.valueOf(isDelete));
		if(registerService.addUser(user))return "注册成功";
		else return "昵称已存在";
	}
	
	
}
