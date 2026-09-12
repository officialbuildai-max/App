package com.cloud.tmc.kernel.proxy.performanceanalyse;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.miniapp.performanceanalyse.LogEReportManager")
/* loaded from: classes3.dex */
public interface LogEProxy extends Proxiable {
    void destroy(String str);

    void e(String str, String str2);

    void init(String str);

    void saveConfig(float f11);
}
