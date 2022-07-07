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
                                                 @RequestParam Optional<Integer> size) {

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
