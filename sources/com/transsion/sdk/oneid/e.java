package com.transsion.sdk.oneid;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.gslb.GslbSdk;
import com.transsion.sdk.oneid.data.AppIdInfo;
import com.transsion.sdk.oneid.data.GroupFpInfo;
import com.transsion.sdk.oneid.data.GroupHashInfo;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import com.transsion.sdk.oneid.data.OdIdInfo;
import com.transsion.sdk.oneid.data.UniqueIdInfo;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import n00.g;
import n00.h;
import n00.i;
import n00.j;
import n00.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e implements Handler.Callback {

    /* renamed from: n, reason: collision with root package name */
    private static volatile e f51976n;

    /* renamed from: a, reason: collision with root package name */
    private Handler f51977a;

    /* renamed from: c, reason: collision with root package name */
    private GroupFpInfo f51979c;

    /* renamed from: d, reason: collision with root package name */
    private GroupHashInfo f51980d;

    /* renamed from: g, reason: collision with root package name */
    private c f51983g;

    /* renamed from: j, reason: collision with root package name */
    private final Context f51986j;

    /* renamed from: k, reason: collision with root package name */
    private OdIdInfo f51987k;

    /* renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap f51988l;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f51978b = null;

    /* renamed from: e, reason: collision with root package name */
    private long f51981e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f51982f = 0;

    /* renamed from: i, reason: collision with root package name */
    private final ReentrantLock f51985i = new ReentrantLock();

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f51989m = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private final List f51984h = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        a(e eVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        b(e eVar) {
        }
    }

    private e(Context context) {
        this.f51986j = context;
        j();
        Handler handler = this.f51977a;
        if (handler != null) {
            handler.sendEmptyMessage(200);
        }
    }

    public static e a(Context context) {
        if (f51976n == null) {
            synchronized (e.class) {
                try {
                    if (f51976n == null) {
                        f51976n = new e(context);
                    }
                } finally {
                }
            }
        }
        return f51976n;
    }

    private void c(int i11, AppIdInfo appIdInfo) {
        if (com.transsion.sdk.oneid.b.q(this.f51986j)) {
            com.transsion.sdk.oneid.b.i("onOdidRequestRetry");
            appIdInfo.retryTimes++;
            long j11 = appIdInfo.retryRequestDelay;
            if (j11 == 0) {
                appIdInfo.retryRequestDelay = 3000L;
            } else {
                appIdInfo.retryRequestDelay = Math.min((j11 * 2) + 1000, 600000L);
            }
            Message obtain = Message.obtain(this.f51977a, 303);
            obtain.obj = appIdInfo;
            obtain.arg1 = i11;
            this.f51977a.sendMessageDelayed(obtain, appIdInfo.retryRequestDelay);
        }
    }

    private void d(Message message) {
        if (com.transsion.sdk.oneid.b.q(this.f51986j)) {
            long j11 = this.f51981e;
            if (j11 == 0) {
                this.f51981e = 3000L;
            } else {
                this.f51981e = Math.min((j11 * 2) + 1000, 600000L);
            }
            this.f51977a.sendMessageDelayed(message, this.f51981e);
        }
    }

    private void f(String str) {
        com.transsion.sdk.oneid.b.i("onFpPostComplete");
        this.f51982f = System.currentTimeMillis();
        try {
            n00.b b11 = n00.b.b(this.f51986j);
            b11.c("last_post_time", Long.valueOf(this.f51982f / 1000).intValue());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b11.d("fp_hash", str);
        } catch (Exception e11) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e11));
        }
    }

    private void g(String str, int i11, AppIdInfo appIdInfo) {
        com.transsion.sdk.oneid.b.i("onOdidRequestComplete appId : " + i11);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("code", 0);
            String optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            long optLong = jSONObject.optLong(EventConstants.KEY_TIME, 0L);
            appIdInfo.odid = jSONObject.optString("odid", "");
            appIdInfo.retryTimes = 0;
            appIdInfo.retryRequestDelay = 0L;
            appIdInfo.lastRequestTime = System.currentTimeMillis();
            long j11 = optLong * 1000;
            appIdInfo.waitTime = j11;
            appIdInfo.msg = optString;
            n00.b b11 = n00.b.b(this.f51986j);
            String json = new Gson().toJson(this.f51988l, new b(this).getType());
            com.transsion.sdk.oneid.b.i("appIdInfoListJson : " + json);
            b11.g("appid_info_list", json);
            Message obtain = Message.obtain(this.f51977a, 303);
            obtain.obj = appIdInfo;
            obtain.arg1 = i11;
            this.f51977a.sendMessageDelayed(obtain, j11);
        } catch (Exception e11) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e11));
        }
    }

    private void j() {
        Handler handler;
        if (this.f51985i.tryLock()) {
            try {
                try {
                    handler = this.f51977a;
                } catch (Exception e11) {
                    com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e11));
                }
                if (handler != null && this.f51978b != null) {
                    if (handler.hasMessages(201)) {
                        this.f51977a.removeMessages(201);
                    }
                    this.f51985i.unlock();
                }
                HandlerThread handlerThread = new HandlerThread("OneID Worker", 10);
                this.f51978b = handlerThread;
                handlerThread.start();
                this.f51977a = new Handler(this.f51978b.getLooper(), this);
                this.f51985i.unlock();
            } catch (Throwable th2) {
                this.f51985i.unlock();
                throw th2;
            }
        }
    }

    private void k() {
        ConcurrentHashMap concurrentHashMap = this.f51988l;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            String h11 = n00.b.b(this.f51986j).h("appid_info_list");
            if (!TextUtils.isEmpty(h11)) {
                com.transsion.sdk.oneid.b.i("AppId Records : " + h11);
                try {
                    this.f51988l = (ConcurrentHashMap) new Gson().fromJson(h11, new a(this).getType());
                } catch (Exception e11) {
                    com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e11));
                }
            }
            if (this.f51988l == null) {
                this.f51988l = new ConcurrentHashMap();
            }
        }
    }

    public void b(int i11) {
        com.transsion.sdk.oneid.b.i("Check appId record : " + i11);
        HandlerThread handlerThread = this.f51978b;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        Message obtain = Message.obtain(this.f51977a, Sdk$SDKError.Reason.AD_EXPIRED_VALUE);
        obtain.obj = Integer.valueOf(i11);
        if (this.f51989m.get()) {
            this.f51977a.sendMessage(obtain);
        } else {
            this.f51977a.sendMessageDelayed(obtain, OneID.f51962d * 1000);
        }
    }

    public void e(IdChangeInfo idChangeInfo) {
        IdChangeInfo idChangeInfo2;
        com.transsion.sdk.oneid.b.i("onFpIdChanged type = " + idChangeInfo.id_type);
        List list = this.f51984h;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    idChangeInfo2 = null;
                    break;
                } else {
                    idChangeInfo2 = (IdChangeInfo) it.next();
                    if (idChangeInfo2.id_type.equals(idChangeInfo.id_type)) {
                        break;
                    }
                }
            }
            if (idChangeInfo2 != null) {
                this.f51984h.remove(idChangeInfo2);
            }
            this.f51984h.add(idChangeInfo);
        }
    }

    public String h() {
        try {
            GroupFpInfo groupFpInfo = this.f51979c;
            return groupFpInfo != null ? groupFpInfo.vaid : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x002a. Please report as an issue. */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i11;
        GroupFpInfo groupFpInfo;
        int i12;
        long j11;
        String str;
        try {
            i11 = message.what;
        } catch (Exception e11) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e11));
        }
        if (i11 == 100) {
            com.transsion.sdk.oneid.b.i("-->WHAT_GET_PROP_RET");
            String string = message.getData().getString("oneid");
            if (!TextUtils.isEmpty(string) && !TextUtils.equals(string, NetworkUtil.NETWORK_TYPE_UNKNOWN) && (groupFpInfo = this.f51979c) != null) {
                if (TextUtils.isEmpty(groupFpInfo.dids.tsid)) {
                    UniqueIdInfo uniqueIdInfo = this.f51979c.dids;
                    uniqueIdInfo.tsid = string;
                    this.f51980d.updateDidsHash(uniqueIdInfo);
                    this.f51987k.tsid = string;
                    n00.b b11 = n00.b.b(this.f51986j);
                    int intValue = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
                    try {
                        b11.d("oneid", string);
                        b11.c("oneid_time", intValue);
                    } catch (Exception e12) {
                        com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e12));
                    }
                } else if (!TextUtils.equals(this.f51979c.dids.tsid, string)) {
                    e(new IdChangeInfo("tsid", this.f51979c.dids.tsid, string));
                    UniqueIdInfo uniqueIdInfo2 = this.f51979c.dids;
                    uniqueIdInfo2.tsid = string;
                    this.f51980d.updateDidsHash(uniqueIdInfo2);
                    this.f51987k.tsid = string;
                }
            }
            return false;
        }
        if (i11 == 200) {
            com.transsion.sdk.oneid.b.o();
            if (TextUtils.isEmpty(n00.b.b(this.f51986j).h("one_id_first_launch")) && OneID.f51962d > 0) {
                com.transsion.sdk.oneid.b.i("First launch delay " + OneID.f51962d + " sec init");
                try {
                    Thread.sleep(OneID.f51962d * 1000);
                } catch (InterruptedException unused) {
                }
                n00.b.b(this.f51986j).g("one_id_first_launch", String.valueOf(System.currentTimeMillis()));
            }
            com.transsion.sdk.oneid.b.i("-->WHAT_INIT 2.0.2.1");
            String string2 = this.f51986j.getResources().getString(R$string.oneid_process_name);
            if (TextUtils.isEmpty(string2)) {
                string2 = this.f51986j.getPackageName();
            }
            if (!TextUtils.equals(string2, com.transsion.sdk.oneid.b.k(this.f51986j))) {
                com.transsion.sdk.oneid.b.i("Only works in the main process");
                this.f51977a.sendEmptyMessageDelayed(201, 1000L);
                return false;
            }
            try {
                if (this.f51983g == null) {
                    this.f51983g = new c();
                    this.f51986j.registerReceiver(this.f51983g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, this.f51977a);
                }
            } catch (Exception e13) {
                com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e13));
            }
            GslbSdk.init(this.f51986j, new String[]{"ire-oneid.shalltry.com", "oneid-dev-sg.shalltry.com"}, (GslbSdk.InitListener) null);
            GroupFpInfo groupFpInfo2 = new GroupFpInfo(this.f51986j, this);
            this.f51979c = groupFpInfo2;
            this.f51980d = new GroupHashInfo(groupFpInfo2);
            this.f51987k = new OdIdInfo(this.f51979c);
            com.transsion.sdk.oneid.b.i("--> new OdidInfo " + this.f51987k);
            if (this.f51982f == 0) {
                this.f51982f = n00.b.b(this.f51986j).a("last_post_time") * 1000;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j12 = this.f51982f;
            if (currentTimeMillis >= j12 && currentTimeMillis - j12 < 86400000) {
                com.transsion.sdk.oneid.b.i("Post time not yet reached");
                this.f51989m.set(true);
                return false;
            }
            if (!this.f51977a.hasMessages(300)) {
                Handler handler = this.f51977a;
                if (GslbSdk.isInitSuccess(l.d().c())) {
                    i12 = 300;
                    j11 = 3000;
                } else {
                    i12 = 300;
                    j11 = 6000;
                }
                handler.sendEmptyMessageDelayed(i12, j11);
            }
            this.f51989m.set(true);
            return false;
        }
        if (i11 == 201) {
            com.transsion.sdk.oneid.b.i("-->WHAT_QUIT");
            if (this.f51985i.tryLock()) {
                try {
                    HandlerThread handlerThread = this.f51978b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.f51978b = null;
                    }
                    this.f51985i.unlock();
                } catch (Throwable th2) {
                    this.f51985i.unlock();
                    throw th2;
                }
            }
            return false;
        }
        switch (i11) {
            case 300:
                com.transsion.sdk.oneid.b.i("-->WHAT_POST_FP_HASH");
                this.f51977a.removeMessages(300);
                if (OneID.f51961c && com.transsion.sdk.oneid.b.p(this.f51986j)) {
                    if (!GslbSdk.isInitSuccess(l.d().c())) {
                        com.transsion.sdk.oneid.b.i("GslbSdk new domain is not ready");
                        d(Message.obtain(this.f51977a, 300));
                        return false;
                    }
                    try {
                        str = n00.b.b(this.f51986j).f("fp_hash");
                    } catch (Exception unused2) {
                        str = "";
                    }
                    String g11 = com.transsion.sdk.oneid.b.g(this.f51980d.toString());
                    com.transsion.sdk.oneid.b.i(str + " vs " + g11);
                    if (TextUtils.equals(str, g11)) {
                        f(null);
                    } else {
                        Message.obtain(this.f51977a, Sdk$SDKError.Reason.MRAID_ERROR_VALUE, g11).sendToTarget();
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.f51981e = 0L;
                this.f51977a.sendEmptyMessage(201);
                return false;
            case MRAID_ERROR_VALUE:
                com.transsion.sdk.oneid.b.i("-->WHAT_POST_FP_DATA");
                this.f51977a.removeMessages(Sdk$SDKError.Reason.MRAID_ERROR_VALUE);
                if (OneID.f51961c && com.transsion.sdk.oneid.b.p(this.f51986j)) {
                    String str2 = (String) message.obj;
                    i a11 = new g(this.f51979c).a();
                    com.transsion.sdk.oneid.b.i("code = " + a11.f70201a + " data = " + ((String) a11.f70202b));
                    int i13 = a11.f70201a;
                    if (i13 == 0) {
                        this.f51981e = 0L;
                        try {
                            if (new JSONObject((String) a11.f70202b).optInt("code", 0) == 0) {
                                if (this.f51984h.isEmpty()) {
                                    f(str2);
                                } else {
                                    Message.obtain(this.f51977a, Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE, str2).sendToTarget();
                                }
                            }
                        } catch (Exception e14) {
                            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e14));
                        }
                    } else if (i13 != 4) {
                        d(Message.obtain(this.f51977a, Sdk$SDKError.Reason.MRAID_ERROR_VALUE, str2));
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.f51981e = 0L;
                this.f51977a.sendEmptyMessage(201);
                return false;
            case INVALID_IFA_STATUS_VALUE:
                com.transsion.sdk.oneid.b.i("-->WHAT_POST_ID_CHANGE");
                this.f51977a.removeMessages(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE);
                String str3 = (String) message.obj;
                ArrayList arrayList = new ArrayList();
                for (IdChangeInfo idChangeInfo : this.f51984h) {
                    if (!TextUtils.isEmpty(idChangeInfo.pre_id)) {
                        arrayList.add(idChangeInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    try {
                        i a12 = new h(arrayList).a();
                        com.transsion.sdk.oneid.b.i("code = " + a12.f70201a + " data = " + ((String) a12.f70202b));
                        int i14 = a12.f70201a;
                        if (i14 == 0) {
                            this.f51981e = 0L;
                            try {
                                if (new JSONObject((String) a12.f70202b).optInt("code", 0) == 0) {
                                    com.transsion.sdk.oneid.b.h(this.f51986j, this.f51984h);
                                    this.f51984h.clear();
                                    f(str3);
                                }
                            } catch (Exception e15) {
                                com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e15));
                            }
                        } else if (i14 != 4) {
                            d(Message.obtain(this.f51977a, Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE, str3));
                        }
                    } catch (Exception e16) {
                        com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e16));
                    }
                } else {
                    if (this.f51984h.size() > 0) {
                        com.transsion.sdk.oneid.b.h(this.f51986j, this.f51984h);
                        this.f51984h.clear();
                    }
                    f(str3);
                }
                return false;
            case 303:
                com.transsion.sdk.oneid.b.i("-->WHAT_REQUEST_ODID");
                int i15 = message.arg1;
                AppIdInfo appIdInfo = (AppIdInfo) message.obj;
                this.f51977a.removeMessages(303, appIdInfo);
                if (OneID.f51961c && com.transsion.sdk.oneid.b.p(this.f51986j)) {
                    OdIdInfo odIdInfo = this.f51987k;
                    if (odIdInfo != null) {
                        odIdInfo.appid = i15;
                        com.transsion.sdk.oneid.b.i("--> mOdidInfo set appID :" + this.f51987k.toString());
                        i a13 = new j(this.f51987k).a();
                        com.transsion.sdk.oneid.b.i("code = " + a13.f70201a + " data = " + ((String) a13.f70202b));
                        int i16 = a13.f70201a;
                        if (i16 == 0) {
                            g((String) a13.f70202b, i15, appIdInfo);
                        } else if (i16 == 3) {
                            com.transsion.sdk.oneid.b.i("onOdidRequestGatewayError");
                            Message obtain = Message.obtain(this.f51977a, 303);
                            obtain.obj = appIdInfo;
                            obtain.arg1 = i15;
                            this.f51977a.sendMessageDelayed(obtain, 1000L);
                        } else if (i16 != 4) {
                            c(i15, appIdInfo);
                        }
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.f51977a.sendEmptyMessage(201);
                return false;
            case AD_EXPIRED_VALUE:
                Integer num = (Integer) message.obj;
                int intValue2 = num.intValue();
                this.f51977a.removeMessages(Sdk$SDKError.Reason.AD_EXPIRED_VALUE, num);
                if (OneID.f51961c && com.transsion.sdk.oneid.b.p(this.f51986j)) {
                    k();
                    AppIdInfo appIdInfo2 = (AppIdInfo) this.f51988l.get(num);
                    if (appIdInfo2 == null) {
                        appIdInfo2 = new AppIdInfo();
                        this.f51988l.put(num, appIdInfo2);
                        OdIdInfo odIdInfo2 = this.f51987k;
                        if (odIdInfo2 != null) {
                            odIdInfo2.appid = intValue2;
                        }
                    }
                    Message obtain2 = Message.obtain(this.f51977a, 303);
                    obtain2.arg1 = intValue2;
                    obtain2.obj = appIdInfo2;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j13 = GslbSdk.isInitSuccess(l.d().c()) ? 3000L : 6000L;
                    long j14 = appIdInfo2.lastRequestTime;
                    if (currentTimeMillis2 >= j14) {
                        long j15 = currentTimeMillis2 - j14;
                        long j16 = appIdInfo2.waitTime;
                        if (j15 < j16) {
                            j13 = Math.max((j14 + j16) - currentTimeMillis2, j13);
                        }
                    }
                    if (!this.f51977a.hasMessages(303, appIdInfo2)) {
                        this.f51977a.sendMessageDelayed(obtain2, j13);
                        com.transsion.sdk.oneid.b.i("Appid : " + intValue2 + " delay " + j13 + " ms refresh odid ");
                    }
                    return false;
                }
                com.transsion.sdk.oneid.b.i("OneID disable or network unavailable");
                this.f51977a.sendEmptyMessage(201);
                return false;
            default:
                return false;
        }
        com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e11));
        return false;
    }

    public String i(int i11) {
        AppIdInfo appIdInfo;
        String str;
        ConcurrentHashMap concurrentHashMap = this.f51988l;
        return (concurrentHashMap == null || (appIdInfo = (AppIdInfo) concurrentHashMap.get(Integer.valueOf(i11))) == null || (str = appIdInfo.odid) == null) ? "" : str;
    }

    public void l() {
        if (com.transsion.sdk.oneid.b.q(this.f51986j)) {
            com.transsion.sdk.oneid.b.i("retry");
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = OneID.f51961c;
            if (z10) {
                long j11 = this.f51982f;
                if (currentTimeMillis < j11 || currentTimeMillis - j11 >= 86400000) {
                    if (this.f51985i.tryLock()) {
                        try {
                            if (this.f51978b == null) {
                                j();
                            }
                        } finally {
                            this.f51985i.unlock();
                        }
                    }
                    Handler handler = this.f51977a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.f51977a.sendEmptyMessage(200);
                        return;
                    }
                    return;
                }
            }
            com.transsion.sdk.oneid.b.i(z10 ? "Post time not yet reached" : "OneID disable");
        }
    }
}
