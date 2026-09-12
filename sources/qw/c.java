package qw;

import android.text.TextUtils;
import bh.a;
import com.tencent.mmkv.MMKV;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import ti.p;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f74005a = new c();

    private c() {
    }

    public final String a() {
        MMKV c11 = bh.a.f16551a.c();
        if (c11 != null) {
            return c11.getString("key_user_agent", "");
        }
        return null;
    }

    public final void b() {
        try {
            Result.Companion companion = Result.INSTANCE;
            a.C0156a c0156a = bh.a.f16551a;
            MMKV c11 = c0156a.c();
            Object obj = null;
            String string = c11 != null ? c11.getString("key_custom_date", "") : null;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (Intrinsics.c(p.f76389a.c(), string)) {
                a.C0856a.g(lg.a.f68962a, "AdDeveloperUtil --> 特殊权限已授予", false, 2, null);
                obj = Unit.f67184a;
            } else {
                a.C0856a.g(lg.a.f68962a, "AdDeveloperUtil --> 特殊权限授权已过期", false, 2, null);
                MMKV c12 = c0156a.c();
                if (c12 != null) {
                    c12.putString("sp_code", "");
                }
                MMKV c13 = c0156a.c();
                if (c13 != null) {
                    c13.putString("custom_local_iso", "");
                }
                MMKV c14 = c0156a.c();
                if (c14 != null) {
                    c14.putString("custom_local_country", "");
                }
                MMKV c15 = c0156a.c();
                if (c15 != null) {
                    obj = c15.putString("custom_country_code", "");
                }
            }
            Result.m1185constructorimpl(obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void c(String customDate) {
        Intrinsics.h(customDate, "customDate");
        MMKV c11 = bh.a.f16551a.c();
        if (c11 != null) {
            c11.putString("key_custom_date", customDate);
        }
    }

    public final void d(String str) {
        MMKV c11 = bh.a.f16551a.c();
        if (c11 != null) {
            c11.putString("key_user_agent", str);
        }
    }
}
