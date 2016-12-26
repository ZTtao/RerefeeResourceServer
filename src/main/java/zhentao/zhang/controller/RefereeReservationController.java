package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.RefereeReservation;
import zhentao.zhang.service.IRefereeReservationService;

@Controller
@RequestMapping("/refereeReservation")
public class RefereeReservationController {
	
	@Resource
	private IRefereeReservationService reservationService;
	
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
		String gameState = request.getParameter("gameState");
		String count = request.getParameter("refereeCount");
		String require = request.getParameter("refereeRequire");
		String reward = request.getParameter("reward");
		String createTime = request.getParameter("createTime");
		RefereeReservation reservation = new RefereeReservation();
		reservation.setPlayerId(Integer.parseInt(playerId));
		reservation.setGameTime(new Date(Long.parseLong(gameTime)));
		reservation.setAddress(address);
		reservation.setGameState(gameState);
		reservation.setRefereeCount(count);
		reservation.setRefereeRequire(require);
		reservation.setReward(reward);
		reservation.setCreateTime(new Date(Long.parseLong(createTime)));
		if(reservationService.addReservation(reservation)){
			return "success";
		}else
			return "faild";
	}
	
	@RequestMapping("/hasReply")
	@ResponseBody
	public String hasReply(HttpServletRequest request){
		String refereeId = request.getParameter("refereeId");
		String reservationId = request.getParameter("reservationId");
		if(reservationService.hasReply(Integer.parseInt(refereeId), Integer.parseInt(reservationId))){
			return "true";
		}else return "false";
	}
	
	@RequestMapping("/updateReply")
	@ResponseBody
	public String updateReply(HttpServletRequest request){
		String refereeId = request.getParameter("refereeId");
		String reservationId = request.getParameter("reservationId");
		String isDelete = request.getParameter("isDelete");
		if(reservationService.updateReply(Integer.parseInt(refereeId), Integer.parseInt(reservationId), Boolean.parseBoolean(isDelete))){
			return "success";
		}else return "faild";
	}
}
