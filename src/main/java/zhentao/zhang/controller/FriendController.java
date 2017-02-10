package zhentao.zhang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.service.IFriendService;

@RequestMapping("/friend")
@Controller
public class FriendController {
	
	@Resource
	private IFriendService friendService;

	@RequestMapping("/findFriend")
	@ResponseBody
	public String findFriend(String whereClause){
		return JSON.toJSONString(friendService.findFriend(whereClause));
	}
}
