package com.wh.entity.parent;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.util.List;

/**
 * 树形结构父类
 *
 * @ClassName ParentTree
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 10:47
 **/
public class ParentTree {
    /**
     * 子节点
     */
    private List<ParentTree> childNode;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 请求路径
     */
    private String path;
    /**
     * 是否还有下一级
     */
    @TableField(value = "is_parent_node")
    private Boolean nextLevel;

    /**
     * 树ID
     */
    @TableId(type = IdType.AUTO)
    private Integer treeId;

    /**
     * 树节点名称
     */
    private String treeName;
    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    @TableLogic //逻辑删除
    private Integer delOrNot;

    /**
     * 版本标识
     */
    private Integer version;

    /**
     * 创建用户id
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 修改时间
     */
    private Long modifyDate;

    /**
     * 修改用户id
     */
    private String modifyUser;

    /**
     * 创建范围时间
     */
    @TableField(exist = false)
    private List<Long> createDates;

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

    public List<Long> getCreateDates() {
        return createDates;
    }

    public void setCreateDates(List<Long> createDates) {
        this.createDates = createDates;
    }

    public Boolean getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Boolean nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
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

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public List<ParentTree> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<ParentTree> childNode) {
        this.childNode = childNode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
