# Mocking Demo service
This application is implemented in order to mock all external systems which should be integrated with the Portal afterwards.
In order to run this application locally, the following should be satisfied:
- Identity system (keycloak) should be accessible from localhost
- Valid SMTP account should be available

## Configuring mailing system
In order to send different emails from this service, the working SMTP server and account should be available.
Configuration is done with the following environment variables:
  * MAIL_SUPPORT_ADDRESS (email address used for "sender") 
  * MAIL_SMTP_HOST (SMTP server's hostname) 
  * MAIL_SMTP_PORT (SMTP port) 
  * MAIL_SMTP_USERNAME (SMTP account's username) 
  * MAIL_SMTP_PASSWORD (SMTP account's password)
All these variables are configured in Portal infrastructure project 
(https://gitlab.com/gaia-x/data-infrastructure-federation-services/por/infra-mesh/-/settings/ci_cd) and contains sensitive information.

For instance, they might have the following values:
  * MAIL_SUPPORT_ADDRESS="noreply@gxfs.dev" 
  * MAIL_SMTP_HOST="in-v3.mailjet.com" 
  * MAIL_SMTP_PORT=587 
  * MAIL_SMTP_USERNAME="314159265759" 
  * MAIL_SMTP_PASSWORD="12345"

## Portal external address
The URL for the Portal itself is a configurable setting incorporated in PORTAL_URL environment variable.
For instance:
  * PORTAL_URL="portal.gxfs.dev"

## Configuring keycloak
In order to protect provided endpoints and develop/test authorization with OIDC, the access to working identity system (keycloak)
should be configured. The following variables should be specified:
  * KC_URL (URL to Keycloak)
  * KC_URL_INT (URL to Keycloak for internal, i.e. not public access - can be the same value as KC_URL)
  * KC_REALM (realm name in Keycloak)
  * KC_RESOURCE (client in Keycloak)
  * KC_CLIENT_SECRET (client secret in Keycloak)

All these variables are configured in Portal infrastructure project 
(https://gitlab.com/gaia-x/data-infrastructure-federation-services/por/infra-mesh/-/settings/ci_cd) and contains sensitive information.

For instance, they might have the following values:
  * KC_URL="http://78.138.66.50/" 
  * KC_URL_INT="http://78.138.66.50/" 
  * KC_REALM="gaiax_realm"
  * KC_RESOURCE="gaiax_client"
  * KC_CLIENT_SECRET="31415"

## Configuration of external systems
Open the application.yml file and configure value for the services.identity.uri.internal setting representing URI for
GAIA-X Federated Catalogue service. For instance:

~~~~
services.identity.uri.internal: http://gaia-x.identity.ext:8081/demo
~~~~

Make sure that such external system is available from your host.


## Application run
With all these configurations, use the following command to run application:

~~~~
$ MAIL_SUPPORT_ADDRESS="noreply@gxfs.dev" MAIL_SMTP_HOST="in-v3.mailjet.com" MAIL_SMTP_PORT=587 \
  MAIL_SMTP_USERNAME="314159265759" MAIL_SMTP_PASSWORD="12345" \
  PORTAL_URL="portal.gxfs.dev" \
  KC_URL="http://78.138.66.50/" KC_URL_INT="http://78.138.66.50/" \
  KC_REALM="gaiax_realm" KC_RESOURCE="gaiax_client" KC_CLIENT_SECRET="31415" \
  ./mvnw clean spring-boot:run
~~~~

The application should be started on localhost and use port, configured in application.yml file:

~~~~
server.port: 8081
~~~~
