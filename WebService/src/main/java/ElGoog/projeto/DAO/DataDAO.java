package ElGoog.projeto.DAO;

import ElGoog.projeto.API.Data;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;


@RegisterRowMapper(ProductMapper.class)
public interface DataDAO {
    //CREATE
    @SqlUpdate("insert into graph (id, date, value) values (:id, :date , :value)")
    @GetGeneratedKeys
    long insert (@BindBean Data data);

    //READ
    @SqlQuery("select * from graph")
    List<Data> getAllData();

    //READ
    @SqlQuery("select * from graph where id = :id ")
    Data findById(@Bind("id")long id);

    //UPDATE
    @SqlUpdate("update graph set date = :date, value = :value where id = :id")
    void updateData(@BindBean Data data);

    //DELETE
    @SqlUpdate("delete from graph where id = :id")
    void deleteData(@BindBean Data data);

}

