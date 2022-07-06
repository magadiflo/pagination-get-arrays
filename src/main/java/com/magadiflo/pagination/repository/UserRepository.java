package com.magadiflo.pagination.repository;

import com.magadiflo.pagination.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository //Es opcional definir esta anotación
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findByNameContaining(String name, Pageable pageable);

}
