package com.ryz.sh.service;

import com.ryz.sh.pojo.User;
import com.ryz.sh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public void save(){
        userRepository.save(new User("20","ryz201",20));
        userRepository.save(new User("21","ryz211",20));
        userRepository.save(new User("22","ryz221",20));
        userRepository.save(new User("22","ryz222",20));
        userRepository.save(new User("23","ryz231",20));
    }

    public User findUserById(String id){
        return userRepository.findUserById(id);
    }
}
