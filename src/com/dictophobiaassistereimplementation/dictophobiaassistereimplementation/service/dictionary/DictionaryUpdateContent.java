package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.dictionary;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.DictionaryDAOImpl;

public class DictionaryUpdateContent {
	private static DictionaryUpdateContent dictionaryUpdateContent = new DictionaryUpdateContent();

	public static DictionaryUpdateContent getInstance() {
		return dictionaryUpdateContent;
	}

	public boolean updateContent(int did, String content) throws SQLException {
		return DictionaryDAOImpl.getInstance().updateDictionaryContent(did, content);
	}
}
