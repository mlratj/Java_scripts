package org.example.api.consts;

import io.swagger.annotations.ApiParam;
import org.example.api.handlers.ErrorHandler;
import org.example.api.model.RegisterUserRequest;
import org.example.api.model.User;
import org.example.exceptions.ValidationException;
import org.example.repository.impl.UserAccountRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(ApiEndpoints.USER)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
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

    @GET
    @Path(ApiEndpoints.USER_LOGOUT)
    public Response logoutUser(
            @QueryParam(ApiEndpoints.PARAM_LIMIT) Integer limit,
            @QueryParam(ApiEndpoints.PARAM_OFFSET) Integer offset,
            @QueryParam(ApiEndpoints.PARAM_SEARCH) String search
    ) {
        return Response.status(Response.Status.OK).entity("mock call ok...").build();
    }

    @GET
    @Path(ApiEndpoints.USER_ID)
    public Response getUserById(
            @QueryParam(ApiEndpoints.PARAM_LIMIT) Integer limit,
            @QueryParam(ApiEndpoints.PARAM_OFFSET) Integer offset,
            @QueryParam(ApiEndpoints.PARAM_SEARCH) String search
    ) {
        return Response.status(Response.Status.OK).entity("mock call ok...").build();
    }
    @DELETE
    @Path(ApiEndpoints.USER_ID)
    public Response deleteUser(Integer id) {
        return Response.status(Response.Status.OK).entity("mock call ok...").build();
    }
}