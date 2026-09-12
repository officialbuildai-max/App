package com.bytedance.sdk.openadsdk.core.aa.sP;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.component.utils.uA;
import com.bytedance.sdk.component.utils.wE;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq;
import com.bytedance.sdk.openadsdk.EjP.Jcg;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Dq.ib;
import com.bytedance.sdk.openadsdk.core.aa.sP.vS;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.sef.Fmk;
import com.bytedance.sdk.openadsdk.sef.sef;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import t5.a;
import u5.b;
import u5.c;

/* loaded from: classes3.dex */
public class TKC extends com.bytedance.sdk.openadsdk.core.aa.Sj.Sj {
    private int Ei;
    private final boolean FPG;
    private WeakReference<b.a> Fm;
    private int HpB;
    private long JcM;
    private final String Mts;
    private boolean MuB;
    private final Runnable UHs;
    private final boolean WMZ;
    private final boolean Wjd;

    /* renamed from: db, reason: collision with root package name */
    private sP f21137db;
    private final wE.Sj dwU;
    private long fF;

    /* renamed from: jb, reason: collision with root package name */
    private WeakReference<Sj> f21138jb;
    private final a.InterfaceC0949a ndK;
    private int qRN;
    private int sdp;
    private boolean xD;
    private Jcg xhi;

    /* loaded from: classes3.dex */
    public interface Sj {
        void Sj(int i11);

        void vS();
    }

