package ab;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.f0;

/* loaded from: classes4.dex */
public abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(int i11) {
        return i11 != 0 ? i11 != 1 ? b() : new f() : new m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        return new m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g c() {
        return new g();
    }

    public static void d(View view, float f11) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            ((i) background).c0(f11);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            f(view, (i) background);
        }
    }

    public static void f(View view, i iVar) {
        if (iVar.U()) {
            iVar.h0(f0.n(view));
        }
    }
}
