import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("CDs", request.session().attribute("CDs"));
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
   post("/CD", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CD> CDs = request.session().attribute("CDs");
      if (CDs == null) {
        CDs= new ArrayList<CD>();
        request.session().attribute("CDs", CDs);
      }

      String albumName = request.queryParams("albumName");
      CD newCD = new CD(albumName);
      CDs.add(newCD);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
