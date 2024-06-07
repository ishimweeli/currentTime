package checks.currenttime.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TimeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetCurrentTime() {
        ResponseEntity<String> response = restTemplate.getForEntity("/time", String.class);
        assertThat(response.getBody()).startsWith("Current time is: ");
    }
}