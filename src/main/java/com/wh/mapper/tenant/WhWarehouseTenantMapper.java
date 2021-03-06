package com.wh.mapper.tenant;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wh.dto.TenantStateDto;
import com.wh.entity.tenant.WhWarehouseTenant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 租户表 Mapper 接口
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */
public interface WhWarehouseTenantMapper extends BaseMapper<WhWarehouseTenant> {

    /**
     * 查询租户状态
     *
     * @param tenant
     * @return
     */
    @Select("SELECT `t_status`,`effective_time` FROM `wh_warehouse_tenant` where tenant=#{tenant}")
    TenantStateDto getTenantStatus(@Param("tenant") String tenant);


    /**
     * 查询租户状态
     *
     * @return
     */
    @Select("SELECT `tenant_id`,`tenant_name`,`db_ip`,`db_name`,`db_pwd`, `tenant`,`db_database` " +
            "FROM `wh_warehouse_tenant`")
    List<WhWarehouseTenant> findTenantList();
}
