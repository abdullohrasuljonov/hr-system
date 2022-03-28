package uz.pdp.hr.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourniquetCardDto {

    @NotNull
    private String employeeEmail;
}
