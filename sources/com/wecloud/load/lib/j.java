package com.wecloud.load.lib;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f60969a = new j();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference f60970b = new AtomicReference(null);

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, Map map);
    }

    private j() {
    }

    public final void a(List results) {
        Intrinsics.h(results, "results");
        a aVar = (a) f60970b.get();
        if (aVar == null) {
            return;
        }
        Iterator it = results.iterator();
        while (it.hasNext()) {
            aVar.a("network_probe", c((n) it.next()));
        }
    }

    public final void b(a aVar) {
        f60970b.set(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r5.isEmpty() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map c(com.wecloud.load.lib.n r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "result"
            kotlin.jvm.internal.Intrinsics.h(r15, r2)
            java.lang.String r2 = r15.k()
            boolean r3 = kotlin.text.StringsKt.q0(r2)
            r4 = 0
            if (r3 != 0) goto L13
            goto L14
        L13:
            r2 = r4
        L14:
            int r3 = r15.l()
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 == r5) goto L1e
            r3 = r1
            goto L1f
        L1e:
            r3 = r0
        L1f:
            if (r3 == 0) goto L2c
            java.util.Map r5 = r15.g()
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L2c
            goto L2d
        L2c:
            r5 = r4
        L2d:
            if (r3 == 0) goto L3a
            java.lang.String r3 = r15.f()
            boolean r6 = kotlin.text.StringsKt.q0(r3)
            if (r6 != 0) goto L3a
            r4 = r3
        L3a:
            java.lang.String r3 = "url"
            java.lang.String r6 = r15.n()
            kotlin.Pair r3 = kotlin.TuplesKt.a(r3, r6)
            java.lang.String r6 = "method"
            java.lang.String r7 = r15.i()
            kotlin.Pair r6 = kotlin.TuplesKt.a(r6, r7)
            boolean r7 = r15.m()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "success"
            kotlin.Pair r7 = kotlin.TuplesKt.a(r8, r7)
            int r8 = r15.l()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "status_code"
            kotlin.Pair r8 = kotlin.TuplesKt.a(r9, r8)
            long r9 = r15.c()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r10 = "duration"
            kotlin.Pair r9 = kotlin.TuplesKt.a(r10, r9)
            long r10 = r15.j()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            java.lang.String r11 = "request_time"
            kotlin.Pair r10 = kotlin.TuplesKt.a(r11, r10)
            int r11 = r15.d()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.String r12 = "error_code"
            kotlin.Pair r11 = kotlin.TuplesKt.a(r12, r11)
            java.lang.String r12 = "error_message"
            java.lang.String r13 = r15.e()
            kotlin.Pair r12 = kotlin.TuplesKt.a(r12, r13)
            java.lang.String r13 = "server_ip"
            kotlin.Pair r2 = kotlin.TuplesKt.a(r13, r2)
            java.lang.String r13 = "http_headers"
            kotlin.Pair r5 = kotlin.TuplesKt.a(r13, r5)
            java.lang.String r13 = "http_body"
            kotlin.Pair r4 = kotlin.TuplesKt.a(r13, r4)
            java.lang.String r13 = "http_protocol"
            java.lang.String r15 = r15.h()
            kotlin.Pair r15 = kotlin.TuplesKt.a(r13, r15)
            r13 = 12
            kotlin.Pair[] r13 = new kotlin.Pair[r13]
            r13[r0] = r3
            r13[r1] = r6
            r0 = 2
            r13[r0] = r7
            r0 = 3
            r13[r0] = r8
            r0 = 4
            r13[r0] = r9
            r0 = 5
            r13[r0] = r10
            r0 = 6
            r13[r0] = r11
            r0 = 7
            r13[r0] = r12
            r0 = 8
            r13[r0] = r2
            r0 = 9
            r13[r0] = r5
            r0 = 10
            r13[r0] = r4
            r0 = 11
            r13[r0] = r15
            java.util.LinkedHashMap r15 = kotlin.collections.MapsKt.k(r13)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.j.c(com.wecloud.load.lib.n):java.util.Map");
    }
}
