package com.dsoccer1980.web;

import com.dsoccer1980.domain.UserData;
import com.dsoccer1980.dto.SectorDto;
import com.dsoccer1980.service.SectorService;
import com.dsoccer1980.service.UserDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SectorService sectorService;

    @MockBean
    private UserDataService userDataService;


    @Test
    void testShowSectors() throws Exception {
        given(sectorService.getSectorDtoList())
                .willReturn(List.of(new SectorDto(1, 0, "name", true)));

        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("name")));
    }

    @Test
    void testAccept() throws Exception {
        given(userDataService.save(any(UserData.class))).willReturn(new UserData(1, "Name", true, "1,19"));

        mvc.perform(post("/accept")
                .param("name", "Name")
                .param("sectors", "1,19")
                .param("isAgree", "true"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
