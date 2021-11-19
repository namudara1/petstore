package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api/pets")
@Produces("application/json")
public class PetResource {

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	public Response getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		Pet pet1 = new Pet();
		pet1.setPetId(1);
		pet1.setPetAge(7);
		pet1.setPetName("Shaggy");
		pet1.setPetType("Dog");

		Pet pet2 = new Pet();
		pet2.setPetId(2);
		pet2.setPetAge(3);
		pet2.setPetName("Kitty");
		pet2.setPetType("Cat");

		Pet pet3 = new Pet();
		pet3.setPetId(3);
		pet3.setPetAge(5);
		pet3.setPetName("Haavi");
		pet3.setPetType("Rabbit");

		Pet pet4 = new Pet();
		pet4.setPetId(4);
		pet4.setPetAge(15);
		pet4.setPetName("Bruna");
		pet4.setPetType("Dog");

		pets.add(pet1);
		pets.add(pet2);
		pets.add(pet3);
		pets.add(pet4);
		return Response.ok(pets).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "Cannot find the pet from given ID") })
	@GET
	@Path("{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Pet pet = new Pet();
		pet.setPetId(petId);
		pet.setPetAge(3);
		pet.setPetName("Buula");
		pet.setPetType("Dog");

		return Response.ok(pet).build();
		
	}
}
