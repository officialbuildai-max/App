package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ley extends vS implements com.bytedance.sdk.component.adexpress.dynamic.TKC {
    int Sj;

    /* renamed from: dx, reason: collision with root package name */
    private int f20977dx;
    boolean sP;
    private int sU;
    private boolean zR;

    public ley(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        this.f20977dx = 0;
        setTag(Integer.valueOf(getClickArea()));
        Sj();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().uP()) {
            return;
        }
        View view = this.Zq;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    private void Sj() {
        List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> Ym = this.Fmk.Ym();
        if (Ym == null || Ym.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = Ym.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.TEQ().sP())) {
                int Sj = (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(this.Ym, next.Dq() + (com.bytedance.sdk.component.adexpress.EjP.sP() ? next.Fmk() : 0));
                this.sU = Sj;
                this.Sj = this.Jcg - Sj;
            }
        }
        this.f20977dx = this.Jcg - this.Sj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.TKC
    public void Sj(CharSequence charSequence, boolean z10, int i11, boolean z11) {
        if (z11 && this.zR != z11) {
            this.zR = z11;
            vS();
            return;
        }
        if (z10 && this.sP != z10) {
            this.sP = z10;
            vS();
        }
        this.sP = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.zR && this.f20971aa != null) {
            setMeasuredDimension(this.sU + ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.TKC())) + ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.EjP())), this.Dq);
        } else if (this.sP) {
            setMeasuredDimension(this.Jcg, this.Dq);
        } else {
            setMeasuredDimension(this.Sj, this.Dq);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        if (com.bytedance.sdk.component.adexpress.EjP.vS.sP(this.sef.getRenderRequest().EjP())) {
            return true;
        }
        super.uA();
        setPadding((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.TKC()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.sP()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.EjP()), (int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.Sj()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB
    public void vS() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.sP) {
            layoutParams.leftMargin = this.uA;
        } else {
            layoutParams.leftMargin = this.uA + this.f20977dx;
        }
        if (this.zR && this.f20971aa != null) {
            layoutParams.leftMargin = ((this.uA + this.f20977dx) - ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.TKC()))) - ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.EjP()));
        }
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            layoutParams.topMargin = this.TEQ - ((int) com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), this.f20971aa.sP()));
        } else {
            layoutParams.topMargin = this.TEQ;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
