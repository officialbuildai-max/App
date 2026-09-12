package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f68469a = new Object[8];

    /* renamed from: b, reason: collision with root package name */
    private int[] f68470b;

    /* renamed from: c, reason: collision with root package name */
    private int f68471c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f68472a = new a();

        private a() {
        }
    }

    public x() {
        int[] iArr = new int[8];
        for (int i11 = 0; i11 < 8; i11++) {
            iArr[i11] = -1;
        }
        this.f68470b = iArr;
        this.f68471c = -1;
    }

    private final void e() {
        int i11 = this.f68471c * 2;
        Object[] copyOf = Arrays.copyOf(this.f68469a, i11);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        this.f68469a = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.f68470b, i11);
        Intrinsics.g(copyOf2, "copyOf(this, newSize)");
        this.f68470b = copyOf2;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("$");
        int i11 = this.f68471c + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = this.f68469a[i12];
            if (obj instanceof kotlinx.serialization.descriptors.f) {
                kotlinx.serialization.descriptors.f fVar = (kotlinx.serialization.descriptors.f) obj;
                if (!Intrinsics.c(fVar.d(), i.b.f68194a)) {
                    int i13 = this.f68470b[i12];
                    if (i13 >= 0) {
                        sb2.append(".");
                        sb2.append(fVar.f(i13));
                    }
                } else if (this.f68470b[i12] != -1) {
                    sb2.append("[");
                    sb2.append(this.f68470b[i12]);
                    sb2.append("]");
                }
            } else if (obj != a.f68472a) {
                sb2.append("[");
                sb2.append("'");
                sb2.append(obj);
                sb2.append("'");
                sb2.append("]");
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final void b() {
        int i11 = this.f68471c;
        int[] iArr = this.f68470b;
        if (iArr[i11] == -2) {
            iArr[i11] = -1;
            this.f68471c = i11 - 1;
        }
        int i12 = this.f68471c;
        if (i12 != -1) {
            this.f68471c = i12 - 1;
        }
    }

    public final void c(kotlinx.serialization.descriptors.f sd2) {
        Intrinsics.h(sd2, "sd");
        int i11 = this.f68471c + 1;
        this.f68471c = i11;
        if (i11 == this.f68469a.length) {
            e();
        }
        this.f68469a[i11] = sd2;
    }

    public final void d() {
        int[] iArr = this.f68470b;
        int i11 = this.f68471c;
        if (iArr[i11] == -2) {
            this.f68469a[i11] = a.f68472a;
        }
    }

    public final void f(Object obj) {
        int[] iArr = this.f68470b;
        int i11 = this.f68471c;
        if (iArr[i11] != -2) {
            int i12 = i11 + 1;
            this.f68471c = i12;
            if (i12 == this.f68469a.length) {
                e();
            }
        }
        Object[] objArr = this.f68469a;
        int i13 = this.f68471c;
        objArr[i13] = obj;
        this.f68470b[i13] = -2;
    }

    public final void g(int i11) {
        this.f68470b[this.f68471c] = i11;
    }

    public String toString() {
        return a();
    }
}
