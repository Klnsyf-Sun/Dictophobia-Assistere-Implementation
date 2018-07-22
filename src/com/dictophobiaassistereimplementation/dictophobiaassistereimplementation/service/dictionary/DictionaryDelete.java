package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.dictionary;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.DictionaryDAOImpl;

public class DictionaryDelete {
	private static DictionaryDelete dictionaryDelete = new DictionaryDelete();

	public static DictionaryDelete getInstance() {
		return dictionaryDelete;
	}

	public boolean delete(int did) throws SQLException {
		return DictionaryDAOImpl.getInstance().deleteDictionary(did);
	}

}
