import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_test1 {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public db_test1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jw_test?serverTimezone=UTC","root","root1234");
			st = con.createStatement();
		}
		catch(Exception e) {
			System.out.println("연결실패");
		}
	}
	public boolean isAdmin(String adminID, String adminPs) {
		try {
			String SQL = "SELECT * FROM ADMIN WHERE adminID = '" + adminID + "' and adminPassword = '" + adminPs+"'";
			rs = st.executeQuery(SQL);
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("데이터베이스 검색 오류");
		}
		return false;
	}
	
	public boolean isChecked(String PhoneN) { //번호유무 체크
		try {
			String Sql = "SELECT * FROM ADMIN WHERE adminID = '" + PhoneN ;
			rs = st.executeQuery(Sql);
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("번호 없음 : "+PhoneN);
		}
		return false;
	}
	
	public boolean add_PN(String PhoneN) { //번호유무 체크
		try {
			String Sql = "INSERT INTO ADMIN(adminID,adminPassword) VALUES(" + PhoneN+")" ;
			rs = st.executeQuery(Sql);
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("번호 없음 : "+PhoneN);
		}
		return false;
	}
	
	
}
