package ds;

import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv.utils.h;

/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f61554a = new g();

    private g() {
    }

    public final boolean a() {
        return !h.f53707a.e().getBoolean("dark_mode_follow_sys", false) || (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
