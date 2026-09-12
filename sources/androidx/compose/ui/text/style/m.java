package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6500c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final m f6501d = new m(1.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    private final float f6502a;

    /* renamed from: b, reason: collision with root package name */
    private final float f6503b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a() {
            return m.f6501d;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.style.m.<init>():void");
    }

    public m(float f11, float f12) {
        this.f6502a = f11;
        this.f6503b = f12;
    }

    public /* synthetic */ m(float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 0.0f : f12);
    }

    public final float b() {
        return this.f6502a;
    }

    public final float c() {
        return this.f6503b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f6502a == mVar.f6502a && this.f6503b == mVar.f6503b;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f6502a) * 31) + Float.floatToIntBits(this.f6503b);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.f6502a + ", skewX=" + this.f6503b + ')';
    }
}
