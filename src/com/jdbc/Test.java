package com.jdbc;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		try {
			DianHuaBenDao dianHuaBenDao = new DianHuaBenDao();
			
			//�������
/*			Phone phone = new Phone();
			phone.setName("С��");
			phone.setPhone("110");
			phone.setAddress("������");
			phone.setEmail("xiaogu@163.com");
			dianHuaBenDao.add(phone);*/
			//ɾ������
/*			Phone phone = new Phone();
			phone.setName("С��");
			boolean b = dianHuaBenDao.del(phone);*/
			//��������
			Phone phone = new Phone();
			phone.setName("С��");//�Ȳ�ѯ��Ҫ���ĵ���Ϣ
			Phone gg = new Phone();
			gg.setAddress("����");
			gg.setPhone("120");
			List<Phone> phones = dianHuaBenDao.query(phone);
			dianHuaBenDao.update(phones.get(0),gg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
