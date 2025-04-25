package eu.gaia_x.demo.config;

import eu.gaia_x.demo.onboarding.util.RegisterResult;
import eu.gaia_x.demo.utils.EmailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.image.BufferedImage;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
      }
    };
  }

  @Bean
  public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
    return new BufferedImageHttpMessageConverter();
  }

  @Bean(name = "kcSrv")
  public WebClient kcSrv(@Value("${int.keycloak.uri}") final String extURI) {
    return WebClient.builder()
                    .baseUrl(extURI)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                    .build();
  }

  @Bean
  public EmailSender createEmailSender() {
    return new eu.gaia_x.demo.utils.EmailSender() {

      @Override
      public RegisterResult sendEmailRegistrationMessage(final String email, final String routing) {
        return null;
      }
    };
  }
}