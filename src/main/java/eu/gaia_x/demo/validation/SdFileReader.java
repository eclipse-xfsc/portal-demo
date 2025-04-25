package eu.gaia_x.demo.validation;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SdFileReader {

    public static String readFile(MultipartFile file) {
        StringBuilder lines = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) lines.append(line);
        } catch (Exception e) {
            return "";
        }
        return lines.toString();
    }
}
