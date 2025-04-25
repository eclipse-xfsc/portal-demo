package eu.gaia_x.demo.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JsonUtil {

  public static <T> T readTokenIntoClass(String bearerToken, Class<T> clazz) {
    String token = bearerToken.split("\\s+")[1];
    String tokenBody = token.split("\\.")[1];

    Base64.Decoder decoder = Base64.getDecoder();
    String jsonStr = new String(decoder.decode(tokenBody));
    log.info("JWT Token: {}", jsonStr);
    Gson gson = new Gson();
    return gson.fromJson(jsonStr, clazz);
  }

  public static <T> T readJsonFromFile(String filename, Class<T> type) throws FileNotFoundException {
    Gson gson = new Gson();
//        JsonReader reader = new JsonReader(new FileReader(filename));
    JsonReader reader = new JsonReader(
            new FileReader(
                    ResourceUtils.getFile(String.format("classpath:%s", filename))));
    return gson.fromJson(reader, type);
  }

}
