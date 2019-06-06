package com.dsoccer1980.repository;

import com.dsoccer1980.domain.Sector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class SectorRepositoryTest {

    @Autowired
    private SectorRepository repository;

    @BeforeEach
    void beforeEach() {
        repository.deleteAll();
    }

    @Test
    void getAll() {
        Sector sector1 = new Sector(1, 0, "name1");
        Sector sector2 = new Sector(2, 1, "name2");
        repository.save(sector1);
        repository.save(sector2);
        assertThat(repository.findAll()).isEqualTo(Arrays.asList(sector1, sector2));
    }

    @Test
    void findByParentId() {
        Sector sector1 = new Sector(1, 0, "name1");
        Sector sector2 = new Sector(2, 1, "name2");
        Sector sector3 = new Sector(3, 1, "name2");
        Sector sector4 = new Sector(4, 0, "name2");
        repository.save(sector1);
        repository.save(sector2);
        repository.save(sector3);
        repository.save(sector4);
        assertThat(repository.findAllByParentId(1)).isEqualTo(Arrays.asList(sector2, sector3));
    }
}
