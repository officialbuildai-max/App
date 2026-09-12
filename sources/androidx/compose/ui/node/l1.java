package androidx.compose.ui.node;

import androidx.compose.ui.f;

/* loaded from: classes.dex */
public final class l1 extends f.c {

    /* renamed from: n, reason: collision with root package name */
    private boolean f5489n;

    public l1() {
        t1(0);
    }

    public final boolean D1() {
        return this.f5489n;
    }

    @Override // androidx.compose.ui.f.c
    public void n1() {
        this.f5489n = true;
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        this.f5489n = false;
    }

    public String toString() {
        return "<tail>";
    }
}
