package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.Users;
import com.filrouge.filrouge.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Users userSave(Users users) {
        return usersRepository.save(users);
    }

    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }
}
