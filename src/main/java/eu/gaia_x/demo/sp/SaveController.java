package eu.gaia_x.demo.sp;

import eu.gaia_x.demo.sp.model.SaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/demo/api/sp-service")
public class SaveController {

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody SaveRequest rq) {
        HashMap<Object, Object> body = new HashMap<>();
        body.put("result", "ok");
        return ResponseEntity.ok(body);
    }
}
