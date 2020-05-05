package ru.agiletech.teammate.service.input.ports.presentation;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.agiletech.teammate.service.application.teammate.TeammateDTO;
import ru.agiletech.teammate.service.application.teammate.TeammateService;
import ru.agiletech.teammate.service.application.teammate.command.ChangeContactsCommand;
import ru.agiletech.teammate.service.application.teammate.command.ChangeFullNameCommand;
import ru.agiletech.teammate.service.application.teammate.command.ChangePasswordCommand;
import ru.agiletech.teammate.service.application.teammate.command.ChangeRoleCommand;
import ru.agiletech.teammate.service.input.ports.presentation.hateoas.LinksUtil;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeammateResource {

    private final TeammateService teammateService;

    @PostMapping(value = "/teammates")
    @ResponseStatus(HttpStatus.CREATED)
    public TeammateDTO createTeammate(@Valid @RequestBody TeammateDTO teammateDTO){
        var createdTeammate = teammateService.createTeammate(teammateDTO);
        LinksUtil.addLinks(createdTeammate);

        return createdTeammate;
    }

    @GetMapping(value = "/teammates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeammateDTO getTeammate(@PathVariable String id){
        var teammate = teammateService.searchTeammate(id);
        LinksUtil.addLinks(teammate);

        return teammate;
    }

    @GetMapping(value = "/teammates")
    @ResponseStatus(HttpStatus.OK)
    public Set<TeammateDTO> getAllTeammates(){
        Set<TeammateDTO> teammates = teammateService.searchAllTeammates();

        if(CollectionUtils.isNotEmpty(teammates))
            teammates.forEach(LinksUtil::addLinks);

        return teammates;
    }

    @PutMapping(value = "/teammates/{id}/fullName")
    public ResponseEntity<Void> changeName(@PathVariable(name = "id")       String teammateId,
                                           @RequestParam                    String name,
                                           @RequestParam                    String surName,
                                           @RequestParam(required = false)  String patronymic){
        ChangeFullNameCommand command = new ChangeFullNameCommand(teammateId,
                name,
                surName,
                patronymic);

        teammateService.changeFullName(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/teammates/{id}/credentials")
    public ResponseEntity<Void> changePassword(@PathVariable(name = "id") String teammateId,
                                               @RequestParam              String password){
        ChangePasswordCommand command = new ChangePasswordCommand(teammateId,
                password);

        teammateService.changePassword(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/teammates/{id}/contacts")
    public ResponseEntity<Void> changeEmail(@PathVariable(name = "id")          String teammateId,
                                            @RequestParam(required = false)     String email,
                                            @RequestParam(required = false)     String phoneNumber){
        ChangeContactsCommand command = new ChangeContactsCommand(teammateId,
                email,
                phoneNumber);

        teammateService.changeContacts(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/teammates/{id}/role")
    public ResponseEntity<Void> changeRole(@PathVariable(name = "id") String teammateId,
                                           @RequestParam              String role){
        ChangeRoleCommand command = new ChangeRoleCommand(teammateId,
                role);

        teammateService.changeRole(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
