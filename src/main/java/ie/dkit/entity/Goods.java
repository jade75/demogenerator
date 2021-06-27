package ie.dkit.entity;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
@TableName(value = "ecm_goods", resultMap = "BaseResultMap")
public class Goods extends Model<Goods> {
    private static final long serialVersionUID = 1L;

    @TableId(value="goods_id", type= IdType.AUTO)
    private Integer goodsId;

    @TableField(value="store_id")
    private Integer storeId;

    @TableField(value="type")
    private String type;

    @TableField(value="goods_name")
    private String goodsName;

    @TableField(value="barcode")
    private String barcode;

    @TableField(value="description")
    private String description;

    @TableField(value="cate_id")
    private Integer cateId;

    @TableField(value="cate_name")
    private String cateName;

    @TableField(value="brand")
    private String brand;

    @TableField(value="spec_qty")
    private Integer specQty;

    @TableField(value="spec_name_1")
    private String specName1;

    @TableField(value="spec_name_2")
    private String specName2;

    @TableField(value="spec_name_3")
    private String specName3;

    @TableField(value="if_show")
    private Integer ifShow;

    @TableField(value="time_starter")
    private LocalDateTime timeStarter;

    @TableField(value="time_over")
    private LocalDateTime timeOver;

    @TableField(value="closed")
    private Integer closed;

    @TableField(value="close_reason")
    private String closeReason;

    @TableField(value="add_time")
    private Integer addTime;

    @TableField(value="last_update")
    private Integer lastUpdate;

    @TableField(value="default_spec")
    private Integer defaultSpec;

    @TableField(value="default_image")
    private String defaultImage;

    @TableField(value="recommended")
    private Integer recommended;

    @TableField(value="cate_id_1")
    private Integer cateId1;

    @TableField(value="cate_id_2")
    private Integer cateId2;

    @TableField(value="cate_id_3")
    private Integer cateId3;

    @TableField(value="cate_id_4")
    private Integer cateId4;

    @TableField(value="price")
    private BigDecimal price;

    @TableField(value="tags")
    private String tags;

    @TableField(exist = false)
    private List<GoodsImage> goodsImageList;
}