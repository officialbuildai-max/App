package lv;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import androidx.compose.foundation.e;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.d;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yg.b;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: r, reason: collision with root package name */
    public static final C0862a f69160r = new C0862a(null);

    /* renamed from: a, reason: collision with root package name */
    private String f69161a;

    /* renamed from: b, reason: collision with root package name */
    private String f69162b;

    /* renamed from: c, reason: collision with root package name */
    private String f69163c;

    /* renamed from: d, reason: collision with root package name */
    private String f69164d;

    /* renamed from: e, reason: collision with root package name */
    private String f69165e;

    /* renamed from: f, reason: collision with root package name */
    private String f69166f;

    /* renamed from: g, reason: collision with root package name */
    private String f69167g;

    /* renamed from: h, reason: collision with root package name */
    private String f69168h;

    /* renamed from: i, reason: collision with root package name */
    private String f69169i;

    /* renamed from: j, reason: collision with root package name */
    private String f69170j;

    /* renamed from: k, reason: collision with root package name */
    private String f69171k;

    /* renamed from: l, reason: collision with root package name */
    private String f69172l;

    /* renamed from: m, reason: collision with root package name */
    private String f69173m;

    /* renamed from: n, reason: collision with root package name */
    private String f69174n;

    /* renamed from: o, reason: collision with root package name */
    private String f69175o;

    /* renamed from: p, reason: collision with root package name */
    private String f69176p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f69177q;

    /* renamed from: lv.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0862a {
        private C0862a() {
        }

        public /* synthetic */ C0862a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(a aVar) {
            if (aVar.q()) {
                throw new RuntimeException("the device isn‘t sender");
            }
            if (aVar.a()) {
                String b11 = b();
                String upperCase = d.f56088a.a(4).toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                return b11 + "-5G-" + upperCase;
            }
            String b12 = b();
            String upperCase2 = d.f56088a.a(4).toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase2, "toUpperCase(...)");
            return b12 + "-" + upperCase2;
        }

        private final String b() {
            String upperCase = d.f56088a.a(2).toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            return "DIRECT-" + upperCase + "-MOVIEBOX";
        }

        public final a c(boolean z10) {
            String str = null;
            a aVar = new a(null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, str, false, 131071, null);
            aVar.y("mb_unique");
            aVar.u(Build.DEVICE);
            aVar.s(Build.BRAND);
            aVar.w(Build.PRODUCT);
            aVar.C(Build.VERSION.RELEASE);
            aVar.D(String.valueOf(Build.VERSION.SDK_INT));
            aVar.A(String.valueOf(c.f()));
            aVar.B(c.h());
            aVar.v(c.e());
            b.a aVar2 = b.f79132a;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            aVar.t(aVar2.e(a11));
            aVar.z("userId");
            aVar.r("avatarIndex");
            if (z10) {
                aVar.E(NetworkUtil.NETWORK_TYPE_5G);
            } else {
                aVar.E("2.4G");
            }
            aVar.H(a(aVar));
            com.transsion.transfer.wifi.util.b bVar = com.transsion.transfer.wifi.util.b.f56086a;
            String p11 = aVar.p();
            if (p11 == null) {
                p11 = "";
            }
            String substring = bVar.a(p11).substring(0, 8);
            Intrinsics.g(substring, "substring(...)");
            aVar.G(substring);
            aVar.x(true);
            return aVar;
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 131071, null);
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z10) {
        this.f69161a = str;
        this.f69162b = str2;
        this.f69163c = str3;
        this.f69164d = str4;
        this.f69165e = str5;
        this.f69166f = str6;
        this.f69167g = str7;
        this.f69168h = str8;
        this.f69169i = str9;
        this.f69170j = str10;
        this.f69171k = str11;
        this.f69172l = str12;
        this.f69173m = str13;
        this.f69174n = str14;
        this.f69175o = str15;
        this.f69176p = str16;
        this.f69177q = z10;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : str8, (i11 & 256) != 0 ? null : str9, (i11 & 512) != 0 ? null : str10, (i11 & 1024) != 0 ? null : str11, (i11 & 2048) != 0 ? null : str12, (i11 & 4096) != 0 ? null : str13, (i11 & 8192) != 0 ? null : str14, (i11 & 16384) != 0 ? null : str15, (i11 & 32768) != 0 ? null : str16, (i11 & 65536) != 0 ? false : z10);
    }

    public final void A(String str) {
        this.f69167g = str;
    }

    public final void B(String str) {
        this.f69168h = str;
    }

    public final void C(String str) {
        this.f69165e = str;
    }

    public final void D(String str) {
        this.f69166f = str;
    }

    public final void E(String str) {
        this.f69175o = str;
    }

    public final void F(String str) {
        this.f69176p = str;
    }

    public final void G(String str) {
        this.f69174n = str;
    }

    public final void H(String str) {
        this.f69173m = str;
    }

    public final boolean a() {
        return WifiUtils.f56083a.n() && TextUtils.equals(this.f69175o, NetworkUtil.NETWORK_TYPE_5G);
    }

    public final String b() {
        return this.f69172l;
    }

    public final String c() {
        return this.f69163c;
    }

    public final String d() {
        return this.f69170j;
    }

    public final String e() {
        return this.f69162b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f69161a, aVar.f69161a) && Intrinsics.c(this.f69162b, aVar.f69162b) && Intrinsics.c(this.f69163c, aVar.f69163c) && Intrinsics.c(this.f69164d, aVar.f69164d) && Intrinsics.c(this.f69165e, aVar.f69165e) && Intrinsics.c(this.f69166f, aVar.f69166f) && Intrinsics.c(this.f69167g, aVar.f69167g) && Intrinsics.c(this.f69168h, aVar.f69168h) && Intrinsics.c(this.f69169i, aVar.f69169i) && Intrinsics.c(this.f69170j, aVar.f69170j) && Intrinsics.c(this.f69171k, aVar.f69171k) && Intrinsics.c(this.f69172l, aVar.f69172l) && Intrinsics.c(this.f69173m, aVar.f69173m) && Intrinsics.c(this.f69174n, aVar.f69174n) && Intrinsics.c(this.f69175o, aVar.f69175o) && Intrinsics.c(this.f69176p, aVar.f69176p) && this.f69177q == aVar.f69177q;
    }

    public final String f() {
        return this.f69169i;
    }

    public final String g() {
        return this.f69164d;
    }

    public final String h() {
        return this.f69171k;
    }

    public int hashCode() {
        String str = this.f69161a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f69162b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f69163c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f69164d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f69165e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f69166f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f69167g;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f69168h;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f69169i;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f69170j;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f69171k;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.f69172l;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.f69173m;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.f69174n;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.f69175o;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.f69176p;
        return ((hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31) + e.a(this.f69177q);
    }

    public final String i() {
        return this.f69167g;
    }

    public final String j() {
        return this.f69168h;
    }

    public final String k() {
        return this.f69165e;
    }

    public final String l() {
        return this.f69166f;
    }

    public final String m() {
        return this.f69175o;
    }

    public final String n() {
        return this.f69176p;
    }

    public final String o() {
        return this.f69174n;
    }

    public final String p() {
        return this.f69173m;
    }

    public final boolean q() {
        return this.f69177q;
    }

    public final void r(String str) {
        this.f69172l = str;
    }

    public final void s(String str) {
        this.f69163c = str;
    }

    public final void t(String str) {
        this.f69170j = str;
    }

    public String toString() {
        return "WifiInfoModel(unique=" + this.f69161a + ", device=" + this.f69162b + ", brand=" + this.f69163c + ", product=" + this.f69164d + ", versionRelease=" + this.f69165e + ", versionSdkInt=" + this.f69166f + ", versionCode=" + this.f69167g + ", versionName=" + this.f69168h + ", packageName=" + this.f69169i + ", channel=" + this.f69170j + ", userId=" + this.f69171k + ", avatarIndex=" + this.f69172l + ", wifiSsid=" + this.f69173m + ", wifiPwd=" + this.f69174n + ", wifiChannel=" + this.f69175o + ", wifiIp=" + this.f69176p + ", isSender=" + this.f69177q + ")";
    }

    public final void u(String str) {
        this.f69162b = str;
    }

    public final void v(String str) {
        this.f69169i = str;
    }

    public final void w(String str) {
        this.f69164d = str;
    }

    public final void x(boolean z10) {
        this.f69177q = z10;
    }

    public final void y(String str) {
        this.f69161a = str;
    }

    public final void z(String str) {
        this.f69171k = str;
    }
}
