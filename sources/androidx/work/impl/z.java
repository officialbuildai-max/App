package androidx.work.impl;

import androidx.work.impl.a0;
import androidx.work.impl.model.s1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class z {
    static {
        a0.a aVar = a0.f15622a;
    }

    public static y a(a0 a0Var, androidx.work.impl.model.j0 spec) {
        Intrinsics.h(spec, "spec");
        return a0Var.d(s1.a(spec));
    }

    public static a0 b() {
        return a0.f15622a.a();
    }

    public static a0 c(boolean z10) {
        return a0.f15622a.b(z10);
    }
}
