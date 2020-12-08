package com.example.demo.service.appuser;

import com.example.demo.model.AppUser;
import com.example.demo.service.IService;

public interface IAppUserService extends IService<AppUser> {
    AppUser getUserByUserName(String name);

}
