package com.transsion.ad.monopoly.manager;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.g;

/* loaded from: classes5.dex */
public final class AdPlansStorageManager {

    /* renamed from: c, reason: collision with root package name */
    private static volatile List f42209c;

    /* renamed from: a, reason: collision with root package name */
    public static final AdPlansStorageManager f42207a = new AdPlansStorageManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42208b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.manager.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            li.b e11;
            e11 = AdPlansStorageManager.e();
            return e11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Map f42210d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.sync.a f42211e = g.b(false, 1, null);

    private AdPlansStorageManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final li.b e() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).z0();
    }

    private final List g(List list, String str) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            List<String> scenes = ((MbAdDbPlans) obj).getScenes();
            List<String> list2 = scenes;
            if (list2 != null && !list2.isEmpty()) {
                List<String> list3 = scenes;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        if (StringsKt.H((String) it.next(), str, true)) {
                        }
                    }
                }
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static /* synthetic */ Object i(AdPlansStorageManager adPlansStorageManager, String str, Map map, String str2, AdPlanSourceManager.AdPlanEnum[] adPlanEnumArr, Continuation continuation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        return adPlansStorageManager.h(str, map, str2, adPlanEnumArr, continuation);
    }

    private final li.b k() {
        return (li.b) f42208b.getValue();
    }

    public static /* synthetic */ Object m(AdPlansStorageManager adPlansStorageManager, String str, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        return adPlansStorageManager.l(str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$invalidatePlanCache$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$invalidatePlanCache$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$invalidatePlanCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$invalidatePlanCache$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$invalidatePlanCache$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
            kotlin.ResultKt.b(r6)
            goto L47
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.sync.a r6 = com.transsion.ad.monopoly.manager.AdPlansStorageManager.f42211e
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r0 = r6.h(r4, r0)
            if (r0 != r1) goto L46
            return r1
        L46:
            r0 = r6
        L47:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager.f42209c = r4     // Catch: java.lang.Throwable -> L56
            java.util.Map r6 = com.transsion.ad.monopoly.manager.AdPlansStorageManager.f42210d     // Catch: java.lang.Throwable -> L56
            r6.clear()     // Catch: java.lang.Throwable -> L56
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L56
            r0.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        L56:
            r6 = move-exception
            r0.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAdPlansBySceneIdFromDb$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAdPlansBySceneIdFromDb$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAdPlansBySceneIdFromDb$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAdPlansBySceneIdFromDb$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAdPlansBySceneIdFromDb$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            long r1 = r0.J$0
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.b(r9)
            goto L59
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.b(r9)
            long r4 = android.os.SystemClock.elapsedRealtime()
            li.b r9 = r7.k()
            java.lang.String r2 = com.blankj.utilcode.util.o.j(r8)
            java.lang.String r6 = "toJson(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r6)
            r0.L$0 = r8
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r9 = r9.c(r2, r0)
            if (r9 != r1) goto L58
            return r1
        L58:
            r1 = r4
        L59:
            java.util.List r9 = (java.util.List) r9
            oi.a r0 = oi.a.f71145a
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r1
            if (r9 == 0) goto L6d
            int r1 = r9.size()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            goto L6e
        L6d:
            r1 = 0
        L6e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "AdPlansStorageManager --> getAllAdPlans() --> sceneId = "
            r2.append(r5)
            r2.append(r8)
            java.lang.String r8 = " --> dbCost = "
            r2.append(r8)
            r2.append(r3)
            java.lang.String r8 = "ms --> size = "
            r2.append(r8)
            r2.append(r1)
            java.lang.String r8 = r2.toString()
            r1 = 3
            r2 = 0
            r0.b(r8, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.s(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAllAdPlansFromDb$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAllAdPlansFromDb$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAllAdPlansFromDb$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAllAdPlansFromDb$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$queryAllAdPlansFromDb$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r0 = r0.J$0
            kotlin.ResultKt.b(r7)
            goto L4a
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            kotlin.ResultKt.b(r7)
            long r4 = android.os.SystemClock.elapsedRealtime()
            li.b r7 = r6.k()
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            java.util.List r7 = (java.util.List) r7
            oi.a r2 = oi.a.f71145a
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r0
            if (r7 == 0) goto L5e
            int r0 = r7.size()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.d(r0)
            goto L5f
        L5e:
            r0 = 0
        L5f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "AdPlansStorageManager --> getAllAdPlans() --> dbCost = "
            r1.append(r5)
            r1.append(r3)
            java.lang.String r3 = "ms --> size = "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 3
            r3 = 0
            r2.b(r0, r1, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$deleteExpireVersion$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$deleteExpireVersion$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$deleteExpireVersion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$deleteExpireVersion$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$deleteExpireVersion$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L51
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r7)
            goto L48
        L38:
            kotlin.ResultKt.b(r7)
            li.b r7 = r5.k()
            r0.label = r4
            java.lang.Object r6 = r7.f(r6, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            r0.label = r3
            java.lang.Object r6 = r5.r(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.f(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x013e -> B:11:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r21, java.util.Map r22, java.lang.String r23, com.transsion.ad.monopoly.plan.AdPlanSourceManager.AdPlanEnum[] r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.h(java.lang.String, java.util.Map, java.lang.String, com.transsion.ad.monopoly.plan.AdPlanSourceManager$AdPlanEnum[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object j(Continuation continuation) {
        return k().d(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b9 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #1 {all -> 0x003c, blocks: (B:14:0x0037, B:15:0x00b5, B:17:0x00b9, B:26:0x009b, B:28:0x00a5), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:14:0x0037, B:15:0x00b5, B:17:0x00b9, B:26:0x009b, B:28:0x00a5), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #0 {all -> 0x005c, blocks: (B:33:0x0057, B:34:0x00eb, B:36:0x00ef, B:42:0x00da, B:44:0x00de), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[Catch: all -> 0x005c, TryCatch #0 {all -> 0x005c, blocks: (B:33:0x0057, B:34:0x00eb, B:36:0x00ef, B:42:0x00da, B:44:0x00de), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.l(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object n(String str, Continuation continuation) {
        return k().h(str, continuation);
    }

    public final Object o(String str, Continuation continuation) {
        return k().j(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(com.transsion.ad.db.plan.MbAdDbPlans r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L51
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r7)
            goto L48
        L38:
            kotlin.ResultKt.b(r7)
            li.b r7 = r5.k()
            r0.label = r4
            java.lang.Object r6 = r7.e(r6, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            r0.label = r3
            java.lang.Object r6 = r5.r(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.p(com.transsion.ad.db.plan.MbAdDbPlans, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.util.List r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$2
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$2 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$2 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$insert$2
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L51
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r7)
            goto L48
        L38:
            kotlin.ResultKt.b(r7)
            li.b r7 = r5.k()
            r0.label = r4
            java.lang.Object r6 = r7.a(r6, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            r0.label = r3
            java.lang.Object r6 = r5.r(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.q(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(boolean r6, java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.transsion.ad.monopoly.manager.AdPlansStorageManager$updateAllValid$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$updateAllValid$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansStorageManager$updateAllValid$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager$updateAllValid$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansStorageManager$updateAllValid$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L51
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r8)
            goto L48
        L38:
            kotlin.ResultKt.b(r8)
            li.b r8 = r5.k()
            r0.label = r4
            java.lang.Object r6 = r8.g(r6, r7, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            r0.label = r3
            java.lang.Object r6 = r5.r(r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.u(boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
