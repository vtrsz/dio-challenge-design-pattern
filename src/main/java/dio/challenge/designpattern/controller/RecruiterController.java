package dio.challenge.designpattern.controller;

import dio.challenge.designpattern.dto.CreateRecruiterDTO;
import dio.challenge.designpattern.entity.Recruiter;
import dio.challenge.designpattern.exception.BusinessRuleException;
import dio.challenge.designpattern.service.RecruiterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/recruiter")
public class RecruiterController {
    @Autowired
    RecruiterService recruiterService;

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Recruiter registerNewRecruiter(@Valid @RequestBody CreateRecruiterDTO recruiter) {
        return recruiterService.createRecruiter(recruiter);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Recruiter> getRecruiterById(@PathVariable Long id) {
        return recruiterService.getRecruiter(id);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<List<Recruiter>> getRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Recruiter> updateRecruiterById(@PathVariable Long id, @Valid @RequestBody Recruiter recruiter) throws BusinessRuleException {
        return recruiterService.updateRecruiter(id, recruiter);
    }

    @DeleteMapping(path = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public boolean deleteRecruiterById(@PathVariable Long id) throws BusinessRuleException {
        return recruiterService.deleteRecruiter(id);
    }
}