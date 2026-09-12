package androidx.compose.animation.core;

/* loaded from: classes.dex */
public abstract /* synthetic */ class r {
    public static /* synthetic */ int a(double d11) {
        long doubleToLongBits = Double.doubleToLongBits(d11);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
