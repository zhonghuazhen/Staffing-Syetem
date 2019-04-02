package cn.edu.lingnan.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.dao.*;
public class JDBCTest {
    //部门：
	//查找所有部门信息
	public static void findalldep()
	{
		   departmentDao ddao=new departmentDao();
			Vector<department> v=new Vector<department>();
			v=ddao.findAllDep();
			//for(department d:v)
			//System.out.println(d.getDname());
	}
	//增加部门信息：
	public static void indep()
	{
		Scanner s1=new Scanner(System.in);
		String did;
		String dname;
		int hidden;
		department dep=new department();
		System.out.println("请输入部门id");
		did=s1.next();
		System.out.println("请输入部门名字");
		dname=s1.next();
		System.out.println("请输入0(显示部门信息)或1(隐藏部门信息)");
		hidden=s1.nextInt();
		//
		dep.setDid(did);
		dep.setDname(dname);
		dep.setHidden(hidden);
		//
		departmentDao depd=new departmentDao();
		depd.insertdep(dep);
		
	}
	//修改部门信息；
	public static void updep()
	{
		Scanner s1=new Scanner(System.in);
		String did;
		String dname;
		int hidden;
		String did1;
		//
		department dep=new department();
		departmentDao depd=new departmentDao();
		//
		 int i;
		 System.out.println("请输入要修改的部门的id");
	     did1=s1.next();
	     System.out.println("修改部门id请输入1");
	     System.out.println("修改名字请输入2");
	     System.out.println("修改显示或者隐藏请输入3");
	     //
	     i=s1.nextInt();
	     switch(i)
	     {
	     case 1:
	    	 System.out.println("请输入部门修改后的id");
	    	 did=s1.next();
	    	 dep.setDid(did);
	    	 break;
	     case 2:
	    	 System.out.println("请输入部门修改后的名字");
	    	 dname=s1.next();
	    	 dep.setDname(dname);
	    	 break;
	     case 3:
	    	 System.out.println("请输入部门修改后是否显示或者隐藏");
	    	 hidden=s1.nextInt();
	    	 dep.setHidden(hidden);
	    	 break;
	     }
	     depd.updatedep(dep,did1, i);
	}
	//通过did删除部门信息；
	public static void deldepbydid()
	{
		String _did;
		 Scanner s1=new Scanner(System.in);
		 System.out.println("请输入要删除的部门的id");
		 _did=s1.next();
		 departmentDao depd=new departmentDao();
		 depd.deleteDepBydid(_did);
	}
    //对部门表进行操作；
	public static void dep()
	{
		int dep,d1;
		Scanner s1=new Scanner(System.in);
		System.out.println("查看请输入1");
		System.out.println("增加请输入2");
		System.out.println("修改请输入3");
		System.out.println("删除请输入4");
		System.out.println("返回请按0");
		dep=s1.nextInt();
		switch (dep) {
		case 0:
			main1();
		case 1:
			findalldep();
			break;
		case 2:
			indep();
			break;
		case 3:
			updep();
			break;
		case 4:
			deldepbydid();
			break;
      
		default:
			break;
		}
		System.out.println("返回请按0");
		d1=s1.nextInt();
		if(d1==0)
			dep();
			
		
	}
	
	//员工：
	//查找所有员工信息；
	public static void findallstaff()
	{
		
		 staffDao sdao=new staffDao();
			Vector<staff> v=new Vector<staff>();
			v=sdao.findAllSta();
			//只显示最后的一组数据；
			//for(staff s:v)
			//System.out.println(s.getSname());
	   /*staffDao sdao=new staffDao();
	   Vector<staff> v=new Vector<staff>();
	   v=sdao.findAllsta();
			for(staff s:v)
				System.out.println(s.getEmail());
		//System.out.println(s.getDid()+s.getSid()+s.getSname()+s.getSpass()+s.getSex()+s.getAge()+s.getZhiwu()+s.getTel()+s.getEmail()+s.getSuperuser());
	*/
	}

