package kechengshji;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class consumeinsert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 consumeinsert b=new consumeinsert();
		 b.ser_book();
	}
	private dbutil dbUtil=new dbutil();//创建对象，下面要用
	public void ser_book()
	{	
	  Connection con=null;
	  PreparedStatement pstmt = null;//准备发语句
	  try {
		con=dbUtil.getCon();
String sql="INSERT INTO dishes VALUES (1,'木耳炒肉','9.5'); \r\n" + 
		"" ;		// 获取执行sql语句对象
		
        pstmt=con.prepareStatement(sql);   //发语句   
        System.out.println("success");
        
        pstmt.executeUpdate(sql);
        
        // 执行查询操作
//        rs=pstmt.executeQuery();	//执行查询给rs
        //处理结果集
            }
		 catch(Exception e)
		    {
			e.printStackTrace();
		     }
		  
	}
	

}