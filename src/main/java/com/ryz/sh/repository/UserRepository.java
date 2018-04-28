package com.ryz.sh.repository;

import com.ryz.sh.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="user")
public interface UserRepository extends CrudRepository<User,Long>{

    public User findUserById(String id);


    @Override
    List<User> findAll();




}
