package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.i4;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f5841a;

    /* renamed from: b, reason: collision with root package name */
    private Matrix f5842b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f5843c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f5844d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f5845e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5846f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5847g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5848h = true;

    public d1(Function2 function2) {
        this.f5841a = function2;
    }

    public final float[] a(Object obj) {
        float[] fArr = this.f5845e;
        if (fArr == null) {
            fArr = i4.c(null, 1, null);
            this.f5845e = fArr;
        }
        if (this.f5847g) {
            this.f5848h = b1.a(b(obj), fArr);
            this.f5847g = false;
        }
        if (this.f5848h) {
            return fArr;
        }
        return null;
    }

    public final float[] b(Object obj) {
        float[] fArr = this.f5844d;
        if (fArr == null) {
            fArr = i4.c(null, 1, null);
            this.f5844d = fArr;
        }
        if (!this.f5846f) {
            return fArr;
        }
        Matrix matrix = this.f5842b;
        if (matrix == null) {
            matrix = new Matrix();
            this.f5842b = matrix;
        }
        this.f5841a.invoke(obj, matrix);
        Matrix matrix2 = this.f5843c;
        if (matrix2 == null || !Intrinsics.c(matrix, matrix2)) {
            androidx.compose.ui.graphics.r0.b(fArr, matrix);
            this.f5842b = matrix2;
            this.f5843c = matrix;
        }
        this.f5846f = false;
        return fArr;
    }

    public final void c() {
        this.f5846f = true;
        this.f5847g = true;
    }
}
