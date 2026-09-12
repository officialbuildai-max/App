package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;

/* loaded from: classes.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    private final SemanticsNode f5849a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f5850b;

    public d2(SemanticsNode semanticsNode, Rect rect) {
        this.f5849a = semanticsNode;
        this.f5850b = rect;
    }

    public final Rect a() {
        return this.f5850b;
    }

    public final SemanticsNode b() {
        return this.f5849a;
    }
}
