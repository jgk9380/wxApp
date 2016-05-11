package org;

import java.util.Collections;
import java.util.Map;

public class WxConfigImpl implements WxConfig {
    Map<String, String> targetConifig;
    Map<String, String> dataServiceConifig;
    String  currentWxAppName;
    String  webAddress;
    @Override
    public Map<String, String> getTargetConifig() {         
        return targetConifig;
    }

    @Override
    public Map<String, String> getDataServiceConifig() {         
        return dataServiceConifig;
    }

    public void setTargetConifig(Map<String, String> targetConifig) {
        this.targetConifig = targetConifig;
    }

    public void setDataServiceConifig(Map<String, String> dataServiceConifig) {
        this.dataServiceConifig = dataServiceConifig;
    }

    @Override
    public String getCurrentWxAppName() {         
        return currentWxAppName;
    }


    public void setCurrentWxAppName(String currentWxAppName) {
        this.currentWxAppName = currentWxAppName;
    }


    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
    @Override
    public String getWebAddress() {
        return webAddress;
    }
}
