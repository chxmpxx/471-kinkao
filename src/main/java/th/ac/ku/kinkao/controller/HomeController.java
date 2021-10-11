package th.ac.ku.kinkao.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    // คืนค่าเป็น str เสมอ เพราะจะคืนค่าชื่อไฟล์ที่เป็นเทมเพลต
    public String getHomePage(Model model
                            , @AuthenticationPrincipal OAuth2User principal) {
        // key ต้องตรงกับที่ใส่ไว้ในเทมเพลต
        model.addAttribute("greeting", "Sawaddee");

        if (principal != null)
            model.addAttribute("user", principal.getAttribute("name"));
        else
            model.addAttribute("user", "Guest");

        // return home.html
        return "home";
    }

}
