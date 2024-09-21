package thu2;

import java.util.List;


public interface IUserDao {
	List<UserModel> findAll();
	UserModel findById(int id);
	void insert(UserModel user);
	UserModel findByUserName(String username);
}
