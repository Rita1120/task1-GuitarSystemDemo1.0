package dataBaseFactory;

import dataBaseDao.GuitarDao;
import dataBaseProxy.GuitarDaoProxy;

public class DaoFactory {
	public static GuitarDao getGuitarDaoInstance() throws Exception{
		return new GuitarDaoProxy() ;
	}
}
