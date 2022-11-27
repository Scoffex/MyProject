package com.prova.dao;

import com.prova.daoimpl.PlayerDao;

public class DAOFactoryMethod {
	private IPlayerDao iPlayerDao;

	static private class InstanceHolder {
		static public DAOFactoryMethod instance = new DAOFactoryMethod();
	}

	static public DAOFactoryMethod getInstance() {
		return InstanceHolder.instance;
	}
	private DAOFactoryMethod() {
		this.iPlayerDao = new PlayerDao();
	}
	
	public IPlayerDao getPlayerDAO() {
		
		return iPlayerDao;
	}

}
