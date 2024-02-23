
public class NXB {
	private String ma_nxb;
	private String ten_nxb;
	
	public NXB() {}
	public NXB(String ten_nxb, String ma_nxb) {
		this.ten_nxb = ten_nxb;
		this.ma_nxb = ma_nxb;
	}
	
	public String getTen_nxb() {
		return ten_nxb;
	}
	public void setTen_nxb(String ten_nxb) {
		this.ten_nxb = ten_nxb;
	}
	public String getMa_nxb() {
		return ma_nxb;
	}
	public void setMa_nxb(String ma_nxb) {
		this.ma_nxb = ma_nxb;
	}
}
