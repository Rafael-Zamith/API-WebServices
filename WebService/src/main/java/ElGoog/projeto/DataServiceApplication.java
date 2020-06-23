package ElGoog.projeto;


import ElGoog.projeto.API.Data;
import ElGoog.projeto.DAO.DataDAO;
import ElGoog.projeto.Resources.DataResources;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.jdbi.v3.core.Jdbi;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Hello world!
 *
 */
public class DataServiceApplication extends Application<DataServiceConfiguration> {
    public static void main( String[] args ) {
        try{
            (new DataServiceApplication()).run(args);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String getName(){
        return "Dataservice";
    }

    public void initialize (final Bootstrap<DataServiceConfiguration> bootstrap){
        bootstrap.addBundle(new MigrationsBundle<DataServiceConfiguration>() {
            @Override
            public void run(DataServiceConfiguration productServiceConfiguration, Environment environment) throws Exception {
            }

            @Override
            public DataSourceFactory getDataSourceFactory(DataServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            @Override
            public String name() {
                return "db";
            }
        });
    }

    @Override
    public void run(final DataServiceConfiguration configuration, final Environment environment){
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "db");
        DataDAO dataDAO = jdbi.onDemand(DataDAO.class);

        DataResources dataResources = new DataResources(dataDAO);
        environment.jersey().register(dataResources);

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}

