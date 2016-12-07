package zhentao.zhang.imserver;

import java.io.IOException;

import net.openmob.mobileimsdk.server.ServerLauncher;
import net.openmob.mobileimsdk.server.qos.QoS4SendDaemonS2C;

public class ServerLauncherImpl extends ServerLauncher{

	private static ServerLauncherImpl instance = null;
	
	public static ServerLauncherImpl getInstance() throws IOException{
		if(instance == null){
			ServerLauncher.appKey = "abcd1234";
			QoS4SendDaemonS2C.DEBUG=true;
			ServerLauncherImpl.PORT = 7901;
			instance = new ServerLauncherImpl();
		}
		return instance;
	}
	
	public ServerLauncherImpl() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initListeners() {
		// TODO Auto-generated method stub
		this.setServerEventListener(new ServerEventListenerImpl());
		this.setServerMessageQoSEventListener(new MessageQoSEventS2CListenerImpl());
	}

	public static void main(String[] args)throws IOException{
		ServerLauncherImpl.getInstance().startup();
	}
}
