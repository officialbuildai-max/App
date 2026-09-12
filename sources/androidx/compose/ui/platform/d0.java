package androidx.compose.ui.platform;

import android.view.View;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f5840a = new d0();

    private d0() {
    }

    public final void a(View view) {
        view.clearViewTranslationCallback();
    }

    public final void b(View view) {
        view.setViewTranslationCallback(a0.a(z.f5962a));
    }
}
