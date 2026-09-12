package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.EjP.Sj.sef;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.settings.HiB;
import com.bytedance.sdk.openadsdk.core.settings.TTSdkSettings;
import com.bytedance.sdk.openadsdk.core.settings.Ym;
import com.bytedance.sdk.openadsdk.core.settings.aa;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.transsion.push.PushConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Fmk implements Ym.Sj, vS {
    HiB.sP<sef> Dq;
    private final com.bytedance.sdk.openadsdk.core.settings.Sj Fmk;
    final HiB.sP<ConcurrentHashMap<String, Integer>> Jcg;
    private boolean RiZ;
    private Set<String> TEQ;
    private int TzV;
    private final AtomicBoolean Zq;
    private int dNu;

    /* renamed from: ib, reason: collision with root package name */
    private final Runnable f21179ib;
    private final HiB.sP<Map<String, Integer>> kF;
    private HiB.sP<JSONObject> ley;
    private final TEQ sef;
    private final Set<String> uP;
    private volatile boolean uvD;
    private final HiB.sP<Set<String>> wE;
    private final BroadcastReceiver zR;
    public static final String Sj = j6.a.a("_", new CharSequence[]{"bus_con_collect", Mts.kF()});
    public static final String sP = j6.a.a("_", new CharSequence[]{"bus_con", Mts.kF(), Mts.ib(), "timeout"});
    public static final String TKC = j6.a.a("_", new CharSequence[]{"bus_con", Mts.kF(), Mts.ib(), "alpha"});
    private static final String uA = Mts.dNu();
    private static final com.bytedance.sdk.component.Dq.Dq Ym = new com.bytedance.sdk.component.Dq.Dq("TemplateReInitTask") { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.adexpress.Sj.sP.HiB.sP().uA();
            com.bytedance.sdk.component.adexpress.Sj.sP.HiB.sP().sP(false);
            com.bytedance.sdk.component.adexpress.Sj.sP.sP.sP();
            com.bytedance.sdk.component.adexpress.Sj.sP.HiB.sP().TKC();
        }
    };
    public static String EjP = "";
    public static String HiB = "IABTCF_TCString";

    /* renamed from: aa, reason: collision with root package name */
    private static boolean f21177aa = false;
    private static final ConcurrentLinkedQueue<aa.Sj> sU = new ConcurrentLinkedQueue<>();

    /* renamed from: dx, reason: collision with root package name */
    private static final Dq f21178dx = new Dq();
    static final ConcurrentHashMap<String, Integer> vS = new ConcurrentHashMap<>();

    /* renamed from: com.bytedance.sdk.openadsdk.core.settings.Fmk$9, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass9 extends BroadcastReceiver {
        private final Runnable sP = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.9.1
            @Override // java.lang.Runnable
            public void run() {
                JcM.sP(new com.bytedance.sdk.component.Dq.Dq("LoadLocalData") { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.9.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Fmk.this.sP();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        };

        AnonymousClass9() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            JcM.sP(new com.bytedance.sdk.component.Dq.Dq("setting_receiver") { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.9.2
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if ("_tryFetRemoDat".equals(action)) {
                        Fmk.this.Sj(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                    } else if ("_dataChanged".equals(action)) {
                        com.bytedance.sdk.component.utils.uA.Sj().removeCallbacks(AnonymousClass9.this.sP);
                        com.bytedance.sdk.component.utils.uA.Sj().postDelayed(AnonymousClass9.this.sP, 10000L);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Sj {
        static final Fmk Sj = new Fmk();
    }

    private Fmk() {
        this.TEQ = Collections.synchronizedSet(new HashSet());
        this.Fmk = new com.bytedance.sdk.openadsdk.core.settings.Sj();
        this.sef = new TEQ(new aa.Sj() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.5
            @Override // com.bytedance.sdk.openadsdk.core.settings.aa.Sj
            public void Sj() {
                aa.Sj[] sjArr;
                boolean unused = Fmk.f21177aa = true;
                if (Fmk.sU == null || Fmk.sU.size() == 0 || (sjArr = (aa.Sj[]) Fmk.sU.toArray()) == null) {
                    return;
                }
                for (aa.Sj sj2 : sjArr) {
                    sj2.Sj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.aa.Sj
            public void sP() {
                if (Fmk.sU == null || Fmk.sU.isEmpty()) {
                    return;
                }
                Iterator it = Fmk.sU.iterator();
                while (it.hasNext()) {
                    ((aa.Sj) it.next()).sP();
                }
            }
        });
        this.Zq = new AtomicBoolean(false);
        this.uvD = false;
        this.dNu = 5000;
        this.TzV = 10;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9();
        this.zR = anonymousClass9;
        this.f21179ib = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.10
            @Override // java.lang.Runnable
            public void run() {
                Fmk.this.EjP(2);
                Fmk.this.hzV();
            }
        };
        this.Jcg = new HiB.sP<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.11
            @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public ConcurrentHashMap<String, Integer> sP(String str) {
                if (TextUtils.isEmpty(str)) {
                    return Fmk.vS;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        int optInt = jSONObject.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && optInt >= 0 && optInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(optInt));
                        }
                    }
                } catch (JSONException e11) {
                    e11.getMessage();
                }
                return concurrentHashMap;
            }
        };
        this.kF = new HiB.sP<Map<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.12
            @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Map<String, Integer> sP(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap hashMap = new HashMap(jSONObject.length());
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            int optInt = jSONObject.optInt(next, 100);
                            if (optInt < 0 || optInt > 100) {
                                hashMap.put(next, 100);
                            } else {
                                hashMap.put(next, Integer.valueOf(optInt));
                            }
                        }
                    }
                    return hashMap;
                } catch (Exception e11) {
                    sU.sP("get applog rate from sp failed:" + e11.getMessage(), new Object[0]);
                    return null;
                }
            }
        };
        this.uP = new HashSet();
        this.wE = new HiB.sP<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.2
            @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Set<String> sP(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("applog_count");
                        if (optInt >= 2 && optInt <= 100) {
                            Fmk.this.TzV = optInt;
                        }
                        int optInt2 = jSONObject.optInt("applog_interval");
                        if (optInt2 >= 100 && optInt2 <= 30000) {
                            Fmk.this.dNu = optInt2;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                String string = jSONArray.getString(i11);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e11) {
                        e11.getMessage();
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList("click", PushConstants.PUSH_SERVICE_TYPE_SHOW, "insight_log", "mrc_show")) : hashSet;
            }
        };
        this.ley = new HiB.sP<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.3
            @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public JSONObject sP(String str) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th2) {
                    sU.sP("TTAD.SdkSettings", th2.getMessage());
                    jSONObject = null;
                }
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        };
        this.Dq = new HiB.sP<sef>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.4
            private sef.Sj Sj(JSONObject jSONObject) {
                if (jSONObject != null) {
                    return new sef.Sj(jSONObject.optInt("retry_times", -1), jSONObject.optInt("time_interval", -1));
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public sef sP(String str) {
                sef sefVar = new sef();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    sefVar.Sj(jSONObject.optInt("enable_strategy", 0) == 1);
                    sefVar.Sj(Sj(jSONObject.optJSONObject("default")));
                    JSONObject optJSONObject = jSONObject.optJSONObject("adid_configs");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            sefVar.Sj(next, Sj(optJSONObject.getJSONObject(next)));
                        }
                    }
                } catch (Exception unused) {
                }
                return sefVar;
            }
        };
        try {
            Context Sj2 = dNu.Sj();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                Sj2.registerReceiver(anonymousClass9, intentFilter, 4);
            } else {
                Sj2.registerReceiver(anonymousClass9, intentFilter);
            }
        } catch (Exception e11) {
            sU.Sj("TTAD.SdkSettings", "", e11);
        }
    }

    private Set<String> Aw() {
        return (Set) this.sef.Sj("perf_con_applog_send", this.uP, this.wE);
    }

    @Nullable
    private static SharedPreferences EjP(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void Sj(aa.Sj sj2) {
        ConcurrentLinkedQueue<aa.Sj> concurrentLinkedQueue = sU;
        if (concurrentLinkedQueue.contains(sj2)) {
            return;
        }
        concurrentLinkedQueue.add(sj2);
    }

    private static int TKC(boolean z10) {
        return z10 ? 20 : 5;
    }

    public static String TKC(Context context) {
        SharedPreferences EjP2;
        return (context == null || (EjP2 = EjP(context)) == null) ? "" : EjP2.getString(HiB, "");
    }

    public static boolean TX() {
        return f21177aa;
    }

    public static vS gq() {
        if (dNu.Sj() != null) {
            return Sj.Sj;
        }
        IllegalStateException illegalStateException = new IllegalStateException("context is null");
        Log.e("TTAD.SdkSettings", "context is null", illegalStateException);
        ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
        return f21178dx;
    }

    public static void mj() {
        Context Sj2;
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC() && (Sj2 = dNu.Sj()) != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(Sj2.getPackageName());
                intent.setAction("_dataChanged");
                Sj2.sendBroadcast(intent);
            } catch (Throwable th2) {
                sU.Sj("TTAD.SdkSettings", "", th2);
            }
        }
    }

    public static int sP(Context context) {
        SharedPreferences EjP2;
        if (context == null || (EjP2 = EjP(context)) == null) {
            return -2;
        }
        int i11 = EjP2.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE);
        int i12 = EjP2.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE);
        if (i11 == Integer.MIN_VALUE && i12 == Integer.MIN_VALUE) {
            return -2;
        }
        return EjP2.getInt("IABTCF_gdprApplies", -1);
    }

    private static void sP(int i11, boolean z10) {
        Context Sj2 = dNu.Sj();
        if (Sj2 != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(Sj2.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z10);
                intent.putExtra("_source", i11);
                Sj2.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    private String tX() {
        return this.sef.Sj("force_language", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean AVc() {
        return this.sef.Sj("bus_con_video_keep_screen_on", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Bml() {
        return this.sef.Sj("perf_con_thread_stack_size", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Chv() {
        return this.sef.Sj("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Dq() {
        return this.sef.Sj("if_both_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Dq(String str) {
        return str == null || ley(str).sef == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean EZ() {
        if (com.bytedance.sdk.component.adexpress.EjP.sP.Sj(dNu.Sj())) {
            return this.sef.Sj("support_rtl", false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Ei() {
        int Sj2 = this.Fmk.Sj("perf_con_apm", 100);
        if (Sj2 == 0) {
            return false;
        }
        return Sj2 < 0 || Sj2 >= 100 || Sj2 > ((int) (Math.random() * 100.0d));
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int EjP() {
        return this.sef.Sj("max_tpl_cnts", 100);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void EjP(@TTSdkSettings.FETCH_REQUEST_SOURCE int i11) {
        Sj(i11, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean EjP(String str) {
        return ley(str).Yf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String FPG() {
        return this.sef.Sj("dc", "TX");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Fm() {
        int Sj2 = this.sef.Sj("privacy_ad_enable", Integer.MAX_VALUE);
        if (Sj2 == 1) {
            return true;
        }
        if (Sj2 == 0) {
            return false;
        }
        int RiZ = Mts.RiZ();
        return RiZ == 1 || RiZ == 2 || RiZ == 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Fmk() {
        Aw();
        return this.TzV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Fmk(String str) {
        return ley(String.valueOf(str)).Dq;
    }

    public long GMp() {
        return this.sef.Sj("last_req_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String HS() {
        return this.sef.Sj("dual_event_url", (String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public JSONObject HcZ() {
        return (JSONObject) this.sef.Sj("perf_con_thread_pool_config", new JSONObject(), this.ley);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    @Nullable
    public JSONObject HiB() {
        return (JSONObject) this.sef.Sj("digest", null, HiB.Sj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean HiB(String str) {
        int i11 = ley(str).HiB;
        return i11 != 1 ? i11 == 2 && TzV.TKC(dNu.Sj()) != 0 : TzV.EjP(dNu.Sj());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean HpB() {
        return this.sef.Sj("bus_con_sec_type", Integer.MAX_VALUE) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int IOh() {
        return this.sef.Sj("blank_detect_rate", 30);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Ir() {
        return this.sef.Sj("bus_con_behavior_count", 300);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String JcM() {
        return this.sef.Sj("policy_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Jcg(String str) {
        return ley(str).TzV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void Jcg() {
        this.sef.Sj().Sj("tt_sdk_settings").Sj("ab_test_param").Sj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String LD() {
        return this.sef.Sj("settings_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean LD(String str) {
        Set set;
        if (TextUtils.isEmpty(str) || (set = (Set) this.sef.Sj("token_adx_ids", Collections.emptySet(), HiB.sP)) == null || set.size() == 0) {
            return false;
        }
        return set.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean LqL() {
        return this.sef.sP();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean LqL(@NonNull String str) {
        Set set = (Set) this.sef.Sj("privacy_fields_allowed", Collections.emptySet(), HiB.sP);
        if (!set.isEmpty()) {
            return set.contains(str);
        }
        int RiZ = Mts.RiZ();
        if (RiZ != 1) {
            if (RiZ != 2 && RiZ != 3) {
                return false;
            }
            if (!"mcc".equals(str) && !"mnc".equals(str)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String Mts() {
        return this.sef.Sj("dyn_draw_engine_url", uA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String[] MuB() {
        Set<String> set;
        try {
            set = this.TEQ;
        } catch (Throwable unused) {
        }
        if (set == null || set.size() == 0) {
            JSONArray jSONArray = new JSONArray(this.sef.Sj("gecko_hosts", (String) null));
            if (jSONArray.length() != 0) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    this.TEQ.add(jSONArray.getString(i11));
                }
            }
            Set<String> Sj2 = TEQ.Sj(this.TEQ);
            this.TEQ = Sj2;
            if (Sj2 != null) {
                if (Sj2.size() == 0) {
                }
            }
            return null;
        }
        return (String[]) this.TEQ.toArray(new String[0]);
    }

    public long Ph() {
        long Sj2 = this.sef.Sj("req_inter_min", 600000L);
        if (Sj2 < 0 || Sj2 > 86400000) {
            return 600000L;
        }
        return Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String QZ() {
        return this.sef.Sj("bus_con_check_clz", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int RiZ(String str) {
        return ley(str).sU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String RiZ() {
        return this.sef.Sj("ab_test_param", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public Set<String> RrR() {
        return (Set) this.sef.Sj("perf_con_drop2rt_skip_label_list", Collections.emptySet(), HiB.sP);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void SP() {
        HiB.Sj Sj2 = this.sef.Sj();
        Sj2.Sj("settings_url", "");
        Sj2.Sj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Sj(int i11) {
        return ley(String.valueOf(i11)).WMZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Sj(String str) {
        if (str == null) {
            return 0;
        }
        return dNu.EjP().ley(str).RiZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Sj(String str, boolean z10) {
        int i11;
        return (str == null || (i11 = ley(str).uP) == -1) ? TKC(z10) : i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void Sj() {
        File file;
        File dataDir;
        try {
            TKC.Sj();
            this.sef.TKC();
            this.Fmk.TKC();
            Context Sj2 = dNu.Sj();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                dataDir = Sj2.getDataDir();
                file = new File(dataDir, "shared_prefs");
            } else {
                file = new File(Sj2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(".xml", "");
                if (i11 >= 24) {
                    Sj2.deleteSharedPreferences(replace);
                } else {
                    Sj2.getSharedPreferences(replace, 0).edit().clear().apply();
                    com.bytedance.sdk.component.utils.Jcg.TKC(file2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void Sj(@TTSdkSettings.FETCH_REQUEST_SOURCE int i11, boolean z10) {
        if (!com.bytedance.sdk.openadsdk.core.sef.HiB() && i11 != 1 && i11 != 2) {
            if (z10) {
                this.RiZ = true;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.uA.sP().EjP())) {
                return;
            }
            if (this.RiZ) {
                this.RiZ = false;
                if (!z10) {
                    z10 = true;
                }
            }
            long GMp = GMp();
            long currentTimeMillis = System.currentTimeMillis();
            long Ph = Ph();
            long j11 = currentTimeMillis - GMp;
            if (z10 || j11 >= Ph) {
                if (!Ym.Sj()) {
                    sP(i11, z10);
                } else if (this.Zq.compareAndSet(false, true)) {
                    JcM.sP((com.bytedance.sdk.component.Dq.Dq) new Ym(this, this.sef, this.Fmk));
                    com.bytedance.sdk.openadsdk.core.sef.sP().removeCallbacks(this.f21179ib);
                }
            }
        } catch (Throwable th2) {
            ApmHelper.reportCustomError("settings request error", "settings", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void Sj(long j11) {
        this.sef.Sj().Sj("last_req_time", j11).Sj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void Sj(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.zR, intentFilter, 4);
            } else {
                context.registerReceiver(this.zR, intentFilter);
            }
        } catch (Exception e11) {
            sU.Sj("TTAD.SdkSettings", "", e11);
        }
        if (ndK()) {
            EjP(1);
            hzV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void Sj(JSONObject jSONObject, HiB.Sj sj2) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        TEQ teq = this.sef;
        String str = uA;
        String Sj2 = teq.Sj("dyn_draw_engine_url", str);
        final String optString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(Sj2) && !TextUtils.isEmpty(optString) && !optString.equals(Sj2)) {
            com.bytedance.sdk.openadsdk.core.sef.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.equals(Fmk.this.sef.Sj("dyn_draw_engine_url", Fmk.uA), optString)) {
                        com.bytedance.sdk.component.adexpress.Sj.sP.HiB.sP().TKC();
                    }
                }
            }, 5000L);
        }
        sj2.Sj("dyn_draw_engine_url", optString);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.Ym.Sj
    public void Sj(boolean z10) {
        this.Zq.set(false);
        hzV();
        if (z10) {
            HashMap hashMap = new HashMap();
            Set<String> dLt = dLt();
            if (dLt != null && !dLt.isEmpty()) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, dLt);
            }
            String Fmk = Mts.Fmk();
            if (!TextUtils.isEmpty(Fmk)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, Fmk);
            }
            hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, oWa());
            com.bytedance.sdk.openadsdk.core.uA.sP.sP().Sj(hashMap);
            mj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Sj(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        return (cryptDataScene == PangleEncryptConstant.CryptDataScene.GET_ADS || cryptDataScene == PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN) ? this.sef.Sj("perf_con_crypt_V4_get_ad", false) : cryptDataScene == PangleEncryptConstant.CryptDataScene.APP_LOG ? this.sef.Sj("perf_con_crypt_V4_applog", false) : this.sef.Sj("perf_con_crypt_V4", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int TEQ() {
        return this.sef.Sj("load_callback_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int TEQ(String str) {
        return ley(str).Ym;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public sef TFd() {
        return (sef) this.sef.Sj("perf_con_track_url_strategy", sef.Sj, this.Dq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int TKC(int i11) {
        return ley(String.valueOf(i11)).uA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String TKC() {
        return this.sef.Sj("aes_key", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean TKC(String str) {
        return ley(str).TKC == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public float TO() {
        return this.sef.Sj(TKC, 1.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int TzV() {
        return this.sef.Sj("loadedCallbackOpportunity", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public JSONObject TzV(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(this.sef.Sj("core_settings", ""));
            try {
                jSONObject2.put("ad_slot_setting", ley(str).Mts);
                return jSONObject2;
            } catch (JSONException e11) {
                e = e11;
                jSONObject = jSONObject2;
                sU.sP("TTAD.SdkSettings", "getCoreSettingJsonObj", e.getMessage());
                return jSONObject;
            }
        } catch (JSONException e12) {
            e = e12;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean UHs() {
        return this.sef.Sj("read_video_from_cache", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Uc() {
        return this.sef.Sj("perf_con_adlog_turn_off_retry_stats", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int WMZ() {
        return this.sef.Sj("ivrv_downward", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Wjd() {
        return this.sef.Sj("isGdprUser", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Xqg() {
        return this.sef.Sj("token_enable", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Yf(String str) {
        Integer num;
        Map map = (Map) this.sef.Sj("perf_con_applog_rate", null, this.kF);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String Yf() {
        return this.sef.Sj("ads_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Ym() {
        return this.sef.Sj("splash_video_load_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Ym(String str) {
        return ley(str).f21180aa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int Zq(String str) {
        return ley(str).TEQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean Zq() {
        return this.sef.Sj("allow_blind_mode_request_ad", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean aNB() {
        return this.sef.Sj("bus_con_adshow_check_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean aZ() {
        return this.sef.Sj("perf_con_use_new_thread_pool", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public Set<String> aa() {
        return Aw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean aa(String str) {
        try {
            return ley(str).f21182ib != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public long cX() {
        return this.sef.Sj("perf_con_adlog_expire_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public Set<String> dLt() {
        return (Set) this.sef.Sj("privacy_fields_allowed", Collections.emptySet(), HiB.sP);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean dNu() {
        return this.sef.Sj("ad_revenue_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean dNu(String str) {
        return str == null || DeviceUtils.TEQ(dNu.Sj()) == 0 || ley(str).Fmk == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean db() {
        return this.sef.Sj("privacy_debug_unlock", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int dwU() {
        int Sj2 = this.sef.Sj("perf_con_webview_cache_count", 0);
        if (Sj2 < 0) {
            return 0;
        }
        return Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int dx(String str) {
        return ley(str).wE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public long dx() {
        return this.sef.Sj("duration", 10000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean eI() {
        return this.sef.Sj("bus_con_rewardedfull_link", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int eMB() {
        return this.sef.Sj(sP, 10000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String fF() {
        return this.sef.Sj("app_log_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String gR() {
        return this.sef.Sj("bus_con_express_host", "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int gY() {
        return this.sef.Sj("bus_con_send_log_type", 1);
    }

    void hzV() {
        if (Ym.Sj()) {
            com.bytedance.sdk.openadsdk.core.sef.sP().removeCallbacks(this.f21179ib);
            com.bytedance.sdk.openadsdk.core.sef.sP().postDelayed(this.f21179ib, Ph());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int ib(String str) {
        return ley(str).LqL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public Jcg ib() {
        return (Jcg) this.sef.Sj("insert_js_config", Jcg.Sj, new HiB.sP<Jcg>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.8
            @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Jcg sP(String str) {
                return new Jcg(str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int jb() {
        int Sj2 = this.sef.Sj("privacy_personalized_ad", Integer.MAX_VALUE);
        if (Sj2 != Integer.MAX_VALUE) {
            return Sj2;
        }
        int RiZ = Mts.RiZ();
        if (RiZ == 1 || RiZ == 2) {
            return 2;
        }
        return RiZ != 3 ? 0 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String kF() {
        return this.sef.Sj("playableLoadH5Url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean kF(String str) {
        return ley(str).fF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean kb() {
        return this.sef.Sj("perf_con_adlog_turn_off_retry_ad", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    @NonNull
    public sP ley(String str) {
        return TKC.Sj(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void ley() {
        String tX = tX();
        if (TextUtils.isEmpty(tX)) {
            return;
        }
        if (tX.equals("zh-Hant")) {
            com.bytedance.sdk.component.utils.aa.Sj(dNu.Sj(), "zh", "tw");
        } else {
            com.bytedance.sdk.component.utils.aa.Sj(dNu.Sj(), tX, null);
        }
        try {
            TTAdDislikeToast.onResourceUpdated();
        } catch (Throwable th2) {
            sU.sP("TTAD.SdkSettings", th2.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int liH() {
        return this.sef.Sj("perf_con_close_button_delay_check_time", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int mZN() {
        return this.sef.Sj("perf_con_drawable_code", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean nP() {
        return this.sef.Sj("bus_con_url_check", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean ndK() {
        return this.uvD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean nru() {
        return this.sef.Sj(Sj, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String oWa() {
        return this.sef.Sj("target_region", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public JSONObject pfr() {
        return (JSONObject) this.sef.Sj("video_cache_config", null, HiB.Sj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean qRN() {
        return this.sef.Sj("global_rate", 1.0f) == 1.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int sP(int i11) {
        return ley(String.valueOf(i11)).sP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int sP(String str) {
        Integer num;
        Map map = (Map) this.sef.Sj("perf_con_stats_rate", vS, this.Jcg);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public synchronized void sP() {
        SystemClock.elapsedRealtime();
        boolean z10 = this.uvD;
        this.Fmk.Sj(this.uvD);
        this.sef.Sj(this.uvD);
        TKC.Sj(!z10);
        this.uvD = true;
        SystemClock.elapsedRealtime();
        if (!z10) {
            com.bytedance.sdk.openadsdk.core.sef.sP().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.Fmk.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!Ym.Sj()) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.Sj.Sj().sP();
                    } else {
                        Fmk.this.EjP(1);
                        Fmk.this.hzV();
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public void sP(JSONObject jSONObject, HiB.Sj sj2) {
        if (jSONObject.has("is_gdpr_user")) {
            int optInt = jSONObject.optInt("is_gdpr_user", -1);
            sj2.Sj("isGdprUser", (optInt == -1 || optInt == 1 || optInt == 0) ? optInt : -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean sU() {
        return this.sef.Sj("landingpage_new_style", -1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean sU(String str) {
        return ley(str).f21181dx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int sdp() {
        int Sj2 = this.sef.Sj("perf_con_webview_cache_count_v3", 0);
        if (Sj2 < 0) {
            return 0;
        }
        return Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int sef() {
        Aw();
        return this.dNu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean sef(String str) {
        return Fmk(str) != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean tY() {
        return this.sef.Sj("perf_con_is_new_net_thread", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int tz() {
        int Sj2 = this.sef.Sj("bus_con_auto_click_delay", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        return Sj2 <= 0 ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int uA(String str) {
        if (str == null) {
            return 1500;
        }
        return ley(str).uvD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public String uA() {
        return this.sef.Sj("ab_test_version", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int uP() {
        int Sj2 = this.sef.Sj("fetch_tpl_timeout_ctrl", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        return Sj2 <= 0 ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int uP(String str) {
        return ley(str).JcM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean uvD() {
        return this.sef.Sj("support_gzip", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean uvD(String str) {
        return ley(str).zR == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public long vS() {
        return this.sef.Sj("data_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean vS(String str) {
        return ley(str).Jcg == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int wE() {
        int Sj2 = this.sef.Sj("fetch_tpl_second", 0);
        if (Sj2 <= 0) {
            return 0;
        }
        return Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean wE(String str) {
        return dNu.EjP().ley(str).Zq == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int xD() {
        return this.sef.Sj("vbtt", 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean xhi() {
        return this.sef.Sj("bus_con_dislike_report_raw", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int xu() {
        int Sj2 = this.sef.Sj("bus_con_token_thread_count", 4);
        if (Sj2 <= 0 || Sj2 > 30) {
            return 4;
        }
        return Sj2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int zR() {
        return this.sef.Sj("max", 50);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public int zR(String str) {
        return ley(str).ley;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vS
    public boolean zwV() {
        return this.sef.Sj("privacy_app_reg", true);
    }
}
