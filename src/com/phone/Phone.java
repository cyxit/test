package com.phone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Phone {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取链接
			String url = "jdbc:mysql://120.76.155.46:3306/test?useUnicode=true&characterEncoding=UTF-8";
			String userName = "test";
			String password = "test";
			conn = java.sql.DriverManager.getConnection(url, userName, password);
			
			//创建对话
			Statement statement = conn.createStatement();
//			//增加数据
//			statement.addBatch("insert into phone_c(phone,name,email,address)values(?,?,?,?)");
//			int[] a = statement.executeBatch();
//			//删除数据
//			statement.addBatch("delete from phone_c where name = 'peter'");
//			int[] c = statement.executeBatch();
//			
//			//改数据
//			statement.addBatch("update phone_c set phone ='6665' where name = 'peter' ");
//			int[] d = statement.executeBatch();
//			
			//查询数据
			ResultSet b = statement.executeQuery("select*from phone_c");
			while (b.next()) {
				String phone = b.getString("phone");
				String name = b.getString("name");
				String email = b.getString("email");
				String address = b.getString("address");
				System.out.println("phone="+phone+" name="+name+" email="+email+" address="+address);
			}
			//关闭资源
			conn.close();
		} catch (Exception e) {
			System.out.println("驱动加载失败！！");
			e.printStackTrace();
		}
	}
}
