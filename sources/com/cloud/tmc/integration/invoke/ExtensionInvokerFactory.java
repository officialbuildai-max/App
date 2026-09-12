package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;
import com.cloud.tmc.kernel.security.AccessController;

@DefaultImpl("")
/* loaded from: classes3.dex */
public interface ExtensionInvokerFactory extends Proxiable {
    ExtensionInvoker createPermissionExtensionInvoker(AccessController accessController, ExtensionInvoker extensionInvoker);

    ExtensionInvoker createScheduleExtensionInvoker(ExtensionInvoker extensionInvoker);
}
