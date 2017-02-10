package zhentao.zhang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.FindRefereeMessage;
import zhentao.zhang.service.IFindRefereeService;

@RequestMapping("/findReferee")
@Controller
public class FindRefereeController {
	
	@Resource
	private IFindRefereeService findRefereeService;
	
	@RequestMapping("/saveFindMessage")
	@ResponseBody
	public String saveFindMessage(FindRefereeMessage message){
		return JSON.toJSONString(findRefereeService.saveFindRefereeMessage(message));
	}
	
	@RequestMapping("/findMessage")
	@ResponseBody
	public String findMessage(String whereClause,String orderByClause,String limitClause){
		return JSON.toJSONString(findRefereeService.findMessageByCondition(whereClause,orderByClause,limitClause));
	}
	
	@RequestMapping("/addReadCount")
	@ResponseBody
	public String addReadCount(Integer messageId){
		return JSON.toJSONString(findRefereeService.addReadCount(messageId));
	}
	
	@RequestMapping("/addApplyCount")
	@ResponseBody
	public String addApplyCount(Integer messageId){
		return JSON.toJSONString(findRefereeService.addApplyCount(messageId));
	}
}
