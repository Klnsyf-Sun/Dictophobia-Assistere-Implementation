package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.datasource.MySQL;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Dictionary;

public class DictionaryDAOImpl implements DictionaryDAO {
	private static DictionaryDAOImpl dictionaryDAOImpl = new DictionaryDAOImpl();

	public static DictionaryDAOImpl getInstance() {
		return dictionaryDAOImpl;
	}

	@Override
	public boolean insertDictionary(Dictionary dictionary) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		sql.append("INSERT INTO dictionaries(uid,linkedPhrase,content) VALUES (").append(dictionary.getUid())
				.append(",'").append(dictionary.getLinkedPhrase()).append("','").append(dictionary.getContent())
				.append("')");
		stmt.execute(sql.toString());
		MySQL.close();
		return true;
	}

	@Override
	public List<Dictionary> queryDictionarybyUid(int uid) throws SQLException {
		List<Dictionary> dictionaries = new LinkedList<>();
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT * FROM dictionaries WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return null;
		} else {
			do {
				dictionaries.add(new Dictionary(rsts.getInt("did"), rsts.getInt("uid"), rsts.getString("linkedPhrase"),
						rsts.getString("content")));
			} while (rsts.next());
			MySQL.close();
			return dictionaries;
		}
	}

	@Override
	public boolean updateDictionaryContent(int did, String content) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT did FROM dictionaries WHERE did=").append(did);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("UPDATE dictionaries SET content='").append(content).append("' WHERE did=").append(did);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

	@Override
	public boolean deleteDictionary(int did) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT did FROM dictionaries WHERE did=").append(did);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("DELETE FROM dictionaries WHERE did=").append(did);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

}
