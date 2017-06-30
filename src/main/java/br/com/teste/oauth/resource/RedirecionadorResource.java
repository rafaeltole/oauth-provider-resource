package br.com.teste.oauth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/redirecionador")
public class RedirecionadorResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "{aplicacao}", produces = "application/json")
    public ResponseEntity<String> redirecionaAplicacao(@PathVariable("aplicacao") String aplicacao) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer 916d937f-4adc-412f-9655-0b8065d45dcc");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return restTemplate.exchange("http://localhost:8380/oauth-aplicacao/aplicacao/autenticado", HttpMethod.POST, entity, String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
