package com.bytedance.adsdk.ugeno.core.sP;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.core.TEQ;
import com.bytedance.adsdk.ugeno.core.aa;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public class EjP {
    private boolean Dq;
    private TEQ EjP;
    private TEQ HiB;
    private Context Jcg;
    private String vS;
    private float Sj = Float.MIN_VALUE;
    private float sP = Float.MIN_VALUE;
    private int TKC = 0;

    public EjP(Context context, TEQ teq, TEQ teq2, boolean z10) {
        this.Jcg = context;
        this.EjP = teq;
        this.HiB = teq2;
        this.Dq = z10;
        sP();
    }

    public EjP(Context context, TEQ teq, boolean z10) {
        this.Jcg = context;
        this.EjP = teq;
        this.Dq = z10;
        sP();
    }

    private void sP() {
        TEQ teq = this.EjP;
        if (teq == null) {
            return;
        }
        this.TKC = teq.TKC().optInt("slideThreshold");
        this.vS = this.EjP.TKC().optString("slideDirection");
    }

    public void Sj() {
        this.Sj = Float.MIN_VALUE;
        this.sP = Float.MIN_VALUE;
    }

    public boolean Sj(aa aaVar, com.bytedance.adsdk.ugeno.sP.TKC tkc, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    if (this.Sj == Float.MIN_VALUE || this.sP == Float.MIN_VALUE) {
                        return false;
                    }
                }
            }
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (this.Dq && Math.abs(x10 - this.Sj) <= 10.0f && Math.abs(y10 - this.sP) <= 10.0f && aaVar != null) {
                Sj();
                aaVar.Sj(this.HiB, tkc, tkc);
                return true;
            }
            if (this.TKC == 0 && aaVar != null) {
                Sj();
                aaVar.Sj(this.EjP, tkc, tkc);
                return true;
            }
            int sP = Dq.sP(this.Jcg, x10 - this.Sj);
            int sP2 = Dq.sP(this.Jcg, y10 - this.sP);
            if (TextUtils.equals(this.vS, "up")) {
                sP = -sP2;
            } else if (TextUtils.equals(this.vS, "down")) {
                sP = sP2;
            } else if (TextUtils.equals(this.vS, TtmlNode.LEFT)) {
                sP = -sP;
            } else if (!TextUtils.equals(this.vS, TtmlNode.RIGHT)) {
                sP = (int) Math.abs(Math.sqrt(Math.pow(sP, 2.0d) + Math.pow(sP2, 2.0d)));
            }
            if (sP < this.TKC) {
                Sj();
                return false;
            }
            if (aaVar != null) {
                Sj();
                aaVar.Sj(this.EjP, tkc, tkc);
                return true;
            }
            Sj();
        } else {
            this.Sj = motionEvent.getX();
            this.sP = motionEvent.getY();
        }
        return true;
    }
}
