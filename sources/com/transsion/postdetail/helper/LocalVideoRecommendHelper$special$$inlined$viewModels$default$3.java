package com.transsion.postdetail.helper;

import androidx.fragment.app.Fragment;
import androidx.view.m;
import androidx.view.v0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/t0;", "VM", "Landroidx/lifecycle/v0$c;", "<anonymous>", "()Landroidx/lifecycle/v0$c;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$3"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes6.dex */
public final class LocalVideoRecommendHelper$special$$inlined$viewModels$default$3 extends Lambda implements Function0<v0.c> {
    final /* synthetic */ Function0 $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoRecommendHelper$special$$inlined$viewModels$default$3(Function0 function0, Fragment fragment) {
        super(0);
        this.$ownerProducer = function0;
        this.$this_viewModels = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final v0.c invoke() {
        Object invoke = this.$ownerProducer.invoke();
        m mVar = invoke instanceof m ? (m) invoke : null;
        v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
        if (defaultViewModelProviderFactory == null) {
            defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
        Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
