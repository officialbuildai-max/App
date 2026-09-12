package com.transsion.shorttv.ui.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ms.t;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
/* synthetic */ class ShortTvLanguageSelectDialog$bindingInflater$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, t> {
    public static final ShortTvLanguageSelectDialog$bindingInflater$1 INSTANCE = new ShortTvLanguageSelectDialog$bindingInflater$1();

    ShortTvLanguageSelectDialog$bindingInflater$1() {
        super(3, t.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/shorttv/databinding/ShortTvDialogLanguageListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }

    public final t invoke(LayoutInflater p02, ViewGroup viewGroup, boolean z10) {
        Intrinsics.h(p02, "p0");
        return t.c(p02, viewGroup, z10);
    }
}
