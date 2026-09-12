package com.bytedance.sdk.component.adexpress.dynamic.Sj;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.TKC;
import com.bytedance.sdk.component.adexpress.dynamic.EjP.vS;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Mts;
import com.bytedance.sdk.component.adexpress.sP.Dq;
import com.bytedance.sdk.component.adexpress.sP.EjP;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import com.bytedance.sdk.component.adexpress.sP.Jcg;
import com.bytedance.sdk.component.adexpress.sP.Ym;
import com.bytedance.sdk.component.adexpress.sP.sef;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.uA;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj implements EjP<DynamicRootView>, Ym {
    private AtomicBoolean Dq = new AtomicBoolean(false);
    private Jcg EjP;
    private Dq HiB;
    private ScheduledFuture<?> Jcg;
    private DynamicRootView Sj;
    private Context TKC;
    private com.bytedance.sdk.component.adexpress.dynamic.HiB.Dq sP;
    private Fmk vS;

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.Sj.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0227Sj implements Runnable {
        private int sP;

        public RunnableC0227Sj(int i11) {
            this.sP = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.sP == 2) {
                Sj.this.Sj.callBackRenderFail(Sj.this.sP instanceof com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg ? 127 : Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, null);
            }
        }
    }

    public Sj(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z10, com.bytedance.sdk.component.adexpress.dynamic.HiB.Dq dq2, Fmk fmk, com.bytedance.sdk.component.adexpress.dynamic.vS.Sj sj2) {
        this.TKC = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z10, fmk, sj2);
        this.Sj = dynamicRootView;
        this.sP = dq2;
        this.vS = fmk;
        dynamicRootView.setRenderListener(this);
        this.vS = fmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        try {
            ScheduledFuture<?> scheduledFuture = this.Jcg;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.Jcg.cancel(false);
            this.Jcg = null;
        } catch (Throwable unused) {
        }
    }

    private boolean Jcg() {
        DynamicRootView dynamicRootView = this.Sj;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Sj(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 >= viewGroup.getChildCount()) {
                    break;
                }
                Sj(viewGroup.getChildAt(i11));
                i11++;
            }
        }
        if (view instanceof Mts) {
            ((Mts) view).sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> Ym;
        if (dq2 == null || (Ym = dq2.Ym()) == null || Ym.size() <= 0) {
            return;
        }
        Collections.sort(Ym, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Sj.Sj.3
            @Override // java.util.Comparator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq4) {
                vS HiB = dq3.TEQ().HiB();
                vS HiB2 = dq4.TEQ().HiB();
                if (HiB == null || HiB2 == null) {
                    return 0;
                }
                return HiB.eMB() >= HiB2.eMB() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3 : Ym) {
            if (dq3 != null) {
                Sj(dq3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TKC(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        if (dq2 == null) {
            this.Sj.callBackRenderFail(this.sP instanceof com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg ? Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113, "layoutUnit is null");
            return;
        }
        this.vS.HiB().EjP(TKC());
        try {
            this.Sj.render(dq2, TKC());
        } catch (Exception e11) {
            int i11 = this.sP instanceof com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg ? 128 : Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE;
            this.Sj.callBackRenderFail(i11, "exception is " + e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        float f11;
        float f12;
        List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> Ym;
        if (dq2 == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> Ym2 = dq2.Ym();
        if (Ym2 == null || Ym2.size() <= 0) {
            f11 = 0.0f;
        } else {
            f11 = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3 : Ym2) {
                if (dq3.Jcg() > dq2.Jcg() - dq3.uA() || (Ym = dq3.Ym()) == null || Ym.size() <= 0) {
                    f12 = 0.0f;
                } else {
                    f12 = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq4 : Ym) {
                        if (dq4.TEQ().sP().equals("logo-union")) {
                            f12 = dq4.TEQ().vS();
                            f11 = (((-f12) + dq2.Jcg()) - dq3.Jcg()) + dq3.TEQ().HiB().oWa();
                        }
                    }
                }
                sP(dq3);
                if (f12 <= -15.0f) {
                    dq3.vS(dq3.uA() - f12);
                    dq3.EjP(dq3.Jcg() + f12);
                    for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq5 : dq3.Ym()) {
                        dq5.EjP(dq5.Jcg() - f12);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq aa2 = dq2.aa();
        if (aa2 == null) {
            return;
        }
        float vS = dq2.vS() - aa2.vS();
        float Jcg = dq2.Jcg() - aa2.Jcg();
        dq2.TKC(vS);
        dq2.EjP(Jcg);
        if (f11 > 0.0f) {
            dq2.EjP(dq2.Jcg() - f11);
            dq2.vS(dq2.uA() + f11);
            for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq6 : dq2.Ym()) {
                dq6.EjP(dq6.Jcg() + f11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS() {
        this.vS.HiB().sP(TKC());
        JSONObject TKC = this.vS.TKC();
        if (com.bytedance.sdk.component.adexpress.Sj.sP.sP.Sj(TKC)) {
            this.sP.Sj(new com.bytedance.sdk.component.adexpress.dynamic.vS.sP() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Sj.Sj.2
                @Override // com.bytedance.sdk.component.adexpress.dynamic.vS.sP
                public void Sj(final com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
                    Sj.this.Dq();
                    Sj.this.vS.HiB().TKC(Sj.this.TKC());
                    Sj.this.Sj(dq2);
                    Sj.this.sP(dq2);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        Sj.this.TKC(dq2);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Sj.Sj.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Sj.this.TKC(dq2);
                            }
                        });
                    }
                    if (Sj.this.Sj == null || dq2 == null) {
                        return;
                    }
                    Sj.this.Sj.setBgColor(dq2.Sj());
                    Sj.this.Sj.setBgMaterialCenterCalcColor(dq2.sP());
                }
            });
            this.sP.Sj(this.vS);
            return;
        }
        int i11 = this.sP instanceof com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg ? Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113;
        DynamicRootView dynamicRootView = this.Sj;
        StringBuilder sb2 = new StringBuilder("data null is ");
        sb2.append(TKC == null);
        dynamicRootView.callBackRenderFail(i11, sb2.toString());
    }

    public DynamicRootView EjP() {
        return this.Sj;
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.EjP
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public DynamicRootView HiB() {
        return EjP();
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.Ym
    public void Sj(View view, int i11, TKC tkc) {
        Dq dq2 = this.HiB;
        if (dq2 != null) {
            dq2.Sj(view, i11, tkc);
        }
    }

    public void Sj(Dq dq2) {
        this.HiB = dq2;
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.EjP
    public void Sj(Jcg jcg) {
        this.EjP = jcg;
        int vS = this.vS.vS();
        if (vS < 0) {
            this.Sj.callBackRenderFail(this.sP instanceof com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg ? 127 : Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, "time is ".concat(String.valueOf(vS)));
            return;
        }
        this.Jcg = com.bytedance.sdk.component.adexpress.EjP.EjP.Sj(new RunnableC0227Sj(2), vS, TimeUnit.MILLISECONDS);
        if (Looper.getMainLooper() != Looper.myLooper() || this.vS.uA() > 0) {
            uA.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Sj.Sj.1
                @Override // java.lang.Runnable
                public void run() {
                    Sj.this.vS();
                }
            }, this.vS.uA());
        } else {
            vS();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.Ym
    public void Sj(sef sefVar) {
        if (this.Dq.get()) {
            return;
        }
        this.Dq.set(true);
        if (!sefVar.TKC() || !Jcg()) {
            this.EjP.Sj(sefVar.Ym(), sefVar.TEQ());
            return;
        }
        this.Sj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.EjP.Sj(HiB(), sefVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.EjP
    public int TKC() {
        return this.sP instanceof com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg ? 3 : 2;
    }

    public void sP() {
        Sj(HiB());
    }
}
