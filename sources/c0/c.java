package c0;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f17053a;

    /* renamed from: b, reason: collision with root package name */
    private final i1 f17054b;

    private c(int i11, Function1 function1) {
        i1 c11;
        this.f17053a = function1;
        c11 = u2.c(a.c(i11), null, 2, null);
        this.f17054b = c11;
    }

    public /* synthetic */ c(int i11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, function1);
    }

    @Override // c0.b
    public int a() {
        return ((a) this.f17054b.getValue()).i();
    }

    public void b(int i11) {
        this.f17054b.setValue(a.c(i11));
    }
}
