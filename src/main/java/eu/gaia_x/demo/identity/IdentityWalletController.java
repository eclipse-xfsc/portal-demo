package eu.gaia_x.demo.identity;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import eu.gaia_x.demo.identity.wallet.QrInfoResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.awt.image.BufferedImage;
import java.util.Map;

import static eu.gaia_x.demo.onboarding.OnboardingSystemController.getQrInfoResponse;

@Log4j2
@RestController
@RequestMapping(value = {"/demo/api/identity"})
public class IdentityWalletController {
  private static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
    final QRCodeWriter barcodeWriter = new QRCodeWriter();
    final BitMatrix bitMatrix =
            barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

    return MatrixToImageWriter.toBufferedImage(bitMatrix);
  }

  @GetMapping("/wallet_info")
  @ResponseBody
  public QrInfoResponse requestWalletInfo(
          @RequestParam Map<String, String> raw,
          @Value("${services.identity.uri.external}") String uri
  ) {
    log.info("requestWalletInfo, parameters: {}", raw);
    final String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();

    return getQrInfoResponse(uri, sessionId);
  }


  @GetMapping(value = "/mock_qr_link", produces = MediaType.IMAGE_PNG_VALUE)
  public ResponseEntity<BufferedImage> mockQRAndLink(
          @Value("${services.identity.uri.external}") String uri,
          @RequestParam Map<String, String> raw
  )
          throws Exception {
    final String loginMockURL =
            String.format(
                    "%s/demo/api/onboarding/ext/auth/login-mock/%s",
                    uri,
                    raw.get("session")
            );
    log.info("in mockQRAndLink, loginMockURL: {}", loginMockURL);
    return ResponseEntity.ok().body(generateQRCodeImage(
                    loginMockURL
            )
    );
  }

}
