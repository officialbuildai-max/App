package com.transsion.moviedetail.preload;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class g extends qm.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f47343a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f47344b = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.preload.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g d11;
            d11 = g.d();
            return d11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return (g) g.f47344b.getValue();
        }
    }

    public g() {
        qm.e.f73767a.e(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g d() {
        return new g();
    }
}
