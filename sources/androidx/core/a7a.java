package androidx.core;

import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.core.fragmentapp.C0070;
import androidx.core.fragmentapp.C0071;

/* loaded from: classes7.dex */
class a7a implements DialogInterface.OnKeyListener {
    private final yke a14;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a7a(yke ykeVar) {
        this.a14 = ykeVar;
    }

    static yke a15(a7a a7aVar) {
        return m196(a7aVar);
    }

    /* renamed from: ۢۢ۟, reason: not valid java name and contains not printable characters */
    public static yke m196(Object obj) {
        if (C0070.m297() <= 0) {
            return ((a7a) obj).a14;
        }
        return null;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        return i11 == 4 && C0071.m316(keyEvent) == 1;
    }
}
