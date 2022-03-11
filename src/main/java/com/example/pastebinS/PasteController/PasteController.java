package com.example.pastebinS.PasteController;

import com.example.pastebinS.Paste.Paste;
import com.example.pastebinS.PasteService.PasteService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PasteController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
    private final PasteService pasteService;

    @Autowired
    public PasteController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("Paste", new Paste());
        return "pasteForm";
    }

    @RequestMapping(value = "/pastes", method = RequestMethod.GET)
    public String getPastes(Model model) {
        List<Paste> pastes = pasteService.getPastes();
        model.addAttribute("pastes", pastes);
        return "pastes";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPaste (Model model, @ModelAttribute Paste paste) {
        Paste somePaste = pasteService.createPaste(paste);
        return "redirect:/create/";
    }

    @RequestMapping(value = "/pastes/{id}", method = RequestMethod.GET)
    public String getPaste(Model model, @PathVariable Integer id) {
        List<Paste> pastes = pasteService.getPasteById(id);
        model.addAttribute("pastes", pastes);
        return "PasteById";
    }

}
