/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.29).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.InlineResponse200;
import io.swagger.model.User;
import io.swagger.model.UserBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-27T00:45:23.376927900+02:00[Europe/Madrid]")
@Validated
public interface UserApi {

    @Operation(summary = "Delete a user", description = "Delete a user identified by userId", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted"),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: resource not available")})
    @RequestMapping(value = "/user/{userId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> usersDelete(@Pattern(regexp = "^\\w+$") @Parameter(in = ParameterIn.PATH, description = "ID of the User", required = true, schema = @Schema()) @PathVariable("userId") String userId);


    @Operation(summary = "Get all the users", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users array", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: resource not available")})
    @RequestMapping(value = "/user",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ArrayList<User>> usersGet();


    @Operation(summary = "Find user by ID", description = "Get user especified in userId", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: resource not available")})
    @RequestMapping(value = "/user/{userId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<User> usersGetId(@Pattern(regexp = "^\\w+$") @Parameter(in = ParameterIn.PATH, description = "ID of the User", required = true, schema = @Schema()) @PathVariable("userId") String userId);


    @Operation(summary = "Crete a new user", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "422", description = "UNPROCESSABLE ENTITY: missing data")})
    @RequestMapping(value = "/user",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<User> usersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody UserBody body);


    @Operation(summary = "Update user", description = "Update user data", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: User modified", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),

            @ApiResponse(responseCode = "422", description = "UNPROCESSABLE ENTITY: missing data")})
    @RequestMapping(value = "/user/{userId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<User> usersPut(@Pattern(regexp = "^\\w+$") @Parameter(in = ParameterIn.PATH, description = "ID of the User", required = true, schema = @Schema()) @PathVariable("userId") String userId, @Parameter(in = ParameterIn.DEFAULT, description = "User data", required = true, schema = @Schema()) @Valid @RequestBody UserBody body);

}

