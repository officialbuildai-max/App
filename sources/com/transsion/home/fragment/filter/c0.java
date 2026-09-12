package com.transsion.home.fragment.filter;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final /* synthetic */ class c0 implements androidx.view.c0, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function1 f45076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Function1 function) {
        Intrinsics.h(function, "function");
        this.f45076a = function;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function a() {
        return this.f45076a;
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
        this.f45076a.invoke(obj);
    }
}
