package com.cloud.hisavana.sdk.common.util;

import android.util.Log;
import com.cloud.hisavana.abtestkit.ABTestKit;
import com.cloud.hisavana.sdk.c2;
import com.cloud.hisavana.sdk.c6;
import com.cloud.hisavana.sdk.database.HSRoomDatabase;
import com.cloud.hisavana.sdk.f5;
import com.cloud.hisavana.sdk.m1;
import com.cloud.hisavana.sdk.v0;
import com.cloud.hisavana.sdk.v3;
import com.cloud.sdk.commonutil.util.HSScopeHelper;

/* loaded from: classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final k0 f22243a = new k0();

    /* renamed from: b, reason: collision with root package name */
    private static HSRoomDatabase f22244b;

    private k0() {
    }

    public static final void b(boolean z10) {
        int g11 = j7.a.e().g("key_data_status", -1);
        final int i11 = !z10 ? 1 : 0;
        com.cloud.sdk.commonutil.util.c.Log().i("TestChecker", "sp save env status = " + g11 + " and isDebug = " + z10);
        if (g11 == -1) {
            j7.a.e().p("key_data_status", i11);
        } else if (g11 != i11) {
            HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.common.util.j0
                @Override // java.lang.Runnable
                public final void run() {
                    k0.c(i11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i11) {
        f22243a.d();
        j7.a.e().p("key_data_status", i11);
    }

    private final void d() {
        try {
            j7.a.e().b();
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().e("TestChecker", "delete sp fail = " + e11.getMessage());
        }
        e();
    }

    private final void e() {
        f5 k02;
        c6 n02;
        m1 x02;
        c2 t02;
        v3 h02;
        v0 p02;
        com.cloud.sdk.commonutil.util.c.Log().i("TestChecker", "execSQL delete");
        try {
            f();
            HSRoomDatabase hSRoomDatabase = f22244b;
            if (hSRoomDatabase != null && (p02 = hSRoomDatabase.p0()) != null) {
                p02.a();
            }
            HSRoomDatabase hSRoomDatabase2 = f22244b;
            if (hSRoomDatabase2 != null && (h02 = hSRoomDatabase2.h0()) != null) {
                h02.a();
            }
            HSRoomDatabase hSRoomDatabase3 = f22244b;
            if (hSRoomDatabase3 != null && (t02 = hSRoomDatabase3.t0()) != null) {
                t02.b();
            }
            HSRoomDatabase hSRoomDatabase4 = f22244b;
            if (hSRoomDatabase4 != null && (x02 = hSRoomDatabase4.x0()) != null) {
                x02.b();
            }
            HSRoomDatabase hSRoomDatabase5 = f22244b;
            if (hSRoomDatabase5 != null && (n02 = hSRoomDatabase5.n0()) != null) {
                n02.a();
            }
            HSRoomDatabase hSRoomDatabase6 = f22244b;
            if (hSRoomDatabase6 != null && (k02 = hSRoomDatabase6.k0()) != null) {
                k02.a();
            }
            ABTestKit.deleteTable();
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().e("TestChecker", "delete db fail = " + e11.getMessage());
        }
    }

    public final synchronized void f() {
        HSRoomDatabase hSRoomDatabase = f22244b;
        if (hSRoomDatabase == null || !hSRoomDatabase.S()) {
            try {
                f22244b = HSRoomDatabase.v0();
            } catch (Exception e11) {
                com.cloud.sdk.commonutil.util.c.Log().e("TestChecker", "openDB ex " + Log.getStackTraceString(e11));
            }
        }
    }
}
