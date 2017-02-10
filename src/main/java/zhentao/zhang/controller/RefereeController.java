package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.Referee;
import zhentao.zhang.service.IRefereeService;
import zhentao.zhang.service.impl.RefereeServiceImpl;

@Controller
@RequestMapping("/referee")
public class RefereeController {
	
	@Resource
	private IRefereeService refereeService;
	
	@RequestMapping("/addRefereeAPI")
	@ResponseBody
	public String addPlayerAPI(String userId,Referee referee){
		return refereeService.addReferee(Integer.parseInt(userId), referee);
	}
	
	@RequestMapping("/getRefereeAPI")
	@ResponseBody
	public String getRefereeAPI(HttpServletRequest request,HttpServletResponse response){
		String nickName = request.getParameter("nickName");
		String result = refereeService.getRefereeByNickName(nickName);
		return result;
	}
	
	@RequestMapping("/updateRefereeAPI")
	@ResponseBody
	public String updateRefereeAPI(Referee referee){
//		int userId = Integer.parseInt(request.getParameter("userId"));
//		Long startJudgeTime = Long.parseLong(request.getParameter("startJudgeTime"));
//		String experience = request.getParameter("experience");
//		String honor = request.getParameter("honor");
//		String certificate = request.getParameter("certificate");
//		String note = request.getParameter("note");
//		String other = request.getParameter("other");
//		Long registerTime = Long.parseLong(request.getParameter("registerTime"));
//		Referee referee = new Referee();
//		referee.setUserId(userId);
//		referee.setStartJudgeTime(new Date(startJudgeTime));
//		referee.setExperience(experience==null?"":experience);
//		referee.setHonor(honor==null?"":honor);
//		referee.setCertificate(certificate==null?"":certificate);
//		referee.setRegisterTime(new Date(registerTime));
//		referee.setNote(note==null?"":note);
//		referee.setIsDelete(false);
//		referee.setOther(other==null?"":other);
//		if(refereeService.addOrUpdateReferee(referee))return "success";
//		return "faild";
		if(refereeService.updateReferee(referee))return "success";
		return "faild";
	}
	
	@RequestMapping("/deleteRefereeAPI")
	@ResponseBody
	public String deleteRefereeAPI(int refereeId){
		if(refereeService.deleteReferee(refereeId))
			return "success";
		return "faild";
	}
}
