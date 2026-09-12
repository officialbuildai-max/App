package androidx.compose.ui.platform;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class w2 implements v2 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5948b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final androidx.compose.runtime.i1 f5949c;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.i1 f5950a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        androidx.compose.runtime.i1 c11;
        c11 = androidx.compose.runtime.u2.c(androidx.compose.ui.input.pointer.g0.a(androidx.compose.ui.input.pointer.r.a()), null, 2, null);
        f5949c = c11;
    }

    public w2() {
        androidx.compose.runtime.i1 c11;
        c11 = androidx.compose.runtime.u2.c(Boolean.FALSE, null, 2, null);
        this.f5950a = c11;
    }

    public void a(int i11) {
        f5949c.setValue(androidx.compose.ui.input.pointer.g0.a(i11));
    }

    public void b(boolean z10) {
        this.f5950a.setValue(Boolean.valueOf(z10));
    }
}
