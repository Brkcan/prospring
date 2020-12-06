package com.prospring.autoconfigurationenable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("webcontroller")
    public String index ()
    {
        return "Hello .../";
    }
}
