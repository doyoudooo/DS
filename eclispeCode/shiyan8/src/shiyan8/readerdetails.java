package shiyan8;

import java.util.Scanner;   
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//���ô洢����ʵ�ֲ�ѯ
public class readerdetails {
	private DButil dbUtil=new DButil();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("��������߱�ţ�"); 
        String rno= sc.nextLine();      //1.ȡ���û�������ַ��� 
        readerdetails b=new readerdetails();
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
		String sql="call  booksborrow(?);";
		// ��ȡִ��sql������
		cstmt=con.prepareCall(sql);
        // ׼������
		cstmt.setString(1, rn);  
        rs=cstmt.executeQuery();	//ִ�в�ѯ��rs

    	while (rs.next()) {
            System.out.println("bookname��"+rs.getString(1)+"     auther��"+rs.getString(2)+"     price��"+rs.getString(3)+"     bookno��"+rs.getString(4));

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