package androidx.core;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.appcompat.C0067;
import androidx.core.appcompat.C0068;
import androidx.core.fragmentapp.C0071;

/* loaded from: classes7.dex */
class a80 implements DialogInterface.OnShowListener {
    private final yke a14;
    private final AlertDialog a15;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a80(yke ykeVar, AlertDialog alertDialog) {
        this.a14 = ykeVar;
        this.a15 = alertDialog;
    }

    static yke a15(a80 a80Var) {
        return m199(a80Var);
    }

    /* renamed from: ۣۡۥ۟, reason: not valid java name and contains not printable characters */
    public static AlertDialog m197(Object obj) {
        if (C0077.m370() > 0) {
            return ((a80) obj).a15;
        }
        return null;
    }

    /* renamed from: ۥۡ۟ۨ, reason: contains not printable characters */
    public static Drawable m198(Object obj) {
        if (C0071.m301() <= 0) {
            return yke.access$1000012((yke) obj);
        }
        return null;
    }

    /* renamed from: ۨ۟ۧۡ, reason: not valid java name and contains not printable characters */
    public static yke m199(Object obj) {
        if (C0068.m249() < 0) {
            return ((a80) obj).a14;
        }
        return null;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Window m216 = C0067.m216(m197(this));
        if (m216 != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            C0077.m362(layoutParams, C0077.m352(m216));
            ((ViewGroup.LayoutParams) layoutParams).width = (int) (C0068.m262(C0067.m237(C0077.m384(m199(this)))) * 0.8d);
            C0071.m305(m216, layoutParams);
            C0071.m312(m216, m198(m199(this)));
        }
    }
}
