package dio.challenge.designpattern.repository;

import dio.challenge.designpattern.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Optional<List<Recruiter>> findAllByOrderByIdAsc();
}
