package com.gys.classmanager.dto;

public class UnivScoreDto {
	
	private int id;
	private String name;
	private String major;
	private String kyeyoel;
	private String mojibgun;
	private String index;
	private int standard;
	private int percent;
	private double rate;
	private String banyoungSubject;
	
	public UnivScoreDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UnivScoreDto(int id, String name, String major, String kyeyoel, String mojibgun, String index, int standard, int percent, double rate, String banyoungSubject) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.kyeyoel = kyeyoel;
		this.mojibgun = mojibgun;
		this.index = index;
		this.standard = standard;
		this.percent = percent;
		this.rate = rate;
		this.banyoungSubject = banyoungSubject;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getKyeyoel() {
		return kyeyoel;
	}

	public void setKyeyoel(String kyeyoel) {
		this.kyeyoel = kyeyoel;
	}

	public String getMojibgun() {
		return mojibgun;
	}

	public void setMojibgun(String mojibgun) {
		this.mojibgun = mojibgun;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getBanyoungSubject() {
		return banyoungSubject;
	}

	public void setBanyoungSubject(String banyoungSubject) {
		this.banyoungSubject = banyoungSubject;
	}

	
	
}
