package com.hy.crm.util;

import lombok.Data;

/**
 * @author Jackson
 * @date 2020/7/31 9:17
 * @Description:
 */
@Data
public class ImgUtils {
    /**
     * code-->状态码
     * 0:成功
     * 1：失败
     */
    private Integer code;
    /**
     * msg--> 详细信息
     */
    private String msg;
    /**
     * 具体信息
     */
    private String data;
}
