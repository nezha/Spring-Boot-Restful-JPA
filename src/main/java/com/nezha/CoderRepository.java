package com.nezha;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by nezha on 2017/4/25.
 */
public interface CoderRepository extends JpaRepository<Coder,Integer> {

    public List<Coder> findByAge(Integer age);
}
