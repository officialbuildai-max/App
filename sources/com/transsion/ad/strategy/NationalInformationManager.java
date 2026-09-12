package com.transsion.ad.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class NationalInformationManager {

    /* renamed from: a, reason: collision with root package name */
    public static final NationalInformationManager f42278a = new NationalInformationManager();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Map f42279b;

    private NationalInformationManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        String simpleName = NationalInformationManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final Object f(Continuation continuation) {
        Map map = f42279b;
        return map != null ? map : kotlinx.coroutines.i.g(y0.b(), new NationalInformationManager$getMccCache$3(null), continuation);
    }

    public final Object c(Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new NationalInformationManager$getAllNationalInformationList$2(null), continuation);
    }

    public final String e() {
        String string;
        MMKV c11 = bh.a.f16551a.c();
        String str = "";
        if (c11 != null && (string = c11.getString("sp_code", "")) != null) {
            str = string;
        }
        if (TextUtils.isEmpty(str)) {
            str = ih.b.f65364a.o();
        }
        if (str.length() <= 0 || str.length() < 3) {
            return str;
        }
        String substring = str.substring(0, 3);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.ad.strategy.NationalInformationManager$getNationalInformation$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.ad.strategy.NationalInformationManager$getNationalInformation$1 r0 = (com.transsion.ad.strategy.NationalInformationManager$getNationalInformation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.strategy.NationalInformationManager$getNationalInformation$1 r0 = new com.transsion.ad.strategy.NationalInformationManager$getNationalInformation$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.f(r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.util.Map r6 = (java.util.Map) r6
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.g(r5, r0)
            java.lang.Object r5 = r6.get(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.strategy.NationalInformationManager.g(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object h(Context context, Continuation continuation) {
        Object g11 = kotlinx.coroutines.i.g(y0.b(), new NationalInformationManager$initLocalMcc$2(context, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }
}
