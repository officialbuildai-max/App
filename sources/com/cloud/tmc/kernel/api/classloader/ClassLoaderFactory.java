package com.cloud.tmc.kernel.api.classloader;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.kernel.api.classloader.DefaultClassLoaderFactory")
/* loaded from: classes3.dex */
public interface ClassLoaderFactory extends Proxiable {
    ClassLoader getClassLoader(String str);
}
