package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.ui.f;
import d0.e;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
final class b extends f.c implements e {

    /* renamed from: n, reason: collision with root package name */
    private Function1 f5004n;

    /* renamed from: o, reason: collision with root package name */
    private Function1 f5005o;

    public b(Function1 function1, Function1 function12) {
        this.f5004n = function1;
        this.f5005o = function12;
    }

    public final void D1(Function1 function1) {
        this.f5004n = function1;
    }

    public final void E1(Function1 function1) {
        this.f5005o = function1;
    }

    @Override // d0.e
    public boolean l0(KeyEvent keyEvent) {
        Function1 function1 = this.f5005o;
        if (function1 != null) {
            return ((Boolean) function1.invoke(d0.b.a(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // d0.e
    public boolean s0(KeyEvent keyEvent) {
        Function1 function1 = this.f5004n;
        if (function1 != null) {
            return ((Boolean) function1.invoke(d0.b.a(keyEvent))).booleanValue();
        }
        return false;
    }
}
