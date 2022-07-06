package com.magadiflo.pagination.service.implementation;

import com.magadiflo.pagination.domain.User;
import com.magadiflo.pagination.repository.UserRepository;
import com.magadiflo.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor //Permitirá definir el constructor con la propiedad final userRepository, de esa manera haremos la inyección de dependencia del repository vía constructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("Fetching users for page {} of size {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return this.userRepository.findByNameContaining(name, pageable);
    }

}
