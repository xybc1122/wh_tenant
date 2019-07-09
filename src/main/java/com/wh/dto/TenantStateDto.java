package com.wh.dto;

/**
 * @ClassName TenantStateDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/9 16:12
 * 租户接收状态对象
 **/
public class TenantStateDto {

    /**
     * 租户有效时间
     */
    private Long effectiveTime;
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

    public Long getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
