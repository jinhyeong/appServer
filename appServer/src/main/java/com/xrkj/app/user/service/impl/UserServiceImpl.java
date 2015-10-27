package com.xrkj.app.user.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.xrkj.app.user.dao.AppUserMapper;
import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.user.service.IUserService;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年6月30日 下午6:39:09 
 *
 */
@Service
@CacheConfig(cacheNames = "userCache")
public class UserServiceImpl implements IUserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AppUserMapper appUserMapper;

    public void setAppUserMapper(AppUserMapper appUserMapper) {
        this.appUserMapper = appUserMapper;
    }

    @Override
    @Cacheable
    public AppUser getUserById(long id) {
        logger.debug("######## 去数据库中查询ID为：{} 的user", id);
        return appUserMapper.selectByPrimaryKey(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xrkj.app.user.service.IUserService#selectAll()
     */
    @Override
    @Cacheable
    public List<AppUser> selectAll() {
        logger.debug("####### 去数据库中查询全部的user");
        return appUserMapper.selectAll();
    }

}
