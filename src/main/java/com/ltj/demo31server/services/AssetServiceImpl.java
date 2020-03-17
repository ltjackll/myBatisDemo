package com.ltj.demo31server.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltj.demo31server.mapper.AssetMapper;
import com.ltj.demo31server.pojo.Asset;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements AssetService {
}
