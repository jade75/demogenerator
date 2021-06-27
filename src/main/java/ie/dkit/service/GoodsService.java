package ie.dkit.service;

import ie.dkit.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @auther d00216118
 * @create ${cfg.dateTime}
 * @describe 服务类
 */
public interface GoodsService extends IService<Goods> {

        List<Goods> findGoodsStoreId(Integer storeId);

}
