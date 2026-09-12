package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final a3 f6408a;

    /* renamed from: b, reason: collision with root package name */
    private final q f6409b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6410c;

    public q(a3 a3Var, q qVar) {
        this.f6408a = a3Var;
        this.f6409b = qVar;
        this.f6410c = a3Var.getValue();
    }

    public final Typeface a() {
        Object obj = this.f6410c;
        Intrinsics.f(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    public final boolean b() {
        q qVar;
        return this.f6408a.getValue() != this.f6410c || ((qVar = this.f6409b) != null && qVar.b());
    }
}
