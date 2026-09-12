package com.bytedance.sdk.openadsdk.core.aa.sP;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.LqL;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.EjP.HiB.sP.Zq;
import com.bytedance.sdk.openadsdk.EjP.Jcg;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.LD;
import com.bytedance.sdk.openadsdk.core.aa.sP.TKC;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.sef;
import com.bytedance.sdk.openadsdk.core.uA;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import u5.b;
import u5.c;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class vS extends com.bytedance.sdk.openadsdk.core.HiB.TKC implements b.InterfaceC0963b, LqL.Sj, TKC.Sj {

    /* renamed from: dx, reason: collision with root package name */
    private static final Integer f21139dx = 0;
    private static final Integer zR = 1;
    protected ImageView Dq;
    private boolean Ei;
    protected boolean EjP;
    private View FPG;
    private final AtomicBoolean Fm;
    protected int Fmk;
    public boolean HiB;
    private final AtomicBoolean HpB;
    private long JcM;
    protected RelativeLayout Jcg;
    private final Handler LD;
    private long LqL;
    private final String Mts;
    private boolean RiZ;
    protected final sU Sj;
    protected ImageView TEQ;
    protected FrameLayout TKC;
    private boolean TzV;
    private boolean WMZ;
    private b.c Wjd;
    private final boolean Yf;
    protected boolean Ym;
    public sP Zq;

    /* renamed from: aa, reason: collision with root package name */
    protected String f21140aa;
    private ViewGroup dNu;
    private boolean fF;

    /* renamed from: ib, reason: collision with root package name */
    private String f21141ib;

    /* renamed from: jb, reason: collision with root package name */
    private final Runnable f21142jb;
    private boolean kF;
    private boolean ley;
    protected b sP;
    private String sU;
    boolean sef;
    protected ImageView uA;
    private boolean uP;
    private final Context uvD;
    public Jcg vS;
    private boolean wE;
    private ViewTreeObserver.OnGlobalLayoutListener xD;
    private final ViewTreeObserver.OnScrollChangedListener xhi;

    /* loaded from: classes2.dex */
    public interface Sj {
        void Sj(View view, int i11);
    }

    /* loaded from: classes2.dex */
    public interface sP {
        void Sj(boolean z10, long j11, long j12, long j13, boolean z11);
    }

    public vS(@NonNull Context context, @NonNull sU sUVar, Jcg jcg) {
        this(context, sUVar, false, jcg);
    }

    public vS(@NonNull Context context, @NonNull sU sUVar, String str, boolean z10, boolean z11, Jcg jcg) {
        this(context, sUVar, false, str, z10, z11, jcg);
    }

    public vS(@NonNull Context context, @NonNull sU sUVar, boolean z10, Jcg jcg) {
        this(context, sUVar, z10, "embeded_ad", false, false, jcg);
    }

    public vS(@NonNull Context context, @NonNull sU sUVar, boolean z10, String str, boolean z11, boolean z12, Jcg jcg) {
        super(context);
        this.TzV = true;
        this.EjP = true;
        this.RiZ = false;
        this.HiB = false;
        this.kF = true;
        this.uP = false;
        this.wE = true;
        this.Ym = true;
        this.f21140aa = "embeded_ad";
        this.Fmk = 50;
        this.ley = true;
        this.Yf = false;
        this.LD = new LqL(sef.sP().getLooper(), this);
        this.WMZ = false;
        this.Mts = Build.MODEL;
        this.sef = false;
        this.Fm = new AtomicBoolean(false);
        this.f21142jb = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.vS.4
            @Override // java.lang.Runnable
            public void run() {
                vS vSVar = vS.this;
                vSVar.Sj(vSVar.fF, vS.f21139dx.intValue());
            }
        };
        this.Ei = true;
        this.HpB = new AtomicBoolean(false);
        this.xhi = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.vS.6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                vS.this.dNu();
            }
        };
        try {
            if (sUVar.rB()) {
                this.f21141ib = CacheDirFactory.getICacheDir(0).sP();
            }
        } catch (Throwable unused) {
        }
        if (jcg != null) {
            this.vS = jcg;
        }
        this.f21140aa = str;
        this.uvD = context;
        this.Sj = sUVar;
        this.RiZ = z10;
        setContentDescription("NativeVideoTsView");
        this.uP = z11;
        this.wE = z12;
        sP();
        HiB();
    }

    private void EjP() {
        Sj(0L, 0);
        this.Wjd = null;
    }

    private void HiB() {
        addView(Sj(this.uvD));
        TzV();
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.vS.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                vS.this.dNu();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                vS.this.dNu();
            }
        });
    }

    private void JcM() {
        FPG.HiB(this.uA);
        FPG.HiB(this.Jcg);
    }

    private boolean LD() {
        return 5 == dNu.EjP().sP(this.Sj.If());
    }

    private void LqL() {
        if (this.sP == null || fF()) {
            return;
        }
        if ((!kF() || com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_is_update_flag", false)) && kF()) {
            long Dq = this.sP.Dq();
            long vS = this.sP.vS() + Dq;
            boolean Sj2 = com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_native_video_complete", false);
            long Sj3 = com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long Sj4 = com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_total_play_duration", vS);
            long Sj5 = com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_duration", Dq);
            com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            this.sP.sP(Sj2);
            this.sP.Sj(Sj3);
            this.sP.sP(Sj4);
            this.sP.TKC(Sj5);
        }
    }

    private void RiZ() {
        b bVar = this.sP;
        if (bVar == null) {
            return;
        }
        bVar.TKC(this.TzV);
        ((TKC) this.sP).Sj((TKC.Sj) this);
        this.sP.Sj(this);
    }

    private View Sj(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.dNu = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.TKC = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.FPG = view;
        return frameLayout;
    }

    private void Sj(View view, ViewGroup viewGroup, View view2) {
        int indexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    private void Sj(com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC tkc) {
        try {
            if (this.Sj.rB()) {
                tkc.Sj(this.f21141ib);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(boolean z10, int i11) {
        if (this.Sj == null || this.sP == null) {
            return;
        }
        boolean uP = uP();
        wE();
        if (uP && this.sP.Zq()) {
            this.sP.Zq();
            sP(true);
            EjP();
            return;
        }
        if (!z10 || !this.kF || this.sP.Zq() || this.sP.Ym()) {
            if (this.sP.aa() == null || !this.sP.aa().vS()) {
                return;
            }
            this.sP.Sj();
            Sj(true);
            b.c cVar = this.Wjd;
            if (cVar != null) {
                cVar.g_();
                return;
            }
            return;
        }
        if (this.sP.aa() == null || !this.sP.aa().Jcg()) {
            if (this.TzV && this.sP.aa() == null) {
                if (!this.Fm.get()) {
                    this.Fm.set(true);
                }
                this.HpB.set(false);
                sU();
                return;
            }
            return;
        }
        if (this.TzV || i11 == 1) {
            b bVar = this.sP;
            if (bVar != null) {
                Sj(bVar.sef(), "changeVideoStatus");
            }
            if ("ALP-AL00".equals(this.Mts)) {
                this.sP.sP();
            } else {
                if (!uA.sP().dNu()) {
                    uP = true;
                }
                ((TKC) this.sP).Jcg(uP);
            }
            Sj(false);
            b.c cVar2 = this.Wjd;
            if (cVar2 != null) {
                cVar2.h_();
            }
        }
    }

    private void TzV() {
        this.sP = new TKC(this.uvD, this.TKC, this.Sj, this.f21140aa, !fF(), this.uP, this.wE, this.vS);
        RiZ();
        if (this.xD == null) {
            this.xD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.vS.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    vS vSVar;
                    b bVar;
                    if (vS.this.dNu == null || vS.this.dNu.getViewTreeObserver() == null || (bVar = (vSVar = vS.this).sP) == null) {
                        return;
                    }
                    ((TKC) bVar).Sj(vSVar.dNu.getWidth(), vS.this.dNu.getHeight());
                    vS.this.dNu.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    vS.this.xD = null;
                }
            };
            this.dNu.getViewTreeObserver().addOnGlobalLayoutListener(this.xD);
        }
    }

    private boolean Yf() {
        return 2 == dNu.EjP().sP(this.Sj.If());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNu() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.LD;
        if (handler == null || elapsedRealtime - this.JcM <= 500) {
            return;
        }
        this.JcM = elapsedRealtime;
        handler.sendEmptyMessageDelayed(1, 500L);
    }

    private void dx() {
        this.Zq = null;
        if ((this.sP instanceof TKC) && !fF()) {
            ((TKC) this.sP).JcM();
        }
        TEQ();
        Sj(false);
        zR();
    }

    private boolean fF() {
        return this.RiZ;
    }

    private void ib() {
        this.fF = Ym();
        JcM.Sj(this.f21142jb);
    }

    private boolean kF() {
        sU sUVar = this.Sj;
        if (sUVar == null) {
            return false;
        }
        return sUVar.Ms();
    }

    private void ley() {
        this.LD.removeMessages(1);
        sef.TKC().removeCallbacks(this.f21142jb);
    }

    private RelativeLayout sP(Context context) {
        com.bytedance.sdk.openadsdk.core.HiB.Jcg jcg = new com.bytedance.sdk.openadsdk.core.HiB.Jcg(context);
        jcg.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        jcg.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.HiB.EjP ejP = new com.bytedance.sdk.openadsdk.core.HiB.EjP(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ejP.setLayoutParams(layoutParams);
        ejP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Dq = ejP;
        com.bytedance.sdk.openadsdk.core.HiB.EjP ejP2 = new com.bytedance.sdk.openadsdk.core.HiB.EjP(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        ejP2.setLayoutParams(layoutParams2);
        ejP2.setVisibility(8);
        ejP2.setBackground(ib.TKC(context, "tt_new_play_video"));
        this.TEQ = ejP2;
        jcg.addView(ejP);
        jcg.addView(ejP2);
        return jcg;
    }

    private void sU() {
        b bVar = this.sP;
        if (bVar == null) {
            TzV();
        } else if ((bVar instanceof TKC) && !fF()) {
            ((TKC) this.sP).TzV();
        }
        if (this.sP == null || !this.Fm.get()) {
            return;
        }
        this.Fm.set(false);
        sP();
        if (!Dq()) {
            if (this.sP.Zq()) {
                this.sP.Zq();
                sP(true);
                return;
            } else {
                Jcg();
                FPG.Sj((View) this.Jcg, 0);
                return;
            }
        }
        FPG.Sj((View) this.Jcg, 8);
        ImageView imageView = this.uA;
        if (imageView != null) {
            FPG.Sj((View) imageView, 8);
        }
        sU sUVar = this.Sj;
        if (sUVar == null || sUVar.UHs() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.aa.Sj.sP Sj2 = sU.Sj(CacheDirFactory.getICacheDir(this.Sj.Gn()).TKC(), this.Sj);
        Sj2.sP(this.Sj.aZ());
        Sj2.Sj(this.dNu.getWidth());
        Sj2.sP(this.dNu.getHeight());
        Sj2.TKC(this.Sj.mZN());
        Sj2.Sj(0L);
        Sj2.Sj(uA());
        Sj(Sj2);
        this.sP.Sj(Sj2);
        this.sP.sP(false);
    }

    private boolean uP() {
        if (fF() || !kF()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void wE() {
        if (fF() || !kF()) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.multipro.EjP.Sj.Sj("sp_multi_native_video_data", "key_video_is_from_detail_page", bool);
    }

    private void zR() {
        if (!this.Fm.get()) {
            this.Fm.set(true);
            b bVar = this.sP;
            if (bVar != null) {
                bVar.Sj(true, 3);
            }
        }
        this.HpB.set(false);
    }

    public boolean Dq() {
        return this.TzV;
    }

    public void Fmk() {
        if (getNativeVideoController() == null || !(getNativeVideoController() instanceof TKC)) {
            return;
        }
        TKC tkc = (TKC) getNativeVideoController();
        tkc.Sj(tkc.Fmk(), this);
    }

    public void Jcg() {
        View view;
        if (this.uvD == null || (view = this.FPG) == null || view.getParent() == null || this.Sj == null || this.Jcg != null) {
            return;
        }
        ViewParent parent = this.FPG.getParent();
        RelativeLayout sP2 = sP(this.uvD);
        if (parent != null && (parent instanceof ViewGroup)) {
            Sj(sP2, (ViewGroup) parent, this.FPG);
        }
        this.Jcg = sP2;
        if (this.Ym) {
            FPG.Sj((View) this.TEQ, 0);
        }
        if (this.Sj.UHs() != null && this.Sj.UHs().r() != null) {
            com.bytedance.sdk.openadsdk.TzV.sP.Sj().Sj(this.Sj.UHs().r(), this.Sj.UHs().t(), this.Sj.UHs().C(), this.Dq, this.Sj);
        }
        ImageView imageView = this.TEQ;
        if (imageView != null) {
            imageView.setClickable(true);
            this.TEQ.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.vS.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    vS.this.TKC();
                }
            });
        }
    }

    public com.bytedance.sdk.openadsdk.core.Ym.vS Sj(List<Pair<View, FriendlyObstructionPurpose>> list) {
        b bVar = this.sP;
        if (bVar instanceof TKC) {
            return ((TKC) bVar).Sj(this, list);
        }
        return null;
    }

    @Override // u5.b.InterfaceC0963b
    public void Sj() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.sP.TKC.Sj
    public void Sj(int i11) {
        sP();
    }

    @Override // u5.b.InterfaceC0963b
    public void Sj(long j11, int i11) {
        b.c cVar = this.Wjd;
        if (cVar != null) {
            cVar.i_();
        }
    }

    @Override // u5.b.InterfaceC0963b
    public void Sj(long j11, long j12) {
        b.c cVar = this.Wjd;
        if (cVar != null) {
            cVar.Sj(j11, j12);
        }
    }

    @Override // com.bytedance.sdk.component.utils.LqL.Sj
    public void Sj(Message message) {
        if (message.what == 1) {
            ib();
        }
    }

    protected void Sj(boolean z10) {
        if (this.uA == null) {
            this.uA = new ImageView(getContext());
            if (uA.sP().TzV() != null) {
                this.uA.setImageBitmap(uA.sP().TzV());
            } else {
                this.uA.setImageResource(ib.EjP(dNu.Sj(), "tt_new_play_video"));
            }
            this.uA.setScaleType(ImageView.ScaleType.FIT_XY);
            int sP2 = FPG.sP(getContext(), this.Fmk);
            int sP3 = FPG.sP(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sP2, sP2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = sP3;
            layoutParams.bottomMargin = sP3;
            this.dNu.addView(this.uA, layoutParams);
            this.uA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.aa.sP.vS.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    vS.this.sef();
                }
            });
        }
        if (z10) {
            this.uA.setVisibility(0);
        } else {
            this.uA.setVisibility(8);
        }
    }

    public void Sj(boolean z10, String str) {
        this.EjP = z10;
        b bVar = this.sP;
        if (bVar != null) {
            bVar.Sj(z10, str);
        }
    }

    public boolean Sj(long j11, boolean z10, boolean z11) {
        boolean z12 = false;
        this.dNu.setVisibility(0);
        this.LqL = j11;
        if (!fF()) {
            return true;
        }
        this.sP.Sj(false);
        sU sUVar = this.Sj;
        if (sUVar != null && sUVar.UHs() != null) {
            com.bytedance.sdk.openadsdk.core.aa.Sj.sP Sj2 = sU.Sj(CacheDirFactory.getICacheDir(this.Sj.Gn()).TKC(), this.Sj);
            Sj2.sP(this.Sj.aZ());
            Sj2.Sj(this.dNu.getWidth());
            Sj2.sP(this.dNu.getHeight());
            Sj2.TKC(this.Sj.mZN());
            Sj2.Sj(j11);
            Sj2.Sj(uA());
            Sj(Sj2);
            if (z11) {
                this.sP.sP(Sj2);
                return true;
            }
            z12 = this.sP.Sj(Sj2);
        }
        if (((j11 > 0 && !z10 && !z11) || (j11 > 0 && z10)) && this.sP != null) {
            Zq.Sj sj2 = new Zq.Sj();
            sj2.Sj(this.sP.HiB());
            sj2.TKC(this.sP.Dq());
            sj2.sP(this.sP.vS());
            com.bytedance.sdk.openadsdk.EjP.HiB.Sj.Sj.sP(this.sP.Fmk(), sj2);
        }
        return z12;
    }

    public void TEQ() {
        c Fmk;
        b bVar = this.sP;
        if (bVar == null || (Fmk = bVar.Fmk()) == null) {
            return;
        }
        Fmk.Sj();
        View TKC = Fmk.TKC();
        if (TKC != null) {
            TKC.setVisibility(8);
            if (TKC.getParent() != null) {
                ((ViewGroup) TKC.getParent()).removeView(TKC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TKC() {
        if (aa()) {
            return;
        }
        sef();
    }

    boolean Ym() {
        return LD.Sj(this, 50, com.bytedance.sdk.openadsdk.core.Dq.ib.sP(this.f21140aa) ? 1 : 5);
    }

    public void Zq() {
        sU sUVar = this.Sj;
        if (sUVar == null || sUVar.GMp() == null) {
            return;
        }
        this.Sj.GMp().Zq();
        this.Sj.GMp().Sj().HiB(this.LqL);
    }

    public boolean aa() {
        boolean z10 = false;
        if (TzV.TKC(dNu.Sj()) == 0) {
            return false;
        }
        if (this.sP.aa() != null && this.sP.aa().vS()) {
            Sj(false, f21139dx.intValue());
            Handler handler = this.LD;
            z10 = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z10;
    }

    public double getCurrentPlayTime() {
        if (this.sP != null) {
            return (r0.HiB() * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public b getNativeVideoController() {
        return this.sP;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sU();
        getViewTreeObserver().addOnScrollChangedListener(this.xhi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dx();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.xhi);
        }
        ViewGroup viewGroup = this.dNu;
        if (viewGroup == null || this.xD == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.xD);
            this.xD = null;
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        sU();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        sP sPVar;
        b bVar;
        if (!this.RiZ && (sPVar = this.Zq) != null && (bVar = this.sP) != null) {
            sPVar.Sj(bVar.Zq(), this.sP.Dq(), this.sP.uA(), this.sP.HiB(), this.TzV);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dx();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        if ("open_ad".equals(this.f21140aa)) {
            ley();
            return;
        }
        this.kF = z10;
        super.onWindowFocusChanged(z10);
        com.bytedance.sdk.openadsdk.kF.Sj.TKC.Sj(this.Sj, z10);
        LqL();
        if (uP() && (bVar4 = this.sP) != null && bVar4.Zq()) {
            wE();
            FPG.Sj((View) this.Jcg, 8);
            sP(true);
            EjP();
            return;
        }
        sP();
        if (!fF() && Dq() && (bVar2 = this.sP) != null && !bVar2.Ym()) {
            if (this.LD != null) {
                if (z10 && (bVar3 = this.sP) != null && !bVar3.Zq()) {
                    this.LD.obtainMessage(1).sendToTarget();
                    return;
                } else {
                    ley();
                    Sj(false, f21139dx.intValue());
                    return;
                }
            }
            return;
        }
        if (Dq()) {
            return;
        }
        if (!z10 && (bVar = this.sP) != null && bVar.aa() != null && this.sP.aa().vS()) {
            ley();
            Sj(false, f21139dx.intValue());
        } else if (z10) {
            this.LD.obtainMessage(1).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        b bVar;
        sU sUVar;
        b bVar2;
        b bVar3;
        super.onWindowVisibilityChanged(i11);
        LqL();
        if (this.Ei) {
            this.Ei = i11 == 0;
        }
        if (uP() && (bVar3 = this.sP) != null && bVar3.Zq()) {
            wE();
            FPG.Sj((View) this.Jcg, 8);
            sP(true);
            EjP();
            return;
        }
        sP();
        if (fF() || !Dq() || (bVar = this.sP) == null || bVar.Ym() || (sUVar = this.Sj) == null) {
            return;
        }
        if (this.ley && sUVar.UHs() != null) {
            this.Sj.UHs();
            com.bytedance.sdk.openadsdk.core.aa.Sj.sP Sj2 = sU.Sj(CacheDirFactory.getICacheDir(this.Sj.Gn()).TKC(), this.Sj);
            Sj2.sP(this.Sj.aZ());
            Sj2.Sj(this.dNu.getWidth());
            Sj2.sP(this.dNu.getHeight());
            Sj2.TKC(this.Sj.mZN());
            Sj2.Sj(this.LqL);
            Sj2.Sj(uA());
            Sj(Sj2);
            this.sP.Sj(Sj2);
            this.ley = false;
            FPG.Sj((View) this.Jcg, 8);
        }
        if (i11 != 0 || this.LD == null || (bVar2 = this.sP) == null || bVar2.Zq()) {
            return;
        }
        this.LD.obtainMessage(1).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sP() {
        sU sUVar = this.Sj;
        if (sUVar == null) {
            return;
        }
        int If = sUVar.If();
        int sP2 = dNu.EjP().sP(If);
        int TKC = TzV.TKC(dNu.Sj());
        if (sP2 == 1) {
            this.TzV = Mts.EjP(TKC);
        } else if (sP2 == 2) {
            this.TzV = Mts.HiB(TKC) || Mts.EjP(TKC) || Mts.vS(TKC);
        } else if (sP2 == 3) {
            this.TzV = false;
        } else if (sP2 == 4) {
            this.sef = true;
        } else if (sP2 == 5) {
            this.TzV = Mts.EjP(TKC) || Mts.vS(TKC);
        }
        if (this.RiZ) {
            this.EjP = false;
        } else if (!this.HiB || !com.bytedance.sdk.openadsdk.core.Dq.ib.sP(this.f21140aa)) {
            this.EjP = dNu.EjP().TKC(String.valueOf(If));
        }
        if ("open_ad".equals(this.f21140aa)) {
            this.TzV = true;
            this.EjP = true;
        }
        b bVar = this.sP;
        if (bVar != null) {
            bVar.TKC(this.TzV);
        }
        this.HiB = true;
    }

    @Override // u5.b.InterfaceC0963b
    public void sP(long j11, int i11) {
    }

    public void sP(boolean z10) {
        b bVar = this.sP;
        if (bVar != null) {
            bVar.sP(z10);
            c Fmk = this.sP.Fmk();
            if (Fmk != null) {
                Fmk.sP();
                View TKC = Fmk.TKC();
                if (TKC != null) {
                    if (TKC.getParent() != null) {
                        ((ViewGroup) TKC.getParent()).removeView(TKC);
                    }
                    TKC.setVisibility(0);
                    addView(TKC);
                    Fmk.Sj(this.Sj, new WeakReference(this.uvD), false);
                }
            }
        }
    }

    public void sef() {
        if (TzV.TKC(dNu.Sj()) != 0 && Ym()) {
            if (this.sP.aa() != null && this.sP.aa().Jcg()) {
                Sj(true, zR.intValue());
                sP();
                Handler handler = this.LD;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                return;
            }
            if (Dq() || this.HpB.get()) {
                return;
            }
            this.HpB.set(true);
            JcM();
            sU sUVar = this.Sj;
            if (sUVar != null && sUVar.UHs() != null) {
                JcM();
                this.Sj.UHs();
                com.bytedance.sdk.openadsdk.core.aa.Sj.sP Sj2 = sU.Sj(CacheDirFactory.getICacheDir(this.Sj.Gn()).TKC(), this.Sj);
                Sj2.sP(this.Sj.aZ());
                Sj2.Sj(this.dNu.getWidth());
                Sj2.sP(this.dNu.getHeight());
                Sj2.TKC(this.Sj.mZN());
                Sj2.Sj(this.LqL);
                Sj2.Sj(uA());
                Sj2.Sj(CacheDirFactory.getICacheDir(this.Sj.Gn()).TKC());
                Sj(Sj2);
                this.sP.Sj(Sj2);
            }
            Handler handler2 = this.LD;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500L);
            }
            Sj(false);
        }
    }

    public void setAdCreativeClickListener(Sj sj2) {
        b bVar = this.sP;
        if (bVar != null) {
            ((TKC) bVar).Sj(sj2);
        }
    }

    public void setControllerStatusCallBack(sP sPVar) {
        this.Zq = sPVar;
    }

    public void setIsAutoPlay(boolean z10) {
        if (this.WMZ) {
            return;
        }
        int sP2 = dNu.EjP().sP(this.Sj.If());
        if (z10 && sP2 != 4 && (!TzV.HiB(this.uvD) ? !(!TzV.vS(this.uvD) ? TzV.EjP(this.uvD) : Yf() || LD()) : !Yf())) {
            z10 = false;
        }
        this.TzV = z10;
        b bVar = this.sP;
        if (bVar != null) {
            bVar.TKC(z10);
        }
        if (this.TzV) {
            FPG.Sj((View) this.Jcg, 8);
        } else {
            Jcg();
            RelativeLayout relativeLayout = this.Jcg;
            if (relativeLayout != null) {
                FPG.Sj((View) relativeLayout, 0);
                sU sUVar = this.Sj;
                if (sUVar != null && sUVar.UHs() != null) {
                    com.bytedance.sdk.openadsdk.TzV.sP.Sj().Sj(this.Sj.UHs().r(), this.Sj.UHs().t(), this.Sj.UHs().C(), this.Dq, this.Sj);
                }
            }
        }
        this.WMZ = true;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z10) {
        this.Ym = z10;
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        b bVar = this.sP;
        if (bVar != null) {
            ((TKC) bVar).Sj(pAGNativeAd);
        }
    }

    public void setVideoAdInteractionListener(b.c cVar) {
        this.Wjd = cVar;
    }

    public void setVideoAdLoadListener(b.a aVar) {
        b bVar = this.sP;
        if (bVar != null) {
            bVar.Sj(aVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.sU = str;
    }

    public void setVideoPlayCallback(com.bytedance.sdk.openadsdk.core.aa.sP.sP sPVar) {
        b bVar = this.sP;
        if (bVar != null) {
            ((TKC) bVar).Sj(sPVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 == 4 || i11 == 8) {
            zR();
        }
    }

    public boolean uA() {
        return this.EjP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.aa.sP.TKC.Sj
    public void vS() {
        b.c cVar = this.Wjd;
        if (cVar != null) {
            cVar.d_();
        }
    }
}
