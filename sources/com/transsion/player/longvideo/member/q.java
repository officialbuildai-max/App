package com.transsion.player.longvideo.member;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f48287a = new q();

    private q() {
    }

    public final go.b a(List resolutionList) {
        Object obj;
        Intrinsics.h(resolutionList, "resolutionList");
        Iterator it = resolutionList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int e11 = f48287a.e(((go.b) next).d());
                do {
                    Object next2 = it.next();
                    int e12 = f48287a.e(((go.b) next2).d());
                    if (e11 < e12) {
                        next = next2;
                        e11 = e12;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (go.b) obj;
    }

    public final go.b b(List resolutionList) {
        Object obj;
        Intrinsics.h(resolutionList, "resolutionList");
        Iterator it = resolutionList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int e11 = f48287a.e(((go.b) next).d());
                do {
                    Object next2 = it.next();
                    int e12 = f48287a.e(((go.b) next2).d());
                    if (e11 > e12) {
                        next = next2;
                        e11 = e12;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (go.b) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c() {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            sm.f$a r0 = sm.f.f75530c     // Catch: java.lang.Throwable -> L18
            sm.f r0 = r0.a()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "stream_resolution_ratio"
            r2 = 1
            com.transsion.mb.config.manager.ConfigBean r0 = r0.c(r1, r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L30
        L1a:
            java.lang.String r0 = ""
        L1c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L18
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "vipResolutionRatio"
            int r0 = r1.optInt(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L18
            goto L3a
        L30:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3a:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto L41
            goto L47
        L41:
            r0 = 1080(0x438, float:1.513E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L47:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.player.longvideo.member.q.c():int");
    }

    public final String d() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(f(c()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = String.valueOf(f48287a.c());
        }
        return (String) m1185constructorimpl;
    }

    public final int e(String str) {
        Integer num;
        if (str == null || StringsKt.q0(str)) {
            return 0;
        }
        String upperCase = StringsKt.n1(str).toString().toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        int hashCode = upperCase.hashCode();
        if (hashCode == 1625) {
            if (upperCase.equals("2K")) {
                num = 1440;
            }
            num = null;
        } else if (hashCode == 1687) {
            if (upperCase.equals("4K")) {
                num = 2160;
            }
            num = null;
        } else if (hashCode != 1718) {
            if (hashCode == 1811 && upperCase.equals("8K")) {
                num = 4320;
            }
            num = null;
        } else {
            if (upperCase.equals("5K")) {
                num = 2880;
            }
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        Integer v11 = StringsKt.v(StringsKt.J0(upperCase, "P"));
        if (v11 != null) {
            return v11.intValue();
        }
        return 0;
    }

    public final String f(int i11) {
        if (i11 >= 4320) {
            return "8K";
        }
        if (i11 >= 2880) {
            return "5K";
        }
        if (i11 >= 2160) {
            return "4K";
        }
        if (i11 >= 1440) {
            return "2K";
        }
        if (i11 >= 1080) {
            return "1080P";
        }
        if (i11 >= 720) {
            return "720P";
        }
        if (i11 >= 576) {
            return "576P";
        }
        if (i11 >= 480) {
            return "480P";
        }
        if (i11 >= 360) {
            return "360P";
        }
        if (i11 >= 240) {
            return "240P";
        }
        return i11 + "P";
    }
}
