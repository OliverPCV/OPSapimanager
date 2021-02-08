package cz.educanet.opsapimanagers;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private ArrayList<Users> users = new ArrayList<Users>();


    @Inject
    private UsersManager userManager;
    @Inject
    private LoginManager loginManager;

    @GET
    public Response getUsers() {
        return Response.ok(userManager.getAll()).build();
    }

    @POST
    public Response createUser(
            @FormParam("fullname") String fullname,
            @FormParam("username") String username,
            @FormParam("email") String email,
            @FormParam("password") String password
    ) {
        Users user = new Users(fullname, username, email, password);
        if (userManager.doesUserExist(username)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("user už existuje").build();

        } else {
            userManager.saveUser(user);
            return Response.ok("Registered").build();
        }
    }

    @POST
    public Response loginUser(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {
        Users user = userManager.getUserLogin(username, password);
        if (user == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Špatnš zadáno").build();
        } else {
            loginManager.loggedUser = user;
            return Response.ok("uživatel se uspěšně přihlásil").build();
        }

    }

    @GET
    public Response getLoggedUser(){
        return Response.ok(loginManager.loggedUser).build();
    }
    @DELETE
    public Response logoutUser(){
        loginManager.loggedUser = null;
        return Response.ok("User logged out").build();
    }
}
