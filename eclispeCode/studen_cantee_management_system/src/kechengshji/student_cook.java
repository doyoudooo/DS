package kechengshji;

import java.util.Arrays;
import java.util.Scanner;   
import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//���ô洢����ʵ�ֲ�ѯ
 class student_cook {
	private dbutil dbUtil=new dbutil();
	public static void main(String[] args) {
        System.out.println("�������ò�ѧ��ѧ�ţ����������������ö��Ÿ�����"); 
        Scanner sc = new Scanner(System.in); 
        String input= sc.nextLine();      //1.ȡ���û�������ַ��� 
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
		// ��ȡִ��sql������
		cstmt=con.prepareCall(sql);
		// ׼������
		cstmt.setString(1, arr[0]);  
		cstmt.setString(2, arr[1]);  
		cstmt.setString(3, arr[2]);  
        rs=cstmt.execute();	//ִ�в�ѯ��rs        
       System.out.println("����ɹ�"); 
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