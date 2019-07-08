package com.wh.entity.tenant;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-11
 */

public class WhWarehouseTenant extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    @TableId(value = "tenant_id", type = IdType.AUTO)
    private Long tenantId;

    /**
     * 租户名称
     */
    @NotBlank(message = "is null")
    private String tenantName;
    /**
     * db url
     */
    @NotBlank(message = "is null")
    private String dbDatabase;
    /**
     * db 姓名
     */
    @NotBlank(message = "is null")
    private String dbName;
    /**
     * db密码
     */
    @NotBlank(message = "is null")
    private String dbPwd;

    /**
     * 标识
     */
    @NotBlank(message = "is null")
    private String dbIp;

    /**
     * 标识
     */
    @NotBlank(message = "is null")
    private String tenant;


    /**
     * 租户状态
     */
    private Integer tStatus;


    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }

    public String getDbDatabase() {
        return dbDatabase;
    }

    public void setDbDatabase(String dbDatabase) {
        this.dbDatabase = dbDatabase;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
