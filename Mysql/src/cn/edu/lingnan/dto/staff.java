package cn.edu.lingnan.dto;

public class staff {
	private static String did;
	private static String sid;
	private static String sname;
	private static String spass;
	private static String sex;
	private static int age;
	private static String zhiwu;
	private static int tel;
	private static String email;
	private static int superuser;
    private static int hidden;
	public static  String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
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
	public static String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public static String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public static int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public static int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public static String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static int getSuperuser() {
		return superuser;
	}
	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	public static int getHidden() {
		return hidden;
	}
	public void setHidden(int hidden) {
		this.hidden = hidden;
	}
}
