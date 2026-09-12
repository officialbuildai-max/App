package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3133a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f3134b = 8;

    /* renamed from: c, reason: collision with root package name */
    private static final long f3135c = o0.q.a(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return k.f3135c;
        }
    }

    public abstract void b(long j11, boolean z10);

    public abstract void c();

    public abstract long d();

    public abstract GraphicsLayer e();

    public abstract long f();

    public abstract long g();

    public abstract long h();

    public abstract boolean i();

    public abstract void j();

    public abstract void k(long j11);

    public abstract void l(long j11);

    public abstract void m(long j11);
}
