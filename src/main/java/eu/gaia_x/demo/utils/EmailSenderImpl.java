package eu.gaia_x.demo.utils;

import eu.gaia_x.demo.onboarding.util.RegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

public class EmailSenderImpl implements eu.gaia_x.demo.utils.EmailSender {

    private final JavaMailSender javaMailSender;
    @Value("${support.email}")
    private String senderMail;
    @Value("${email.confirmation.frontend.url}")
    private String confirmationUrl;

    @Autowired
    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public RegisterResult sendEmailRegistrationMessage(String email, String routing) {
        try {
            UUID uniqueId = UUID.randomUUID();
            MimeMessage message = prepareMessage(email, routing, uniqueId.toString());
            javaMailSender.send(message);
            return new RegisterResult(false);
        } catch (MessagingException e) {
            return new RegisterResult(true, e.getMessage() + "; cause: " + e.getLocalizedMessage());
        }
    }

    private MimeMessage prepareMessage(String email, String routing, String uniqueId) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Confirm Registration");
        helper.setFrom(senderMail);
        helper.setTo(email);
        String text = String.format("Please click in the following link to confirm your registration on Gaia-X portal: %s", routing);
        helper.setText(text, true);
        return message;
    }
}
