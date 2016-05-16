package com.ATMMS.imudges.DAO;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String num;

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** full constructor */
	public Major(String name, String num) {
		this.name = name;
		this.num = num;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}