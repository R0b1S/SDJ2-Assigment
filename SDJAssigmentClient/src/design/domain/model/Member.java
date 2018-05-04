package design.domain.model;


public class Member {
	private String name;
	private String address;
	private String email;
	private String phone;
	private boolean paidFee;
	private int year; // Year when member signed for membership
	private DOB dob;

	public Member(String name, String address, String email, String phone, boolean paidFee, int year, DOB dob) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.paidFee = paidFee;
		this.year = year;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public boolean getPaidFee() {
		return paidFee;
	}

	public int getYear() {
		return year;
	}

	public DOB getDob() {
		return dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPaidFee(boolean paidFee) {
		this.paidFee = paidFee;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDob(DOB dob) {
		this.dob = dob;
	}
	
	public String toString() {
		return name + " | " + address + " | " + email + " | "+ phone + " | " + dob + " | " + year + " | " + paidFee;
	}
}
