package com.star.sys.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Njq
 * @since 2021-08-12
 */
@TableName("sys_role")
@Data
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色编码
     */
    private String rolecode;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 备注
     */
    private String remark;

}
