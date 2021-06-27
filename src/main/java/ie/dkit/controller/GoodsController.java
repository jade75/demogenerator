package ie.dkit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ie.dkit.service.GoodsService;
import ie.dkit.entity.Goods;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @auther d00216118
 * @create ${cfg.dateTime}
 * @describe 前端控制器
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

//    TableInfo(importPackages=[java.math.BigDecimal, com.baomidou.mybatisplus.annotation.TableName, com.baomidou.mybatisplus.annotation.IdType, com.baomidou.mybatisplus.annotation.TableId, java.time.LocalDateTime, com.baomidou.mybatisplus.annotation.TableField, java.io.Serializable], convert=true, name=ecm_goods, comment=, entityName=Goods, mapperName=GoodsMapper, xmlName=GoodsMapper, serviceName=GoodsService, serviceImplName=GoodsServiceImpl, controllerName=GoodsController, fields=[TableField(convert=true, keyFlag=true, keyIdentityFlag=true, name=goods_id, type=int(10) unsigned, propertyName=goodsId, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=goods_id, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=store_id, type=int(10) unsigned, propertyName=storeId, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=store_id, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=type, type=varchar(10), propertyName=type, columnType=STRING, comment=, fill=null, keyWords=false, columnName=type, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=goods_name, type=varchar(255), propertyName=goodsName, columnType=STRING, comment=, fill=null, keyWords=false, columnName=goods_name, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=barcode, type=varchar(255), propertyName=barcode, columnType=STRING, comment=, fill=null, keyWords=false, columnName=barcode, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=description, type=text, propertyName=description, columnType=STRING, comment=, fill=null, keyWords=false, columnName=description, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=cate_id, type=int(10) unsigned, propertyName=cateId, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=cate_id, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=cate_name, type=varchar(255), propertyName=cateName, columnType=STRING, comment=, fill=null, keyWords=false, columnName=cate_name, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=brand, type=varchar(100), propertyName=brand, columnType=STRING, comment=, fill=null, keyWords=false, columnName=brand, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=spec_qty, type=tinyint(4) unsigned, propertyName=specQty, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=spec_qty, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=spec_name_1, type=varchar(60), propertyName=specName1, columnType=STRING, comment=, fill=null, keyWords=false, columnName=spec_name_1, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=spec_name_2, type=varchar(60), propertyName=specName2, columnType=STRING, comment=, fill=null, keyWords=false, columnName=spec_name_2, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=spec_name_3, type=varchar(60), propertyName=specName3, columnType=STRING, comment=, fill=null, keyWords=false, columnName=spec_name_3, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=if_show, type=tinyint(3) unsigned, propertyName=ifShow, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=if_show, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=time_starter, type=timestamp, propertyName=timeStarter, columnType=LOCAL_DATE_TIME, comment=, fill=null, keyWords=false, columnName=time_starter, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=time_over, type=timestamp, propertyName=timeOver, columnType=LOCAL_DATE_TIME, comment=, fill=null, keyWords=false, columnName=time_over, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=closed, type=tinyint(3) unsigned, propertyName=closed, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=closed, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=close_reason, type=varchar(255), propertyName=closeReason, columnType=STRING, comment=, fill=null, keyWords=false, columnName=close_reason, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=add_time, type=int(10) unsigned, propertyName=addTime, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=add_time, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=last_update, type=int(10) unsigned, propertyName=lastUpdate, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=last_update, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=default_spec, type=int(11) unsigned, propertyName=defaultSpec, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=default_spec, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=default_image, type=varchar(255), propertyName=defaultImage, columnType=STRING, comment=, fill=null, keyWords=false, columnName=default_image, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=recommended, type=tinyint(4) unsigned, propertyName=recommended, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=recommended, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=cate_id_1, type=int(10) unsigned, propertyName=cateId1, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=cate_id_1, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=cate_id_2, type=int(10) unsigned, propertyName=cateId2, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=cate_id_2, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=cate_id_3, type=int(10) unsigned, propertyName=cateId3, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=cate_id_3, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=cate_id_4, type=int(10) unsigned, propertyName=cateId4, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=cate_id_4, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=price, type=decimal(10,2), propertyName=price, columnType=BIG_DECIMAL, comment=, fill=null, keyWords=false, columnName=price, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=tags, type=varchar(102), propertyName=tags, columnType=STRING, comment=, fill=null, keyWords=false, columnName=tags, customMap=null)], havePrimaryKey=true, commonFields=[], fieldNames=goods_id, store_id, type, goods_name, barcode, description, cate_id, cate_name, brand, spec_qty, spec_name_1, spec_name_2, spec_name_3, if_show, time_starter, time_over, closed, close_reason, add_time, last_update, default_spec, default_image, recommended, cate_id_1, cate_id_2, cate_id_3, cate_id_4, price, tags)


    @Autowired
    private GoodsService goodsServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public List<Goods> list(@RequestParam Map<String, Object> params){
        List<Goods> list =goodsServiceImpl.listByMap(params);
        return list;
    }

    @GetMapping("/test")
    public void test(){
        List<Goods> list=goodsServiceImpl.list();
        list.forEach(x->System.out.println(x));
    }


}

