package com.bytedance.adsdk.ugeno.Sj.Sj;

import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.Jcg.Sj;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EjP extends Sj {
    private static final float Zq;
    private static final float dNu;
    private static final float sef;
    private static final float uvD;
    private int Dq;
    private Paint EjP;
    private Path Fmk;
    private Path HiB;
    private int Jcg;
    private int TEQ;
    private int TKC;
    private float TzV;
    private int Ym;

    /* renamed from: aa, reason: collision with root package name */
    private boolean f20895aa;
    private float uA;
    private Sj.C0207Sj vS;

    static {
        float radians = (float) Math.toRadians(30.0d);
        sef = radians;
        Zq = (float) Math.tan(radians);
        uvD = (float) Math.cos(radians);
        dNu = (float) Math.sin(radians);
    }

    public EjP(com.bytedance.adsdk.ugeno.sP.TKC tkc, JSONObject jSONObject) {
        super(tkc, jSONObject);
        this.f20895aa = true;
        Paint paint = new Paint();
        this.EjP = paint;
        paint.setAntiAlias(true);
        this.HiB = new Path();
        this.uA = this.sP.zR();
        this.Fmk = new Path();
    }

    private void TKC(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.sP.db() > 0.0f) {
                int i11 = this.TEQ;
                float f11 = Zq;
                float db2 = (i11 + (i11 * f11)) * this.sP.db();
                this.Fmk.reset();
                this.Fmk.moveTo(db2, 0.0f);
                int i12 = this.Ym;
                float f12 = db2 - (i12 * f11);
                this.Fmk.lineTo(f12, i12);
                this.Fmk.lineTo(f12 + this.TKC, this.Ym);
                this.Fmk.lineTo(this.TKC + db2, 0.0f);
                this.Fmk.close();
                float f13 = this.TzV;
                float f14 = uvD * f13;
                float f15 = f13 * dNu;
                if (!this.f20895aa || this.vS == null) {
                    float f16 = db2 + f14;
                    int i13 = this.Dq;
                    linearGradient = new LinearGradient(db2, 0.0f, f16, f15, new int[]{i13, this.Jcg, i13}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(db2, 0.0f, db2 + f14, f15, this.vS.sP, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.EjP.setShader(linearGradient);
                Path path = this.HiB;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.Fmk, this.EjP);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public void Sj(int i11, int i12) {
        this.TEQ = i11;
        this.Ym = i12;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i11, i12);
            Path path = this.HiB;
            float f11 = this.uA;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    @SuppressLint({"DrawAllocation"})
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
        this.TKC = (int) Dq.Sj(this.sP.Ym().getContext(), this.Sj.optInt("shineWidth", 30));
        String optString = this.Sj.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(optString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : optString;
        if (str.startsWith("linear")) {
            this.vS = com.bytedance.adsdk.ugeno.Jcg.Sj.sP(str);
        } else {
            int Sj = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str);
            this.Jcg = Sj;
            this.Dq = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(Sj, 32);
            this.f20895aa = false;
        }
        this.TzV = uvD * this.TKC;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.Sj.Sj
    public void sP(Canvas canvas) {
        TKC(canvas);
    }
}
