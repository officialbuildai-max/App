package com.transsion.shorttv.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import ms.e0;

/* loaded from: classes6.dex */
public final class b extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private final e0 f53174a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        Intrinsics.h(view, "view");
        e0 a11 = e0.a(view);
        Intrinsics.g(a11, "bind(...)");
        this.f53174a = a11;
    }

    public final e0 f() {
        return this.f53174a;
    }
}
