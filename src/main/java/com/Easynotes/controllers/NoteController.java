package com.Easynotes.controllers;


import com.Easynotes.models.NoteRequest;
import com.Easynotes.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class NoteController {

    private NoteService service;

    @RequestMapping(value = "api/note",method = RequestMethod.POST)
    ResponseEntity<?> create(@RequestBody NoteRequest request){
        return service.create(request);
    }
    @RequestMapping(value = "api/note/{id}",method = RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }
    @RequestMapping(value = "api/note/{id}",method = RequestMethod.GET)
    ResponseEntity<?> read(@PathVariable Long id){
        return service.find(id);
    }
    @RequestMapping(value = "api/note/{id}",method = RequestMethod.PATCH)
    ResponseEntity<?> update(@RequestBody NoteRequest request,@PathVariable Long id){
        return service.update(id,request);
    }
}
