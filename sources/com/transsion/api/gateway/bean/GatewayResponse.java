package com.transsion.api.gateway.bean;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import fm.a;

/* loaded from: classes5.dex */
public class GatewayResponse {

    @a(name = "data")
    public String data;

    @a(name = "error_code")
    public String errorCode;

    @a(name = OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG)
    public String errorMsg;
}
