package com.bytedance.adsdk.ugeno.uA.HiB;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.sP.TKC;

/* loaded from: classes2.dex */
public class sP extends TKC<Sj> {
    private int AVc;
    private float RrR;
    private float SP;
    private int Sj;
    private float dLt;
    private static final int zwV = Color.parseColor("#FFC642");
    private static final int Xqg = Color.parseColor("#e3e3e4");

    public sP(Context context) {
        super(context);
        this.Sj = zwV;
        this.AVc = Xqg;
        this.RrR = 4.0f;
        this.SP = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(String str, String str2) {
        super.Sj(str, str2);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1810866385:
                if (str.equals("highLightColor")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1804390815:
                if (str.equals("lowLightColor")) {
                    c11 = 1;
                    break;
                }
                break;
            case 102102:
                if (str.equals("gap")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c11 = 3;
                    break;
                }
                break;
            case 109264530:
                if (str.equals("score")) {
                    c11 = 4;
                    break;
                }
                break;
            case 490636047:
                if (str.equals("highlightColor")) {
                    c11 = 5;
                    break;
                }
                break;
            case 497111617:
                if (str.equals("lowlightColor")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 5:
                this.Sj = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                return;
            case 1:
            case 6:
                this.AVc = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2, Xqg);
                return;
            case 2:
                this.dLt = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case 3:
                this.SP = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 20.0f);
                return;
            case 4:
                this.RrR = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 4.0f);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public Sj Sj() {
        Sj sj2 = new Sj(this.sP);
        sj2.Sj(this);
        return sj2;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        if (LD()) {
            ((Sj) this.HiB).Sj(this.RrR, this.Sj, this.AVc, this.SP, (int) this.dLt);
        } else {
            ((Sj) this.HiB).Sj(this.RrR, this.Sj, this.AVc, this.SP, 5);
        }
    }
}
