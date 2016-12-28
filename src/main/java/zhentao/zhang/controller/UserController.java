package zhentao.zhang.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.User;
import zhentao.zhang.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping("/updateInfoAPI")
	public String updateInfoAPI(HttpServletRequest request){
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
	
	@RequestMapping("/searchFriend")
	@ResponseBody
	public String searchFriend(HttpServletRequest request){
		String condition = request.getParameter("condition");
		List<Map<String,String>> list = userService.getUserNameLikeCondition(condition);
		if(list.size() == 0)return "nodata";
		else {
			return JSON.toJSONString(list);
		}
	}
	
	@RequestMapping("/getFriendInfo")
	@ResponseBody
	public String getFriendInfo(HttpServletRequest request){
		String userId = request.getParameter("userId");
		String friendId = request.getParameter("friendId");
		Map<String,Object> map = userService.getUserInfoById(Integer.parseInt(userId),Integer.parseInt(friendId));
		return JSON.toJSONString(map);
	}
	
	@RequestMapping("/addFriend")
	@ResponseBody
	public String addFriend(HttpServletRequest request){
		String userId = request.getParameter("userId");
		String friendId = request.getParameter("friendId");
		if(userService.addFriend(Integer.parseInt(userId), Integer.parseInt(friendId))){
			return "success";
		}else return "faild";
	}
}
