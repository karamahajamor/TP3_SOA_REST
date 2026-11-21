package service;

import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.Calculatrice;
import model.Operation;

@Path("/calcul")
@Produces(MediaType.APPLICATION_JSON)
public class CalculRest {

    private final Calculatrice calculatrice = new Calculatrice();

    @GET
    @Path("/addition")
    public Response addition(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        if (a == null || b == null) {
            return erreur("Les parametres a et b sont obligatoires");
        }
        return Response.ok(new Operation(a, b, "+", calculatrice.addition(a, b))).build();
    }

    @GET
    @Path("/soustraction")
    public Response soustraction(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        if (a == null || b == null) {
            return erreur("Les parametres a et b sont obligatoires");
        }
        return Response.ok(new Operation(a, b, "-", calculatrice.soustraction(a, b))).build();
    }

    @GET
    @Path("/multiplication")
    public Response multiplication(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        if (a == null || b == null) {
            return erreur("Les parametres a et b sont obligatoires");
        }
        return Response.ok(new Operation(a, b, "*", calculatrice.multiplication(a, b))).build();
    }

    @GET
    @Path("/division")
    public Response division(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        if (a == null || b == null) {
            return erreur("Les parametres a et b sont obligatoires");
        }
        if (b == 0) {
            return erreur("Division par zero impossible");
        }
        return Response.ok(new Operation(a, b, "/", calculatrice.division(a, b))).build();
    }

    private Response erreur(String message) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Map.of("erreur", message))
                .build();
    }
}