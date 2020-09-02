package com.dancoghlan.runtracker.controller;

import com.dancoghlan.runtracker.model.RunDto;
import com.dancoghlan.runtracker.service.RunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/rest")
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private RunService runService;

    @PostMapping(path = "/save", consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody RunDto runDto) {
        runService.save(runDto);
    }

    @GetMapping(path = "/getAll")
    @ResponseBody
    public List<RunDto> getAll() {
        List<RunDto> runDtos = runService.getAll();
        return runDtos;
    }

    @GetMapping(path = "/getTotalDistance")
    @ResponseBody
    public Double getTotalDistance() {
        return runService.getTotalDistance();
    }

    @DeleteMapping(path = "/delete")
    public void deleteById(@RequestParam long id) {
        runService.delete(id);
    }

}
