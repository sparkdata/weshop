package tech.wetech.weshop.user.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentQuery {

    @NotNull
    private Integer typeId;

    @NotNull
    private Integer valueId;

    private boolean requirePicture;

    /**
     * 页码，从1开始
     */
    @ApiModelProperty("页码，从1开始")
    private int pageNum;
    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private int pageSize;

}
