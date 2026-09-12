package com.cloud.tmc.kernel.intf;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.kernel.deftimpl.DefaultSDKConfig")
/* loaded from: classes3.dex */
public interface ISDKConfig extends Proxiable {
    String getAppVersion();

    boolean openShareTarget();
}
