package androidx.compose.ui.graphics.layer;

import android.graphics.Outline;
import androidx.compose.ui.graphics.Path;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f4672a = new l0();

    private l0() {
    }

    public final void a(Outline outline, Path path) {
        if (!(path instanceof androidx.compose.ui.graphics.u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        outline.setPath(((androidx.compose.ui.graphics.u0) path).p());
    }
}
