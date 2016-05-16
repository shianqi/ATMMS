package com.ATMMS.imudges.DAO;

import java.sql.Timestamp;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String project;
	private String parent;
	private String num;
	private Timestamp newTime;
	private Timestamp fixTime;
	private String ascription;
	private String principal;
	private String medium;
	private String remark;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String name, String project, String parent, String num,
			Timestamp newTime) {
		this.name = name;
		this.project = project;
		this.parent = parent;
		this.num = num;
		this.newTime = newTime;
	}

	/** full constructor */
	public Item(String name, String project, String parent, String num,
			Timestamp newTime, Timestamp fixTime, String ascription,
			String principal, String medium, String remark) {
		this.name = name;
		this.project = project;
		this.parent = parent;
		this.num = num;
		this.newTime = newTime;
		this.fixTime = fixTime;
		this.ascription = ascription;
		this.principal = principal;
		this.medium = medium;
		this.remark = remark;
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

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
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

	public Timestamp getNewTime() {
		return this.newTime;
	}

	public void setNewTime(Timestamp newTime) {
		this.newTime = newTime;
	}

	public Timestamp getFixTime() {
		return this.fixTime;
	}

	public void setFixTime(Timestamp fixTime) {
		this.fixTime = fixTime;
	}

	public String getAscription() {
		return this.ascription;
	}

	public void setAscription(String ascription) {
		this.ascription = ascription;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getMedium() {
		return this.medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}