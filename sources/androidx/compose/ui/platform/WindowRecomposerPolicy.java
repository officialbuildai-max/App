package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class WindowRecomposerPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final WindowRecomposerPolicy f5782a = new WindowRecomposerPolicy();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference f5783b = new AtomicReference(y2.f5959a.c());

    /* renamed from: c, reason: collision with root package name */
    public static final int f5784c = 8;

    /* loaded from: classes.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.t1 f5785a;

        a(kotlinx.coroutines.t1 t1Var) {
            this.f5785a = t1Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            t1.a.b(this.f5785a, null, 1, null);
        }
    }

    private WindowRecomposerPolicy() {
    }

    public final Recomposer a(View view) {
        kotlinx.coroutines.t1 d11;
        Recomposer a11 = ((y2) f5783b.get()).a(view);
        WindowRecomposer_androidKt.i(view, a11);
        d11 = kotlinx.coroutines.k.d(kotlinx.coroutines.n1.f68024a, kotlinx.coroutines.android.g.d(view.getHandler(), "windowRecomposer cleanup").q(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(a11, view, null), 2, null);
        view.addOnAttachStateChangeListener(new a(d11));
        return a11;
    }
}
