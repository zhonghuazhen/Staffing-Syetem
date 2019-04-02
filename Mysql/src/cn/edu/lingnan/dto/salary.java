package cn.edu.lingnan.dto;

public class salary {
    private static String sid;
    private static String sname;
    private static float basic;  //基础工资
    private static float bonus;   //奖金百分比（*基础工资）
    private static float subvention;  //补贴百分比（*基础工资）
    private static float penalty;  //罚款
    private static String date;    //
    private static int hidden; 
 	public static String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public static String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public static float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	public static float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public static float getSubvention() {
		return subvention;
	}
	public void setSubvention(float subvention) {
		this.subvention = subvention;
	}
	public static float getPenalty() {
		return penalty;
	}
	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
	public static String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public static int getHidden() {
		return hidden;
	}
	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

}
