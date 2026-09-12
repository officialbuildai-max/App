package com.transsion.baselib.helper;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final a f43337b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f43338c = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            m c11;
            c11 = m.c();
            return c11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private String f43339a = "";

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a() {
            return (m) m.f43338c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m c() {
        return new m();
    }

    public final void d(String userPrefer) {
        Intrinsics.h(userPrefer, "userPrefer");
        this.f43339a = userPrefer;
    }
}
