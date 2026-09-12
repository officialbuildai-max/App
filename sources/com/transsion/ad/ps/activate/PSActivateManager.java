package com.transsion.ad.ps.activate;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class PSActivateManager {

    /* renamed from: a, reason: collision with root package name */
    public static final PSActivateManager f42225a = new PSActivateManager();

    /* renamed from: b, reason: collision with root package name */
    private static final PriorityBlockingQueue f42226b = new PriorityBlockingQueue(11, new Comparator() { // from class: com.transsion.ad.ps.activate.PSActivateManager$special$$inlined$compareByDescending$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t11, T t12) {
            Double ecpm = ((PsActivateBean) t12).getECPM();
            Double valueOf = Double.valueOf(0.0d);
            if (ecpm == null) {
                ecpm = valueOf;
            }
            Double ecpm2 = ((PsActivateBean) t11).getECPM();
            if (ecpm2 != null) {
                valueOf = ecpm2;
            }
            return ComparisonsKt.d(ecpm, valueOf);
        }
    });

    private PSActivateManager() {
    }

    public final void a(PsActivateBean bean) {
        Intrinsics.h(bean, "bean");
        f42226b.offer(bean);
    }

    public final PsActivateBean b() {
        return (PsActivateBean) f42226b.poll();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[LOOP:0: B:12:0x0060->B:14:0x0066, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsion.ad.ps.activate.PSActivateManager$getRecentTwoHoursOpenAdList$1
            if (r0 == 0) goto L14
            r0 = r12
            com.transsion.ad.ps.activate.PSActivateManager$getRecentTwoHoursOpenAdList$1 r0 = (com.transsion.ad.ps.activate.PSActivateManager$getRecentTwoHoursOpenAdList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.transsion.ad.ps.activate.PSActivateManager$getRecentTwoHoursOpenAdList$1 r0 = new com.transsion.ad.ps.activate.PSActivateManager$getRecentTwoHoursOpenAdList$1
            r0.<init>(r11, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.b(r12)
            goto L4f
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L33:
            kotlin.ResultKt.b(r12)
            com.transsion.ad.ps.installed.AppInstallManager r1 = com.transsion.ad.ps.installed.AppInstallManager.f42250a
            android.app.Application r12 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r3 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r12, r3)
            r5.label = r2
            r3 = 0
            r6 = 2
            r7 = 0
            r2 = r12
            java.lang.Object r12 = com.transsion.ad.ps.installed.AppInstallManager.c(r1, r2, r3, r5, r6, r7)
            if (r12 != r0) goto L4f
            return r0
        L4f:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.v(r12, r1)
            r0.<init>(r1)
            java.util.Iterator r12 = r12.iterator()
        L60:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L74
            java.lang.Object r1 = r12.next()
            com.transsion.ad.db.pslink.AppInstalledBean r1 = (com.transsion.ad.db.pslink.AppInstalledBean) r1
            java.lang.String r1 = r1.getPackageName()
            r0.add(r1)
            goto L60
        L74:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r12 = r0.iterator()
        L7d:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L94
            java.lang.Object r0 = r12.next()
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = kotlin.text.StringsKt.q0(r1)
            if (r1 != 0) goto L7d
            r2.add(r0)
            goto L7d
        L94:
            r9 = 62
            r10 = 0
            java.lang.String r3 = ","
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r12 = kotlin.collections.CollectionsKt.s0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.activate.PSActivateManager.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean d() {
        return !f42226b.isEmpty();
    }

    public final void e() {
        f(false);
    }

    public final void f(boolean z10) {
        k.d(o0.a(y0.b()), null, null, new PSActivateManager$requestActivateAd$1(z10, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007b -> B:10:0x007e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.util.List r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsion.ad.ps.activate.PSActivateManager$saveAdCache$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.ad.ps.activate.PSActivateManager$saveAdCache$1 r0 = (com.transsion.ad.ps.activate.PSActivateManager$saveAdCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.ps.activate.PSActivateManager$saveAdCache$1 r0 = new com.transsion.ad.ps.activate.PSActivateManager$saveAdCache$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$1
            com.transsion.ad.ps.activate.PsActivateBean r7 = (com.transsion.ad.ps.activate.PsActivateBean) r7
            java.lang.Object r2 = r0.L$0
            java.util.Iterator r2 = (java.util.Iterator) r2
            kotlin.ResultKt.b(r8)
            goto L7e
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.PriorityBlockingQueue r8 = com.transsion.ad.ps.activate.PSActivateManager.f42226b
            r8.clear()
            if (r7 == 0) goto L91
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r2 = r7
        L4a:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L91
            java.lang.Object r7 = r2.next()
            com.transsion.ad.ps.activate.PsActivateBean r7 = (com.transsion.ad.ps.activate.PsActivateBean) r7
            com.transsion.ad.db.MbAdDatabase$n r8 = com.transsion.ad.db.MbAdDatabase.INSTANCE
            android.app.Application r4 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r5 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r4, r5)
            com.transsion.ad.db.MbAdDatabase r8 = r8.b(r4)
            mi.a r8 = r8.w0()
            java.lang.String r4 = r7.getPackageName()
            if (r4 != 0) goto L71
            java.lang.String r4 = ""
        L71:
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.b(r4, r0)
            if (r8 != r1) goto L7e
            return r1
        L7e:
            com.transsion.ad.db.pslink.AppInstalledBean r8 = (com.transsion.ad.db.pslink.AppInstalledBean) r8
            if (r8 == 0) goto L87
            java.lang.Double r8 = r8.getECPM()
            goto L88
        L87:
            r8 = 0
        L88:
            r7.setECPM(r8)
            java.util.concurrent.PriorityBlockingQueue r8 = com.transsion.ad.ps.activate.PSActivateManager.f42226b
            r8.add(r7)
            goto L4a
        L91:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.activate.PSActivateManager.g(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
