package vv;

import android.graphics.drawable.Drawable;
import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f77571a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f77572b;

    /* renamed from: c, reason: collision with root package name */
    public String f77573c;

    /* renamed from: d, reason: collision with root package name */
    public long f77574d;

    /* renamed from: e, reason: collision with root package name */
    public String f77575e;

    /* renamed from: f, reason: collision with root package name */
    public String f77576f;

    /* renamed from: g, reason: collision with root package name */
    public String f77577g;

    /* renamed from: h, reason: collision with root package name */
    public String f77578h;

    /* renamed from: i, reason: collision with root package name */
    public String f77579i;

    /* renamed from: j, reason: collision with root package name */
    public String f77580j;

    /* renamed from: k, reason: collision with root package name */
    public String f77581k;

    /* renamed from: l, reason: collision with root package name */
    public String f77582l;

    /* renamed from: m, reason: collision with root package name */
    public String f77583m;

    public b(String packageName, Drawable drawable, String appName, long j11, String versionName, String lan, String appKey, String countryCode, String brand, String model, String originModel, String androidVersion, String defaultLocal) {
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(appName, "appName");
        Intrinsics.h(versionName, "versionName");
        Intrinsics.h(lan, "lan");
        Intrinsics.h(appKey, "appKey");
        Intrinsics.h(countryCode, "countryCode");
        Intrinsics.h(brand, "brand");
        Intrinsics.h(model, "model");
        Intrinsics.h(originModel, "originModel");
        Intrinsics.h(androidVersion, "androidVersion");
        Intrinsics.h(defaultLocal, "defaultLocal");
        this.f77571a = packageName;
        this.f77572b = drawable;
        this.f77573c = appName;
        this.f77574d = j11;
        this.f77575e = versionName;
        this.f77576f = lan;
        this.f77577g = appKey;
        this.f77578h = countryCode;
        this.f77579i = brand;
        this.f77580j = model;
        this.f77581k = originModel;
        this.f77582l = androidVersion;
        this.f77583m = defaultLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f77571a, bVar.f77571a) && Intrinsics.c(this.f77572b, bVar.f77572b) && Intrinsics.c(this.f77573c, bVar.f77573c) && this.f77574d == bVar.f77574d && Intrinsics.c(this.f77575e, bVar.f77575e) && Intrinsics.c(this.f77576f, bVar.f77576f) && Intrinsics.c(this.f77577g, bVar.f77577g) && Intrinsics.c(this.f77578h, bVar.f77578h) && Intrinsics.c(this.f77579i, bVar.f77579i) && Intrinsics.c(this.f77580j, bVar.f77580j) && Intrinsics.c(this.f77581k, bVar.f77581k) && Intrinsics.c(this.f77582l, bVar.f77582l) && Intrinsics.c(this.f77583m, bVar.f77583m);
    }

    public final int hashCode() {
        int hashCode = this.f77571a.hashCode() * 31;
        Drawable drawable = this.f77572b;
        return this.f77583m.hashCode() + a.a(this.f77582l, a.a(this.f77581k, a.a(this.f77580j, a.a(this.f77579i, a.a(this.f77578h, a.a(this.f77577g, a.a(this.f77576f, a.a(this.f77575e, (s.a(this.f77574d) + a.a(this.f77573c, (hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31, 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "CurrentPackageInfo(packageName=" + this.f77571a + ", iconDrawable=" + this.f77572b + ", appName=" + this.f77573c + ", currentVersion=" + this.f77574d + ", versionName=" + this.f77575e + ", lan=" + this.f77576f + ", appKey=" + this.f77577g + ", countryCode=" + this.f77578h + ", brand=" + this.f77579i + ", model=" + this.f77580j + ", originModel=" + this.f77581k + ", androidVersion=" + this.f77582l + ", defaultLocal=" + this.f77583m + ')';
    }
}
