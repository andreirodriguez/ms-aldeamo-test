package pe.aldeamo.test.repository.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.aldeamo.test.application.domain.ArrayGlass;
import pe.aldeamo.test.repository.interfaces.ArrayGlassRepository;
import pe.aldeamo.test.repository.interfaces.SQLHelper;

@Repository
public class ArrayGlassRepositoryImp implements ArrayGlassRepository {

	@Autowired
	private SQLHelper sqlHelper;

	@Override
	public ArrayGlass getSearch(Map<String,Object> parametersJson) {
		ArrayGlass o = sqlHelper.getSearch("array_search", parametersJson, new ArrayGlassSearchRowMapper());

		return o;
	}
	
	static class ArrayGlassSearchRowMapper implements RowMapper<ArrayGlass> {
		@Override
		public ArrayGlass mapRow(ResultSet r, int row) throws SQLException {
			ArrayGlass o = new ArrayGlass();

			o.setId(r.getInt("id"));
			o.setInputArray(r.getString("input_array"));

			return o;
		}
	}	
}
