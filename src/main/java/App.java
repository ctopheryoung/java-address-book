import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
      ProcessBuilder process = new ProcessBuilder();
       Integer port;
       if (process.environment().get("PORT") != null) {
           port = Integer.parseInt(process.environment().get("PORT"));
       } else {
           port = 4567;
       }

    setPort(port);
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/contacts", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("contacts", Contact.all());
        model.put("template", "templates/contacts.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/contacts", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        String firstName = request.queryParams("firstName");
        String lastName = request.queryParams("lastName");
        String relation = request.queryParams("relationship");
        Contact newContact = new Contact(firstName, lastName, relation);
        model.put("contacts", Contact.all());
        model.put("template", "templates/contacts.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/contacts/new", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/contact-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/contacts/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
        model.put("contact", contact);
        model.put("template", "templates/contact.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("contacts/:id/phones/new", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
        ArrayList<Phone> phones = contact.getPhones();
        model.put("contact", contact);
        model.put("phones", phones);
        model.put("template", "templates/contact-phone-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/phones", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();

        Contact contact = Contact.find(Integer.parseInt(request.queryParams("contactId")));
        ArrayList<Phone> phones = contact.getPhones();

        if (phones == null) {
          phones = new ArrayList<Phone>();
          request.session().attribute("phones", phones);
        }

        String phoneNumber = request.queryParams("phoneNumber");
        String phoneType = request.queryParams("phoneType");

        Phone newPhone = new Phone(phoneNumber, phoneType);

        phones.add(newPhone);
        model.put("phones", phones);
        model.put("contact", contact);
        model.put("template", "templates/contact.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    }
}
