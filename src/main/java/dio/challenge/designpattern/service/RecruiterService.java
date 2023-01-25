package dio.challenge.designpattern.service;

import dio.challenge.designpattern.dto.CreateRecruiterDTO;
import dio.challenge.designpattern.entity.Recruiter;
import dio.challenge.designpattern.exception.BusinessRuleException;
import dio.challenge.designpattern.repository.RecruiterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository recruiterRepository;

    public Recruiter createRecruiter(CreateRecruiterDTO recruiterDTO) {
        Recruiter recruiter = recruiterDTO.toEntity();
        recruiterRepository.save(recruiter);
        return recruiter;
    }

    public Optional<Recruiter> getRecruiter(Long id) {
        Optional<Recruiter> recruiter = recruiterRepository.findById(id);
        if (recruiter.isEmpty()) {
            return Optional.empty();
        }
        return recruiter;
    }

    public Optional<List<Recruiter>> getAllRecruiters() {
        return recruiterRepository.findAllByOrderByIdAsc();
    }

    public Optional<Recruiter> updateRecruiter(Long id, Recruiter recruiter) throws BusinessRuleException {
        Optional<Recruiter> rec = recruiterRepository.findById(id);
        if (rec.isEmpty()) {
            throw new BusinessRuleException("Não foi possível localizar este recrutador.");
        }
        if (rec.get().getId() != recruiter.getId()) {
            throw new BusinessRuleException("O id de parâmetro não corresponde com o id do objeto.");
        }
        BeanUtils.copyProperties(recruiter, rec.get());
        recruiterRepository.save(rec.get());
        return rec;
    }

    public boolean deleteRecruiter(Long id) throws BusinessRuleException {
        Optional<Recruiter> recruiter = recruiterRepository.findById(id);
        if (recruiter.isEmpty()) {
            throw new BusinessRuleException("Não foi possível localizar este recrutador.");
        }
        recruiterRepository.deleteById(id);
        return true;
    }
}