package com.transsion.ad.monopoly.intercept;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ti.p;

/* loaded from: classes5.dex */
public final class ValidDispatchTimeHandler extends com.transsion.ad.monopoly.intercept.a {

    /* renamed from: b, reason: collision with root package name */
    public static final b f42194b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final a f42195c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap f42196d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static volatile String f42197e = "";

    /* loaded from: classes5.dex */
    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair b(String str, String str2) {
            Object m1185constructorimpl;
            SimpleDateFormat simpleDateFormat;
            Date parse;
            String c11 = p.f76389a.c();
            if (!Intrinsics.c(ValidDispatchTimeHandler.f42197e, c11)) {
                ValidDispatchTimeHandler.f42196d.clear();
                ValidDispatchTimeHandler.f42197e = c11;
            }
            String str3 = str + "_" + str2;
            Pair pair = (Pair) ValidDispatchTimeHandler.f42196d.get(str3);
            if (pair != null) {
                return pair;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                simpleDateFormat = (SimpleDateFormat) ValidDispatchTimeHandler.f42195c.get();
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (simpleDateFormat == null) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            Date parse2 = simpleDateFormat.parse(str);
            if (parse2 == null || (parse = simpleDateFormat.parse(str2)) == null) {
                return null;
            }
            Object clone = calendar.clone();
            Intrinsics.f(clone, "null cannot be cast to non-null type java.util.Calendar");
            Calendar calendar2 = (Calendar) clone;
            calendar2.setTime(parse2);
            calendar2.set(1, calendar.get(1));
            calendar2.set(2, calendar.get(2));
            calendar2.set(5, calendar.get(5));
            long timeInMillis = calendar2.getTimeInMillis();
            Object clone2 = calendar.clone();
            Intrinsics.f(clone2, "null cannot be cast to non-null type java.util.Calendar");
            Calendar calendar3 = (Calendar) clone2;
            calendar3.setTime(parse);
            calendar3.set(1, calendar.get(1));
            calendar3.set(2, calendar.get(2));
            calendar3.set(5, calendar.get(5));
            m1185constructorimpl = Result.m1185constructorimpl(new Pair(Long.valueOf(timeInMillis), Long.valueOf(calendar3.getTimeInMillis())));
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            Pair pair2 = (Pair) m1185constructorimpl;
            if (pair2 == null) {
                return null;
            }
            ValidDispatchTimeHandler.f42196d.put(str3, pair2);
            return pair2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r11, com.transsion.ad.db.plan.MbAdDbPlans r12, java.util.Map r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r14
            com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler$doHandle$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.b(r14)
            goto Lb6
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            kotlin.ResultKt.b(r14)
            goto L7c
        L3c:
            kotlin.ResultKt.b(r14)
            goto Ld7
        L41:
            kotlin.ResultKt.b(r14)
            r14 = 0
            if (r12 == 0) goto L4c
            java.lang.String r2 = r12.getDispatchTimeStart()
            goto L4d
        L4c:
            r2 = r14
        L4d:
            if (r12 == 0) goto L53
            java.lang.String r14 = r12.getDispatchTimeEnd()
        L53:
            if (r2 == 0) goto Lc8
            boolean r6 = kotlin.text.StringsKt.q0(r2)
            if (r6 == 0) goto L5c
            goto Lc8
        L5c:
            if (r14 == 0) goto Lc8
            boolean r6 = kotlin.text.StringsKt.q0(r14)
            if (r6 == 0) goto L65
            goto Lc8
        L65:
            com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler$b r5 = com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler.f42194b
            kotlin.Pair r14 = com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler.b.a(r5, r2, r14)
            if (r14 != 0) goto L85
            com.transsion.ad.monopoly.intercept.a r14 = r10.c()
            if (r14 == 0) goto L80
            r0.label = r4
            java.lang.Object r14 = r14.b(r11, r12, r13, r0)
            if (r14 != r1) goto L7c
            return r1
        L7c:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r14
            if (r14 != 0) goto L84
        L80:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = r10.e()
        L84:
            return r14
        L85:
            java.lang.Object r2 = r14.getFirst()
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
            java.lang.Object r14 = r14.getSecond()
            java.lang.Number r14 = (java.lang.Number) r14
            long r6 = r14.longValue()
            ti.p r14 = ti.p.f76389a
            long r8 = r14.d()
            int r14 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r14 > 0) goto Lbf
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r14 > 0) goto Lbf
            com.transsion.ad.monopoly.intercept.a r14 = r10.c()
            if (r14 == 0) goto Lba
            r0.label = r3
            java.lang.Object r14 = r14.b(r11, r12, r13, r0)
            if (r14 != r1) goto Lb6
            return r1
        Lb6:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r14
            if (r14 != 0) goto Lc7
        Lba:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = r10.e()
            goto Lc7
        Lbf:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            r11 = 0
            java.lang.String r12 = "当前不在展示时间内--时间段"
            r14.<init>(r11, r12)
        Lc7:
            return r14
        Lc8:
            com.transsion.ad.monopoly.intercept.a r14 = r10.c()
            if (r14 == 0) goto Ldb
            r0.label = r5
            java.lang.Object r14 = r14.b(r11, r12, r13, r0)
            if (r14 != r1) goto Ld7
            return r1
        Ld7:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r14
            if (r14 != 0) goto Ldf
        Ldb:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = r10.e()
        Ldf:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.ValidDispatchTimeHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
