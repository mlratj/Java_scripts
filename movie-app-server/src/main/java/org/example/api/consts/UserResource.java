package org.example.api.consts;

import org.example.api.handlers.ErrorHandler;
import org.example.api.model.RegisterUserRequest;
import org.example.api.model.User;
import org.example.exceptions.ValidationException;
import org.example.repository.impl.UserAccountRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(ApiEndpoints.USER)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource
{
    @POST
    public Response postUser(RegisterUserRequest body) {
        try {
            UserAccountRepository userAccountRepository = new UserAccountRepository();
            return Response.status(
                    Response.Status.OK
            ).entity(
                    User.createFromUserAccount(
                            userAccountRepository.registerUser(body)
                    )
            ).build();
        } catch (ValidationException ex) {
            return Response.status(
                    Response.Status.BAD_REQUEST
            ).entity(
                    ErrorHandler.getErrorResponse(ex)
            ).build();
        } catch (Exception ex) {
            return Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR
            ).entity(
                    ErrorHandler.getErrorResponse(ex)
            ).build();
        }
    }
        }