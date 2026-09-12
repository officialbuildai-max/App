package com.transsion.member.promotion;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.transsion.memberapi.SkuPromotionItem;
import com.transsion.memberapi.SkuPromotionPlacementScene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class PromotionManager {

    /* renamed from: b, reason: collision with root package name */
    private static final a f46722b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f46723c = 8;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f46724a = LazyKt.b(new Function0() { // from class: com.transsion.member.promotion.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SkuPromotionRepository E;
            E = PromotionManager.E();
            return E;
        }
    });

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit B(Function1 function1, Function0 function0, FragmentActivity fragmentActivity, SkuPromotionItem skuPromotionItem);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit C(Function1 function1, SkuPromotionItem skuPromotionItem);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit D(Function0 function0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native SkuPromotionRepository E();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void m(SkuPromotionItem skuPromotionItem, String str, String str2, Function2 function2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native Object n(String str, Continuation continuation);

    /* JADX INFO: Access modifiers changed from: private */
    public final native SkuPromotionRepository q();

    private final native boolean r(SkuPromotionItem skuPromotionItem, String str);

    private final native void s(Context context, String str, String str2, Function2 function2, Function2 function22, Function1 function1);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(String str, final Function0 function0, final Function0 function02, final Function0 function03, FragmentActivity activity, SkuPromotionItem promotionItem) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(promotionItem, "promotionItem");
        if (ii.b.f65371a.a(str)) {
            new MemberPromotionDialog().M0(promotionItem).K0(new Function0() { // from class: com.transsion.member.promotion.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit v11;
                    v11 = PromotionManager.v(Function0.this);
                    return v11;
                }
            }).L0(new Function0() { // from class: com.transsion.member.promotion.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit w11;
                    w11 = PromotionManager.w(Function0.this);
                    return w11;
                }
            }).J0(new Function0() { // from class: com.transsion.member.promotion.r
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit x10;
                    x10 = PromotionManager.x(Function0.this);
                    return x10;
                }
            }).k0(activity, "MemberPromotionDialog");
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit v(Function0 function0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit w(Function0 function0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit x(Function0 function0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit z(Function1 function1, FragmentActivity fragmentActivity, SkuPromotionItem skuPromotionItem);

    public final native void A(Context context, Function1 function1, Function0 function0, Function1 function12);

    public final native Object o(Continuation continuation);

    public final native void p();

    public final void t(Context context, final String sceneId, final Function0 function0, final Function0 function02, final Function0 function03, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(sceneId, "sceneId");
        s(context, SkuPromotionPlacementScene.MARKETING_PLACEMENT_SCENE_TYPE_OFFER_POPUP, "dialog", new PromotionManager$showDialog$1(g.f46739a), new Function2() { // from class: com.transsion.member.promotion.o
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit u11;
                u11 = PromotionManager.u(sceneId, function0, function02, function03, (FragmentActivity) obj, (SkuPromotionItem) obj2);
                return u11;
            }
        }, function1);
    }

    public final native void y(Context context, Function1 function1, Function1 function12);
}
