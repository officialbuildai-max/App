package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m1;

/* loaded from: classes.dex */
final class l0 extends f.c implements m1 {

    /* renamed from: n, reason: collision with root package name */
    private x f3137n;

    /* renamed from: o, reason: collision with root package name */
    private final String f3138o = "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";

    public l0(x xVar) {
        this.f3137n = xVar;
    }

    public final x D1() {
        return this.f3137n;
    }

    @Override // androidx.compose.ui.node.m1
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public String D() {
        return this.f3138o;
    }

    public final void F1(x xVar) {
        this.f3137n = xVar;
    }
}
