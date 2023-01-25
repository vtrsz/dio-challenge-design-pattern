package dio.challenge.designpattern.service;

import dio.challenge.designpattern.dto.CreateDeveloperDTO;
import dio.challenge.designpattern.entity.Developer;
import dio.challenge.designpattern.exception.BusinessRuleException;
import dio.challenge.designpattern.repository.DeveloperRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {
    @Autowired
    DeveloperRepository developerRepository;

    public Developer createDeveloper(CreateDeveloperDTO developerDTO) {
        Developer developer = developerDTO.toEntity();
        developerRepository.save(developer);
        return developer;
    }

    public Optional<Developer> getDeveloper(Long id) {
        Optional<Developer> dev = developerRepository.findById(id);
        if (dev.isEmpty()) {
            return Optional.empty();
        }
        return dev;
    }

    public Optional<List<Developer>> getAllDevelopers() {
        return developerRepository.findAllByOrderByIdAsc();
    }

    public Optional<Developer> updateDeveloper(Long id, Developer developer) throws BusinessRuleException {
        Optional<Developer> dev = developerRepository.findById(id);
        if (dev.isEmpty()) {
            throw new BusinessRuleException("Não foi possível localizar este desenvolvedor.");
        }
        if (dev.get().getId() != developer.getId()) {
            throw new BusinessRuleException("O id de parâmetro não corresponde com o id do objeto.");
        }
        BeanUtils.copyProperties(developer, dev.get());
        developerRepository.save(dev.get());
        return dev;
    }

    public boolean deleteDeveloper(Long id) throws BusinessRuleException {
        Optional<Developer> dev = developerRepository.findById(id);
        if (dev.isEmpty()) {
            throw new BusinessRuleException("Não foi possível localizar este desenvolvedor.");
        }
        developerRepository.deleteById(id);
        return true;
    }
}