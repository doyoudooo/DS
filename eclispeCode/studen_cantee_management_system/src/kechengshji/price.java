package kechengshji;

import java.awt.Transparency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class price {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 price b=new price();
		 b.ser_book();
	}
	private dbutil dbUtil=new dbutil();//创建对象，下面要用
	public void ser_book()
	{	
	  Connection con=null;
	  PreparedStatement pstmt = null;//准备发语句
      ResultSet rs = null;
	  try {
			con=dbUtil.getCon();
		String sql="SELECT dishnum*dprice FROM price\r\n" + 
				"";
		// 获取执行sql语句对象
        pstmt=con.prepareStatement(sql);   //发语句   
        // 执行查询操作
        rs=pstmt.executeQuery();	//执行查询给rs
        //处理结果集
        while (rs.next()) {         	
            System.out.println("每一个订单的价格："+rs.getString(1) );
            /*								第一列							第二列	
             * varchar》串》getstring，否则getint。。			
             */
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
