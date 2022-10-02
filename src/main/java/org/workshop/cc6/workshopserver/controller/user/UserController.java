package org.workshop.cc6.workshopserver.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.cc6.workshopserver.dto.user.LoginRequest;
import org.workshop.cc6.workshopserver.dto.user.LoginResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody
    LoginRequest user) {
        return new ResponseEntity<LoginResponse>(new LoginResponse("hello world"), HttpStatus.OK);
    }

}
