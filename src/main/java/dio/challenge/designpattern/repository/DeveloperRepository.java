package dio.challenge.designpattern.repository;

import dio.challenge.designpattern.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<List<Developer>> findAllByOrderByIdAsc();
}
