package com.dsoccer1980.repository;

import com.dsoccer1980.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDataRepository extends JpaRepository<UserData, Integer> {


}
