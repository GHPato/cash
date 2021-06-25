package com.cash.exam.persistance;

import com.cash.exam.domain.User;
import com.cash.exam.persistance.crud.UserCrudRepository;
import com.cash.exam.persistance.entity.UserEntity;
import com.cash.exam.persistance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository implements com.cash.exam.domain.repository.UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userCrudRepository.findAll();
        return (List<User>) mapper.toUser((UserEntity) users);
    }

    @Override
    public Optional<User> getUserById (int id) {
       return userCrudRepository.findById(id).map(UserEntity -> mapper.toUser((com.cash.exam.persistance.entity.UserEntity) UserEntity));
    }

    @Override
    public void deleteUser(int id) {
        userCrudRepository.deleteById(id);
    }

    @Override
    public User addUser(User user) {
        UserEntity userEntity = mapper.toUserEntity(user);
        userEntity.getLoanEntities().forEach(loan -> loan.setUserEntity(userEntity));
        return mapper.toUser((userCrudRepository.save(userEntity)));

    }

}
