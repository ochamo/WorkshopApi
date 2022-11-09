package org.workshop.cc6.workshopserver.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.data.repository.UserRepository;
import org.workshop.cc6.workshopserver.dto.user.request.LoginRequest;
import org.workshop.cc6.workshopserver.dto.user.response.LoginResponse;
import org.workshop.cc6.workshopserver.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    private final UserRepository userRepository;

    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager,
                                       JwtTokenUtil jwtTokenUtil,
                                       JwtUserDetailsService userDetailsService,
                                       UserRepository userRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUserEmail(), authenticationRequest.getUserPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserEmail());

        if (userDetails == null) {
            return new ResponseEntity<>(new LoginResponse("", (byte)0, 0, "0"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        final var result = userRepository.findByUserEmail(authenticationRequest.getUserEmail());
        final String token = jwtTokenUtil.generateToken(authenticationRequest);

        return ResponseEntity.ok(new LoginResponse(token, result.get().getUserRoleId().getUserRoleId(), result.get().getUserId(), "1"));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (AuthenticationException e) {
            throw new Exception(("Exception "), e);
        }
    }

}
