package ej;

import com.bumptech.glide.util.LruCache;
import com.cloud.tmc.kernel.utils.UrlUtils;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a */
    public static final g f62037a = new g();

    /* renamed from: b */
    private static Integer[] f62038b = {120, 180, 240, 360, 540, 720, 1080};

    /* renamed from: c */
    private static LruCache f62039c = new LruCache(600);

    private g() {
    }

    public static /* synthetic */ String b(g gVar, String str, int i11, boolean z10, boolean z11, int i12, boolean z12, int i13, int i14, Object obj) {
        return gVar.a(str, i11, (i14 & 4) != 0 ? true : z10, (i14 & 8) != 0 ? true : z11, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? false : z12, (i14 & 64) != 0 ? 0 : i13);
    }

    public static /* synthetic */ String e(g gVar, String str, int i11, boolean z10, boolean z11, int i12, boolean z12, boolean z13, int i13, int i14, Object obj) {
        return gVar.d(str, i11, (i14 & 4) != 0 ? true : z10, (i14 & 8) != 0 ? true : z11, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? false : z12, (i14 & 64) != 0 ? false : z13, (i14 & 128) != 0 ? 0 : i13);
    }

    private final int f(int i11) {
        int intValue = ((Number) ArraysKt.q0(f62038b)).intValue();
        for (Integer num : f62038b) {
            int intValue2 = num.intValue();
            if (i11 <= intValue2) {
                return intValue2;
            }
        }
        return intValue;
    }

    private final boolean g(String str) {
        return StringsKt.c0(str, "?x-oss-process=image", false, 2, null) || StringsKt.c0(str, "x-server-image=1", false, 2, null);
    }

    public final String a(String url, int i11, boolean z10, boolean z11, int i12, boolean z12, int i13) {
        Intrinsics.h(url, "url");
        if (g(url)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(url);
        if (StringsKt.c0(url, UrlUtils.QUESTION_MARK, false, 2, null)) {
            sb2.append("&x-oss-process=image");
        } else {
            sb2.append("?x-oss-process=image");
        }
        sb2.append("/resize,w_");
        sb2.append(i11);
        if (z12) {
            sb2.append(",h_");
            sb2.append(i12);
        }
        if (z10) {
            sb2.append("/format,webp");
        }
        if (z11) {
            sb2.append("/quality,Q_50");
        }
        if (1 <= i13 && i13 < 51) {
            sb2.append("/blur,r_" + i13 + ",s_" + i13);
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public final int c(String url) {
        Intrinsics.h(url, "url");
        Integer num = (Integer) f62039c.get(url);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final String d(String url, int i11, boolean z10, boolean z11, int i12, boolean z12, boolean z13, int i13) {
        Intrinsics.h(url, "url");
        if (g(url)) {
            return url;
        }
        int f11 = f(i11);
        Integer num = (Integer) f62039c.get(url);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue >= f11) {
            f11 = intValue;
        }
        int i14 = (int) (((f11 * 1.0f) / i11) * i12);
        if (intValue != f11 && !z13) {
            f62039c.put(url, Integer.valueOf(f11));
        }
        return a(url, f11, z10, z11, i14, z12, i13);
    }

    public final void h(String originUrl, int i11) {
        Intrinsics.h(originUrl, "originUrl");
        if (g(originUrl)) {
            return;
        }
        int f11 = f(i11);
        Integer num = (Integer) f62039c.get(originUrl);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue >= f11) {
            f11 = intValue;
        }
        if (intValue != f11) {
            f62039c.put(originUrl, Integer.valueOf(f11));
        }
    }
}
