package zhentao.zhang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.RefereeReplyMapper;
import zhentao.zhang.dao.RefereeReservationMapper;
import zhentao.zhang.pojo.RefereeReply;
import zhentao.zhang.pojo.RefereeReplyExample;
import zhentao.zhang.pojo.RefereeReservation;
import zhentao.zhang.pojo.RefereeReservationExample;
import zhentao.zhang.service.IPlayerService;
import zhentao.zhang.service.IRefereeReservationService;
import zhentao.zhang.service.IUserService;
@Service
public class RefereeReservationImpl implements IRefereeReservationService {

	@Resource
	private RefereeReservationMapper reservationMapper;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IPlayerService playerService;
	
	@Resource
	private RefereeReplyMapper replyMapper;
	
	@Override
	public String getAllReservation() {
		RefereeReservationExample example = new RefereeReservationExample();
		example.or().andIsDeleteEqualTo(false);
		example.setOrderByClause("create_time desc");
		List<RefereeReservation> list = reservationMapper.selectByExample(example);
		if(list != null && list.size()>0){
			int index=0;
			List<Integer> idList = new ArrayList<Integer>();
			while(index < list.size()){
				idList.add(list.get(index).getPlayerId());
				index++;
			}
			Map<Integer,Integer> m = playerService.getUserIdByPlayerId(idList);
			List<Integer> userIdList = new ArrayList<Integer>();
			for(Map.Entry<Integer, Integer> entry : m.entrySet()){
				userIdList.add(entry.getValue());
			}
			Map<Integer,String> map = userService.getUserNameById(userIdList);
			
			int i=0;
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			while(i<list.size()){
				builder.append(",");
				builder.append("{");
				builder.append("'refResId':");
				builder.append(list.get(i).getRefResId());
				builder.append(",'playerId':");
				builder.append(list.get(i).getPlayerId());
				builder.append(",'gameTime':");
				builder.append(list.get(i).getGameTime().getTime());
				builder.append(",'address':'");
				builder.append(list.get(i).getAddress());
				builder.append("','gameState':'");
				builder.append(list.get(i).getGameState());
				builder.append("','refereeCount':'");
				builder.append(list.get(i).getRefereeCount());
				builder.append("','refereeRequire':'");
				builder.append(list.get(i).getRefereeRequire());
				builder.append("','reward':'");
				builder.append(list.get(i).getReward());
				builder.append("','note':'");
				builder.append(list.get(i).getNote());
				builder.append("','isReceive':");
				builder.append(list.get(i).getIsReceive());
				builder.append(",'isDelete':");
				builder.append(list.get(i).getIsDelete());
				builder.append(",'createTime':");
				builder.append(list.get(i).getCreateTime().getTime());
				builder.append(",'playerName':'");
				builder.append(map.get(m.get(list.get(i).getPlayerId())));
				builder.append("'}");
				i++;
			}
			builder.deleteCharAt(1);
			builder.append("]");
			return builder.toString();
		}
		return "nodata";
	}

	@Override
	public boolean addReservation(RefereeReservation res) {
		res.setIsReceive(false);
		res.setIsDelete(false);
		int count = reservationMapper.insertSelective(res);
		if(count > 0)
			return true;
		else return false;
	}

	@Override
	public boolean hasReply(int refereeId, int reservationId) {
		RefereeReplyExample example = new RefereeReplyExample();
		example.or().andRefereeIdEqualTo(refereeId).andRefResIdEqualTo(reservationId).andIsDeleteEqualTo(false);
		List<RefereeReply> list = replyMapper.selectByExample(example);
		if(list!=null && list.size() > 0)return true;
		else return false;
	}

	@Override
	public boolean updateReply(int refereeId, int reservationId, boolean isDelete) {
		RefereeReplyExample example = new RefereeReplyExample();
			example.or().andRefereeIdEqualTo(refereeId).andRefResIdEqualTo(reservationId);
			List<RefereeReply> list = replyMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				list.get(0).setIsDelete(isDelete);
				int count = replyMapper.updateByPrimaryKey(list.get(0));
				if(count > 0)return true;
				else return false;
			}else{
				RefereeReply reply = new RefereeReply();
				reply.setRefereeId(refereeId);
				reply.setCreateTime(new Date());
				reply.setIsDelete(false);
				reply.setRefResId(reservationId);
				reply.setIsDelete(isDelete);
				int count = replyMapper.insertSelective(reply);
				if(count > 0)return true;
				else return false;
			}
	}

}
