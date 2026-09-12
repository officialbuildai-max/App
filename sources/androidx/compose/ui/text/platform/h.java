package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
final class h extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.text.f f6398a;

    public h(androidx.compose.ui.text.f fVar) {
        this.f6398a = fVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f6398a.a();
    }
}
