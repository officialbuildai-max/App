package dk;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.Intrinsics;
import oh.h;

/* loaded from: classes6.dex */
public abstract class a {
    public static final int a(float f11) {
        h hVar = h.f71144a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return hVar.a(a11, f11);
    }

    public static final int b(int i11) {
        h hVar = h.f71144a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return hVar.a(a11, i11);
    }
}
