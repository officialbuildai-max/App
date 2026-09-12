package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class HiB extends FrameLayout implements IAnimation, Mts, WMZ {
    protected int Dq;
    protected float EjP;
    protected com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Fmk;
    protected float HiB;
    protected int Jcg;
    private float RiZ;
    private float Sj;
    protected int TEQ;
    protected float TKC;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.TKC TzV;
    protected Context Ym;
    protected View Zq;

    /* renamed from: aa, reason: collision with root package name */
    protected com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg f20971aa;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.sP dNu;

    /* renamed from: dx, reason: collision with root package name */
    private com.bytedance.sdk.component.utils.kF f20972dx;
    private float sP;
    private float sU;
    protected DynamicRootView sef;
    protected int uA;
    protected boolean uvD;
    protected float vS;
    private static final View.OnTouchListener zR = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    /* renamed from: ib, reason: collision with root package name */
    private static final View.OnClickListener f20970ib = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    public HiB(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context);
        this.Ym = context;
        this.sef = dynamicRootView;
        this.Fmk = dq2;
        this.TKC = dq2.vS();
        this.EjP = dq2.Jcg();
        this.HiB = dq2.Dq();
        this.vS = dq2.uA();
        this.uA = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.TKC);
        this.TEQ = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.EjP);
        this.Jcg = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.HiB);
        this.Dq = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.vS);
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg = new com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg(dq2.TEQ());
        this.f20971aa = jcg;
        if (jcg.TzV() > 0) {
            this.Jcg += this.f20971aa.TzV() * 2;
            this.Dq += this.f20971aa.TzV() * 2;
            this.uA -= this.f20971aa.TzV();
            this.TEQ -= this.f20971aa.TzV();
            List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> Ym = dq2.Ym();
            if (Ym != null) {
                for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3 : Ym) {
                    dq3.TKC(dq3.vS() + com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(this.Ym, this.f20971aa.TzV()));
                    dq3.EjP(dq3.Jcg() + com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(this.Ym, this.f20971aa.TzV()));
                    dq3.Sj(com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(this.Ym, this.f20971aa.TzV()));
                    dq3.sP(com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(this.Ym, this.f20971aa.TzV()));
                }
            }
        }
        this.uvD = this.f20971aa.sef() > 0.0d;
        this.TzV = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.TKC();
    }

    private void Sj() {
        if (isShown()) {
            int Sj = com.bytedance.sdk.component.adexpress.dynamic.sP.Sj.Sj(this.f20971aa);
            if (Sj == 2) {
                if (this.f20972dx == null) {
                    this.f20972dx = new com.bytedance.sdk.component.utils.kF(getContext().getApplicationContext(), 1);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB.4
                };
                com.bytedance.sdk.component.adexpress.sP.Fmk renderRequest = this.sef.getRenderRequest();
                if (renderRequest != null) {
                    renderRequest.Zq();
                    renderRequest.dx();
                    renderRequest.RiZ();
                    return;
                }
                return;
            }
            if (Sj == 3) {
                if (this.f20972dx == null) {
                    this.f20972dx = new com.bytedance.sdk.component.utils.kF(getContext().getApplicationContext(), 2);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB.5
                };
                com.bytedance.sdk.component.adexpress.sP.Fmk renderRequest2 = this.sef.getRenderRequest();
                if (renderRequest2 != null) {
                    renderRequest2.dNu();
                    renderRequest2.zR();
                    renderRequest2.TzV();
                    renderRequest2.sU();
                }
            }
        }
    }

    private Drawable[] Sj(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = split.length - 1;
                int[] iArr = new int[length];
                int i12 = 0;
                while (i12 < length) {
                    int i13 = i12 + 1;
                    iArr[i12] = com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg.Sj(split[i13].substring(0, 7));
                    i12 = i13;
                }
                GradientDrawable Sj = Sj(Sj(split[0]), iArr);
                Sj.setShape(0);
                Sj.setCornerRadius(com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.Zq()));
                drawableArr[(list.size() - 1) - i11] = Sj;
            }
        }
        return drawableArr;
    }

    private List<String> sP(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        for (int i13 = 0; i13 < str.length(); i13++) {
            if (str.charAt(i13) == '(') {
                i11++;
                z10 = true;
            } else if (str.charAt(i13) == ')' && i11 - 1 == 0 && z10) {
                int i14 = i13 + 1;
                arrayList.add(str.substring(i12, i14));
                i12 = i14;
                z10 = false;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Dq() {
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 = this.Fmk;
        return dq2 == null || dq2.TEQ() == null || this.Fmk.TEQ().HiB() == null || this.Fmk.TEQ().HiB().Xqg() == null;
    }

    protected boolean EjP() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.Zq;
        if (view == null) {
            view = this;
        }
        if (HiB()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = zR;
            onClickListener = f20970ib;
        }
        if (onTouchListener != null && onClickListener != null) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            int Sj = com.bytedance.sdk.component.adexpress.dynamic.sP.Sj.Sj(this.f20971aa);
            if (Sj == 2 || Sj == 3) {
                view.setOnClickListener(f20970ib);
            } else {
                view.setOnClickListener(onClickListener);
            }
        }
        Sj(view);
        sP(view);
        return true;
    }

    public boolean HiB() {
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg = this.f20971aa;
        return (jcg == null || jcg.ley() == 0) ? false : true;
    }

    public void Jcg() {
        if (Dq()) {
            return;
        }
        View view = this.Zq;
        if (view == null) {
            view = this;
        }
        this.dNu = new com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.sP(view, this.Fmk.TEQ().HiB().Xqg());
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.sP sPVar = HiB.this.dNu;
                if (sPVar != null) {
                    sPVar.Sj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable Sj(boolean z10, String str) {
        String[] split;
        int[] iArr;
        if (!TextUtils.isEmpty(this.f20971aa.FPG())) {
            try {
                String FPG = this.f20971aa.FPG();
                String substring = FPG.substring(FPG.indexOf("(") + 1, FPG.length() - 1);
                if (substring.contains("rgba") && substring.contains("%")) {
                    split = new String[]{substring.substring(0, substring.indexOf(",")).trim(), substring.substring(substring.indexOf(",") + 1, substring.indexOf("%") + 1).trim(), substring.substring(substring.indexOf("%") + 2).trim()};
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg.Sj(split[1]), com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg.Sj(split[2])};
                } else {
                    split = substring.split(", ");
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg.Sj(split[1].substring(0, 7)), com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg.Sj(split[2].substring(0, 7))};
                }
                try {
                    double parseDouble = Double.parseDouble(substring.substring(substring.indexOf("linear-gradient(") + 1, substring.indexOf("deg")));
                    if (parseDouble > 225.0d && parseDouble < 315.0d) {
                        int i11 = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i11;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable Sj = Sj(Sj(split[0]), iArr);
                Sj.setShape(0);
                Sj.setCornerRadius(com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.Zq()));
                return Sj;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float Sj2 = com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.Zq());
        drawable.setCornerRadius(Sj2);
        if (Sj2 < 1.0f) {
            float Sj3 = com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.LD());
            float Sj4 = com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.fF());
            float Sj5 = com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.JcM());
            float Sj6 = com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.WMZ());
            float[] fArr = new float[8];
            if (Sj3 > 0.0f) {
                fArr[0] = Sj3;
                fArr[1] = Sj3;
            }
            if (Sj4 > 0.0f) {
                fArr[2] = Sj4;
                fArr[3] = Sj4;
            }
            if (Sj5 > 0.0f) {
                fArr[4] = Sj5;
                fArr[5] = Sj5;
            }
            if (Sj6 > 0.0f) {
                fArr[6] = Sj6;
                fArr[7] = Sj6;
            }
            drawable.setCornerRadii(fArr);
        }
        drawable.setColor(z10 ? Color.parseColor(str) : this.f20971aa.LqL());
        if (this.f20971aa.dNu() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.dNu()), this.f20971aa.uvD());
        } else if (this.f20971aa.TzV() > 0) {
            drawable.setStroke(this.f20971aa.TzV(), this.f20971aa.uvD());
            drawable.setAlpha(50);
            if (TextUtils.equals(this.Fmk.TEQ().sP(), "video-vd")) {
                setLayerType(1, null);
                return new RiZ((int) Sj2, this.f20971aa.TzV());
            }
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GradientDrawable.Orientation Sj(String str) {
        try {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            return parseFloat <= 90 ? GradientDrawable.Orientation.LEFT_RIGHT : parseFloat <= 180 ? GradientDrawable.Orientation.TOP_BOTTOM : parseFloat <= 270 ? GradientDrawable.Orientation.RIGHT_LEFT : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GradientDrawable Sj(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length != 1) {
            return new GradientDrawable(orientation, iArr);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iArr[0]);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public sP Sj(Bitmap bitmap) {
        return new Sj(bitmap, null);
    }

    public void Sj(int i11) {
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg = this.f20971aa;
        if (jcg != null && jcg.Sj(i11)) {
            uA();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != null && (getChildAt(i12) instanceof HiB)) {
                    ((HiB) childAt).Sj(i11);
                }
            }
        }
    }

    protected void Sj(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.Fmk.Dq());
            jSONObject.put("height", this.Fmk.uA());
            if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.Sj.sU, this.f20971aa.Wjd());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.Sj.f20966dx, this.Fmk.TEQ().sP());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.Sj.zR, this.Fmk.TKC());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.Sj.f20967ib, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.f20971aa.Wjd());
            view.setTag(2097610715, this.Fmk.TEQ().sP());
            view.setTag(2097610714, this.Fmk.TKC());
            view.setTag(2097610713, jSONObject.toString());
            int Sj = com.bytedance.sdk.component.adexpress.dynamic.sP.Sj.Sj(this.f20971aa);
            if (Sj == 1) {
                view.setTag(2097610707, new Pair(this.f20971aa.uP(), Long.valueOf(this.f20971aa.wE())));
                view.setTag(2097610708, Integer.valueOf(Sj));
            }
        } catch (JSONException unused) {
        }
    }

    public boolean TKC() {
        uA();
        vS();
        EjP();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getBackgroundDrawable() {
        return Sj(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.uvD;
    }

    public int getClickArea() {
        return this.f20971aa.ley();
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.vS.Sj getDynamicClickListener() {
        return this.sef.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.Dq;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.EjP.vS getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB TEQ;
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 = this.Fmk;
        if (dq2 == null || (TEQ = dq2.TEQ()) == null) {
            return null;
        }
        return TEQ.HiB();
    }

    public int getDynamicWidth() {
        return this.Jcg;
    }

    public String getImageObjectFit() {
        return this.f20971aa.MuB();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.RiZ;
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(Sj(sP(this.f20971aa.FPG().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.Sj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.sP;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.sU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Jcg();
        Sj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        sP();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.TzV.Sj(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.TKC tkc = this.TzV;
        View view = this.Zq;
        if (view == null) {
            view = this;
        }
        tkc.Sj(view, i11, i12);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
    }

    public void sP() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.sP sPVar = this.dNu;
        if (sPVar != null) {
            sPVar.sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sP(@NonNull View view) {
        com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB;
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 = this.Fmk;
        if (dq2 == null || (HiB = dq2.TEQ().HiB()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(HiB.Aw()));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f11) {
        this.RiZ = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f11) {
        this.Sj = f11;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f11) {
        this.sP = f11;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z10) {
        this.uvD = z10;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f11) {
        this.sU = f11;
        this.TzV.Sj(this, f11);
    }

    public void vS() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Jcg, this.Dq);
        layoutParams.topMargin = this.TEQ;
        int i11 = this.uA;
        layoutParams.leftMargin = i11;
        layoutParams.setMarginStart(i11);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
