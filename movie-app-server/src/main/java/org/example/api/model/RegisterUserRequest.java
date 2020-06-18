/*
 * Movie App API
 * Sample Movie App API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.example.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.example.exceptions.ValidationException;

import javax.validation.constraints.*;

/**
 * RegisterUserRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-03-25T16:08:47.699Z")
public class RegisterUserRequest   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  public RegisterUserRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User email address
   * @return email
   **/
  @JsonProperty("email")
  @ApiModelProperty(required = true, value = "User email address")
  @NotNull
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RegisterUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User&#39;s password
   * @return password
   **/
  @JsonProperty("password")
  @ApiModelProperty(required = true, value = "User's password")
  @NotNull
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterUserRequest registerUserRequest = (RegisterUserRequest) o;
    return Objects.equals(this.email, registerUserRequest.email) &&
        Objects.equals(this.password, registerUserRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterUserRequest {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
  public void validateData() throws ValidationException {
    if (StringUtils.isBlank(this.email)) {
      throw new ValidationException("Please provide email address...");
    }
    if (StringUtils.isBlank(this.password)) {
      throw new ValidationException("Please provide password...");
    }
  }
}
