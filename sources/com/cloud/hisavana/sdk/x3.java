package com.cloud.hisavana.sdk;

import android.os.Bundle;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class x3 extends G {

    /* renamed from: i, reason: collision with root package name */
    private final String f23166i;

    /* renamed from: j, reason: collision with root package name */
    private volatile AdsDTO f23167j;

    /* renamed from: k, reason: collision with root package name */
    private e2 f23168k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x3(q3 adFetchInfo) {
        super(adFetchInfo);
        Intrinsics.h(adFetchInfo, "adFetchInfo");
        this.f23166i = "Rewarded";
    }

    private final void K() {
        this.f23168k = new e2(this);
    }

    public final void F(TaErrorCode taErrorCode) {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.t(taErrorCode, this);
        }
    }

    public final void G() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.m();
        }
        AdCallback adCallback2 = this.f21586e;
        if (adCallback2 != null) {
            adCallback2.k(this.f23167j);
        }
    }

    public final void H() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.p(this.f23167j);
        }
    }

    public final void I() {
        f();
        k(true);
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.s();
        }
    }

    public final void J() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.A();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L() {
        /*
            r3 = this;
            com.cloud.sdk.commonutil.util.Preconditions.a()
            r3.K()
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r0 = r3.f23167j
            if (r0 == 0) goto L35
            int r0 = r3.r()
            if (r0 != 0) goto L22
            boolean r0 = r3.z()
            if (r0 != 0) goto L22
            com.cloud.hisavana.sdk.e2 r0 = r3.f23168k
            if (r0 == 0) goto L35
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r1 = r3.f23167j
            r0.c(r1)
            kotlin.Unit r0 = kotlin.Unit.f67184a
            goto L36
        L22:
            com.cloud.hisavana.sdk.common.constant.TaErrorCode r0 = com.cloud.hisavana.sdk.common.constant.TaErrorCode.ERROR_SHOW_INNER_INVALID
            r3.F(r0)
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r1 = r3.f23166i
            java.lang.String r2 = "ad not condition to use"
            r0.d(r1, r2)
            kotlin.Unit r0 = kotlin.Unit.f67184a
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 != 0) goto L43
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r1 = r3.f23166i
            java.lang.String r2 = "adBean = null"
            r0.d(r1, r2)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.x3.L():void");
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle athenaTrackBundle) {
        Intrinsics.h(athenaTrackBundle, "athenaTrackBundle");
        this.f23167j = list != null ? (AdsDTO) CollectionsKt.k0(list) : null;
        super.d(list, athenaTrackBundle);
    }

    @Override // com.cloud.hisavana.sdk.G
    public void m() {
        super.m();
        e2 e2Var = this.f23168k;
        if (e2Var != null) {
            e2Var.b();
        }
    }
}
