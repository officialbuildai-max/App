package com.cloud.tmc.kernel.proxy.worker;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;
import java.util.Map;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.JSAheadParamsProxyImp")
/* loaded from: classes3.dex */
public interface JSAheadParamsProxy extends Proxiable {
    Map<String, String> getParasm();

    void setParams(Map<String, String> map);
}
