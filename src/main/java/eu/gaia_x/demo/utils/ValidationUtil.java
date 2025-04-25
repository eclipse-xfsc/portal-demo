package eu.gaia_x.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Base64;
import java.util.regex.Pattern;

/**
 * For validating input parameters
 */
@Slf4j
public class ValidationUtil {

    /**
     * Validating email address
     *
     * @param emailStr ...
     * @return ...
     */
    public static boolean validateEmail(String emailStr) {
        return Pattern
                .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
                .matcher(emailStr)
                .find();
    }

    public static boolean validateInputFile(String document) {
        boolean validObject = true;
        boolean validArray = true;
        try {
            new JSONObject(document);
        } catch (JSONException e) {
            validObject = false;
        }
        try {
            new JSONArray(document);
        } catch (JSONException e) {
            validArray = false;
        }
        return validArray || validObject;
    }

    public static String getEmailFromId(String uniqueId) {
        int dis = uniqueId.indexOf('-');
        String encoded = uniqueId.substring(0, dis);
        int eqCount = Integer.parseInt("" + uniqueId.charAt(dis + 1));
        String basedEmail = encoded + "=".repeat(Math.max(0, eqCount));
        byte[] decodedBytes = Base64.getDecoder().decode(basedEmail);
        String email = new String(decodedBytes);
        log.info("decoded email: " + email);
        return email;
    }
}
