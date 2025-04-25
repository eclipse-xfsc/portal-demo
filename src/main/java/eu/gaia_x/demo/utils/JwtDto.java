package eu.gaia_x.demo.utils;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtDto {
    @SerializedName("realm_access")
    private RealmAccess realmAccess;

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RealmAccess {
        @SerializedName("roles")
        List<String> roles;
    }
}
