package com.bytedance.sdk.openadsdk.sU;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Dq {
    private String AVc;
    private int Aw;
    private int Bml;
    private int Chv;
    private volatile boolean DKa;
    private ViewTreeObserver.OnGlobalLayoutListener DKj;
    private boolean DPc;
    private volatile boolean DhB;
    private final Handler Dq;
    private int EZ;
    private String Ei;
    public final String EjP;
    private long FPG;
    private String Fm;
    private Runnable Fmk;
    private String GJs;
    private int GMp;
    private String Gn;
    private int Grp;
    private WeakReference<View> HS;
    private int HcZ;
    public final String HiB;
    private String HpB;
    private String IOh;
    private Context Ir;
    private long JcM;
    private final String Jcg;
    private long LD;
    private int LqL;
    private long Mts;
    private int MuB;
    private int NPW;
    private String Ov;
    private int Ph;
    private String QZ;
    private Set<String> RiZ;
    private String RrR;
    private String SP;
    public final String Sj;
    private Runnable TEQ;
    private com.bytedance.sdk.openadsdk.sU.Sj TFd;
    public final String TKC;
    private String TO;
    private int TX;
    private boolean TzV;
    private int UHs;
    private int Uc;
    private long WMZ;
    private long Wjd;
    private boolean WxP;
    private float Xqg;
    private long Yf;
    private Runnable Ym;
    private sP Zq;
    private long aNB;

    @Nullable
    private WebView aZ;

    /* renamed from: aa, reason: collision with root package name */
    private final Handler f21192aa;
    private long cX;
    private JSONObject dLt;
    private boolean dNu;
    private boolean dU;

    /* renamed from: db, reason: collision with root package name */
    private int f21193db;
    private int dwU;

    /* renamed from: dx, reason: collision with root package name */
    private String f21194dx;
    private boolean eEJ;
    private String eI;
    private JSONObject eMB;
    private long fF;
    private Sj gR;
    private int gY;

    /* renamed from: gq, reason: collision with root package name */
    private int f21195gq;
    private boolean hif;
    private int hzV;

    /* renamed from: ib, reason: collision with root package name */
    private boolean f21196ib;

    /* renamed from: jb, reason: collision with root package name */
    private String f21197jb;
    private List<JSONObject> jjS;
    private boolean kF;

    /* renamed from: kb, reason: collision with root package name */
    private JSONObject f21198kb;
    private long ley;
    private JSONObject liH;
    private TKC mZN;

    /* renamed from: mj, reason: collision with root package name */
    private int f21199mj;
    private Map<String, String> nP;
    private boolean ndK;
    private String nou;
    private int nru;
    private float oWa;
    private boolean pfr;
    private int qRN;
    private boolean rB;
    private boolean ron;
    public final String sP;
    private String sU;
    private int sdp;
    private Runnable sef;
    private boolean tPD;
    private int tX;
    private String tY;

    /* renamed from: tz, reason: collision with root package name */
    private vS f21200tz;
    private Runnable uA;
    private String uP;
    private boolean uvD;
    private final String vS;

    /* renamed from: vb, reason: collision with root package name */
    private int f21201vb;
    private String vll;
    private long wE;
    private long xD;
    private int xhi;

    /* renamed from: xu, reason: collision with root package name */
    private int f21202xu;
    private boolean xzt;
    private boolean zR;
    private float zwV;

    /* loaded from: classes3.dex */
    public enum Sj {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private Dq(Context context, int i11, TKC tkc, com.bytedance.sdk.openadsdk.sU.Sj sj2) {
        this.vS = "playable_stuck_check_ping";
        this.Jcg = "playable_apply_media_permission_callback";
        this.Dq = new Handler(Looper.getMainLooper());
        this.f21192aa = new Handler(Looper.getMainLooper());
        this.uvD = true;
        this.dNu = true;
        this.TzV = true;
        this.Sj = "PL_sdk_playable_global_viewable";
        this.sP = "PL_sdk_page_screen_blank";
        this.TKC = "PL_sdk_playable_destroy_analyze_summary";
        this.EjP = "PL_sdk_playable_hardware_dialog_cancel";
        this.HiB = "PL_sdk_playable_hardware_dialog_setting";
        this.RiZ = new HashSet(Arrays.asList("adInfo", TmcConstants.EXTRA_APPINFO, "subscribe_app_ad", "download_app_ad"));
        this.sU = null;
        this.f21194dx = "embeded_ad";
        this.zR = true;
        this.f21196ib = true;
        this.kF = false;
        this.uP = "";
        this.wE = 10L;
        this.ley = 10L;
        this.LqL = LogSeverity.ALERT_VALUE;
        this.Yf = 0L;
        this.LD = 0L;
        this.fF = -1L;
        this.JcM = -1L;
        this.WMZ = -1L;
        this.Mts = -1L;
        this.FPG = -1L;
        this.Wjd = -1L;
        this.xD = -1L;
        this.Fm = "";
        this.f21197jb = "";
        this.Ei = "";
        this.HpB = "";
        this.xhi = 0;
        this.f21193db = 0;
        this.ndK = false;
        this.qRN = 0;
        this.UHs = -1;
        this.dwU = 0;
        this.sdp = 0;
        this.MuB = 0;
        this.IOh = null;
        this.pfr = false;
        this.EZ = 0;
        this.gY = 0;
        this.Chv = 0;
        this.Bml = 0;
        this.aNB = 0L;
        this.cX = 0L;
        this.Uc = -2;
        this.f21202xu = 0;
        this.HcZ = 0;
        this.nru = 0;
        this.eMB = new JSONObject();
        this.nP = new HashMap();
        this.liH = new JSONObject();
        this.SP = "";
        this.zwV = 0.0f;
        this.Xqg = 0.0f;
        this.dU = false;
        this.hif = false;
        this.ron = false;
        this.jjS = new ArrayList();
        this.eEJ = true;
        this.DhB = true;
        this.DKa = true;
        this.DKj = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) Dq.this.HS.get();
                    if (view == null) {
                        return;
                    }
                    Dq.this.sP(view);
                } catch (Throwable th2) {
                    Jcg.Sj("PlayablePlugin", "onSizeChanged error", th2);
                }
            }
        };
        this.NPW = -1;
        this.Uc = i11;
        this.gR = Sj.LAND_PAGE;
        Sj(context, tkc, sj2);
    }

    private Dq(Context context, WebView webView, TKC tkc, com.bytedance.sdk.openadsdk.sU.Sj sj2, Sj sj3) {
        this.vS = "playable_stuck_check_ping";
        this.Jcg = "playable_apply_media_permission_callback";
        this.Dq = new Handler(Looper.getMainLooper());
        this.f21192aa = new Handler(Looper.getMainLooper());
        this.uvD = true;
        this.dNu = true;
        this.TzV = true;
        this.Sj = "PL_sdk_playable_global_viewable";
        this.sP = "PL_sdk_page_screen_blank";
        this.TKC = "PL_sdk_playable_destroy_analyze_summary";
        this.EjP = "PL_sdk_playable_hardware_dialog_cancel";
        this.HiB = "PL_sdk_playable_hardware_dialog_setting";
        this.RiZ = new HashSet(Arrays.asList("adInfo", TmcConstants.EXTRA_APPINFO, "subscribe_app_ad", "download_app_ad"));
        this.sU = null;
        this.f21194dx = "embeded_ad";
        this.zR = true;
        this.f21196ib = true;
        this.kF = false;
        this.uP = "";
        this.wE = 10L;
        this.ley = 10L;
        this.LqL = LogSeverity.ALERT_VALUE;
        this.Yf = 0L;
        this.LD = 0L;
        this.fF = -1L;
        this.JcM = -1L;
        this.WMZ = -1L;
        this.Mts = -1L;
        this.FPG = -1L;
        this.Wjd = -1L;
        this.xD = -1L;
        this.Fm = "";
        this.f21197jb = "";
        this.Ei = "";
        this.HpB = "";
        this.xhi = 0;
        this.f21193db = 0;
        this.ndK = false;
        this.qRN = 0;
        this.UHs = -1;
        this.dwU = 0;
        this.sdp = 0;
        this.MuB = 0;
        this.IOh = null;
        this.pfr = false;
        this.EZ = 0;
        this.gY = 0;
        this.Chv = 0;
        this.Bml = 0;
        this.aNB = 0L;
        this.cX = 0L;
        this.Uc = -2;
        this.f21202xu = 0;
        this.HcZ = 0;
        this.nru = 0;
        this.eMB = new JSONObject();
        this.nP = new HashMap();
        this.liH = new JSONObject();
        this.SP = "";
        this.zwV = 0.0f;
        this.Xqg = 0.0f;
        this.dU = false;
        this.hif = false;
        this.ron = false;
        this.jjS = new ArrayList();
        this.eEJ = true;
        this.DhB = true;
        this.DKa = true;
        this.DKj = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) Dq.this.HS.get();
                    if (view == null) {
                        return;
                    }
                    Dq.this.sP(view);
                } catch (Throwable th2) {
                    Jcg.Sj("PlayablePlugin", "onSizeChanged error", th2);
                }
            }
        };
        this.NPW = -1;
        this.Uc = 0;
        this.gR = sj3;
        this.aZ = webView;
        uA.Sj(webView);
        Sj(webView);
        Sj(context, tkc, sj2);
    }

    private void Ei() {
        Runnable runnable;
        Runnable runnable2;
        this.Zq.Sj(System.currentTimeMillis());
        Handler handler = this.f21192aa;
        if (handler != null) {
            int i11 = this.Uc;
            if (i11 == 0 && (runnable2 = this.Fmk) != null) {
                handler.post(runnable2);
            } else if ((i11 == 1 || i11 == 2) && (runnable = this.sef) != null) {
                handler.post(runnable);
            }
            this.Zq.Sj(500);
        }
    }

    private String EjP(String str, String str2) {
        String format = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.tY = format;
        return format;
    }

    private void Fm() {
        this.Zq = new sP(this, this.LqL);
        this.uA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.5
            @Override // java.lang.Runnable
            public void run() {
                if (Dq.this.zR) {
                    Dq.this.zR = false;
                    Dq.this.Dq.removeCallbacks(Dq.this.TEQ);
                    Dq.this.Sj(2, "ContainerLoadTimeOut");
                }
            }
        };
        this.TEQ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.6
            @Override // java.lang.Runnable
            public void run() {
                if (Dq.this.zR) {
                    Dq.this.zR = false;
                    Dq.this.DhB = false;
                    Dq.this.Dq.removeCallbacks(Dq.this.uA);
                    Dq.this.Sj(3, "JSSDKLoadTimeOut");
                }
            }
        };
        this.Fmk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.7
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (Dq.this.aZ != null) {
                    Dq.this.aZ.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.7.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (Dq.this.Zq != null) {
                                Dq.this.Zq.Sj(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (Dq.this.f21192aa != null) {
                    Dq.this.f21192aa.postDelayed(this, 500L);
                }
            }
        };
        this.sef = new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.8
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                Dq.this.Sj("playable_stuck_check_ping", new JSONObject());
                if (Dq.this.f21192aa != null) {
                    Dq.this.f21192aa.postDelayed(this, 500L);
                }
            }
        };
        this.Ym = new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.9
            @Override // java.lang.Runnable
            public void run() {
                if (Dq.this.cX <= 0) {
                    Dq.this.sP(1, "Clicking on the hot zone causes the program to freeze.");
                } else {
                    if (Dq.this.cX - Dq.this.aNB > Dq.this.LqL) {
                        Dq.this.sP(1, "Clicking on the hot zone causes the program to freeze.");
                        return;
                    }
                    Dq.this.fF();
                    Dq.this.aNB = 0L;
                    Dq.this.cX = 0L;
                }
            }
        };
    }

    static /* synthetic */ int Fmk(Dq dq2) {
        int i11 = dq2.f21193db;
        dq2.f21193db = i11 + 1;
        return i11;
    }

    private void HiB(String str, JSONObject jSONObject) {
        try {
            int i11 = this.Uc;
            if (i11 == 0) {
                if (this.gR != Sj.LAND_PAGE && !aa(this.tY)) {
                    jb();
                }
                jSONObject.put("playable_url", this.tY);
            } else {
                if (i11 != 3 && i11 != 4) {
                    if (i11 == 1 || i11 == 2) {
                        jSONObject.put("playable_url", TKC(this.Gn, this.nou));
                    }
                }
                jSONObject.put("playable_url", EjP(this.vll, this.GJs));
            }
            jSONObject.put("playable_render_type", this.Uc);
            if (this.TFd != null) {
                if (this.Uc == 0 && (this.gR != Sj.LAND_PAGE || aa(this.tY))) {
                    this.TFd.Sj(jSONObject);
                } else if (this.Uc != 0) {
                    this.TFd.Sj(jSONObject);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public static Dq Sj(Context context, @Nullable WebView webView, TKC tkc, com.bytedance.sdk.openadsdk.sU.Sj sj2) {
        if (tkc == null || sj2 == null) {
            return null;
        }
        return webView == null ? new Dq(context, 0, tkc, sj2) : new Dq(context, webView, tkc, sj2, Sj.LAND_PAGE);
    }

    private void Sj(Context context, TKC tkc, com.bytedance.sdk.openadsdk.sU.Sj sj2) {
        this.sU = UUID.randomUUID().toString();
        this.Ir = context;
        this.TFd = sj2;
        this.mZN = tkc;
        TEQ.Sj(sj2);
        this.f21200tz = new vS(this);
        Fm();
        if (this.aZ == null) {
            this.NPW = 4;
            this.Dq.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.4
                @Override // java.lang.Runnable
                public void run() {
                    Dq.this.Sj(5, "webview is null");
                }
            });
        }
    }

    private String TKC(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.RrR) && !TextUtils.isEmpty(this.SP)) {
            Uri parse = Uri.parse(this.SP);
            String host = parse.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = parse.getQueryParameter("surl");
                queryParameter2 = parse.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme(parse.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                appendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.RrR = appendQueryParameter.toString();
        }
        return this.RrR;
    }

    private void TKC(int i11, String str) {
        com.bytedance.sdk.openadsdk.sU.Sj sj2 = this.TFd;
        if (sj2 != null) {
            sj2.Sj(i11, str);
        }
    }

    static /* synthetic */ int aa(Dq dq2) {
        int i11 = dq2.xhi;
        dq2.xhi = i11 + 1;
        return i11;
    }

    private boolean aa(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    private void jb() {
        String str;
        if (this.liH == null || (str = this.tY) == null || str.contains("/cid_")) {
            return;
        }
        String optString = this.liH.optString(BidResponsedEx.KEY_CID);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String host = Uri.parse(this.tY).getHost();
        if (TextUtils.isEmpty(host)) {
            this.tY += "/cid_" + optString;
            return;
        }
        this.tY = this.tY.replace(host, host + "/cid_" + optString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.HcZ == view.getWidth() && this.nru == view.getHeight()) {
                return;
            }
            this.HcZ = view.getWidth();
            this.nru = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.HcZ);
            jSONObject.put("height", this.nru);
            Sj("resize", jSONObject);
            this.eMB = jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "resetViewDataJsonByView error", th2);
        }
    }

    public JSONObject Dq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 0);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt == 1) {
            jSONObject2.put("result", HiB.sP(this.Ir, "android.permission.RECORD_AUDIO"));
        } else {
            if (optInt != 2) {
                if (optInt == 3) {
                    jSONObject2.put("result", HiB.Sj(this.Ir));
                }
                return jSONObject2;
            }
            jSONObject2.put("result", HiB.sP(this.Ir, "android.permission.CAMERA"));
        }
        return jSONObject2;
    }

    public void Dq(String str) {
        this.f21202xu = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.WMZ = currentTimeMillis;
            long j11 = this.JcM;
            jSONObject.put("playable_page_show_duration", j11 != -1 ? currentTimeMillis - j11 : 0L);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "reportUrlLoadStart error", th2);
        }
        TKC("PL_sdk_html_load_start", jSONObject);
        this.DhB = true;
        this.DKa = true;
        if (this.eEJ) {
            Yf();
            this.DhB = false;
            this.DKa = false;
        }
        if (this.dNu) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (HiB.Sj(this.Ir, HiB.f21203aa)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (HiB.sP(this.Ir, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (HiB.Sj(this.Ir, HiB.Ym)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (HiB.Sj(this.Ir, HiB.TEQ)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (HiB.Sj(this.Ir, HiB.uA)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (HiB.Sj(this.Ir, HiB.Dq)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (HiB.sP(this.Ir, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (HiB.Sj(this.Ir, HiB.Jcg)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (HiB.Sj(this.Ir)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                TKC("PL_sdk_hardware_detect", jSONObject2);
                this.dNu = false;
            } catch (Throwable th3) {
                Jcg.Sj("PlayablePlugin", "Hardware detect error", th3);
            }
        }
    }

    public boolean Dq() {
        return this.tPD;
    }

    public Dq EjP(String str) {
        this.QZ = str;
        return this;
    }

    public Dq EjP(boolean z10) {
        this.DPc = z10;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.DPc);
            Sj("change_playable_click", jSONObject);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "setPlayableClick error", th2);
        }
        return this;
    }

    public String EjP() {
        return this.eI;
    }

    public JSONObject EjP(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        if (Jcg.Sj() && jSONObject != null) {
            jSONObject.toString();
        }
        JSONObject Sj2 = this.f21200tz.Sj(str, jSONObject);
        if (Jcg.Sj()) {
            System.currentTimeMillis();
            if (Sj2 != null) {
                Sj2.toString();
            }
        }
        return Sj2;
    }

    public void EjP(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.IOh = jSONObject.optString("section");
        }
    }

    public int FPG() {
        return (this.JcM == -1 || !this.WxP) ? 1 : 2;
    }

    public JSONObject Fmk() {
        try {
            boolean Sj2 = HiB.Sj(this.Ir, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", Sj2);
            return jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "getCameraPermission error", th2);
            return new JSONObject();
        }
    }

    public Dq HiB(String str) {
        this.Ov = str;
        return this;
    }

    public Dq HiB(boolean z10) {
        this.eEJ = z10;
        return this;
    }

    public String HiB() {
        return this.TO;
    }

    public void HiB(JSONObject jSONObject) {
        this.f21198kb = jSONObject;
        this.MuB++;
        JcM();
        this.Dq.removeCallbacks(this.Ym);
        if (this.f21196ib) {
            this.Wjd = System.currentTimeMillis();
            this.aNB = System.currentTimeMillis();
            this.cX = 0L;
            int i11 = this.Uc;
            if (i11 == 0) {
                WebView webView = this.aZ;
                if (webView != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.10
                        @Override // android.webkit.ValueCallback
                        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            Dq.this.cX = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i11 == 1 || i11 == 2) {
                Sj("playable_stuck_check_ping", new JSONObject());
            }
            this.Dq.postDelayed(this.Ym, this.LqL);
        }
    }

    public void JcM() {
        try {
            sP sPVar = this.Zq;
            if (sPVar != null) {
                sPVar.Sj();
            }
            Handler handler = this.f21192aa;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    public Dq Jcg(String str) {
        Uri parse;
        String scheme;
        int indexOf;
        String decode;
        this.SP = str;
        try {
            parse = Uri.parse(str);
            scheme = parse.getScheme();
        } catch (Throwable unused) {
        }
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            String host = parse.getHost();
            if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.Uc == -1) {
                        sP(2);
                    } else {
                        sP(1);
                    }
                }
                this.tY = str;
                return this;
            }
            sP(0);
            String queryParameter = parse.getQueryParameter("url");
            if (!TextUtils.isEmpty(queryParameter) && (decode = Uri.decode(queryParameter)) != null) {
                int indexOf2 = decode.indexOf(UrlUtils.QUESTION_MARK);
                str = indexOf2 != -1 ? decode.substring(0, indexOf2) : decode;
            }
            this.tY = str;
            return this;
        }
        sP(0);
        if (str != null && (indexOf = str.indexOf(UrlUtils.QUESTION_MARK)) != -1) {
            str = str.substring(0, indexOf);
        }
        this.tY = str;
        return this;
    }

    public String Jcg() {
        return this.Ov;
    }

    public JSONObject Jcg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 0);
        return optInt != 1 ? optInt != 2 ? optInt != 3 ? new JSONObject() : sef() : Fmk() : aa();
    }

    public void LD() {
        this.DKa = false;
        this.Dq.removeCallbacks(this.TEQ);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.WMZ > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.WMZ);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            TKC("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void LqL() {
        sP sPVar;
        this.cX = System.currentTimeMillis();
        int i11 = this.Uc;
        if ((i11 == 1 || i11 == 2) && (sPVar = this.Zq) != null) {
            sPVar.Sj(System.currentTimeMillis());
        }
    }

    public void Mts() {
        if (this.ron) {
            return;
        }
        this.ron = true;
        this.LD = 0L;
        this.dNu = true;
        WMZ();
        try {
            View view = this.HS.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.DKj);
            }
        } catch (Throwable unused) {
        }
        try {
            this.f21200tz.sP();
        } catch (Throwable unused2) {
        }
        try {
            sP sPVar = this.Zq;
            if (sPVar != null) {
                sPVar.Sj();
                this.Zq = null;
            }
            Handler handler = this.f21192aa;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th2) {
            th2.toString();
        }
        try {
            if (!TextUtils.isEmpty(this.tY)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.xhi);
                jSONObject.put("playable_hit_times", this.f21193db);
                int i11 = this.xhi;
                if (i11 > 0) {
                    jSONObject.put("playable_hit_ratio", this.f21193db / (i11 * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                TKC("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.tY)) {
                if (this.fF != -1) {
                    this.Yf += System.currentTimeMillis() - this.fF;
                    this.fF = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.Yf);
                TKC("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.DhB = false;
        this.DKa = false;
        this.Dq.removeCallbacks(this.uA);
        this.Dq.removeCallbacks(this.TEQ);
        this.Dq.removeCallbacksAndMessages(null);
    }

    public JSONObject RiZ() {
        return this.liH;
    }

    public Context Sj() {
        return this.Ir;
    }

    public Dq Sj(float f11) {
        this.oWa = f11;
        return this;
    }

    public Dq Sj(long j11) {
        if (j11 <= 0) {
            this.wE = 10L;
        } else {
            this.wE = j11;
        }
        return this;
    }

    public Dq Sj(String str) {
        this.TO = str;
        return this;
    }

    public Dq Sj(String str, String str2) {
        this.nP.put(str, str2);
        return this;
    }

    public Dq Sj(boolean z10) {
        this.tPD = z10;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.tPD);
            Sj("volumeChange", jSONObject);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "setIsMute error", th2);
        }
        return this;
    }

    public void Sj(int i11) {
        this.NPW = i11;
    }

    protected void Sj(int i11, String str) {
        JcM();
        TKC(i11, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i11);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "reportRenderFatal error", th2);
        }
        TKC("PL_sdk_global_faild", jSONObject);
    }

    public void Sj(int i11, String str, String str2) {
        this.f21202xu = -1;
        this.AVc = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i11);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
            jSONObject.put("playable_has_show", FPG());
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "onWebReceivedError error", th2);
        }
        TKC("PL_sdk_html_load_error", jSONObject);
        if (this.zR) {
            this.zR = false;
            this.DhB = false;
            this.DKa = false;
            this.Dq.removeCallbacks(this.uA);
            this.Dq.removeCallbacks(this.TEQ);
            Sj(1, "ContainerLoadFail");
        }
    }

    public void Sj(View view) {
        if (view == null) {
            return;
        }
        try {
            this.HS = new WeakReference<>(view);
            sP(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.DKj);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "setViewForScreenSize error", th2);
        }
    }

    public void Sj(String str, JSONObject jSONObject) {
        if (Jcg.Sj() && jSONObject != null) {
            jSONObject.toString();
        }
        TKC tkc = this.mZN;
        if (tkc != null) {
            tkc.Sj(str, jSONObject);
        }
    }

    public void Sj(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.sU.Sj sj2 = this.TFd;
        if (sj2 == null || sj2.sP(jSONObject) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int optInt = jSONObject.optInt("resource_type", -1);
        String optString2 = jSONObject.optString("resource_name", "playable_media");
        if (optInt == 1) {
            sP(optString2, optString);
        }
    }

    public void Sj(boolean z10, String str, int i11) {
        if (z10) {
            this.f21202xu = -1;
            this.AVc = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i11);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
                jSONObject.put("playable_has_show", FPG());
            } catch (Throwable th2) {
                Jcg.Sj("PlayablePlugin", "onWebReceivedHttpError error", th2);
            }
            TKC("PL_sdk_html_load_error", jSONObject);
            if (this.zR) {
                this.zR = false;
                this.DhB = false;
                this.DKa = false;
                this.Dq.removeCallbacks(this.uA);
                this.Dq.removeCallbacks(this.TEQ);
                Sj(1, "ContainerLoadFail");
            }
        }
    }

    public JSONObject TEQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.DPc);
            return jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "getPlayableClickStatus error", th2);
            return new JSONObject();
        }
    }

    public void TEQ(String str) {
        this.Dq.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.2
            @Override // java.lang.Runnable
            public void run() {
                Dq.aa(Dq.this);
            }
        });
    }

    public Dq TKC(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.dLt = jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "setPlayableStyle error", th2);
        }
        return this;
    }

    public Dq TKC(JSONObject jSONObject) {
        this.liH = jSONObject;
        return this;
    }

    public Dq TKC(boolean z10) {
        if (this.NPW == -1 || this.WxP == z10) {
            return this;
        }
        this.WxP = z10;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.WxP) {
                jSONObject.put("playable_background_show_type", this.gY);
            }
        } catch (JSONException unused) {
        }
        TKC(this.WxP ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.JcM == -1 && this.WxP) {
            this.JcM = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("render_type", this.NPW == 1 ? 1 : 2);
                int i11 = this.NPW;
                if (i11 != -1) {
                    jSONObject2.put("webview_state", i11);
                }
            } catch (JSONException unused2) {
            }
            TKC("PL_sdk_page_show", jSONObject2);
        }
        if (this.JcM != -1 && !this.WxP && !this.dU) {
            this.dU = true;
        }
        if (this.WxP) {
            this.fF = System.currentTimeMillis();
        } else if (this.fF != -1) {
            this.Yf += System.currentTimeMillis() - this.fF;
            this.fF = -1L;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("viewStatus", this.WxP);
            Sj("viewableChange", jSONObject3);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "setViewable error", th2);
        }
        if (this.WxP) {
            fF();
        } else {
            JcM();
        }
        return this;
    }

    public JSONObject TKC() {
        return this.dLt;
    }

    public void TKC(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.ndK && this.f21193db > 0) {
                this.ndK = true;
            }
            if ("PL_sdk_html_load_start".equals(str) || "PL_sdk_html_load_finish".equals(str) || "PL_sdk_html_load_error".equals(str)) {
                jSONObject.put("usecache", this.rB ? 1 : 0);
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.WxP);
            jSONObject.put("playable_session_id", this.sU);
            int i11 = this.Uc;
            if (i11 == 0) {
                if (this.gR != Sj.LAND_PAGE && !aa(this.tY)) {
                    jb();
                }
                jSONObject.put("playable_url", this.tY);
            } else {
                if (i11 != 3 && i11 != 4) {
                    if (i11 == 1 || i11 == 2) {
                        jSONObject.put("playable_url", TKC(this.Gn, this.nou));
                    }
                }
                jSONObject.put("playable_url", EjP(this.vll, this.GJs));
            }
            jSONObject.put("playable_full_url", this.SP);
            jSONObject.put("playable_replay_count", this.qRN);
            jSONObject.put("playable_is_prerender", this.xzt);
            jSONObject.put("playable_is_preload", this.ndK);
            jSONObject.put("playable_render_type", this.Uc);
            jSONObject.put("playable_scenes_type", this.gR.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.Gn) ? "" : this.Gn);
            if (!TextUtils.isEmpty(this.nou)) {
                str2 = this.nou;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.6.0");
            jSONObject.put("playable_minigamelite_id", this.vll);
            jSONObject.put("playable_minigamelite_schema", this.GJs);
            jSONObject.put("playable_is_debug", this.hif);
            jSONObject.put("playable_retry_count", this.dwU);
            jSONObject.put("playable_enter_from", this.sdp);
            jSONObject.put("playable_sequence", this.MuB);
            jSONObject.put("playable_current_section", this.IOh);
            jSONObject.put("is_playable_finish", this.pfr);
            jSONObject.put("playable_card_session", this.Fm);
            jSONObject.put("playable_video_session", this.f21197jb);
            jSONObject.put("playable_network_type", uvD());
            jSONObject.put("playable_lynx_version", this.uP);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.f21194dx);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, this.liH.opt(BidResponsedEx.KEY_CID));
            jSONObject2.put("log_extra", this.liH.opt("log_extra"));
            int i12 = this.Uc;
            if (i12 != -1 && i12 != -2) {
                if (this.TFd != null) {
                    List<JSONObject> list = this.jjS;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.jjS.iterator();
                        while (it.hasNext()) {
                            JSONObject optJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (optJSONObject != null) {
                                optJSONObject.put("playable_render_type", this.Uc);
                                optJSONObject.put("playable_url", this.tY);
                            }
                            this.TFd.Sj(optJSONObject);
                        }
                        this.jjS.clear();
                    }
                    if (this.Uc == 0 && (this.gR != Sj.LAND_PAGE || aa(this.tY))) {
                        this.TFd.Sj(jSONObject);
                        return;
                    } else {
                        if (this.Uc != 0) {
                            this.TFd.Sj(jSONObject);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.jjS == null) {
                this.jjS = new ArrayList();
            }
            this.jjS.add(jSONObject2);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "reportEvent error", th2);
        }
    }

    public JSONObject TzV() {
        if (this.eMB.isNull("width")) {
            View view = this.HS.get();
            if (view == null) {
                return this.eMB;
            }
            sP(view);
        }
        return this.eMB;
    }

    public void WMZ() {
        this.HcZ = 0;
        this.nru = 0;
        this.oWa = 0.0f;
        this.f21199mj = 0;
        this.f21195gq = 0;
        this.Ph = 0;
        this.GMp = 0;
        this.hzV = 0;
        this.TX = 0;
        this.f21201vb = 0;
        this.Grp = 0;
        this.tX = 0;
        this.Aw = 0;
    }

    public String Wjd() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    public void Yf() {
        int i11;
        int i12 = this.Uc;
        if (i12 == 0 || i12 == 1 || i12 == 2) {
            if (this.DhB) {
                this.Dq.postDelayed(this.uA, this.wE * 1000);
            }
            if ((this.DKa && aa(this.tY)) || (i11 = this.Uc) == 1 || i11 == 2) {
                this.Dq.postDelayed(this.TEQ, this.ley * 1000);
            }
        }
    }

    public Set<String> Ym() {
        return this.f21200tz.Sj();
    }

    public void Ym(String str) {
        this.Dq.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.3
            @Override // java.lang.Runnable
            public void run() {
                Dq.Fmk(Dq.this);
            }
        });
    }

    public JSONObject Zq() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.gR.ordinal());
            jSONObject.put("safe_area_top_height", this.zwV);
            jSONObject.put("safe_area_bottom_height", this.Xqg);
            jSONObject.put("playable_enter_from", this.sdp);
            jSONObject.put("playable_retry_count", this.dwU);
            jSONObject.put("playable_card_session", this.Fm);
            jSONObject.put("playable_video_session", this.f21197jb);
            jSONObject.put("playable_network_type", uvD());
            jSONObject.put("aweme_id", this.HpB);
            return jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "playableInfo error", th2);
            return new JSONObject();
        }
    }

    public JSONObject aa() {
        try {
            boolean Sj2 = HiB.Sj(this.Ir, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", Sj2);
            return jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "getCameraPermission error", th2);
            return new JSONObject();
        }
    }

    public com.bytedance.sdk.openadsdk.sU.Sj dNu() {
        return this.TFd;
    }

    public void dx() {
        com.bytedance.sdk.openadsdk.sU.Sj sj2 = this.TFd;
        if (sj2 != null) {
            sj2.sP();
        }
    }

    public void fF() {
        if (this.f21196ib) {
            this.Wjd = System.currentTimeMillis();
            if (this.gR == Sj.FEED_AWEME) {
                if (this.WxP && this.f21202xu == 3) {
                    sP sPVar = this.Zq;
                    if (sPVar != null && sPVar.sP()) {
                        Ei();
                        return;
                    } else {
                        if (this.Zq == null) {
                            this.Zq = new sP(this, this.LqL);
                            Ei();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.WxP && this.f21202xu == 2) {
                sP sPVar2 = this.Zq;
                if (sPVar2 != null && sPVar2.sP()) {
                    Ei();
                } else if (this.Zq == null) {
                    this.Zq = new sP(this, this.LqL);
                    Ei();
                }
            }
        }
    }

    public void ib() {
        this.UHs = 2;
    }

    public void kF() {
        this.pfr = true;
    }

    public void ley() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.FPG > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.FPG);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.WMZ > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.WMZ);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            TKC("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public Dq sP(int i11) {
        this.Uc = i11;
        return this;
    }

    public Dq sP(long j11) {
        if (j11 <= 0) {
            this.ley = 10L;
        } else {
            this.ley = j11;
        }
        return this;
    }

    public Dq sP(String str) {
        this.eI = str;
        return this;
    }

    public Dq sP(boolean z10) {
        this.xzt = z10;
        return this;
    }

    public Map<String, String> sP() {
        return this.nP;
    }

    public void sP(int i11, String str) {
        this.UHs = i11;
        if (this.f21198kb == null) {
            this.f21198kb = new JSONObject();
        }
        try {
            this.f21198kb.put("playable_stuck_type", i11);
            this.f21198kb.put("playable_stuck_reason", str);
            if (this.Wjd > 0) {
                this.f21198kb.put("playable_stuck_duration", System.currentTimeMillis() - this.Wjd);
            } else {
                this.f21198kb.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        TKC("PL_sdk_page_stuck", this.f21198kb);
        JcM();
        if (this.TFd == null || i11 != 2) {
            return;
        }
        this.f21198kb = new JSONObject();
    }

    public void sP(String str, String str2) {
        Bitmap Sj2;
        if (TextUtils.isEmpty(str2) || (Sj2 = HiB.Sj(str2)) == null) {
            return;
        }
        MediaStore.Images.Media.insertImage(this.Ir.getContentResolver(), Sj2, str, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sP(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HiB(str, jSONObject);
    }

    public void sP(JSONObject jSONObject) {
        if (this.TFd != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject sU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.oWa);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.f21199mj);
            jSONObject2.put("height", this.f21195gq);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.GMp);
            jSONObject3.put("y", this.Ph);
            jSONObject3.put("width", this.hzV);
            jSONObject3.put("height", this.TX);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.Grp);
            jSONObject4.put("y", this.f21201vb);
            jSONObject4.put("width", this.tX);
            jSONObject4.put("height", this.Aw);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "getViewport error", th2);
        }
        return jSONObject;
    }

    public JSONObject sef() {
        boolean Sj2;
        boolean Sj3;
        try {
            boolean z10 = true;
            if (Build.VERSION.SDK_INT >= 33) {
                Sj2 = HiB.Sj(this.Ir, "android.permission.READ_MEDIA_IMAGES");
                Sj3 = true;
            } else {
                Sj2 = HiB.Sj(this.Ir, "android.permission.READ_EXTERNAL_STORAGE");
                Sj3 = HiB.Sj(this.Ir, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", Sj2);
            jSONObject.put("isHasWrite", Sj3);
            if (!Sj2 || !Sj3) {
                z10 = false;
            }
            jSONObject.put("result", z10);
            return jSONObject;
        } catch (Throwable th2) {
            Jcg.Sj("PlayablePlugin", "getCameraPermission error", th2);
            return new JSONObject();
        }
    }

    public void uA(String str) {
        WebView webView;
        boolean z10 = this.f21202xu == -1;
        this.f21202xu = 2;
        if (!z10) {
            this.AVc = str;
            JSONObject jSONObject = new JSONObject();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.Mts = currentTimeMillis;
                long j11 = this.WMZ;
                jSONObject.put("playable_html_load_start_duration", j11 != -1 ? currentTimeMillis - j11 : 0L);
                jSONObject.put("playable_has_show", FPG());
            } catch (Throwable th2) {
                Jcg.Sj("PlayablePlugin", "reportUrlLoadFinish error", th2);
            }
            TKC("PL_sdk_html_load_finish", jSONObject);
        }
        this.DhB = false;
        this.Dq.removeCallbacks(this.uA);
        try {
            if (this.Uc == 0) {
                if (this.uvD && (webView = this.aZ) != null) {
                    this.uvD = false;
                    webView.evaluateJavascript(Wjd(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.sU.Dq.11
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                fF();
            }
        } catch (Throwable th3) {
            Jcg.Sj("PlayablePlugin", "crashMonitor error", th3);
        }
    }

    public void uA(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, true);
            if (optBoolean) {
                this.f21202xu = 3;
                fF();
            } else {
                this.f21202xu = -2;
            }
            if (optBoolean || !this.zR) {
                return;
            }
            this.zR = false;
            this.DhB = false;
            this.DKa = false;
            this.Dq.removeCallbacks(this.uA);
            this.Dq.removeCallbacks(this.TEQ);
            Sj(4, "CaseRenderFail");
        }
    }

    public boolean uA() {
        return this.WxP;
    }

    public void uP() {
        if (this.TFd != null) {
            Sj sj2 = Sj.LAND_PAGE;
        }
    }

    public String uvD() {
        com.bytedance.sdk.openadsdk.sU.Sj sj2;
        if (TextUtils.isEmpty(this.Ei) && (sj2 = this.TFd) != null) {
            this.Ei = sj2.Sj().toString();
        }
        return this.Ei;
    }

    public Dq vS(String str) {
        this.f21194dx = str;
        return this;
    }

    public String vS() {
        return this.QZ;
    }

    public void vS(JSONObject jSONObject) {
        sP(2, jSONObject != null ? jSONObject.optString(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, "The material directly invokes the exception pocket mask on the client") : "The material directly invokes the exception pocket mask on the client");
    }

    public void vS(boolean z10) {
        this.rB = z10;
    }

    public void wE() {
        if (this.TFd != null) {
            Sj sj2 = Sj.LAND_PAGE;
        }
    }

    public int xD() {
        return this.NPW;
    }

    public void zR() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.FPG > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.FPG);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.WMZ > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.WMZ;
                this.xD = currentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", currentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            TKC("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }
}
