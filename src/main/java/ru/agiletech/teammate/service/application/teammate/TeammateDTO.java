package ru.agiletech.teammate.service.application.teammate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeammateDTO extends RepresentationModel<TeammateDTO> {

    private String      id;

    @NotEmpty
    private String      login;

    @NotEmpty
    private String      name;

    @NotEmpty
    private String      surName;

    private String      patronymic;

    @NotEmpty
    private String      password;

    @NotEmpty
    private String      email;

    private String      phoneNumber;

    private LocalDate createDate;

    private String      role;

    private Set<String> openTasks;

}
