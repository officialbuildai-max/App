package com.bytedance.adsdk.ugeno.uA.Sj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.HiB;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.Jcg.EjP;
import com.bytedance.adsdk.ugeno.Jcg.Sj;
import com.bytedance.adsdk.ugeno.Sj;
import com.bytedance.adsdk.ugeno.sP.TKC;
import com.bytedance.adsdk.ugeno.uA.vS.sP;

/* loaded from: classes2.dex */
public class Sj extends sP {
    private boolean GMp;
    private boolean Ph;
    private String SP;
    private String Xqg;
    private String dLt;

    /* renamed from: gq, reason: collision with root package name */
    private int f20924gq;

    /* renamed from: mj, reason: collision with root package name */
    private Sj.C0207Sj f20925mj;
    private int oWa;
    private String zwV;

    public Sj(Context context) {
        super(context);
        this.dLt = "row";
    }

    private void EjP() {
        if (TextUtils.isEmpty(this.SP)) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setCompoundDrawables(null, null, null, null);
        if (!this.SP.startsWith("local://")) {
            HiB.Sj().sP().Sj(this.uA, this.SP, new Sj.InterfaceC0208Sj() { // from class: com.bytedance.adsdk.ugeno.uA.Sj.Sj.1
                @Override // com.bytedance.adsdk.ugeno.Sj.InterfaceC0208Sj
                public void Sj(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    Dq.Sj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.uA.Sj.Sj.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Sj.this.sP(new BitmapDrawable(((TKC) Sj.this).sP.getResources(), bitmap));
                        }
                    });
                }
            });
            return;
        }
        try {
            String replace = this.SP.replace("local://", "");
            Context context = this.sP;
            sP(Dq.Sj(context, EjP.Sj(context, replace)));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void sP(Drawable drawable) {
        char c11;
        if (drawable == null) {
            return;
        }
        String str = this.dLt;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 113114:
                if (str.equals("row")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        if (c11 == 0) {
            ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (c11 == 1) {
            ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (c11 != 2) {
            ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Ei() {
        super.Ei();
        if (this.Ph) {
            ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setTextColor(((sP) this).AVc);
        }
        if (this.GMp) {
            if (this.nP) {
                Sj(this.liH);
            } else {
                EjP(this.Wjd);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.uA.vS.sP, com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(String str, String str2) {
        super.Sj(str, str2);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -962590849:
                if (str.equals("direction")) {
                    c11 = 0;
                    break;
                }
                break;
            case -808924190:
                if (str.equals("highlightTextColor")) {
                    c11 = 1;
                    break;
                }
                break;
            case -104120541:
                if (str.equals("highlightedTextColor")) {
                    c11 = 2;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c11 = 3;
                    break;
                }
                break;
            case 496106759:
                if (str.equals("highlightImage")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1126933377:
                if (str.equals("highlightBackgroundColor")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1132404089:
                if (str.equals("highlightBackgroundImage")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.dLt = str2;
                return;
            case 1:
            case 2:
                this.f20924gq = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                this.Ph = true;
                return;
            case 3:
                this.SP = str2;
                return;
            case 4:
                this.zwV = str2;
                return;
            case 5:
                if (com.bytedance.adsdk.ugeno.Jcg.Sj.TKC(str2)) {
                    this.nP = true;
                    this.f20925mj = com.bytedance.adsdk.ugeno.Jcg.Sj.sP(str2);
                } else {
                    this.oWa = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                    this.nP = false;
                }
                this.GMp = true;
                return;
            case 6:
                this.Xqg = str2;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void jb() {
        super.jb();
        if (this.Ph) {
            ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setTextColor(this.f20924gq);
        }
        if (this.GMp) {
            if (this.nP) {
                Sj(this.f20925mj);
            } else {
                EjP(this.oWa);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.uA.vS.sP, com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        EjP();
        ((com.bytedance.adsdk.ugeno.uA.vS.Sj) this.HiB).setGravity(17);
    }
}
