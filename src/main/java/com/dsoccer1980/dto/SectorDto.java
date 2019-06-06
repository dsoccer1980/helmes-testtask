package com.dsoccer1980.dto;

import com.dsoccer1980.domain.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectorDto {

    private int id;
    private int level;
    private String name;
    private boolean isSelected;

    public static SectorDto getSectorDto(Sector sector, int level) {
        return new SectorDto(sector.getId(), level, sector.getName(), false);
    }
}
