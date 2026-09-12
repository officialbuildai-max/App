package com.cloud.tmc.miniapp.proxy.platform;

import android.content.Context;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;

@DefaultImpl("com.cloud.tmc.miniapp.UpgradeImpl")
/* loaded from: classes3.dex */
public interface IUpgradeProxy extends Proxiable {
    void showFwUpdateTipsDialog(Context context, String str, o000oOoO o000oooo);
}
