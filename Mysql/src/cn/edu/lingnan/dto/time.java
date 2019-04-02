package cn.edu.lingnan.dto;

public class time {
  
	private static String sid;
	private static int worktime;
	private static int vacate;
	private static int rest;
	private static int hidden;
	public static String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public static int getWorktime() {
		return worktime;
	}
	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}
	public static int getVacate() {
		return vacate;
	}
	public void setVacate(int vacate) {
		this.vacate = vacate;
	}
	public static int getRest() {
		return rest;
	}
	public void setRest(int rest) {
		this.rest = rest;
	}
	public static int getHidden() {
		return hidden;
	}
	public void setHidden(int hidden) {
		this.hidden = hidden;
	}
	
}
