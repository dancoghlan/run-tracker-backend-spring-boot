package com.dancoghlan.runtracker.mapper;

import com.dancoghlan.runtracker.entity.RunEntity;
import com.dancoghlan.runtracker.model.RunDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RunDtoToEntityMapper {

    RunDtoToEntityMapper INSTANCE = Mappers.getMapper(RunDtoToEntityMapper.class);

    @Mappings({
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "time", source = "time"),
            @Mapping(target = "distance", source = "distance"),
            @Mapping(target = "pace", source = "pace")
    })
    RunEntity dtoToEntity(RunDto entity);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "time", source = "time"),
            @Mapping(target = "distance", source = "distance"),
            @Mapping(target = "pace", source = "pace")
    })
    RunDto entityToDto(RunEntity entity);

}
