package kechengshji;

import java.util.Scanner;   
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//调用存储过程实现查询
public class student_consume {
	private dbutil dbUtil=new dbutil();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("请输入用餐学生学号："); 
        String rno= sc.nextLine();      //1.取得用户输入的字符串 
        student_consume b=new student_consume();
        b.ser_reader(rno);
   }
	public void ser_reader(String rn)
	{	
	  Connection con=null;
	  CallableStatement cstmt = null;
      ResultSet rs = null;

      int canborrow=0;
	  try {
		con=dbUtil.getCon();
		String sql="call  student_consume(?);";
		// 获取执行sql语句对象
		cstmt=con.prepareCall(sql);
        // 准备参数
		cstmt.setString(1, rn);  
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