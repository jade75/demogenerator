package ie.dkit.mapper;

import ie.dkit.entity.GoodsImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author d00216118
 * @since 2021-06-02
 */
public interface GoodsImageMapper extends BaseMapper<GoodsImage> {
    List<GoodsImage> selectImageByGoodsId(Integer goodsId);
}
