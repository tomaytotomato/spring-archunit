package com.tomaytotomato.layered;

import com.tomaytotomato.layered.controller.RAndomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bar")
public class BarController {


  public String getBar() {
    var random = new RAndomUtil();
    return random.randomString();
  }

}
