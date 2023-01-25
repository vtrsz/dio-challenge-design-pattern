package dio.challenge.designpattern.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "recruiter")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Recruiter extends Employee {
    @Column(nullable = false)
    private String seniority;

    @Column(nullable = false)
    private String recruitArea;
}
