package com.ltj.demo31server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ltj.demo31server.mapper.AssetMapper;
import com.ltj.demo31server.pojo.Asset;
import com.ltj.demo31server.pojo.Response;
import com.ltj.demo31server.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class AssetController {
    DateFormat dateFormat = DateFormat.getDateTimeInstance();
    @Autowired
    private AssetService assetService;

//    @Autowired
//    private AssetMapper assetMapper;

    @RequestMapping(value = "/api/asset", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Asset>> queryAsset(@RequestParam(required = false) Map<String, Object> params) {
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();
        if (params.containsKey("asset_name")) {
            System.out.println("asset_name");
            queryWrapper.like("asset_name", params.get("asset_name"));
        }
        if (params.containsKey("asset_product_key")) {
            System.out.println("asset_product_key");
            queryWrapper.like("asset_product_key", params.get("asset_product_key"));
        }
        if (params.containsKey("asset_type")) {
            System.out.println("asset_type");
            queryWrapper.like("asset_type", params.get("asset_type"));
        }

        List<Asset> assetList = assetService.list(queryWrapper);
//        for(Asset asset :assetList){
//            System.out.println(asset.toString());
//        }
        return new Response<List<Asset>>(true, assetList);
    }

    @RequestMapping(value = "/api/addAsset", method = RequestMethod.POST)
    @ResponseBody
//    public List<Asset> addAsset(@RequestBody Map<String, String> requestParam) {
    public List<Asset> addAsset(@RequestBody Map<String, String> requestParam) {
//        System.out.println(requestParam.get("name"));
//        System.out.println(requestParam.get("modaltype"));
        String productKey = (int) ((Math.random() * 9 + 1) * 100000) + "";
//        System.out.println(productKey);
//        String time = dateFormat.format(new Date());
        Date date = new Date();
        Asset asset = new Asset(null, requestParam.get("asset_name"), productKey, requestParam.get("asset_type"), date, date);
        System.out.println(asset.toString());
        assetService.save(asset);
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();
        List<Asset> assetList = assetService.list(queryWrapper);
//        for(Asset asset :assetList){
//            System.out.println(asset.toString());
//        }
        return assetList;
    }

    @RequestMapping(value = "/api/updateAsset", method = RequestMethod.POST)
    @ResponseBody
//    public List<Asset> addAsset(@RequestBody Map<String, String> requestParam) {
    public List<Asset> updateAsset(@RequestBody Map<String, Object> requestParam) {
//        Object o = new Object();
        Asset asset = new Asset(Long.valueOf(String.valueOf(requestParam.get("asset_id"))));
        System.out.println(asset.getId());
        asset.setAsset_name((String) requestParam.get("asset_name"));
        asset.setAsset_type((String) requestParam.get("asset_type"));
        asset.setUpdate_time(new Date());
        Asset otherasset = assetService.getById(asset);
        if (otherasset == null) {
            System.out.println("fuck");
        } else {
            System.out.println("neng cha " + otherasset.getId());
        }
        System.out.println(asset.toString());
        assetService.updateById(asset);
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();
        List<Asset> assetList = assetService.list(queryWrapper);
        return assetList;
    }

    @RequestMapping(value = "/api/deleteAsset", method = RequestMethod.POST)
    @ResponseBody
    public List<Asset> deleteAsset(@RequestBody Map<String, List<Long>> requestParam) {
        System.out.println(requestParam.get("idList").size());

        assetService.removeByIds(requestParam.get("idList"));
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();
        List<Asset> assetList = assetService.list(queryWrapper);
        return assetList;
    }


    @RequestMapping(value = "/api/date", method = RequestMethod.GET)
    @ResponseBody
    public List<Asset> getDate() {
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();
        queryWrapper.select("SELECT MAX(id) AS id ");
        List<Asset> assetList = assetService.list(queryWrapper);

//        System.out.println(dateFormat.format(new Date()));
//        for(Asset asset :assetList){
//            System.out.println(asset.toString());
//        }
        return assetList;
    }
}
