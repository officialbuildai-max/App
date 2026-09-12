package com.bytedance.sdk.openadsdk.core.Dq;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.core.RiZ;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.WMZ;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Jcg {
    private Sj Dq;
    private PAGBannerAdLoadListener EjP;
    private List<com.bytedance.sdk.openadsdk.core.model.sU> Jcg;
    private AdSlot Sj;
    private final Context TKC;
    private List<com.bytedance.sdk.openadsdk.core.model.sU> vS;
    private final AtomicBoolean HiB = new AtomicBoolean(false);
    private int uA = 5;
    private final WMZ TEQ = WMZ.TKC();
    private final com.bytedance.sdk.openadsdk.core.RiZ sP = com.bytedance.sdk.openadsdk.core.dNu.TKC();

    /* loaded from: classes3.dex */
    public interface Sj {
    }

    private Jcg(Context context) {
        if (context != null) {
            this.TKC = context.getApplicationContext();
        } else {
            this.TKC = com.bytedance.sdk.openadsdk.core.dNu.Sj();
        }
    }

    private PAGBannerAd Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (this.uA == 1) {
            return sUVar.UHs() != null ? new com.bytedance.sdk.openadsdk.core.TKC.vS(this.TKC, sUVar, this.Sj) : new com.bytedance.sdk.openadsdk.core.TKC.EjP(this.TKC, sUVar, this.Sj);
        }
        return null;
    }

    @Nullable
    private PAGBannerAd Sj(WMZ wmz) {
        int i11;
        int i12;
        PAGBannerAd pAGBannerAd = null;
        for (com.bytedance.sdk.openadsdk.core.model.sU sUVar : this.Jcg) {
            PAGBannerSize Ovo = sUVar.Ovo();
            float min = Math.min(this.Sj.getExpressViewAcceptedHeight(), 250.0f);
            if (Ovo != null) {
                i11 = Ovo.getWidth();
                i12 = Ovo.getHeight();
            } else {
                i11 = 0;
                i12 = 0;
            }
            float expressViewAcceptedWidth = i11 > 0 ? i11 : this.Sj.getExpressViewAcceptedWidth();
            if (i12 > 0) {
                min = i12;
            }
            this.Sj.setExpressViewAccepted(expressViewAcceptedWidth, min);
            pAGBannerAd = Sj(sUVar);
            if (pAGBannerAd != null) {
                break;
            }
        }
        return pAGBannerAd;
    }

    public static Jcg Sj(Context context) {
        return new Jcg(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj() {
        List<com.bytedance.sdk.openadsdk.core.model.sU> list = this.vS;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.model.sU> list2 = this.Jcg;
        if (list2 != null) {
            list2.clear();
        }
    }

    private void Sj(int i11) {
        List<com.bytedance.sdk.openadsdk.core.model.sU> list = this.vS;
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj().Sj(com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj(this.uA).TKC(this.Sj.getCodeId()).HiB((list == null || list.size() <= 0) ? "" : this.vS.get(0).cKW()).sP(i11).vS(com.bytedance.sdk.openadsdk.core.Dq.Sj(i11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(int i11, String str) {
        if (this.HiB.getAndSet(false)) {
            PAGBannerAdLoadListener pAGBannerAdLoadListener = this.EjP;
            if (pAGBannerAdLoadListener != null) {
                pAGBannerAdLoadListener.onError(i11, str);
            }
            Sj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(AdSlot adSlot) {
        List<com.bytedance.sdk.openadsdk.core.model.sU> list = this.vS;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.model.sU sUVar : list) {
            if (com.bytedance.sdk.openadsdk.core.model.sU.HiB(sUVar) && sUVar.UHs() != null && sUVar.UHs().x() != null) {
                if (com.bytedance.sdk.openadsdk.core.dNu.EjP().HiB(String.valueOf(sUVar.If())) && com.bytedance.sdk.openadsdk.core.dNu.EjP().UHs()) {
                    com.bytedance.sdk.openadsdk.core.aa.Sj.sP Sj2 = com.bytedance.sdk.openadsdk.core.model.sU.Sj(CacheDirFactory.getICacheDir(sUVar.Gn()).TKC(), sUVar);
                    Sj2.Sj("material_meta", sUVar);
                    Sj2.Sj("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.aa.HiB.Sj.Sj(Sj2, null);
                }
            }
        }
    }

    private void Sj(final AdSlot adSlot, com.bytedance.sdk.openadsdk.common.vS vSVar) {
        if (adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.ib ibVar = new com.bytedance.sdk.openadsdk.core.model.ib();
        ibVar.Dq = 2;
        this.sP.Sj(adSlot, ibVar, this.uA, new RiZ.Sj() { // from class: com.bytedance.sdk.openadsdk.core.Dq.Jcg.1
            @Override // com.bytedance.sdk.openadsdk.core.RiZ.Sj
            public void Sj(int i11, String str) {
                Jcg.this.Sj(i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.RiZ.Sj
            public void Sj(final com.bytedance.sdk.openadsdk.core.model.Sj sj2, com.bytedance.sdk.openadsdk.core.model.TKC tkc) {
                if (sj2.EjP() == null || sj2.EjP().isEmpty()) {
                    Jcg.this.Sj(-3, com.bytedance.sdk.openadsdk.core.Dq.Sj(-3));
                    tkc.Sj(-3);
                    com.bytedance.sdk.openadsdk.core.model.TKC.Sj(tkc);
                    return;
                }
                Jcg.this.vS = sj2.EjP();
                Jcg.this.Jcg = sj2.EjP();
                Jcg.this.Sj(adSlot);
                if (com.bytedance.sdk.component.utils.Zq.EjP()) {
                    Log.e("ExpressAdLoadManager", "onAdLoad: net work response duration = " + Jcg.this.TEQ.EjP() + "run in  " + Thread.currentThread().getName());
                }
                if (Jcg.this.HiB.getAndSet(false)) {
                    JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.Jcg.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (Jcg.this.Jcg != null && Jcg.this.Jcg.size() > 0) {
                                Jcg jcg = Jcg.this;
                                jcg.Sj(sj2, jcg.TEQ, elapsedRealtime);
                                if (Jcg.this.Dq != null) {
                                    Sj unused = Jcg.this.Dq;
                                    List unused2 = Jcg.this.Jcg;
                                }
                            } else if (Jcg.this.Dq != null) {
                                Sj unused3 = Jcg.this.Dq;
                            }
                            Jcg.this.Sj();
                        }
                    });
                }
            }
        });
    }

    private void Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2, final long j11, final long j12, final long j13) {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar;
        try {
            if (com.bytedance.sdk.openadsdk.core.dNu.EjP().qRN()) {
                if (com.bytedance.sdk.openadsdk.dx.Sj.EjP()) {
                    try {
                        if (this.uA != 1 || sj2 == null || sj2.EjP() == null || sj2.EjP().isEmpty() || sj2.Sj() == null || (sUVar = sj2.EjP().get(0)) == null) {
                            return;
                        }
                        final JSONObject Sj2 = sj2.Sj();
                        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(System.currentTimeMillis(), sUVar, Sj2.optString("tag", ""), "load_ad_time", new com.bytedance.sdk.openadsdk.Zq.TKC.Sj() { // from class: com.bytedance.sdk.openadsdk.core.Dq.Jcg.2
                            @Override // com.bytedance.sdk.openadsdk.Zq.TKC.Sj
                            public JSONObject Sj() {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    long optLong = Sj2.optLong("callback_start", 0L);
                                    long j14 = j12;
                                    long j15 = j14 - optLong;
                                    long j16 = j13 - j14;
                                    long optLong2 = Sj2.optLong("duration", 0L);
                                    JSONObject optJSONObject = Sj2.optJSONObject("extra_data");
                                    if (optJSONObject == null) {
                                        optJSONObject = new JSONObject();
                                    }
                                    optJSONObject.put("thread_dispatch_duration", j15);
                                    optJSONObject.put("build_banner_ad_duration", j16);
                                    optJSONObject.put("ad_load_duration_full", j11);
                                    jSONObject.put("duration", optLong2);
                                    jSONObject.put("ad_extra_data", optJSONObject.toString());
                                    if (com.bytedance.sdk.component.utils.Zq.EjP()) {
                                        jSONObject.toString();
                                    }
                                } catch (Throwable unused) {
                                }
                                return jSONObject;
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2, WMZ wmz, long j11) {
        if (this.EjP != null) {
            PAGBannerAd Sj2 = Sj(wmz);
            if (Sj2 == null) {
                this.EjP.onError(103, com.bytedance.sdk.openadsdk.core.Dq.Sj(103));
                Sj(103);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long EjP = this.TEQ.EjP();
            if (!TextUtils.isEmpty(this.Sj.getBidAdm())) {
                com.bytedance.sdk.openadsdk.Zq.TKC.Sj(this.Jcg.get(0), EjP);
            }
            this.EjP.onAdLoaded(Sj2);
            Sj(sj2, EjP, j11, elapsedRealtime);
        }
    }

    public void Sj(AdSlot adSlot, int i11, @NonNull com.bytedance.sdk.openadsdk.common.vS vSVar, int i12) {
        Sj(adSlot, i11, vSVar, null, i12);
    }

    public void Sj(AdSlot adSlot, int i11, @Nullable com.bytedance.sdk.openadsdk.common.vS vSVar, @Nullable Sj sj2, int i12) {
        this.TEQ.HiB();
        if (this.HiB.get()) {
            return;
        }
        this.uA = i11;
        this.HiB.set(true);
        this.Sj = adSlot;
        if (vSVar instanceof PAGBannerAdLoadListener) {
            this.EjP = (PAGBannerAdLoadListener) vSVar;
        }
        this.Dq = sj2;
        Sj(adSlot, vSVar);
    }
}
