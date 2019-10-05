package com.sc.interview.crudapp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public ResponseEntity get() {
        return ResponseEntity.ok("Hello World!");
    }

}
