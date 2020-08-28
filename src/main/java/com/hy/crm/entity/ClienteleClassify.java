package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户分类表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClienteleClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户分类id
     */
    @TableId(value = "classify_id", type = IdType.AUTO)
    private Integer classifyId;

    private String classifyName;


}
