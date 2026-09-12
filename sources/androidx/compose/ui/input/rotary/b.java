package androidx.compose.ui.input.rotary;

import androidx.compose.ui.f;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
final class b extends f.c implements f0.a {

    /* renamed from: n, reason: collision with root package name */
    private Function1 f5165n;

    /* renamed from: o, reason: collision with root package name */
    private Function1 f5166o;

    public b(Function1 function1, Function1 function12) {
        this.f5165n = function1;
        this.f5166o = function12;
    }

    public final void D1(Function1 function1) {
        this.f5165n = function1;
    }

    public final void E1(Function1 function1) {
        this.f5166o = function1;
    }

    @Override // f0.a
    public boolean J0(f0.b bVar) {
        Function1 function1 = this.f5166o;
        if (function1 != null) {
            return ((Boolean) function1.invoke(bVar)).booleanValue();
        }
        return false;
    }

    @Override // f0.a
    public boolean X0(f0.b bVar) {
        Function1 function1 = this.f5165n;
        if (function1 != null) {
            return ((Boolean) function1.invoke(bVar)).booleanValue();
        }
        return false;
    }
}
