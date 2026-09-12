package com.transsion.ad;

import androidx.compose.animation.core.j0;
import androidx.compose.foundation.e;
import com.transsion.ad.strategy.AppManager;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class MBAd {

    /* renamed from: a, reason: collision with root package name */
    public static final MBAd f41805a = new MBAd();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference f41806b = new AtomicReference(null);

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f41807a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f41808b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f41809c;

        /* renamed from: d, reason: collision with root package name */
        private final AppManager.AppEnum f41810d;

        /* renamed from: e, reason: collision with root package name */
        private final String f41811e;

        /* renamed from: f, reason: collision with root package name */
        private final String f41812f;

        /* renamed from: g, reason: collision with root package name */
        private final String f41813g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f41814h;

        /* renamed from: i, reason: collision with root package name */
        private final hi.a f41815i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f41816j;

        /* renamed from: k, reason: collision with root package name */
        private final boolean f41817k;

        /* renamed from: l, reason: collision with root package name */
        private final boolean f41818l;

        public a(String hisavanaAppId, boolean z10, boolean z11, AppManager.AppEnum appEnum, String hotSceneId, String adConfigUrl, String adConfigHost, boolean z12, hi.a aVar, boolean z13, boolean z14, boolean z15) {
            Intrinsics.h(hisavanaAppId, "hisavanaAppId");
            Intrinsics.h(appEnum, "appEnum");
            Intrinsics.h(hotSceneId, "hotSceneId");
            Intrinsics.h(adConfigUrl, "adConfigUrl");
            Intrinsics.h(adConfigHost, "adConfigHost");
            this.f41807a = hisavanaAppId;
            this.f41808b = z10;
            this.f41809c = z11;
            this.f41810d = appEnum;
            this.f41811e = hotSceneId;
            this.f41812f = adConfigUrl;
            this.f41813g = adConfigHost;
            this.f41814h = z12;
            this.f41815i = aVar;
            this.f41816j = z13;
            this.f41817k = z14;
            this.f41818l = z15;
        }

        public final String a() {
            return this.f41813g;
        }

        public final String b() {
            return this.f41812f;
        }

        public final boolean c() {
            return this.f41808b;
        }

        public final AppManager.AppEnum d() {
            return this.f41810d;
        }

        public final hi.a e() {
            return this.f41815i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f41807a, aVar.f41807a) && this.f41808b == aVar.f41808b && this.f41809c == aVar.f41809c && this.f41810d == aVar.f41810d && Intrinsics.c(this.f41811e, aVar.f41811e) && Intrinsics.c(this.f41812f, aVar.f41812f) && Intrinsics.c(this.f41813g, aVar.f41813g) && this.f41814h == aVar.f41814h && Intrinsics.c(this.f41815i, aVar.f41815i) && this.f41816j == aVar.f41816j && this.f41817k == aVar.f41817k && this.f41818l == aVar.f41818l;
        }

        public final String f() {
            return this.f41807a;
        }

        public final String g() {
            return this.f41811e;
        }

        public final boolean h() {
            return this.f41814h;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((this.f41807a.hashCode() * 31) + e.a(this.f41808b)) * 31) + e.a(this.f41809c)) * 31) + this.f41810d.hashCode()) * 31) + this.f41811e.hashCode()) * 31) + this.f41812f.hashCode()) * 31) + this.f41813g.hashCode()) * 31) + e.a(this.f41814h)) * 31;
            hi.a aVar = this.f41815i;
            return ((((((hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31) + e.a(this.f41816j)) * 31) + e.a(this.f41817k)) * 31) + e.a(this.f41818l);
        }

        public final boolean i() {
            return this.f41816j;
        }

        public final boolean j() {
            return this.f41818l;
        }

        public final boolean k() {
            return this.f41817k;
        }

        public final boolean l() {
            return this.f41809c;
        }

        public final String m() {
            return StringsKt.n("\n                AdInitParams {\n                    hisavanaAppId = " + this.f41807a + "\n                    adTestDevice = " + this.f41808b + "\n                    isDebug = " + this.f41809c + "\n                    appEnum = " + this.f41810d.getValue() + "\n                    hotSceneId = " + this.f41811e + "\n                    adConfigUrl = " + this.f41812f + "\n                    mediaDisposeAppForeground = " + this.f41814h + "\n                    businessBridge = " + this.f41815i + "\n                    mediaDisposeH5Url = " + this.f41816j + "\n                    skipHiSdkInitDelay = " + this.f41817k + "\n                    openPsActivateAd = " + this.f41818l + "\n                }\n            ");
        }

        public String toString() {
            return "AdInitParams(hisavanaAppId=" + this.f41807a + ", adTestDevice=" + this.f41808b + ", isDebug=" + this.f41809c + ", appEnum=" + this.f41810d + ", hotSceneId=" + this.f41811e + ", adConfigUrl=" + this.f41812f + ", adConfigHost=" + this.f41813g + ", mediaDisposeAppForeground=" + this.f41814h + ", businessBridge=" + this.f41815i + ", mediaDisposeH5Url=" + this.f41816j + ", skipHiSdkInitDelay=" + this.f41817k + ", openPsActivateAd=" + this.f41818l + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        private boolean f41820b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f41821c;

        /* renamed from: h, reason: collision with root package name */
        private boolean f41826h;

        /* renamed from: i, reason: collision with root package name */
        private hi.a f41827i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f41828j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f41829k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f41830l;

        /* renamed from: a, reason: collision with root package name */
        private String f41819a = "";

        /* renamed from: d, reason: collision with root package name */
        private AppManager.AppEnum f41822d = AppManager.AppEnum.APP_MOVIE_BOX;

        /* renamed from: e, reason: collision with root package name */
        private String f41823e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f41824f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f41825g = "";

        public final a a() {
            if (this.f41819a.length() != 0) {
                return new a(this.f41819a, this.f41820b, this.f41821c, this.f41822d, this.f41823e, this.f41824f, this.f41825g, this.f41826h, this.f41827i, this.f41828j, this.f41829k, this.f41830l);
            }
            throw new IllegalArgumentException("HiSavana App ID must not be empty");
        }

        public final b b(String adConfigHost) {
            Intrinsics.h(adConfigHost, "adConfigHost");
            this.f41825g = adConfigHost;
            return this;
        }

        public final b c(String adConfigUrl) {
            Intrinsics.h(adConfigUrl, "adConfigUrl");
            this.f41824f = adConfigUrl;
            return this;
        }

        public final b d(boolean z10) {
            this.f41820b = z10;
            return this;
        }

        public final b e(AppManager.AppEnum appEnum) {
            Intrinsics.h(appEnum, "appEnum");
            this.f41822d = appEnum;
            return this;
        }

        public final b f(hi.a aVar) {
            this.f41827i = aVar;
            return this;
        }

        public final b g(String hisavanaAppId) {
            Intrinsics.h(hisavanaAppId, "hisavanaAppId");
            this.f41819a = hisavanaAppId;
            return this;
        }

        public final b h(String hotSceneId) {
            Intrinsics.h(hotSceneId, "hotSceneId");
            this.f41823e = hotSceneId;
            return this;
        }

        public final b i(boolean z10) {
            this.f41821c = z10;
            return this;
        }

        public final b j(boolean z10) {
            this.f41826h = z10;
            return this;
        }

        public final b k(boolean z10) {
            this.f41828j = z10;
            return this;
        }

        public final b l(boolean z10) {
            this.f41830l = z10;
            return this;
        }

        public final b m(boolean z10) {
            this.f41829k = z10;
            return this;
        }
    }

    private MBAd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        String simpleName = MBAd.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final a c() {
        return (a) f41806b.get();
    }

    public final Object e(a aVar, Continuation continuation) {
        if (j0.a(f41806b, null, aVar)) {
            Object g11 = i.g(y0.b(), new MBAd$initAd$2(aVar, null), continuation);
            return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
        }
        oi.a.c(oi.a.f71145a, d() + " --> initAd() --> 广告SDK，已经初始化", 6, false, 4, null);
        return Unit.f67184a;
    }

    public final Object f(String str, Continuation continuation) {
        Object g11 = i.g(y0.b(), new MBAd$initNonAd$2(str, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }

    public final boolean g() {
        a c11 = c();
        if (c11 != null) {
            return c11.l();
        }
        return false;
    }
}
