package com.wh.entity.tenant;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wh.entity.parent.ParentConfTable;
import com.wh.entity.user.UserInfo;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-07-09
 */
@TableName("wh_tenant_info")
public class WhTenantInfo extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    /**
     * 租户admin账号
     */
    @NotBlank(message = "is null")
    private String adminAccount;

    /**
     * 租户id
     */
    @NotNull(message = "is null")
    private Integer tId;
    /**
     * 用户对象
     */
    @NotNull
    @Valid
    @TableField(exist = false)
    private UserInfo user;


    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }
}