    public TKC(Context context, ViewGroup viewGroup, sU sUVar, String str, boolean z10, boolean z11, boolean z12, Jcg jcg) {
        super(context, sUVar, viewGroup);
        this.fF = 0L;
        this.JcM = 0L;
        this.xD = true;
        this.Ei = 0;
        this.HpB = 0;
        this.ndK = new a.InterfaceC0949a() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1
            @Override // t5.a.InterfaceC0949a
            public void EjP(a aVar) {
                com.bytedance.sdk.openadsdk.core.Ym.Sj GMp = ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq.GMp();
                if (GMp != null && GMp.Sj() != null) {
                    GMp.Sj().sP(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uA);
                }
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 3);
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.Sj(0);
                }
            }

            @Override // t5.a.InterfaceC0949a
            public void HiB(a aVar) {
                com.bytedance.sdk.openadsdk.core.Ym.Sj GMp = ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq.GMp();
                if (GMp != null && GMp.Sj() != null) {
                    GMp.Sj().TKC(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uA);
                }
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.Sj(1);
                }
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar) {
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 5);
                            com.bytedance.sdk.openadsdk.kF.Sj.TKC.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 5);
                            if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.Sj(9);
                            }
                        } catch (Exception unused) {
                        }
                        TKC.this.Mts();
                    }
                });
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq.GMp() == null || ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq.GMp().Sj() == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq.GMp().Sj().EjP(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uA);
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, int i11) {
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).kF = false;
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.removeCallbacks(TKC.this.UHs);
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.sP();
                    }
                });
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 0);
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.Sj(5);
                }
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, int i11, int i12) {
                uA.Sj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        TKC.this.Wjd();
                    }
                });
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, int i11, int i12, int i13) {
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).kF = true;
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg != null) {
                            ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.dNu();
                            ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.postDelayed(TKC.this.UHs, 8000L);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 2);
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.Sj(4);
                }
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, long j11) {
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).kF = false;
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.removeCallbacks(TKC.this.UHs);
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg != null) {
                            ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.sP();
                        }
                        if (!((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Zq || TKC.this.f21138jb == null || TKC.this.f21138jb.get() == null) {
                            return;
                        }
                        ((Sj) TKC.this.f21138jb.get()).vS();
                    }
                });
                TKC.this.fF();
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 0);
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.TKC();
                }
                TKC tkc = TKC.this;
                tkc.Sj(tkc.xhi);
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, final long j11, final long j12) {
                if (Math.abs(j11 - ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uA) < 50) {
                    return;
                }
                TKC tkc = TKC.this;
                tkc.Sj(tkc.xhi);
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        TKC.this.Sj(j11, j12);
                        TKC.this.sP(j11, j12);
                    }
                });
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, final y5.a aVar2) {
                String unused = ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Sj;
                aVar2.a();
                aVar2.d();
                aVar2.c();
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int a11 = aVar2.a();
                        int d11 = aVar2.d();
                        if (!TKC.this.wE() || d11 == -1004) {
                            if (TKC.this.EjP(a11, d11)) {
                                String unused2 = ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Sj;
                                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, (WeakReference<Context>) null, false);
                                TKC.this.sP(true);
                                TKC.this.EjP();
                            }
                            if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg != null) {
                                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.sP();
                            }
                            if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).ley != null) {
                                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).ley.sP(TKC.this.JcM, c6.a.a(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uA, ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Yf));
                            }
                            if (TKC.this.Fm == null || TKC.this.Fm.get() == null || TKC.this.wE()) {
                                return;
                            }
                            ((b.a) TKC.this.Fm.get()).Sj(a11, d11);
                        }
                    }
                });
                TKC.this.Sj(aVar2);
                com.bytedance.sdk.openadsdk.core.Ym.Sj GMp = ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq.GMp();
                if (GMp != null && GMp.Sj() != null) {
                    GMp.Sj().Sj(com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.GENERAL_LINEAR_AD_ERROR);
                }
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, 6);
                com.bytedance.sdk.openadsdk.kF.Sj.TKC.sP(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq);
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).LqL.Sj(14);
                }
            }

            @Override // t5.a.InterfaceC0949a
            public void Sj(a aVar, boolean z13) {
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg != null) {
                            ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.sP();
                        }
                    }
                });
            }

            @Override // t5.a.InterfaceC0949a
            public void TKC(a aVar) {
            }

            @Override // t5.a.InterfaceC0949a
            public void sP(a aVar) {
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.removeCallbacks(TKC.this.UHs);
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).TKC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TKC.this.Fm != null && TKC.this.Fm.get() != null) {
                            TKC.this.Fm.get();
                        }
                        if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg != null) {
                            ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.sP();
                        }
                    }
                });
                if (TKC.this.WMZ) {
                    return;
                }
                TKC tkc = TKC.this;
                tkc.Sj(tkc.xhi);
            }

            @Override // t5.a.InterfaceC0949a
            public void sP(a aVar, int i11) {
            }
        };
        this.qRN = 0;
        this.UHs = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.4
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg != null) {
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.Sj(((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Dq, (WeakReference<Context>) null, false);
                    ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.sP();
                    TKC.this.sP(true);
                    String unused = ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Sj;
                }
            }
        };
        this.dwU = new wE.Sj() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.6
            @Override // com.bytedance.sdk.component.utils.wE.Sj
            public void Sj(Context context2, Intent intent, boolean z13, final int i11) {
                JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TKC.this.HiB(i11);
                    }
                });
            }
        };
        this.MuB = false;
        this.sdp = TzV.TKC(context);
        Sj(z10);
        this.Mts = str;
        try {
            this.Ei = viewGroup.getWidth();
            this.HpB = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        Sj(context);
        this.WMZ = true;
        this.FPG = z11;
        this.Wjd = z12;
        if (jcg != null) {
            this.xhi = jcg;
        }
    }

    private void EjP(int i11) {
        if (this.sdp == i11) {
            return;
        }
        this.sdp = i11;
        if (i11 != 4 && i11 != 0) {
            this.TzV = false;
        }
        if (!this.TzV && !Zq() && this.FPG) {
            TKC(2, i11);
        }
        WeakReference<Sj> weakReference = this.f21138jb;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f21138jb.get().Sj(this.sdp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EjP(int i11, int i12) {
        boolean z10 = i11 == -1010 || i11 == -1007 || i11 == -1004 || i11 == -110 || i11 == 100 || i11 == 200;
        if (i12 == 1 || i12 == 700 || i12 == 800) {
            return true;
        }
        return z10;
    }

    private void FPG() {
        com.bytedance.sdk.openadsdk.core.aa.EjP.TKC tkc = this.vS;
        if (tkc != null) {
            if (!tkc.Jcg()) {
                this.vS.Sj(false, this.uA, this.uvD);
            } else if (this.Fmk) {
                dx();
            } else {
                sP(this.LD);
            }
        }
        if (this.sU.get()) {
            ley();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HiB(int i11) {
        EjP(i11);
        if (i11 == 4) {
            this.dNu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mts() {
        this.qRN++;
        HiB hiB = this.Jcg;
        if (hiB == null) {
            return;
        }
        hiB.sP();
        b.InterfaceC0963b interfaceC0963b = this.ley;
        if (interfaceC0963b != null) {
            interfaceC0963b.Sj(this.JcM, c6.a.a(this.uA, this.Yf));
        }
        this.JcM = System.currentTimeMillis() - this.fF;
        if (this.xD) {
            this.Jcg.Sj(this.Dq, (WeakReference<Context>) null, true);
        }
        if (!this.f21127dx) {
            this.f21127dx = true;
            long j11 = this.Yf;
            sP(j11, j11);
            long j12 = this.Yf;
            this.uA = j12;
            this.TEQ = j12;
            sP(this.xhi);
        }
        if (!this.Zq && this.RiZ) {
            HiB(this.Jcg, null);
        }
        this.sef = true;
    }

    private void Sj(Context context) {
        ViewGroup sefVar = this.Zq ? new sef(context) : new Fmk(context);
        if (this.Zq) {
            this.Jcg = new HiB(context, sefVar, true, 17, this.Dq, this, ib());
        } else {
            this.Jcg = new EjP(context, sefVar, true, 17, this.Dq, this, false);
        }
        this.Jcg.Sj(this);
    }

    private void TKC(com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC tkc) {
        tkc.TKC(0);
        this.vS.Sj(tkc);
        this.fF = System.currentTimeMillis();
        this.Jcg.TKC(8);
        this.Jcg.TKC(0);
        Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.3
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).vS == null) {
                    return;
                }
                TKC.this.fF = System.currentTimeMillis();
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).Jcg.EjP(0);
                ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).vS.Sj(true, ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uA, ((com.bytedance.sdk.openadsdk.core.aa.Sj.Sj) TKC.this).uvD);
            }
        });
        if (this.Zq) {
            TzV();
        }
    }

    private boolean TKC(int i11, int i12) {
        if (i12 == 0) {
            Sj();
            this.dNu = true;
            HiB hiB = this.Jcg;
            if (hiB != null) {
                hiB.Sj(this.Dq, (WeakReference<Context>) null, false);
            }
        }
        if (i12 != 4 && i12 != 0) {
            HiB hiB2 = this.Jcg;
            if (hiB2 != null) {
                hiB2.Sj();
            }
            Sj();
            this.dNu = true;
            this.TzV = false;
            HiB hiB3 = this.Jcg;
            if (hiB3 != null) {
                return hiB3.Sj(i11, this.Dq.UHs(), this.Wjd);
            }
        } else if (i12 == 4) {
            this.dNu = false;
            HiB hiB4 = this.Jcg;
            if (hiB4 != null) {
                hiB4.Zq();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r1 > 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r2 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Wjd() {
        /*
            r8 = this;
            com.bykv.vk.openvk.Sj.Sj.Sj.vS.a r0 = r8.xD()     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L6e
            com.bytedance.sdk.openadsdk.core.aa.EjP.TKC r0 = r8.vS     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L6e
            android.view.ViewGroup r1 = r8.uP     // Catch: java.lang.Throwable -> L6b
            if (r1 != 0) goto L10
            goto L6e
        L10:
            int r0 = r0.EjP()     // Catch: java.lang.Throwable -> L6b
            com.bytedance.sdk.openadsdk.core.aa.EjP.TKC r1 = r8.vS     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.HiB()     // Catch: java.lang.Throwable -> L6b
            android.view.ViewGroup r2 = r8.uP     // Catch: java.lang.Throwable -> L6b
            int r2 = r2.getWidth()     // Catch: java.lang.Throwable -> L6b
            android.view.ViewGroup r3 = r8.uP     // Catch: java.lang.Throwable -> L6b
            int r3 = r3.getHeight()     // Catch: java.lang.Throwable -> L6b
            if (r2 <= 0) goto L6d
            if (r3 <= 0) goto L6d
            if (r1 <= 0) goto L6d
            if (r0 > 0) goto L2f
            goto L6d
        L2f:
            if (r0 != r1) goto L38
            if (r2 <= r3) goto L36
            r0 = r3
        L34:
            r1 = r0
            goto L54
        L36:
            r0 = r2
            goto L34
        L38:
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            if (r0 <= r1) goto L49
            float r0 = (float) r0     // Catch: java.lang.Throwable -> L6b
            float r0 = r0 * r6
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L6b
            float r0 = r0 / r1
            double r6 = (double) r2     // Catch: java.lang.Throwable -> L6b
            double r6 = r6 * r4
            double r0 = (double) r0     // Catch: java.lang.Throwable -> L6b
            double r6 = r6 / r0
            int r0 = (int) r6     // Catch: java.lang.Throwable -> L6b
            r1 = r2
            goto L54
        L49:
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L6b
            float r1 = r1 * r6
            float r0 = (float) r0     // Catch: java.lang.Throwable -> L6b
            float r1 = r1 / r0
            double r6 = (double) r3     // Catch: java.lang.Throwable -> L6b
            double r6 = r6 * r4
            double r0 = (double) r1     // Catch: java.lang.Throwable -> L6b
            double r6 = r6 / r0
            int r0 = (int) r6     // Catch: java.lang.Throwable -> L6b
            r1 = r0
            r0 = r3
        L54:
            if (r0 > r3) goto L5a
            if (r0 > 0) goto L59
            goto L5a
        L59:
            r3 = r0
        L5a:
            if (r1 > r2) goto L60
            if (r1 > 0) goto L5f
            goto L60
        L5f:
            r2 = r1
        L60:
            com.bytedance.sdk.component.utils.LqL r0 = r8.TKC     // Catch: java.lang.Throwable -> L6b
            com.bytedance.sdk.openadsdk.core.aa.sP.TKC$5 r1 = new com.bytedance.sdk.openadsdk.core.aa.sP.TKC$5     // Catch: java.lang.Throwable -> L6b
            r1.<init>()     // Catch: java.lang.Throwable -> L6b
            r0.post(r1)     // Catch: java.lang.Throwable -> L6b
            return
        L6b:
            r0 = move-exception
            goto L7b
        L6d:
            return
        L6e:
            android.content.Context r0 = r8.Ym     // Catch: java.lang.Throwable -> L6b
            java.util.Objects.toString(r0)     // Catch: java.lang.Throwable -> L6b
            com.bykv.vk.openvk.Sj.Sj.Sj.vS.a r0 = r8.xD()     // Catch: java.lang.Throwable -> L6b
            java.util.Objects.toString(r0)     // Catch: java.lang.Throwable -> L6b
            return
        L7b:
            r0.toString()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.Wjd():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(long j11, long j12) {
        this.Dq.TKC(j11);
        this.uA = j11;
        this.Yf = j12;
        this.Jcg.Sj(j11, j12);
        this.Jcg.Sj(c6.a.a(j11, j12));
        try {
            b.InterfaceC0963b interfaceC0963b = this.ley;
            if (interfaceC0963b != null) {
                interfaceC0963b.Sj(j11, j12);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj(this.Sj, "onProgressUpdate error: ", th2);
        }
        com.bytedance.sdk.openadsdk.core.Ym.Sj GMp = this.Dq.GMp();
        if (GMp == null || GMp.Sj() == null) {
            return;
        }
        GMp.Sj().Sj(j11, j12, this.LqL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bykv.vk.openvk.Sj.Sj.Sj.vS.a xD() {
        HiB hiB;
        if (this.Ym.getResources().getConfiguration().orientation != 1 || (hiB = this.Jcg) == null) {
            return null;
        }
        return hiB.Fmk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, u5.b
    public void EjP() {
        com.bytedance.sdk.openadsdk.core.aa.EjP.TKC tkc = this.vS;
        if (tkc != null) {
            tkc.aa();
            this.vS = null;
        }
        if (this.xD) {
            if ("embeded_ad".equals(this.Mts)) {
                this.Jcg.sU();
            } else {
                this.Jcg.Sj(this.Dq, (WeakReference<Context>) null, true);
            }
            this.TKC.removeCallbacksAndMessages(null);
            this.f21126aa.clear();
            if (this.Zq) {
                JcM();
            }
        }
    }

    public void JcM() {
        if (this.MuB && this.zR) {
            this.MuB = false;
            wE.Sj(this.dwU);
        }
    }

    public void Jcg(boolean z10) {
        HiB hiB = this.Jcg;
        if (hiB != null) {
            hiB.Sj();
        }
        HiB hiB2 = this.Jcg;
        if (hiB2 != null && z10) {
            hiB2.TzV();
        }
        FPG();
    }

    public com.bytedance.sdk.openadsdk.core.Ym.vS Sj(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.Dq.Ph()) {
            return null;
        }
        if (this.LqL == null) {
            this.LqL = com.bytedance.sdk.openadsdk.core.Ym.vS.Sj();
        }
        this.LqL.Sj(view, this.Dq.GMp().sef());
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    Object obj = pair.second;
                    this.LqL.Sj((View) pair.first, obj == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) obj);
                }
            }
        }
        return this.LqL;
    }

    public void Sj(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return;
        }
        this.Ei = i11;
        this.HpB = i12;
    }

    public void Sj(PAGNativeAd pAGNativeAd) {
        HiB hiB;
        if (!this.Zq || (hiB = this.Jcg) == null) {
            return;
        }
        hiB.Sj(pAGNativeAd);
    }

    public void Sj(Sj sj2) {
        this.f21138jb = new WeakReference<>(sj2);
    }

    public void Sj(sP sPVar) {
        this.f21137db = sPVar;
    }

    public void Sj(final vS.Sj sj2) {
        HiB hiB;
        if (!this.Zq || (hiB = this.Jcg) == null) {
            return;
        }
        hiB.Sj(new vS.Sj() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.TKC.2
            @Override // com.bytedance.sdk.openadsdk.core.aa.sP.vS.Sj
            public void Sj(View view, int i11) {
                vS.Sj sj3 = sj2;
                if (sj3 != null) {
                    sj3.Sj(view, i11);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, u5.b
    public void Sj(b.a aVar) {
        this.Fm = new WeakReference<>(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, com.bytedance.sdk.openadsdk.core.aa.sP.Sj
    public void Sj(c cVar, View view) {
        com.bytedance.sdk.openadsdk.core.aa.EjP.TKC tkc = this.vS;
        if (tkc == null) {
            return;
        }
        if (tkc.vS()) {
            Sj();
            this.Jcg.sP(true, false);
            this.Jcg.vS();
            return;
        }
        if (this.vS.Jcg()) {
            Jcg(false);
            HiB hiB = this.Jcg;
            if (hiB != null) {
                hiB.sP(false, false);
                return;
            }
            return;
        }
        HiB hiB2 = this.Jcg;
        if (hiB2 != null) {
            hiB2.TKC(this.uP);
        }
        EjP(this.uA);
        HiB hiB3 = this.Jcg;
        if (hiB3 != null) {
            hiB3.sP(false, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj
    public void Sj(c cVar, View view, boolean z10) {
        HiB(!this.RiZ);
        if (this.Ym instanceof Activity) {
            HiB hiB = this.Jcg;
            if (hiB != null) {
                hiB.sP(this.uP);
                this.Jcg.TKC(false);
            }
            Sj(1);
            WeakReference<b.d> weakReference = this.wE;
            b.d dVar = weakReference != null ? weakReference.get() : null;
            if (dVar != null) {
                dVar.Sj(this.RiZ);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, u5.b
    public void Sj(boolean z10, int i11) {
        if (!this.f21127dx && this.sU.get()) {
            if (z10) {
                Zq.Sj sj2 = new Zq.Sj();
                sj2.Sj(HiB());
                sj2.TKC(Dq());
                sj2.sP(vS());
                sj2.TKC(i11);
                sj2.EjP(Jcg());
                com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.Sj(this.Jcg, sj2, this.xhi);
                this.f21127dx = false;
            } else {
                LqL();
            }
        }
        EjP();
        com.bytedance.sdk.openadsdk.core.Ym.vS vSVar = this.LqL;
        if (vSVar != null) {
            vSVar.EjP();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, u5.b
    public boolean Sj(com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC tkc) {
        if (this.vS != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(tkc.Fmk())) {
            return false;
        }
        sP(false);
        tkc.Fmk();
        sP(tkc);
        Yf();
        com.bytedance.sdk.openadsdk.core.Ym.vS vSVar = this.LqL;
        if (vSVar != null) {
            vSVar.Sj(false, 0.0f);
        }
        if (!ib.sP(this.Mts) || this.uA <= 0) {
            this.uA = tkc.Jcg();
        }
        if (tkc.Jcg() <= 0) {
            this.f21127dx = false;
            this.sU.set(false);
        } else {
            long Jcg = tkc.Jcg();
            this.uA = Jcg;
            this.TEQ = Math.max(this.TEQ, Jcg);
        }
        HiB hiB = this.Jcg;
        if (hiB != null) {
            hiB.Sj();
            if (this.qRN == 0) {
                this.Jcg.Jcg();
            }
            this.Jcg.TKC(tkc.HiB(), tkc.vS());
            this.Jcg.TKC(this.uP);
            this.Jcg.Sj(tkc.HiB(), tkc.vS());
        }
        if (this.vS == null) {
            com.bytedance.sdk.openadsdk.core.aa.EjP.TKC tkc2 = new com.bytedance.sdk.openadsdk.core.aa.EjP.TKC();
            this.vS = tkc2;
            tkc2.Sj(this.ndK);
        }
        RiZ();
        this.JcM = 0L;
        try {
            TKC(tkc);
            return true;
        } catch (Exception e11) {
            Sj(new y5.a(-10, 0, e11.getMessage()));
            com.bytedance.sdk.component.utils.sU.sP(this.Sj, "[video] invoke NativeVideoController#playVideo cause exception :".concat(String.valueOf(e11)));
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, u5.b
    public void TKC() {
        Sj(true, 3);
    }

    public void TKC(int i11) {
        EjP(i11);
        if (i11 == 4) {
            this.dNu = false;
            sP();
        }
    }

    public void TzV() {
        if (this.MuB || !this.zR) {
            return;
        }
        Context applicationContext = dNu.Sj().getApplicationContext();
        this.MuB = true;
        wE.Sj(this.dwU, applicationContext);
    }

    public void WMZ() {
        com.bytedance.sdk.openadsdk.core.Ym.vS vSVar = this.LqL;
        if (vSVar != null) {
            vSVar.Sj(13);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.Sj.Sj, u5.b
    public void sP() {
        HiB hiB = this.Jcg;
        if (hiB != null) {
            hiB.Sj();
        }
        HiB hiB2 = this.Jcg;
        if (hiB2 != null) {
            hiB2.TzV();
        }
        FPG();
    }

    public void sP(int i11, int i12) {
        Sj(i11, i12);
        HiB hiB = this.Jcg;
        if (hiB == null || i11 <= 0 || i12 <= 0) {
            return;
        }
        hiB.TKC(i11, i12);
        this.Jcg.Sj(i11, i12);
        Wjd();
    }

    public void vS(boolean z10) {
        this.xD = z10;
    }
}
