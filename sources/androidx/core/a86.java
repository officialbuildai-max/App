package androidx.core;

import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.appcompat.C0068;
import androidx.core.fragmentapp.C0070;

/* loaded from: classes7.dex */
class a86 implements CompoundButton.OnCheckedChangeListener {
    private final yke a14;
    private final Switch a15;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a86(yke ykeVar, Switch r53) {
        this.a14 = ykeVar;
        this.a15 = r53;
    }

    static yke a15(a86 a86Var) {
        return m202(a86Var);
    }

    /* renamed from: ۟۟ۡۧ۟, reason: not valid java name and contains not printable characters */
    public static Switch m200(Object obj) {
        if (C0077.m370() > 0) {
            return ((a86) obj).a15;
        }
        return null;
    }

    /* renamed from: ۟۠ۢ۠ۦ, reason: not valid java name and contains not printable characters */
    public static void m201(Object obj, boolean z10) {
        if (C0077.m370() >= 0) {
            yke.access$S1000000((yke) obj, z10);
        }
    }

    /* renamed from: ۣ۟ۤۨۥ, reason: not valid java name and contains not printable characters */
    public static yke m202(Object obj) {
        if (C0070.m297() <= 0) {
            return ((a86) obj).a14;
        }
        return null;
    }

    /* renamed from: ۣۦۨۢ, reason: not valid java name and contains not printable characters */
    public static void m203(Object obj, Object obj2, boolean z10) {
        if (C0068.m249() <= 0) {
            yke.access$1000008((yke) obj, (Switch) obj2, z10);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        m201(m202(this), z10);
        m203(m202(this), m200(this), z10);
    }
}
