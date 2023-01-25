package dio.challenge.designpattern.controller;

import dio.challenge.designpattern.dto.CreateDeveloperDTO;
import dio.challenge.designpattern.entity.Developer;
import dio.challenge.designpattern.exception.BusinessRuleException;
import dio.challenge.designpattern.service.DeveloperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/dev")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Developer registerNewDeveloper(@Valid @RequestBody CreateDeveloperDTO developer) {
        return developerService.createDeveloper(developer);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Developer> getDeveloperById(@PathVariable Long id) {
        return developerService.getDeveloper(id);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<List<Developer>> getDevelopers() {
        return developerService.getAllDevelopers();
    }

    @PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Developer> updateDeveloperById(@PathVariable Long id, @Valid @RequestBody Developer developer) throws BusinessRuleException {
        return developerService.updateDeveloper(id, developer);
    }

    @DeleteMapping(path = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public boolean deleteDeveloperById(@PathVariable Long id) throws BusinessRuleException {
        return developerService.deleteDeveloper(id);
    }
}