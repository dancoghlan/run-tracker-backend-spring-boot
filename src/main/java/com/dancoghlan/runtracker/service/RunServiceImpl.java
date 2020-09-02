package com.dancoghlan.runtracker.service;

import com.dancoghlan.runtracker.entity.RunEntity;
import com.dancoghlan.runtracker.mapper.RunDtoToEntityMapper;
import com.dancoghlan.runtracker.model.RunDto;
import com.dancoghlan.runtracker.repository.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RunServiceImpl implements RunService {
    private static final Logger logger = LoggerFactory.getLogger(RunServiceImpl.class);
    private final RunRepository repository;
    private final RunDtoToEntityMapper mapper;

    @Autowired
    public RunServiceImpl(RunRepository repository) {
        this.repository = repository;
        this.mapper = RunDtoToEntityMapper.INSTANCE;
    }

    @Override
    public void save(RunDto runDto) {
        RunEntity entity = mapper.dtoToEntity(runDto);
        repository.save(entity);
        logger.info("Saved run [{}]", runDto);
    }

    @Override
    public List<RunDto> getAll() {
        List<RunDto> runEntities = repository.findAll().stream()
                .map(f -> mapper.entityToDto(f))
                .sorted((f1, f2) -> f2.getDate().compareTo(f1.getDate()))
                .collect(Collectors.toList());
        logger.info("Retrieved [{}] runs", runEntities.size());
        return runEntities;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
        logger.info("Deleted run [{}]", id);
    }

    @Override
    public Double getTotalDistance() {
        return repository.getTotalDistance();
    }

}
