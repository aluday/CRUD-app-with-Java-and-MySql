

public class Book {
	private String id;
	private String ten;
	private String ma_tac_gia;
	private String ma_nxb;
	private String dau_sach;
	
	public Book () {}
	public Book (String id, String ten, String ma_tg, String ma_nxb, String dau_sach) {
		setId(id);
		setTen(ten);
		setMa_tac_gia(ma_tg);
		setMa_nxb(ma_nxb);
		setDau_sach(dau_sach);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMa_tac_gia() {
		return ma_tac_gia;
	}
	public void setMa_tac_gia(String ma_tac_gia) {
		this.ma_tac_gia = ma_tac_gia;
	}
	public String getMa_nxb() {
		return ma_nxb;
	}
	public void setMa_nxb(String ma_nxb) {
		this.ma_nxb = ma_nxb;
	}
	public String getDau_sach() {
		return dau_sach;
	}
	public void setDau_sach(String dau_sach) {
		this.dau_sach = dau_sach;
	}
	 public String toString() {
	        return "Book{" +
	                "id='" + id + '\'' +
	                ", ten='" + ten + '\'' +
	                ", ma_tac_gia='" + ma_tac_gia + '\'' +
	                ", ma_nxb='" + ma_nxb + '\'' +
	                ", dau_sach='" + dau_sach + '\'' +
	                '}';
	 }
}
