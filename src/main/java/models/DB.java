package models;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "Access");
    //public static Sql2o sql2o=new Sql2o("jdbc:postgresql://ec2-52-23-45-36.compute-1.amazonaws.com:5432/d3a4kfh2ek5hms","opjfyysnghexnq","4ce549c7755a5b7efa892829719479efc2070d3c20840c70a58192dbc2296de2");
}
