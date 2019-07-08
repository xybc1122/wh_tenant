package com.wh.entity.parent;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ParentConfTable
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 16:07
 * 配置表父类
 **/
public class ParentConfTable {


    /**
     * 备注
     */
    @TableField(exist = false)
    private String remark;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改日期
     */
    private Long modifyDate;

    /**
     * 修改人
     */
    private String modifyUser;

    @TableField(value = "is_delete")
    @TableLogic //逻辑删除
    private Integer delOrNot;

    /**
     * 当前页
     */
    @TableField(exist = false)
    private Integer currentPage;

    /**
     * 显示的页数
     */
    @TableField(exist = false)
    private Integer pageSize;

    /**
     * 创建时间范围查询
     */
    @TableField(exist = false)
    private List<Long> createDates;

    public void setCreate(String createUser) {
        this.createUser = createUser;
        this.createDate = new Date().getTime();
    }

    public void setModify(String createUser, Integer version) {
        this.modifyUser = createUser;
        this.modifyDate = new Date().getTime();
        this.version = version == null ? 0 : +1;
    }

    /**
     * 版本标识
     */
    private Integer version;


    public List<Long> getCreateDates() {
        return createDates;
    }

    public void setCreateDates(List<Long> createDates) {
        this.createDates = createDates;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }


    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
