package com.transsion.ad.strategy;

import com.transsion.ad.monopoly.model.MbAdPlansBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f42285a = new d();

    private d() {
    }

    private final List c() {
        ArrayList arrayList = new ArrayList();
        try {
            Result.Companion companion = Result.INSTANCE;
            Iterator it = StringsKt.S0(b(), new String[]{","}, false, 0, 6, null).iterator();
            while (it.hasNext()) {
                String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                arrayList.add(upperCase);
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return arrayList;
    }

    public final Map a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("genre", str);
        return linkedHashMap;
    }

    public final String b() {
        String string = f.f42286a.c().getString("ad_plan_genre", "");
        return string == null ? "" : string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        if (r10 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.util.Map r10) {
        /*
            r9 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L12
            if (r10 == 0) goto L94
            java.lang.String r0 = "genre"
            java.lang.Object r0 = r10.get(r0)     // Catch: java.lang.Throwable -> L12
            boolean r1 = r0 instanceof java.lang.String     // Catch: java.lang.Throwable -> L12
            r2 = 0
            if (r1 == 0) goto L15
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L12
            goto L16
        L12:
            r10 = move-exception
            goto L9e
        L15:
            r0 = r2
        L16:
            java.lang.String r1 = "toUpperCase(...)"
            if (r0 == 0) goto L25
            java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toUpperCase(r3)     // Catch: java.lang.Throwable -> L12
            kotlin.jvm.internal.Intrinsics.g(r0, r1)     // Catch: java.lang.Throwable -> L12
            r3 = r0
            goto L26
        L25:
            r3 = r2
        L26:
            if (r3 == 0) goto L35
            java.lang.String r4 = " "
            java.lang.String r5 = ""
            r7 = 4
            r8 = 0
            r6 = 0
            java.lang.String r0 = kotlin.text.StringsKt.Q(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L12
            r3 = r0
            goto L36
        L35:
            r3 = r2
        L36:
            if (r3 == 0) goto L47
            java.lang.String r0 = ","
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L12
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.List r0 = kotlin.text.StringsKt.S0(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L12
            goto L48
        L47:
            r0 = r2
        L48:
            java.lang.String r3 = "channelId"
            java.lang.Object r10 = r10.get(r3)     // Catch: java.lang.Throwable -> L12
            boolean r3 = r10 instanceof java.lang.String     // Catch: java.lang.Throwable -> L12
            if (r3 == 0) goto L55
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L12
            goto L56
        L55:
            r10 = r2
        L56:
            if (r10 == 0) goto L63
            java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L12
            java.lang.String r10 = r10.toUpperCase(r3)     // Catch: java.lang.Throwable -> L12
            kotlin.jvm.internal.Intrinsics.g(r10, r1)     // Catch: java.lang.Throwable -> L12
            if (r10 != 0) goto L65
        L63:
            java.lang.String r10 = ""
        L65:
            if (r0 == 0) goto L6d
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L12
            java.util.List r2 = kotlin.collections.CollectionsKt.U0(r0)     // Catch: java.lang.Throwable -> L12
        L6d:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L78
            if (r2 == 0) goto L78
            r2.add(r10)     // Catch: java.lang.Throwable -> L12
        L78:
            ti.k r10 = ti.k.f76385a     // Catch: java.lang.Throwable -> L12
            if (r2 == 0) goto L84
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L12
            java.util.List r0 = kotlin.collections.CollectionsKt.U0(r2)     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L89
        L84:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
        L89:
            com.transsion.ad.strategy.d r1 = com.transsion.ad.strategy.d.f42285a     // Catch: java.lang.Throwable -> L12
            java.util.List r1 = r1.c()     // Catch: java.lang.Throwable -> L12
            boolean r10 = r10.a(r0, r1)     // Catch: java.lang.Throwable -> L12
            goto L95
        L94:
            r10 = 0
        L95:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> L12
            java.lang.Object r10 = kotlin.Result.m1185constructorimpl(r10)     // Catch: java.lang.Throwable -> L12
            goto La8
        L9e:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.a(r10)
            java.lang.Object r10 = kotlin.Result.m1185constructorimpl(r10)
        La8:
            java.lang.Throwable r0 = kotlin.Result.m1188exceptionOrNullimpl(r10)
            if (r0 != 0) goto Laf
            goto Lb1
        Laf:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
        Lb1:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.strategy.d.d(java.util.Map):boolean");
    }

    public final void e(MbAdPlansBean mbAdPlansBean) {
        f.f42286a.c().putString("ad_plan_genre", mbAdPlansBean != null ? mbAdPlansBean.getGenre() : null);
        oi.a.c(oi.a.f71145a, d.class.getSimpleName() + " --> saveGenre() --> genre = " + (mbAdPlansBean != null ? mbAdPlansBean.getGenre() : null), 0, false, 6, null);
    }
}
