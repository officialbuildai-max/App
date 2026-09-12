package com.transsion.postdetail.shorttv_pugc.factory;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class j implements st.a {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f49358a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv_pugc.factory.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            yj.c d11;
            d11 = j.d();
            return d11;
        }
    });

    private final yj.c c() {
        return (yj.c) this.f49358a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yj.c d() {
        return (yj.c) yj.a.f79145a.a(yj.c.class);
    }

    @Override // st.a
    public void a(long j11) {
        yj.c c11 = c();
        if (c11 != null) {
            c11.a(j11);
        }
    }
}
