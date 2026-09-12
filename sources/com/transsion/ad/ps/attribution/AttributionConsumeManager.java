package com.transsion.ad.ps.attribution;

import com.transsion.ad.db.pslink.AttributionPoint;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class AttributionConsumeManager extends BaseAttributionProvider {

    /* renamed from: c, reason: collision with root package name */
    public static final AttributionConsumeManager f42231c = new AttributionConsumeManager();

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f42232d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static AttributionPoint f42233e;

    private AttributionConsumeManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.attribution.AttributionConsumeManager.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        f42232d.set(false);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.transsion.ad.ps.attribution.AttributionConsumeManager$safeCall$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.ad.ps.attribution.AttributionConsumeManager$safeCall$1 r0 = (com.transsion.ad.ps.attribution.AttributionConsumeManager$safeCall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.ps.attribution.AttributionConsumeManager$safeCall$1 r0 = new com.transsion.ad.ps.attribution.AttributionConsumeManager$safeCall$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L40
            if (r2 == r6) goto L3c
            if (r2 == r5) goto L38
            if (r2 != r4) goto L30
            kotlin.ResultKt.b(r8)
            goto L9c
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            kotlin.ResultKt.b(r8)
            goto L8d
        L3c:
            kotlin.ResultKt.b(r8)
            goto L62
        L40:
            kotlin.ResultKt.b(r8)
            nh.m r8 = nh.m.f70597a
            boolean r8 = r8.e()
            if (r8 != 0) goto L4e
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        L4e:
            java.util.concurrent.atomic.AtomicBoolean r8 = com.transsion.ad.ps.attribution.AttributionConsumeManager.f42232d
            boolean r8 = r8.compareAndSet(r3, r6)
            if (r8 != 0) goto L59
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        L59:
            r0.label = r6
            java.lang.Object r8 = r7.d(r0)
            if (r8 != r1) goto L62
            return r1
        L62:
            com.transsion.ad.db.pslink.AttributionPoint r8 = (com.transsion.ad.db.pslink.AttributionPoint) r8
            com.transsion.ad.ps.attribution.AttributionConsumeManager.f42233e = r8
            if (r8 != 0) goto L70
            java.util.concurrent.atomic.AtomicBoolean r8 = com.transsion.ad.ps.attribution.AttributionConsumeManager.f42232d
            r8.set(r3)
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        L70:
            if (r8 == 0) goto L77
            java.lang.String r8 = r8.getReportUrl()
            goto L78
        L77:
            r8 = 0
        L78:
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L93
            com.transsion.ad.db.pslink.AttributionPoint r8 = com.transsion.ad.ps.attribution.AttributionConsumeManager.f42233e
            if (r8 == 0) goto L8d
            com.transsion.ad.ps.attribution.AttributionConsumeManager r2 = com.transsion.ad.ps.attribution.AttributionConsumeManager.f42231c
            r0.label = r5
            java.lang.Object r8 = r2.c(r8, r0)
            if (r8 != r1) goto L8d
            return r1
        L8d:
            r7.p()
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        L93:
            r0.label = r4
            java.lang.Object r8 = r7.o(r0)
            if (r8 != r1) goto L9c
            return r1
        L9c:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.attribution.AttributionConsumeManager.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void n() {
        k.d(o0.a(y0.b()), null, null, new AttributionConsumeManager$consume$1(null), 3, null);
    }
}
