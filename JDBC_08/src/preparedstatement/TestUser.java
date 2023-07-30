package preparedstatement;
import dao.UserDAO;
import model.User;

public class TestUser {
	public static void main(String[] args) {
//		User u1 = new User("user1", "pass123", "User Mot");
//		UserDAO.getInstance().insert(u1);
		
		
		System.out.println("---------------------------------");
		User u_find = new User("user1", "pass123", "User Mot");
		User u_result = UserDAO.getInstance().selectById(u_find);
		System.out.println(u_result);
		
		System.out.println("---------------------------------");
		User u_find1 = new User("x\' or 1=1; -- ", "", "");
		User u_result1 = UserDAO.getInstance().selectById(u_find1);
		System.out.println(u_result1);
		
	}
}
