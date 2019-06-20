package com.zr.demo.service.impl;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zr.demo.dao.UserDao;
import com.zr.demo.service.UserService;
import com.zr.model.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired  
    private UserDao userDao;  
	@Override
	public User selectUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(userId);
	}
	  @Autowired
	 private RedisTemplate redisTemplate;  
	public List<User> selectAll()
	{
		ValueOperations<String, List<User>> operations = redisTemplate.opsForValue();
		 String key="user212123";
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            List<User> users = operations.get(key);
            System.out.println("从缓存中拿到了数据");
            return users;
        }
        
        List<User> users = userDao.selectAll();
        operations.set(key, users, 10, TimeUnit.SECONDS);
        System.out.println("讲数据插入缓存");
		return userDao.selectAll();
		
	}

	
}
