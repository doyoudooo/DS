package shiyan8;

import java.util.Arrays;
import java.util.Scanner;

import kechengshji.dbutil;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//调用存储过程实现查询
public class a1 {
	private dbutil dbUtil=new dbutil();
	public static void main(String[] args) {
        System.out.println("请输入用餐学生学号，菜名，价格，并用逗号隔开："); 
        Scanner sc = new Scanner(System.in); 
        String input= sc.nextLine();      //1.取得用户输入的字符串 
        String arr[] =input .split(",");
        System.out.println(Arrays.toString(arr));
        a1 b=new a1();
        b.ser_reader(arr);
   }
	public void ser_reader(String[] arr)
	{	
	  Connection con=null;
	  CallableStatement cstmt = null;
      ResultSet rs = null;
      try {
		con=dbUtil.getCon();
		String sql="call  student_cook(?,?,?);";
		// 获取执行sql语句对象
		cstmt=con.prepareCall(sql);
		// 准备参数
		cstmt.setString(1, arr[0]);  
		cstmt.setString(2, arr[1]);  
		cstmt.setString(3, arr[2]);  
        rs=cstmt.executeQuery();	//执行查询给rs
        
    	while (rs.next()) {
            System.out.println("学号："+rs.getString(1)+"     姓名："+rs.getString(2)+"     餐厅："+rs.getString(3)+"     窗口号："+rs.getString(4)+"     菜名："+rs.getString(5)+"     价格："+rs.getString(6)+"     用餐时间："+rs.getString(7));

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