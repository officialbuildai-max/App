package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public static final i1 f4526a = new i1();

    private i1() {
    }

    public final BlendModeColorFilter a(long j11, int i11) {
        f1.a();
        return e1.a(w1.j(j11), f0.a(i11));
    }

    public final d1 b(BlendModeColorFilter blendModeColorFilter) {
        int color;
        BlendMode mode;
        color = blendModeColorFilter.getColor();
        long b11 = w1.b(color);
        mode = blendModeColorFilter.getMode();
        return new d1(b11, f0.b(mode), blendModeColorFilter, null);
    }
}
