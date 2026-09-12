package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f2233a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f2234b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f2235c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f2236d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f2237a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f2238b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f2239c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f2240d;

        public b a() {
            return new b(this.f2237a, this.f2238b, this.f2239c, this.f2240d);
        }
    }

    b(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f2233a = num;
        this.f2234b = num2;
        this.f2235c = num3;
        this.f2236d = num4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f2233a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f2234b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f2235c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f2236d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
