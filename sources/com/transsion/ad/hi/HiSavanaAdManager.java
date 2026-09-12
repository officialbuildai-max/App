package com.transsion.ad.hi;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import ih.b;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class HiSavanaAdManager {

    /* renamed from: a, reason: collision with root package name */
    public static final HiSavanaAdManager f42171a = new HiSavanaAdManager();

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f42172b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f42173c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static final Set f42174d = new LinkedHashSet();

    private HiSavanaAdManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        String simpleName = HiSavanaAdManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean h() {
        b bVar = b.f65364a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return ((double) bVar.k(a11).totalMem) <= ((double) 1073741824) * ((double) com.transsion.ad.scene.b.f42256a.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5 A[LOOP:0: B:11:0x009f->B:13:0x00a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.transsion.ad.hi.HiSavanaAdManager$onInitSuccess$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.ad.hi.HiSavanaAdManager$onInitSuccess$1 r0 = (com.transsion.ad.hi.HiSavanaAdManager$onInitSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.hi.HiSavanaAdManager$onInitSuccess$1 r0 = new com.transsion.ad.hi.HiSavanaAdManager$onInitSuccess$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r11)
            goto L6b
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L31:
            kotlin.ResultKt.b(r11)
            com.transsion.ad.MBAd r11 = com.transsion.ad.MBAd.f41805a
            com.transsion.ad.MBAd$a r11 = r11.c()
            if (r11 == 0) goto L4d
            boolean r11 = r11.k()
            if (r11 != 0) goto L4d
            r0.label = r3
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r11 = kotlinx.coroutines.u0.a(r4, r0)
            if (r11 != r1) goto L6b
            return r1
        L4d:
            oi.a r4 = oi.a.f71145a
            java.lang.String r11 = r10.f()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = " --> initHiAdSdk() --> complete -- 媒体取消延时"
            r0.append(r11)
            java.lang.String r5 = r0.toString()
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            oi.a.c(r4, r5, r6, r7, r8, r9)
        L6b:
            java.util.concurrent.atomic.AtomicBoolean r11 = com.transsion.ad.hi.HiSavanaAdManager.f42173c
            r11.set(r3)
            oi.a r4 = oi.a.f71145a
            java.lang.String r11 = r10.f()
            java.util.concurrent.atomic.AtomicBoolean r0 = com.transsion.ad.hi.HiSavanaAdManager.f42173c
            boolean r0 = r0.get()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r11 = " --> initHiAdSdk() --> complete -- isInitialized = "
            r1.append(r11)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            oi.a.c(r4, r5, r6, r7, r8, r9)
            java.util.Set r11 = com.transsion.ad.hi.HiSavanaAdManager.f42174d
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L9f:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto Laf
            java.lang.Object r0 = r11.next()
            com.transsion.ad.hi.a r0 = (com.transsion.ad.hi.a) r0
            r0.onInitSuccess()
            goto L9f
        Laf:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.hi.HiSavanaAdManager.j(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(a listener) {
        Intrinsics.h(listener, "listener");
        f42174d.add(listener);
    }

    public final Object g(String str, boolean z10, boolean z11, Continuation continuation) {
        if (h()) {
            oi.a.c(oi.a.f71145a, f() + " --> initHiAdSdk() --> 2g & 开关不打开直接关闭sdk初始化", 6, false, 4, null);
            return Unit.f67184a;
        }
        if (f42172b.compareAndSet(false, true)) {
            Object g11 = i.g(y0.b(), new HiSavanaAdManager$initHiAdSdk$2(str, z11, z10, null), continuation);
            return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
        }
        oi.a.c(oi.a.f71145a, f() + " --> initHiAdSdk() --> isInitializing == true", 6, false, 4, null);
        return Unit.f67184a;
    }

    public final boolean i() {
        return f42173c.get();
    }

    public final void k(a listener) {
        Intrinsics.h(listener, "listener");
        Set set = f42174d;
        if (!set.isEmpty() && set.contains(listener)) {
            set.remove(listener);
        }
    }
}
