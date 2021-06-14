import models.Animal;
import models.Endangered;
import models.Sighting;
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
        post("animal/add",(request, response) -> {
            boolean endangered = request.queryParams("endangered")!=null;
            if (endangered) {
                String name = request.queryParams("name");
                int id =Integer.parseInt(request.queryParams("id"));
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                Endangered endangeredAnimal = new Endangered(name,id,endangered,health,age);
                endangeredAnimal.save();
            } else {
                String name = request.queryParams("name");
                Animal animal = new Animal(name);
                animal.save();
            }
            response.redirect("/");
            return null;
        });

        //processing new endangered form
        post("/endangered_animal",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int animal_id = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String RangerName = request.queryParams("RangerName");
            int id=Integer.parseInt(request.queryParams("id"));
            Sighting newSighting = new Sighting(animal_id, location, RangerName,id);
            newSighting.save();
            model.put("newSighting",newSighting);
            model.put("animals", Animal.all());
            String animal = Animal.find(animal_id).getName();
            model.put("animal", animal);
            return new ModelAndView(model, "allAnimals.hbs");
        },new HandlebarsTemplateEngine());

        //processing sighting form
        post("/sighting/add",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int animal_id = Integer.parseInt(request.queryParams("animalSelected"));
            String location = request.queryParams("location");
            String RangerName=request.queryParams("RangerName");
            int id=Integer.parseInt(request.queryParams("id"));
            Sighting newSighting = new Sighting(animal_id, location, RangerName,id);
            newSighting.save();
            model.put("newSighting",newSighting);
            return new ModelAndView(model, "allSightings.hbs");
        },new HandlebarsTemplateEngine());

        //display sighting form
        get("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("endangeredAnimals", Endangered.all());
            return new ModelAndView(model, "allSightings.hbs");
        },new HandlebarsTemplateEngine());
    }

}
