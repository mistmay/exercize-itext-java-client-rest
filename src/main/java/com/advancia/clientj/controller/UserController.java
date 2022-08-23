package com.advancia.clientj.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.clientj.dao.UserDAO;
import com.advancia.clientj.model.User;

@Path("/users")
public class UserController {
	@GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<User> fetchUsers() {
        return UserDAO.getUserList();
    }
}
