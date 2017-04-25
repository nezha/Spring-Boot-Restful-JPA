package com.nezha;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nezha on 2017/4/21.
 */
@RestController
public class HelloController {

    //自动载入PeopleProperities的对象，相当于new 对象
    @Autowired
    private PeopleProperities peopleProperities;

    @Autowired
    private PeopleProperities peopleProperities2;

//    private String name = peopleProperities.getName();

//    //依赖注入
//    @Value("${people.name}")
//    private String name;

    @RequestMapping(value="/hello/{id}",method = RequestMethod.GET)
    public String sayhello(@PathVariable("id")Integer myid){
        return "id:"+myid;
    }

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String sayhi(@RequestParam(value = "id",required = false,defaultValue = "100")Integer myid){
        return "id:"+myid;
    }
}
