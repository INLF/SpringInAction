package com.eldar.vesna.controllers;

import com.eldar.vesna.data.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder , Errors errors , SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            log.info("Errors occured {}" , errors);
            return "orderForm";
        }

        log.info("Taco order : {}" , tacoOrder);
        sessionStatus.isComplete();
        return "redirect:/";
    }
}
