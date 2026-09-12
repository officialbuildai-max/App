package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.b;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public abstract class j {

    /* loaded from: classes.dex */
    public interface a {
        Function1 getKey();

        Function1 getType();
    }

    public final Object b(int i11) {
        b.a aVar = c().get(i11);
        return ((a) aVar.c()).getType().invoke(Integer.valueOf(i11 - aVar.b()));
    }

    public abstract b c();

    public final int d() {
        return c().getSize();
    }

    public final Object e(int i11) {
        Object invoke;
        b.a aVar = c().get(i11);
        int b11 = i11 - aVar.b();
        Function1 key = ((a) aVar.c()).getKey();
        return (key == null || (invoke = key.invoke(Integer.valueOf(b11))) == null) ? b0.a(i11) : invoke;
    }
}
