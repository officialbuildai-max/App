package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.a0;
import androidx.compose.foundation.lazy.layout.z;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public static final class a implements z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LazyListState f3020a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3021b;

        a(LazyListState lazyListState, boolean z10) {
            this.f3020a = lazyListState;
            this.f3021b = z10;
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public int a() {
            return this.f3020a.t().e() + this.f3020a.t().b();
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public float b() {
            return a0.a(this.f3020a.o(), this.f3020a.p(), this.f3020a.d());
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public Object c(int i11, Continuation continuation) {
            Object H = LazyListState.H(this.f3020a, i11, 0, continuation, 2, null);
            return H == IntrinsicsKt.f() ? H : Unit.f67184a;
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public androidx.compose.ui.semantics.b d() {
            return this.f3021b ? new androidx.compose.ui.semantics.b(-1, 1) : new androidx.compose.ui.semantics.b(1, -1);
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public int e() {
            return this.f3020a.t().getOrientation() == Orientation.Vertical ? o0.t.f(this.f3020a.t().a()) : o0.t.g(this.f3020a.t().a());
        }

        @Override // androidx.compose.foundation.lazy.layout.z
        public float f() {
            return a0.b(this.f3020a.o(), this.f3020a.p());
        }
    }

    public static final z a(LazyListState lazyListState, boolean z10) {
        return new a(lazyListState, z10);
    }
}
