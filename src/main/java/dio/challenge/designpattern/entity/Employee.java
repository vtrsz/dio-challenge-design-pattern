package dio.challenge.designpattern.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal salary;

}
