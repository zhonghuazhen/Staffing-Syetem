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
    //���ţ�
	//�������в�����Ϣ
	public static void findalldep()
	{
		   departmentDao ddao=new departmentDao();
			Vector<department> v=new Vector<department>();
			v=ddao.findAllDep();
			//for(department d:v)
			//System.out.println(d.getDname());
	}
	//���Ӳ�����Ϣ��
	public static void indep()
	{
		Scanner s1=new Scanner(System.in);
		String did;
		String dname;
		int hidden;
		department dep=new department();
		System.out.println("�����벿��id");
		did=s1.next();
		System.out.println("�����벿������");
		dname=s1.next();
		System.out.println("������0(��ʾ������Ϣ)��1(���ز�����Ϣ)");
		hidden=s1.nextInt();
		//
		dep.setDid(did);
		dep.setDname(dname);
		dep.setHidden(hidden);
		//
		departmentDao depd=new departmentDao();
		depd.insertdep(dep);
		
	}
	//�޸Ĳ�����Ϣ��
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
		 System.out.println("������Ҫ�޸ĵĲ��ŵ�id");
	     did1=s1.next();
	     System.out.println("�޸Ĳ���id������1");
	     System.out.println("�޸�����������2");
	     System.out.println("�޸���ʾ��������������3");
	     //
	     i=s1.nextInt();
	     switch(i)
	     {
	     case 1:
	    	 System.out.println("�����벿���޸ĺ��id");
	    	 did=s1.next();
	    	 dep.setDid(did);
	    	 break;
	     case 2:
	    	 System.out.println("�����벿���޸ĺ������");
	    	 dname=s1.next();
	    	 dep.setDname(dname);
	    	 break;
	     case 3:
	    	 System.out.println("�����벿���޸ĺ��Ƿ���ʾ��������");
	    	 hidden=s1.nextInt();
	    	 dep.setHidden(hidden);
	    	 break;
	     }
	     depd.updatedep(dep,did1, i);
	}
	//ͨ��didɾ��������Ϣ��
	public static void deldepbydid()
	{
		String _did;
		 Scanner s1=new Scanner(System.in);
		 System.out.println("������Ҫɾ���Ĳ��ŵ�id");
		 _did=s1.next();
		 departmentDao depd=new departmentDao();
		 depd.deleteDepBydid(_did);
	}
    //�Բ��ű���в�����
	public static void dep()
	{
		int dep,d1;
		Scanner s1=new Scanner(System.in);
		System.out.println("�鿴������1");
		System.out.println("����������2");
		System.out.println("�޸�������3");
		System.out.println("ɾ��������4");
		System.out.println("�����밴0");
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
		System.out.println("�����밴0");
		d1=s1.nextInt();
		if(d1==0)
			dep();
			
		
	}
	
	//Ա����
	//��������Ա����Ϣ��
	public static void findallstaff()
	{
		
		 staffDao sdao=new staffDao();
			Vector<staff> v=new Vector<staff>();
			v=sdao.findAllSta();
			//ֻ��ʾ����һ�����ݣ�
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

	//����Ա����Ϣ��
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
	    System.out.println("�����벿��id");
	    did=s1.next();
	    System.out.println("������Ա��id");
	    sid=s1.next();
	    System.out.println("������Ա������");
	    sname=s1.next();
	    System.out.println("����������");
	    spass=s1.next();
	    System.out.println("�������Ա�");
	    sex=s1.next();
	    System.out.println("����������");
	    age=s1.nextInt();
	    System.out.println("������ְλ");
	    zhiwu=s1.next();
	    System.out.println("������绰����");
	    tel=s1.nextInt();
	    System.out.println("����������");
	    email=s1.next();
	    System.out.println("������Ȩ��");
	    superuser=s1.nextInt();
	    System.out.println("������0(��ʾ��Ϣ)��1(������Ϣ)");
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
	

	//�޸�Ա����Ϣ���ԣ�
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
	     //�޸Ĳ��ԣ�
	   //**************************
	     int i;
	     System.out.println("�޸�Ա������id������1");
	     System.out.println("�޸�Ա������������2");
	     System.out.println("�޸�Ա������������3");
	     System.out.println("�޸�Ա���Ա�������4");
	     System.out.println("�޸�Ա������������5");
	     System.out.println("�޸�Ա��ְ��������6");
	     System.out.println("�޸�Ա���绰����������7");
	     System.out.println("�޸�Ա������������8");
	     System.out.println("�޸�Ա��Ȩ��������9");
	     System.out.println("�޸�Ա����Ϣ��ʾ������������10");
        i=s1.nextInt();
        
        //
        switch(i)
        {
        case 1:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ�Ĳ���id");
       	 did=s1.next();
       	 sta.setSid(sid);
       	 sta.setDid(did);
       	 break;
        case 2:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա������");
       	 sname=s1.next();
       	 sta.setSid(sid);
       	 sta.setSname(sname);
       	 break;
        case 3:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա������");
       	 spass=s1.next();
       	 sta.setSid(sid);
       	 sta.setSpass(spass);
       	 break;
        case 4:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա���Ա�");
       	 sex=s1.next();
       	 sta.setSid(sid);
       	 sta.setSex(sex);
       	 break;
        case 5:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա������");
       	 age=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setAge(age);
       	 break;
        case 6:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա��ְ��");
       	 zhiwu=s1.next();
       	 sta.setSid(sid);
       	 sta.setZhiwu(zhiwu);
       	 break;
        case 7:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա���绰����");
       	 tel=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setTel(tel);
       	 break;
        case 8:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա������");
       	 email=s1.next();
       	 sta.setSid(sid);
       	 sta.setEmail(email);
       	 break;
        case 9:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������Ҫ�޸ĺ��Ա��Ȩ��");
       	 superuser=s1.nextInt();
       	 sta.setSid(sid);
       	 sta.setSuperuser(superuser);
       	 break;
        case 10:
       	 System.out.println("������Ա��id");
       	 sid=s1.next();
       	 System.out.println("������0(��ʾԱ����Ϣ)������1(����Ա����Ϣ)");
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
//ͨ������ɾ��Ա����Ϣ��
	public static void destabyname()
	{    String _name;
	  Scanner s1=new Scanner(System.in);
	  System.out.println("������Ҫɾ����Ա��������");
	  _name=s1.next();
		staffDao sta=new staffDao();
		sta.deletestaByName(_name);
	}
//ͨ��Ա��idɾ��Ա����Ϣ��
	public static void destabyid()
	{
		 String _sid;
		  Scanner s1=new Scanner(System.in);
		  System.out.println("������Ҫɾ����Ա����id");
		  _sid=s1.next();
			staffDao sta=new staffDao();
			sta.deletestaByName(_sid);
		
	}
	//��Ա������в���
	public static void sta()
	{   int sta,sta1;
	    Scanner s1=new Scanner(System.in);
		System.out.println("�鿴������1");
		System.out.println("����������2");
		System.out.println("�޸�������3");
		System.out.println("ɾ��������4");
		System.out.println("����������0");
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
		System.out.println("����������0");
		sta1=s1.nextInt();
		if(sta1==0)
			sta();
	}
//ҳ����ʾ;
	
	//���ʱ�
	//��ʾ����Ա���Ĺ������
	public static void findallsal()
	{
		salaryDao saldao=new salaryDao();
		Vector<salary> v=new Vector<salary>();
		v=saldao.findAllsal();
	}
	
	//����Ա��������Ϣ
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
		System.out.println("������Ա��id");
		sid=s1.next();
		System.out.println("������Ա������");
		sname=s1.next();
		System.out.println("�������������");
		basic=s1.nextFloat();
		System.out.println("�����뽱��ٷֱ�");
		bonus=s1.nextFloat();
		System.out.println("�����벹���ٷֱ�");
		subvention=s1.nextFloat();
		System.out.println("�����뷣��");
		penalty=s1.nextFloat();
		System.out.println("��������-��-��");
		date=s1.next();
	    System.out.println("������0(��ʾ��Ϣ)��1(������Ϣ)");
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
	//�޸�Ա��������Ϣ
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
		
		System.out.println("������Ҫ�޸ĵ�Ա����id");
		sid1=s1.next();
		 int i;
	     System.out.println("�޸�Ա��id������1");
	     System.out.println("�޸�Ա������������2");
	     System.out.println("�޸�Ա����������������3");
	     System.out.println("�޸�Ա������ٷֱ�������4");
	     System.out.println("�޸�Ա�������ٷֱ�������5");
	     System.out.println("�޸�Ա������������6");
	     System.out.println("�޸�Ա��ʱ��������7");
	     System.out.println("�޸�Ա��������Ϣ��ʾ������������8");
         i=s1.nextInt();
        
        switch (i) {
		case 1:
	       	 System.out.println("�������޸ĺ��Ա��id");
	       	 sid=s1.next();
	       	 sal.setSid(sid1);
	       	break;
		case 2:
			System.out.println("�������޸ĺ��Ա������");
			sname=s1.next();
			sal.setSname(sname);
			break;
		case 3:
			System.out.println("�������޸ĺ�Ļ�������");
		    basic=s1.nextFloat();
		    sal.setBasic(basic);
		    break;
		case 4:
			System.out.println("�������޸ĺ�Ľ���ٷֱ�");
			bonus=s1.nextFloat();
            sal.setBonus(bonus);
			break;
		case 5:
			System.out.println("�������޸ĺ�Ĳ����ٷֱ�");
			subvention=s1.nextFloat();
			sal.setSubvention(subvention);
			break;
		case 6:
			System.out.println("�������޸ĺ�ķ���");
			penalty=s1.nextFloat();
			sal.setPenalty(penalty);
			break;
		case 7:
			System.out.println("�������޸ĺ��ʱ��");
			date=s1.next();
			sal.setDate(date);
			break;
		case 8:
			System.out.println("������0(��ʾԱ��������Ϣ)��1(����Ա��������Ϣ)");
            hidden=s1.nextInt();
            sal.setHidden(hidden);
		default:
			break;
		}
        saldao.updatesal(sal, sid1, i);
		
	}
	
	//ͨ��Ա��idɾ��Ա��������Ϣ��
	public static void delsalbyid()
	{
		String _sid;
		 Scanner s1=new Scanner(System.in);
		 System.out.println("������Ҫɾ����Ա����id");
		 _sid=s1.next();
		 salaryDao sald=new salaryDao();
		 sald.deletesalBysid(_sid);
	}
	
	//�Թ��ʱ���в�����
	public static void sal()
	{
		int sal,sal1;
		  Scanner s1=new Scanner(System.in);
			System.out.println("�鿴������1");
			System.out.println("����������2");
			System.out.println("�޸�������3");
			System.out.println("ɾ��������4");
			System.out.println("����������0");
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
			System.out.println("����������0");
			sal1=s1.nextInt();
			if(sal1==0)
				sal();
	}
	//����ʱ���
	//��������Ա���Ĺ���ʱ���
	public static void findalltim()
	{
		timeDao timdao=new timeDao();
		Vector<time> v=new Vector<time>();
		v=timdao.findAlltim();
	}

	//����Ա������ʱ����Ϣ��
	public static void intim()
	{
		Scanner s1=new Scanner(System.in);
		String sid;
		int worktime;
		int vacate;
	    int rest;
	    int hidden;
	    
	    time tim=new time();
	    System.out.println("������Ա��id");
	    sid=s1.next();
	    System.out.println("������Ա������ʱ��");
	    worktime=s1.nextInt();
	    System.out.println("������Ա������ʱ��");
	    vacate=s1.nextInt();
	    System.out.println("������Ա����Ϣʱ��");
	    rest=s1.nextInt();
	    System.out.println("������0(��ʾ)��1(����)");
	    hidden=s1.nextInt();
	    
	    tim.setSid(sid);
	    tim.setWorktime(worktime);
	    tim.setVacate(vacate);
	    tim.setRest(rest);
	    tim.setHidden(hidden);
	    
	    timeDao timd=new timeDao();
	    timd.inserttim(tim);		
	}
	
	//�޸�Ա������ʱ���
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
        System.out.println("������Ҫ�޸ĵ�Ա����id");
        sid1=s1.next();
        
        System.out.println("�޸�Ա��id������1");
        System.out.println("�޸�Ա������ʱ��������2");
        System.out.println("�޸�Ա������������3");
        System.out.println("�޸�Ա����Ϣʱ��������4");
        System.out.println("�޸�0(��ʾ)����1(����)������5");
         //
        i=s1.nextInt();
        switch (i) {
		case 1:
			System.out.println("�������޸ĺ��Ա��id");
			sid=s1.next();
			tim.setSid(sid);
			break;
		case 2:
			System.out.println("�������޸ĺ��Ա������ʱ��");
			worktime=s1.nextInt();
			tim.setWorktime(worktime);
			break;
		case 3:
			System.out.println("�������޸ĺ��Ա������");
			vacate=s1.nextInt();
			tim.setVacate(vacate);
			break;
		case 4:
			System.out.println("�������޸ĺ��Ա����Ϣʱ��");
			rest=s1.nextInt();
			tim.setRest(rest);
			break;
		case 5:
			System.out.println("����0(��ʾ)����1(����)");
			hidden=s1.nextInt();
			tim.setHidden(hidden);
			break;

		default:
			break;
		}
        timd.updatetim(tim, sid1, i);
        //
		
	}
	//ɾ��Ա������ʱ����Ϣ��
	public static void deltimbyid()
	{
		String _sid;
		 Scanner s1=new Scanner(System.in);
		 System.out.println("������Ҫɾ����Ա����id");
		 _sid=s1.next();
		 timeDao timd=new timeDao();
		 timd.deletetimBysid(_sid);
	}
	
	//��Ա����������в�����
	public static void tim()
	{
		int tim,tim1;
		  Scanner s1=new Scanner(System.in);
			System.out.println("�鿴������1");
			System.out.println("����������2");
			System.out.println("�޸�������3");
			System.out.println("ɾ��������4");
			System.out.println("����������0");
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
			System.out.println("����������0");
			tim1=s1.nextInt();
			if(tim1==0)
				tim();
	}
	//
	//��ҳ��
	public static void main1()
	{
		int f1,f2;
		Scanner s1=new Scanner(System.in);
		System.out.println("�Բ��Ž��в����밴1");
		System.out.println("��Ա�����в����밴2");
		System.out.println("�Թ��ʽ��в����밴3");
		System.out.println("�Թ���ʱ����в����밴4");
	
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
