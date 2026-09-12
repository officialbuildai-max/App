package com.bytedance.adsdk.sP.TKC.TKC;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.sP.TKC.sP.uvD;
import java.util.Collections;

/* loaded from: classes2.dex */
public class Jcg extends Sj {
    private final sP Dq;
    private final com.bytedance.adsdk.sP.Sj.Sj.EjP Jcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Jcg(com.bytedance.adsdk.sP.uA uAVar, HiB hiB, sP sPVar, com.bytedance.adsdk.sP.Jcg jcg) {
        super(uAVar, hiB);
        this.Dq = sPVar;
        com.bytedance.adsdk.sP.Sj.Sj.EjP ejP = new com.bytedance.adsdk.sP.Sj.Sj.EjP(uAVar, this, new uvD("__container", hiB.sef(), false), jcg);
        this.Jcg = ejP;
        ejP.Sj(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj, com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        super.Sj(rectF, matrix, z10);
        this.Jcg.Sj(rectF, this.Sj, z10);
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public com.bytedance.adsdk.sP.TKC.sP.Sj TEQ() {
        com.bytedance.adsdk.sP.TKC.sP.Sj TEQ = super.TEQ();
        return TEQ != null ? TEQ : this.Dq.TEQ();
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public com.bytedance.adsdk.sP.HiB.TEQ Ym() {
        com.bytedance.adsdk.sP.HiB.TEQ Ym = super.Ym();
        return Ym != null ? Ym : this.Dq.Ym();
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void sP(Canvas canvas, Matrix matrix, int i11) {
        super.sP(canvas, matrix, i11);
        this.Jcg.Sj(canvas, matrix, i11);
    }
}
