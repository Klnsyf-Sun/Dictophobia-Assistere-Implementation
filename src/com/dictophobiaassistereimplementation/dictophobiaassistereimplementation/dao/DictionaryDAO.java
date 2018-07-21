package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao;

import java.sql.SQLException;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Dictionary;

public interface DictionaryDAO {
	public boolean insertDictionary(Dictionary dictionary) throws SQLException;

	public List<Dictionary> queryDictionarybyUid(int uid) throws SQLException;

	public boolean updateDictionaryContent(int did, String content) throws SQLException;
}
