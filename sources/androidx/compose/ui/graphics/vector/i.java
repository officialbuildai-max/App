package androidx.compose.ui.graphics.vector;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private Function1 f4917a;

    private i() {
    }

    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void a(z.g gVar);

    public Function1 b() {
        return this.f4917a;
    }

    public final void c() {
        Function1 b11 = b();
        if (b11 != null) {
            b11.invoke(this);
        }
    }

    public void d(Function1 function1) {
        this.f4917a = function1;
    }
}
