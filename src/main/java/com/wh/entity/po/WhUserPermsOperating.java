package com.wh.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wh.entity.parent.ParentConfTable;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈恩惠
 * @since 2019-06-18
 */
public class WhUserPermsOperating extends ParentConfTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作id
     */
    @TableId(value = "po_id", type = IdType.AUTO)
    private Long poId;

    /**
     * 权限名id
     */
    private Long pId;

    /**
     * 操作名称
     */
    private String poName;

    /**
     * api 请求url
     */
    private String apiUrl;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
