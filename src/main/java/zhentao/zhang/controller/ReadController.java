package zhentao.zhang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.Read;
import zhentao.zhang.service.IReadService;

@RequestMapping("/read")
@Controller
public class ReadController {
	@Resource
	private IReadService readService;
	
	@RequestMapping("/saveRead")
	@ResponseBody
	public String saveRead(Read read){
		return JSON.toJSONString(readService.saveRead(read));
	}
	
	@RequestMapping("/countRead")
	@ResponseBody
	public String countRead(Integer postId){
		return JSON.toJSONString(readService.countRead(postId));
	}
}
