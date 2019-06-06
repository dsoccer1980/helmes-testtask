package com.dsoccer1980.services;

import com.dsoccer1980.domain.Sector;
import com.dsoccer1980.dto.SectorDto;
import com.dsoccer1980.service.SectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class SectorServiceTest {

    @Autowired
    private SectorService sectorService;

    @BeforeEach
    void beforeEach() {
        sectorService.deleteAll();
    }


    @Test
    void getAll() {
        Sector sector1 = new Sector(1, 0, "name1");
        Sector sector2 = new Sector(2, 1, "name2");
        sectorService.save(sector1);
        sectorService.save(sector2);
        assertThat(sectorService.getAllSectors()).isEqualTo(Arrays.asList(sector1, sector2));
    }

    @Test
    void findNyParentId() {
        Sector sector1 = new Sector(1, 0, "name1");
        Sector sector2 = new Sector(2, 1, "name2");
        Sector sector3 = new Sector(3, 1, "name2");
        Sector sector4 = new Sector(4, 0, "name2");
        sectorService.save(sector1);
        sectorService.save(sector2);
        sectorService.save(sector3);
        sectorService.save(sector4);
        assertThat(sectorService.getSectorsByParentId(1)).isEqualTo(Arrays.asList(sector2, sector3));
    }

    @Test
    void getSectorDtoList() {
        Sector sector1 = new Sector(1, 0, "name1");
        Sector sector2 = new Sector(2, 1, "name2");
        Sector sector3 = new Sector(3, 1, "name2");
        Sector sector4 = new Sector(4, 0, "name2");

        SectorDto sectorDto1 = SectorDto.getSectorDto(sector1, 0);
        SectorDto sectorDto2 = SectorDto.getSectorDto(sector2, 1);
        SectorDto sectorDto3 = SectorDto.getSectorDto(sector3, 1);
        SectorDto sectorDto4 = SectorDto.getSectorDto(sector4, 0);

        sectorService.save(sector1);
        sectorService.save(sector2);
        sectorService.save(sector3);
        sectorService.save(sector4);

        assertThat(sectorService.getSectorDtoList()).isEqualTo(Arrays.asList(sectorDto1, sectorDto2, sectorDto3, sectorDto4));

    }


}
