package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.transsion.gslb.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class vS extends HiB {
    private static String sU = "";
    protected com.bytedance.sdk.component.adexpress.dynamic.TKC.uA RiZ;
    private Runnable Sj;

    /* renamed from: dx, reason: collision with root package name */
    private volatile boolean f20978dx;
    private Runnable sP;

    /* loaded from: classes2.dex */
    private static class Sj implements com.bytedance.sdk.component.HiB.uvD<Bitmap> {
        private final WeakReference<View> Sj;
        private final com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq TKC;
        private final WeakReference<DynamicRootView> sP;

        public Sj(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
            this.Sj = new WeakReference<>(view);
            this.sP = new WeakReference<>(dynamicRootView);
            this.TKC = dq2;
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(int i11, String str, @Nullable Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(com.bytedance.sdk.component.HiB.Ym<Bitmap> ym2) {
            View view = this.Sj.get();
            if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
                DynamicRootView dynamicRootView = this.sP.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().EjP()) || "splash_ad".equals(dynamicRootView.getRenderRequest().EjP())) {
                    view.setBackground(new BitmapDrawable(ym2.sP()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(ym2.sP()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(ym2.sP()));
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 = this.TKC;
            if (dq2 == null || dq2.TEQ() == null || 6 != this.TKC.TEQ().Sj() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    /* loaded from: classes2.dex */
    private static class TKC implements com.bytedance.sdk.component.HiB.Dq {
        private final WeakReference<Context> Sj;
        private final int sP;

        public TKC(Context context, int i11) {
            this.Sj = new WeakReference<>(context);
            this.sP = i11;
        }

        @Override // com.bytedance.sdk.component.HiB.Dq
        public Bitmap Sj(Bitmap bitmap) {
            Context context = this.Sj.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.EjP.Sj.Sj(context, bitmap, this.sP);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private static class sP implements com.bytedance.sdk.component.HiB.uvD<Bitmap> {
        private final WeakReference<View> Sj;
        private final WeakReference<HiB> sP;

        public sP(View view, HiB hiB) {
            this.Sj = new WeakReference<>(view);
            this.sP = new WeakReference<>(hiB);
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(int i11, String str, @Nullable Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(com.bytedance.sdk.component.HiB.Ym<Bitmap> ym2) {
            Bitmap sP;
            HiB hiB;
            View view = this.Sj.get();
            if (view == null || (sP = ym2.sP()) == null || ym2.TKC() == null || (hiB = this.sP.get()) == null) {
                return;
            }
            view.setBackground(hiB.Sj(sP));
        }
    }

    public vS(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        this.f20978dx = true;
        setTag(Integer.valueOf(getClickArea()));
        String sP2 = dq2.TEQ().sP();
        if ("logo-union".equals(sP2)) {
            dynamicRootView.setLogoUnionHeight(this.Dq - ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(context, this.f20971aa.sP() + this.f20971aa.Sj())));
        } else if ("scoreCountWithIcon".equals(sP2)) {
            dynamicRootView.setScoreCountWithIcon(this.Dq - ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(context, this.f20971aa.sP() + this.f20971aa.Sj())));
        }
    }

    private String Sj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return Sj(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return Sj((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void Sj() {
        if (this.f20978dx) {
            int qRN = this.f20971aa.qRN();
            int UHs = this.f20971aa.UHs();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = vS.this.sef;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        vS vSVar = vS.this;
                        vS vSVar2 = vS.this;
                        vSVar.RiZ = new com.bytedance.sdk.component.adexpress.dynamic.TKC.uA(vSVar2.Ym, vSVar2, vSVar2.f20971aa);
                    } else {
                        com.bytedance.sdk.component.adexpress.sP.Fmk renderRequest = vS.this.sef.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.EjP.TEQ teq = new com.bytedance.sdk.component.adexpress.dynamic.EjP.TEQ();
                        teq.Sj(renderRequest.Zq());
                        teq.sP(renderRequest.uvD());
                        teq.TKC(renderRequest.dNu());
                        teq.Sj(renderRequest.TzV());
                        teq.sP(renderRequest.RiZ());
                        teq.TKC(renderRequest.sU());
                        teq.EjP(renderRequest.dx());
                        teq.HiB(renderRequest.zR());
                        vS vSVar3 = vS.this;
                        vS vSVar4 = vS.this;
                        vSVar3.RiZ = new com.bytedance.sdk.component.adexpress.dynamic.TKC.uA(vSVar4.Ym, vSVar4, vSVar4.f20971aa, teq, renderRequest);
                    }
                    vS vSVar5 = vS.this;
                    vSVar5.sP(vSVar5.RiZ);
                    if (vS.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) vS.this.getParent()).setClipChildren(false);
                    }
                    vS.this.setClipChildren(false);
                    vS.this.RiZ.setTag(2);
                    vS vSVar6 = vS.this;
                    vSVar6.Sj((ViewGroup) vSVar6);
                    vS vSVar7 = vS.this;
                    vSVar7.addView(vSVar7.RiZ, new FrameLayout.LayoutParams(-1, -1));
                    vS.this.RiZ.TKC();
                }
            };
            this.Sj = runnable;
            postDelayed(runnable, qRN * 1000);
            if (this.f20971aa.dwU() || UHs >= Integer.MAX_VALUE || qRN >= UHs) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS.5
                @Override // java.lang.Runnable
                public void run() {
                    vS vSVar = vS.this;
                    if (vSVar.RiZ != null) {
                        vSVar.f20978dx = false;
                        vS.this.RiZ.EjP();
                        vS.this.RiZ.setVisibility(4);
                        vS vSVar2 = vS.this;
                        vSVar2.removeView(vSVar2.RiZ);
                    }
                }
            };
            this.sP = runnable2;
            postDelayed(runnable2, UHs * 1000);
        }
    }

    private void Sj(double d11, final View view) {
        if (d11 > 0.0d) {
            com.bytedance.sdk.component.utils.uA.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS.3
                @Override // java.lang.Runnable
                public void run() {
                    if (vS.this.Fmk.TEQ().HiB().Xqg() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    vS.this.setVisibility(0);
                }
            }, (long) (d11 * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            if (viewGroup.getChildAt(i11) instanceof com.bytedance.sdk.component.adexpress.dynamic.TKC.uA) {
                viewGroup.removeViewAt(i11);
            }
        }
    }

    private static void Sj(com.bytedance.sdk.component.HiB.TEQ teq) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            teq.Sj(Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable TKC(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                if (jSONArray.getString(i11).startsWith(Utils.SEPARATOR)) {
                    arrayList.add(jSONArray.getString(i11));
                } else if (jSONArray.getString(i11).endsWith("deg")) {
                    str2 = jSONArray.getString(i11);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                iArr[i12] = com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg.Sj(((String) arrayList.get(i12)).substring(0, 7));
            }
            GradientDrawable Sj2 = Sj(Sj(str2), iArr);
            Sj2.setShape(0);
            Sj2.setCornerRadius(com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.Zq()));
            return Sj2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getBuildModel() {
        try {
            sU = com.bytedance.sdk.component.utils.uP.Sj();
        } catch (Throwable unused) {
            sU = Build.MODEL;
        }
        if (TextUtils.isEmpty(sU)) {
            sU = Build.MODEL;
        }
        return sU;
    }

    private String sP(String str) {
        try {
            Map<String, String> Ym = this.sef.getRenderRequest().Ym();
            if (Ym != null && Ym.size() > 0) {
                return Ym.get(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.Jcg, this.Dq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.Zq;
        if (view == null) {
            view = this;
        }
        double sU2 = this.Fmk.TEQ().HiB().sU();
        if (sU2 < 90.0d && sU2 > 0.0d) {
            com.bytedance.sdk.component.utils.uA.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS.2
                @Override // java.lang.Runnable
                public void run() {
                    vS.this.setVisibility(8);
                }
            }, (long) (sU2 * 1000.0d));
        }
        Sj(this.Fmk.TEQ().HiB().RiZ(), view);
        if (!TextUtils.isEmpty(this.f20971aa.Ei())) {
            Sj();
        }
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.Sj);
            removeCallbacks(this.sP);
        } catch (Exception unused) {
        }
    }

    public boolean uA() {
        int i11;
        int i12;
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject optJSONObject;
        final View view = this.Zq;
        if (view == null) {
            view = this;
        }
        setContentDescription(this.Fmk.Sj(this.f20971aa.ley()));
        String TFd = this.f20971aa.TFd();
        String str = null;
        String Sj2 = (TextUtils.isEmpty(TFd) || (dynamicRootView = this.sef) == null || dynamicRootView.getRenderRequest() == null || this.sef.getRenderRequest().TKC() == null || (optJSONObject = this.sef.getRenderRequest().TKC().optJSONObject("creative")) == null) ? null : Sj(optJSONObject.opt(TFd));
        if (TextUtils.isEmpty(Sj2)) {
            Sj2 = this.f20971aa.dx();
        }
        com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
        if (TKC2 != null) {
            i11 = TKC2.Zq();
            i12 = TKC2.uvD();
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (this.f20971aa.sU()) {
            int RiZ = this.f20971aa.RiZ();
            String str2 = this.f20971aa.sP;
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().HiB().Sj(str2).Sj(this.Jcg).sP(this.Dq).EjP(i11).HiB(i12).Sj(sP(str2)).TKC(2).Sj(new TKC(this.Ym, RiZ)).Sj(new sP(view, this));
        } else if (!TextUtils.isEmpty(Sj2)) {
            if (!Sj2.startsWith("http:") && !Sj2.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.sef;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    str = this.sef.getRenderRequest().kF();
                }
                Sj2 = com.bytedance.sdk.component.adexpress.dynamic.HiB.uA.sP(Sj2, str);
            }
            com.bytedance.sdk.component.HiB.TEQ TKC3 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().HiB().Sj(Sj2).Sj(this.Jcg).sP(this.Dq).EjP(i11).HiB(i12).Sj(sP(Sj2)).TKC(2);
            Sj(TKC3);
            TKC3.Sj(new Sj(view, this.sef, this.Fmk));
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.f20971aa.Yf() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (vS.this.f20971aa.Mts() > 0) {
                            vS vSVar = vS.this;
                            Drawable TKC4 = vSVar.TKC(vSVar.sef.getBgMaterialCenterCalcColor().get(Integer.valueOf(vS.this.f20971aa.Mts())));
                            if (TKC4 == null) {
                                vS vSVar2 = vS.this;
                                TKC4 = vSVar2.Sj(true, vSVar2.sef.getBgMaterialCenterCalcColor().get(Integer.valueOf(vS.this.f20971aa.Mts())));
                            }
                            if (TKC4 != null) {
                                view.setBackground(TKC4);
                                return;
                            }
                            View view2 = view;
                            vS vSVar3 = vS.this;
                            view2.setBackground(vSVar3.Sj(true, vSVar3.sef.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.f20971aa.Yf() * 1000.0d));
        }
        View view2 = this.Zq;
        if (view2 != null) {
            view2.setPadding((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.TKC()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.sP()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.EjP()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, this.f20971aa.Sj()));
        }
        if (this.uvD || this.f20971aa.sef() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }
}
