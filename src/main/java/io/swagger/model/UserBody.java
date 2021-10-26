package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-10-27T00:45:23.376927900+02:00[Europe/Madrid]")


public class UserBody   {
  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("birthdate")
  private String birthdate = null;

  public UserBody userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Id of the User
   * @return userId
   **/
  @Schema(required = true, description = "Id of the User")
      @NotNull

    public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public UserBody name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the user
   * @return name
   **/
  @Schema(required = true, description = "Name of the user")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserBody birthdate(String birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * birthdate of the user
   * @return birthdate
   **/
  @Schema(required = true, description = "birthdate of the user")
      @NotNull

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
    UserBody userBody = (UserBody) o;
    return Objects.equals(this.userId, userBody.userId) &&
        Objects.equals(this.name, userBody.name) &&
        Objects.equals(this.birthdate, userBody.birthdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, birthdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBody {\n");
    
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
