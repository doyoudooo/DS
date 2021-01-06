package shiyan8;

import java.util.Scanner;

import kechengshji.dbutil;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//调用存储过程实现查询
public class stu_cook {
	private dbutil dbUtil=new dbutil();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("请输入用餐学生学号："); 
        String sno= sc.nextLine();      //1.取得用户输入的字符串 
        System.out.println("请输入菜名编号："); 
        String cname= sc.nextLine();      //1.取得用户输入的字符串 
        System.out.println("请输入价格编号："); 
        String dprice= sc.nextLine();      //1.取得用户输入的字符串 

        stu_cook b=new stu_cook();
        b.ser_reader(sno,cname,dprice);
   }
	public void ser_reader(String sno,String cname,String dprice)
	{	
	  Connection con=null;
	  CallableStatement cstmt = null;
      ResultSet rs = null;

      int canborrow=0;
	  try {
		con=dbUtil.getCon();
		String sql="call  student_cook(?,?,?);";
		// 获取执行sql语句对象
		cstmt=con.prepareCall(sql);
        // 准备参数
		cstmt.setString(1, sno);  
		cstmt.setString(2, cname);  
		cstmt.setString(3, dprice);  
        rs=cstmt.executeQuery();	//执行查询给rs

    	while (rs.next()) {
            System.out.println("bookname："+rs.getString(1)+"     auther："+rs.getString(2)+"     price："+rs.getString(3)+"     bookno："+rs.getString(4));

		}
        
         }
		 catch(Exception e)
		    {
			e.printStackTrace();
		     }
		   finally
		   {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}