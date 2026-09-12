package com.cloud.tmc.miniapp.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public /* synthetic */ class MiniAppActivity$createSuccess$2 extends FunctionReferenceImpl implements Function3<String, String, String, Unit> {
    public MiniAppActivity$createSuccess$2(Object obj) {
        super(3, obj, MiniAppActivity.class, "showOpenAppDialog", "showOpenAppDialog(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, (String) obj3);
        return Unit.f67184a;
    }

    public final void invoke(String p02, String p12, String p22) {
        Intrinsics.h(p02, "p0");
        Intrinsics.h(p12, "p1");
        Intrinsics.h(p22, "p2");
        ((MiniAppActivity) this.receiver).showOpenAppDialog(p02, p12, p22);
    }
}
