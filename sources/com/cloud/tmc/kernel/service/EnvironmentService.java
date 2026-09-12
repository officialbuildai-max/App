package com.cloud.tmc.kernel.service;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;
import java.lang.ref.WeakReference;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.EnvironmentServiceImpl")
/* loaded from: classes3.dex */
public interface EnvironmentService extends Proxiable {
    @NonNull
    String defaultPlatform();

    @Nullable
    String getAppLanguage();

    @NonNull
    String getAppName();

    @NonNull
    Application getApplicationContext();

    int getLpid();

    @NonNull
    String getProductVersion();

    @NonNull
    Resources getResources();

    @NonNull
    WeakReference<Activity> getTopActivity();
}
