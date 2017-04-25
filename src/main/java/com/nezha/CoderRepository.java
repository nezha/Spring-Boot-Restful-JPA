package com.nezha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by nezha on 2017/4/25.
 */
public interface CoderRepository extends JpaRepository<Coder,Integer> {

    public List<Coder> findByAge(Integer age);

    @Query("select p from Coder p where p.id = (select max(p2.id) from Coder p2)")
    Coder getMaxIdCoder();
}
