package org;

import java.util.Map;

public interface WxConfig {
    String    getCurrentWxAppName();//��ǰApp����
    Map<String,String> getTargetConifig();//����
    Map<String,String> getDataServiceConifig();
    String getWebAddress();
}
