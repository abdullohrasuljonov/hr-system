package uz.pdp.hr.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Integer deadlineDay;

    @NotNull
    private String email;
}
