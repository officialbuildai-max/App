package yy;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsnet.loginapi.bean.Country;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79217a = new a();

    private a() {
    }

    public final Country a(Context context, String phone) {
        Intrinsics.h(context, "context");
        Intrinsics.h(phone, "phone");
        ArrayList a11 = b.b().a(context);
        if (a11 != null && !a11.isEmpty()) {
            Iterator it = a11.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.g(next, "next(...)");
                Country country = (Country) next;
                String code = country.getCode();
                String substring = phone.substring(1, (code != null ? code.length() : 0) + 1);
                Intrinsics.g(substring, "substring(...)");
                if (TextUtils.equals(substring, country.getCode())) {
                    return country;
                }
            }
        }
        return null;
    }

    public final Country b() {
        Application a11 = Utils.a();
        ArrayList a12 = b.b().a(a11);
        Object systemService = a11.getSystemService("phone");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String simCountryIso = ((TelephonyManager) systemService).getSimCountryIso();
        Intrinsics.g(simCountryIso, "getSimCountryIso(...)");
        String upperCase = simCountryIso.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        Object obj = null;
        if (a12 == null) {
            return null;
        }
        Iterator it = a12.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.c(((Country) next).getCountry_s(), upperCase)) {
                obj = next;
                break;
            }
        }
        return (Country) obj;
    }
}
