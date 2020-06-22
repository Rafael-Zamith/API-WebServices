package ElGoog.projeto.DAO;

import ElGoog.projeto.API.Data;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;


@RegisterRowMapper(ProductMapper.class)
public interface DataDAO {
    @SqlUpdate("insert into graph (date, value) values (:date , :value)")
    @GetGeneratedKeys
    long insert (@BindBean Data data);

    @SqlQuery("select * from graph")
    List<Data> getAllData();

    @SqlQuery("select * from graph where id = :id ")
    Data findById(@Bind("id")long id);

    @SqlUpdate("delete from graph where id = :id")
    boolean delete(@Bind("id") long graphId);

}

