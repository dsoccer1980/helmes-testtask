package com.dsoccer1980.web;

import com.dsoccer1980.domain.UserData;
import com.dsoccer1980.dto.SectorDto;
import com.dsoccer1980.service.SectorService;
import com.dsoccer1980.service.UserDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private final SectorService sectorService;
    private final UserDataService userDataService;

    public MainController(SectorService sectorService, UserDataService userDataService) {
        this.sectorService = sectorService;
        this.userDataService = userDataService;
    }

    @GetMapping("/")
    public String showSectors(Model model) {
        model.addAttribute("sectors_dto", sectorService.getSectorDtoList());
        return "index";
    }

    @PostMapping(value = "/accept")
    public String accept(@RequestParam(value = "id", required = false) String id,
                         @RequestParam(value = "name") String name,
                         @RequestParam(value = "sectors") List<String> sectors,
                         @RequestParam(value = "isAgree") boolean isAgree,
                         Model model) {

        UserData userData = new UserData(name, isAgree, String.join(",", sectors));
        if (id != null && !id.isEmpty()) {
            userData.setId(Integer.parseInt(id));
        }

        UserData saveUsedData = userDataService.save(userData);

        Set<String> selectedSectors = Set.of(saveUsedData.getSectors().split(","));
        List<SectorDto> sectorDtoList = sectorService.getSectorDtoList();
        setSelectedSectors(sectorDtoList, selectedSectors);

        model.addAttribute("sectors_dto", sectorDtoList);
        model.addAttribute("id", saveUsedData.getId());
        model.addAttribute("name", saveUsedData.getName());
        model.addAttribute("is_agree", saveUsedData.isAgree());
        return "index";
    }

    private void setSelectedSectors(List<SectorDto> sectorDtoList, Set<String> chosenSectors) {
        sectorDtoList.stream()
                .filter(sectorDto -> chosenSectors.contains(String.valueOf(sectorDto.getId())))
                .forEach(sectorDto -> sectorDto.setSelected(true));
    }


}