package com.cloud.tmc.kernel.proxy.env;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.TmcApplicationContextGetter")
/* loaded from: classes3.dex */
public interface IApplicationContextGetter extends Proxiable {
    @NonNull
    Application getApplication();

    @NonNull
    Context getApplicationContext();
}
