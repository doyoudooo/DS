package shiyan8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class booksinsert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 booksinsert b=new booksinsert();
		 b.ser_book();
	}
	private DButil dbUtil=new DButil();//创建对象，下面要用
	public void ser_book()
	{	
	  Connection con=null;
	  PreparedStatement pstmt = null;//准备发语句
	  try {
		con=dbUtil.getCon();
String sql="INSERT  INTO `book`  VALUES ('ISBN97871 ','数据库系统','李晖','机械',2010,'69.0','未借','2'); ";		// 获取执行sql语句对象
		
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