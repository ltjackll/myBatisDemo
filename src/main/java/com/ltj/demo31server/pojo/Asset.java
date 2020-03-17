package com.ltj.demo31server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.io.Serializable;
import java.util.Date;

@TableName("asset_info")
public class Asset implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -3431718024824438376L;

    @TableId(value = "asset_id", type = IdType.AUTO)
    private Long asset_id;

    private String asset_name;
    private String asset_product_key;
    private String asset_type;
    private Date create_time;
    private Date update_time;

    public Asset(Long id) {
        this.asset_id = id;
    }

    public Asset(String asset_name, String asset_product_key, String asset_type, Date create_time, Date update_time) {
        this.asset_name = asset_name;
        this.asset_product_key = asset_product_key;
        this.asset_type = asset_type;
        this.create_time = create_time;
        this.update_time = update_time;
    }


    public Asset(Long id, String asset_name, String asset_product_key, String asset_type, Date create_time, Date update_time) {
        this.asset_id = id;
        this.asset_name = asset_name;
        this.asset_product_key = asset_product_key;
        this.asset_type = asset_type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + asset_id +
                ", asset_name='" + asset_name + '\'' +
                ", asset_product_key='" + asset_product_key + '\'' +
                ", asset_type='" + asset_type + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Long getId() {
        return asset_id;
    }

    public void setId(Long id) {
        this.asset_id = id;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getAsset_product_key() {
        return asset_product_key;
    }

    public void setAsset_product_key(String asset_product_key) {
        this.asset_product_key = asset_product_key;
    }

    public String getAsset_type() {
        return asset_type;
    }

    public void setAsset_type(String asset_type) {
        this.asset_type = asset_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
