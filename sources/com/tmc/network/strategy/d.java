package com.tmc.network.strategy;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f40872b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f40873a = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return b.f40874a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f40874a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final d f40875b = new d();

        private b() {
        }

        public final d a() {
            return f40875b;
        }
    }

    public final void a(Context context) {
        if (context != null && this.f40873a.compareAndSet(false, true)) {
            gg.b.f63690a.d("StrategyCenter", "StrategyCenter init");
            fg.b.f62513a.g(context);
            LocalDnsStrategy.f40858c.a().h(context);
        }
    }
}
