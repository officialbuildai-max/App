package androidx.compose.ui.platform;

import android.os.Looper;

/* loaded from: classes.dex */
public abstract class j0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
