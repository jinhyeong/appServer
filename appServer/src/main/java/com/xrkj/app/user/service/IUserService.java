package com.xrkj.app.user.service;

import java.util.List;

import com.xrkj.app.user.model.AppUser;

public interface IUserService {

    AppUser getUserById(long id);

    List<AppUser> selectAll();
}
