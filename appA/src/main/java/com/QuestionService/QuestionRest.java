package com.QuestionService;


import com.Question.dao.Common;
import com.Question.models.QuestionFour;
import com.Question.models.Question_One;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@Path("question")
public class QuestionRest {

    @Inject
    private Logger logger;
    @Inject
    private Common common;

    @PostConstruct
    private void init() {

    }


    @POST
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reverseinput(Question_One inputData) throws Exception {
        String reversedString = "";
//        String k= "Ab,c,de!$";
        Question_One questionOne;
        try {
            logger.log(Level.INFO, "question one executing ");
            reversedString = common.reverse(inputData.getInpputString());
            questionOne = new Question_One();
            questionOne.setInpputString(reversedString);
            return Response.status(200).entity(questionOne).build();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new WebApplicationException(exc.getMessage());
        }
    }

    @GET
    @Path("/two")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countTriplet() throws Exception {
        int arr[] = new int[]{5, 1, 3, 4, 7};
        int sum = 12;
        try {
            logger.log(Level.INFO, "question two executing ");
            int output = common.countTriplets(arr.length, sum, arr);
            return Response.status(200).entity(output).build();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new WebApplicationException(exc.getMessage());
        }
    }


    //question 3
    @GET
    @Path("/three")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Checktriplet() throws Exception {
        boolean tripletstatus = false;
        try {
            logger.log(Level.INFO, "question three executing ");
            int arr[] = {3, 1, 4, 6, 5};
            int arr_size = arr.length;
            tripletstatus = common.isTriplet(arr, arr_size);

            return tripletstatus;


        } catch (Exception exc) {
            exc.printStackTrace();
            throw new WebApplicationException(exc.getMessage());
        }
    }

    //    question 4
    @POST
    @Path("/four")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isValisString(QuestionFour inputData) throws Exception {
        boolean isValid = false;
//    String inputString=" '(', ')', '{', '}', '[' and ']',";
        try {
            logger.log(Level.INFO, "question four executing ");
            isValid = common.isValid(inputData.getInpputString());

            return isValid;
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new WebApplicationException(exc.getMessage());
        }
    }
//    question 5

    @POST
    @Path("/five")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> generateParenthesis(int n) {
//        int k=4;
        ArrayList<String> result = new ArrayList<String>();
        common.genParenthesis(result, "", n, n);
        return result;
    }

    //question five
    @POST
    @Path("/six")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Integer> generateKthRow(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result = common.findRow(n);
        return result;
    }

}
