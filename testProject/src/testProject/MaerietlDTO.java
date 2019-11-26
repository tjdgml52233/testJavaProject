package testProject;

import java.sql.Date;

public class MaerietlDTO {
	String product_no;
	String plocal;
	String pname;
	String company;
	Date redate;
	int uprice;
	int pacc;
	int sprice;
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getPlocal() {
		return plocal;
	}
	public void setPlocal(String plocal) {
		this.plocal = plocal;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	public int getUprice() {
		return uprice;
	}
	public void setUprice(int uprice) {
		this.uprice = uprice;
	}
	public int getPacc() {
		return pacc;
	}
	public void setPacc(int pacc) {
		this.pacc = pacc;
	}
	public int getSprice() {
		return sprice;
	}
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_no=" + product_no + ", plocal=" + plocal + ", pname=" + pname + ", company="
				+ company + ", redate=" + redate + ", uprice=" + uprice + ", pacc=" + pacc + ", sprice=" + sprice + "]";
	}
	public MaerietlDTO() {

	}
	public MaerietlDTO(String product_no, String plocal, String pname, String company, Date redate, 
			int uprice, int pacc) {
		super();
		this.product_no = product_no;
		this.plocal = plocal;
		this.pname = pname;
		this.company = company;
		this.redate = redate;
		this.uprice = uprice;
		this.pacc = pacc;
		sprice = uprice*pacc;
	}
}
