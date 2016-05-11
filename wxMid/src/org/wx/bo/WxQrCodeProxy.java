package org.wx.bo;

import org.entity.qrcode.WxQrCode;

public interface WxQrCodeProxy {
    WxQrCode getUserQrCode(long userId);

    WxQrCode getCouponQrCode(long couponQrCode);
}