	//增加员工信息；
	public static void insta()
	{
		Scanner s1=new Scanner(System.in);
		 String did;
		 String sid;
		 String sname;
		 String spass;
		 String sex;
		 int age;
		 String zhiwu;
		 int tel;
		 String email;
		 int superuser;
	     int hidden;
	     
	    staff sta=new staff();
	    System.out.println("请输入部门id");
	    did=s1.next();
	    System.out.println("请输入员工id");
	    sid=s1.next();
	    System.out.println("请输入员工姓名");
	    sname=s1.next();
	    System.out.println("请输入密码");
	    spass=s1.next();
	    System.out.println("请输入性别");
	    sex=s1.next();
	    System.out.println("请输入年龄");
	    age=s1.nextInt();
	    System.out.println("请输入职位");
	    zhiwu=s1.next();
	    System.out.println("请输入电话号码");
	    tel=s1.nextInt();
	    System.out.println("请输入邮箱");
	    email=s1.next();
	    System.out.println("请输入权限");
	    superuser=s1.nextInt();
	    System.out.println("请输入0(显示信息)，1(隐藏信息)");
	    hidden=s1.nextInt();
	     //
	    sta.setDid(did);
	    sta.setSid(sid);
	    sta.setSname(sname);
	    sta.setSpass(spass);
	    sta.setSex(sex);
	    sta.setAge(age);
	    sta.setZhiwu(zhiwu);
	    sta.setTel(tel);
	    sta.setEmail(email);
	    sta.setSuperuser(superuser);
	    sta.setHidden(hidden);
	    
	    staffDao stad=new staffDao();
	    stad.insertsta(sta);
	}
	

	//修改员工信息测试；
	public static void upsta()
	{
		Scanner s1=new Scanner(System.in);
		 String did;
		 String sid;
		 String sname;
		 String spass;
		 String sex;
		 int age;
		 String zhiwu;
		 int tel;
		 String email;
		 int superuser;
	     int hidden;
	     //staff
	     staff sta=new staff();
	     staffDao stad=new staffDao();
	     //修改测试；
	   //**************************
	     int i;
	     System.out.println("修改员工部门id请输入1");
	     System.out.println("修改员工名字请输入2");
	     System.out.println("修改员工密码请输入3");
	     System.out.println("修改员工性别请输入4");
	     System.out.println("修改员工年龄请输入5");
	     System.out.println("修改员工职务请输入6");
	     System.out.println("修改员工电话号码请输入7");
	     System.out.println("修改员工邮箱请输入8");
	     System.out.println("修改员工权限请输入9");
	     System.out.println("修改员工信息显示或隐藏请输入10");
        i=s1.nextInt();
        
        //
        switch(i)
        {
        case 1:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的部门id");
       	 did=s1.next();
       	 sta.setSid(sid);
       	 sta.setDid(did);
       	 break;
        case 2:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工姓名");
       	 sname=s1.next();
       	 sta.setSid(sid);
       	 sta.setSname(sname);
       	 break;
        case 3:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工密码");
       	 spass=s1.next();
       	 sta.setSid(sid);
       	 sta.setSpass(spass);
       	 break;
        case 4:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工性别");
       	 sex=s1.next();
       	 sta.setSid(sid);
       	 sta.setSex(sex);
       	 break;
        case 5:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工年龄");
       	 age=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setAge(age);
       	 break;
        case 6:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工职务");
       	 zhiwu=s1.next();
       	 sta.setSid(sid);
       	 sta.setZhiwu(zhiwu);
       	 break;
        case 7:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工电话号码");
       	 tel=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setTel(tel);
       	 break;
        case 8:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工邮箱");
       	 email=s1.next();
       	 sta.setSid(sid);
       	 sta.setEmail(email);
       	 break;
        case 9:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入要修改后的员工权限");
       	 superuser=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setSuperuser(superuser);
       	 break;
        case 10:
       	 System.out.println("请输入员工id");
       	 sid=s1.next();
       	 System.out.println("请输入0(显示员工信息)或输入1(隐藏员工信息)");
       	 hidden=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setHidden(hidden);
       	 break;
          default:
			break;
       	 
        }
        //
        
        stad.updatesta(sta, i);
	     
		
	}
//通过名字删除员工信息；
	public static void destabyname()
	{    String _name;
	  Scanner s1=new Scanner(System.in);
	  System.out.println("请输入要删除的员工的名字");
	  _name=s1.next();
		staffDao sta=new staffDao();
		sta.deletestaByName(_name);
	}
//通过员工id删除员工信息；
	public static void destabyid()
	{
		 String _sid;
		  Scanner s1=new Scanner(System.in);
		  System.out.println("请输入要删除的员工的id");
		  _sid=s1.next();
			staffDao sta=new staffDao();
			sta.deletestaByName(_sid);
		
	}
	//对员工表进行操作
	public static void sta()
	{   int sta,sta1;
	    Scanner s1=new Scanner(System.in);
		System.out.println("查看请输入1");
		System.out.println("增加请输入2");
		System.out.println("修改请输入3");
		System.out.println("删除请输入4");
		System.out.println("返回请输入0");
		sta=s1.nextInt();
		switch (sta) {
		case 0:
			main1();
			break;
		case 1:
			findallstaff();
			break;
		case 2:
			insta();
			break;
		case 3:
			upsta();
			break;
		case 4:
			destabyname();
			break;

		default:
			break;
		}
		System.out.println("返回请输入0");
		sta1=s1.nextInt();
		if(sta1==0)
			sta();
	}
//页面显示;
	
