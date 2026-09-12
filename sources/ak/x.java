package ak;

import com.blankj.utilcode.util.Utils;

/* loaded from: classes5.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f733a = new x();

    private x() {
    }

    public final boolean a() {
        return !com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("dark_mode_follow_sys", false) || (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
