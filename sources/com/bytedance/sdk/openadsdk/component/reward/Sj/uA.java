package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.utils.LqL;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.sU.Jcg;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class uA implements Handler.Callback {
    private static final Jcg.Sj TEQ = new Jcg.Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.1
    };
    private boolean Dq;

    @NonNull
    private final sU Fmk;
    private com.bytedance.sdk.openadsdk.core.widget.TEQ RiZ;
    private volatile boolean Ym;
    private final Sj Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final Activity f21088aa;
    private TzV dNu;

    /* renamed from: dx, reason: collision with root package name */
    private HomeWatcherReceiver f21089dx;

    /* renamed from: ib, reason: collision with root package name */
    private boolean f21090ib;
    private volatile boolean kF;
    private final String sef;
    private boolean uA;
    private boolean uP;
    private boolean wE;
    private com.bytedance.sdk.openadsdk.sU.Dq zR;
    protected final AtomicBoolean Sj = new AtomicBoolean(false);
    private final Handler uvD = new Handler(this);
    boolean sP = false;
    boolean TKC = false;
    long EjP = 0;
    int HiB = 0;
    int vS = 0;
    int Jcg = 0;
    private int TzV = 1;
    private boolean sU = true;
    private final com.bytedance.sdk.openadsdk.aa.HiB ley = new com.bytedance.sdk.openadsdk.aa.HiB() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.8
        @Override // com.bytedance.sdk.openadsdk.aa.HiB
        public void Sj() {
            if (!uA.this.Zq.Fm.isFinishing() && uA.this.Zq.sP.eEJ() && uP.uvD(uA.this.Zq.sP)) {
                uA.this.uvD.removeMessages(LogSeverity.EMERGENCY_VALUE);
                uA.this.uvD.sendMessage(uA.Sj(1, 0));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.aa.HiB
        public void Sj(int i11) {
        }

        @Override // com.bytedance.sdk.openadsdk.aa.HiB
        public void sP() {
        }
    };

    public uA(Sj sj2) {
        this.Dq = true;
        this.Zq = sj2;
        this.f21088aa = sj2.Fm;
        this.sef = sj2.HiB;
        sU sUVar = sj2.sP;
        this.Fmk = sUVar;
        this.Dq = uP.Jcg(sUVar);
    }

    static /* synthetic */ com.bytedance.sdk.openadsdk.sU.EjP RiZ() {
        return sU();
    }

    public static Message Sj(int i11, int i12) {
        Message obtain = Message.obtain();
        obtain.what = LogSeverity.EMERGENCY_VALUE;
        obtain.arg1 = i11;
        if (i11 == 3) {
            obtain.arg2 = i12;
        }
        return obtain;
    }

    private void Sj(Context context) {
        if (this.Dq) {
            try {
                this.f21089dx.Sj(null);
                context.getApplicationContext().unregisterReceiver(this.f21089dx);
            } catch (Throwable unused) {
            }
        }
    }

    private void dx() {
        if (this.Dq) {
            this.RiZ = (com.bytedance.sdk.openadsdk.core.widget.TEQ) this.Zq.xD.findViewById(com.bytedance.sdk.openadsdk.utils.Zq.ewz);
        }
    }

    private String ib() {
        String kF = com.bytedance.sdk.openadsdk.core.dNu.EjP().kF();
        if (TextUtils.isEmpty(kF) || this.Fmk.tz() == null) {
            return kF;
        }
        String sP = this.Fmk.tz().sP();
        double EjP = this.Fmk.tz().EjP();
        int HiB = this.Fmk.tz().HiB();
        String Sj = (this.Fmk.EZ() == null || TextUtils.isEmpty(this.Fmk.EZ().Sj())) ? "" : this.Fmk.EZ().Sj();
        String aZ = this.Fmk.aZ();
        String TKC = this.Fmk.tz().TKC();
        String Sj2 = this.Fmk.tz().Sj();
        String sP2 = this.Fmk.tz().sP();
        String xu2 = this.Fmk.xu();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("appname=");
        sb2.append(URLEncoder.encode(sP));
        sb2.append("&stars=");
        sb2.append(EjP);
        sb2.append("&comments=");
        sb2.append(HiB);
        sb2.append("&icon=");
        sb2.append(URLEncoder.encode(Sj));
        sb2.append("&downloading=true&id=");
        sb2.append(URLEncoder.encode(aZ));
        sb2.append("&packageName=");
        sb2.append(URLEncoder.encode(TKC));
        sb2.append("&downloadUrl=");
        sb2.append(URLEncoder.encode(Sj2));
        sb2.append("&name=");
        sb2.append(URLEncoder.encode(sP2));
        sb2.append("&orientation=");
        sb2.append(this.TzV == 1 ? "portrait" : TmcStartParams.KEY_LANDSCAPE);
        sb2.append("&apptitle=");
        sb2.append(URLEncoder.encode(xu2));
        return kF + UrlUtils.QUESTION_MARK + ((Object) sb2);
    }

    @NonNull
    private static com.bytedance.sdk.openadsdk.sU.EjP sU() {
        String vS = com.bytedance.sdk.openadsdk.common.sP.vS();
        vS.hashCode();
        char c11 = 65535;
        switch (vS.hashCode()) {
            case 1653:
                if (vS.equals("2g")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1684:
                if (vS.equals("3g")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1715:
                if (vS.equals("4g")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1746:
                if (vS.equals("5g")) {
                    c11 = 3;
                    break;
                }
                break;
            case 3649301:
                if (vS.equals("wifi")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return com.bytedance.sdk.openadsdk.sU.EjP.TYPE_2G;
            case 1:
                return com.bytedance.sdk.openadsdk.sU.EjP.TYPE_3G;
            case 2:
                return com.bytedance.sdk.openadsdk.sU.EjP.TYPE_4G;
            case 3:
                return com.bytedance.sdk.openadsdk.sU.EjP.TYPE_5G;
            case 4:
                return com.bytedance.sdk.openadsdk.sU.EjP.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.sU.EjP.TYPE_UNKNOWN;
        }
    }

    private boolean zR() {
        if (this.RiZ == null) {
            return false;
        }
        if (this.Fmk.eEJ() && uP.TzV(this.Fmk)) {
            this.RiZ.sP(this.Fmk, this.TzV);
            return true;
        }
        this.RiZ.TKC();
        return false;
    }

    public boolean Dq() {
        return this.Ym;
    }

    public void EjP() {
        if (this.Dq) {
            try {
                HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
                this.f21089dx = homeWatcherReceiver;
                homeWatcherReceiver.Sj(new HomeWatcherReceiver.Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.7
                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.Sj
                    public void Sj() {
                        uA.this.TKC = true;
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.Sj
                    public void sP() {
                        uA.this.TKC = true;
                    }
                });
                this.f21088aa.getApplicationContext().registerReceiver(this.f21089dx, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Throwable unused) {
            }
        }
    }

    public void EjP(int i11) {
        this.HiB = i11 - 1;
    }

    public void EjP(boolean z10) {
        com.bytedance.sdk.openadsdk.sU.Dq dq2;
        if (this.Dq && (dq2 = this.zR) != null) {
            dq2.TKC(z10);
        }
    }

    public void Fmk() {
        if (this.Dq) {
            this.uvD.removeMessages(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
            this.uvD.removeMessages(600);
        }
    }

    public void HiB() {
        if (this.Dq && this.EjP <= 0) {
            this.EjP = System.currentTimeMillis();
            Handler handler = this.uvD;
            handler.sendMessage(handler.obtainMessage(DescriptorProtos$Edition.EDITION_LEGACY_VALUE, uA(), 0));
            TKC(true);
        }
    }

    public void HiB(int i11) {
        this.HiB = i11;
    }

    public void HiB(boolean z10) {
        com.bytedance.sdk.openadsdk.sU.Dq dq2;
        if (this.Dq && (dq2 = this.zR) != null) {
            dq2.Sj(z10);
        }
    }

    public void Jcg() {
        if (this.Dq && !this.RiZ.isShown()) {
            com.bytedance.sdk.openadsdk.core.widget.TEQ teq = this.RiZ;
            if (teq != null) {
                teq.sP(this.Fmk, this.TzV);
                this.RiZ.setProgress(this.Zq.JcM.TEQ() != null ? this.Zq.JcM.TEQ().getProgress() : 0);
            }
            com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
            if (dq2 != null) {
                dq2.Yf();
            }
        }
    }

    public void Sj() {
        if (this.Dq && !this.f21090ib) {
            this.f21090ib = true;
            Sj sj2 = this.Zq;
            this.dNu = sj2.JcM;
            this.TzV = sj2.sdp;
            dx();
            if (zR() && uP.TzV(this.Fmk) && uP.uvD(this.Fmk)) {
                Handler handler = this.uvD;
                handler.sendMessageDelayed(handler.obtainMessage(LogSeverity.EMERGENCY_VALUE, 2, uP.Sj(2)), uP.sU(this.Fmk) * 1000);
            }
        }
    }

    public void Sj(int i11) {
        if (this.Dq) {
            if (i11 == 5) {
                this.uA = true;
                if (uP.ib(this.Fmk)) {
                    this.uvD.removeMessages(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
                    this.Zq.HpB.sendEmptyMessage(600);
                }
            }
            this.uvD.sendMessage(Sj(i11, 0));
        }
    }

    public void Sj(int i11, sU sUVar, boolean z10) {
        if (this.Dq && sUVar != null) {
            this.vS = sUVar.oWa();
            this.Jcg = com.bytedance.sdk.openadsdk.core.dNu.EjP().Sj(String.valueOf(i11), z10);
        }
    }

    public void Sj(int i11, String str, String str2) {
        if (this.Dq) {
            try {
                com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
                if (dq2 != null) {
                    dq2.vS(com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().Sj(this.Fmk));
                    this.zR.Sj(i11, str, str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void Sj(long j11) {
        if (this.Dq) {
            Message obtain = Message.obtain();
            obtain.what = DescriptorProtos$Edition.EDITION_LEGACY_VALUE;
            obtain.arg1 = TEQ();
            this.uvD.sendMessageDelayed(obtain, j11);
        }
    }

    public void Sj(DownloadListener downloadListener) {
        com.bytedance.sdk.component.uA.vS Ym;
        if (this.Dq && (Ym = this.dNu.Ym()) != null) {
            String ib2 = ib();
            if (TextUtils.isEmpty(ib2)) {
                return;
            }
            Ym.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.Sj.HiB(this.f21088aa, this.dNu.Fmk(), this.Fmk.aZ(), null, false) { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.6
                @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    if (uA.this.sU) {
                        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(System.currentTimeMillis(), uA.this.Fmk, uA.this.sef, "loading_h5_success");
                    }
                    super.onPageFinished(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i11, String str, String str2) {
                    super.onReceivedError(webView, i11, str, str2);
                    uA.this.sU = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    uA.this.sU = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    uA.this.sU = false;
                }
            });
            Ym.a_(ib2);
            Ym.setDisplayZoomControls(false);
            Ym.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.Sj.EjP(this.dNu.Fmk(), this.dNu.sef()));
            Ym.setDownloadListener(downloadListener);
        }
    }

    public void Sj(final com.bytedance.sdk.openadsdk.aa.vS vSVar, boolean z10) {
        com.bytedance.sdk.openadsdk.Zq.sP sPVar;
        com.bytedance.sdk.component.Sj.dNu sP;
        com.bytedance.sdk.openadsdk.sU.Dq HiB;
        if (this.Dq && uP.Jcg(this.Fmk) && this.Zq.xhi) {
            if (com.bytedance.sdk.openadsdk.core.uA.sP().RiZ()) {
                com.bytedance.sdk.openadsdk.sU.Jcg.Sj(TEQ);
            }
            com.bytedance.sdk.openadsdk.sU.Sj sj2 = new com.bytedance.sdk.openadsdk.sU.Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.2
                @Override // com.bytedance.sdk.openadsdk.sU.Sj
                public com.bytedance.sdk.openadsdk.sU.EjP Sj() {
                    return uA.RiZ();
                }

                @Override // com.bytedance.sdk.openadsdk.sU.Sj
                public void Sj(int i11, String str) {
                    super.Sj(i11, str);
                    if (uA.this.RiZ == null || !uA.this.RiZ.isShown()) {
                        return;
                    }
                    uA.this.uvD.sendMessage(uA.Sj(3, uP.Sj(i11)));
                }

                @Override // com.bytedance.sdk.openadsdk.sU.Sj
                public void Sj(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.EjP.TKC.sP(uA.this.Fmk, uA.this.sef, "playable_track", jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.sU.Sj
                public void sP() {
                    uA.this.Zq.JcM.aa().TKC(true);
                    com.bytedance.sdk.openadsdk.aa.vS vSVar2 = vSVar;
                    if (vSVar2 != null) {
                        vSVar2.Sj();
                    }
                }
            };
            com.bytedance.sdk.openadsdk.sU.TKC tkc = new com.bytedance.sdk.openadsdk.sU.TKC() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.3
                @Override // com.bytedance.sdk.openadsdk.sU.TKC
                public void Sj(String str, JSONObject jSONObject) {
                    uA.this.Zq.JcM.aa().Sj(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BidResponsedEx.KEY_CID, this.Fmk.aZ());
                jSONObject.put("log_extra", this.Fmk.mZN());
                HiB = com.bytedance.sdk.openadsdk.sU.Dq.Sj(com.bytedance.sdk.openadsdk.core.dNu.Sj(), this.Zq.JcM.TEQ().getWebView(), tkc, sj2).Jcg(this.Zq.JcM.uP()).HiB(com.bytedance.sdk.openadsdk.common.sP.Sj(com.bytedance.sdk.openadsdk.core.dNu.Sj())).Sj(com.bytedance.sdk.openadsdk.common.sP.Sj()).TKC(jSONObject).Sj("sdkEdition", com.bytedance.sdk.openadsdk.common.sP.TKC()).sP(com.bytedance.sdk.openadsdk.common.sP.HiB()).EjP(com.bytedance.sdk.openadsdk.common.sP.EjP()).EjP(false).Sj(z10).Sj(uP.sU(this.Fmk)).sP(uP.sU(this.Fmk)).HiB(uP.TzV(this.Fmk));
                this.zR = HiB;
            } catch (Exception unused) {
                if (this.zR == null) {
                    sPVar = new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.4
                        @Override // com.bytedance.sdk.openadsdk.Zq.sP
                        public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj("PlayablePlugin_init").sP(jSONObject2.toString());
                        }
                    };
                }
            } catch (Throwable th2) {
                if (this.zR == null) {
                    com.bytedance.sdk.openadsdk.Zq.TKC.Sj("PlayablePlugin_init", false, new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.4
                        @Override // com.bytedance.sdk.openadsdk.Zq.sP
                        public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj("PlayablePlugin_init").sP(jSONObject2.toString());
                        }
                    });
                }
                throw th2;
            }
            if (HiB == null) {
                sPVar = new com.bytedance.sdk.openadsdk.Zq.sP() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.4
                    @Override // com.bytedance.sdk.openadsdk.Zq.sP
                    public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("PlayablePlugin_is_null", true);
                        return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj("PlayablePlugin_init").sP(jSONObject2.toString());
                    }
                };
                com.bytedance.sdk.openadsdk.Zq.TKC.Sj("PlayablePlugin_init", false, sPVar);
            }
            if (this.zR != null && !TextUtils.isEmpty(uP.Ym(this.Fmk))) {
                this.zR.TKC(uP.Ym(this.Fmk));
            }
            com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
            if (dq2 != null) {
                Set<String> Ym = dq2.Ym();
                final WeakReference weakReference = new WeakReference(this.zR);
                for (String str : Ym) {
                    if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (sP = this.Zq.JcM.aa().sP()) != null) {
                        sP.Sj(str, new com.bytedance.sdk.component.Sj.HiB<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.uA.5
                            @Override // com.bytedance.sdk.component.Sj.HiB
                            public JSONObject Sj(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.Sj.vS vSVar2) {
                                try {
                                    com.bytedance.sdk.openadsdk.sU.Dq dq3 = (com.bytedance.sdk.openadsdk.sU.Dq) weakReference.get();
                                    if (dq3 == null) {
                                        return null;
                                    }
                                    return dq3.EjP(Sj(), jSONObject2);
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void Sj(com.bytedance.sdk.openadsdk.core.sP.HiB hiB) {
        com.bytedance.sdk.openadsdk.core.widget.TEQ teq;
        if (!this.Dq || (teq = this.RiZ) == null || teq.getDownloadButton() == null) {
            return;
        }
        if (uP.TzV(this.Fmk) || uP.ib(this.Fmk)) {
            this.RiZ.getDownloadButton().setOnClickListener(hiB);
            this.RiZ.getDownloadButton().setOnTouchListener(hiB);
        }
    }

    public void Sj(String str) {
        if (this.Dq && this.TKC) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.EjP);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFPM", "sendPlayableEvent error", e11);
            }
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.Fmk, this.sef, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.TKC = false;
            }
        }
    }

    public void Sj(JSONObject jSONObject) {
        if (this.Dq && jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.EjP);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFPM", "endShow json error", e11);
            }
        }
    }

    public void Sj(boolean z10) {
        if (this.Dq && z10) {
            this.dNu.TEQ().setDomStorageEnabled(true);
        }
    }

    public void Sj(boolean z10, String str, int i11) {
        if (this.Dq) {
            try {
                com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
                if (dq2 != null) {
                    dq2.vS(com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().Sj(this.Fmk));
                    this.zR.Sj(z10, str, i11);
                }
            } catch (Exception unused) {
            }
        }
    }

    public int TEQ() {
        return this.HiB;
    }

    public int TKC(int i11) {
        return this.Jcg - (this.vS - i11);
    }

    public void TKC() {
        if (this.Dq && !this.wE) {
            this.wE = true;
            TKC(false);
            Sj(this.f21088aa.getApplicationContext());
            com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
            if (dq2 != null) {
                dq2.Mts();
            }
            this.uvD.removeCallbacksAndMessages(null);
        }
    }

    public void TKC(String str) {
        com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
        if (dq2 == null || !this.Dq) {
            return;
        }
        dq2.vS(com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().Sj(this.Fmk));
        this.zR.Dq(str);
    }

    public void TKC(boolean z10) {
        if (this.Dq) {
            this.Ym = z10;
            if (z10) {
                return;
            }
            this.uvD.removeMessages(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
        }
    }

    public com.bytedance.sdk.openadsdk.sU.Dq TzV() {
        return this.zR;
    }

    public void Ym() {
        if (this.Dq && this.zR != null && FPG.EjP(this.Zq.JcM.TEQ())) {
            this.zR.TKC(true);
        }
    }

    public boolean Zq() {
        return this.kF;
    }

    public void aa() {
        if (this.Dq) {
            com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
            if (dq2 != null) {
                dq2.TKC(false);
            }
            this.uvD.removeMessages(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
        }
    }

    public boolean dNu() {
        com.bytedance.sdk.openadsdk.core.widget.TEQ teq = this.RiZ;
        return teq != null && teq.isShown();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.bytedance.sdk.openadsdk.core.widget.TEQ teq;
        TzV tzV;
        int i11 = message.what;
        if (i11 == 900) {
            if (!this.Ym || !uP.TzV(this.Zq.sP)) {
                return true;
            }
            int i12 = message.arg1;
            if (i12 > 0) {
                this.Zq.Mts.EjP(true);
                int sP = this.Zq.uP.sP(i12);
                if (sP == i12) {
                    this.Zq.Mts.Sj(String.valueOf(i12), null);
                } else if (sP > 0) {
                    this.Zq.Mts.Sj(String.valueOf(i12), String.format(ib.Sj(this.Zq.Fm.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(sP)));
                } else if (!uP.Dq(this.Fmk) || Zq()) {
                    this.Zq.RiZ.set(true);
                    this.Zq.f21076kb.Zq();
                } else {
                    this.Zq.Mts.Sj(String.valueOf(i12), ib.Sj(this.Zq.Fm.getApplicationContext(), "tt_reward_screen_skip_tx"));
                    this.Zq.Mts.HiB(true);
                }
                Message obtain = Message.obtain();
                obtain.what = DescriptorProtos$Edition.EDITION_LEGACY_VALUE;
                obtain.arg1 = i12 - 1;
                this.uvD.sendMessageDelayed(obtain, 1000L);
                EjP(i12);
            } else {
                if (!uP.Dq(this.Fmk) || (uP.ib(this.Fmk) && this.Zq.uP.Jcg())) {
                    this.Zq.Mts.EjP(false);
                    this.Zq.RiZ.set(true);
                    this.Zq.f21076kb.Zq();
                } else {
                    this.Zq.Mts.TKC();
                    this.Zq.Mts.HiB(true);
                }
                if (!this.uA) {
                    this.uP = true;
                }
            }
            this.Zq.f21075jb.sef();
        } else {
            if (i11 != 800 || ((teq = this.RiZ) != null && (!teq.isShown() || this.RiZ.EjP()))) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                int i13 = message.arg2;
                if (i13 != 0) {
                    jSONObject.put("remove_loading_page_reason", i13);
                }
                String aa2 = uP.aa(this.Fmk);
                Sj sj2 = this.Zq;
                if (sj2 != null && (tzV = sj2.JcM) != null) {
                    String uP = tzV.uP();
                    if (!TextUtils.isEmpty(uP)) {
                        aa2 = uP;
                    }
                }
                jSONObject.put("playable_url", aa2);
                com.bytedance.sdk.openadsdk.core.widget.TEQ teq2 = this.RiZ;
                r3 = teq2 != null ? teq2.getDisplayDuration() : 0L;
                jSONObject.put("duration", r3);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFPM", "handleMessage json error", e11);
            }
            long j11 = r3;
            Sj sj3 = this.Zq;
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sj3.sP, sj3.HiB, "remove_loading_page", jSONObject, j11);
            this.uvD.removeMessages(LogSeverity.EMERGENCY_VALUE);
            if (!this.f21088aa.isFinishing()) {
                this.Zq.uP.HiB();
            }
        }
        return true;
    }

    public void sP() {
        if (this.Dq && !this.Sj.getAndSet(true)) {
            this.dNu.Mts();
            if (uP.Dq(this.Fmk)) {
                this.dNu.Jcg();
            }
        }
    }

    public void sP(int i11) {
        com.bytedance.sdk.openadsdk.core.widget.TEQ teq;
        if (this.Dq && (teq = this.RiZ) != null) {
            teq.setProgress(i11);
        }
    }

    public void sP(String str) {
        com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
        if (dq2 != null) {
            if (!this.Dq) {
                return;
            }
            dq2.vS(com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().Sj(this.Fmk));
            this.zR.uA(str);
        }
        if (Zq()) {
            this.Zq.JcM.HiB(true);
            this.Zq.fF.Sj(true);
            this.Zq.ndK = true;
        }
    }

    public void sP(boolean z10) {
        if (this.Dq) {
            if (z10) {
                try {
                    if (!TextUtils.isEmpty(this.dNu.uP()) && this.dNu.ib() != 0) {
                        com.bytedance.sdk.openadsdk.Zq.TKC.Sj().Sj(this.dNu.uP(), this.dNu.ib(), this.dNu.kF());
                    }
                } catch (Throwable unused) {
                }
            }
            if (z10) {
                try {
                    if (TextUtils.isEmpty(this.dNu.uP())) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.Zq.TKC.Sj().sP(this.dNu.uP());
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public com.bytedance.sdk.openadsdk.aa.HiB sef() {
        return this.ley;
    }

    public int uA() {
        return this.vS;
    }

    public boolean uvD() {
        return this.uP;
    }

    public void vS() {
        com.bytedance.sdk.openadsdk.sU.Dq dq2;
        com.bytedance.sdk.openadsdk.utils.Fmk fmk;
        if (this.Dq) {
            if (!uP.Dq(this.Fmk) && this.RiZ.isShown() && (fmk = this.Zq.f21078xu) != null) {
                fmk.Sj(uA() * 1000);
            }
            if (uP.RiZ(this.Fmk) && this.RiZ.isShown()) {
                Sj sj2 = this.Zq;
                sj2.FPG.sP(sj2.f21076kb);
            }
            com.bytedance.sdk.openadsdk.core.widget.TEQ teq = this.RiZ;
            if (teq != null) {
                teq.TKC();
            }
            if (this.Sj.getAndSet(true)) {
                return;
            }
            if (this.Zq.JcM.Wjd() && (dq2 = this.zR) != null) {
                dq2.Sj(1);
            }
            if (uP.Jcg(this.Fmk) && uP.ib(this.Fmk)) {
                TzV tzV = this.Zq.JcM;
                if (tzV == null || tzV.Wjd()) {
                    Sj sj3 = this.Zq;
                    sj3.FPG.Sj(sj3.f21076kb);
                    return;
                }
                int i11 = !this.Zq.JcM.TzV() ? 2 : 3;
                com.bytedance.sdk.openadsdk.sU.Dq dq3 = this.zR;
                if (dq3 != null) {
                    dq3.Sj(i11);
                }
                if (uP.TzV(this.Zq.sP)) {
                    Sj sj4 = this.Zq;
                    int i12 = sj4.vS;
                    sU sUVar = sj4.sP;
                    Sj(i12, sUVar, sUVar.TT());
                    HiB();
                    this.Zq.f21075jb.Ym();
                }
                this.Zq.FPG.Sj(false);
                this.Zq.JcM.FPG();
                this.kF = true;
                this.Zq.Mts.TKC(false);
                this.Zq.uP.HiB(true);
                this.Zq.ndK = true;
                if (uP.RiZ(this.Fmk)) {
                    this.uvD.removeMessages(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
                    this.Zq.Mts.EjP(false);
                    LqL lqL = this.Zq.HpB;
                    if (lqL != null) {
                        lqL.removeMessages(1);
                        this.Zq.HpB.sendEmptyMessageDelayed(600, 1000L);
                    }
                }
                com.bytedance.sdk.openadsdk.sU.Dq dq4 = this.zR;
                if (dq4 != null) {
                    dq4.TKC(true);
                }
            }
        }
    }

    public void vS(boolean z10) {
        if (this.Dq && z10 && !this.Zq.uP.Jcg()) {
            com.bytedance.sdk.openadsdk.sU.Dq dq2 = this.zR;
            if (dq2 != null) {
                dq2.Sj(1);
            }
            boolean TzV = uP.TzV(this.Fmk);
            if ((TzV || uP.ib(this.Fmk)) && this.Fmk.eEJ() && !uP.uvD(this.Fmk)) {
                Handler handler = this.uvD;
                handler.sendMessageDelayed(handler.obtainMessage(LogSeverity.EMERGENCY_VALUE, 0, 0), 1000L);
            }
            if (TzV) {
                this.Zq.uP.Dq();
                this.Zq.JcM.sP(true);
                this.Zq.JcM.TKC(true);
                com.bytedance.sdk.openadsdk.EjP.TKC.Sj(System.currentTimeMillis(), this.Zq.sP, this.sef, "py_loading_success");
            }
        }
    }
}
