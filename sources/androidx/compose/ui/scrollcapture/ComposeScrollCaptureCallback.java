package androidx.compose.ui.scrollcapture;

import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import androidx.compose.ui.graphics.u4;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.function.Consumer;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import o0.r;

/* loaded from: classes.dex */
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {

    /* renamed from: a, reason: collision with root package name */
    private final SemanticsNode f5967a;

    /* renamed from: b, reason: collision with root package name */
    private final r f5968b;

    /* renamed from: c, reason: collision with root package name */
    private final a f5969c;

    /* renamed from: d, reason: collision with root package name */
    private final n0 f5970d;

    /* renamed from: e, reason: collision with root package name */
    private final RelativeScroller f5971e;

    /* renamed from: f, reason: collision with root package name */
    private int f5972f;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, r rVar, n0 n0Var, a aVar) {
        this.f5967a = semanticsNode;
        this.f5968b = rVar;
        this.f5969c = aVar;
        this.f5970d = o0.h(n0Var, e.f5978a);
        this.f5971e = new RelativeScroller(rVar.e(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(android.view.ScrollCaptureSession r9, o0.r r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.e(android.view.ScrollCaptureSession, o0.r, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void onScrollCaptureEnd(Runnable runnable) {
        k.d(this.f5970d, c2.f67768a, null, new ComposeScrollCaptureCallback$onScrollCaptureEnd$1(this, runnable, null), 2, null);
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        ComposeScrollCaptureCallback_androidKt.c(this.f5970d, cancellationSignal, new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1(this, scrollCaptureSession, rect, consumer, null));
    }

    public void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(u4.a(this.f5968b));
    }

    public void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f5971e.d();
        this.f5972f = 0;
        this.f5969c.a();
        runnable.run();
    }
}
