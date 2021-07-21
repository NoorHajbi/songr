package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    @Autowired
    private AlbumRepository albumRepository;
    
    //1. Home
    @GetMapping("/")
    public String home() {
        return "index"; //Html file name
    }

    //2. Hello
    @GetMapping("/helloForm")
    public String helloForm() {
        return "helloForm"; //Html file name
    }


    //hello?name=name
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWorld(@RequestParam String name, Model model) {
        String wlcMsg = "Hello, " + name + "!";
        model.addAttribute("hello", wlcMsg);
        return "helloWorld";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name, Model model) {
        String wlcMsg = "Hello, " + name + "!";
        model.addAttribute("hello", wlcMsg);
        return "helloWorld";
    }


    //capitalize
    @GetMapping("/capitalize/{capitalizeME}")
    public String capitalized(Model model, @PathVariable("capitalizeME") String capitalizeME) {
        model.addAttribute("capitalizeME", capitalizeME);
        return "capitalize"; //Html file name
    }
    @GetMapping("/capitalize")
    @ResponseBody
    public String capitalizeNull() {
        return "Please, Add your words to the route!";
    }

}
/*
    The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.

@RequestParam binds the value of the query string parameter name into
        the name parameter of the greeting() method. This query string parameter is not required.
        If it is absent in the request, the defaultValue of World is used.
        The value of the name parameter is added to a Model object,
        ultimately making it accessible to the view template.

        The implementation of the method body relies on a view technology
        (in this case, Thymeleaf) to perform server-side rendering of the HTML.
        Thymeleaf parses the greeting.html template and evaluates the th:text expression
        to render the value of the ${name} parameter that was set in the controller.
        */
