package com.phone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Phone {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			String url = "jdbc:mysql://120.76.155.46:3306/test?useUnicode=true&characterEncoding=UTF-8";
			String userName = "test";
			String password = "test";
			conn = java.sql.DriverManager.getConnection(url, userName, password);
			
			//�����Ի�
			Statement statement = conn.createStatement();
//			//��������
//			statement.addBatch("insert into phone_c(phone,name,email,address)values(?,?,?,?)");
//			int[] a = statement.executeBatch();
//			//ɾ������
//			statement.addBatch("delete from phone_c where name = 'peter'");
//			int[] c = statement.executeBatch();
//			
//			//������
//			statement.addBatch("update phone_c set phone ='6665' where name = 'peter' ");
//			int[] d = statement.executeBatch();
//			
			//��ѯ����
			ResultSet b = statement.executeQuery("select*from phone_c");
			while (b.next()) {
				String phone = b.getString("phone");
				String name = b.getString("name");
				String email = b.getString("email");
				String address = b.getString("address");
				System.out.println("phone="+phone+" name="+name+" email="+email+" address="+address);
			}
			//�ر���Դ
			conn.close();
		} catch (Exception e) {
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
