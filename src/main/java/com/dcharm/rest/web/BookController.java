package com.dcharm.rest.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangqiang on 2015/8/6.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "book";
    }
}
