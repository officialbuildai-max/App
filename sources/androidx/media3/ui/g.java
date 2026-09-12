package androidx.media3.ui;

import android.graphics.Color;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class g {
    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String b(int i11) {
        return androidx.media3.common.util.a1.G("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i11)), Integer.valueOf(Color.green(i11)), Integer.valueOf(Color.blue(i11)), Double.valueOf(Color.alpha(i11) / 255.0d));
    }
}
