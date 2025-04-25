package eu.gaia_x.demo.utils;

import eu.gaia_x.demo.onboarding.util.RegisterResult;

public interface EmailSender {
  RegisterResult sendEmailRegistrationMessage(String email, String routing);
}
