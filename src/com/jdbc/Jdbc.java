package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Jdbc {
	public static void main(String [] args){
		Connection conn = null;
		try {
			//����Mysql������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			String url = "jdbc:mysql://120.76.155.46:3306/test?useUnicode=true&characterEncoding=UTF-8";
			String userName = "test";
			String password = "test";
			conn = java.sql.DriverManager.getConnection(url, userName, password);
			//�����Ի�
//			Statement statement = conn.createStatement();
//			for (int i = 0; i < 100; i++) {
//				statement.addBatch("insert into t_user(name) values ('��������')");
//			}
//			int[] b = statement.executeBatch();
			
			
			conn.setAutoCommit(false);
			PreparedStatement statement = conn.prepareStatement("insert into t_user(user_name,sex) values (?,?)");
			statement.setString(1, "С��");
			statement.setString(2, "��");
			System.out.println(statement.executeUpdate());
		
			//�����Ի�
//			Statement statement = connection.createStatement();
			//executeUpdate()���Դ�������ɾ����
//			boolean b =statement.execute("insert into t_user(user_name,password,sex)value('���','187','��')");
//			System.out.println(b);
			
			//executeQuery()����ѯ
//			ResultSet b = statement.executeQuery("select*from t_user");
//			ResultSetMetaData meta = b.getMetaData();
//			for (int i = 1; i <= meta.getColumnCount(); i++) {
//				System.out.println(meta.getColumnName(i));
//			}
//			List<List<Object>> list = new ArrayList<>();
//			while () {
//				
//				
//			}
//			
			
			//��ѯ
//			ResultSet b = statement.executeQuery("select*from t_user");
//			while (b.next()) {
//				int id = b.getInt("id");
//				String user = b.getString("user_name");
//				String passwordCopy = b.getString("password");
//				String sex = b.getString("sex");
//				String create_time = b.getString("create_time");
//				System.out.println("id="+id+",user="+user+",passwordCopy="+passwordCopy+",sex="+sex+",create_time="+create_time);
//			}
			
			//�ر���Դ
			conn.close();
		} catch (Exception e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}
}
