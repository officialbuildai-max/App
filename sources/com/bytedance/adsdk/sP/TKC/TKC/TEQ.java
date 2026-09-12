package com.bytedance.adsdk.sP.TKC.TKC;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes2.dex */
public class TEQ extends EjP {
    private Path Dq;
    private int TEQ;
    private int uA;

    public TEQ(com.bytedance.adsdk.sP.uA uAVar, HiB hiB, Context context) {
        super(uAVar, hiB);
        this.Dq = null;
        this.uA = -1;
        this.TEQ = -1;
        if (((EjP) this).Jcg != null) {
            float Sj = com.bytedance.adsdk.sP.vS.vS.Sj();
            this.uA = (int) (((EjP) this).Jcg.Sj() * Sj);
            this.TEQ = (int) (((EjP) this).Jcg.sP() * Sj);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.uA, this.TEQ);
            Path path = new Path();
            this.Dq = path;
            float f11 = Sj * 40.0f;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        }
    }

    private static void Sj(View view, int i11, int i12) {
        view.layout(0, 0, i11, i12);
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.EjP, com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void sP(Canvas canvas, Matrix matrix, int i11) {
        View Sj = this.sP.Sj();
        if (this.uA <= 0 || Sj == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Sj(i11);
        float vS = vS();
        Sj(Sj, this.uA, this.TEQ);
        Sj.setAlpha(vS);
        canvas.clipPath(this.Dq);
        Sj.draw(canvas);
        canvas.restore();
    }
}
