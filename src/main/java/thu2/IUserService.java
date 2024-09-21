package thu2;

public interface IUserService {
UserModel login(String username, String password);
UserModel FindByUserName(String username);
boolean register(UserModel newUser);
}
