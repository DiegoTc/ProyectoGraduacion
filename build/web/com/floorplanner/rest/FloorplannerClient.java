package com.floorplanner.rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.floorplanner.rest.beans.Design;
import com.floorplanner.rest.beans.Floor;
import com.floorplanner.rest.beans.Project;
import com.floorplanner.rest.beans.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.commons.codec.binary.Base64;

public class FloorplannerClient {

	private final String authentication;
	private static final String AUTHENTICATION_HEADER = "Authorization";
	private final WebResource userResource;

	public FloorplannerClient(String apikey, String host) {
                byte[] encodeBytes = Base64.encodeBase64((apikey + ":x").getBytes());
                String by= new String(encodeBytes);
		authentication = "Basic "+by;

		ClientConfig config = new DefaultClientConfig();

		Client client = Client.create(config);
		userResource = client.resource(host);
	}

	public User getUserWithToken(int userId) {
		return userResource.path("users").path(Integer.toString(userId)).path(
				"token").header(AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).get(new GenericType<User>() {
		});
	}

	public List<User> getUsers(int page, int perPage) {
		return userResource.queryParam("page", Integer.toString(page))
				.queryParam("per_page", Integer.toString(perPage)).path(
						"users.xml").header(AUTHENTICATION_HEADER,
						authentication).accept(MediaType.APPLICATION_XML_TYPE)
				.get(new GenericType<List<User>>() {
				});
	}

	public User getUserById(int userId) {
		return userResource.path("users").path(userId + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).get(new GenericType<User>() {
		});
	}

	public User createUser(User user) {
		return userResource.path("users.xml").header(AUTHENTICATION_HEADER,
				authentication).accept(MediaType.APPLICATION_XML_TYPE).post(
				User.class, user);
	}

	public User updateUser(User user) {
		return userResource.path("users").path(user.getId() + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).put(User.class, user);
	}

	public void removeUser(int userId) {
		userResource.path("users").path(userId + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).delete();
	}

	public Project createProject(String userId, Project project) {
		return userResource.path("projects.xml")
				.header(AUTHENTICATION_HEADER, authentication).accept(
						MediaType.APPLICATION_XML_TYPE).post(Project.class,
						project);
	}

	public List<Project> getProjectsByUser(int userId, int page, int perPage) {
		return userResource.queryParam("page", Integer.toString(page))
				.queryParam("per_page", Integer.toString(perPage))
				.path("users").path(Integer.toString(userId)).path(
						"projects.xml").header(AUTHENTICATION_HEADER,
						authentication).accept(MediaType.APPLICATION_XML_TYPE)
				.get(new GenericType<List<Project>>() {
				});
	}

	public Project getProjectById(int projectId) {
		return userResource.path("projects").path(projectId + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).get(new GenericType<Project>() {
		});
	}

	public List<Project> getProjects(int page, int perPage) {
		return userResource.queryParam("page", Integer.toString(page))
				.queryParam("per_page", Integer.toString(perPage)).path(
						"projects.xml").header(AUTHENTICATION_HEADER,
						authentication).accept(MediaType.APPLICATION_XML_TYPE)
				.get(new GenericType<List<Project>>() {
				});
	}

	public Project updateProject(Project project) {
		return userResource.path("projects").path(project.getId() + ".xml")
				.header(AUTHENTICATION_HEADER, authentication).accept(
						MediaType.APPLICATION_XML_TYPE).put(Project.class,
						project);
	}

	public void removeProject(int projectId) {
		userResource.path("projects").path(projectId + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).delete();
	}

	public String exportProject(int projectId) {
		return userResource.path("projects").path(Integer.toString(projectId))
				.path("export.xml").header(AUTHENTICATION_HEADER,
						authentication).accept(MediaType.APPLICATION_XML_TYPE)
				.get(new GenericType<String>() {
				});
	}

	public void removeFloor(int floorId) {
		userResource.path("floors").path(floorId + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).delete();
	}

	public Floor updateFloor(Floor floor) {
		return userResource.path("floors").path(floor.getId() + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).put(Floor.class, floor);
	}

	public void removeDesign(int designId) {
		userResource.path("designs").path(designId + ".xml").header(
				AUTHENTICATION_HEADER, authentication).accept(
				MediaType.APPLICATION_XML_TYPE).delete();
	}

	public Design updateDesign(Design design) {
		return userResource.path("designs").path(design.getId() + ".xml")
				.header(AUTHENTICATION_HEADER, authentication).accept(
						MediaType.APPLICATION_XML_TYPE).put(Design.class,
						design);
	}
}
