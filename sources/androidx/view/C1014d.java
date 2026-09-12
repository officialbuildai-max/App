package androidx.view;

import android.os.Bundle;
import androidx.view.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.savedstate.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1014d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f14916d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC1015e f14917a;

    /* renamed from: b, reason: collision with root package name */
    private final C1013c f14918b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14919c;

    /* renamed from: androidx.savedstate.d$a */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final C1014d a(InterfaceC1015e owner) {
            Intrinsics.h(owner, "owner");
            return new C1014d(owner, null);
        }
    }

    private C1014d(InterfaceC1015e interfaceC1015e) {
        this.f14917a = interfaceC1015e;
        this.f14918b = new C1013c();
    }

    public /* synthetic */ C1014d(InterfaceC1015e interfaceC1015e, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC1015e);
    }

    public static final C1014d a(InterfaceC1015e interfaceC1015e) {
        return f14916d.a(interfaceC1015e);
    }

    public final C1013c b() {
        return this.f14918b;
    }

    public final void c() {
        Lifecycle lifecycle = this.f14917a.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new C1011a(this.f14917a));
        this.f14918b.e(lifecycle);
        this.f14919c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f14919c) {
            c();
        }
        Lifecycle lifecycle = this.f14917a.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f14918b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        Intrinsics.h(outBundle, "outBundle");
        this.f14918b.g(outBundle);
    }
}
