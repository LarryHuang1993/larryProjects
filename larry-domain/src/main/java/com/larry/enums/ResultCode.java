package com.larry.enums;

/**
 * Created by huang on 2017/6/11.
 */
public enum ResultCode {

    ERROR("-200","失败",""),

    SUCCESS("200","成功","");

    ResultCode(String code, String name, String remark) {
        this.code = code;
        this.name = name;
        this.remark = remark;
    }

    private String code;

    private String name;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return this.getCode();
    }
}
