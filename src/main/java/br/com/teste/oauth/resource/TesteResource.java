package br.com.teste.oauth.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteResource {

    @RequestMapping(path = "/semToken", produces = "application/json")
    public ResponseEntity<String> semToken() {
        return ResponseEntity.ok("{\"msg\":\"Acesso SEM Token :: Ok\"}");
    }

    @RequestMapping(path = "/comToken", produces = "application/json")
    public ResponseEntity<String> comToken() {
        return ResponseEntity.ok("{\"msg\":\"Acesso COM Token :: Ok\"}");
    }

}
