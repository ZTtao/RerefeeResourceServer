package zhentao.zhang.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
	Map<Integer,String> getUserNameById(List<Integer> idList);
}
