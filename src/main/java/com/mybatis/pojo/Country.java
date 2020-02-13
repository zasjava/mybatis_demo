package com.mybatis.pojo;

/**
 * @ClassName Country
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-2-10 11:46
 **/
public class Country {
	private long id;
	private String countryname;
	private String countrycode;

	public Country() {
	}

	public Country(long id, String countryname, String countrycode) {
		this.id = id;
		this.countryname = countryname;
		this.countrycode = countrycode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", countryname='" + countryname + '\'' +
				", countrycode='" + countrycode + '\'' +
				'}';
	}
}
