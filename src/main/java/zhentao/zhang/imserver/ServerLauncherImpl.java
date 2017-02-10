package zhentao.zhang.imserver;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.openmob.mobileimsdk.server.ServerLauncher;
import net.openmob.mobileimsdk.server.qos.QoS4SendDaemonS2C;
import zhentao.zhang.service.IUserService;
import zhentao.zhang.service.impl.UserServiceImpl;


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
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		IUserService service = (IUserService)context.getBean(UserServiceImpl.class);
		System.out.println(service.hasUserByNickName("zhentao"));
	}
}
