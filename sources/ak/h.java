package ak;

import android.app.Application;
import com.aliyun.player.BuildConfig;
import com.blankj.utilcode.util.Utils;
import com.transsion.mb.config.manager.ConfigBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f716a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f717b;

    private h() {
    }

    public final boolean a() {
        String str;
        Boolean bool = f717b;
        if (bool != null) {
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        try {
            ih.b bVar = ih.b.f65364a;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            long j11 = bVar.k(a11).totalMem;
            ConfigBean c11 = sm.f.f75530c.a().c("lowMemoryValue", true);
            if (c11 == null || (str = c11.getValue()) == null) {
                str = BuildConfig.VERSION_NAME;
            }
            if (j11 <= 1073741824 * Double.parseDouble(str)) {
                f717b = Boolean.TRUE;
            }
            Boolean bool2 = f717b;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
