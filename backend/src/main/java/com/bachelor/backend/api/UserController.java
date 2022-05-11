package com.bachelor.backend.api;

import com.bachelor.backend.domain.authentication.AuthenticationService;
import com.bachelor.backend.domain.authentication.TokenRequest;
import com.bachelor.backend.domain.users.NewUser;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    private AuthenticationService authenticationService;
    @Inject
    private UsersRepository usersRepository;

    @RequestMapping(
            value = "/auth/registerNewUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> registerNewUser(@RequestBody NewUser newUser) {
        final String email = newUser.getEmail();
        final String username = newUser.getUsername();
        LOG.info("Requesting token for {} ", email);
        try {
                authenticationService.registerNewUser(email, username);
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Token created");
    }

    @RequestMapping(
            value = "/auth/tokenRequest",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> requestNewToken(@RequestBody TokenRequest request) {
        final String email = request.email();
        LOG.info("Requesting token for {} ", email);
        try {
            final Optional<User> optionalUser = usersRepository.findByEmail(email);
            if (optionalUser.isPresent()) {
                authenticationService.requestNewToken(email);
                return ResponseEntity.ok("Token created");
            }
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> findAllUsers() {
        var optionalUser = StreamSupport.stream(usersRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(optionalUser);
    }

    @GetMapping("/users/{stableId}")
    public ResponseEntity<UUID> findUserById(@PathVariable("stableId") String stableId, Principal principal) {
        if (principal == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if ("me".equals(stableId)) {
            try {
                User oneByEmail = usersRepository.findByEmail(principal.getName()).get();
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(oneByEmail.getUuid());
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }

        Optional<User> optionalUser = usersRepository.findByUuid(UUID.fromString(stableId));

        if (optionalUser.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        User user = optionalUser.get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user.getUuid());

    }

    @ResponseBody
    @RequestMapping(
            value = {"users/create"},
            method = RequestMethod.POST
    )
    public ResponseEntity<UUID> createUser(@RequestBody User user) {
        usersRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user.getUuid());
    }
}
