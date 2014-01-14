package com.manh.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/* 
 * This class will convert database rows into JSON format .
 * 
 * 
 */
public class ToJSON {

	/*
	 * This will convert database records into a JSON array. Simply pass in a
	 * resultset froma database connection and it loop through and return a json
	 * array.
	 * 
	 * @param rs= database resultset
	 * 
	 * @return JSONArray
	 * 
	 * @throws Exception
	 */

	public JSONArray ToJSONArray(ResultSet rs) throws Exception {

		JSONArray jsonArray = new JSONArray();
		try {

			ResultSetMetaData rsMetadata = rs.getMetaData();
			while (rs.next()) {
				int numofColumns = rsMetadata.getColumnCount();
				JSONObject obj = new JSONObject();
				for (int i = 1; i < numofColumns + 1; i++) {
					String column_name = rsMetadata.getColumnName(i);
					if (rsMetadata.getColumnType(i) == java.sql.Types.ARRAY) {
						obj.put(column_name, rs.getArray(column_name));
					}

					else if (rsMetadata.getColumnType(i) == java.sql.Types.BIGINT) {
						obj.put(column_name, rs.getInt(column_name));
					} else if (rsMetadata.getColumnType(i) == java.sql.Types.BOOLEAN) {
						obj.put(column_name, rs.getBoolean(column_name));
					}

					else if (rsMetadata.getColumnType(i) == java.sql.Types.BLOB) {

						obj.put(column_name, rs.getBlob(column_name));
					} else if (rsMetadata.getColumnType(i) == java.sql.Types.FLOAT) {
						obj.put(column_name, rs.getFloat(column_name));
					}

					else if (rsMetadata.getColumnType(i) == java.sql.Types.DOUBLE) {
						obj.put(column_name, rs.getDouble(column_name));
					} else if (rsMetadata.getColumnType(i) == java.sql.Types.NVARCHAR) {
						obj.put(column_name, rs.getNString(column_name));
					}

					else if (rsMetadata.getColumnType(i) == java.sql.Types.VARCHAR) {
						obj.put(column_name, rs.getString(column_name));
					}

					else if (rsMetadata.getColumnType(i) == java.sql.Types.TINYINT) {
						obj.put(column_name, rs.getInt(column_name));
					}

					else if (rsMetadata.getColumnType(i) == java.sql.Types.SMALLINT) {
						obj.put(column_name, rs.getInt(column_name));

					} else if (rsMetadata.getColumnType(i) == java.sql.Types.DATE) {
						obj.put(column_name, rs.getDate(column_name));

					} else if (rsMetadata.getColumnType(i) == java.sql.Types.TIMESTAMP) {
						obj.put(column_name, rs.getTimestamp(column_name));

					} else if (rsMetadata.getColumnType(i) == java.sql.Types.NUMERIC) {
						obj.put(column_name, rs.getBigDecimal(column_name));

					} else if (rsMetadata.getColumnType(i) == java.sql.Types.INTEGER) {
						obj.put(column_name, rs.getInt(column_name));
					}

					else {
						obj.put(column_name, rs.getObject(column_name));
					}

				}
				jsonArray.put(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return jsonArray;
	}

}
