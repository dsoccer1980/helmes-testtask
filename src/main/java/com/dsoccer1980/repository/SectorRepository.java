package com.dsoccer1980.repository;

import com.dsoccer1980.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SectorRepository extends JpaRepository<Sector, Integer> {

    List<Sector> findAllByParentId(int id);

}
