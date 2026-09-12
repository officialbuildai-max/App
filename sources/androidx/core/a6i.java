package androidx.core;

import android.view.View;
import androidx.core.appcompat.C0068;
import androidx.core.fragmentapp.C0070;
import androidx.core.fragmentapp.C0071;

/* loaded from: classes7.dex */
class a6i implements View.OnClickListener {
    private final yke a14;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a6i(yke ykeVar) {
        this.a14 = ykeVar;
    }

    static yke a15(a6i a6iVar) {
        return m192(a6iVar);
    }

    /* renamed from: ۠ۦۡۧ, reason: not valid java name and contains not printable characters */
    public static yke m192(Object obj) {
        if (C0068.m249() <= 0) {
            return ((a6i) obj).a14;
        }
        return null;
    }

    /* renamed from: ۢۨۨۥ, reason: not valid java name and contains not printable characters */
    public static void m193(Object obj) {
        if (C0070.m297() < 0) {
            yke.access$1000007((yke) obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m193(m192(this));
        C0071.m300(m192(this));
    }
}
