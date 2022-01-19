package com.Easynotes.services;

import com.Easynotes.models.Note;
import com.Easynotes.models.NoteRequest;
import com.Easynotes.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public ResponseEntity<?> create(NoteRequest request){
        Note note;
        try{
            note = new Note(request.getContent());
        }catch (Exception e){
            return new ResponseEntity<>("bad body", HttpStatus.BAD_REQUEST);
        }
        repository.save(note);

        return new ResponseEntity<>("note created",HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Long id,NoteRequest request){
        Note toUpdate;
        try{
            toUpdate = new Note(request.getContent());
        }catch (Exception e){
            return new ResponseEntity<>("bad body", HttpStatus.BAD_REQUEST);
        }
        repository.findById(id).ifPresent(
                note -> {
                    note.updateForm(toUpdate);
                    repository.save(note);
                });
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("deleted",HttpStatus.OK);

    }

    public ResponseEntity<?> find(Long id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

}
