package p0;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c implements p0.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f72349c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f72350d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final float[] f72351a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f72352b;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(float f11, float[] fArr, float[] fArr2) {
            float f12;
            float f13;
            float f14;
            float a11;
            float abs = Math.abs(f11);
            float signum = Math.signum(f11);
            int binarySearch = Arrays.binarySearch(fArr, abs);
            if (binarySearch >= 0) {
                a11 = fArr2[binarySearch];
            } else {
                int i11 = -(binarySearch + 1);
                int i12 = i11 - 1;
                float f15 = 0.0f;
                if (i12 >= fArr.length - 1) {
                    float f16 = fArr[fArr.length - 1];
                    float f17 = fArr2[fArr.length - 1];
                    if (f16 == 0.0f) {
                        return 0.0f;
                    }
                    return f11 * (f17 / f16);
                }
                if (i12 == -1) {
                    float f18 = fArr[0];
                    f14 = fArr2[0];
                    f13 = f18;
                    f12 = 0.0f;
                } else {
                    float f19 = fArr[i12];
                    float f20 = fArr[i11];
                    f12 = fArr2[i12];
                    f15 = f19;
                    f13 = f20;
                    f14 = fArr2[i11];
                }
                a11 = d.f72353a.a(f12, f14, f15, f13, abs);
            }
            return signum * a11;
        }
    }

    public c(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.f72351a = fArr;
        this.f72352b = fArr2;
    }

    @Override // p0.a
    public float a(float f11) {
        return f72349c.b(f11, this.f72352b, this.f72351a);
    }

    @Override // p0.a
    public float b(float f11) {
        return f72349c.b(f11, this.f72351a, this.f72352b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f72351a, cVar.f72351a) && Arrays.equals(this.f72352b, cVar.f72352b);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f72351a) * 31) + Arrays.hashCode(this.f72352b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontScaleConverter{fromSpValues=");
        String arrays = Arrays.toString(this.f72351a);
        Intrinsics.g(arrays, "toString(this)");
        sb2.append(arrays);
        sb2.append(", toDpValues=");
        String arrays2 = Arrays.toString(this.f72352b);
        Intrinsics.g(arrays2, "toString(this)");
        sb2.append(arrays2);
        sb2.append('}');
        return sb2.toString();
    }
}
