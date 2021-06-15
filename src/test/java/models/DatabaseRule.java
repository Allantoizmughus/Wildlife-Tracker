package models;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:4567/wildlife_tracker_test", "moringa", "Access");
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
