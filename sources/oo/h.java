package oo;

import com.bumptech.glide.util.LruCache;
import com.cloud.tmc.kernel.utils.UrlUtils;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f71202a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static Integer[] f71203b = {120, 180, 240, 360, 540, 720, 1080};

    /* renamed from: c, reason: collision with root package name */
    private static LruCache f71204c = new LruCache(600);

    private h() {
    }

    private final int d(int i11) {
        int intValue = ((Number) ArraysKt.q0(f71203b)).intValue();
        for (Integer num : f71203b) {
            int intValue2 = num.intValue();
            if (i11 <= intValue2) {
                return intValue2;
            }
        }
        return intValue;
    }

    private final boolean e(String str) {
        return StringsKt.c0(str, "?x-oss-process=image", false, 2, null) || StringsKt.c0(str, "x-server-image=1", false, 2, null);
    }

    public final String a(String url, int i11, boolean z10, boolean z11, int i12, boolean z12) {
        Intrinsics.h(url, "url");
        if (e(url)) {
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
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public final String b(String url, int i11, boolean z10, boolean z11, int i12, boolean z12, boolean z13) {
        Intrinsics.h(url, "url");
        if (e(url)) {
            return url;
        }
        int d11 = d(i11);
        Integer num = (Integer) f71204c.get(url);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue >= d11) {
            d11 = intValue;
        }
        int i13 = (int) (((d11 * 1.0f) / i11) * i12);
        if (intValue != d11 && !z13) {
            f71204c.put(url, Integer.valueOf(d11));
        }
        return a(url, d11, z10, z11, i13, z12);
    }
}
