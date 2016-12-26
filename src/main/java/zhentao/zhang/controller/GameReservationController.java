package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.GameReservation;
import zhentao.zhang.service.IGameReservationService;

@Controller
@RequestMapping("/gameReservation")
public class GameReservationController {
	@Resource
	private IGameReservationService reservationService;
	
	@RequestMapping("/getReservation")
	@ResponseBody
	public String getReservation(HttpServletRequest request){
		return reservationService.getAllReservation();
	}
	
	@RequestMapping("/addReservation")
	@ResponseBody
	public String addReservation(HttpServletRequest request){
		String playerId = request.getParameter("playerId");
		String gameTime = request.getParameter("gameTime");
		String address = request.getParameter("address");
		String team = request.getParameter("team");
		String level = request.getParameter("level");
		String createTime = request.getParameter("createTime");
		GameReservation reservation = new GameReservation();
		reservation.setPlayerId(Integer.parseInt(playerId));
		reservation.setGameTime(new Date(Long.parseLong(gameTime)));
		reservation.setAddress(address);
		reservation.setTeam(team);
		reservation.setLevel(level);
		reservation.setCreateTime(new Date(Long.parseLong(createTime)));
		if(reservationService.addReservation(reservation)){
			return "success";
		}else
			return "faild";
	}
	
	@RequestMapping("/hasReply")
	@ResponseBody
	public String hasReply(HttpServletRequest request){
		String playerId = request.getParameter("playerId");
		String reservationId = request.getParameter("reservationId");
		if(reservationService.hasReply(Integer.parseInt(playerId), Integer.parseInt(reservationId))){
			return "true";
		}else return "false";
	}
	
	@RequestMapping("/updateReply")
	@ResponseBody
	public String updateReply(HttpServletRequest request){
		String playerId = request.getParameter("playerId");
		String reservationId = request.getParameter("reservationId");
		String isDelete = request.getParameter("isDelete");
		if(reservationService.updateReply(Integer.parseInt(playerId), Integer.parseInt(reservationId), Boolean.parseBoolean(isDelete))){
			return "success";
		}else return "faild";
	}
}
