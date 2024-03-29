package com.dsoccer1980.service;

import com.dsoccer1980.domain.UserData;
import com.dsoccer1980.repository.UserDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    private final UserDataRepository repository;

    public UserDataService(UserDataRepository repository) {
        this.repository = repository;
    }

    public UserData save(UserData userData) {
        return repository.save(userData);
    }

    public List<UserData> getAll() {
        return repository.findAll();
    }

}
