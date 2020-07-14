package com.ytx.pojo;

import java.util.Date;

public class Student {
	//班级名称
	private String classname;
	//专业名称
	private String majorname;
	//省名称
	private String shengname;
	//市名称
	private String cityname;
	//县名称
	private String xianname;
	

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public String getShengname() {
		return shengname;
	}

	public void setShengname(String shengname) {
		this.shengname = shengname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getXianname() {
		return xianname;
	}

	public void setXianname(String xianname) {
		this.xianname = xianname;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.id
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.stuno
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String stuno;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.name
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.stucode
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String stucode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.stupwd
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String stupwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.classid
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private Long classid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.sex
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String sex;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.phone
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String phone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.photo
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String photo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.modifydate
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private Date modifydate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.modifyby
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private Long modifyby;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.age
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private Long age;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.majorid
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private Long majorid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.sheng
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String sheng;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.city
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String city;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column student.xian
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	private String xian;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.id
	 * @return  the value of student.id
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.id
	 * @param id  the value for student.id
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.stuno
	 * @return  the value of student.stuno
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getStuno() {
		return stuno;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.stuno
	 * @param stuno  the value for student.stuno
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.name
	 * @return  the value of student.name
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.name
	 * @param name  the value for student.name
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.stucode
	 * @return  the value of student.stucode
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getStucode() {
		return stucode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.stucode
	 * @param stucode  the value for student.stucode
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setStucode(String stucode) {
		this.stucode = stucode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.stupwd
	 * @return  the value of student.stupwd
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getStupwd() {
		return stupwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.stupwd
	 * @param stupwd  the value for student.stupwd
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setStupwd(String stupwd) {
		this.stupwd = stupwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.classid
	 * @return  the value of student.classid
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public Long getClassid() {
		return classid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.classid
	 * @param classid  the value for student.classid
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setClassid(Long classid) {
		this.classid = classid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.sex
	 * @return  the value of student.sex
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.sex
	 * @param sex  the value for student.sex
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.phone
	 * @return  the value of student.phone
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.phone
	 * @param phone  the value for student.phone
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.photo
	 * @return  the value of student.photo
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.photo
	 * @param photo  the value for student.photo
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.modifydate
	 * @return  the value of student.modifydate
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public Date getModifydate() {
		return modifydate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.modifydate
	 * @param modifydate  the value for student.modifydate
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.modifyby
	 * @return  the value of student.modifyby
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public Long getModifyby() {
		return modifyby;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.modifyby
	 * @param modifyby  the value for student.modifyby
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setModifyby(Long modifyby) {
		this.modifyby = modifyby;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.age
	 * @return  the value of student.age
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public Long getAge() {
		return age;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.age
	 * @param age  the value for student.age
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setAge(Long age) {
		this.age = age;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.majorid
	 * @return  the value of student.majorid
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public Long getMajorid() {
		return majorid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.majorid
	 * @param majorid  the value for student.majorid
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setMajorid(Long majorid) {
		this.majorid = majorid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.sheng
	 * @return  the value of student.sheng
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getSheng() {
		return sheng;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.sheng
	 * @param sheng  the value for student.sheng
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.city
	 * @return  the value of student.city
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.city
	 * @param city  the value for student.city
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column student.xian
	 * @return  the value of student.xian
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public String getXian() {
		return xian;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column student.xian
	 * @param xian  the value for student.xian
	 * @mbggenerated  Sun Jul 12 23:13:43 CST 2020
	 */
	public void setXian(String xian) {
		this.xian = xian;
	}
}