	//工资表
	//显示所有员工的工资情况
	public static void findallsal()
	{
		salaryDao saldao=new salaryDao();
		Vector<salary> v=new Vector<salary>();
		v=saldao.findAllsal();
	}
	
	//插入员工工资信息
	public static void insal()
	{
		Scanner s1=new Scanner(System.in);
		
		String sid;
		String sname;
		float basic;
		float bonus;
		float subvention;
		float penalty;
		String date;
		int hidden;
		
		salary sal=new salary();
		System.out.println("请输入员工id");
		sid=s1.next();
		System.out.println("请输入员工姓名");
		sname=s1.next();
		System.out.println("请输入基础工资");
		basic=s1.nextFloat();
		System.out.println("请输入奖金百分比");
		bonus=s1.nextFloat();
		System.out.println("请输入补贴百分比");
		subvention=s1.nextFloat();
		System.out.println("请输入罚款");
		penalty=s1.nextFloat();
		System.out.println("请输入年-月-日");
		date=s1.next();
	    System.out.println("请输入0(显示信息)，1(隐藏信息)");
        hidden=s1.nextInt();
        
        sal.setSid(sid);
        sal.setSname(sname);
        sal.setBasic(basic);
        sal.setBonus(bonus);
        sal.setSubvention(subvention);
        sal.setPenalty(penalty);
        sal.setDate(date);
        sal.setHidden(hidden);
        
        salaryDao saldao=new salaryDao();
        saldao.insertsal(sal);
       
		
	}
	//
	//修改员工工资信息
	public static void upsal()
	{
		Scanner s1=new Scanner(System.in);
		String sid;
		String sname;
		float basic;
		float bonus;
		float subvention;
		float penalty;
		String date;
		int hidden;
	    String sid1;
		
		salary sal=new salary();
		salaryDao saldao=new salaryDao();
		
		System.out.println("请输入要修改的员工的id");
		sid1=s1.next();
		 int i;
	     System.out.println("修改员工id请输入1");
	     System.out.println("修改员工名字请输入2");
	     System.out.println("修改员工基础工资请输入3");
	     System.out.println("修改员工奖金百分比请输入4");
	     System.out.println("修改员工补贴百分比请输入5");
	     System.out.println("修改员工罚款请输入6");
	     System.out.println("修改员工时间请输入7");
	     System.out.println("修改员工工资信息显示或隐藏请输入8");
         i=s1.nextInt();
        
        switch (i) {
		case 1:
	       	 System.out.println("请输入修改后的员工id");
	       	 sid=s1.next();
	       	 sal.setSid(sid1);
	       	break;
		case 2:
			System.out.println("请输入修改后的员工名字");
			sname=s1.next();
			sal.setSname(sname);
			break;
		case 3:
			System.out.println("请输入修改后的基础工资");
		    basic=s1.nextFloat();
		    sal.setBasic(basic);
		    break;
		case 4:
			System.out.println("请输入修改后的奖金百分比");
			bonus=s1.nextFloat();
            sal.setBonus(bonus);
			break;
		case 5:
			System.out.println("请输入修改后的补贴百分比");
			subvention=s1.nextFloat();
			sal.setSubvention(subvention);
			break;
		case 6:
			System.out.println("请输入修改后的罚款");
			penalty=s1.nextFloat();
			sal.setPenalty(penalty);
			break;
		case 7:
			System.out.println("请输入修改后的时间");
			date=s1.next();
			sal.setDate(date);
			break;
		case 8:
			System.out.println("请输入0(显示员工工资信息)或1(隐藏员工工资信息)");
            hidden=s1.nextInt();
            sal.setHidden(hidden);
		default:
			break;
		}
        saldao.updatesal(sal, sid1, i);
		
	}
	
	//通过员工id删除员工工资信息；
	public static void delsalbyid()
	{
		String _sid;
		 Scanner s1=new Scanner(System.in);
		 System.out.println("请输入要删除的员工的id");
		 _sid=s1.next();
		 salaryDao sald=new salaryDao();
		 sald.deletesalBysid(_sid);
	}
	
