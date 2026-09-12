package com.transsion.publish;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final a f50509b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f50510c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.publish.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            n b11;
            b11 = n.b();
            return b11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private List f50511a = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a() {
            return (n) n.f50510c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n b() {
        return new n();
    }

    public final void d() {
        List list = this.f50511a;
        if (list != null) {
            list.clear();
        }
    }

    public final List e() {
        return this.f50511a;
    }

    public final void f(List list) {
        Intrinsics.h(list, "list");
        this.f50511a = list;
    }
}
