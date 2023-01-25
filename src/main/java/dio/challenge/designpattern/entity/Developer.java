package dio.challenge.designpattern.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "developer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Developer extends Employee {
    @Column(nullable = false)
    private String seniority;

    @Column(nullable = false)
    private String stack;
}
