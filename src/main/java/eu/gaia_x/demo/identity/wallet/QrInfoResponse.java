package eu.gaia_x.demo.identity.wallet;

import lombok.*;

@ToString
//@Value(staticConstructor = "of")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QrInfoResponse {
  @NonNull String pollUrl;
  @NonNull String qrCodePath;
  @NonNull String walletLink;


//  public static QrInfoResponse from(Map<String, String> m) {
//    return of(m.get("qrCodePath"), m.get("walletLink"));
//  }
//
//  public Map<String, String> map() {
//    final Map<String, String> m = new HashMap<>();
//    m.put("qrCodePath", qrCodePath);
//    m.put("walletLink", walletLink);
//
//    return m;
//  }
}
