package zhentao.zhang.service;

import zhentao.zhang.pojo.User;

public interface ILoginService {
	String checkAccountAndPassword(String account,String password);
}
