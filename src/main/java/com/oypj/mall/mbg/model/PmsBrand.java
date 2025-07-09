package com.oypj.mall.mbg.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@TableName("pms_brand")
@Data
public class PmsBrand {
    private Long id;

    private String name;

    @Schema(title = "首字母")
    private String firstLetter;

    private Integer sort;

    @Schema(title = "是否为产品制造商：0->不是：1->是")
    private Integer factoryStatus;

    private Integer showStatus;

    @Schema(title = "产品数量")
    private Integer productCount;

    @Schema(title = "产品评论数量")
    private Integer productCommentCount;

    @Schema(title = "品牌logo")
    private String logo;

    @Schema(title = "专区大图")
    private String bigPic;

    @Schema(title = "品牌故事")
    private String brandStory;


    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", firstLetter=").append(firstLetter);
        sb.append(", sort=").append(sort);
        sb.append(", factoryStatus=").append(factoryStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", productCount=").append(productCount);
        sb.append(", productCommentCount=").append(productCommentCount);
        sb.append(", logo=").append(logo);
        sb.append(", bigPic=").append(bigPic);
        sb.append(", brandStory=").append(brandStory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
