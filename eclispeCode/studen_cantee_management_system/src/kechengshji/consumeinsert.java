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
	private dbutil dbUtil=new dbutil();//������������Ҫ��
	public void ser_book()
	{	
	  Connection con=null;
	  PreparedStatement pstmt = null;//׼�������
	  try {
		con=dbUtil.getCon();
String sql="INSERT INTO consume VALUES ('B19041831','�Ǵ��Ź�','2020-12-31 18:26:25','13.5');\r\n" + 
		"";		// ��ȡִ��sql������
		
        pstmt=con.prepareStatement(sql);   //�����   
        System.out.println("success");
        
        pstmt.executeUpdate(sql);
        
        // ִ�в�ѯ����
//        rs=pstmt.executeQuery();	//ִ�в�ѯ��rs
        //���������
            }
		 catch(Exception e)
		    {
			e.printStackTrace();
		     }
		  
	}
	

}