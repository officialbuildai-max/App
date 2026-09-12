package com.transsion.mpush.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.mpush.core.fcm.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f47663a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f47664b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f47665c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f47666a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47667b;

        public a(String seed, int i11) {
            Intrinsics.h(seed, "seed");
            this.f47666a = seed;
            this.f47667b = i11;
        }

        public final int a() {
            return this.f47667b;
        }

        public final String b() {
            return this.f47666a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f47666a, aVar.f47666a) && this.f47667b == aVar.f47667b;
        }

        public int hashCode() {
            return (this.f47666a.hashCode() * 31) + this.f47667b;
        }

        public String toString() {
            return "CachedSeed(seed=" + this.f47666a + ", priority=" + this.f47667b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.transsion.mpush.core.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0636b {

        /* renamed from: a, reason: collision with root package name */
        private final String f47668a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47669b;

        public C0636b(String raw, int i11) {
            Intrinsics.h(raw, "raw");
            this.f47668a = raw;
            this.f47669b = i11;
        }

        public final int a() {
            return this.f47669b;
        }

        public final String b() {
            return this.f47668a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0636b)) {
                return false;
            }
            C0636b c0636b = (C0636b) obj;
            return Intrinsics.c(this.f47668a, c0636b.f47668a) && this.f47669b == c0636b.f47669b;
        }

        public int hashCode() {
            return (this.f47668a.hashCode() * 31) + this.f47669b;
        }

        public String toString() {
            return "DeviceCandidate(raw=" + this.f47668a + ", priority=" + this.f47669b + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f47670a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47671b;

        /* renamed from: c, reason: collision with root package name */
        private final int f47672c;

        /* renamed from: d, reason: collision with root package name */
        private final int f47673d;

        /* renamed from: e, reason: collision with root package name */
        private final int f47674e;

        public c(int i11, int i12, int i13, int i14, int i15) {
            this.f47670a = i11;
            this.f47671b = i12;
            this.f47672c = i13;
            this.f47673d = i14;
            this.f47674e = i15;
        }

        public final int a() {
            return this.f47671b;
        }

        public final int b() {
            return this.f47673d;
        }

        public final int c() {
            return this.f47670a;
        }

        public final int d() {
            return this.f47672c;
        }

        public final boolean e() {
            return this.f47670a >= this.f47673d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f47670a == cVar.f47670a && this.f47671b == cVar.f47671b && this.f47672c == cVar.f47672c && this.f47673d == cVar.f47673d && this.f47674e == cVar.f47674e;
        }

        public final int f() {
            return this.f47674e;
        }

        public int hashCode() {
            return (((((((this.f47670a * 31) + this.f47671b) * 31) + this.f47672c) * 31) + this.f47673d) * 31) + this.f47674e;
        }

        public String toString() {
            return "RequestWindow(nowMinutes=" + this.f47670a + ", baseStartMinutes=" + this.f47671b + ", offsetMinutes=" + this.f47672c + ", hashedStartMinutes=" + this.f47673d + ", seedPriority=" + this.f47674e + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final int f47675a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47676b;

        /* renamed from: c, reason: collision with root package name */
        private final int f47677c;

        /* renamed from: d, reason: collision with root package name */
        private final int f47678d;

        public d(int i11, int i12, int i13, int i14) {
            this.f47675a = i11;
            this.f47676b = i12;
            this.f47677c = i13;
            this.f47678d = i14;
        }

        public final int a() {
            return this.f47677c;
        }

        public final int b() {
            return this.f47675a;
        }

        public final int c() {
            return this.f47676b;
        }

        public final boolean d() {
            return this.f47675a >= this.f47677c;
        }

        public final int e() {
            return this.f47678d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f47675a == dVar.f47675a && this.f47676b == dVar.f47676b && this.f47677c == dVar.f47677c && this.f47678d == dVar.f47678d;
        }

        public int hashCode() {
            return (((((this.f47675a * 31) + this.f47676b) * 31) + this.f47677c) * 31) + this.f47678d;
        }

        public String toString() {
            return "SecondRequestWindow(nowSeconds=" + this.f47675a + ", offsetSeconds=" + this.f47676b + ", hashedStartSeconds=" + this.f47677c + ", seedPriority=" + this.f47678d + ")";
        }
    }

    private b() {
    }

    private final String a() {
        String str = Build.FINGERPRINT;
        if (str == null) {
            str = "";
        }
        String obj = StringsKt.n1(str).toString();
        if (!StringsKt.q0(obj) && !StringsKt.H(obj, TmcConstants.ROUTE_UNKNOWN, true)) {
            return obj;
        }
        List<String> o11 = CollectionsKt.o(Build.BRAND, Build.MANUFACTURER, Build.MODEL, Build.DEVICE, Build.PRODUCT, Build.HARDWARE, Build.BOARD);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(o11, 10));
        for (String str2 : o11) {
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(StringsKt.n1(str2).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            String str3 = (String) obj2;
            if (!StringsKt.q0(str3) && !StringsKt.H(str3, TmcConstants.ROUTE_UNKNOWN, true)) {
                arrayList2.add(obj2);
            }
        }
        return CollectionsKt.s0(arrayList2, "|", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ c c(b bVar, Context context, String str, int i11, int i12, int i13, Calendar calendar, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i11 = 480;
        }
        int i15 = i11;
        if ((i14 & 8) != 0) {
            i12 = 60;
        }
        int i16 = i12;
        if ((i14 & 16) != 0) {
            i13 = 30;
        }
        int i17 = i13;
        if ((i14 & 32) != 0) {
            calendar = Calendar.getInstance();
        }
        return bVar.b(context, str, i15, i16, i17, calendar);
    }

    private final int e(Calendar calendar) {
        return (calendar.get(11) * 3600) + (calendar.get(12) * 60) + calendar.get(13);
    }

    private final Pair h(Context context, int i11) {
        if (i11 <= 1) {
            return new Pair(0, 0);
        }
        Pair k11 = k(context);
        String str = (String) k11.component1();
        int intValue = ((Number) k11.component2()).intValue();
        double l11 = l(str);
        int v11 = v(l11, i11);
        a.C0856a c0856a = lg.a.f68962a;
        String u11 = u(intValue);
        String format = String.format("%.6f", Arrays.copyOf(new Object[]{Double.valueOf(l11)}, 1));
        Intrinsics.g(format, "format(...)");
        a.C0856a.r(c0856a, "PUSH_HASH", new String[]{"【时间散列】分钟偏移=" + v11 + "/" + i11 + ", seed来源=" + u11 + ", hash=" + format}, false, 4, null);
        return new Pair(Integer.valueOf(v11), Integer.valueOf(intValue));
    }

    private final Pair i(Context context, int i11) {
        if (i11 <= 1) {
            return new Pair(0, 0);
        }
        Pair k11 = k(context);
        String str = (String) k11.component1();
        int intValue = ((Number) k11.component2()).intValue();
        double l11 = l(str);
        int v11 = v(l11, i11);
        a.C0856a c0856a = lg.a.f68962a;
        String u11 = u(intValue);
        String format = String.format("%.6f", Arrays.copyOf(new Object[]{Double.valueOf(l11)}, 1));
        Intrinsics.g(format, "format(...)");
        a.C0856a.r(c0856a, "PUSH_HASH", new String[]{"【时间散列】秒偏移=" + v11 + "/" + i11 + ", seed来源=" + u11 + ", hash=" + format}, false, 4, null);
        return new Pair(Integer.valueOf(v11), Integer.valueOf(intValue));
    }

    private final String j(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mpush_hash_fallback_prefs", 0);
        String string = sharedPreferences.getString("key_install_fallback_id", null);
        if (string != null && !StringsKt.q0(string)) {
            return string;
        }
        synchronized (f47664b) {
            String string2 = sharedPreferences.getString("key_install_fallback_id", null);
            if (string2 != null && !StringsKt.q0(string2)) {
                return string2;
            }
            String str = "install-" + UUID.randomUUID();
            Intrinsics.e(sharedPreferences);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("key_install_fallback_id", str);
            edit.apply();
            return str;
        }
    }

    private final Pair k(Context context) {
        a aVar = f47665c;
        if (aVar != null) {
            return TuplesKt.a(aVar.b(), Integer.valueOf(aVar.a()));
        }
        synchronized (f47664b) {
            a aVar2 = f47665c;
            if (aVar2 != null) {
                return TuplesKt.a(aVar2.b(), Integer.valueOf(aVar2.a()));
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mpush_hash_fallback_prefs", 0);
            String string = sharedPreferences.getString("key_stable_device_id", null);
            if (string == null) {
                string = "";
            }
            b bVar = f47663a;
            Intrinsics.e(sharedPreferences);
            int q11 = bVar.q(sharedPreferences);
            C0636b s11 = bVar.s(context);
            String t11 = bVar.t(s11.b());
            if (!StringsKt.q0(string)) {
                if (s11.a() > q11 && !Intrinsics.c(string, t11)) {
                    bVar.o(sharedPreferences, t11, s11.a());
                    q11 = s11.a();
                }
                f47665c = new a(string, q11);
                return TuplesKt.a(string, Integer.valueOf(q11));
            }
            bVar.o(sharedPreferences, t11, s11.a());
            q11 = s11.a();
            string = t11;
            f47665c = new a(string, q11);
            return TuplesKt.a(string, Integer.valueOf(q11));
        }
    }

    private final double l(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "getBytes(...)");
        UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(bytes);
        return ((nameUUIDFromBytes.getMostSignificantBits() ^ nameUUIDFromBytes.getLeastSignificantBits()) >>> 1) / 9.223372036854776E18d;
    }

    private final boolean m(String str) {
        return (StringsKt.q0(str) || StringsKt.H(str, "9774d56d682e549c", true) || StringsKt.H(str, TmcConstants.ROUTE_UNKNOWN, true)) ? false : true;
    }

    private final int n(String str, int i11) {
        Integer v11;
        if (str != null && !StringsKt.q0(str)) {
            String obj = StringsKt.n1(str).toString();
            if (StringsKt.c0(obj, ":", false, 2, null)) {
                List S0 = StringsKt.S0(obj, new String[]{":"}, false, 2, 2, null);
                if (S0.size() == 2 && (v11 = StringsKt.v((String) S0.get(0))) != null) {
                    int m11 = RangesKt.m(v11.intValue(), 0, 23);
                    Integer v12 = StringsKt.v((String) S0.get(1));
                    if (v12 != null) {
                        return (m11 * 60) + RangesKt.m(v12.intValue(), 0, 59);
                    }
                }
                return i11;
            }
            Integer v13 = StringsKt.v(obj);
            if (v13 != null) {
                return RangesKt.m(v13.intValue(), 0, 23) * 60;
            }
        }
        return i11;
    }

    private final void o(SharedPreferences sharedPreferences, String str, int i11) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("key_stable_device_id", str);
        edit.putInt("key_stable_device_priority", i11);
        edit.apply();
    }

    private final String p(Context context) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        String str = (String) m1185constructorimpl;
        return str == null ? "" : str;
    }

    private final int q(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt("key_stable_device_priority", 0);
    }

    private final String r() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Function0 p11 = m.f47565a.p();
            String str = p11 != null ? (String) p11.invoke() : null;
            if (str == null) {
                str = "";
            }
            m1185constructorimpl = Result.m1185constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        String str2 = (String) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
        return str2 == null ? "" : str2;
    }

    private final C0636b s(Context context) {
        String p11 = p(context);
        if (m(p11)) {
            return new C0636b(p11, 4);
        }
        String r11 = r();
        if (!StringsKt.q0(r11)) {
            return new C0636b(r11, 3);
        }
        String j11 = j(context);
        if (!StringsKt.q0(j11)) {
            return new C0636b(j11, 2);
        }
        String a11 = a();
        if (!StringsKt.q0(a11)) {
            return new C0636b(a11, 1);
        }
        return new C0636b("volatile-" + UUID.randomUUID(), 0);
    }

    private final String t(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "getBytes(...)");
        return "stable-" + UUID.nameUUIDFromBytes(bytes);
    }

    private final int v(double d11, int i11) {
        return RangesKt.m((int) (RangesKt.k(d11, 0.0d, com.transsion.mpush.core.utils.a.a(1.0d)) * i11), 0, i11 - 1);
    }

    public final c b(Context context, String str, int i11, int i12, int i13, Calendar calendar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(calendar, "calendar");
        int i14 = (calendar.get(11) * 60) + calendar.get(12);
        int n11 = n(str, i11);
        Pair h11 = h(context, RangesKt.f(i13 + i12 + 1, 1));
        int intValue = ((Number) h11.component1()).intValue();
        int i15 = intValue - i12;
        return new c(i14, n11, i15, RangesKt.m(n11 + i15, 0, 1439), ((Number) h11.component2()).intValue());
    }

    public final d d(Context context, String str, int i11, int i12, int i13) {
        Intrinsics.h(context, "context");
        int n11 = n(str, i11) * 60;
        int f11 = RangesKt.f(i12, 0) * 60;
        Pair i14 = i(context, (RangesKt.f(i13, 0) * 60) + f11 + 1);
        int intValue = ((Number) i14.component1()).intValue();
        int intValue2 = ((Number) i14.component2()).intValue();
        int i15 = intValue - f11;
        int m11 = RangesKt.m(n11 + i15, 0, 86399);
        Calendar calendar = Calendar.getInstance();
        Intrinsics.g(calendar, "getInstance(...)");
        return new d(e(calendar), i15, m11, intValue2);
    }

    public final String f(int i11) {
        int m11 = RangesKt.m(i11, 0, 1439);
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(m11 / 60), Integer.valueOf(m11 % 60)}, 2));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final String g(int i11) {
        int m11 = RangesKt.m(i11, 0, 86399);
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(m11 / 3600), Integer.valueOf((m11 % 3600) / 60), Integer.valueOf(m11 % 60)}, 3));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final String u(int i11) {
        if (i11 == 0) {
            return "VOLATILE_UUID";
        }
        if (i11 == 1) {
            return "BUILD_FINGERPRINT";
        }
        if (i11 == 2) {
            return "INSTALL_ID";
        }
        if (i11 == 3) {
            return "UID";
        }
        if (i11 == 4) {
            return "ANDROID_ID";
        }
        return "UNKNOWN(" + i11 + ")";
    }
}
