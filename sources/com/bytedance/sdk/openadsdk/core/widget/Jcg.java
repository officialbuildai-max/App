package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class Jcg extends com.bytedance.sdk.openadsdk.core.HiB.Jcg {
    private com.bytedance.sdk.openadsdk.core.HiB.Dq EjP;
    private boolean HiB;
    private uvD Sj;
    private Dq TKC;
    private com.bytedance.sdk.openadsdk.core.HiB.Dq sP;
    private boolean vS;

    public Jcg(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (Sj()) {
            sP();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(com.bytedance.sdk.openadsdk.core.model.sU r7, int r8) {
        /*
            r6 = this;
            boolean r8 = r6.HiB
            if (r8 == 0) goto L83
            if (r7 == 0) goto L83
            boolean r8 = r6.vS
            if (r8 == 0) goto Lc
            goto L83
        Lc:
            r8 = 1
            r6.vS = r8
            boolean r8 = r7.IOh()
            r0 = 8
            if (r8 != 0) goto L50
            com.bytedance.sdk.openadsdk.core.model.uvD r1 = r7.EZ()
            if (r1 == 0) goto L50
            com.bytedance.sdk.openadsdk.core.model.uvD r1 = r7.EZ()
            java.lang.String r1 = r1.Sj()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L50
            com.bytedance.sdk.openadsdk.core.model.uvD r1 = r7.EZ()     // Catch: java.lang.Throwable -> L50
            com.bytedance.sdk.component.HiB.TEQ r1 = com.bytedance.sdk.openadsdk.uA.EjP.Sj(r1)     // Catch: java.lang.Throwable -> L50
            r2 = 2
            com.bytedance.sdk.component.HiB.TEQ r1 = r1.TKC(r2)     // Catch: java.lang.Throwable -> L50
            com.bytedance.sdk.openadsdk.uA.sP r2 = new com.bytedance.sdk.openadsdk.uA.sP     // Catch: java.lang.Throwable -> L50
            com.bytedance.sdk.openadsdk.core.model.uvD r3 = r7.EZ()     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r3.Sj()     // Catch: java.lang.Throwable -> L50
            com.bytedance.sdk.openadsdk.utils.wE r4 = new com.bytedance.sdk.openadsdk.utils.wE     // Catch: java.lang.Throwable -> L50
            com.bytedance.sdk.openadsdk.core.widget.uvD r5 = r6.Sj     // Catch: java.lang.Throwable -> L50
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L50
            r2.<init>(r7, r3, r4)     // Catch: java.lang.Throwable -> L50
            r1.Sj(r2)     // Catch: java.lang.Throwable -> L50
            goto L55
        L50:
            com.bytedance.sdk.openadsdk.core.widget.uvD r1 = r6.Sj
            r1.setVisibility(r0)
        L55:
            if (r8 == 0) goto L5f
            com.bytedance.sdk.openadsdk.core.HiB.Dq r8 = r6.sP
            java.lang.String r0 = "Loading"
            r8.setText(r0)
            goto L78
        L5f:
            java.lang.String r8 = r7.xu()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L73
            com.bytedance.sdk.openadsdk.core.HiB.Dq r8 = r6.sP
            java.lang.String r0 = r7.xu()
            r8.setText(r0)
            goto L78
        L73:
            com.bytedance.sdk.openadsdk.core.HiB.Dq r8 = r6.sP
            r8.setVisibility(r0)
        L78:
            com.bytedance.sdk.openadsdk.core.HiB.Dq r8 = r6.EjP
            if (r8 == 0) goto L83
            java.lang.String r7 = r7.Ir()
            r8.setText(r7)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.Jcg.Sj(com.bytedance.sdk.openadsdk.core.model.sU, int):void");
    }

    protected boolean Sj() {
        return true;
    }

    @Nullable
    public com.bytedance.sdk.openadsdk.core.HiB.Dq getDownloadButton() {
        return this.EjP;
    }

    @Nullable
    public Dq getLoadingProgressBar() {
        return this.TKC;
    }

    public void sP() {
        if (this.HiB) {
            return;
        }
        this.HiB = true;
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        uvD uvd = new uvD(context);
        this.Sj = uvd;
        uvd.setId(520093745);
        int sP = FPG.sP(context, 64.0f);
        this.Sj.setLayoutParams(new RelativeLayout.LayoutParams(sP, sP));
        com.bytedance.sdk.openadsdk.core.HiB.Dq dq2 = new com.bytedance.sdk.openadsdk.core.HiB.Dq(context);
        this.sP = dq2;
        dq2.setId(520093746);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(FPG.sP(context, 219.0f), -2);
        layoutParams2.topMargin = FPG.sP(context, 16.0f);
        this.sP.setLayoutParams(layoutParams2);
        this.sP.setEllipsize(TextUtils.TruncateAt.END);
        this.sP.setGravity(17);
        this.sP.setMaxWidth(FPG.sP(context, 150.0f));
        this.sP.setMaxLines(2);
        this.sP.setTextColor(-1);
        this.sP.setTextSize(1, 16.0f);
        Dq dq3 = new Dq(context);
        this.TKC = dq3;
        dq3.setId(520093748);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(FPG.sP(context, 219.0f), FPG.sP(context, 6.0f));
        layoutParams3.topMargin = FPG.sP(context, 24.0f);
        this.TKC.setLayoutParams(layoutParams3);
        this.EjP = new com.bytedance.sdk.openadsdk.core.HiB.Dq(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(FPG.sP(context, 138.0f), FPG.sP(context, 42.0f));
        layoutParams4.topMargin = FPG.sP(context, 48.0f);
        this.EjP.setLayoutParams(layoutParams4);
        this.EjP.setTextColor(-1);
        this.EjP.setTextSize(16.0f);
        this.EjP.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(layoutParams4.height / 2);
        this.EjP.setBackground(gradientDrawable);
        linearLayout.addView(this.Sj);
        linearLayout.addView(this.sP);
        linearLayout.addView(this.TKC);
        linearLayout.addView(this.EjP);
        addView(linearLayout);
    }

    public void setProgress(int i11) {
        Dq dq2 = this.TKC;
        if (dq2 != null) {
            dq2.setProgress(i11);
        }
    }
}
