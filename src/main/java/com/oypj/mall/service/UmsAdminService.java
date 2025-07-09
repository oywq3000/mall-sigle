package com.oypj.mall.service;

import com.oypj.mall.domain.UmsResource;

import java.util.List;

public interface UmsAdminService {

    String login(String username, String password);

    List<UmsResource> getResourceList();
}
