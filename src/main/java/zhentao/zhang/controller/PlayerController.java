package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.Player;
import zhentao.zhang.service.IPlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	@Resource
	private IPlayerService playerService;
	
	@RequestMapping("/getPlayerAPI")
	@ResponseBody
	public String getPlayerAPI(HttpServletRequest request,HttpServletResponse response){
		String nickName = request.getParameter("nickName");
		String result = playerService.getPlayerByNickName(nickName);
		return result;
	}
	
	@RequestMapping("/updatePlayerAPI")
	@ResponseBody
	public String updatePlayerAPI(HttpServletRequest request,HttpServletResponse response){
		int userId = Integer.parseInt(request.getParameter("userId"));
		Long startPlayTime = Long.parseLong(request.getParameter("startPlayTime"));
		String experience = request.getParameter("experience");
		String honor = request.getParameter("honor");
		String team = request.getParameter("team");
		String note = request.getParameter("note");
		String other = request.getParameter("other");
		Long registerTime = Long.parseLong(request.getParameter("registerTime"));
		Player player = new Player();
		player.setUserId(userId);
		player.setStartPlayTime(new Date(startPlayTime));
		player.setExperience(experience==null?"":experience);
		player.setHonor(honor==null?"":honor);
		player.setTeam(team==null?"":team);
		player.setRegisterTime(new Date(registerTime));
		player.setNote(note==null?"":note);
		player.setIsDelete(false);
		player.setOther(other==null?"":other);
		if(playerService.addOrUpdatePlayer(player))return "success";
		return "faild";
	}
}
