package com.transsion.postdetail.ui.fragment;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final /* synthetic */ class o implements androidx.view.c0, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function1 f49821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Function1 function) {
        Intrinsics.h(function, "function");
        this.f49821a = function;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function a() {
        return this.f49821a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    @Override // androidx.view.c0
    public final /* synthetic */ void onChanged(Object obj) {
        this.f49821a.invoke(obj);
    }
}
