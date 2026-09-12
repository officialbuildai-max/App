package com.bytedance.sdk.openadsdk.RiZ.Sj.Sj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.Mts;

/* loaded from: classes2.dex */
public class Jcg {
    public static vS Sj(Context context, sU sUVar, String str) {
        return TKC.Sj() ? new HiB(context, sUVar, str) : Mts.Dq(context) ? new EjP(context, sUVar, str) : new Sj(context, sUVar, str);
    }
}
