package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.dictionary;

import java.sql.SQLException;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.DictionaryDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Dictionary;

public class DictionaryQueryByUid {
	private static DictionaryQueryByUid dictionaryQueryByUid = new DictionaryQueryByUid();

	public static DictionaryQueryByUid getInstance() {
		return dictionaryQueryByUid;
	}

	public List<Dictionary> queryByUid(int uid) throws SQLException {
		return DictionaryDAOImpl.getInstance().queryDictionarybyUid(uid);
	}
}
