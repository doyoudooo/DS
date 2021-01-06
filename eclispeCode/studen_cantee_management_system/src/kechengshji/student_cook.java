package kechengshji;

import java.util.Arrays;
import java.util.Scanner;   
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//调用存储过程实现查询
 class student_cook {
	private dbutil dbUtil=new dbutil();
	public static void main(String[] args) {
        System.out.println("请输入用餐学生学号，菜名，个数，并用逗号隔开："); 
        Scanner sc = new Scanner(System.in); 
        String input= sc.nextLine();      //1.取得用户输入的字符串 
        String arr[] =input .split(",");
        System.out.println(Arrays.toString(arr));
        student_cook b=new student_cook();
        b.ser_reader(arr);
   }
	public void ser_reader(String[] arr)
	{	
	  Connection con=null;
	  CallableStatement cstmt = null;
      boolean rs = false;
      try {
		con=dbUtil.getCon();
		String sql="call  ordering(?,?,?);";
		// 获取执行sql语句对象
		cstmt=con.prepareCall(sql);
		// 准备参数
		cstmt.setString(1, arr[0]);  
		cstmt.setString(2, arr[1]);  
		cstmt.setString(3, arr[2]);  
        rs=cstmt.execute();	//执行查询给rs        
       System.out.println("插入成功"); 
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