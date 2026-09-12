package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* loaded from: classes3.dex */
public class Zq {
    private final com.bytedance.sdk.openadsdk.utils.Sj Sj = new com.bytedance.sdk.openadsdk.utils.Sj();
    private boolean sP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Sj {
        private static final Zq Sj = new Zq();
    }

    public static Zq Sj() {
        return Sj.Sj;
    }

    public boolean EjP() {
        return this.Sj.Sj();
    }

    public com.bytedance.sdk.openadsdk.utils.Sj HiB() {
        return this.Sj;
    }

    public boolean Sj(boolean z10) {
        return this.Sj.Sj(z10);
    }

    public boolean TKC() {
        return this.sP;
    }

    public void sP() {
        try {
            Context Sj2 = dNu.Sj();
            if (Sj2 instanceof Application) {
                ((Application) Sj2).registerActivityLifecycleCallbacks(this.Sj);
                this.sP = true;
            } else {
                if (Sj2 == null || Sj2.getApplicationContext() == null) {
                    return;
                }
                ((Application) Sj2.getApplicationContext()).registerActivityLifecycleCallbacks(this.Sj);
                this.sP = true;
            }
        } catch (Throwable th2) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th2);
        }
    }
}
