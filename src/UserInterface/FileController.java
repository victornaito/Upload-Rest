package UserInterface;

import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@Path("/api/file")
public class FileController  {

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return DateFormat.getDateInstance().format(new Date());
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response.ResponseBuilder saveFile(@FormDataParam("file") byte[] bytes) {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream("D:\\Upload-Rest\\file\\teste.pdf");
            fileOutputStream.write(bytes);
            fileOutputStream.close();

            return Response.ok(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return Response.status(500);
        }
    }
}