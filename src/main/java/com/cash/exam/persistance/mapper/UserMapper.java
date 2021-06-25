package com.cash.exam.persistance.mapper;

import com.cash.exam.domain.User;
import com.cash.exam.persistance.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {LoanMapper.class})
public interface UserMapper {
    @Mappings(
            {
                    // Se mapean por default al ser las variables iguales, no hace falta mapearlas
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "firstName", target = "firstName"),
                    @Mapping(source = "lastName", target = "lastName"),
            }
    )
    User toUser(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);
}
