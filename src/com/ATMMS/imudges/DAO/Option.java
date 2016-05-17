package com.ATMMS.imudges.DAO;

/**
 * Option entity. @author MyEclipse Persistence Tools
 */

public class Option implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String parent;
	private String num;

	// Constructors

	/** default constructor */
	public Option() {
	}

	/** full constructor */
	public Option(String name, String parent, String num) {
		this.name = name;
		this.parent = parent;
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

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}