package eu.gaia_x.demo.validation;

import com.google.gson.Gson;
import eu.gaia_x.demo.common.ResultsResponse;
import eu.gaia_x.demo.sd.model.SdDetailsDto;
import eu.gaia_x.demo.utils.ReadFileUtil;
import eu.gaia_x.demo.validation.dto.JsonbSdData;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@SuppressWarnings("unused")
@RestController
public class ValidationController {

    @PostMapping(value = "/demo/api/validation/sd", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public JsonbSdData validateSdFile(HttpServletRequest request) throws IOException {
        String fileContent = ReadFileUtil.fromOctet(request);
        Gson gson = new Gson();
        JsonbSdData.SdDetailsDto[] jsonbSdData = gson.fromJson(fileContent, JsonbSdData.SdDetailsDto[].class);
        log.info("Parsed data: " + Arrays.toString(jsonbSdData));
        return new JsonbSdData(Arrays.asList(jsonbSdData));
    }

    @PostMapping(value = "/demo/api/sd-service/convert", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResultsResponse<SdDetailsDto[]> convertSdFile(HttpServletRequest request) throws IOException {
        log.info("in convertSdFile");
        String json = ReadFileUtil.fromOctet(request);
        if (json.isBlank()) return new ResultsResponse<>(null, false);
        Gson gson = new Gson();

        boolean isArray = true;
        try {
            JSONArray objects = new JSONArray(json);
        } catch (Exception e) {
            isArray = false;
        }

        boolean isObject = true;
        try {
            JSONObject objects = new JSONObject(json);
        } catch (Exception e) {
            isObject = false;
        }

        if (!isArray && !isObject) return new ResultsResponse<>(null, false);

        final SdDetailsDto[] sdDetails = gson.fromJson(json, SdDetailsDto[].class);
        return new ResultsResponse<>(sdDetails, Stream.of(sdDetails).allMatch(Validator::validateSdObj));
    }
}
