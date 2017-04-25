package com.nezha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nezha on 2017/4/25.
 */
@RestController
public class CoderController {
    @Autowired
    private CoderRepository coderRepository;

    @Autowired
    private CoderService coderService;

    //1.Get方式请求，查询所有程序员信息
    @GetMapping(value = "/coders")
    public List<Coder> coderList(){
        return coderRepository.findAll();
    }
    //2.Post方式，增加程序员
    @PostMapping(value = "/coders")
    public Coder CoderAdd(@RequestParam("name")String name,@RequestParam("age")Integer age){
        Coder coder = new Coder();
        coder.setAge(age);
        coder.setName(name);
        return  coderRepository.save(coder);

    }
    //3.通过id查询一个人
    @GetMapping(value = "/coders/{id}")
    public Coder CoderFindOne(@PathVariable("id")Integer id){
        return coderRepository.findOne(id);
    }
    //4.通过id删除一个人
    @DeleteMapping(value = "/coders/{id}")
    public void CoderDelete(@PathVariable("id")Integer id){
        coderRepository.delete(id);
    }

    //5.更新一个人
    @PutMapping(value = "/coders/{id}")
    public Coder CoderUpdateOne(@PathVariable("id")Integer id, @RequestParam("name") String name, @RequestParam("age")Integer age){
        Coder coder = new Coder();
        coder.setId(id);
        coder.setName(name);
        coder.setAge(age);
        return coderRepository.save(coder);
    }

    //6.扩展Jpa接口，按照年龄查找
    @GetMapping(value = "/coder/age/{age}")
    public List<Coder> CoderFindAll(@PathVariable("age")Integer age){
        return coderRepository.findByAge(age);
    }

    //7.使用事务，同时插入两个人的数据
    @PostMapping(value = "coder/two")
    public void coderTwo(){
        coderService.insertTwo();
    }

}
