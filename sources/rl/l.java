package rl;

import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.home.bean.LayoutStyle;

/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f74688a = new l();

    private l() {
    }

    public final k a(int i11, LayoutStyle layoutStyle, String str) {
        int a11 = a0.a(((i11 - 1) * 8.0f) + 24.0f);
        int e11 = (y.e() - a11) / i11;
        return new k(e11, (int) (e11 * ((a0.a(92.0f) * 1.0f) / a0.a(164.0f))));
    }
}
