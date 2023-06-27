package pl.javastart.validationtask;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("myObject")
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", new RegisterFormDto());
        return "home";
    }

    @PostMapping("/register")
    String register(@Valid @ModelAttribute("data") RegisterFormDto registerFormDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("data", registerFormDto);
            return "home";
        } else {
            redirectAttributes.addFlashAttribute("registerFormDto", registerFormDto);
            return "redirect:/success";
        }
    }

    @GetMapping("/success")
    String approved(@ModelAttribute("registerFormDto") final RegisterFormDto registerFormDto, Model model) {
        model.addAttribute("formData", registerFormDto);
        return "success";
    }


}
