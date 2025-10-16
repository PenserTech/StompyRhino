package tech.penser.stompy_rhino.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
