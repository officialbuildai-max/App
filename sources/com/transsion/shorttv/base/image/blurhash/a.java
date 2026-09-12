package com.transsion.shorttv.base.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f52839a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f52840b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap f52841c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Map f52842d;

    static {
        List o11 = CollectionsKt.o('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', '$', '%', '*', '+', ',', '-', '.', ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~');
        ArrayList arrayList = new ArrayList(CollectionsKt.v(o11, 10));
        int i11 = 0;
        for (Object obj : o11) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            Character ch2 = (Character) obj;
            ch2.charValue();
            arrayList.add(TuplesKt.a(ch2, Integer.valueOf(i11)));
            i11 = i12;
        }
        f52842d = MapsKt.s(arrayList);
    }

    private a() {
    }

    private final Bitmap a(int i11, int i12, int i13, int i14, float[][] fArr, boolean z10) {
        int[] iArr = new int[i11 * i12];
        boolean z11 = (z10 && f52840b.containsKey(Integer.valueOf(i11 * i13))) ? false : true;
        double[] f11 = f(z11, i11, i13);
        boolean z12 = (z10 && f52841c.containsKey(Integer.valueOf(i12 * i14))) ? false : true;
        double[] g11 = g(z12, i12, i14);
        int i15 = 0;
        while (i15 < i12) {
            int i16 = 0;
            while (i16 < i11) {
                float f12 = 0.0f;
                float f13 = 0.0f;
                float f14 = 0.0f;
                int i17 = 0;
                while (i17 < i14) {
                    float f15 = f12;
                    float f16 = f13;
                    float f17 = f14;
                    int i18 = 0;
                    while (i18 < i13) {
                        int i19 = i18;
                        int i20 = i17;
                        int i21 = i16;
                        boolean z13 = z12;
                        i15 = i15;
                        float h11 = (float) (h(g11, z13, i20, i14, i15, i12) * h(f11, z11, i19, i13, i21, i11));
                        float[] fArr2 = fArr[(i20 * i13) + i19];
                        f15 += fArr2[0] * h11;
                        f16 += fArr2[1] * h11;
                        f17 += fArr2[2] * h11;
                        i18 = i19 + 1;
                        i17 = i20;
                        i16 = i21;
                        z12 = z13;
                    }
                    i17++;
                    f12 = f15;
                    f13 = f16;
                    f14 = f17;
                }
                int i22 = i16;
                iArr[i22 + (i11 * i15)] = Color.rgb(i(f12), i(f13), i(f14));
                i16 = i22 + 1;
            }
            i15++;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i11, i12, Bitmap.Config.ARGB_8888);
        Intrinsics.g(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    private final int c(String str, int i11, int i12) {
        int i13 = 0;
        while (i11 < i12) {
            Integer num = (Integer) f52842d.get(Character.valueOf(str.charAt(i11)));
            int intValue = num != null ? num.intValue() : -1;
            if (intValue != -1) {
                i13 = (i13 * 83) + intValue;
            }
            i11++;
        }
        return i13;
    }

    private final float[] d(int i11, float f11) {
        return new float[]{j(((i11 / 361) - 9) / 9.0f) * f11, j((((i11 / 19) % 19) - 9) / 9.0f) * f11, j(((i11 % 19) - 9) / 9.0f) * f11};
    }

    private final float[] e(int i11) {
        return new float[]{k(i11 >> 16), k((i11 >> 8) & 255), k(i11 & 255)};
    }

    private final double[] f(boolean z10, int i11, int i12) {
        if (!z10) {
            Object obj = f52840b.get(Integer.valueOf(i11 * i12));
            Intrinsics.e(obj);
            return (double[]) obj;
        }
        int i13 = i11 * i12;
        double[] dArr = new double[i13];
        f52840b.put(Integer.valueOf(i13), dArr);
        return dArr;
    }

    private final double[] g(boolean z10, int i11, int i12) {
        if (!z10) {
            Object obj = f52841c.get(Integer.valueOf(i11 * i12));
            Intrinsics.e(obj);
            return (double[]) obj;
        }
        int i13 = i11 * i12;
        double[] dArr = new double[i13];
        f52841c.put(Integer.valueOf(i13), dArr);
        return dArr;
    }

    private final double h(double[] dArr, boolean z10, int i11, int i12, int i13, int i14) {
        if (z10) {
            dArr[(i12 * i13) + i11] = Math.cos(((i13 * 3.141592653589793d) * i11) / i14);
        }
        return dArr[i11 + (i12 * i13)];
    }

    private final int i(float f11) {
        float pow;
        float f12;
        float l11 = RangesKt.l(f11, 0.0f, 1.0f);
        if (l11 <= 0.0031308f) {
            pow = l11 * 12.92f;
            f12 = 255.0f;
        } else {
            pow = (((float) Math.pow(l11, 0.41666666f)) * 1.055f) - 0.055f;
            f12 = 255;
        }
        return (int) ((pow * f12) + 0.5f);
    }

    private final float j(float f11) {
        return Math.copySign((float) Math.pow(f11, 2.0f), f11);
    }

    private final float k(int i11) {
        float f11 = i11 / 255.0f;
        return f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((f11 + 0.055f) / 1.055f, 2.4f);
    }

    public final Bitmap b(String str, int i11, int i12, float f11, boolean z10) {
        float[] d11;
        if (str == null || str.length() < 6) {
            return null;
        }
        int c11 = c(str, 0, 1);
        int i13 = (c11 % 9) + 1;
        int i14 = (c11 / 9) + 1;
        if (str.length() != (i13 * 2 * i14) + 4) {
            return null;
        }
        float c12 = (c(str, 1, 2) + 1) / 166.0f;
        int i15 = i13 * i14;
        float[][] fArr = new float[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            if (i16 == 0) {
                a aVar = f52839a;
                d11 = aVar.e(aVar.c(str, 2, 6));
            } else {
                int i17 = i16 * 2;
                a aVar2 = f52839a;
                d11 = aVar2.d(aVar2.c(str, i17 + 4, i17 + 6), c12 * f11);
            }
            fArr[i16] = d11;
        }
        return a(i11, i12, i13, i14, fArr, z10);
    }
}
