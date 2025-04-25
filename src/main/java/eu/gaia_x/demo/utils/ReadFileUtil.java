package eu.gaia_x.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileUtil {

    public static String readFile(MultipartFile file) {
        StringBuilder lines = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read uploaded file: " + e.getMessage());
        }
        return lines.toString();
    }

    public static String fromOctet(HttpServletRequest request) throws IOException {
        ServletInputStream mServletInputStream = request.getInputStream();
        byte[] httpInData = new byte[request.getContentLength()];
        int retVal;
        StringBuilder sb = new StringBuilder();
        while ((retVal = mServletInputStream.read(httpInData)) != -1) {
            for (int i = 0; i < retVal; i++) {
                sb.append((char) httpInData[i]);
            }
        }
        return sb.toString();
    }
}
