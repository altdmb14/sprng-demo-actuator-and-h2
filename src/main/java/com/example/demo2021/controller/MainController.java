package com.example.demo2021.controller;

import com.example.demo2021.dao.PersonDAO;
import com.example.demo2021.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    private PersonDAO personDAO;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<Person> all = personDAO.findAll();
        StringBuilder sb = new StringBuilder();
        all.forEach(p-> sb.append(p.getFullName() + "<br>"));
        return sb.toString();
    }

    @ResponseBody
    @RequestMapping(path = "/abc")
    public String home(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String host = request.getServerName();
        String endpointBasePath = "/actuator";
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Spring Boot Actuator</h2>");
        sb.append("<ul>");
        String url = "http://" + host + ":8090" + contextPath + endpointBasePath;
        sb.append("<li><a href='" + url + "'>" + url + "</a></li>");
        sb.append("</ul>");
        return sb.toString();
    }
}
