package com.nezha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by nezha on 2017/4/25.
 */
@Service
public class CoderService {
    @Autowired
    CoderRepository coderRepository;

    @Transactional
    public void insertTwo(){
        Coder coderA = new Coder();
        coderA.setAge(101);
        coderA.setName("1");
        coderRepository.save(coderA);

        Coder coderB = new Coder();
        coderB.setAge(102);
        coderB.setName("102");
        coderRepository.save(coderB);

    }
}
