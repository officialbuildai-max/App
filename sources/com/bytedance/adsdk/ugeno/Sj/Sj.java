package com.bytedance.adsdk.ugeno.Sj;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;

/* loaded from: classes2.dex */
public class Sj {
    private Context EjP;
    private int HiB;
    private com.bytedance.adsdk.ugeno.sP.TKC Sj;
    private ValueAnimator TKC;
    private sP sP;
    private com.bytedance.adsdk.ugeno.Sj.Sj.Sj vS;

    public Sj(Context context, com.bytedance.adsdk.ugeno.sP.TKC tkc, sP sPVar) {
        this.Sj = tkc;
        this.sP = sPVar;
        this.EjP = context;
    }

    public void Sj() {
        ValueAnimator valueAnimator = this.TKC;
        if (valueAnimator == null || this.HiB == -2) {
            return;
        }
        valueAnimator.start();
    }

    public void Sj(int i11, int i12) {
        com.bytedance.adsdk.ugeno.Sj.Sj.Sj sj2 = this.vS;
        if (sj2 != null) {
            sj2.Sj(i11, i12);
        }
    }

    public void Sj(Canvas canvas) {
        com.bytedance.adsdk.ugeno.Sj.Sj.Sj sj2 = this.vS;
        if (sj2 != null) {
            sj2.Sj(canvas);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        switch(r7) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            default: goto L32;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        if (r6 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r3.addAll(r6.HiB());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
    
        r6 = new com.bytedance.adsdk.ugeno.Sj.sP.EjP(r9.EjP, r9.Sj, r5, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r6 = new com.bytedance.adsdk.ugeno.Sj.sP.sP(r9.EjP, r9.Sj, r5, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        r6 = new com.bytedance.adsdk.ugeno.Sj.sP.TKC(r9.EjP, r9.Sj, r5, r4.getValue());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.ValueAnimator TKC() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.Sj.Sj.TKC():android.animation.ValueAnimator");
    }

    public void sP() {
        ValueAnimator valueAnimator = this.TKC;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void sP(Canvas canvas) {
        com.bytedance.adsdk.ugeno.Sj.Sj.Sj sj2 = this.vS;
        if (sj2 != null) {
            sj2.sP(canvas);
        }
    }
}
