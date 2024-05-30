package org.example.jaxdemo;

import jakarta.ws.rs.*;

import java.util.List;

@Path("/users")
public class AppResource {
    private final UserRepository ur = new UserRepository();

    @GET
    @Produces({"application/json","application/xml"})
    public List<Users> getAllUsers() {
        return ur.fetchAllUsers();
    }

    @GET
    @Path("/user/{username}")
    @Produces({"application/xml","application/json"})
    public Users getUser(@PathParam("username") String username) {
        return ur.fetchUser(username);
    }

    @POST
    @Path("/user")
//    @Consumes("application/xml")              will only accept xml
    public void createUser(Users user) {
        ur.createUser(user);
        System.out.println("User "+user.getUsername()+" created");
    }

    @PUT
    @Path("/user")
    public void updateUser(Users user){
        if(ur.fetchUser(user.getUsername())==null){
            System.out.println("User "+user.getUsername()+" not found.Creating....");
            ur.createUser(user);
        }
        else{
            ur.updateUser(user);
            System.out.println("User "+user.getUsername()+" updated");
        }
    }

    @DELETE
    @Path("/user/{username}")
    public void deleteUser(@PathParam("username") String username) {
        if(username!=null){
            ur.deleteUser(username);
            System.out.println("User "+username+" deleted");
        }
    }
}