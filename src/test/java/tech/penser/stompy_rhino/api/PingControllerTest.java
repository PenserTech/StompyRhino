package tech.penser.stompy_rhino.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // using this instead of @WebMVCTest to ensure entire spring env is loaded
@AutoConfigureMockMvc
@Testcontainers
public class PingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16-alpine");

    @Test
    void shouldReturnUnauthorizedForUnauthenticatedAccess() throws Exception {
        mockMvc.perform(get("/api/v1/ping"))
                .andExpect(status().isUnauthorized()); // Expect 401 Unauthorized
    }

    @Test
    void shouldReturnUnauthorizedForInvalidUserAccess() throws Exception {
        mockMvc.perform(get("/api/v1/ping")
                .with(httpBasic("invaliduser", "invalidpassword")))
                .andExpect(status().isUnauthorized()); // Expect 401 Unauthorized
    }

    @Test
    void givenAuthenticatedUser_whenCallingNonExistentEndpoint_thenReturnsNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/nonexistent")
            .with(user("testuser")))
            .andExpect(status().isNotFound());
    }

    @Test
    void getAuthenticatedUser_thenReturnsOK() throws Exception {
        mockMvc.perform(get("/api/v1/ping")
                .with(httpBasic("user", "password")))
                .andExpect(status().isOk());
    }

}
