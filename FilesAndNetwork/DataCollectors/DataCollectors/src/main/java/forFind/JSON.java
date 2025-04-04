package forFind;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import forClasses.Depth;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JSON
{
    public List<Depth> parseFile(Path path) throws IOException {
        List<Depth> depths;
        String json = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        depths =  mapper.readValue(json, new TypeReference<>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        return depths;
    }
}
