package com.Easynotes.repositories;


import com.Easynotes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
