package org.workshop.cc6.workshopserver.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.cc6.workshopserver.dto.user.request.CreateUserClientRequest;
import org.workshop.cc6.workshopserver.dto.user.response.CreateUserClientResponse;
import org.workshop.cc6.workshopserver.dto.user.response.LoginResponse;
import org.workshop.cc6.workshopserver.service.user.IUserService;
import org.workshop.cc6.workshopserver.service.user.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<CreateUserClientResponse> registerUser(@RequestBody CreateUserClientRequest user) {
        var response = userService.registerClient(user);
        return new ResponseEntity<CreateUserClientResponse>(response, HttpStatus.OK);
    }

}
