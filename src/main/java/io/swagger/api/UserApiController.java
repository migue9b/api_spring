package io.swagger.api;

import io.swagger.model.InlineResponse200;
import io.swagger.model.User;
import io.swagger.model.UserBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-26T22:28:39.473155700+02:00[Europe/Madrid]")
@RestController
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private UserBD userDB;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> usersDelete(@Pattern(regexp = "^\\d+$") @Parameter(in = ParameterIn.PATH, description = "ID of User", required = true, schema = @Schema()) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (!userDB.findById(userId).isPresent())
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        else {
            userDB.deleteById(userId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    public ResponseEntity<ArrayList<User>> usersGet() {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            ArrayList<User> users = (ArrayList<User>) userDB.findAll();
            if (users.isEmpty())
                return new ResponseEntity<ArrayList<User>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<User>>(users, HttpStatus.OK);
        }
        return new ResponseEntity<ArrayList<User>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> usersGetId(@Pattern(regexp = "^\\d+$") @Parameter(in = ParameterIn.PATH, description = "ID of User", required = true, schema = @Schema()) @PathVariable("userId") Integer userId) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            Optional<User> user = userDB.findById(userId);
            if (user.isPresent())
                return new ResponseEntity<User>(user.get(), HttpStatus.OK);
            else
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> usersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody UserBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            User newUser = new User();
            newUser.setName(body.getName());
            newUser.setBirthdate(body.getBirthdate());
            userDB.save(newUser);
            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<User> usersPut(@Pattern(regexp = "^\\d+$") @Parameter(in = ParameterIn.PATH, description = "ID of User", required = true, schema = @Schema()) @PathVariable("userId") Integer userId, @Parameter(in = ParameterIn.DEFAULT, description = "User data", required = true, schema = @Schema()) @Valid @RequestBody UserBody body) {
        String accept = request.getHeader("Accept");
        Optional<User> user = userDB.findById(userId);
        if (user.isPresent() && accept.contains("application/json")) {
            User u = user.get();
            u.setName(body.getName());
            u.setBirthdate(body.getBirthdate());
            userDB.save(u);
            return new ResponseEntity<User>(HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
}
