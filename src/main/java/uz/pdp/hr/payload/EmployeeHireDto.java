package uz.pdp.hr.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHireDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Double salary;

    @NotNull
    @Email
    private String email;

    private Integer companyId;
}
