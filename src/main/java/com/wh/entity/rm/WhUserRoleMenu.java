package com.wh.entity.rm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色菜单权限表
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-14
 */
public class WhUserRoleMenu extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableField(value = "m_id")
    private Long mid;

    /**
     * 角色id
     */
    @TableField(value = "r_id")
    private Long rid;

    /**
     * 要设置的菜单集合
     */
    @TableField(exist = false)
    private List<Integer> menus;


    /**
     * 自增id
     */
    @TableId(value = "rm_id", type = IdType.AUTO)
    private Long rmId;

    /**
     * 租户id
     */
    private Integer tId;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public WhUserRoleMenu() {

    }

    public WhUserRoleMenu(Long mid, Long rid, Integer tId) {
        this.mid = mid;
        this.rid = rid;
        this.tId = tId;
    }


    public WhUserRoleMenu(Long mid, Long rid) {
        this.mid = mid;
        this.rid = rid;
    }


    public List<Integer> getMenus() {
        return menus;
    }

    public void setMenus(List<Integer> menus) {
        this.menus = menus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getRmId() {
        return rmId;
    }

    public void setRmId(Long rmId) {
        this.rmId = rmId;
    }
}
