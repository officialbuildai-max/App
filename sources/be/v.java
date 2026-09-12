package be;

import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.hisavana.mediation.config.ConfigContentHelper;

/* loaded from: classes4.dex */
public abstract class v {
    public static void a() {
        com.cloud.sdk.commonutil.util.c.Log().i("TestChecker", "mediation execSQL delete");
        try {
            ConfigContentHelper.g().c();
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().e("TestChecker", "mediation delete db fail = " + e11.getMessage());
        }
    }

    public static void b(boolean z10) {
        int g11 = j7.a.e().g("key_data_status", -1);
        boolean z11 = !z10;
        com.cloud.sdk.commonutil.util.c.Log().i("TestChecker", "mediation sp save env status = " + g11 + " and isDebug = " + z10);
        if (g11 == -1 || g11 == z11) {
            return;
        }
        HSScopeHelper.f23249a.i(new Runnable() { // from class: be.u
            @Override // java.lang.Runnable
            public final void run() {
                v.a();
            }
        });
    }
}
