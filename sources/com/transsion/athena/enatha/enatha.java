package com.transsion.athena.enatha;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.tencent.mmkv.MMKV;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.Track;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.athena.hatnea.atnhae;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.ga.i;
import com.transsion.gslb.GslbSdk;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class enatha extends com.transsion.athena.enatha.athena implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile enatha f42778c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42779d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f42780e;

    /* renamed from: f, reason: collision with root package name */
    private int f42781f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f42782g;

    /* renamed from: h, reason: collision with root package name */
    private int f42783h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Track> f42784i;

    /* renamed from: j, reason: collision with root package name */
    private long f42785j;

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray<String> f42786k;

    /* renamed from: l, reason: collision with root package name */
    private String f42787l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f42788m;

    /* renamed from: n, reason: collision with root package name */
    private long f42789n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f42790o;

    /* renamed from: p, reason: collision with root package name */
    private long f42791p;

    /* renamed from: q, reason: collision with root package name */
    private final com.transsion.athena.aethna.aethna f42792q;

    /* renamed from: r, reason: collision with root package name */
    private final Runnable f42793r;

    /* renamed from: s, reason: collision with root package name */
    private long f42794s;

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f42795t;

    /* renamed from: u, reason: collision with root package name */
    private final LocationListener f42796u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class aatnhe implements GslbSdk.InitListener {
        aatnhe(enatha enathaVar) {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class aethna implements GslbSdk.InitListener {
        aethna() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            enatha.this.f42787l = map == null ? "" : map.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class anateh implements GslbSdk.InitListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f42798a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f42799b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.transsion.athena.config.data.model.athena f42800c;

        anateh(String str, int i11, com.transsion.athena.config.data.model.athena athenaVar) {
            this.f42798a = str;
            this.f42799b = i11;
            this.f42800c = athenaVar;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            enatha.this.a(this.f42798a, this.f42799b, this.f42800c, map == null ? "" : map.toString());
        }
    }

    /* loaded from: classes5.dex */
    class anehat implements Runnable {
        anehat() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!com.transsion.athena.config.data.model.ehanat.r()) {
                com.transsion.athena.taaneh.aethna.c("Athena SDK isAthenaEnable = false");
                return;
            }
            try {
                MMKV J = MMKV.J("AthenaKV", 2);
                String[] a11 = J.a();
                if (a11 != null && a11.length > 0) {
                    enatha.this.a(J);
                }
                enatha.this.f42776b.postDelayed(this, 300000L);
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        }
    }

    /* loaded from: classes5.dex */
    class athena extends com.transsion.athena.aethna.aethna {
        athena() {
        }

        @Override // com.transsion.athena.aethna.aethna
        public void a(int i11, boolean z10) {
            try {
                if (i11 > 0) {
                    enatha.this.a(i11, z10);
                } else {
                    enatha.a(enatha.this);
                }
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b("onConfigChanged exception : %s", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class ehanat implements GslbSdk.ResultListener {
        ehanat(enatha enathaVar) {
        }

        @Override // com.transsion.gslb.GslbSdk.ResultListener
        public void onGslbFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.ResultListener
        public void onGslbSuccess(String str) {
        }
    }

    /* loaded from: classes5.dex */
    class ehatna implements Runnable {
        ehatna() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MissingPermission"})
        public void run() {
            try {
                enatha.this.a((Location) null);
                LocationManager locationManager = (LocationManager) enatha.this.f42775a.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager != null) {
                    locationManager.removeUpdates(enatha.this.f42796u);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsion.athena.enatha.enatha$enatha, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0606enatha implements com.transsion.athena.data.anateh.enatha<String> {
        C0606enatha(enatha enathaVar) {
        }

        @Override // com.transsion.athena.data.anateh.enatha
        public void a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("v", str);
            i.a().c(new com.transsion.ga.anateh("cleanupEvents_oom", bundle));
        }
    }

    /* loaded from: classes5.dex */
    class hatnea implements LocationListener {
        hatnea() {
        }

        @Override // android.location.LocationListener
        @SuppressLint({"MissingPermission"})
        public void onLocationChanged(Location location) {
            enatha enathaVar = enatha.this;
            Handler handler = enathaVar.f42776b;
            if (handler != null) {
                handler.removeCallbacks(enathaVar.f42795t);
            }
            try {
                enatha.this.a(location);
                LocationManager locationManager = (LocationManager) enatha.this.f42775a.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager != null) {
                    locationManager.removeUpdates(enatha.this.f42796u);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i11, Bundle bundle) {
        }
    }

    private enatha(Context context) {
        super(context);
        this.f42779d = false;
        this.f42780e = false;
        this.f42786k = new SparseArray<>();
        this.f42791p = 0L;
        this.f42792q = new athena();
        this.f42793r = new anehat();
        this.f42794s = 0L;
        this.f42795t = new ehatna();
        this.f42796u = new hatnea();
        HandlerThread handlerThread = new HandlerThread("Athena-Worker", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f42776b = handler;
        handler.sendEmptyMessage(303);
    }

    private Track a(TrackDataWrapper trackDataWrapper) {
        Object jSONObject;
        Track track = new Track();
        track.setEventName(trackDataWrapper.a());
        track.setTid(trackDataWrapper.b());
        track.setTrackTs(System.currentTimeMillis());
        track.setTrackErTs(SystemClock.elapsedRealtime());
        TrackData c11 = trackDataWrapper.c();
        try {
            JSONObject a11 = c11.a();
            String str = com.transsion.athena.config.data.model.ehanat.f42661h;
            if (a11.has("_eparam")) {
                jSONObject = a11.get("_eparam");
                if (!(jSONObject instanceof JSONArray) || a11.length() <= 1) {
                    a11.remove("_eparam");
                } else {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            if ((jSONObject instanceof JSONObject) && a11.length() > 0) {
                JSONArray names = a11.names();
                for (int i11 = 0; i11 < names.length(); i11++) {
                    String string = names.getString(i11);
                    ((JSONObject) jSONObject).put(string, a11.get(string));
                    a11.remove(string);
                }
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            a11.put("_eparam", jSONObject);
            a11.put("net", com.transsion.athena.taaneh.aatnhe.b(this.f42775a));
            a11.put(NotificationCompat.CATEGORY_EVENT, track.getEventName());
            track.setJsonData(a11);
            track.setOriginJsonData(jSONObject2);
            track.setTrackFlag(c11.d());
            TidConfigBean a12 = com.transsion.athena.aethna.athena.c().a((int) track.getTid(), track.getEventName());
            if (a12 != null) {
                track.setTid(a12.getTid());
            }
        } catch (JSONException e11) {
            com.transsion.athena.taaneh.aethna.b("Convert to Track exception : %s", e11.getMessage());
        }
        return track;
    }

    public static enatha a(Context context) {
        if (f42778c == null) {
            synchronized (enatha.class) {
                try {
                    if (f42778c == null) {
                        f42778c = new enatha(context);
                    }
                } finally {
                }
            }
        }
        return f42778c;
    }

    private void a(int i11, String str) {
        com.transsion.athena.aethna.athena.c().a(i11);
        if (com.transsion.athena.data.anateh.aethna.a(this.f42775a) != null) {
            if (str == null) {
                com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(AppIdData.a(this.f42775a, i11));
                return;
            }
            com.transsion.athena.data.anateh.aethna a11 = com.transsion.athena.data.anateh.aethna.a(this.f42775a);
            AppIdData appIdData = new AppIdData();
            appIdData.f42696a = i11;
            appIdData.f42697b = str;
            a11.a(appIdData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, boolean z10) {
        com.transsion.athena.config.data.model.athena b11 = com.transsion.athena.aethna.athena.c().b(i11);
        if (b11 != null) {
            com.transsion.athena.taaneh.aethna.a("handleTidChange appconf : %s", b11.m());
            com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(b11, z10);
            String h11 = b11.h();
            if (!TextUtils.isEmpty(h11)) {
                if (GslbSdk.isInitSuccess(h11)) {
                    a(h11, i11, b11, this.f42787l);
                } else {
                    GslbSdk.init(this.f42775a, new String[]{h11}, new anateh(h11, i11, b11));
                }
                GslbSdk.getDomain(h11, new ehanat(this));
            }
            String c11 = b11.c();
            if (!TextUtils.isEmpty(c11)) {
                GslbSdk.init(this.f42775a, new String[]{c11}, new aatnhe(this));
                GslbSdk.getDomain(c11, (GslbSdk.ResultListener) null);
            }
        }
        if (z10) {
            List<TidConfigBean> j11 = b11.j();
            if (com.transsion.athena.config.data.model.anehat.a(j11)) {
                com.transsion.athena.taaneh.aethna.c("%s", "handleTidChange tid config is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (TidConfigBean tidConfigBean : j11) {
                if (tidConfigBean.getTidConfig().i() == -1) {
                    arrayList.add(Long.valueOf(tidConfigBean.getTid()));
                }
            }
            if (!arrayList.isEmpty()) {
                try {
                    com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(arrayList, this.f42780e, new com.transsion.athena.data.anateh.enatha() { // from class: com.transsion.athena.enatha.d
                        @Override // com.transsion.athena.data.anateh.enatha
                        public final void a(Object obj) {
                            enatha.a((String) obj);
                        }
                    });
                } catch (Exception e11) {
                    com.transsion.athena.taaneh.aethna.b("Handle tid change exception : %s", e11.getMessage());
                    a("handleTidChange", e11);
                }
            }
            AthenaAnalytics.I();
            if (com.transsion.athena.data.athena.b() == i11) {
                com.transsion.athena.config.data.model.ehanat.e(com.transsion.athena.aethna.athena.c().a(i11, "page_view", 1.0f) == 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.location.Location r13) {
        /*
            r12 = this;
            r0 = 0
            com.transsion.athena.data.TrackData r1 = new com.transsion.athena.data.TrackData
            r1.<init>()
            r2 = 1
            java.lang.String r3 = "lat"
            java.lang.String r4 = "lng"
            if (r13 == 0) goto L57
            double r5 = r13.getLongitude()
            java.math.BigDecimal r5 = java.math.BigDecimal.valueOf(r5)
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            r7 = 2
            java.math.BigDecimal r5 = r5.setScale(r7, r6)
            double r8 = r5.doubleValue()
            double r10 = r13.getLatitude()
            java.math.BigDecimal r13 = java.math.BigDecimal.valueOf(r10)
            java.math.BigDecimal r13 = r13.setScale(r7, r6)
            double r5 = r13.doubleValue()
            com.transsion.athena.data.TrackData r13 = r1.add(r4, r8)
            r13.add(r3, r5)
            com.transsion.athena.aethna.athena r13 = com.transsion.athena.aethna.athena.c()     // Catch: java.lang.Exception -> L4d
            int r13 = r13.b()     // Catch: java.lang.Exception -> L4d
            com.transsion.athena.aatnhe.aethna r13 = com.transsion.athena.aatnhe.aethna.a(r5, r8, r13)     // Catch: java.lang.Exception -> L4d
            java.lang.String r13 = r13.a()     // Catch: java.lang.Exception -> L4d
            java.lang.String r3 = "geono"
            r1.add(r3, r13)     // Catch: java.lang.Exception -> L4d
            goto L55
        L4d:
            r13 = move-exception
            java.lang.String r13 = android.util.Log.getStackTraceString(r13)
            com.transsion.athena.taaneh.aethna.b(r13)
        L55:
            r13 = r2
            goto L5f
        L57:
            com.transsion.athena.data.TrackData r13 = r1.add(r4, r0)
            r13.add(r3, r0)
            r13 = r0
        L5f:
            android.content.Context r3 = r12.f42775a
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r3 = com.transsion.athena.taaneh.anehat.a(r3, r4)
            if (r3 == 0) goto Lc5
            android.content.Context r3 = r12.f42775a
            java.util.List r3 = com.transsion.athena.taaneh.athena.c(r3)
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r3 = r3.iterator()
        L7a:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto Lb0
            java.lang.Object r5 = r3.next()
            com.transsion.athena.aatnhe.athena r5 = (com.transsion.athena.aatnhe.athena) r5
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> La1
            r6.<init>()     // Catch: org.json.JSONException -> La1
            java.lang.String r7 = "cellid"
            java.lang.String r8 = r5.a()     // Catch: org.json.JSONException -> La1
            org.json.JSONObject r6 = r6.put(r7, r8)     // Catch: org.json.JSONException -> La1
            java.lang.String r7 = "level"
            int r5 = r5.f42596e     // Catch: org.json.JSONException -> La1
            org.json.JSONObject r5 = r6.put(r7, r5)     // Catch: org.json.JSONException -> La1
            r4.put(r5)     // Catch: org.json.JSONException -> La1
            goto L7a
        La1:
            r5 = move-exception
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r0] = r5
            java.lang.String r5 = "%s"
            com.transsion.athena.taaneh.aethna.b(r5, r6)
            goto L7a
        Lb0:
            int r0 = r4.length()
            java.lang.String r3 = "cellidlist"
            if (r0 <= 0) goto Lc0
            java.lang.String r13 = r4.toString()
            r1.add(r3, r13)
            goto Lc6
        Lc0:
            java.lang.String r0 = ""
            r1.add(r3, r0)
        Lc5:
            r2 = r13
        Lc6:
            if (r2 == 0) goto Ld3
            r13 = 9999(0x270f, float:1.4012E-41)
            com.transsion.ga.AthenaAnalytics r0 = com.transsion.ga.AthenaAnalytics.K(r13)
            java.lang.String r2 = "location"
            r0.g0(r2, r1, r13)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.enatha.enatha.a(android.location.Location):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(SparseArray sparseArray) {
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            arrayList.add((com.transsion.athena.config.data.model.athena) sparseArray.valueAt(i11));
        }
        com.transsion.athena.aethna.athena.c().a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MMKV mmkv) {
        try {
            String[] a11 = mmkv.a();
            if (a11 != null && a11.length >= 1) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = new String[100];
                for (int i11 = 0; i11 < a11.length; i11++) {
                    TrackDataWrapper trackDataWrapper = (TrackDataWrapper) mmkv.i(a11[i11], TrackDataWrapper.class);
                    if (trackDataWrapper != null && arrayList.size() < 100) {
                        arrayList.add(a(trackDataWrapper));
                        strArr[i11] = a11[i11];
                    }
                }
                if (!arrayList.isEmpty()) {
                    a(arrayList);
                    mmkv.removeValuesForKeys(strArr);
                }
                if (mmkv.a() == null || mmkv.a().length <= 0) {
                    return;
                }
                a(mmkv);
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    private void a(Track track) {
        TidConfigBean a11;
        int a12 = com.transsion.athena.taaneh.anehat.a(track.getTid());
        if (!"".equals(this.f42786k.get(a12, null)) && "page_enter".equals(track.getEventName())) {
            try {
                String jSONObject = new JSONObject().put(NotificationCompat.CATEGORY_EVENT, track.getEventName()).put("ts", track.getTrackTs()).put("tid", track.getTid()).put("net", track.getJsonData().getInt("net")).put("eparam", track.getJsonData().getJSONObject("_eparam").toString()).toString();
                this.f42786k.put(a12, jSONObject);
                k4.a.a(this.f42775a).g("first_page_enter_" + a12, jSONObject);
                com.transsion.athena.taaneh.aethna.a("save [%d] fpe to sp : %s", Integer.valueOf(a12), jSONObject);
                return;
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b("saveFpeForAppId exception : %s", e11.getMessage());
            }
        }
        if (!com.transsion.athena.config.data.model.ehanat.r()) {
            com.transsion.athena.taaneh.aethna.c("%s", "Athena SDK Enable : [false]");
            return;
        }
        String jSONObject2 = track.getJsonData().toString();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(SafeStringUtils.SP_APPID, com.transsion.athena.taaneh.anehat.a(track.getTid()));
            jSONObject3.put(NotificationCompat.CATEGORY_EVENT, track.getEventName());
            jSONObject3.put("ts", track.getTrackTs());
            jSONObject3.put("params", track.getJsonData());
            com.transsion.athena.taaneh.aethna.c("track event:%s", jSONObject3.toString());
        } catch (Exception e12) {
            com.transsion.athena.taaneh.aethna.b("handleSaveData exception:%s", e12.getMessage());
        }
        if (jSONObject2.length() >= 716800) {
            com.transsion.athena.taaneh.aethna.b("track [%d]-[%s], save2DB failed due to eparam out of limit [%d]", Long.valueOf(track.getTid()), track.getEventName(), 716800);
            return;
        }
        if (c(track)) {
            if (track.getTid() > 9999) {
                a11 = com.transsion.athena.aethna.athena.c().b(track.getTid());
            } else {
                a11 = com.transsion.athena.aethna.athena.c().a((int) track.getTid(), track.getEventName());
                if (a11 != null) {
                    track.setTid(a11.getTid());
                }
            }
            boolean z10 = track.getTrackFlag() == 0 && a11 != null && a11.isCacheEnable();
            int j11 = com.transsion.athena.config.data.model.ehanat.j();
            if (j11 <= 0 || !z10) {
                a(track, a11);
                return;
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("tid", track.getTid());
                jSONObject4.put(NotificationCompat.CATEGORY_EVENT, track.getEventName());
                com.transsion.athena.taaneh.aethna.c("save event to memory:%s", jSONObject4.toString());
            } catch (Exception e13) {
                com.transsion.athena.taaneh.aethna.b("print saveTrack2Mem exception:%s", e13.getMessage());
            }
            if (this.f42784i == null) {
                this.f42784i = new ArrayList<>();
            }
            if (this.f42784i.size() >= j11 - 1) {
                this.f42784i.add(track);
                a(this.f42784i);
                this.f42785j = 0L;
                return;
            }
            long trackTs = track.getTrackTs();
            if (!a11.allowTrack(trackTs)) {
                com.transsion.athena.taaneh.aethna.c("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(track.getTid()), track.getEventName());
                return;
            }
            a11.setLastTTime(trackTs);
            this.f42784i.add(track);
            long j12 = this.f42785j;
            if (j12 == 0) {
                this.f42785j = trackTs;
            } else if (trackTs - j12 >= 600000) {
                a(this.f42784i);
                this.f42785j = 0L;
            }
        }
    }

    private void a(Track track, TidConfigBean tidConfigBean) {
        int a11;
        int a12 = track.getTid() > 9999 ? com.transsion.athena.aethna.athena.c().a(track.getTid(), track.getTrackData().b()) : com.transsion.athena.aethna.athena.c().a((int) track.getTid(), track.getEventName(), track.getTrackData().b());
        if (a12 != 0) {
            com.transsion.athena.taaneh.aethna.b("recordTrackFailed reason : %d", Integer.valueOf(a12));
            return;
        }
        if (tidConfigBean == null || tidConfigBean.allowTrack(track.getTrackTs())) {
            com.transsion.athena.ehatna.aethna.b().a(track);
            a11 = com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(track);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", track.getTid());
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, track.getEventName());
                jSONObject.put("ts", track.getTrackTs());
                jSONObject.put("db_count", a11);
                com.transsion.athena.taaneh.aethna.c("save event to DB:%s", jSONObject.toString());
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b("saveTrack2DB exception:%s", e11.getMessage());
            }
        } else {
            com.transsion.athena.taaneh.aethna.b("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(track.getTid()), track.getEventName());
            a11 = 0;
        }
        if (a11 == -1) {
            com.transsion.athena.taaneh.aethna.b("DB_UPDATE_ERROR");
        } else if (a11 == -2) {
            com.transsion.athena.taaneh.aethna.c("save [%d]-[%s] to DB failed due to DB_OUT_OF_MEMORY_ERROR", Long.valueOf(track.getTid()), track.getEventName());
            com.transsion.athena.taaneh.aethna.c("Clean up DB due to DB_OUT_OF_MEMORY_ERROR, Count [%d]", Integer.valueOf(com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(1000, new com.transsion.athena.data.anateh.enatha() { // from class: com.transsion.athena.enatha.b
                @Override // com.transsion.athena.data.anateh.enatha
                public final void a(Object obj) {
                    enatha.b((String) obj);
                }
            })));
        }
        if ("ev_athena".equals(track.getEventName())) {
            return;
        }
        if (a11 > 0) {
            if (tidConfigBean != null) {
                tidConfigBean.setLastTTime(track.getTrackTs());
                tidConfigBean.getTidConfig().a(a11);
            }
            if ("device".equals(track.getEventName()) && 9999 == com.transsion.athena.taaneh.anehat.a(track.getTid())) {
                com.transsion.athena.aethna.athena.c().k();
            }
        }
        a(false, this.f42781f);
    }

    static void a(enatha enathaVar) {
        if (!enathaVar.f42782g) {
            enathaVar.f42781f = com.transsion.athena.aethna.athena.c().g() * 1000;
        }
        enathaVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        i.a().c(new com.transsion.ga.anateh("cleanupEvents_off", bundle));
        com.transsion.athena.taaneh.aethna.c("handleTidChange cleanupList : %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i11, com.transsion.athena.config.data.model.athena athenaVar, String str2) {
        String domain = TextUtils.isEmpty(str) ? GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.o(), true) : GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.b(str), true);
        Bundle bundle = new Bundle();
        bundle.putInt("app_id", i11);
        bundle.putString("url", domain);
        bundle.putLong("ver", athenaVar.k());
        bundle.putString("gslb_data", str2);
        new yi.a("app_cfg_log", 9999).c(bundle, null).b();
    }

    private void a(String str, Throwable th2) {
        i.a().c(new com.transsion.ga.anateh(str, th2));
    }

    private void a(final List<Track> list) {
        ArrayList<Track> arrayList = new ArrayList<>();
        for (Track track : list) {
            if (com.transsion.athena.aethna.athena.c().a(track.getTid(), track.getTrackData().b()) == 0) {
                com.transsion.athena.ehatna.aethna.b().a(track);
                arrayList.add(track);
            }
        }
        if (arrayList.size() > 0) {
            int a11 = com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(arrayList, new com.transsion.athena.data.anateh.enatha() { // from class: com.transsion.athena.enatha.c
                @Override // com.transsion.athena.data.anateh.enatha
                public final void a(Object obj) {
                    enatha.a(list, (LongSparseArray) obj);
                }
            });
            com.transsion.athena.taaneh.aethna.c("saveMemCacheToDb Count = " + a11);
            if (a11 == -2) {
                com.transsion.athena.taaneh.aethna.b("saveToDB out of memory cleanCount = " + com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(1000, new C0606enatha(this)));
            }
            a(false, this.f42781f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list, LongSparseArray longSparseArray) {
        com.transsion.athena.taaneh.aethna.c("saveMemCacheToDb tidCountArray = " + longSparseArray);
        list.clear();
        for (int i11 = 0; i11 < longSparseArray.size(); i11++) {
            long keyAt = longSparseArray.keyAt(i11);
            TidConfigBean b11 = com.transsion.athena.aethna.athena.c().b(keyAt);
            if (b11 != null) {
                b11.getTidConfig().a(((Integer) longSparseArray.valueAt(i11)).intValue());
                if ("device".equals(b11.getEvent()) && 9999 == com.transsion.athena.taaneh.anehat.a(keyAt)) {
                    com.transsion.athena.aethna.athena.c().k();
                }
            }
        }
    }

    private void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.getString(str);
        } catch (JSONException unused) {
            jSONObject.put(str, obj);
        }
    }

    @SuppressLint({"MissingPermission"})
    private void a(boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        if ((z10 && TextUtils.isEmpty(com.transsion.athena.config.data.model.ehanat.m())) || Math.abs(currentTimeMillis - this.f42794s) < 3600000) {
            if (this.f42776b.hasMessages(502)) {
                return;
            }
            this.f42776b.sendMessageDelayed(this.f42776b.obtainMessage(502), 3600000L);
            return;
        }
        if (com.transsion.athena.aethna.athena.c().a(9999, RequestParameters.SUBRESOURCE_LOCATION, 1.0f) == 0) {
            if (com.transsion.athena.taaneh.anehat.a(this.f42775a, "android.permission.ACCESS_COARSE_LOCATION") || com.transsion.athena.taaneh.anehat.a(this.f42775a, "android.permission.ACCESS_FINE_LOCATION")) {
                LocationManager locationManager = (LocationManager) this.f42775a.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager == null) {
                    a((Location) null);
                    return;
                }
                String str = "network";
                if (!locationManager.isProviderEnabled("network")) {
                    str = "passive";
                    if (!locationManager.isProviderEnabled("passive")) {
                        str = "gps";
                        if (!locationManager.isProviderEnabled("gps")) {
                            str = null;
                        }
                    }
                }
                if (str != null) {
                    this.f42776b.removeCallbacks(this.f42795t);
                    this.f42776b.postDelayed(this.f42795t, 30000L);
                    locationManager.requestSingleUpdate(str, this.f42796u, (Looper) null);
                    this.f42794s = currentTimeMillis;
                }
                if (this.f42776b.hasMessages(502)) {
                    return;
                }
                this.f42776b.sendMessageDelayed(this.f42776b.obtainMessage(502), 3600000L);
            }
        }
    }

    private void a(boolean z10, long j11) {
        if (this.f42776b.hasMessages(298)) {
            return;
        }
        Message obtainMessage = this.f42776b.obtainMessage(298);
        if (z10) {
            obtainMessage.arg1 = 1;
            this.f42776b.sendMessage(obtainMessage);
        } else {
            obtainMessage.arg1 = 0;
            this.f42776b.sendMessageDelayed(obtainMessage, j11);
        }
    }

    private void b(Track track) {
        if (!com.transsion.athena.config.data.model.ehanat.r()) {
            com.transsion.athena.taaneh.aethna.c("Athena SDK isAthenaEnable = false");
            return;
        }
        if (c(track)) {
            int a11 = com.transsion.athena.taaneh.anehat.a(track.getTid());
            String str = "";
            if (this.f42786k.indexOfKey(a11) >= 0) {
                String str2 = this.f42786k.get(a11, "");
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        String string = jSONObject.has("eparam") ? jSONObject.getString("eparam") : "";
                        JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
                        Track track2 = new Track();
                        track2.setEventName(jSONObject.getString(NotificationCompat.CATEGORY_EVENT));
                        track2.setTid(jSONObject.getLong("tid"));
                        track2.setTrackTs(jSONObject.getLong("ts"));
                        track2.setTrackErTs(SystemClock.elapsedRealtime());
                        track2.setOriginJsonData(jSONObject2);
                        this.f42786k.put(a11, "");
                        k4.a.a(AthenaAnalytics.J()).g("first_page_enter_" + a11, "");
                        b(track2);
                    } catch (Exception unused) {
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(NotificationCompat.CATEGORY_EVENT, track.getEventName());
                jSONObject3.put("tid", track.getTid());
                jSONObject3.put(NativeComponentConstants.KEY_COMPONENT_TYPE, track.getTrackFlag());
                JSONObject originJsonData = track.getOriginJsonData();
                a(originJsonData, "_apkg", com.transsion.athena.taaneh.athena.h(this.f42775a));
                a(originJsonData, "_avn", com.transsion.athena.taaneh.athena.j(this.f42775a));
                a(originJsonData, "_avc", Integer.valueOf(com.transsion.athena.taaneh.athena.i(this.f42775a)));
                a(originJsonData, "_atutp", Short.valueOf(com.transsion.athena.config.data.model.ehanat.c()));
                String b11 = com.transsion.athena.config.data.model.ehanat.b();
                if (b11 != null) {
                    str = b11;
                }
                a(originJsonData, "_atuid", str);
                a(originJsonData, "_achannel", com.transsion.athena.config.data.model.ehanat.g());
                a(originJsonData, "_ainstallchnl", TextUtils.isEmpty(com.transsion.athena.taaneh.athena.e(this.f42775a)) ? " " : com.transsion.athena.taaneh.athena.e(this.f42775a));
                jSONObject3.put("_eparam", originJsonData);
            } catch (JSONException e11) {
                com.transsion.athena.taaneh.aethna.b("Track by DCS exception : ", e11.getMessage());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", jSONObject3.toString());
            this.f42775a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            com.transsion.athena.taaneh.aethna.c("track by DCS:%s", jSONObject3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        i.a().c(new com.transsion.ga.anateh("cleanupEvents_oom", bundle));
    }

    private boolean c(Track track) {
        if (!"app_launch".equals(track.getEventName())) {
            return true;
        }
        k4.a a11 = k4.a.a(this.f42775a);
        String str = "app_launch_" + com.transsion.athena.taaneh.anehat.a(track.getTid());
        int e11 = a11.e(str);
        if (e11 != 0 && Math.abs((track.getTrackTs() / 1000) - e11) <= 7200) {
            return false;
        }
        a11.b(str, Long.valueOf(track.getTrackTs() / 1000).intValue());
        return true;
    }

    private void f() {
        Cursor cursor = null;
        try {
            try {
                String h11 = com.transsion.athena.taaneh.athena.h(this.f42775a);
                cursor = this.f42775a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{h11}, null);
                if (cursor != null) {
                    boolean z10 = cursor.getCount() == 1;
                    this.f42790o = z10;
                    com.transsion.athena.taaneh.aethna.c("Pkg [%s] DCS authorize [%s]", h11, z10 ? OfflineConstantsKt.OFFLINE_CONFIG_ENABLE : "disable");
                } else {
                    com.transsion.athena.taaneh.aethna.c("Cursor is null, Pkg [%s] may not on the DCS white list", h11);
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b("Dcs applyForAccess exception : %s", e11.getMessage());
                if (0 == 0) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    private boolean g() {
        List<com.transsion.athena.config.data.model.athena> a11 = com.transsion.athena.aethna.athena.c().a();
        if (com.transsion.athena.config.data.model.anehat.a(a11)) {
            return false;
        }
        for (com.transsion.athena.config.data.model.athena athenaVar : a11) {
            if (athenaVar != null && athenaVar.a()) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        if (!com.transsion.athena.taaneh.aatnhe.c(this.f42775a)) {
            com.transsion.athena.taaneh.aethna.c("%s", "CheckConfig cancel, network is not available");
        } else if (GslbSdk.isInitSuccess(com.transsion.athena.config.data.model.ehanat.a(false))) {
            com.transsion.athena.aethna.athena.c().a(this.f42776b, this.f42792q);
        } else {
            com.transsion.athena.taaneh.aethna.c("%s", "CheckConfig cancel, GslbSdk is not inited");
        }
    }

    private void i() {
        if (!com.transsion.athena.taaneh.aatnhe.c(this.f42775a)) {
            com.transsion.athena.taaneh.aethna.a("%s", "checkUpload network unavailable");
            return;
        }
        if (com.transsion.athena.ehatna.aethna.b().f()) {
            if (com.transsion.athena.ehatna.aethna.b().e()) {
                return;
            }
            com.transsion.athena.taaneh.aethna.a("%s", "checkUpload sync baseTime");
            com.transsion.athena.ehatna.aethna.b().a(true);
            com.transsion.athena.hatnea.athena.a().a(new atnhae(this.f42776b));
            return;
        }
        if (!com.transsion.athena.config.data.model.ehanat.r()) {
            com.transsion.athena.taaneh.aethna.a("%s", "checkUpload sdk disable or gaid invalid");
            String i11 = k4.a.a(this.f42775a).i("gdpr_close");
            if (TextUtils.isEmpty(i11)) {
                return;
            }
            com.transsion.athena.hatnea.athena.a().a(new com.transsion.athena.hatnea.aethna(this.f42776b, i11));
            return;
        }
        if (!GslbSdk.isInitSuccess(com.transsion.athena.config.data.model.ehanat.o())) {
            com.transsion.athena.taaneh.aethna.a("%s", "checkUpload GSLB is not ready");
            return;
        }
        if (com.transsion.athena.config.data.model.anehat.a(com.transsion.athena.aethna.athena.c().d())) {
            com.transsion.athena.taaneh.aethna.a("%s", "checkUpload global config is not ready");
            return;
        }
        List<AppIdData> c11 = com.transsion.athena.data.anateh.aethna.a(this.f42775a).c();
        if (com.transsion.athena.config.data.model.anehat.a(c11)) {
            List<com.transsion.athena.config.data.model.athena> a11 = com.transsion.athena.aethna.athena.c().a();
            if (com.transsion.athena.config.data.model.anehat.a(a11)) {
                com.transsion.athena.taaneh.aethna.a("%s", "checkUpload appid config list is null");
                return;
            }
            Iterator<com.transsion.athena.config.data.model.athena> it = a11.iterator();
            while (it.hasNext()) {
                AppIdData a12 = AppIdData.a(this.f42775a, it.next().b());
                if (c11 == null) {
                    c11 = new ArrayList<>();
                }
                c11.add(a12);
                com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(a12);
            }
        }
        HashSet hashSet = new HashSet();
        for (AppIdData appIdData : c11) {
            com.transsion.athena.config.data.model.athena b11 = com.transsion.athena.aethna.athena.c().b(appIdData.f42696a);
            if (b11 != null) {
                String domain = TextUtils.isEmpty(b11.h()) ? GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.o(), true) : GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.b(b11.h()), true);
                appIdData.f42701f = domain;
                hashSet.add(domain);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            com.transsion.athena.hatnea.athena.a().a(new com.transsion.athena.hatnea.hatnea(this.f42776b, (String) it2.next(), c11, this.f42780e, this.f42786k));
        }
    }

    private void j() {
        this.f42789n = System.currentTimeMillis();
        this.f42788m = com.transsion.athena.taaneh.aatnhe.c(this.f42775a);
        com.transsion.athena.ehatna.aethna.b().d();
        com.transsion.athena.aethna.athena.c().h();
        com.transsion.athena.data.anateh.aethna.a(this.f42775a).a(new com.transsion.athena.data.anateh.enatha() { // from class: com.transsion.athena.enatha.a
            @Override // com.transsion.athena.data.anateh.enatha
            public final void a(Object obj) {
                enatha.a((SparseArray) obj);
            }
        });
        AthenaAnalytics.I();
        int b11 = com.transsion.athena.data.athena.b();
        if (b11 != 0) {
            com.transsion.athena.config.data.model.ehanat.e(com.transsion.athena.aethna.athena.c().a(b11, "page_view", 1.0f) == 0);
        }
        if (com.transsion.athena.taaneh.anehat.c(this.f42775a) && g() && com.transsion.athena.config.data.model.ehanat.r()) {
            com.transsion.athena.taaneh.aethna.c("%s", "Dcs available");
            f();
        } else {
            com.transsion.athena.taaneh.aethna.c("%s", "Dcs unavailable because of not support or conf disable");
        }
        GslbSdk.init(this.f42775a, com.transsion.athena.anehat.athena.f42615a, new aethna());
        Handler handler = this.f42776b;
        handler.postDelayed(new com.transsion.athena.enatha.anehat(handler), 7200000L);
        if (AthenaAnalytics.V()) {
            this.f42776b.post(this.f42793r);
        }
        try {
            k4.a a11 = k4.a.a(this.f42775a);
            Iterator<Integer> it = com.transsion.athena.data.athena.a().iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                String str = "first_page_enter_" + next;
                if (a11.d(str)) {
                    this.f42786k.put(next.intValue(), a11.i(str));
                }
            }
            File filesDir = this.f42775a.getFilesDir();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(filesDir);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(com.transsion.athena.config.data.model.ehanat.f42664k);
            File file = new File(sb2.toString());
            File file2 = new File(filesDir + str2 + com.transsion.athena.config.data.model.ehanat.f42665l);
            if (AthenaAnalytics.S()) {
                this.f42780e = true;
            } else if (file.exists()) {
                String[] list = file.list();
                if (list != null && list.length != 0) {
                    this.f42780e = true;
                }
                if (file.delete()) {
                    com.transsion.athena.taaneh.aethna.a("%s", "dataFile deleted");
                }
            }
            if (file2.exists()) {
                com.transsion.athena.taaneh.athena.a(this.f42775a, file2.getPath());
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.a("%s", e11.getMessage());
            a("handleInit", e11);
        }
        Message obtainMessage = this.f42776b.obtainMessage(502);
        obtainMessage.arg1 = 1;
        this.f42776b.sendMessageDelayed(obtainMessage, 3000L);
        if (this.f42782g) {
            return;
        }
        this.f42781f = com.transsion.athena.aethna.athena.c().g() * 1000;
    }

    @Override // com.transsion.athena.enatha.athena
    public void a() {
        Handler handler = this.f42776b;
        if (handler != null) {
            this.f42776b.sendMessageAtFrontOfQueue(handler.obtainMessage(308));
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(int i11) {
        this.f42781f = Math.max(i11, 2000);
        this.f42782g = true;
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Message message, long j11) {
        Handler handler = this.f42776b;
        if (handler != null) {
            if (j11 > 0) {
                handler.removeMessages(message.what);
            }
            this.f42776b.sendMessageDelayed(message, j11);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Runnable runnable) {
        Handler handler = this.f42776b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Runnable runnable, long j11) {
        Handler handler = this.f42776b;
        if (handler != null) {
            handler.postDelayed(runnable, j11);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(String str, TrackData trackData, long j11) {
        Track track = new Track();
        track.setEventName(str);
        track.setTid(j11);
        track.setTrackTs(System.currentTimeMillis());
        track.setTrackErTs(SystemClock.elapsedRealtime());
        track.setTrackData(trackData);
        int i11 = this.f42783h;
        if (i11 < 5000) {
            this.f42783h = i11 + 1;
            Message obtainMessage = this.f42776b.obtainMessage(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE);
            obtainMessage.obj = track;
            this.f42776b.sendMessage(obtainMessage);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public boolean c() {
        return !this.f42779d;
    }

    @Override // com.transsion.athena.enatha.athena
    public void d() {
        Handler handler = this.f42776b;
        if (handler != null) {
            this.f42776b.sendMessageAtFrontOfQueue(handler.obtainMessage(504));
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void e() {
        a(true, this.f42781f);
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x029d  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleMessage(android.os.Message r14) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.enatha.enatha.handleMessage(android.os.Message):boolean");
    }
}
