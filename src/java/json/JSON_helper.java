package json;

import com.sun.jersey.api.json.JSONJAXBContext;
import java.io.InputStream;
import java.io.OutputStream;

public class JSON_helper {
    
    static public Object unmarshal(InputStream  is , Class<?> t)  throws Exception {
        JSONJAXBContext context = new JSONJAXBContext(t);
        return context.createJSONUnmarshaller().unmarshalFromJSON(is,t);
    }
    
    static public void marshal(OutputStream os, Object obj, Class<?>... classes)  {
        try {
            JSONJAXBContext context;
            if (classes.length <= 0) {
                context = new JSONJAXBContext(obj.getClass());
            } else {
                context = new JSONJAXBContext(classes);
            }
            context.createJSONMarshaller().marshallToJSON(obj, os);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
