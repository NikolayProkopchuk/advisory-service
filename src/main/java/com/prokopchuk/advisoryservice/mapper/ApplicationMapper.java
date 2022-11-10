package com.prokopchuk.advisoryservice.mapper;

import com.prokopchuk.advisoryservice.dto.ApplicationDto;
import com.prokopchuk.advisoryservice.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDto applicationToApplicationDto(Application application);
}
