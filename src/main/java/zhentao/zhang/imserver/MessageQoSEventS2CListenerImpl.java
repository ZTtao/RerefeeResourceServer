package zhentao.zhang.imserver;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.openmob.mobileimsdk.server.event.MessageQoSEventListenerS2C;
import net.openmob.mobileimsdk.server.protocal.Protocal;

public class MessageQoSEventS2CListenerImpl implements MessageQoSEventListenerS2C{

	private static Logger logger = LoggerFactory.getLogger(MessageQoSEventS2CListenerImpl.class);
	
	@Override
	public void messagesBeReceived(String theFingerPrint) {
		// TODO Auto-generated method stub
		if(theFingerPrint != null){
			logger.debug("【DEBUG_QoS_S2C事件】收到对方已收到消息事件的通知，fp="+theFingerPrint);
		}
	}

	@Override
	public void messagesLost(ArrayList<Protocal> lostMessages) {
		// TODO Auto-generated method stub
		logger.debug("【DEBUG_QoS_S2C事件】收到系统的未实时送达事件通知，当前共有"+lostMessages.size()+"个包QoS保证机制结束，判定为【无法实时送达】！");
	}

}
