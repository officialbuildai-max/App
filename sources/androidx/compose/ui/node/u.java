package androidx.compose.ui.node;

import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.e5;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    private float f5528c;

    /* renamed from: d, reason: collision with root package name */
    private float f5529d;

    /* renamed from: e, reason: collision with root package name */
    private float f5530e;

    /* renamed from: f, reason: collision with root package name */
    private float f5531f;

    /* renamed from: g, reason: collision with root package name */
    private float f5532g;

    /* renamed from: a, reason: collision with root package name */
    private float f5526a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    private float f5527b = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f5533h = 8.0f;

    /* renamed from: i, reason: collision with root package name */
    private long f5534i = e5.f4511a.a();

    public final void a(c4 c4Var) {
        this.f5526a = c4Var.t();
        this.f5527b = c4Var.A();
        this.f5528c = c4Var.x();
        this.f5529d = c4Var.w();
        this.f5530e = c4Var.y();
        this.f5531f = c4Var.m();
        this.f5532g = c4Var.o();
        this.f5533h = c4Var.q();
        this.f5534i = c4Var.b0();
    }

    public final void b(u uVar) {
        this.f5526a = uVar.f5526a;
        this.f5527b = uVar.f5527b;
        this.f5528c = uVar.f5528c;
        this.f5529d = uVar.f5529d;
        this.f5530e = uVar.f5530e;
        this.f5531f = uVar.f5531f;
        this.f5532g = uVar.f5532g;
        this.f5533h = uVar.f5533h;
        this.f5534i = uVar.f5534i;
    }

    public final boolean c(u uVar) {
        return this.f5526a == uVar.f5526a && this.f5527b == uVar.f5527b && this.f5528c == uVar.f5528c && this.f5529d == uVar.f5529d && this.f5530e == uVar.f5530e && this.f5531f == uVar.f5531f && this.f5532g == uVar.f5532g && this.f5533h == uVar.f5533h && e5.c(this.f5534i, uVar.f5534i);
    }
}
