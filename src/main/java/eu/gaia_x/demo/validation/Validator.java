package eu.gaia_x.demo.validation;


import eu.gaia_x.demo.sd.model.SdDetailsDto;

public class Validator {

    public static boolean validateSdObj(SdDetailsDto dto) {
        for (SdDetailsDto.Attribute attribute : dto.getAttributes()) {
            boolean mandatory = attribute.isMandatory();
            String value = attribute.getValue();
            boolean valid = mandatory && (value != null && !value.isEmpty());
            if (!valid) return false;
        }
        return true;
    }


}
