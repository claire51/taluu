package com.mycompany.services.userProfile;

import com.Question.dao.Common;
import com.Question.models.Question_One;
import com.mycompany.model.coredb.Personel;
import com.mycompany.userProfile.dao.UserprofileDao;
import com.mycompany.utill.filter.JWTTokenNeeded;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@Path("profile")
public class UserProfile {

    @Inject
    private Logger logger;

    @Inject
    private UserprofileDao userprofileDao;
    @Inject
    private Common common;

    @PersistenceContext
    private EntityManager em;


    @PostConstruct
    private void init() {
        this.userprofileDao.setEm(this.em);
    }



    @GET
    @Path("/{id}")
    @JWTTokenNeeded
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadById(@PathParam("id") int Id) throws Exception {
        try {
            logger.log(Level.INFO, "By id ");
            Personel personel;
            personel = this.userprofileDao.findProfileById(Id);
            return Response.status(200).entity(personel).build();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new WebApplicationException(exc.getMessage());
        }

    }


    @GET
    @Path("/namedqry")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadByNamedQuery() throws Exception {
        try {
            logger.log(Level.INFO, "By id ");
            String findAll = "Personel.findAll";
            Object[] k = new Object[0];
            List<Personel> personelList = this.userprofileDao.findProfileByNamedQuery(findAll, k);
            return Response.status(200).entity(personelList).build();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new WebApplicationException(exc.getMessage());
        }

    }


}
