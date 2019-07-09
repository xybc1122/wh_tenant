package com.wh.service.role.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import com.wh.entity.role.WhUserRole;
import com.wh.entity.ur.WhUserRoleUser;
import com.wh.mapper.role.WhUserRoleMapper;
import com.wh.service.redis.RedisService;
import com.wh.service.role.IWhUserRoleService;
import com.wh.service.ur.IWhUserRoleUserService;
import com.wh.utils.CheckUtils;
import com.wh.utils.WrapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
@Service
public class WhUserRoleServiceImpl extends ServiceImpl<WhUserRoleMapper, WhUserRole> implements IWhUserRoleService {

}
