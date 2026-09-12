package com.bytedance.adsdk.sP.TKC.TKC;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public class EjP extends Sj {
    private final Paint Dq;
    protected final com.bytedance.adsdk.sP.TEQ Jcg;
    private final Rect TEQ;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<ColorFilter, ColorFilter> Ym;

    /* renamed from: aa, reason: collision with root package name */
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Bitmap, Bitmap> f20860aa;
    private final Rect uA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EjP(com.bytedance.adsdk.sP.uA uAVar, HiB hiB) {
        super(uAVar, hiB);
        this.Dq = new com.bytedance.adsdk.sP.Sj.Sj(3);
        this.uA = new Rect();
        this.TEQ = new Rect();
        this.Jcg = uAVar.vS(hiB.Jcg());
    }

    private Bitmap aa() {
        Bitmap Jcg;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Bitmap, Bitmap> sj2 = this.f20860aa;
        if (sj2 != null && (Jcg = sj2.Jcg()) != null) {
            return Jcg;
        }
        Bitmap HiB = this.sP.HiB(this.TKC.Jcg());
        if (HiB != null) {
            return HiB;
        }
        com.bytedance.adsdk.sP.TEQ teq = this.Jcg;
        if (teq != null) {
            return teq.Ym();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj, com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        super.Sj(rectF, matrix, z10);
        if (this.Jcg != null) {
            float Sj = com.bytedance.adsdk.sP.vS.vS.Sj();
            rectF.set(0.0f, 0.0f, this.Jcg.Sj() * Sj, this.Jcg.sP() * Sj);
            this.Sj.mapRect(rectF);
        }
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void sP(Canvas canvas, Matrix matrix, int i11) {
        super.sP(canvas, matrix, i11);
        Bitmap aa2 = aa();
        if (aa2 == null || aa2.isRecycled() || this.Jcg == null) {
            return;
        }
        float Sj = com.bytedance.adsdk.sP.vS.vS.Sj();
        this.Dq.setAlpha(i11);
        com.bytedance.adsdk.sP.Sj.sP.Sj<ColorFilter, ColorFilter> sj2 = this.Ym;
        if (sj2 != null) {
            this.Dq.setColorFilter(sj2.Jcg());
        }
        canvas.save();
        canvas.concat(matrix);
        this.uA.set(0, 0, aa2.getWidth(), aa2.getHeight());
        if (this.sP.HiB()) {
            this.TEQ.set(0, 0, (int) (this.Jcg.Sj() * Sj), (int) (this.Jcg.sP() * Sj));
        } else {
            this.TEQ.set(0, 0, (int) (aa2.getWidth() * Sj), (int) (aa2.getHeight() * Sj));
        }
        canvas.drawBitmap(aa2, this.uA, this.TEQ, this.Dq);
        canvas.restore();
    }
}
