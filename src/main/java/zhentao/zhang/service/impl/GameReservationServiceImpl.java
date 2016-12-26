package zhentao.zhang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.GameReplyMapper;
import zhentao.zhang.dao.GameReservationMapper;
import zhentao.zhang.pojo.GameReply;
import zhentao.zhang.pojo.GameReplyExample;
import zhentao.zhang.pojo.GameReservation;
import zhentao.zhang.pojo.GameReservationExample;
import zhentao.zhang.service.IGameReservationService;
import zhentao.zhang.service.IPlayerService;
import zhentao.zhang.service.IUserService;

@Service
public class GameReservationServiceImpl implements IGameReservationService {

	@Resource
	private GameReservationMapper reservationMapper;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IPlayerService playerService;
	
	@Resource
	private GameReplyMapper replyMapper;
	
	@Override
	public String getAllReservation() {
		GameReservationExample example = new GameReservationExample();
		example.or().andIsDeleteEqualTo(false);
		example.setOrderByClause("create_time desc");
		List<GameReservation> list = reservationMapper.selectByExample(example);
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
				builder.append("'gameResId':");
				builder.append(list.get(i).getGameResId());
				builder.append(",'playerId':");
				builder.append(list.get(i).getPlayerId());
				builder.append(",'gameTime':");
				builder.append(list.get(i).getGameTime().getTime());
				builder.append(",'address':'");
				builder.append(list.get(i).getAddress());
				builder.append("','team':'");
				builder.append(list.get(i).getTeam());
				builder.append("','level':'");
				builder.append(list.get(i).getLevel());
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
	public boolean addReservation(GameReservation res) {
		res.setIsReceive(false);
		res.setIsDelete(false);
		int count = reservationMapper.insertSelective(res);
		if(count > 0)
			return true;
		else return false;
	}

	@Override
	public boolean hasReply(int refereeId, int reservationId) {
		GameReplyExample example = new GameReplyExample();
		example.or().andPlayerIdEqualTo(refereeId).andGameResIdEqualTo(reservationId).andIsDeleteEqualTo(false);
		List<GameReply> list = replyMapper.selectByExample(example);
		if(list!=null && list.size() > 0)return true;
		else return false;
	}

	@Override
	public boolean updateReply(int playerId, int reservationId, boolean isDelete) {
		GameReplyExample example = new GameReplyExample();
		example.or().andPlayerIdEqualTo(playerId).andGameResIdEqualTo(reservationId);
		List<GameReply> list = replyMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			list.get(0).setIsDelete(isDelete);
			int count = replyMapper.updateByPrimaryKey(list.get(0));
			if(count > 0)return true;
			else return false;
		}else{
			GameReply reply = new GameReply();
			reply.setPlayerId(playerId);
			reply.setCreateTime(new Date());
			reply.setIsDelete(false);
			reply.setGameResId(reservationId);
			reply.setIsDelete(isDelete);
			int count = replyMapper.insertSelective(reply);
			if(count > 0)return true;
			else return false;
		}
	}

}
