package com.wh.entity.perms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;
import com.wh.entity.po.WhUserPermsOperating;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-17
 */
public class WhUserPerms extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId(value = "p_id", type = IdType.AUTO)
    private Long pId;

    /**
     * 权限名称
     */
    private String pName;

    /**
     * 权限操作名称
     */
    @TableField(exist = false)
    private String poName;
    /**
     * 权限操作url
     */
    @TableField(exist = false)
    private String poApi;


    /**
     * 前端接收对象存入List
     */
    @TableField(exist = false)
    private List<WhUserPermsOperating> permsOperatingList;


    public List<WhUserPermsOperating> getPermsOperatingList() {
        return permsOperatingList;
    }

    public void setPermsOperatingList(List<WhUserPermsOperating> permsOperatingList) {

        this.permsOperatingList = permsOperatingList;
    }


    public String getPoApi() {
        return poApi;
    }

    public void setPoApi(String poApi) {
        this.poApi = poApi;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}
