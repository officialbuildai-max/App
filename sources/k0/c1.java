package k0;

import android.text.Layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final c1 f66621a = new c1();

    /* renamed from: b, reason: collision with root package name */
    private static final Layout.Alignment f66622b;

    /* renamed from: c, reason: collision with root package name */
    private static final Layout.Alignment f66623c;

    static {
        Layout.Alignment[] values = Layout.Alignment.values();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        Layout.Alignment alignment2 = alignment;
        for (Layout.Alignment alignment3 : values) {
            if (Intrinsics.c(alignment3.name(), "ALIGN_LEFT")) {
                alignment = alignment3;
            } else if (Intrinsics.c(alignment3.name(), "ALIGN_RIGHT")) {
                alignment2 = alignment3;
            }
        }
        f66622b = alignment;
        f66623c = alignment2;
    }

    private c1() {
    }

    public final Layout.Alignment a(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? Layout.Alignment.ALIGN_NORMAL : f66623c : f66622b : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
    }
}
