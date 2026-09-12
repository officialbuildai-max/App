package i00;

/* loaded from: classes7.dex */
public class a {
    public static int a(float f11, int i11, int i12) {
        return ((((i11 >> 24) & 255) + ((int) ((((i12 >> 24) & 255) - r0) * f11))) << 24) | ((((i11 >> 16) & 255) + ((int) ((((i12 >> 16) & 255) - r1) * f11))) << 16) | ((((i11 >> 8) & 255) + ((int) ((((i12 >> 8) & 255) - r2) * f11))) << 8) | ((i11 & 255) + ((int) (f11 * ((i12 & 255) - r7))));
    }
}
