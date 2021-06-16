package models;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        //DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "Access");
        DB.sql2o=new Sql2o("jdbc:postgresql://ec2-52-23-45-36.compute-1.amazonaws.com:5432/d3a4kfh2ek5hms","opjfyysnghexnq","4ce549c7755a5b7efa892829719479efc2070d3c20840c70a58192dbc2296de2");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM general_animals *;";
            String deleteEndangeredQuery = "DELETE FROM general_animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteEndangeredQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}
