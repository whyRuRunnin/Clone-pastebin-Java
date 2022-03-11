package com.example.pastebinS.PasteRepository;

import com.example.pastebinS.Paste.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PasteRepository extends JpaRepository<Paste, Integer> {
}
