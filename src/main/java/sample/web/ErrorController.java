package sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

  @RequestMapping("/404")
  public String notFound() {
    return "404";
  }
}
