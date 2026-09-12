package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.v;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final v f3281a = new e(v.f6352a.a(), 0, 0);

    public static final v b() {
        return f3281a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i11, int i12, int i13) {
        if (i11 < 0 || i11 > i12) {
            throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i13 + " -> " + i11 + " is not in range of transformed text [0, " + i12 + ']').toString());
        }
    }
}
