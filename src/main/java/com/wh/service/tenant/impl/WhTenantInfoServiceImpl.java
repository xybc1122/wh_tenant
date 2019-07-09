package com.wh.service.tenant.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wh.entity.tenant.WhTenantInfo;
import com.wh.mapper.tenant.WhTenantInfoMapper;
import com.wh.service.tenant.IWhTenantInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-09
 */
@Service
public class WhTenantInfoServiceImpl extends ServiceImpl<WhTenantInfoMapper, WhTenantInfo> implements IWhTenantInfoService {

}
