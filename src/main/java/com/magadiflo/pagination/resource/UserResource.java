package com.magadiflo.pagination.resource;

import com.magadiflo.pagination.domain.HttpResponse;
import com.magadiflo.pagination.domain.User;
import com.magadiflo.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v0/api")
public class UserResource {

    private final UserService userService;

    /**
     * Se puede poner los valores por defecto en los parámetros del método handler, pero
     * el tutor quiso usar Optionals con el método orElse
     */
    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size) throws InterruptedException {

        //Simularemos el retraso para ver el loading en Angular.
        //Esto se debe eliminar, solo es para probar la interfaz, lo dejaré mientras seguimos desarrollando
        //TimeUnit.SECONDS.sleep(1);

        //Forzamos un error en tiempo de ejecución para ver el comportamiento en Angular
        //throw new RuntimeException("Excepción forzada para la prueba");

        Page<User> userPage = this.userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10));
        Map<String, Page<User>> pageMap = new HashMap<>();
        pageMap.put("page", userPage);

        HttpResponse httpResponse = HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .data(pageMap)
                .message("Users Retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok().body(httpResponse);
    }

}
