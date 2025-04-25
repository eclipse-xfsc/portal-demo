package eu.gaia_x.demo.admin.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AcceptDenyRq {
    private String id;
    private String status;
    private Object sd;
}
