
public class DauSach {
	private String dau_sach;
	private String ten_tl;
	
	public DauSach() {}
	public DauSach(String dau_sach, String ten_tl) {
		this.dau_sach = dau_sach;
		this.ten_tl = ten_tl;
	}
	public String getTen_tl() {
		return ten_tl;
	}
	public void setTen_tl(String ten_tl) {
		this.ten_tl = ten_tl;
	}
	public String getDau_sach() {
		return dau_sach;
	}
	public void setDau_sach(String dau_sach) {
		this.dau_sach = dau_sach;
	}
	 public String toString() {
	        return "DauSach{" +
	                "dau_sach='" + dau_sach + '\'' +
	                ", ten_tl='" + ten_tl + '\'' +
	                '}';
	 }
}
