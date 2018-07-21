package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.dictionary;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.DictionaryDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Dictionary;

public class DictionaryInsert {
	private static DictionaryInsert dictionaryInsert = new DictionaryInsert();

	public static DictionaryInsert getInstance() {
		return dictionaryInsert;
	}

	public boolean insert(Dictionary dictionary) throws SQLException {
		return DictionaryDAOImpl.getInstance().insertDictionary(dictionary);
	}
}
