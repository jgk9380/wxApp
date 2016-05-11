package org;

import java.util.Map;

public interface WxConfig {
    String    getCurrentWxAppName();//当前App名称
    Map<String,String> getTargetConifig();//保存
    Map<String,String> getDataServiceConifig();
    String getWebAddress();
}
