package com.dancoghlan.runtracker.service;

import com.dancoghlan.runtracker.model.RunDto;

import java.util.List;

public interface RunService {

    void save(RunDto runDto);

    List<RunDto> getAll();

    void delete(long id);

    Double getTotalDistance();

}
