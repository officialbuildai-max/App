package com.transsion.home.repository;

import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesIntervalTime;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class HomePreferencesRepository {

    /* renamed from: c, reason: collision with root package name */
    public static final a f45602c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f45603d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final ol.b f45604a;

    /* renamed from: b, reason: collision with root package name */
    private final mj.a f45605b;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomePreferencesRepository(ol.b api, AppDatabase appDatabase) {
        Intrinsics.h(api, "api");
        Intrinsics.h(appDatabase, "appDatabase");
        this.f45604a = api;
        this.f45605b = appDatabase.r1();
    }

    private final boolean e(long j11, HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, HomePreferencesIntervalTime homePreferencesIntervalTime) {
        long j12;
        long j13;
        if (homePreferencesIntervalTimeDbBean == null) {
            return true;
        }
        long showInterval = homePreferencesIntervalTime.getShowInterval();
        long closeInterval = homePreferencesIntervalTime.getCloseInterval();
        long chooseInterval = homePreferencesIntervalTime.getChooseInterval();
        if (homePreferencesIntervalTimeDbBean.getShowTime() <= 0 || showInterval <= 0) {
            j12 = 0;
            j13 = 0;
        } else {
            long showTime = homePreferencesIntervalTimeDbBean.getShowTime() + (showInterval * 1000);
            j12 = 0;
            j13 = Math.max(0L, showTime);
        }
        if (homePreferencesIntervalTimeDbBean.getCloseTime() > j12 && closeInterval > j12) {
            j13 = Math.max(j13, homePreferencesIntervalTimeDbBean.getCloseTime() + (closeInterval * 1000));
        }
        if (homePreferencesIntervalTimeDbBean.getChooseTime() > 0 && chooseInterval > 0) {
            j13 = Math.max(j13, homePreferencesIntervalTimeDbBean.getChooseTime() + (chooseInterval * 1000));
        }
        a.C0856a c0856a = lg.a.f68962a;
        boolean z10 = j11 >= j13;
        a.C0856a.l(c0856a, "HomePreferencesRepository", "----canShow:>>>> " + z10 + " <<<<<, id:" + homePreferencesIntervalTimeDbBean.getId() + ",now:" + j11 + ", showTime:" + homePreferencesIntervalTimeDbBean.getShowTime() + ", closeTime:" + homePreferencesIntervalTimeDbBean.getCloseTime() + ", chooseTime:" + homePreferencesIntervalTimeDbBean.getChooseTime(), false, 4, null);
        return j11 >= j13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(HomePreferencesIntervalTimeDbBean bean, long j11) {
        Intrinsics.h(bean, "bean");
        bean.setChooseTime(j11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(HomePreferencesIntervalTimeDbBean bean, long j11) {
        Intrinsics.h(bean, "bean");
        bean.setCloseTime(j11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(HomePreferencesIntervalTimeDbBean bean, long j11) {
        Intrinsics.h(bean, "bean");
        bean.setShowTime(j11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(com.transsion.home.bean.HomePreferencesConfig r41, kotlin.jvm.functions.Function2 r42, kotlin.coroutines.Continuation r43) {
        /*
            r40 = this;
            r0 = r40
            r1 = r43
            boolean r2 = r1 instanceof com.transsion.home.repository.HomePreferencesRepository$updateIntervalRecord$1
            if (r2 == 0) goto L17
            r2 = r1
            com.transsion.home.repository.HomePreferencesRepository$updateIntervalRecord$1 r2 = (com.transsion.home.repository.HomePreferencesRepository$updateIntervalRecord$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.transsion.home.repository.HomePreferencesRepository$updateIntervalRecord$1 r2 = new com.transsion.home.repository.HomePreferencesRepository$updateIntervalRecord$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L4c
            if (r4 == r6) goto L39
            if (r4 != r5) goto L31
            kotlin.ResultKt.b(r1)
            goto Ldc
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            long r6 = r2.J$0
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r2.L$0
            com.transsion.home.bean.HomePreferencesConfig r9 = (com.transsion.home.bean.HomePreferencesConfig) r9
            kotlin.ResultKt.b(r1)
            r11 = r4
            goto L71
        L4c:
            kotlin.ResultKt.b(r1)
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = r41.getLabelId()
            mj.a r1 = r0.f45605b
            r9 = r41
            r2.L$0 = r9
            r10 = r42
            r2.L$1 = r10
            r2.L$2 = r4
            r2.J$0 = r7
            r2.label = r6
            java.lang.Object r1 = r1.b(r4, r2)
            if (r1 != r3) goto L6e
            return r3
        L6e:
            r11 = r4
            r6 = r7
            r8 = r10
        L71:
            com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean r1 = (com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean) r1
            if (r1 != 0) goto L99
            com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean r1 = new com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean
            com.transsion.home.bean.HomePreferencesIntervalTime r4 = r9.getIntervalTime()
            long r18 = r4.getShowInterval()
            com.transsion.home.bean.HomePreferencesIntervalTime r4 = r9.getIntervalTime()
            long r20 = r4.getCloseInterval()
            com.transsion.home.bean.HomePreferencesIntervalTime r4 = r9.getIntervalTime()
            long r22 = r4.getChooseInterval()
            r12 = 0
            r14 = 0
            r16 = 0
            r10 = r1
            r10.<init>(r11, r12, r14, r16, r18, r20, r22)
        L99:
            r24 = r1
            com.transsion.home.bean.HomePreferencesIntervalTime r1 = r9.getIntervalTime()
            long r32 = r1.getShowInterval()
            com.transsion.home.bean.HomePreferencesIntervalTime r1 = r9.getIntervalTime()
            long r34 = r1.getCloseInterval()
            com.transsion.home.bean.HomePreferencesIntervalTime r1 = r9.getIntervalTime()
            long r36 = r1.getChooseInterval()
            r38 = 15
            r39 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean r1 = com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean.copy$default(r24, r25, r26, r28, r30, r32, r34, r36, r38, r39)
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.e(r6)
            r8.invoke(r1, r4)
            mj.a r4 = r0.f45605b
            r6 = 0
            r2.L$0 = r6
            r2.L$1 = r6
            r2.L$2 = r6
            r2.label = r5
            java.lang.Object r1 = r4.a(r1, r2)
            if (r1 != r3) goto Ldc
            return r3
        Ldc:
            kotlin.Unit r1 = kotlin.Unit.f67184a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.repository.HomePreferencesRepository.n(com.transsion.home.bean.HomePreferencesConfig, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0130 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:12:0x0041, B:13:0x0124, B:15:0x0130, B:16:0x0159, B:22:0x0108), top: B:11:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0123 -> B:13:0x0124). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r20, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.repository.HomePreferencesRepository.f(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object g(HomePreferencesConfig homePreferencesConfig, Continuation continuation) {
        Object n11 = n(homePreferencesConfig, new Function2() { // from class: com.transsion.home.repository.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit h11;
                h11 = HomePreferencesRepository.h((HomePreferencesIntervalTimeDbBean) obj, ((Long) obj2).longValue());
                return h11;
            }
        }, continuation);
        return n11 == IntrinsicsKt.f() ? n11 : Unit.f67184a;
    }

    public final Object i(HomePreferencesConfig homePreferencesConfig, Continuation continuation) {
        Object n11 = n(homePreferencesConfig, new Function2() { // from class: com.transsion.home.repository.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit j11;
                j11 = HomePreferencesRepository.j((HomePreferencesIntervalTimeDbBean) obj, ((Long) obj2).longValue());
                return j11;
            }
        }, continuation);
        return n11 == IntrinsicsKt.f() ? n11 : Unit.f67184a;
    }

    public final Object k(HomePreferencesConfig homePreferencesConfig, Continuation continuation) {
        Object n11 = n(homePreferencesConfig, new Function2() { // from class: com.transsion.home.repository.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit l11;
                l11 = HomePreferencesRepository.l((HomePreferencesIntervalTimeDbBean) obj, ((Long) obj2).longValue());
                return l11;
            }
        }, continuation);
        return n11 == IntrinsicsKt.f() ? n11 : Unit.f67184a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:24|25))(2:26|(2:28|29)(3:30|31|(1:33)))|13|14|(1:16)|17|(1:19)|20|21))|36|6|7|8|(0)(0)|13|14|(0)|17|(0)|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0034, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r14 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r14));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r12, java.util.List r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.repository.HomePreferencesRepository.m(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
