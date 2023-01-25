package dio.challenge.designpattern.dto;

import dio.challenge.designpattern.entity.Recruiter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CreateRecruiterDTO {
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "salary cannot be null")
    private BigDecimal salary;

    @NotBlank(message = "seniority cannot be blank")
    private String seniority;

    @NotBlank(message = "recruitArea cannot be blank")
    private String recruitArea;

    public Recruiter toEntity() {
        Recruiter recruiter = new Recruiter();
        BeanUtils.copyProperties(this, recruiter);
        return recruiter;
    }
}