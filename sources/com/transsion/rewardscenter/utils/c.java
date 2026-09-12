package com.transsion.rewardscenter.utils;

import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f51352a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Regex f51353b = new Regex("^\\d{7,15}$");

    /* renamed from: c, reason: collision with root package name */
    public static final int f51354c = 8;

    private c() {
    }

    public final Triple a() {
        b bVar = b.f51349a;
        String c11 = bVar.c();
        String d11 = bVar.d();
        String e11 = bVar.e();
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "RewardsCenter", "getPhoneInfo mmkv: " + ((Object) c11) + ", " + ((Object) d11) + ", " + ((Object) e11), false, 4, null);
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        if (iLoginApi != null) {
            if (StringsKt.q0(e11)) {
                UserInfo i11 = iLoginApi.i();
                String phone = i11 != null ? i11.getPhone() : null;
                if (phone == null) {
                    phone = "";
                }
                if (StringsKt.q0(c11)) {
                    String cc2 = i11 != null ? i11.getCc() : null;
                    c11 = cc2 == null ? "" : cc2;
                }
                e11 = phone;
            }
            a.C0856a.f(c0856a, "RewardsCenter", "getPhoneInfo userInfo: " + ((Object) c11) + ", " + ((Object) d11) + ", " + ((Object) e11), false, 4, null);
            if (StringsKt.q0(c11) || StringsKt.q0(d11)) {
                Country e12 = iLoginApi.e();
                a.C0856a.f(c0856a, "RewardsCenter", "getPhoneInfo --> country: " + e12, false, 4, null);
                if (StringsKt.q0(c11)) {
                    c11 = e12 != null ? e12.getCode() : null;
                    if (c11 == null) {
                        c11 = "";
                    }
                }
                if (StringsKt.q0(d11)) {
                    String code = e12 != null ? e12.getCode() : null;
                    if (code == null) {
                        code = "";
                    }
                    if (Intrinsics.c(c11, code)) {
                        String country_s = e12 != null ? e12.getCountry_s() : null;
                        d11 = country_s == null ? "" : country_s;
                    }
                }
            }
            a.C0856a.f(c0856a, "RewardsCenter", "getPhoneInfo result: " + ((Object) c11) + ", " + ((Object) d11) + ", " + ((Object) e11), false, 4, null);
        }
        return new Triple(c11, d11, e11);
    }

    public final boolean b(String number) {
        Intrinsics.h(number, "number");
        return f51353b.matches(number);
    }
}
