package com.transsion.member.promotion;

import com.transsion.memberapi.SkuPromotionItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final /* synthetic */ class u implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f46766a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SkuPromotionItem f46767b;

    public /* synthetic */ u(Function1 function1, SkuPromotionItem skuPromotionItem) {
        this.f46766a = function1;
        this.f46767b = skuPromotionItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit C;
        C = PromotionManager.C(this.f46766a, this.f46767b);
        return C;
    }
}
