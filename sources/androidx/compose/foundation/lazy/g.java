package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.h0;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
public final class g implements androidx.compose.foundation.lazy.layout.h {

    /* renamed from: a, reason: collision with root package name */
    private final LazyListState f3023a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3024b;

    public g(LazyListState lazyListState, int i11) {
        this.f3023a = lazyListState;
        this.f3024b = i11;
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public void a() {
        h0 A = this.f3023a.A();
        if (A != null) {
            A.d();
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public boolean b() {
        return !this.f3023a.t().h().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public int c() {
        return Math.max(0, this.f3023a.o() - this.f3024b);
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public int d() {
        return Math.min(getItemCount() - 1, ((j) CollectionsKt.u0(this.f3023a.t().h())).getIndex() + this.f3024b);
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public int getItemCount() {
        return this.f3023a.t().d();
    }
}
