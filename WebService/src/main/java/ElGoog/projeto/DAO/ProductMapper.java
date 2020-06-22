package ElGoog.projeto.DAO;

import ElGoog.projeto.API.Data;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper <Data> {
    public Data map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Data(
                rs.getLong("id"),
                rs.getString("date"),
                rs.getDouble("value")
        );
    }
}
