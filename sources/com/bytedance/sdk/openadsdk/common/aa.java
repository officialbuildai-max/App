package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.RiZ;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.wE;

/* loaded from: classes2.dex */
public class aa extends com.bytedance.sdk.openadsdk.core.HiB.TKC {
    private long EjP;
    private Runnable HiB;
    private int Jcg;
    protected Ym Sj;
    private int TKC;
    protected boolean sP;
    private Runnable vS;

    public aa(@NonNull Context context) {
        super(context);
        this.EjP = 10L;
        this.sP = true;
        this.Jcg = 1;
        TKC();
    }

    private void TKC() {
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        setVisibility(8);
    }

    private void TKC(int i11) {
        if (this.Jcg != i11) {
            this.Jcg = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(int i11) {
        Ym ym2 = this.Sj;
        if (ym2 != null) {
            ym2.Sj(i11);
        }
        if (i11 == 100 && this.sP) {
            sP();
        }
    }

    public void Sj() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa aaVar = aa.this;
                if (aaVar.Sj != null) {
                    aaVar.setVisibility(0);
                }
            }
        });
        if (this.HiB == null) {
            this.HiB = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aa.2
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.sP();
                }
            };
        }
        postDelayed(this.HiB, this.EjP * 1000);
    }

    public void Sj(int i11) {
        if (i11 == 100 || Math.abs(i11 - this.TKC) >= 7) {
            this.TKC = i11;
            if (f6.a.x()) {
                sP(this.TKC);
                return;
            }
            if (this.vS == null) {
                this.vS = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aa.3
                    @Override // java.lang.Runnable
                    public void run() {
                        aa aaVar = aa.this;
                        aaVar.sP(aaVar.TKC);
                    }
                };
            }
            post(this.vS);
        }
    }

    public void Sj(sU sUVar) {
        RiZ Fmk;
        if (sUVar != null && (Fmk = sUVar.Fmk()) != null) {
            this.EjP = Fmk.Sj();
        }
        Ym ym2 = new Ym(getContext());
        this.Sj = ym2;
        View Sj = ym2.Sj();
        if (Sj.getParent() instanceof ViewGroup) {
            ((ViewGroup) Sj.getParent()).removeView(Sj);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Sj.setLayoutParams(layoutParams);
        if (sUVar != null) {
            boolean IOh = sUVar.IOh();
            com.bytedance.sdk.openadsdk.core.widget.uvD sP = this.Sj.sP();
            if (sP != null) {
                if (IOh) {
                    sP.setVisibility(8);
                } else {
                    com.bytedance.sdk.openadsdk.core.model.uvD EZ = (sUVar.EZ() == null || TextUtils.isEmpty(sUVar.EZ().Sj())) ? null : sUVar.EZ();
                    if (EZ != null && !TextUtils.isEmpty(EZ.Sj())) {
                        try {
                            com.bytedance.sdk.openadsdk.uA.EjP.Sj(EZ).TKC(2).Sj(new com.bytedance.sdk.openadsdk.uA.sP(sUVar, EZ.Sj(), new wE(sP)));
                        } catch (Throwable unused) {
                        }
                    }
                    sP.setVisibility(8);
                }
            }
            com.bytedance.sdk.openadsdk.core.HiB.Dq TKC = this.Sj.TKC();
            if (TKC != null) {
                if (IOh) {
                    TKC.setText("Loading");
                } else if (TextUtils.isEmpty(sUVar.xu())) {
                    TKC.setVisibility(8);
                } else {
                    TKC.setText(sUVar.xu());
                }
            }
        }
        addView(Sj);
        TKC(getResources().getConfiguration().orientation);
    }

    public Ym getLoadingStyle() {
        return this.Sj;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TKC(configuration.orientation);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.HiB;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.HiB = null;
        }
    }

    public void sP() {
        this.TKC = 0;
        Ym ym2 = this.Sj;
        if (ym2 != null) {
            removeView(ym2.Sj);
            this.Sj.EjP();
        }
        setVisibility(8);
        this.Sj = null;
        Runnable runnable = this.HiB;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.vS;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.vS = null;
        this.HiB = null;
    }
}
