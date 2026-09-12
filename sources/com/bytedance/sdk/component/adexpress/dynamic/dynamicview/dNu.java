package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class dNu extends vS {
    private TextView Sj;

    /* renamed from: dx, reason: collision with root package name */
    private TextView f20974dx;

    /* renamed from: ib, reason: collision with root package name */
    private LinearLayout f20975ib;
    private TextView sP;
    private TextView sU;
    private TextView zR;

    public dNu(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        super(context, dynamicRootView, dq2);
        this.Sj = new TextView(this.Ym);
        this.sP = new TextView(this.Ym);
        this.sU = new TextView(this.Ym);
        this.f20975ib = new LinearLayout(this.Ym);
        this.f20974dx = new TextView(this.Ym);
        this.zR = new TextView(this.Ym);
        this.Sj.setTag(9);
        this.sP.setTag(10);
        this.sU.setTag(12);
        this.f20975ib.addView(this.sU);
        this.f20975ib.addView(this.zR);
        this.f20975ib.addView(this.sP);
        this.f20975ib.addView(this.f20974dx);
        this.f20975ib.addView(this.Sj);
        addView(this.f20975ib, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB
    protected boolean EjP() {
        this.Sj.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.Sj.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.sP.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.sP.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.sU.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.sU.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.Jcg, this.Dq);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vS, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WMZ
    public boolean uA() {
        this.sU.setText("Function");
        this.sP.setText("Permission list");
        this.f20974dx.setText(" | ");
        this.zR.setText(" | ");
        this.Sj.setText("Privacy policy");
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg = this.f20971aa;
        if (jcg != null) {
            this.sU.setTextColor(jcg.Jcg());
            this.sU.setTextSize(this.f20971aa.HiB());
            this.sP.setTextColor(this.f20971aa.Jcg());
            this.sP.setTextSize(this.f20971aa.HiB());
            this.f20974dx.setTextColor(this.f20971aa.Jcg());
            this.zR.setTextColor(this.f20971aa.Jcg());
            this.Sj.setTextColor(this.f20971aa.Jcg());
            this.Sj.setTextSize(this.f20971aa.HiB());
            return false;
        }
        this.sU.setTextColor(-1);
        this.sU.setTextSize(12.0f);
        this.sP.setTextColor(-1);
        this.sP.setTextSize(12.0f);
        this.f20974dx.setTextColor(-1);
        this.zR.setTextColor(-1);
        this.Sj.setTextColor(-1);
        this.Sj.setTextSize(12.0f);
        return false;
    }
}
