package com.wh.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.ResponseBase;
import com.wh.entity.user.UserInfo;
import com.wh.mapper.user.UserMapper;
import com.wh.service.user.IWhUserService;
import com.wh.store.BindingResultStore;
import com.wh.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class WhUserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements IWhUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseBase getByUserInfoList(UserInfo user) {


        return null;
    }

    @Override
    public String insertUserInfoAndTenant(UserInfo user) {
        //到这里先去查查看有没有名字相同的
        if (userMapper.selUserIsDelete(user.getUserName()) != null) {
            return "添加名字重复";
        }
        //新增用户
        CheckUtils.saveResult(userMapper.insert(user));

        return null;
    }
}
