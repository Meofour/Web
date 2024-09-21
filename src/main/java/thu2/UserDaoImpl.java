package thu2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class UserDaoImpl implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user = ? ";
		try {
		conn = new DB().getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel user = new UserModel();
		List<UserModel> list = new ArrayList<UserModel>();
		list.add(new UserModel(  
		rs.getInt("id"),
		rs.getString("email"),
		rs.getString("username"),
		rs.getString("fullname"),
		rs.getString("password"),
		rs.getString("image"),
	    rs.getInt("roleid"),
		rs.getString("phone"),
		rs.getDate("createdate")));
		return list;
		   }
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM [user] WHERE id = ? ";
		try {
		conn = new DB().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel user = new UserModel();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("image"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreatedDate(rs.getDate("createdate"));
		return user;
		   }
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO [user] (email, username, fullname, password, image, roleid,phone,	createdate) VALUES (?,?,?,?,?,?,?,?)";
				try {
				conn = new DB().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getFullName());
				ps.setString(4, user.getPassWord());
				ps.setString(5, user.getAvatar());
				ps.setInt(6,user.getRoleid());
				ps.setString(7,user.getPhone());
				ps.setDate(8, user.getCreatedDate());
				ps.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM [user] WHERE username = ? ";
		try {
		conn = new DB().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel user = new UserModel();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("image"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreatedDate(rs.getDate("createdate"));
		return user;
		   }
		} catch (Exception e) {e.printStackTrace();}
	
		return null;
	}
	
	
 	public static void main(String[]args) {
 		try {
 			IUserDao userDao = new UserDaoImpl();
 			
 			System.out.println(userDao.findById(8));
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
 	}
	
}
