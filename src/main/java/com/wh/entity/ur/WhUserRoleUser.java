package com.wh.entity.ur;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 * 用户跟角色表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */

public class WhUserRoleUser extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long uId;

    /**
     * 角色id
     */
    private Long rId;

    /**
     * ID
     */
    @TableId(value = "ru_id", type = IdType.AUTO)
    private Long ruId;

    public WhUserRoleUser(Long uId, Long rId) {
        this.uId = uId;
        this.rId = rId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getRuId() {
        return ruId;
    }

    public void setRuId(Long ruId) {
        this.ruId = ruId;
    }
}
