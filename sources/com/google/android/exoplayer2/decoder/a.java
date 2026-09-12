package com.google.android.exoplayer2.decoder;

import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private int f24916a;

    public final void a(int i11) {
        this.f24916a = i11 | this.f24916a;
    }

    public void b() {
        this.f24916a = 0;
    }

    public final void d(int i11) {
        this.f24916a = (~i11) & this.f24916a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e(int i11) {
        return (this.f24916a & i11) == i11;
    }

    public final boolean f() {
        return e(ASTNode.DEOP);
    }

    public final boolean g() {
        return e(Integer.MIN_VALUE);
    }

    public final boolean h() {
        return e(4);
    }

    public final boolean i() {
        return e(ASTNode.NOJIT);
    }

    public final boolean j() {
        return e(1);
    }

    public final void k(int i11) {
        this.f24916a = i11;
    }
}
