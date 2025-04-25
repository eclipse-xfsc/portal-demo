package eu.gaia_x.demo.discovery.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Value(staticConstructor = "of")
public class ScreenshotInfo {

    @NonNull
    String serviceId;
    @NonNull
    PreviewImg[] previewImgs;

    public static ScreenshotInfo from(Map<String, ?> m) {
        String serviceId = (String) m.get("serviceId");
        PreviewImg[] imgs = ((List<String>) m.get("imgs")).stream()
                .map(PreviewImg::new)
                .toArray(PreviewImg[]::new);
        return of(serviceId, imgs);
    }

    public Map<String, ?> map() {
        return new HashMap<>() {{
            put("serviceId", serviceId);
            put("preview_imgs", previewImgs);
        }};
    }

    @Getter
    public static class PreviewImg {
        private final String url;

        public PreviewImg(String url) {
            this.url = url;
        }
    }
}
