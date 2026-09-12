package com.bytedance.adsdk.ugeno.Sj.Sj;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sP extends Sj {
    private static final int Jcg = Color.parseColor("#7ed321");
    private int EjP;
    private int HiB;
    private int TKC;
    private Paint vS;

    public sP(com.bytedance.adsdk.ugeno.sP.TKC tkc, JSONObject jSONObject) {
        super(tkc, jSONObject);
        Paint paint = new Paint();
        this.vS = paint;
        paint.setAntiAlias(true);
    }

    private void TKC(Canvas canvas) {
        try {
            if (this.sP.xhi() > 0.0f) {
                this.vS.setColor(this.TKC);
                this.vS.setAlpha((int) ((1.0f - this.sP.xhi()) * 255.0f));
                ((ViewGroup) this.sP.Ym().getParent()).setClipChildren(true);
                canvas.drawCircle(this.EjP, this.HiB, Math.min(r0, r2) * 2 * this.sP.xhi(), this.vS);
            }
        } catch (Throwable th2) {
            new StringBuilder("ripple animation error ").append(th2.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public void Sj(int i11, int i12) {
        this.EjP = i11 / 2;
        this.HiB = i12 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public void Sj(Canvas canvas) {
        TKC(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public List<PropertyValuesHolder> TKC() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(EjP(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public void sP() {
        this.TKC = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(this.Sj.optString("backgroundColor"), Jcg);
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public void sP(Canvas canvas) {
        TKC(canvas);
    }
}
