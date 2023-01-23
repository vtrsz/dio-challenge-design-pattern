package dio.challenge.designpattern.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "developer")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Developer extends Worker {
    @Column(nullable = false)
    private String seniority;

    @Column(nullable = false)
    private String stack;
}
