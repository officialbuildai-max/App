package ya;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f79079a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f79080b = {R.attr.state_pressed};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f79081c = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f79082d = {R.attr.state_focused};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f79083e = {R.attr.state_hovered};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f79084f = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f79085g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f79086h = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f79087i = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f79088j = {R.attr.state_selected};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f79089k = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: l, reason: collision with root package name */
    static final String f79090l = b.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f79079a) {
            int[] iArr = f79082d;
            return new ColorStateList(new int[][]{f79088j, iArr, StateSet.NOTHING}, new int[]{c(colorStateList, f79084f), c(colorStateList, iArr), c(colorStateList, f79080b)});
        }
        int[] iArr2 = f79084f;
        int[] iArr3 = f79085g;
        int[] iArr4 = f79086h;
        int[] iArr5 = f79087i;
        int[] iArr6 = f79080b;
        int[] iArr7 = f79081c;
        int[] iArr8 = f79082d;
        int[] iArr9 = f79083e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f79088j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), c(colorStateList, iArr5), 0, c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), c(colorStateList, iArr9), 0});
    }

    private static int b(int i11) {
        return z0.b.p(i11, Math.min(Color.alpha(i11) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f79079a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f79089k, 0)) != 0) {
            Log.w(f79090l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 : iArr) {
            if (i11 == 16842910) {
                z10 = true;
            } else if (i11 == 16842908 || i11 == 16842919 || i11 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
