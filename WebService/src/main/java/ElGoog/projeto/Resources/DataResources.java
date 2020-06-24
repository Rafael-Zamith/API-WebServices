package ElGoog.projeto.Resources;

import ElGoog.projeto.API.Data;
import ElGoog.projeto.DAO.DataDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("graph")
@Produces(MediaType.APPLICATION_JSON)
public class DataResources {
    DataDAO dataDAO;

    public DataResources(DataDAO dataDAO){
        this.dataDAO = dataDAO;
    }

    @GET
    public Response getDataIs(){
        List<Data> allData = dataDAO.getAllData();

        return Response.ok(allData).build();
    }

    @POST
    public Response createData(Data data){
        if(data == null){
            throw new BadRequestException("Data data missing");
        }
        long id = dataDAO.insert(data);
        data = dataDAO.findById(id);

        if(data == null){
            throw new WebApplicationException("Problem creating Data");
        }

        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response getDataAre(@PathParam("id")long id){
        Data data = dataDAO.findById(id);

        if (data == null){
            throw new WebApplicationException("This Data does not exist", Response.Status.NOT_FOUND);
        }

        return Response.ok(data).build();
    }

    @DELETE
    public Response deleteData(Data data){
        if (data == null){
            throw new WebApplicationException("This Data does not exist", Response.Status.NOT_FOUND);
        }

        dataDAO.deleteData(data);
        return Response.ok().build();
    }

    @PUT
    public Response updateData(Data data){
        if(data == null){
            throw new WebApplicationException("This Data does not exist", Response.Status.NOT_FOUND);
        }

        dataDAO.updateData(data);
        return Response.ok().build();
    }
}
