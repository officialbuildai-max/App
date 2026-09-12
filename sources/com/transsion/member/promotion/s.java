package com.transsion.member.promotion;

import androidx.fragment.app.FragmentActivity;
import com.transsion.memberapi.SkuPromotionItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
public final /* synthetic */ class s implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f46763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f46764b;

    public /* synthetic */ s(Function1 function1, Function0 function0) {
        this.f46763a = function1;
        this.f46764b = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Unit B;
        B = PromotionManager.B(this.f46763a, this.f46764b, (FragmentActivity) obj, (SkuPromotionItem) obj2);
        return B;
    }
}
