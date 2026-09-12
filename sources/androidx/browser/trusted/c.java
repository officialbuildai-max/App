package androidx.browser.trusted;

import android.os.IBinder;
import d.a;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final d.a f2281a;

    private c(d.a aVar) {
        this.f2281a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(IBinder iBinder) {
        d.a Y0 = iBinder == null ? null : a.AbstractBinderC0749a.Y0(iBinder);
        if (Y0 == null) {
            return null;
        }
        return new c(Y0);
    }
}