	//对工资表进行操作；
	public static void sal()
	{
		int sal,sal1;
		  Scanner s1=new Scanner(System.in);
			System.out.println("查看请输入1");
			System.out.println("增加请输入2");
			System.out.println("修改请输入3");
			System.out.println("删除请输入4");
			System.out.println("返回请输入0");
			sal=s1.nextInt();
			switch (sal) {
			case 0:
				main1();
				break;
			case 1:
				findallsal();
				break;
			case 2:
				insal();
				break;
			case 3:
				upsal();
				break;
			case 4:
				delsalbyid();
				break;

			default:
				break;
			}
			System.out.println("返回请输入0");
			sal1=s1.nextInt();
			if(sal1==0)
				sal();
	}
	//工作时间表；
	//查找所有员工的工作时间表；
	public static void findalltim()
	{
		timeDao timdao=new timeDao();
		Vector<time> v=new Vector<time>();
		v=timdao.findAlltim();
	}

	//插入员工工作时间信息；
	public static void intim()
	{
		Scanner s1=new Scanner(System.in);
		String sid;
		int worktime;
		int vacate;
	    int rest;
	    int hidden;
	    
	    time tim=new time();
	    System.out.println("请输入员工id");
	    sid=s1.next();
	    System.out.println("请输入员工工作时间");
	    worktime=s1.nextInt();
	    System.out.println("请输入员工假期时间");
	    vacate=s1.nextInt();
	    System.out.println("请输入员工休息时间");
	    rest=s1.nextInt();
	    System.out.println("请输入0(显示)或1(隐藏)");
	    hidden=s1.nextInt();
	    
	    tim.setSid(sid);
	    tim.setWorktime(worktime);
	    tim.setVacate(vacate);
	    tim.setRest(rest);
	    tim.setHidden(hidden);
	    
	    timeDao timd=new timeDao();
	    timd.inserttim(tim);		
	}
	
	//修改员工工作时间表；
	public static void uptim()
	{
		Scanner s1=new Scanner(System.in);
	    String sid;
	    int worktime;
	    int vacate;
        int rest;
        int hidden;
        String sid1;
        
        time tim=new time();
        timeDao timd=new timeDao();
        //
        int i;
        System.out.println("请输入要修改的员工的id");
        sid1=s1.next();
        
        System.out.println("修改员工id请输入1");
        System.out.println("修改员工工作时间请输入2");
        System.out.println("修改员工假期请输入3");
        System.out.println("修改员工休息时间请输入4");
        System.out.println("修改0(显示)或者1(隐藏)请输入5");
         //
        i=s1.nextInt();
        switch (i) {
		case 1:
			System.out.println("请输入修改后的员工id");
			sid=s1.next();
			tim.setSid(sid);
			break;
		case 2:
			System.out.println("请输入修改后的员工工作时间");
			worktime=s1.nextInt();
			tim.setWorktime(worktime);
			break;
		case 3:
			System.out.println("请输入修改后的员工假期");
			vacate=s1.nextInt();
			tim.setVacate(vacate);
			break;
		case 4:
			System.out.println("请输入修改后的员工休息时间");
			rest=s1.nextInt();
			tim.setRest(rest);
			break;
		case 5:
			System.out.println("输入0(显示)或者1(隐藏)");
			hidden=s1.nextInt();
			tim.setHidden(hidden);
			break;

		default:
			break;
		}
        timd.updatetim(tim, sid1, i);
        //
		
	}
	//删除员工工作时间信息；
	public static void deltimbyid()
	{
		String _sid;
		 Scanner s1=new Scanner(System.in);
		 System.out.println("请输入要删除的员工的id");
		 _sid=s1.next();
		 timeDao timd=new timeDao();
		 timd.deletetimBysid(_sid);
	}
	
	//对员工工作表进行操作；
	public static void tim()
	{
		int tim,tim1;
		  Scanner s1=new Scanner(System.in);
			System.out.println("查看请输入1");
			System.out.println("增加请输入2");
			System.out.println("修改请输入3");
			System.out.println("删除请输入4");
			System.out.println("返回请输入0");
			tim=s1.nextInt();
			switch (tim) {
			case 0:
				main1();
				break;
			case 1:
				findalltim();
				break;
			case 2:
				intim();
				break;
			case 3:
				uptim();
				break;
			case 4:
				deltimbyid();
				break;

			default:
				break;
			}
			System.out.println("返回请输入0");
			tim1=s1.nextInt();
			if(tim1==0)
				tim();
	}
	//
	//主页面
	public static void main1()
	{
		int f1,f2;
		Scanner s1=new Scanner(System.in);
		System.out.println("对部门进行操作请按1");
		System.out.println("对员工进行操作请按2");
		System.out.println("对工资进行操作请按3");
		System.out.println("对工作时间进行操作请按4");
	
		f1=s1.nextInt();
		switch (f1) {
		case 1:
			dep();
			break;
		case 2:
			sta();
			break;
		case 3:
			sal();
			break;
		case 4:
			tim();
			break;

		default:
			break;
		}
	}
	
	//
	public static void main(String[] args) throws IOException {
		main1();
		
	}
	    
	
}
