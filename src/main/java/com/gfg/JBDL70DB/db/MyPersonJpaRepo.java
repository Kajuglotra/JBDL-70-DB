package com.gfg.JBDL70DB.db;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MyPersonJpaRepo extends JpaRepository<MyPerson, Integer> {
}
