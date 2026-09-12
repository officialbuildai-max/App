package com.transsion.member.dialog;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final /* synthetic */ class i implements androidx.view.c0, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Function1 f46590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Function1 function) {
        Intrinsics.h(function, "function");
        this.f46590a = function;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function a() {
        return this.f46590a;
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
        this.f46590a.invoke(obj);
    }
}
