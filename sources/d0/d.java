package d0;

import android.view.KeyEvent;

/* loaded from: classes2.dex */
public abstract class d {
    public static final long a(KeyEvent keyEvent) {
        return f.a(keyEvent.getKeyCode());
    }

    public static final int b(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        return action != 0 ? action != 1 ? c.f61245a.c() : c.f61245a.b() : c.f61245a.a();
    }

    public static final boolean c(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    public static final boolean d(KeyEvent keyEvent) {
        return keyEvent.isShiftPressed();
    }
}
