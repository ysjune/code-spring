package org.zerock.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

    @RequestMapping("")
    public void basic() {

//        log.info("basic..........");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {

    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2() {

    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        return "ex02";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        return "ex02Bean";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page) {
        return "/sample/ex04";
    }


}
