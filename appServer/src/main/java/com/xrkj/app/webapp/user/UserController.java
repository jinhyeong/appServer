package com.xrkj.app.webapp.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.user.service.IUserService;

@RestController
@RequestMapping("/AppUser")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "view/{id}")//, method = RequestMethod.GET
    public AppUser view(@PathVariable("id") Long id) {
        logger.debug("获取id为：{} 的AppUser对象", id);
        return userService.getUserById(id);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<AppUser> findAll(AppUser user) {
        logger.debug("收到的User对象是：{}",user);
        logger.debug("查询全部的AppUser对象");
        return userService.selectAll();
    }
}
