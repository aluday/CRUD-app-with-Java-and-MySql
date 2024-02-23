import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySqlConnect {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Connection conn = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsach?user=root&password=041102");
            System.out.println("Noi ket thanh cong");
        } catch (Exception e) {
            System.out.println("Nối kết không thành công");
            e.printStackTrace();
        }
    }

	public static List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        String query = "select * from sach";
        try {
            try (
            	Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Book bk = new Book(rs.getString("sach_id"), rs.getString("ten_sach"),
                            rs.getString("ma_tac_gia"), rs.getString("ma_nxb"), rs.getString("dau_sach"));
                    
                    bookList.add(bk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
	public static List<Author> findAllAuthor() {
        List<Author> authorList = new ArrayList<>();
        String query = "select * from tac_gia";
        try {
            try (
            	Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                	Author au = new Author(rs.getString("ma_tac_gia"), rs.getString("ten_tg"));
                    
                	authorList.add(au);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }
	public static List<NXB> findAllNXB() {
        List<NXB> nxbList = new ArrayList<>();
        String query = "select * from nxb";
        try {
            try (
            	Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                	NXB nxb = new NXB(rs.getString("ma_nxb"), rs.getString("ten_nxb"));
                    	
                	nxbList.add(nxb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nxbList;
    }
	
	public static List<DauSach> findAllDauSach() {
        List<DauSach> dauSachList = new ArrayList<>();
        String query = "select * from the_loai";
        try {
            try (
            	Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                	DauSach ds = new DauSach(rs.getString("dau_sach"), rs.getString("ten_tl"));
                	dauSachList.add(ds);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dauSachList;
    }
	
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsach?user=root&password=041102");
    }
    
    public static boolean insertBook(Book bk) {
    	String query = "{call insertBook(?, ?, ?, ?, ?)}";
        try (Connection conn = getConnection();
             CallableStatement cstmt = conn.prepareCall(query)) {
            cstmt.setString(1, bk.getId());
            cstmt.setString(2, bk.getTen());
            cstmt.setString(3, bk.getMa_nxb());
            cstmt.setString(4, bk.getMa_tac_gia());
            cstmt.setString(5, bk.getDau_sach());
            int rowsAffected = cstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
      
    public static void deleteBook(Book bk) {
        String sach_id = bk.getId();
        String query = "{call deleteBook(?)}";
        try (Connection conn = getConnection();
             CallableStatement cstmt = conn.prepareCall(query)) {
            cstmt.setString(1, sach_id);
            cstmt.execute();
            System.out.println("Xóa sách thành công.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean  updateBook(Book bk) {
    	String query = "{call updateBook(?, ?, ?, ?, ?)}";
        try (
        	Connection conn = getConnection();
            CallableStatement cstmt = conn.prepareCall(query)) {
            cstmt.setString(1, bk.getId());
            cstmt.setString(2, bk.getTen());
            cstmt.setString(3, bk.getMa_tac_gia());
            cstmt.setString(4, bk.getMa_nxb());
            cstmt.setString(5, bk.getDau_sach());

            int rowsAffected = cstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 
    public static List<Book> findByName(Book bk) {
        String ten_sach = bk.getTen();
        String query = "{call searchBooksByName(?)}";
        List<Book> bookList = new ArrayList<>();
        try (
        	Connection conn = getConnection();
            CallableStatement cstmt = conn.prepareCall(query)) {
            cstmt.setString(1, ten_sach);
            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
	                Book book = new Book(
	                	rs.getString("sach_id"),
	                    rs.getString("ten_sach"),
	                    rs.getString("ma_tac_gia"),
	                    rs.getString("ma_nxb"),
	                    rs.getString("dau_sach")
	                );
	                bookList.add(book);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }
    
    public static boolean insertType(DauSach ds) {
    	String query = "{call insertType(?, ?)}";
        try (Connection conn = getConnection();
             CallableStatement cstmt = conn.prepareCall(query)) {
            cstmt.setString(1, ds.getDau_sach());
            cstmt.setString(2, ds.getTen_tl());
            int rowsAffected = cstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}