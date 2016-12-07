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
			logger.debug("��DEBUG_QoS_S2C�¼����յ��Է����յ���Ϣ�¼���֪ͨ��fp="+theFingerPrint);
		}
	}

	@Override
	public void messagesLost(ArrayList<Protocal> lostMessages) {
		// TODO Auto-generated method stub
		logger.debug("��DEBUG_QoS_S2C�¼����յ�ϵͳ��δʵʱ�ʹ��¼�֪ͨ����ǰ����"+lostMessages.size()+"����QoS��֤���ƽ������ж�Ϊ���޷�ʵʱ�ʹ��");
	}

}
