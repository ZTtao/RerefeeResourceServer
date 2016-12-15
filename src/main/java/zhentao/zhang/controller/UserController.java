package zhentao.zhang.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.User;
import zhentao.zhang.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserServiceImpl userService;
	
	@ResponseBody
	@RequestMapping("/updateInfoAPI")
	public String updateInfoAPI(HttpServletRequest request,HttpServletResponse response){
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
		if(userService.updateUserInfo(user))return "success";
		return "faild";
	}
}
