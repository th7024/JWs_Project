
public class dbmain {

	public static void main(String[] args) {
		db_test1 con = new db_test1();
		System.out.println("관리자 여부 :"+con.isAdmin("admin", "admin"));
	}

}
