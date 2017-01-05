package com.hellokoding.account.service;


import com.hellokoding.account.model.City;
import com.hellokoding.account.model.Role;
import com.hellokoding.account.model.User;
import com.hellokoding.account.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class CityDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CitiesRepository citiesRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String cityString) throws UsernameNotFoundException {
        City city = citiesRepository.findByCity(cityString);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (City cities : city.getCity()){
            grantedAuthorities.add(new SimpleGrantedAuthority(city.getCity()));
        }

    }


}
