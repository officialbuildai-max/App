package com.transsion.usercenter.profile.fragment;

import androidx.view.c0;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final /* synthetic */ class v implements c0, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function1 f57336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Function1 function) {
        Intrinsics.h(function, "function");
        this.f57336a = function;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function a() {
        return this.f57336a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    @Override // androidx.view.c0
    public final /* synthetic */ void onChanged(Object obj) {
        this.f57336a.invoke(obj);
    }
}
