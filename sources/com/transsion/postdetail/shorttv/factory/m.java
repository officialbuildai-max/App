package com.transsion.postdetail.shorttv.factory;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class m implements qs.a {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f49272a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.factory.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            yj.c e11;
            e11 = m.e();
            return e11;
        }
    });

    private final yj.c d() {
        return (yj.c) this.f49272a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yj.c e() {
        return (yj.c) yj.a.f79145a.a(yj.c.class);
    }

    @Override // qs.a
    public void a(long j11) {
        yj.c d11 = d();
        if (d11 != null) {
            d11.a(j11);
        }
    }

    @Override // qs.a
    public void b(long j11) {
        yj.c d11 = d();
        if (d11 != null) {
            d11.b(j11);
        }
    }
}
