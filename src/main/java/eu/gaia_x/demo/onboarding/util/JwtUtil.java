package eu.gaia_x.demo.onboarding.util;

import org.json.JSONObject;

import java.util.Base64;

public class JwtUtil {

    public static JSONObject readTokenIntoClass(String bearerToken) {
        String token = bearerToken.split("\\s+")[1];
        String tokenBody = token.split("\\.")[1];

        Base64.Decoder decoder = Base64.getDecoder();
        String jsonStr = new String(decoder.decode(tokenBody));
        System.out.println("JSON:: " + jsonStr);

        return new JSONObject(jsonStr);
    }

}
