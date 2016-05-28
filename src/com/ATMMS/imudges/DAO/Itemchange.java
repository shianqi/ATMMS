package com.ATMMS.imudges.DAO;

/**
 * Itemchange entity. @author MyEclipse Persistence Tools
 */

public class Itemchange implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private String pid;
	private String name;
	private String ascription;
	private String princlpal;
	private String medium;
	private String remark;

	// Constructors

	/** default constructor */
	public Itemchange() {
	}

	/** full constructor */
	public Itemchange(String type, String pid, String name, String ascription,
			String princlpal, String medium, String remark) {
		this.type = type;
		this.pid = pid;
		this.name = name;
		this.ascription = ascription;
		this.princlpal = princlpal;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAscription() {
		return this.ascription;
	}

	public void setAscription(String ascription) {
		this.ascription = ascription;
	}

	public String getPrinclpal() {
		return this.princlpal;
	}

	public void setPrinclpal(String princlpal) {
		this.princlpal = princlpal;
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