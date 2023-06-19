package com.example.demo.registration;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import com.example.demo.appuser.AppUserService;
import com.example.demo.security.jwt.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RegistrationService RegistrationService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return RegistrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return RegistrationService.confirmToken(token);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        Optional<AppUser> user= appUserRepository.findByEmail(authRequest.getEmail());

        if(user.isEmpty() || !bCryptPasswordEncoder.matches(authRequest.getPassword(),user.get().getPassword())){
            return "Username/password not exist";
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }

}
