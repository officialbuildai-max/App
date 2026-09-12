package androidx.core;

import android.view.View;
import androidx.core.appcompat.C0068;
import androidx.core.fragmentapp.C0071;

/* loaded from: classes7.dex */
class a76 implements View.OnClickListener {
    private final yke a14;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a76(yke ykeVar) {
        this.a14 = ykeVar;
    }

    static yke a15(a76 a76Var) {
        return m195(a76Var);
    }

    /* renamed from: ۟ۤۨۡۢ, reason: not valid java name and contains not printable characters */
    public static void m194(Object obj, Object obj2) {
        if (C0071.m301() < 0) {
            yke.access$1000006((yke) obj, (String) obj2);
        }
    }

    /* renamed from: ۡۨۦۢ, reason: not valid java name and contains not printable characters */
    public static yke m195(Object obj) {
        if (C0068.m249() < 0) {
            return ((a76) obj).a14;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m194(m195(this), C0071.m331());
    }
}
