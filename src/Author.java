
public class Author {
	private String ma_tac_gia;
	private String ten_tg;
	
	public Author() {}
	public Author(String ma_tac_gia, String ten_tg) {
		this.ten_tg = ten_tg;
		this.ma_tac_gia = ma_tac_gia;
	}
	public String getTen_tg() {
		return ten_tg;
	}
	public void setTen_tg(String ten_tg) {
		this.ten_tg = ten_tg;
	}
	public String getMa_tac_gia() {
		return ma_tac_gia;
	}
	public void setMa_tac_gia(String ma_tac_gia) {
		this.ma_tac_gia = ma_tac_gia;
	}
	 public String toString() {
	        return "Author{" +
	                "ma_tac_gia='" + ma_tac_gia + '\'' +
	                ", ten_tg='" + ten_tg + '\'' +
	                '}';
	}
}
