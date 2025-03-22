# cp-payment-service

# Starting the KeyCloak Locally 
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -v C:\\Users\\Prakash\\key:/opt/keycloak/data quay.io/keycloak/keycloak:23.0.4 start-dev

# Website fro Keycloak Integeration
https://medium.com/javarevisited/keycloak-integration-with-spring-security-6-37999f43ec85

# Chatgpt for Service to Service
https://chatgpt.com/c/67d9b69d-0f48-800a-a6e7-5f8437f9503a

# Way to generate the service to service token
curl -X POST "http://localhost:8080/realms/spring-boot-realm/protocol/openid-connect/token" -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=client_credentials" -d "client_id=spring-boot-client" -d "client_secret=jhOuiJ97GAvmBpPwQC2W9fGu7uq0Edd5"



