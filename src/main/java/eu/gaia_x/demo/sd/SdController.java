package eu.gaia_x.demo.sd;

import eu.gaia_x.demo.lcm.util.Template;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/demo/api/sd-service")
public class SdController {

    @PostMapping("/services")
    public ResponseEntity<?> createServices(HttpServletRequest request, @RequestBody MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/data")
    public ResponseEntity<?> createData(HttpServletRequest request, @RequestBody MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/nodes")
    public ResponseEntity<?> createNodes(HttpServletRequest request, @RequestBody MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<?> updateServices(HttpServletRequest request, @RequestBody MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<?> updateData(HttpServletRequest request, @RequestBody MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/nodes/{id}")
    public ResponseEntity<?> updateNodes(HttpServletRequest request, @RequestBody MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/services/{id}")
    public ResponseEntity<?> getServiceDescriptor(@RequestHeader HttpHeaders headers, @PathVariable String id) {

        byte[] bytes = SdDescriptors.SERVICE_DESCRIPTOR_1.getBytes(StandardCharsets.UTF_8);
        Resource resource = new InputStreamResource(new ByteArrayInputStream(bytes));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resource);

    }
}
