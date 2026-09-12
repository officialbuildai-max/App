package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

/* loaded from: classes2.dex */
enum ServiceNameFactory {
    ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getServiceName(String str) {
        HttpClientConfig h11 = InternalConfig.Factory.a().h(str);
        if (h11 == null) {
            return null;
        }
        return h11.a();
    }
}
