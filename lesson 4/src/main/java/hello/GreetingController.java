package hello;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

class FormEntity{
    public String userName;
    public FormEntity(){

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

@Controller
public class GreetingController {
    @RequestMapping("/hello")
    public String echo(Model model){
        return "hello";
    }
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello (Model model){
        model.addAttribute("message","Hello, Аноним");
        System.out.println();
        return "hello2";
    }
    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    public String helloWithName (@ModelAttribute FormEntity form, Model model){
        System.out.println(form.userName);
        model.addAttribute("message","Hello, " + form.userName);
        return "hello2";
    }

}