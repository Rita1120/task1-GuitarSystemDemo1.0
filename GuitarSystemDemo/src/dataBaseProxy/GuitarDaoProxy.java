package dataBaseProxy;

import java.util.List;

import dataBaseDao.GuitarDao;
import dataBaseImpl.GuitarDaoImpl;
import dataBaseTable.Guitar;
import dataBaseUtil.DbUtil;

public class GuitarDaoProxy implements GuitarDao {
	private DbUtil dbc = null;
	private GuitarDao dao = null;

	public GuitarDaoProxy() throws Exception {
		this.dbc = new DbUtil();
		this.dao = new GuitarDaoImpl(this.dbc.getConnection());
	}
	@Override
	public List<Guitar> findAll(String keyWord) throws Exception {
		List<Guitar> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
