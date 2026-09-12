package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes2.dex */
public class PAGLogoView extends LinearLayout {
    protected int containerHeight;
    private com.bytedance.sdk.openadsdk.core.HiB.EjP mAdLogo;
    private com.bytedance.sdk.openadsdk.core.HiB.Dq mAdText;

    public PAGLogoView(Context context) {
        this(context, null);
    }

    public PAGLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PAGLogoView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initView(context);
    }

    public static PAGLogoView createPAGLogoViewByMaterial(Context context, sU sUVar) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.initData(sUVar);
        return pAGLogoView;
    }

    private void initView(Context context) {
        int sP = FPG.sP(context, 2.0f);
        this.containerHeight = FPG.sP(getContext(), 12.0f);
        this.mAdLogo = new com.bytedance.sdk.openadsdk.core.HiB.EjP(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FPG.sP(context, 14.0f), FPG.sP(context, 6.0f));
        layoutParams.leftMargin = sP;
        this.mAdLogo.setLayoutParams(layoutParams);
        this.mAdLogo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mAdText = new com.bytedance.sdk.openadsdk.core.HiB.Dq(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, this.containerHeight);
        layoutParams2.leftMargin = sP;
        layoutParams2.rightMargin = sP;
        this.mAdText.setLayoutParams(layoutParams2);
        this.mAdText.setTextSize(1, 8.0f);
        this.mAdText.setGravity(17);
        this.mAdText.setTextColor(Color.parseColor("#BFFFFFFF"));
        addView(this.mAdLogo);
        addView(this.mAdText);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(sP);
        setBackground(gradientDrawable);
        setGravity(16);
    }

    public void initData(com.bytedance.sdk.openadsdk.core.model.sP sPVar) {
        if (sPVar == null) {
            return;
        }
        if (sPVar.HiB()) {
            this.mAdLogo.setImageDrawable(ib.TKC(com.bytedance.sdk.openadsdk.core.dNu.Sj(), "tt_ad_logo"));
        } else {
            String Sj = sPVar.Sj();
            if (TextUtils.isEmpty(Sj)) {
                this.mAdLogo.setVisibility(8);
            } else {
                if (Sj.contains("logo")) {
                    this.mAdLogo.setImageDrawable(ib.TKC(com.bytedance.sdk.openadsdk.core.dNu.Sj(), "tt_ad_logo"));
                } else {
                    com.bytedance.sdk.openadsdk.uA.EjP.Sj(Sj).TKC(2).Sj(this.mAdLogo);
                }
                this.mAdLogo.setVisibility(0);
            }
        }
        String sP = sPVar.sP();
        if (sPVar.HiB()) {
            this.mAdText.setText(ib.Sj(com.bytedance.sdk.openadsdk.core.dNu.Sj(), "tt_logo_en"));
        } else if (TextUtils.isEmpty(sP)) {
            this.mAdText.setVisibility(8);
        } else {
            this.mAdText.setText(sP);
            this.mAdText.setVisibility(0);
        }
    }

    public void initData(sU sUVar) {
        if (sUVar == null) {
            return;
        }
        initData(sUVar.fAj());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = this.containerHeight;
        super.setLayoutParams(com.bytedance.sdk.openadsdk.core.HiB.uA.Sj(this, layoutParams));
    }
}
