package com.example.pastebinS.PasteService;

import com.example.pastebinS.Paste.Paste;
import com.example.pastebinS.PasteRepository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasteService {
    @Autowired
    private final PasteRepository pasteRepository;

    public PasteService(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    public List<Paste> getPastes() {
        return pasteRepository.findAll();
    }

    public Paste createPaste(Paste paste) {
        if (paste.getTitle().length() > 100) {
            throw new IllegalArgumentException("Please keep the length of the title under 100 characters");
        } else if (paste.getTitle().length() < 5) {
            throw new IllegalArgumentException("The title has to be at least 5 characters long");
        }
        return pasteRepository.save(paste);
    }

    public List <Paste> getPasteById(Integer id) {
        return getPastes().stream().filter(p -> p.getId() == id).collect(Collectors.toList());
    }
}
