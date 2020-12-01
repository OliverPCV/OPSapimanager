package cz.educanet.opsapimanagers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {
      private static UsersManager userManager = new UsersManager();

      @GET
      public static Response getUsers(){
          return  Response.ok(userManager).build();
      }

      @POST
        public static Response createUser(@FormParam("user") String user){
          userManager.addUser(user);
          return Response.ok().build();
      }
}
