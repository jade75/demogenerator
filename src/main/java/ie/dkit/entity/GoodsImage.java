package ie.dkit.entity;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ecm_goods_image")
public class GoodsImage extends Model<GoodsImage> {
    private static final long serialVersionUID = 1L;

    @TableId(value="image_id", type= IdType.AUTO)
    private Integer imageId;

    @TableField(value="goods_id")
    private Integer goodsId;

    @TableField(value="image_url")
    private String imageUrl;

    @TableField(value="thumbnail")
    private String thumbnail;

    @TableField(value="sort_order")
    private Integer sortOrder;

    @TableField(value="file_id")
    private Integer fileId;


    @Version
    private Integer version;
}