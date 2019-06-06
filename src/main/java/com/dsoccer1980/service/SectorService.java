package com.dsoccer1980.service;

import com.dsoccer1980.domain.Sector;
import com.dsoccer1980.dto.SectorDto;
import com.dsoccer1980.repository.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorService {

    private final SectorRepository repository;

    public SectorService(SectorRepository repository) {
        this.repository = repository;
    }

    public List<Sector> getAllSectors() {
        return repository.findAll();
    }

    public List<Sector> getSectorsByParentId(int id) {
        return repository.findAllByParentId(id);
    }

    public Sector save(Sector sector) {
        return repository.save(sector);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<SectorDto> getSectorDtoList() {
        List<Sector> sectorsWithHigherLevel = getSectorsByParentId(0);
        List<SectorDto> result = new ArrayList<>();
        for (Sector sector : sectorsWithHigherLevel) {
            getSubLevelSectorDto(sector, 0, result);
        }
        return result;
    }

    private void getSubLevelSectorDto(Sector sector, int level, List<SectorDto> result) {
        result.add(SectorDto.getSectorDto(sector, level));
        getSectorsByParentId(sector.getId()).forEach(subSector -> getSubLevelSectorDto(subSector, level + 1, result));
    }


}
