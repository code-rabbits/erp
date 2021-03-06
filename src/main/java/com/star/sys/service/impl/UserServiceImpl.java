package com.star.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.sys.pojo.User;
import com.star.sys.mapper.UserMapper;
import com.star.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.sys.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Njq
 * @since 2021-08-09
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String userName) throws Exception {
        //创建条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //根据登录名称查询
        queryWrapper.eq("loginname",userName);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<User> findUserListByPage(IPage<User> page, UserVo userVo) throws Exception {
        return userMapper.findUserListByPage(page,userVo);
    }


    @Override
    public Set<Integer> findUserRoleByUserId(int id) throws Exception {
        return userMapper.findUserRoleByUserId(id);
    }

    @Override
    public boolean saveUserRole(int userId, String roleIds) throws Exception {
        try {
            //先删除sys_role_user表的数据
            userMapper.deleteUserRoleByUserId(userId);
            //再添加sys_role_user表的数据
            String [] rids = roleIds.split(",");
            //循环添加
            for (int i = 0; i < rids.length; i++) {
                userMapper.insertUserRole(userId,rids[i]);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
