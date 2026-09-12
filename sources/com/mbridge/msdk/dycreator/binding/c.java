package com.mbridge.msdk.dycreator.binding;

import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.dycreator.binding.base.BaseStrategy;
import com.mbridge.msdk.dycreator.binding.strategy.d;
import com.mbridge.msdk.dycreator.binding.strategy.e;
import com.mbridge.msdk.dycreator.binding.strategy.f;
import com.mbridge.msdk.dycreator.binding.strategy.g;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f34814a;

    private c() {
    }

    public static c a() {
        if (f34814a == null) {
            synchronized (c.class) {
                try {
                    if (f34814a == null) {
                        f34814a = new c();
                    }
                } finally {
                }
            }
        }
        return f34814a;
    }

    public <T extends BaseStrategy> T a(String str) {
        T t11 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("close")) {
            t11 = new com.mbridge.msdk.dycreator.binding.strategy.c();
        } else if (str.equals("download")) {
            t11 = new com.mbridge.msdk.dycreator.binding.strategy.b();
        } else if (!str.equals("deeplink") && str.equals("activity")) {
            t11 = new com.mbridge.msdk.dycreator.binding.strategy.a();
        }
        if (str.equals(TmcConstants.MENU_KEY_FEEDBACK)) {
            t11 = new d();
        }
        if (str.equals("notice")) {
            t11 = new e();
        }
        if (str.equals("permissionInfo")) {
            t11 = new f();
        }
        return str.equals("privateAddress") ? new g() : t11;
    }
}
