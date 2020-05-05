package ru.agiletech.teammate.service.input.ports.presentation.hateoas;

import lombok.experimental.UtilityClass;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import ru.agiletech.teammate.service.application.teammate.TeammateDTO;
import ru.agiletech.teammate.service.input.ports.presentation.TeammateResource;

@UtilityClass
public class LinksUtil {

    public void addLinks(TeammateDTO teammateDTO){
        addSelfLink(teammateDTO);
        addAllTeammatesLink(teammateDTO);
        addRoleLink(teammateDTO);
    }

    private void addSelfLink(TeammateDTO teammateDTO){
        teammateDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeammateResource.class)
                .getTeammate(teammateDTO.getId()))
                .withSelfRel());
    }

    private void addAllTeammatesLink(TeammateDTO teammateDTO){
        teammateDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeammateResource.class)
                .getAllTeammates())
                .withRel("allTeammates"));
    }

    private void addRoleLink(TeammateDTO teammateDTO){
        teammateDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeammateResource.class)
                .changeRole(teammateDTO.getId(),null))
                .withRel("role"));
    }

}
