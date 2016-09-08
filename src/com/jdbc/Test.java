package com.jdbc;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		try {
			DianHuaBenDao dianHuaBenDao = new DianHuaBenDao();
			
			//添加数据
/*			Phone phone = new Phone();
			phone.setName("小夏");
			phone.setPhone("110");
			phone.setAddress("深圳市");
			phone.setEmail("xiaogu@163.com");
			dianHuaBenDao.add(phone);*/
			//删除数据
/*			Phone phone = new Phone();
			phone.setName("小雨");
			boolean b = dianHuaBenDao.del(phone);*/
			//更改数据
			Phone phone = new Phone();
			phone.setName("小骨");//先查询想要更改的信息
			Phone gg = new Phone();
			gg.setAddress("西乡");
			gg.setPhone("120");
			List<Phone> phones = dianHuaBenDao.query(phone);
			dianHuaBenDao.update(phones.get(0),gg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
