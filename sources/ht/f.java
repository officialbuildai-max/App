package ht;

import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv_pugc.utils.h;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f64964a = new f();

    private f() {
    }

    public final boolean a() {
        return !h.f54499a.g().getBoolean("dark_mode_follow_sys", false) || (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
    }
}
