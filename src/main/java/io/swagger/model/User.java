package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User description
 */
@Schema(description = "User description")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-27T00:45:23.376927900+02:00[Europe/Madrid]")


public class User {
    @JsonProperty("userId")
    @Id
    private String userId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("birthdate")
    private String birthdate = null;

    public User userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * User identifier
     *
     * @return userId
     **/
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "User identifier")

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    /**
     * user name
     *
     * @return name
     **/
    @Schema(description = "user name")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User birthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    /**
     * birthdate of the user
     *
     * @return birthdate
     **/
    @Schema(description = "birthdate of the user")

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.userId, user.userId) &&
                Objects.equals(this.name, user.name) &&
                Objects.equals(this.birthdate, user.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, birthdate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
