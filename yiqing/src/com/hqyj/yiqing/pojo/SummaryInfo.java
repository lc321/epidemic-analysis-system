package com.hqyj.yiqing.pojo;

public class SummaryInfo {
	
	private int currentConfirmedCount;
	
	private int confirmCount;
	
	private int curedCount;
	
	private int deadCount;
	
	private String WorstCountry;
	
	private String BestCountry;

	public SummaryInfo() {
	}

	public SummaryInfo(int currentConfirmedCount, int confirmCount, int curedCount, int deadCount, String worstCountry,
			String bestCountry) {
		super();
		this.currentConfirmedCount = currentConfirmedCount;
		this.confirmCount = confirmCount;
		this.curedCount = curedCount;
		this.deadCount = deadCount;
		WorstCountry = worstCountry;
		BestCountry = bestCountry;
	}

	public int getCurrentConfirmedCount() {
		return currentConfirmedCount;
	}

	public void setCurrentConfirmedCount(int currentConfirmedCount) {
		this.currentConfirmedCount = currentConfirmedCount;
	}

	public int getConfirmCount() {
		return confirmCount;
	}

	public void setConfirmCount(int confirmCount) {
		this.confirmCount = confirmCount;
	}

	public int getCuredCount() {
		return curedCount;
	}

	public void setCuredCount(int curedCount) {
		this.curedCount = curedCount;
	}

	public int getDeadCount() {
		return deadCount;
	}

	public void setDeadCount(int deadCount) {
		this.deadCount = deadCount;
	}

	public String getWorstCountry() {
		return WorstCountry;
	}

	public void setWorstCountry(String worstCountry) {
		WorstCountry = worstCountry;
	}

	public String getBestCountry() {
		return BestCountry;
	}

	public void setBestCountry(String bestCountry) {
		BestCountry = bestCountry;
	}

}
