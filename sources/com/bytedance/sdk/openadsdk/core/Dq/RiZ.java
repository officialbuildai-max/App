package com.bytedance.sdk.openadsdk.core.Dq;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import com.bytedance.sdk.component.adexpress.sP.TEQ;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.LD;
import com.bytedance.sdk.openadsdk.core.TKC.EjP;
import com.bytedance.sdk.openadsdk.core.Yf;
import com.bytedance.sdk.openadsdk.core.fF;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.sP.Sj;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.bytedance.sdk.openadsdk.kF.sP.HiB;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RiZ extends com.bytedance.sdk.openadsdk.core.HiB.TKC implements com.bytedance.sdk.component.adexpress.dynamic.EjP, com.bytedance.sdk.component.adexpress.sP.Dq, com.bytedance.sdk.component.adexpress.sP.Zq, sef, Sj.InterfaceC0286Sj {
    public static int zR = 500;
    private com.bytedance.sdk.component.adexpress.sP.Fmk Bml;
    private com.bytedance.sdk.component.adexpress.sP.uA Chv;
    protected final Context Dq;
    private com.bytedance.sdk.openadsdk.core.TEQ.sP.Jcg EZ;
    private final AtomicBoolean Ei;
    private TTDislikeDialogAbstract EjP;
    private com.bytedance.sdk.openadsdk.core.TEQ.TKC.sP FPG;
    private boolean Fm;
    protected boolean Fmk;
    private PAGExpressAdWrapperListener HiB;
    private TKC HpB;
    private com.bytedance.sdk.component.adexpress.sP.uvD IOh;
    private long Ir;
    private float JcM;
    private uA Jcg;
    private String LD;
    protected com.bytedance.sdk.component.adexpress.sP.sP LqL;
    private String Mts;
    private List<com.bytedance.sdk.component.adexpress.sP.TEQ> MuB;
    protected String RiZ;
    private boolean Sj;
    protected AdSlot TEQ;
    private com.bytedance.sdk.openadsdk.TKC.TKC TKC;
    protected int TzV;
    private ThemeStatusBroadcastReceiver UHs;
    private float Uc;
    private com.bytedance.sdk.openadsdk.EjP.EjP.HiB WMZ;
    private String Wjd;
    public com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> Yf;
    protected com.bytedance.sdk.openadsdk.core.model.sU Ym;
    protected com.bytedance.sdk.component.adexpress.sP.TKC Zq;
    private int aNB;
    private com.bytedance.sdk.openadsdk.core.TKC.Jcg aZ;

    /* renamed from: aa, reason: collision with root package name */
    public FrameLayout f21096aa;
    private final SparseArray<TKC.Sj> cX;
    boolean dNu;

    /* renamed from: db, reason: collision with root package name */
    private final Runnable f21097db;
    private ib dwU;

    /* renamed from: dx, reason: collision with root package name */
    protected ViewGroup f21098dx;
    private float fF;
    private float gR;
    private com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC gY;

    /* renamed from: ib, reason: collision with root package name */
    public boolean f21099ib;

    /* renamed from: jb, reason: collision with root package name */
    private dx f21100jb;
    int kF;

    /* renamed from: kb, reason: collision with root package name */
    private float f21101kb;
    long ley;
    private final Runnable ndK;
    private com.bytedance.sdk.component.adexpress.sP.vS pfr;
    private final Runnable qRN;
    private int sP;
    protected HashSet<String> sU;
    private TEQ.Sj sdp;
    protected boolean sef;
    protected String uA;
    boolean uP;
    protected boolean uvD;
    private Dq vS;
    public com.bytedance.sdk.openadsdk.EjP.Jcg wE;
    private EjP.Sj xD;
    private final ViewTreeObserver.OnScrollChangedListener xhi;

    /* renamed from: xu, reason: collision with root package name */
    private float f21102xu;

    public RiZ(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.sU sUVar, AdSlot adSlot, String str) {
        super(context);
        this.Sj = true;
        this.sP = 0;
        this.uA = "embeded_ad";
        this.LD = null;
        this.sef = false;
        this.uvD = false;
        this.dNu = true;
        this.TzV = -1;
        this.Mts = "";
        this.f21099ib = false;
        this.Fm = true;
        this.kF = -1;
        this.wE = new com.bytedance.sdk.openadsdk.EjP.Jcg();
        this.ley = 0L;
        this.Ei = new AtomicBoolean(false);
        this.xhi = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RiZ riZ = RiZ.this;
                if (riZ.dNu) {
                    riZ.zR();
                    RiZ riZ2 = RiZ.this;
                    riZ2.removeCallbacks(riZ2.f21097db);
                    RiZ riZ3 = RiZ.this;
                    riZ3.postDelayed(riZ3.f21097db, 500L);
                }
            }
        };
        this.f21097db = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.2
            @Override // java.lang.Runnable
            public void run() {
                if (!LD.Sj(RiZ.this, 0, 5)) {
                    RiZ.this.vS(8);
                } else {
                    RiZ riZ = RiZ.this;
                    riZ.vS(riZ.getVisibility());
                }
            }
        };
        this.ndK = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.3
            @Override // java.lang.Runnable
            public void run() {
                RiZ.this.vS(0);
            }
        };
        this.qRN = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.4
            @Override // java.lang.Runnable
            public void run() {
                RiZ.this.vS(8);
            }
        };
        this.aNB = 8;
        this.cX = new SparseArray<>();
        this.f21101kb = -1.0f;
        this.Uc = -1.0f;
        this.f21102xu = -1.0f;
        this.gR = -1.0f;
        this.Ir = 0L;
        this.uA = str;
        this.Dq = context;
        this.Ym = sUVar;
        this.TEQ = adSlot;
        this.f21099ib = false;
        vS();
    }

    public RiZ(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.sU sUVar, AdSlot adSlot, String str, boolean z10, boolean z11) {
        super(context);
        this.Sj = true;
        this.sP = 0;
        this.uA = "embeded_ad";
        this.LD = null;
        this.sef = false;
        this.uvD = false;
        this.dNu = true;
        this.TzV = -1;
        this.Mts = "";
        this.f21099ib = false;
        this.Fm = true;
        this.kF = -1;
        this.wE = new com.bytedance.sdk.openadsdk.EjP.Jcg();
        this.ley = 0L;
        this.Ei = new AtomicBoolean(false);
        this.xhi = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RiZ riZ = RiZ.this;
                if (riZ.dNu) {
                    riZ.zR();
                    RiZ riZ2 = RiZ.this;
                    riZ2.removeCallbacks(riZ2.f21097db);
                    RiZ riZ3 = RiZ.this;
                    riZ3.postDelayed(riZ3.f21097db, 500L);
                }
            }
        };
        this.f21097db = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.2
            @Override // java.lang.Runnable
            public void run() {
                if (!LD.Sj(RiZ.this, 0, 5)) {
                    RiZ.this.vS(8);
                } else {
                    RiZ riZ = RiZ.this;
                    riZ.vS(riZ.getVisibility());
                }
            }
        };
        this.ndK = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.3
            @Override // java.lang.Runnable
            public void run() {
                RiZ.this.vS(0);
            }
        };
        this.qRN = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.4
            @Override // java.lang.Runnable
            public void run() {
                RiZ.this.vS(8);
            }
        };
        this.aNB = 8;
        this.cX = new SparseArray<>();
        this.f21101kb = -1.0f;
        this.Uc = -1.0f;
        this.f21102xu = -1.0f;
        this.gR = -1.0f;
        this.Ir = 0L;
        this.uA = str;
        this.Dq = context;
        this.Ym = sUVar;
        this.TEQ = adSlot;
        this.f21099ib = z10;
        this.Fm = z11;
        vS();
    }

    private void Jcg() {
        sU.Sj xhi = this.Ym.xhi();
        if (!TextUtils.equals(this.uA, "embeded_ad") || xhi == null) {
            return;
        }
        String aa2 = xhi.aa();
        if (TextUtils.isEmpty(aa2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(aa2);
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            if (optInt == 0 || optInt2 == 0) {
                return;
            }
            this.JcM = optInt2;
            this.fF = optInt;
        } catch (Exception unused) {
        }
    }

    private void RiZ() {
        this.sP = this.Ym.fF();
        try {
            sU();
            dx();
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.Sj("NativeExpressView", "NativeExpressView dynamicRender fail", e11);
        }
        boolean z10 = this.Ym.JcM() == 1;
        this.Sj = z10;
        if (z10) {
            com.bytedance.sdk.component.adexpress.sP.vS vSVar = new com.bytedance.sdk.component.adexpress.sP.vS(this.Dq, this.Bml, new sU(this, this.UHs, this.Bml));
            this.pfr = vSVar;
            this.MuB.add(vSVar);
        }
        Objects.toString(this.MuB);
        this.sdp = new com.bytedance.sdk.component.adexpress.sP.aa(this.MuB, this.Chv);
    }

    public static JSONObject Sj(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(TtmlNode.LEFT, iArr[0]);
            jSONObject.put(IntegrationConstants.TAB_BAR_POSITION_TOP, iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void TzV() {
        if (this.Ym.DKa() == 1 && this.Ym.Ph()) {
            com.bytedance.sdk.component.adexpress.sP.vS vSVar = new com.bytedance.sdk.component.adexpress.sP.vS(this.Dq, this.Bml, new sU(this, this.UHs, this.Bml));
            this.pfr = vSVar;
            this.MuB.add(vSVar);
            this.sdp = new com.bytedance.sdk.component.adexpress.sP.aa(this.MuB, this.Chv);
            return;
        }
        if (wE()) {
            RiZ();
            return;
        }
        try {
            sU();
            ib ibVar = new ib(this.Dq, this.Bml, this.UHs, this.WMZ, this.Ym);
            this.dwU = ibVar;
            com.bytedance.sdk.component.adexpress.sP.uvD uvd = new com.bytedance.sdk.component.adexpress.sP.uvD(this.Dq, this.Bml, ibVar, this);
            this.IOh = uvd;
            this.MuB.add(uvd);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.Sj("NativeExpressView", "NativeExpressView dynamicRender fail", e11);
        }
        com.bytedance.sdk.component.adexpress.sP.vS vSVar2 = new com.bytedance.sdk.component.adexpress.sP.vS(this.Dq, this.Bml, new sU(this, this.UHs, this.Bml));
        this.pfr = vSVar2;
        this.MuB.add(vSVar2);
        this.sdp = new com.bytedance.sdk.component.adexpress.sP.aa(this.MuB, this.Chv);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:1|2|3|(2:5|(22:7|8|9|10|(2:12|(13:14|15|16|(2:22|23)|47|25|(1:27)(1:45)|28|(1:44)|32|(3:40|(1:42)|43)(1:36)|37|38))|50|15|16|(4:18|20|22|23)|47|25|(0)(0)|28|(1:30)|44|32|(1:34)|40|(0)|43|37|38))|53|8|9|10|(0)|50|15|16|(0)|47|25|(0)(0)|28|(0)|44|32|(0)|40|(0)|43|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        if (r12.Ym.DKj() != 3) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0081, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[Catch: Exception -> 0x0081, TRY_LEAVE, TryCatch #2 {Exception -> 0x0081, blocks: (B:10:0x0041, B:12:0x0049), top: B:9:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: Exception -> 0x0082, TryCatch #1 {Exception -> 0x0082, blocks: (B:16:0x0058, B:18:0x0064, B:20:0x006d, B:22:0x0076), top: B:15:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void dNu() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Dq.RiZ.dNu():void");
    }

    private void dx() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Ym;
        if (sUVar == null || sUVar.DKa() != 1 || this.Ym.ley() == 2) {
            com.bytedance.sdk.openadsdk.core.vS.Sj.Sj sj2 = new com.bytedance.sdk.openadsdk.core.vS.Sj.Sj();
            int i11 = this.sP;
            if (i11 != 0) {
                if (i11 == 3) {
                    com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg jcg = new com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg();
                    Context applicationContext = this.Dq.getApplicationContext();
                    com.bytedance.sdk.component.adexpress.sP.Fmk fmk = this.Bml;
                    ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = this.UHs;
                    boolean z10 = this.f21099ib;
                    com.bytedance.sdk.component.adexpress.sP.sP sPVar = new com.bytedance.sdk.component.adexpress.sP.sP(applicationContext, fmk, themeStatusBroadcastReceiver, z10, jcg, this, sj2, new vS(this.Dq, themeStatusBroadcastReceiver, z10, jcg, fmk, sj2));
                    this.LqL = sPVar;
                    this.MuB.add(sPVar);
                    return;
                }
                if (i11 == 7) {
                    com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC tkc = new com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC(this.Dq, this.Ym, this.f21099ib, (com.bytedance.sdk.openadsdk.core.TEQ.HiB.Sj) this.Bml, this);
                    this.gY = tkc;
                    com.bytedance.sdk.openadsdk.core.TEQ.sP.Jcg jcg2 = new com.bytedance.sdk.openadsdk.core.TEQ.sP.Jcg(this.Dq, tkc, this, this.Bml);
                    this.EZ = jcg2;
                    this.MuB.add(jcg2);
                    return;
                }
                if (i11 != 9) {
                    if (i11 != 10) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.TEQ.sP.Jcg jcg3 = new com.bytedance.sdk.openadsdk.core.TEQ.sP.Jcg(this.Dq, new com.bytedance.sdk.openadsdk.core.TEQ.HiB.HiB(this.Dq, this.Ym, this.f21099ib, (com.bytedance.sdk.openadsdk.core.TEQ.HiB.Sj) this.Bml, this), this, this.Bml);
                    this.EZ = jcg3;
                    this.MuB.add(jcg3);
                    return;
                }
            }
            ib ibVar = new ib(this.Dq, this.Bml, this.UHs, this.WMZ, this.Ym);
            this.dwU = ibVar;
            com.bytedance.sdk.component.adexpress.sP.uvD uvd = new com.bytedance.sdk.component.adexpress.sP.uvD(this.Dq, this.Bml, ibVar, this);
            this.IOh = uvd;
            this.MuB.add(uvd);
        }
    }

    private int getAdSlotType() {
        String str = this.uA;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1263194568:
                if (str.equals("open_ad")) {
                    c11 = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 3;
            case 3:
                return 8;
            case 4:
                return 2;
            default:
                return 5;
        }
    }

    private boolean ib() {
        return com.bytedance.sdk.openadsdk.core.model.sU.HiB(this.Ym);
    }

    private void kF() {
        List<com.bytedance.sdk.component.adexpress.sP.TEQ> list = this.MuB;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.sP.TEQ> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void sU() {
        if (com.bytedance.sdk.openadsdk.core.sef.HiB()) {
            return;
        }
        aa.Sj();
    }

    private void uP() {
        List<com.bytedance.sdk.component.adexpress.sP.TEQ> list = this.MuB;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.sP.TEQ> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private boolean wE() {
        return TextUtils.equals(this.uA, "fullscreen_interstitial_ad") || TextUtils.equals(this.uA, "rewarded_video") || TextUtils.equals("open_ad", this.uA) || ib.sP(this.uA) || TextUtils.equals(this.uA, "embeded_ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR() {
        if (this.Ei.get()) {
            this.wE.Sj(System.currentTimeMillis(), LD.Sj(this));
        }
    }

    public void Dq() {
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP instanceof ib) {
            if (ejP == null) {
                return;
            }
            ((ib) ejP).Dq();
            com.bytedance.sdk.component.utils.uA.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.6
                @Override // java.lang.Runnable
                public void run() {
                    RiZ.this.HiB(1);
                }
            }, (this.Ym != null ? r0.sef().EjP() : 5) * 1000);
        }
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Ym;
        if (sUVar != null && sUVar.GMp() != null && this.Ym.GMp().Sj() != null) {
            this.Ym.GMp().Sj().Sj(0L);
        }
        if ((this.Yf instanceof com.bytedance.sdk.openadsdk.core.TEQ.HiB.HiB) && com.bytedance.sdk.openadsdk.core.model.Zq.Sj(this.Ym)) {
            Sj(this.Yf);
        }
    }

    public int EjP() {
        return 0;
    }

    public boolean Fmk() {
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        return ejP != null && (ejP instanceof sU);
    }

    public void HiB() {
    }

    public void HiB(int i11) {
        if (com.bytedance.sdk.openadsdk.core.model.TzV.TKC(this.Ym)) {
            com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
            if (ejP instanceof ib) {
                ((ib) ejP).sP(i11);
            }
        }
    }

    public JSONObject Sj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (!(this.Yf instanceof ib)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int renderEngineCacheType = getRenderEngineCacheType();
            if (sUVar != null) {
                if (sUVar.xhi() != null && sUVar.xhi().sef()) {
                    jSONObject.put("engine_version", sUVar.xhi().Fmk());
                } else if (sUVar.ndK() != null) {
                    jSONObject.put("engine_version", "v3");
                } else {
                    jSONObject.put("engine_version", "v1");
                }
            }
            jSONObject.put("engine_type", renderEngineCacheType);
        } catch (Exception e11) {
            e11.getMessage();
        }
        return jSONObject;
    }

    public void Sj() {
    }

    public void Sj(int i11) {
    }

    public void Sj(int i11, com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
    }

    public void Sj(int i11, String str) {
    }

    public void Sj(int i11, boolean z10, boolean z11) {
        this.dNu = z10;
        removeCallbacks(this.qRN);
        removeCallbacks(this.ndK);
        if (i11 == 0) {
            if (z11) {
                this.ndK.run();
                return;
            } else {
                postDelayed(this.ndK, 50L);
                return;
            }
        }
        if (z11) {
            this.qRN.run();
        } else {
            postDelayed(this.qRN, 50L);
        }
    }

    public void Sj(View view, int i11, com.bytedance.sdk.component.adexpress.TKC tkc) {
        View view2;
        JSONObject jSONObject;
        com.bytedance.sdk.component.utils.sU.Sj("ClickCreativeListener", "trigger Class2 method1", Integer.valueOf(i11));
        if (i11 == -1 || tkc == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (uP.TKC(this.Ym)) {
            hashMap.put("click_scence", 3);
        } else {
            hashMap.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.model.sef sefVar = (com.bytedance.sdk.openadsdk.core.model.sef) tkc;
        if (com.bytedance.sdk.openadsdk.core.model.TzV.TKC(this.Ym)) {
            try {
                JSONObject jSONObject2 = sefVar.dNu;
                if (jSONObject2 != null) {
                    int optInt = jSONObject2.optInt("click_type", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("click_type", optInt);
                    hashMap.put("pag_json_data", jSONObject3.toString());
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP(th2.toString(), new Object[0]);
            }
        }
        Dq dq2 = this.vS;
        if (dq2 != null) {
            dq2.EjP(getDynamicShowType());
            this.vS.Sj(hashMap);
        }
        uA uAVar = this.Jcg;
        if (uAVar != null) {
            uAVar.EjP(getDynamicShowType());
            this.Jcg.Sj(hashMap);
        }
        float f11 = sefVar.Sj;
        float f12 = sefVar.sP;
        float f13 = sefVar.TKC;
        float f14 = sefVar.EjP;
        boolean z10 = sefVar.Zq;
        SparseArray<TKC.Sj> sparseArray = sefVar.sef;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.cX;
        }
        SparseArray<TKC.Sj> sparseArray2 = sparseArray;
        String str = sefVar.Ym;
        if (view == null) {
            view2 = this;
        } else {
            r4 = view != this ? Sj(view) : null;
            view2 = view;
        }
        sefVar.f21158aa = i11;
        if (r4 != null && sefVar.Fmk == null) {
            sefVar.Fmk = r4;
        }
        switch (i11) {
            case 1:
                FrameLayout frameLayout = this.f21096aa;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Ym;
                if (sUVar == null || sUVar.ib() != 1 || z10) {
                    uA uAVar2 = this.Jcg;
                    if (uAVar2 != null) {
                        uAVar2.Sj(sefVar);
                        this.Jcg.Sj(str);
                        this.Jcg.Sj(view2, f11, f12, f13, f14, sparseArray2, z10);
                    }
                    PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.HiB;
                    if (pAGExpressAdWrapperListener == null || sefVar.TzV) {
                        return;
                    }
                    pAGExpressAdWrapperListener.onAdClicked();
                    return;
                }
                return;
            case 2:
                if (sefVar.uvD > 0) {
                    fF.Sj(true);
                }
                Dq dq3 = this.vS;
                if (dq3 != null) {
                    dq3.Sj(sefVar);
                    this.vS.Sj(str);
                    if (com.bytedance.sdk.openadsdk.core.model.TzV.TKC(this.Ym) && (jSONObject = sefVar.dNu) != null) {
                        this.vS.EjP(jSONObject.optBoolean("is_ceiling_page", false));
                    }
                    this.vS.Sj(view2, f11, f12, f13, f14, sparseArray2, z10);
                }
                PAGExpressAdWrapperListener pAGExpressAdWrapperListener2 = this.HiB;
                if (pAGExpressAdWrapperListener2 != null && !sefVar.TzV) {
                    pAGExpressAdWrapperListener2.onAdClicked();
                }
                fF.Sj(false);
                com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(this.Ym, 9);
                return;
            case 3:
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.EjP;
                if (tTDislikeDialogAbstract != null) {
                    tTDislikeDialogAbstract.show();
                    return;
                }
                com.bytedance.sdk.openadsdk.TKC.TKC tkc2 = this.TKC;
                if (tkc2 != null) {
                    tkc2.Sj();
                    return;
                } else {
                    TTDelegateActivity.Sj(this.Ym, this.Wjd);
                    return;
                }
            case 4:
                FrameLayout frameLayout2 = this.f21096aa;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.model.sU sUVar2 = this.Ym;
                if (sUVar2 == null || sUVar2.ib() != 1 || z10) {
                    Mts.TKC(this.Ym);
                    if ("embeded_ad".equals(this.uA) && ib() && !this.Fmk && Mts.TKC(this.Ym)) {
                        Dq dq4 = this.vS;
                        if (dq4 != null) {
                            dq4.Sj(sefVar);
                            this.vS.Sj(str);
                            this.vS.Sj(view2, f11, f12, f13, f14, sparseArray2, z10);
                        }
                    } else {
                        uA uAVar3 = this.Jcg;
                        if (uAVar3 != null) {
                            uAVar3.Sj(sefVar);
                            this.Jcg.Sj(str);
                            this.Jcg.Sj(view2, f11, f12, f13, f14, sparseArray2, z10);
                        }
                    }
                    PAGExpressAdWrapperListener pAGExpressAdWrapperListener3 = this.HiB;
                    if (pAGExpressAdWrapperListener3 == null || sefVar.TzV) {
                        return;
                    }
                    pAGExpressAdWrapperListener3.onAdClicked();
                    return;
                }
                return;
            case 5:
                Sj(!this.f21099ib, "dynamicClick");
                return;
            case 6:
                Sj();
                return;
            case 7:
                TTWebsiteActivity.Sj(this.Dq, this.Ym, this.uA);
                return;
            default:
                return;
        }
    }

    public void Sj(com.bytedance.sdk.component.adexpress.sP.EjP ejP) {
        if (this.FPG == null) {
            return;
        }
        try {
            if (ejP instanceof com.bytedance.sdk.openadsdk.core.TEQ.HiB.HiB) {
                ViewGroup viewGroup = (ViewGroup) ((com.bytedance.sdk.openadsdk.core.TEQ.HiB.HiB) ejP).vS().Ym();
                this.f21098dx = viewGroup;
                if (viewGroup != null) {
                    this.FPG.Sj();
                    View sP = this.FPG.sP();
                    if (sP != null) {
                        ViewGroup viewGroup2 = (ViewGroup) sP.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(sP);
                        }
                        this.f21098dx.addView(sP, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void Sj(com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP, com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar;
        this.Ei.set(true);
        this.Yf = ejP;
        if (this.aNB != getWindowVisibility()) {
            vS(getWindowVisibility());
        }
        ejP.TKC();
        if (ejP.TKC() == 3 && (sUVar = this.Ym) != null && sUVar.dx() == 1) {
            this.Ym.HiB(0);
        }
        if (ejP.TKC() != 1) {
            View HiB = ejP.HiB();
            if (HiB.getParent() != null) {
                ((ViewGroup) HiB.getParent()).removeView(HiB);
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                arrayList.add(getChildAt(i11));
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                if (arrayList.get(i12) instanceof com.bytedance.sdk.component.uA.vS) {
                    removeView((View) arrayList.get(i12));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.model.TzV.TKC(this.Ym)) {
                addView(ejP.HiB(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                addView(ejP.HiB());
            }
        }
        com.bytedance.sdk.openadsdk.core.model.sU sUVar2 = this.Ym;
        if (sUVar2 != null) {
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(sUVar2.HiB(), this.ley, this.uA, ejP.TKC());
        }
        com.bytedance.sdk.component.adexpress.sP.uA uAVar = this.Chv;
        if (uAVar != null) {
            ((Fmk) uAVar).Ym();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.HiB;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderSuccess(this, (float) sefVar.EjP(), (float) sefVar.HiB());
        }
        if ((this.Yf instanceof com.bytedance.sdk.openadsdk.core.TEQ.HiB.HiB) && com.bytedance.sdk.openadsdk.core.model.Zq.Sj(this.Ym)) {
            uvD();
        }
        if (Sj(sefVar)) {
            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(this, this.Ym, TKC(getDynamicShowType()));
        }
        dx dxVar = this.f21100jb;
        if (dxVar != null) {
            dxVar.Sj(this.Ym, this.uA);
        }
    }

    protected void Sj(Fmk.Sj sj2) {
    }

    public void Sj(String str, JSONObject jSONObject) {
    }

    protected void Sj(JSONObject jSONObject) {
    }

    public void Sj(boolean z10, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Sj(com.bytedance.sdk.component.adexpress.sP.sef sefVar) {
        return true;
    }

    public void TEQ() {
        ib ibVar = this.dwU;
        if (ibVar == null || ibVar.HiB() == null) {
            return;
        }
        this.dwU.vS();
    }

    public long TKC() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HiB.Sj TKC(int i11) {
        return new HiB.Sj(i11);
    }

    public void Ym() {
        try {
            TKC tkc = this.HpB;
            if (tkc != null) {
                tkc.sP();
            }
            sef();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<com.bytedance.sdk.component.adexpress.sP.TEQ> list = this.MuB;
            if (list != null) {
                Iterator<com.bytedance.sdk.component.adexpress.sP.TEQ> it = list.iterator();
                while (it.hasNext()) {
                    it.next().Sj();
                }
            }
            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(this.Ym);
            com.bytedance.sdk.openadsdk.kF.Sj.TKC.sP(this.Ym);
            this.TKC = null;
            this.EjP = null;
            this.TEQ = null;
            this.Ym = null;
            this.HiB = null;
            this.vS = null;
            this.Zq = null;
            this.Jcg = null;
            com.bytedance.sdk.openadsdk.core.TEQ.TKC.sP sPVar = this.FPG;
            if (sPVar != null) {
                sPVar.TKC();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("NativeExpressView", "detach error", th2);
        }
    }

    public boolean Zq() {
        return this.Ei.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.Zq
    public void a_(int i11) {
        com.bytedance.sdk.component.adexpress.sP.uA uAVar = this.Chv;
        if (uAVar != null) {
            if (!this.Sj) {
                uAVar.Dq();
            }
            this.Chv.uA();
            ((Fmk) this.Chv).Ym();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.HiB;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.Dq.Sj(i11), i11);
        }
        dx dxVar = this.f21100jb;
        if (dxVar != null) {
            dxVar.Sj(this.Ym, this.uA);
        }
    }

    public void aa() {
        try {
            FrameLayout frameLayout = this.f21096aa;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.f21096aa);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            com.bytedance.sdk.openadsdk.core.Dq.Dq r0 = r12.vS
            r1 = 0
            if (r0 == 0) goto L1e
            int r2 = r13.getDeviceId()
            r0.sP(r2)
            com.bytedance.sdk.openadsdk.core.Dq.Dq r0 = r12.vS
            int r2 = r13.getSource()
            r0.Sj(r2)
            com.bytedance.sdk.openadsdk.core.Dq.Dq r0 = r12.vS
            int r2 = r13.getToolType(r1)
            r0.TKC(r2)
        L1e:
            com.bytedance.sdk.openadsdk.core.Dq.uA r0 = r12.Jcg
            if (r0 == 0) goto L3b
            int r2 = r13.getDeviceId()
            r0.sP(r2)
            com.bytedance.sdk.openadsdk.core.Dq.uA r0 = r12.Jcg
            int r2 = r13.getSource()
            r0.Sj(r2)
            com.bytedance.sdk.openadsdk.core.Dq.uA r0 = r12.Jcg
            int r2 = r13.getToolType(r1)
            r0.TKC(r2)
        L3b:
            int r0 = r13.getActionMasked()
            if (r0 == 0) goto L9a
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L4b
            r3 = 2
            if (r0 == r3) goto L4f
            if (r0 == r1) goto L4d
            r1 = -1
        L4b:
            r5 = r1
            goto Lad
        L4d:
            r1 = 4
            goto L4b
        L4f:
            float r0 = r12.f21102xu
            float r1 = r13.getX()
            float r4 = r12.f21101kb
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)
            float r0 = r0 + r1
            r12.f21102xu = r0
            float r0 = r12.gR
            float r1 = r13.getY()
            float r4 = r12.Uc
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)
            float r0 = r0 + r1
            r12.gR = r0
            float r0 = r13.getX()
            r12.f21101kb = r0
            float r0 = r13.getY()
            r12.Uc = r0
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r12.Ir
            long r0 = r0 - r4
            r4 = 200(0xc8, double:9.9E-322)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L98
            float r0 = r12.f21102xu
            r1 = 1090519040(0x41000000, float:8.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L96
            float r0 = r12.gR
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L98
        L96:
            r5 = r2
            goto Lad
        L98:
            r5 = r3
            goto Lad
        L9a:
            float r0 = r13.getRawX()
            r12.f21101kb = r0
            float r0 = r13.getRawY()
            r12.Uc = r0
            long r2 = java.lang.System.currentTimeMillis()
            r12.Ir = r2
            goto L4b
        Lad:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.sP.TKC$Sj> r0 = r12.cX
            if (r0 == 0) goto Lcc
            int r1 = r13.getActionMasked()
            com.bytedance.sdk.openadsdk.core.sP.TKC$Sj r2 = new com.bytedance.sdk.openadsdk.core.sP.TKC$Sj
            float r3 = r13.getSize()
            double r6 = (double) r3
            float r3 = r13.getPressure()
            double r8 = (double) r3
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r2
            r4.<init>(r5, r6, r8, r10)
            r0.put(r1, r2)
        Lcc:
            boolean r13 = super.dispatchTouchEvent(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Dq.RiZ.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public com.bytedance.sdk.openadsdk.EjP.Jcg getAdShowTime() {
        return this.wE;
    }

    public TKC getBrandBannerController() {
        return this.HpB;
    }

    public Dq getClickCreativeListener() {
        return this.vS;
    }

    public uA getClickListener() {
        return this.Jcg;
    }

    public String getClosedListenerKey() {
        return this.Wjd;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP != null) {
            return ejP.TKC();
        }
        return 0;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.JcM).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.fF).intValue();
    }

    public Yf getJsObject() {
        ib ibVar = this.dwU;
        if (ibVar != null) {
            return ibVar.uvD();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        TEQ Zq;
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (!(ejP instanceof ib) || (Zq = ((ib) ejP).Zq()) == null) {
            return 0;
        }
        return Zq.Sj();
    }

    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.dNu.EjP().uP();
    }

    public String getUgenTemplateErrorReason() {
        return this.Mts;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sP.Sj.InterfaceC0286Sj
    public long getVideoProgress() {
        com.bytedance.sdk.openadsdk.core.TKC.Jcg jcg = this.aZ;
        if (jcg != null) {
            return jcg.getVideoProgress();
        }
        return 0L;
    }

    public com.bytedance.sdk.component.uA.vS getWebView() {
        ib ibVar = this.dwU;
        if (ibVar == null) {
            return null;
        }
        return ibVar.Sj();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        zR();
        kF();
        getViewTreeObserver().addOnScrollChangedListener(this.xhi);
        com.bytedance.sdk.openadsdk.core.uA.sP().Sj(this.Wjd, this.xD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.xhi);
        com.bytedance.sdk.openadsdk.core.uA.sP().vS(this.Wjd);
        uP();
        Sj(8, true, true);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        zR();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z10 ? getVisibility() : 8);
        }
        zR();
        com.bytedance.sdk.openadsdk.kF.Sj.TKC.Sj(this.Ym, z10);
        if (z10) {
            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(this.Ym, 4);
        } else {
            com.bytedance.sdk.openadsdk.kF.sP.HiB.Sj(this.Ym, 8);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        Sj(i11, true, false);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EjP
    public void onvideoComplate() {
    }

    public void sP() {
    }

    public void sP(int i11) {
    }

    protected void sP(int i11, int i12) {
        int i13;
        if (TextUtils.equals(this.uA, "banner_ad")) {
            return;
        }
        int i14 = this.kF;
        int i15 = ((i12 < i14 || i14 < 0 || !(this.uP || TextUtils.equals(this.uA, "open_ad"))) && !((i11 == 0 && TextUtils.equals(this.uA, "open_ad")) || EjP() == 5)) ? 0 : 1;
        if (i12 <= this.kF) {
            com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Ym;
            i13 = (sUVar == null || sUVar.UHs() == null) ? this.kF - i12 : (int) (Math.min(this.kF, this.Ym.UHs().K() * this.Ym.UHs().N()) - i12);
        } else {
            i13 = 0;
        }
        com.bytedance.sdk.component.adexpress.sP.sP sPVar = this.LqL;
        if (sPVar != null && sPVar.sP() != null) {
            this.LqL.sP().setTime(String.valueOf(i11), i15, i13, false);
        }
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP instanceof com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC) {
            ((com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC) ejP).setTime(String.valueOf(i11), i15, i13, false);
        }
    }

    public void sP(int i11, String str) {
        Yf uvD;
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP == null || !(ejP instanceof ib) || (uvD = ((ib) ejP).uvD()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.KEY_TIME, i11);
            jSONObject.put("flag", str);
            uvD.Sj("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void sef() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Ym;
        if (sUVar == null || sUVar.GMp() == null || this.Ym.GMp().Sj() == null) {
            return;
        }
        this.Ym.GMp().Sj().HiB(getVideoProgress());
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.sP.TKC tkc) {
        this.Zq = tkc;
        com.bytedance.sdk.component.adexpress.sP.vS vSVar = this.pfr;
        if (vSVar != null) {
            vSVar.Sj(tkc);
        }
    }

    public void setBannerClickClosedListener(EjP.Sj sj2) {
        this.xD = sj2;
    }

    public void setClickCreativeListener(Dq dq2) {
        this.vS = dq2;
        if (dq2 != null) {
            dq2.Sj((Sj.InterfaceC0286Sj) this);
        }
    }

    public void setClickListener(uA uAVar) {
        this.Jcg = uAVar;
    }

    public void setClosedListenerKey(String str) {
        this.Wjd = str;
        TKC tkc = this.HpB;
        if (tkc != null) {
            tkc.Sj(str);
        }
    }

    public void setDislike(com.bytedance.sdk.openadsdk.TKC.TKC tkc) {
        Sj sj2;
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP != null && (ejP instanceof sU) && (sj2 = (Sj) ejP.HiB()) != null) {
            sj2.setDislikeInner(tkc);
        }
        TKC tkc2 = this.HpB;
        if (tkc2 != null) {
            tkc2.Sj(tkc);
        }
        this.TKC = tkc;
    }

    public void setExpressInteractionListener(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        this.HiB = pAGExpressAdWrapperListener;
        TKC tkc = this.HpB;
        if (tkc != null) {
            tkc.Sj(pAGExpressAdWrapperListener);
        }
    }

    public void setJsbLandingPageOpenListener(com.bytedance.sdk.openadsdk.core.widget.HiB hiB) {
        if (this.dwU != null && getJsObject() != null) {
            getJsObject().Sj(hiB);
        }
        com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC tkc = this.gY;
        if (tkc != null) {
            tkc.Sj(hiB);
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Sj sj2;
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP != null && (ejP instanceof sU) && (sj2 = (Sj) ejP.HiB()) != null) {
            sj2.setDislikeOuter(tTDislikeDialogAbstract);
        }
        TKC tkc = this.HpB;
        if (tkc != null) {
            tkc.Sj(tTDislikeDialogAbstract);
        }
        this.EjP = tTDislikeDialogAbstract;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EjP
    public void setSoundMute(boolean z10) {
        this.f21099ib = z10;
        com.bytedance.sdk.component.adexpress.sP.sP sPVar = this.LqL;
        if (sPVar != null && sPVar.sP() != null) {
            this.LqL.sP().setSoundMute(z10);
        }
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP instanceof com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC) {
            ((com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC) ejP).setSoundMute(z10);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EjP
    public void setTime(CharSequence charSequence, int i11, int i12, boolean z10) {
        try {
            int parseInt = Integer.parseInt(String.valueOf(charSequence));
            sP(parseInt, i11);
            com.bytedance.sdk.openadsdk.core.TEQ.TKC.sP sPVar = this.FPG;
            if (sPVar != null) {
                sPVar.Sj(parseInt);
            }
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EjP
    public void setTimeUpdate(int i11) {
    }

    public void setVastVideoHelper(com.bytedance.sdk.openadsdk.core.TKC.Jcg jcg) {
        this.aZ = jcg;
    }

    public void setVideoFrameChangeListener(com.bytedance.sdk.openadsdk.aa.Jcg jcg) {
        if (this.dwU == null || getJsObject() == null) {
            return;
        }
        getJsObject().Sj(jcg);
    }

    public void uA() {
        if (this.Ym == null) {
            return;
        }
        this.ley = SystemClock.elapsedRealtime();
        if (this.Ym.hzV()) {
            TKC tkc = this.HpB;
            if (tkc == null) {
                a_(106);
                return;
            } else {
                tkc.Sj((com.bytedance.sdk.component.adexpress.sP.Zq) this);
                this.HpB.Sj();
                return;
            }
        }
        this.WMZ.Sj();
        TEQ.Sj sj2 = this.sdp;
        if (sj2 != null) {
            sj2.Sj(this);
        }
        try {
            this.sdp.Sj();
        } catch (Throwable unused) {
        }
    }

    public void uvD() {
        com.bytedance.sdk.openadsdk.core.TEQ.TKC.sP sPVar = new com.bytedance.sdk.openadsdk.core.TEQ.TKC.sP(this.Dq, this.Ym);
        this.FPG = sPVar;
        sPVar.Sj(this);
        this.FPG.Sj(new com.bytedance.sdk.openadsdk.core.TEQ.TKC.Sj() { // from class: com.bytedance.sdk.openadsdk.core.Dq.RiZ.7
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vS() {
        this.sU = new HashSet<>();
        this.UHs = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.TEQ;
        if (adSlot != null) {
            this.fF = adSlot.getExpressViewAcceptedWidth();
            this.JcM = this.TEQ.getExpressViewAcceptedHeight();
            Jcg();
            this.LD = this.TEQ.getCodeId();
            if (TextUtils.equals(this.uA, "fullscreen_interstitial_ad")) {
                com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.Ym;
                if (sUVar == null || sUVar.Sj() < 0) {
                    this.kF = com.bytedance.sdk.openadsdk.core.dNu.EjP().RiZ(this.LD);
                } else {
                    this.kF = this.Ym.Sj();
                }
            } else if (TextUtils.equals(this.uA, "rewarded_video")) {
                com.bytedance.sdk.openadsdk.core.model.sU sUVar2 = this.Ym;
                if (sUVar2 == null || sUVar2.sP() < 0) {
                    this.kF = com.bytedance.sdk.openadsdk.core.dNu.EjP().TEQ(this.LD);
                } else {
                    this.kF = this.Ym.sP();
                }
            } else if (TextUtils.equals(this.uA, "open_ad")) {
                com.bytedance.sdk.openadsdk.core.model.sU sUVar3 = this.Ym;
                if (sUVar3 == null || sUVar3.TKC() < 0) {
                    this.kF = com.bytedance.sdk.openadsdk.core.dNu.EjP().zR(this.LD);
                } else {
                    this.kF = this.Ym.TKC();
                }
                if (this.kF < 0) {
                    this.kF = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.Ym.hzV()) {
            this.HpB = new TKC(this.Dq, this, this.Ym, this.uA);
            return;
        }
        dNu();
        this.MuB = new ArrayList();
        TzV();
        com.bytedance.sdk.component.adexpress.sP.uvD uvd = this.IOh;
        if (uvd != null) {
            this.dwU = (ib) uvd.sP();
        }
        Yf jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.vS(this.uA);
        }
    }

    public void vS(int i11) {
        com.bytedance.sdk.component.adexpress.sP.EjP<? extends View> ejP = this.Yf;
        if (ejP == null || !(ejP instanceof ib)) {
            return;
        }
        ((ib) ejP).Sj(i11);
        this.aNB = i11;
    }
}
