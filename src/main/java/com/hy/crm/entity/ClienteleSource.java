package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户来源表
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClienteleSource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户来源id
     */
    @TableId(value = "clientele_source_id", type = IdType.AUTO)
    private Integer clienteleSourceId;

    private String clienteleSourceName;


}
