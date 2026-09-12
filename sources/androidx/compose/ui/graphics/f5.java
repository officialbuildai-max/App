package androidx.compose.ui.graphics;

/* loaded from: classes.dex */
public abstract class f5 {
    public static final long a(float f11, float f12) {
        return e5.b((Float.floatToRawIntBits(f12) & 4294967295L) | (Float.floatToRawIntBits(f11) << 32));
    }
}
