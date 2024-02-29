package com.beeliveit.demo.controller;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beeliveit.demo.model.Squadra;
import com.beeliveit.demo.repository.SquadraRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Squadre")
public class SquadraController {
    
    @Autowired
    SquadraRepository squadraRepository;

//-------------------------------------------------------------------------    

@GetMapping("/elenco")
public String elencoSquadre (   Model model,
                                @RequestParam(required = false) String nome,
                                @RequestParam(required = false) String citta,
                                @RequestParam(required = false) Integer punteggio,
                                @RequestParam(required = false) String ordinamento) {
    
    ArrayList<Squadra> elencoSquadra = null;

    if (nome==null && citta==null && punteggio == null) {
        elencoSquadra = (ArrayList<Squadra>) squadraRepository.findAll();
    }

    // todo finire aggiungendo altri filti

    Collections.sort(elencoSquadra);
    
    model.addAttribute("elenco", elencoSquadra);
    
    
    return "/squadra/elenco";
}

//------------------------------------------------------------------------------------------

	@GetMapping("/nuovo")
	public String nuovaSquadraGet(Model model) {
		Squadra s = new Squadra();
	
		model.addAttribute("squadra", s);

		return "squdra/nuova";
	}

	@PostMapping("/nuovo")
	public String nuovaSquadraPost(@ModelAttribute("squadra") Squadra s) {

        if (s.getPunteggio()>=25 && s.getPunteggio()<=50) {
            squadraRepository.save(s);
            return "redirect:/Squadre/elenco";
        }
        else{
            return "punteggio non valido";
        }

        
	}


}
