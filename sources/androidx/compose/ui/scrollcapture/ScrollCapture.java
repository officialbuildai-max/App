package androidx.compose.ui.scrollcapture;

import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.u4;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.semantics.m;
import java.util.function.Consumer;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.o0;
import o0.p;
import o0.s;

/* loaded from: classes.dex */
public final class ScrollCapture implements ComposeScrollCaptureCallback.a {

    /* renamed from: a, reason: collision with root package name */
    private final i1 f5976a;

    public ScrollCapture() {
        i1 c11;
        c11 = u2.c(Boolean.FALSE, null, 2, null);
        this.f5976a = c11;
    }

    private final void e(boolean z10) {
        this.f5976a.setValue(Boolean.valueOf(z10));
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.a
    public void a() {
        e(true);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.a
    public void b() {
        e(false);
    }

    public final boolean c() {
        return ((Boolean) this.f5976a.getValue()).booleanValue();
    }

    public final void d(View view, m mVar, CoroutineContext coroutineContext, Consumer<ScrollCaptureTarget> consumer) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new i[16], 0);
        j.f(mVar.a(), 0, new ScrollCapture$onScrollCaptureSearch$1(bVar), 2, null);
        bVar.A(ComparisonsKt.b(new Function1<i, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(i iVar) {
                return Integer.valueOf(iVar.b());
            }
        }, new Function1<i, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(i iVar) {
                return Integer.valueOf(iVar.d().e());
            }
        }));
        i iVar = (i) (bVar.p() ? null : bVar.m()[bVar.n() - 1]);
        if (iVar == null) {
            return;
        }
        ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback(iVar.c(), iVar.d(), o0.a(coroutineContext), this);
        y.i b11 = androidx.compose.ui.layout.m.b(iVar.a());
        long i11 = iVar.d().i();
        ScrollCaptureTarget a11 = h.a(view, u4.a(s.b(b11)), new Point(p.h(i11), p.i(i11)), f.a(composeScrollCaptureCallback));
        a11.setScrollBounds(u4.a(iVar.d()));
        consumer.accept(a11);
    }
}
