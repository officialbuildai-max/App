package com.cloud.tmc.integration.proxy;

import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.integration.defaultImpl.DefaultAppFactoryImpl")
/* loaded from: classes3.dex */
public interface AppFactory extends Proxiable {
    AppNode createApp();

    AppNode createVirtualApp();
}
