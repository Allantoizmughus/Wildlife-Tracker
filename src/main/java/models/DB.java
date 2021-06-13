package models;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-23-21-246-11.compute-1.amazonaws.com:5432/d6isspi7k46sgs", "ldbgmlsfrumefc",  "9f195ab9c22336597bcebf199bba05cf8215cc0ec369c413b42afad28bf85992");
}
