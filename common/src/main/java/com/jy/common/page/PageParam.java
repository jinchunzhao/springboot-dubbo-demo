package com.jy.common.page;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 分页查询参数
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 17:56
 */
@Data
public class PageParam<T> {

    /**
     * 参数
     */
    @Valid
    private T param;

    /**
     * 默认页码
     */
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNum = 1;

    /**
     * 默认条数
     */
    @Min(value = 1, message = "每页展示条数不能小于1")
    private Integer pageSize = 15;

}
