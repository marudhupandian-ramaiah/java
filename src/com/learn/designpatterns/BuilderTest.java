package com.learn.designpatterns;

/**
 * 
 * Builder design pattern help us to create an object with valid state when has
 * more no. of optional parameters. Setting all the optional fields is not good.
 * Builder pattern solves those problems.
 *
 */
public class BuilderTest {

	public static void main(String[] args) {

		// without optional fields
		RailwayInquiry inquiryRqst = new RailwayInquiry.RailwayInquiryBuilder(123).build();
		System.out.println("inquiry object with mandatory fields : " + inquiryRqst.toString());

		// with optional fields
		inquiryRqst = new RailwayInquiry.RailwayInquiryBuilder(345).email("a@b.com").id("jgdgee").name("abc")
				.mobile("3763866164").build();
		System.out.println("inquiry object with optional fields : " + inquiryRqst.toString());

	}

}

class RailwayInquiry {

	// mandatory fields
	private int pnr;

	// optional fields
	private String name;
	private String id;
	private String address;
	private String dob;
	private String email;
	private String mobile;

	// private constructor that allows object creation only through builder inner
	// class
	private RailwayInquiry(RailwayInquiryBuilder railwayInquiryBuilder) {

		this.pnr = railwayInquiryBuilder.pnr;
		this.name = railwayInquiryBuilder.name;
		this.id = railwayInquiryBuilder.id;
		this.address = railwayInquiryBuilder.address;
		this.dob = railwayInquiryBuilder.dob;
		this.email = railwayInquiryBuilder.email;
		this.mobile = railwayInquiryBuilder.mobile;

	}

	// only getters, no setters. values will be set through constructors
	public int getPnr() {
		return pnr;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		return "RailwayInquiry [pnr=" + pnr + ", name=" + name + ", id=" + id + ", address=" + address + ", dob=" + dob
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}

	// builder class
	static class RailwayInquiryBuilder {

		// mandatory
		private int pnr;

		// optional
		private String name;
		private String id;
		private String address;
		private String dob;
		private String email;
		private String mobile;

		// create builder object just with pnr
		public RailwayInquiryBuilder(int pnr) {
			super();
			this.pnr = pnr;
		}

		// setters for optional fields
		public RailwayInquiryBuilder name(String name) {
			this.name = name;
			return this;
		}

		public RailwayInquiryBuilder id(String id) {
			this.id = id;
			return this;
		}

		public RailwayInquiryBuilder address(String address) {
			this.address = address;
			return this;
		}

		public RailwayInquiryBuilder dob(String dob) {
			this.dob = dob;
			return this;
		}

		public RailwayInquiryBuilder email(String email) {
			this.email = email;
			return this;
		}

		public RailwayInquiryBuilder mobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		// build method that creates actual object using builder class
		public RailwayInquiry build() {
			return new RailwayInquiry(this);
		}

	}
}