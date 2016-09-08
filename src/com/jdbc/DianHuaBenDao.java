package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DianHuaBenDao {
	
	static Connection conn = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver") ; 
			//获取链接
			String url = "jdbc:mysql://120.76.155.46:3306/test"
					+ "?useUnicode=true&characterEncoding=UTF-8";
			String userName = "test";
			String password = "test";
			conn = java.sql.DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加电话
	public boolean add(Phone phone) throws SQLException{
		PreparedStatement prepareStatement = conn.prepareStatement("insert into PHONE(name,phone,address,email) values(?,?,?,?)");
		prepareStatement.setString(1, phone.getName());
		prepareStatement.setString(2, phone.getPhone());
		prepareStatement.setString(3, phone.getAddress());
		prepareStatement.setString(4, phone.getEmail());
		int size = prepareStatement.executeUpdate();
		if (size == 0) {
			return false;
		}
		prepareStatement.close();
		return true;
	}
	
	//删除
	public boolean del(Phone phone) throws SQLException{
		PreparedStatement prepareStatement = conn.prepareStatement("delete from PHONE where name=? or phone=?");
		prepareStatement.setString(1, phone.getName());
		prepareStatement.setString(2, phone.getPhone());
		int size = prepareStatement.executeUpdate();
		if (size == 0) {
			return false;
		}
		prepareStatement.close();
		return true;
	}
	
	//修改
	public boolean update(Phone phone,Phone gg) throws SQLException{
		PreparedStatement prepareStatement = conn.prepareStatement("update PHONE set phone=?,address=?,email=? where name=?");
		prepareStatement.setString(1, gg.getPhone());
		prepareStatement.setString(2, gg.getAddress());
		prepareStatement.setString(3, gg.getEmail());
		prepareStatement.setString(4, phone.getName());
//		prepareStatement.setInt(5, phone.getId());
		int size = prepareStatement.executeUpdate();
		if (size == 0) {
			return false;
		}
		prepareStatement.close();
		return true;
	}
	
	//查询
	public List<Phone> query(Phone phone) throws SQLException{
		PreparedStatement prepareStatement = conn.
				prepareStatement("select * from PHONE where name=? or phone=?");
		prepareStatement.setString(1, phone.getName());
		prepareStatement.setString(2, phone.getPhone());
		ResultSet result = prepareStatement.executeQuery();
		List<Phone> phones = new ArrayList<>();
		Phone temp = null;
		while(result.next()){
			temp = new Phone();
			temp.setName(result.getString("name"));
			temp.setPhone(result.getString("phone"));
			temp.setAddress(result.getString("address"));
			temp.setEmail(result.getString("email"));
			phones.add(temp);
		}
		prepareStatement.close();
		return phones;
	}
}
