package zhentao.zhang.imserver;



import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.openmob.mobileimsdk.server.event.ServerEventListener;

public class ServerEventListenerImpl implements ServerEventListener{
	
	private static Logger logger = LoggerFactory.getLogger(ServerEventListenerImpl.class);
	@Override
	public void onTransBuffer_C2C_CallBack(int userId, int from_user_id, String dataContent) {
		// TODO Auto-generated method stub
		logger.debug("�յ��˿ͻ���"+from_user_id+"�����ͻ���"+userId+"����Ϣ:str="+dataContent);
	}

	@Override
	public boolean onTransBuffer_C2C_RealTimeSendFaild_CallBack(int user_id, int from_user_id, String dataContent, String fingerPrint) {
		// TODO Auto-generated method stub
		logger.debug("�ͻ���"+from_user_id+"���͸��ͻ���"+user_id+"����Ϣ��str="+dataContent+"��ʵʱ����û�гɹ�����Ҫ�ϲ�Ӧ�������ߴ����������Ϣ��������");
		return false;
	}

	@Override
	public boolean onTransBuffer_CallBack(int userId, int from_user_id, String dataContent, String fingerPrint) {
		// TODO Auto-generated method stub
		logger.debug("�յ��ͻ���"+from_user_id+"��������˵���Ϣ��str="+dataContent);
		return true;
	}

	@Override
	public void onUserLoginAction_CallBack(int userId, String userName, IoSession session) {
		// TODO Auto-generated method stub
		logger.debug("userId:"+userId+" ���ڵ��ûص�������OnUserLoginAction_CallBack...");
		
	}

	@Override
	public void onUserLogoutAction_CallBack(int userId, Object obj) {
		// TODO Auto-generated method stub
		logger.debug("userId:"+userId+" ���ڵ��ûص�������OnUserLogouAction_CallBack...");
	}

	@Override
	public int onVerifyUserCallBack(String lpUserName, String lpPassword, String extra) {
		// TODO Auto-generated method stub
		logger.debug("���ڵ��ûص�������OnVerifyUserCallBack...(extra="+extra+",account:"+lpUserName+",password:"+lpPassword);
		return 0;
	}

}
