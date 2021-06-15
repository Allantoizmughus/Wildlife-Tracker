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
        //String connectionString = "jdbc:postgresql://localhost:4567/wildlife_tracker?user=moringa&password=Access";
        //Sql2o sql2o = new Sql2o(connectionString, "", "");



        //display homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", Animal.all());
            model.put("endangered", Endangered.all());
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //display animal form
        get("/animal/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "addAnimal.hbs");
        },new HandlebarsTemplateEngine());

        //add new animal
        post("animal/new",(request, response) -> {
            boolean endangered = request.queryParams("endangered")!=null;
            if (endangered) {
                String name = request.queryParams("name");
                int id =Integer.parseInt(request.queryParams("id"));
                String health=request.queryParams("health");
                String age=request.queryParams("age");
                Endangered endangeredAnimal = new Endangered(name,id, true,health,age);
                endangeredAnimal.save();
            } else {
                String name = request.queryParams("name");
                int id =Integer.parseInt(request.queryParams("id"));
                Animal animal =new Animal("name",id);
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
            String rangerName = request.queryParams("rangerName");
            int id=Integer.parseInt(request.queryParams("id"));
            Sighting newSighting = new Sighting(animal_id, location, rangerName,id);
            newSighting.save();
            //model.put("newSighting",newSighting);
            //model.put("animals", Animal.all());
            String animal = Animal.findById(animal_id).getName();
            int animalId = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
            Endangered updatedAnimal = Endangered.findById(animalId);
            updatedAnimal.update(health, age);
            model.put("animal", animal);
            return new ModelAndView(model, "allAnimals.hbs");
        },new HandlebarsTemplateEngine());

        //display sighting form
        get("/sighting/add",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "addSighting.hbs");
        },new HandlebarsTemplateEngine());

        //processing sighting form
        post("/sighting/add",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int animal_id = Integer.parseInt(request.queryParams("animalSelected"));
            String location = request.queryParams("location");
            String rangerName=request.queryParams("rangerName");
            int id=Integer.parseInt(request.queryParams("id"));
            Sighting newSighting = new Sighting(animal_id, location, rangerName,id);
            newSighting.save();
            model.put("newSighting",newSighting);
            return new ModelAndView(model, "allSightings.hbs");
        },new HandlebarsTemplateEngine());

        //display animals page
        get("/endangered_animal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("endangeredAnimals", Endangered.all());
            return new ModelAndView(model, "allAnimals.hbs");
        },new HandlebarsTemplateEngine());

        //displaying sightings page
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("endangeredAnimals", Endangered.all());
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "allSightings.hbs");
        },new HandlebarsTemplateEngine());

        //display animals page


        //error message page
        get("/error",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "error.hbs");
        },new HandlebarsTemplateEngine());
    }

}
