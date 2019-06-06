package com.dsoccer1980.web;

import com.dsoccer1980.service.SectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final SectorService sectorService;

    public MainController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/")
    public String showSectors(Model model) {
        model.addAttribute("sectors_dto", sectorService.getSectorDtoList());
        return "index";
    }


}