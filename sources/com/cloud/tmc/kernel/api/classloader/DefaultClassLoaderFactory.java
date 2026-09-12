package com.cloud.tmc.kernel.api.classloader;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes3.dex */
public class DefaultClassLoaderFactory implements ClassLoaderFactory {
    @Override // com.cloud.tmc.kernel.api.classloader.ClassLoaderFactory
    public ClassLoader getClassLoader(String str) {
        return DefaultClassLoaderFactory.class.getClassLoader();
    }
}
