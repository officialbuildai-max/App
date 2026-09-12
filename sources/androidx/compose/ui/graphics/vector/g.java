package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private float[] f4915a = new float[64];

    public static /* synthetic */ ArrayList b(g gVar, String str, ArrayList arrayList, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            arrayList = new ArrayList();
        }
        return gVar.a(str, arrayList);
    }

    public final ArrayList a(String str, ArrayList arrayList) {
        int i11;
        char charAt;
        int i12;
        int length = str.length();
        int i13 = 0;
        while (i13 < length && Intrinsics.j(str.charAt(i13), 32) <= 0) {
            i13++;
        }
        while (length > i13 && Intrinsics.j(str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i14 = 0;
        while (i13 < length) {
            while (true) {
                i11 = i13 + 1;
                charAt = str.charAt(i13);
                int i15 = charAt | ' ';
                if ((i15 - 97) * (i15 - 122) <= 0 && i15 != 101) {
                    break;
                }
                if (i11 >= length) {
                    charAt = 0;
                    break;
                }
                i13 = i11;
            }
            if (charAt != 0) {
                if ((charAt | ' ') != 122) {
                    i14 = 0;
                    while (true) {
                        if (i11 >= length || Intrinsics.j(str.charAt(i11), 32) > 0) {
                            long a11 = b.a(str, i11, length);
                            i12 = (int) (a11 >>> 32);
                            float intBitsToFloat = Float.intBitsToFloat((int) (a11 & 4294967295L));
                            if (!Float.isNaN(intBitsToFloat)) {
                                float[] fArr = this.f4915a;
                                int i16 = i14 + 1;
                                fArr[i14] = intBitsToFloat;
                                if (i16 >= fArr.length) {
                                    float[] fArr2 = new float[i16 * 2];
                                    this.f4915a = fArr2;
                                    ArraysKt.k(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i14 = i16;
                            }
                            while (i12 < length && str.charAt(i12) == ',') {
                                i12++;
                            }
                            if (i12 >= length || Float.isNaN(intBitsToFloat)) {
                                break;
                            }
                            i11 = i12;
                        } else {
                            i11++;
                        }
                    }
                    i11 = i12;
                }
                f.a(charAt, arrayList, this.f4915a, i14);
            }
            i13 = i11;
        }
        return arrayList;
    }
}
