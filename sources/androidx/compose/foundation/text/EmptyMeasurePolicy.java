package androidx.compose.foundation.text;

import androidx.compose.ui.layout.g0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.v;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.x;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
final class EmptyMeasurePolicy implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyMeasurePolicy f3267a = new EmptyMeasurePolicy();

    /* renamed from: b, reason: collision with root package name */
    private static final Function1 f3268b = new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.text.EmptyMeasurePolicy$placementBlock$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((g0.a) obj);
            return Unit.f67184a;
        }

        public final void invoke(g0.a aVar) {
        }
    };

    private EmptyMeasurePolicy() {
    }

    @Override // androidx.compose.ui.layout.t
    public v c(x xVar, List list, long j11) {
        return w.b(xVar, o0.b.l(j11), o0.b.k(j11), null, f3268b, 4, null);
    }
}
