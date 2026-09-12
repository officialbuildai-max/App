package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.w;
import java.util.List;

/* loaded from: classes.dex */
final class a implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2790a = new a();

    private a() {
    }

    @Override // androidx.compose.foundation.gestures.j
    public long a(o0.e eVar, androidx.compose.ui.input.pointer.o oVar, long j11) {
        List b11 = oVar.b();
        y.g d11 = y.g.d(y.g.f78593b.c());
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            d11 = y.g.d(y.g.r(d11.v(), ((w) b11.get(i11)).m()));
        }
        return y.g.s(d11.v(), -eVar.E0(o0.i.g(64)));
    }
}
