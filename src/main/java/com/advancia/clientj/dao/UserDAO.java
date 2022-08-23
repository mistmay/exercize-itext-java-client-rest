package com.advancia.clientj.dao;

import java.util.ArrayList;
import java.util.List;

import com.advancia.clientj.model.User;

public class UserDAO {
	public static List<User> getUserList() {
		List<User> list = new ArrayList<>();
		list.add(new User("Giuseppe", "Marchesiello", 32));
		list.add(new User("Germano", "Maestri", 27));
		list.add(new User("Pinco", "Paillino", 15));
		return list;
	}
}
