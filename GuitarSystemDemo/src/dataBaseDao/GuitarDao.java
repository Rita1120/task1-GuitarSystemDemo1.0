package dataBaseDao;

import java.util.List;
import dataBaseTable.Guitar;

public interface GuitarDao {
	public List<Guitar> findAll(String keyWord) throws Exception;
}
