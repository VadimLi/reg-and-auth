package com.hellokoding.account.repository;

import com.hellokoding.account.model.City;
import com.hellokoding.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Role, Long> {
    City findByCity(final String city);
}
