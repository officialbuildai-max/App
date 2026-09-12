package com.bytedance.sdk.component.adexpress.dynamic.TKC.Sj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public class TKC implements View.OnTouchListener {
    private boolean Dq;
    private float EjP;
    private boolean HiB;
    private int Jcg;
    private float Sj;
    private float TKC;
    private float sP;
    private boolean uA;
    private com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq vS;

    public TKC(com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq2) {
        this(dq2, 5);
    }

    public TKC(com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq2, int i11) {
        this.Jcg = 5;
        this.Dq = true;
        this.vS = dq2;
        if (i11 > 0) {
            this.Jcg = i11;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq2;
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq3;
        com.bytedance.sdk.component.adexpress.dynamic.TKC.Dq dq4;
        if (this.uA) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Sj = motionEvent.getX();
            this.sP = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.EjP = motionEvent.getX();
                this.TKC = motionEvent.getY();
                if (Math.abs(this.EjP - this.Sj) > 10.0f) {
                    this.HiB = true;
                }
                if (Math.abs(this.EjP - this.Sj) > 8.0f || Math.abs(this.TKC - this.sP) > 8.0f) {
                    this.Dq = false;
                }
                int sP = com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), Math.abs(this.EjP - this.Sj));
                if (this.EjP > this.Sj && sP > this.Jcg && (dq4 = this.vS) != null) {
                    dq4.Sj();
                    this.uA = true;
                }
            }
        } else {
            if (!this.HiB && !this.Dq) {
                return false;
            }
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int sP2 = com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), Math.abs(this.EjP - this.Sj));
            if (this.EjP > this.Sj && sP2 > this.Jcg && (dq3 = this.vS) != null) {
                dq3.Sj();
                this.uA = true;
            }
            float abs = Math.abs(x10 - this.Sj);
            float abs2 = Math.abs(y10 - this.sP);
            if ((abs < 8.0f || abs2 < 8.0f) && (dq2 = this.vS) != null) {
                dq2.sP();
                this.uA = true;
            }
        }
        return true;
    }
}
