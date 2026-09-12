package com.airbnb.lottie;

/* loaded from: classes.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17784a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f17784a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17784a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17784a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean useSoftwareRendering(int i11, boolean z10, int i12) {
        int i13 = a.f17784a[ordinal()];
        if (i13 == 1) {
            return false;
        }
        if (i13 != 2) {
            return (z10 && i11 < 28) || i12 > 4 || i11 <= 25;
        }
        return true;
    }
}
