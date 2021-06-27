package ie.dkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ie.dkit.service.GoodsImageService;
import ie.dkit.entity.GoodsImage;
import java.util.List;
import java.util.Map;

/**
 * @auther d00216118
 * @create ${cfg.dateTime}
 * ${datetime}
 * @describe controller
 */
@RestController
@RequestMapping("/goodsImage")
public class GoodsImageController {

//    TableInfo(importPackages=[com.baomidou.mybatisplus.annotation.TableName, com.baomidou.mybatisplus.annotation.IdType, com.baomidou.mybatisplus.extension.activerecord.Model, com.baomidou.mybatisplus.annotation.TableId, com.baomidou.mybatisplus.annotation.TableField, java.io.Serializable], convert=true, name=ecm_goods_image, comment=, entityName=GoodsImage, mapperName=GoodsImageMapper, xmlName=GoodsImageMapper, serviceName=GoodsImageService, serviceImplName=GoodsImageServiceImpl, controllerName=GoodsImageController, fields=[TableField(convert=true, keyFlag=true, keyIdentityFlag=true, name=image_id, type=int(10) unsigned, propertyName=imageId, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=image_id, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=goods_id, type=int(10) unsigned, propertyName=goodsId, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=goods_id, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=image_url, type=varchar(255), propertyName=imageUrl, columnType=STRING, comment=, fill=null, keyWords=false, columnName=image_url, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=thumbnail, type=varchar(255), propertyName=thumbnail, columnType=STRING, comment=, fill=null, keyWords=false, columnName=thumbnail, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=sort_order, type=tinyint(4) unsigned, propertyName=sortOrder, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=sort_order, customMap=null), TableField(convert=true, keyFlag=false, keyIdentityFlag=false, name=file_id, type=int(11) unsigned, propertyName=fileId, columnType=INTEGER, comment=, fill=null, keyWords=false, columnName=file_id, customMap=null)], havePrimaryKey=true, commonFields=[], fieldNames=image_id, goods_id, image_url, thumbnail, sort_order, file_id)


//    @Autowired
//    private GoodsImageService goodsImageServiceImpl;

    /**
    * 列表
    */
//    @RequestMapping("/list")
//        public List<GoodsImage> list(@RequestParam Map<String, Object> params){
//
//        List<GoodsImage> list =GoodsImageService.listByMap(params);
//        return list;
//    }

}

