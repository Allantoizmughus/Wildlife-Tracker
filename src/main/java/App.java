import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://ec2-23-21-246-11.compute-1.amazonaws.com:5432/d6isspi7k46sgs";
        Sql2o sql2o = new Sql2o(connectionString, "", "");



        //display homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/index.hbs" );
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //display animal form
        get("/animal/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "addAnimal.hbs");
        },new HandlebarsTemplateEngine());

        //add new animal
        post()

    }

}
