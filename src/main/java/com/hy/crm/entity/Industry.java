package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 所属行业表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Industry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属行业id
     */
    @TableId(value = "industry_id", type = IdType.AUTO)
    private Integer industryId;

    private String industryName;


}
