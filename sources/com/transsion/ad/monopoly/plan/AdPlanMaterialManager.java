package com.transsion.ad.monopoly.plan;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mi.l;

/* loaded from: classes5.dex */
public final class AdPlanMaterialManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AdPlanMaterialManager f42218a = new AdPlanMaterialManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42219b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.plan.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            l e11;
            e11 = AdPlanMaterialManager.e();
            return e11;
        }
    });

    private AdPlanMaterialManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l c() {
        return (l) f42219b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l e() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).A0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.transsion.ad.db.plan.MbAdDbPlans r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$1 r0 = (com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$1 r0 = new com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.b(r8)
            goto L53
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            kotlinx.coroutines.i0 r2 = kotlinx.coroutines.y0.b()
            com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$2 r4 = new com.transsion.ad.monopoly.plan.AdPlanMaterialManager$hasPsOffer$2
            r5 = 0
            r4.<init>(r7, r8, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.i.g(r2, r4, r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            r7 = r8
        L53:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.plan.AdPlanMaterialManager.d(com.transsion.ad.db.plan.MbAdDbPlans, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
