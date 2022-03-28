package uz.pdp.hr.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.hr.entity.Task;
import uz.pdp.hr.entity.TourniquetHistory;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<Task> tasks;
    private List<TourniquetHistory> histories;
}
