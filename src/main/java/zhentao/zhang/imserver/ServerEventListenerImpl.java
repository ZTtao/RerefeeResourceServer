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
		logger.debug("收到了客户端"+from_user_id+"发给客户端"+userId+"的消息:str="+dataContent);
	}

	@Override
	public boolean onTransBuffer_C2C_RealTimeSendFaild_CallBack(int user_id, int from_user_id, String dataContent, String fingerPrint) {
		// TODO Auto-generated method stub
		logger.debug("客户端"+from_user_id+"发送给客户端"+user_id+"的消息：str="+dataContent+"因实时发送没有成功，需要上层应用作离线处理，否则次消息将被丢弃");
		return false;
	}

	@Override
	public boolean onTransBuffer_CallBack(int userId, int from_user_id, String dataContent, String fingerPrint) {
		// TODO Auto-generated method stub
		logger.debug("收到客户端"+from_user_id+"发给服务端的消息：str="+dataContent);
		return true;
	}

	@Override
	public void onUserLoginAction_CallBack(int userId, String userName, IoSession session) {
		// TODO Auto-generated method stub
		logger.debug("userId:"+userId+" 正在调用回调方法：OnUserLoginAction_CallBack...");
		
	}

	@Override
	public void onUserLogoutAction_CallBack(int userId, Object obj) {
		// TODO Auto-generated method stub
		logger.debug("userId:"+userId+" 正在调用回调方法：OnUserLogouAction_CallBack...");
	}

	@Override
	public int onVerifyUserCallBack(String lpUserName, String lpPassword, String extra) {
		// TODO Auto-generated method stub
		logger.debug("正在调用回调方法：OnVerifyUserCallBack...(extra="+extra+",account:"+lpUserName+",password:"+lpPassword);
		return 0;
	}

}
