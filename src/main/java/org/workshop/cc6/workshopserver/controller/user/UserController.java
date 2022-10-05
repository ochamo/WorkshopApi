package org.workshop.cc6.workshopserver.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.cc6.workshopserver.data.repository.UserRepository;
import org.workshop.cc6.workshopserver.dto.user.LoginRequest;
import org.workshop.cc6.workshopserver.dto.user.LoginResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/registerUser")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody
    LoginRequest user) {
        return new ResponseEntity<LoginResponse>(new LoginResponse("hello world"), HttpStatus.OK);
    }

}
