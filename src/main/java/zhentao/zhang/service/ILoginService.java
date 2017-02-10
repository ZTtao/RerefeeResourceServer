package zhentao.zhang.service;

import zhentao.zhang.pojo.User;

public interface ILoginService {
	User checkAccountAndPassword(String account,String password);
}
