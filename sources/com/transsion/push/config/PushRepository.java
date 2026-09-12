package com.transsion.push.config;

import android.text.TextUtils;
import android.util.Base64;
import com.transsion.core.utils.f;
import com.transsion.crypto.TCrypterSdk;
import com.transsion.gslb.GslbSdk;
import com.transsion.json.b;
import com.transsion.push.IClientIdListener;
import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.bean.SelfDestroyInfo;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.FirebaseUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.ThreadManager;
import com.transsion.push.utils.v;
import com.transsion.push.utils.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class PushRepository implements IDataSource {

    /* renamed from: e, reason: collision with root package name */
    private static PushRepository f50848e = null;

    /* renamed from: f, reason: collision with root package name */
    private static long f50849f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static long f50850g = -1;

    /* renamed from: a, reason: collision with root package name */
    private f f50851a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.push.config.a f50852b;

    /* renamed from: c, reason: collision with root package name */
    private ConfigInfo.Config f50853c;

    /* renamed from: d, reason: collision with root package name */
    private String f50854d;

    /* loaded from: classes6.dex */
    class a implements FirebaseUtils.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IClientIdListener f50858a;

        a(IClientIdListener iClientIdListener) {
            this.f50858a = iClientIdListener;
        }

        @Override // com.transsion.push.utils.FirebaseUtils.b
        public void onFail() {
            IClientIdListener iClientIdListener = this.f50858a;
            if (iClientIdListener != null) {
                iClientIdListener.onFail("get token fail");
            }
        }

        @Override // com.transsion.push.utils.FirebaseUtils.b
        public void onSuccess() {
            PushRepository.this.d(this.f50858a);
        }
    }

    private PushRepository() {
        try {
            this.f50851a = f.e(PushConstants.SP_FILENAME);
        } catch (Exception unused) {
        }
        this.f50852b = new com.transsion.push.config.a();
    }

    private void c() {
        int intValue = ((Integer) getSpValue(PushConstants.SP_KEY_RETRY_COUNT, 0)).intValue();
        int c11 = v.c();
        PushLogUtils.LOG.g("Reporting Failure, Retry Reporting,retryCount：" + intValue + ", max retryCount：" + c11);
        if (intValue < c11) {
            putSpValue(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(intValue + 1));
            saveReportTime(System.currentTimeMillis() + v.d());
        } else {
            PushLogUtils.LOG.g("More than the maximum number of retries");
            saveReportTime(System.currentTimeMillis() + v.b());
            putSpValue(PushConstants.SP_KEY_RETRY_COUNT, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final IClientIdListener iClientIdListener) {
        if (this.f50852b != null) {
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.config.PushRepository.4
                @Override // java.lang.Runnable
                public void run() {
                    ConfigInfo.Whitelist whitelist;
                    ConfigInfo.Config config;
                    ConfigInfo f11 = PushRepository.this.f50852b.f();
                    if (f11 == null) {
                        IClientIdListener iClientIdListener2 = iClientIdListener;
                        if (iClientIdListener2 != null) {
                            iClientIdListener2.onFail("get client id fail");
                        }
                        PushLogUtils.LOG.g("get client id fail");
                        return;
                    }
                    PushLogUtils.LOG.g("get config response data: " + f11.toString());
                    PushRepository.this.putSpValue(PushConstants.SP_KEY_IS_NEXT_WITH_APP, Boolean.valueOf(f11.nextWithApp));
                    PushRepository.this.putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.valueOf(f11.nextWithDetail));
                    PushRepository.this.putSpValue(PushConstants.SP_KEY_CLIENT_ID, f11.clientId);
                    z.f(f11.destroyAppIds, f11.syncInfoInterval);
                    if (f11.configRefresh && (config = f11.config) != null && config.version > 0) {
                        PushRepository.this.saveConfig(config);
                        PushRepository.this.putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(f11.config.destroy));
                    }
                    if (f11.whitelistRefresh && (whitelist = f11.whitelist) != null && whitelist.version > 0) {
                        PushRepository.this.saveWhiteList(whitelist);
                    }
                    IClientIdListener iClientIdListener3 = iClientIdListener;
                    if (iClientIdListener3 != null) {
                        iClientIdListener3.onSuccess(f11.clientId);
                    }
                }
            });
            return;
        }
        if (iClientIdListener != null) {
            iClientIdListener.onFail("mRemoteDataSource is null");
        }
        PushLogUtils.LOG.z("mRemoteDataSource is null");
    }

    public static synchronized PushRepository getInstance() {
        PushRepository pushRepository;
        synchronized (PushRepository.class) {
            try {
                if (f50848e == null) {
                    f50848e = new PushRepository();
                }
                pushRepository = f50848e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return pushRepository;
    }

    @Override // com.transsion.push.config.IDataSource
    public void getClientId(IClientIdListener iClientIdListener) {
        PushLogUtils.LOG.g("get client id");
        String str = (String) getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        if (!TextUtils.isEmpty(str) && iClientIdListener != null) {
            iClientIdListener.onSuccess(str);
        } else if (TextUtils.isEmpty((CharSequence) getSpValue(PushConstants.SP_KEY_FCM_TOKEN, ""))) {
            FirebaseUtils.d(new a(iClientIdListener));
        } else {
            d(iClientIdListener);
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public ConfigInfo.Config getConfig() {
        ConfigInfo.Config config = this.f50853c;
        if (config != null) {
            return config;
        }
        f fVar = this.f50851a;
        if (fVar == null) {
            return null;
        }
        String j11 = fVar.j(PushConstants.SP_KEY_CONFIG, null);
        if (TextUtils.isEmpty(j11)) {
            return null;
        }
        try {
            return (ConfigInfo.Config) b.a(new String(Base64.decode(j11, 0)), ConfigInfo.Config.class);
        } catch (Exception e11) {
            PushLogUtils.LOG.i("get config fail, e:" + e11.getMessage());
            return null;
        }
    }

    public long getLastTpmsReportTime() {
        long currentTimeMillis = System.currentTimeMillis() - 1;
        long j11 = f50850g;
        if (j11 > 0) {
            return j11;
        }
        f fVar = this.f50851a;
        if (fVar == null) {
            return currentTimeMillis;
        }
        f50850g = fVar.h(PushConstants.SP_KEY_REPORT_TPMS_TIME, 0L);
        PushLogUtils.LOG.g("sLocalTpmsReportTime" + f50850g);
        if (f50850g <= 0) {
            this.f50851a.o(PushConstants.SP_KEY_REPORT_TPMS_TIME, currentTimeMillis);
            f50850g = currentTimeMillis;
        }
        return f50850g;
    }

    @Override // com.transsion.push.config.IDataSource
    public long getReportTime() {
        long currentTimeMillis = System.currentTimeMillis() - 1;
        long j11 = f50849f;
        if (j11 > 0) {
            return j11;
        }
        f fVar = this.f50851a;
        if (fVar == null) {
            return currentTimeMillis;
        }
        long h11 = fVar.h(PushConstants.SP_KEY_REPORT_ACTIVE_TIME, 0L);
        f50849f = h11;
        if (h11 <= 0) {
            this.f50851a.o(PushConstants.SP_KEY_REPORT_ACTIVE_TIME, currentTimeMillis);
            f50849f = currentTimeMillis;
        }
        return f50849f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.push.config.IDataSource
    public <T> T getSpValue(String str, T t11) {
        f fVar = this.f50851a;
        if (fVar == null) {
            return t11;
        }
        try {
            if (t11 instanceof String) {
                return (T) fVar.j(str, (String) t11);
            }
            if (t11 instanceof Boolean) {
                return (T) Boolean.valueOf(fVar.c(str, ((Boolean) t11).booleanValue()));
            }
            if (t11 instanceof Integer) {
                return (T) Integer.valueOf(fVar.f(str, ((Integer) t11).intValue()));
            }
            if (t11 instanceof Long) {
                return (T) Long.valueOf(fVar.h(str, ((Long) t11).longValue()));
            }
            if (t11 instanceof Float) {
                return (T) Float.valueOf(fVar.d(str, ((Float) t11).floatValue()));
            }
            if (t11 instanceof Set) {
                return (T) fVar.k(str, new HashSet());
            }
            PushLogUtils.LOG.i("Type of " + t11.getClass().getSimpleName() + " is not supported.");
            return t11;
        } catch (ClassCastException e11) {
            PushLogUtils.LOG.i("Type of default value is not match with value stored." + System.lineSeparator() + e11.getMessage());
            return t11;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public ConfigInfo.Whitelist getWhiteList() {
        if (!TextUtils.isEmpty(this.f50854d)) {
            try {
                return (ConfigInfo.Whitelist) b.a(this.f50854d, ConfigInfo.Whitelist.class);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            String a11 = TCrypterSdk.a(qk.a.a(), PushConstants.SP_KEY_WHITE_LIST);
            if (TextUtils.isEmpty(a11)) {
                return null;
            }
            this.f50854d = a11;
            return (ConfigInfo.Whitelist) b.a(a11, ConfigInfo.Whitelist.class);
        } catch (Exception e12) {
            PushLogUtils.LOG.i("get white list fail, e:" + e12.getMessage());
            return null;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public boolean isReported() {
        f fVar = this.f50851a;
        if (fVar == null) {
            return false;
        }
        try {
            return fVar.b(PushConstants.SP_KEY_REPORT_ACTIVE_SUCCESS);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void putSpValue(String str, Object obj) {
        f fVar = this.f50851a;
        if (fVar == null) {
            return;
        }
        try {
            if (obj instanceof String) {
                fVar.p(str, (String) obj);
            } else if (obj instanceof Boolean) {
                fVar.l(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                fVar.n(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                fVar.o(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                fVar.m(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                fVar.q(str, (Set) obj);
            }
        } catch (Exception e11) {
            PushLogUtils.LOG.i("put sp, Type of default value is not match with value stored." + System.lineSeparator() + e11.getMessage());
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void removeSpValue(String str) {
        try {
            f fVar = this.f50851a;
            if (fVar != null) {
                fVar.r(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveConfig(ConfigInfo.Config config) {
        f fVar;
        if (config == null || (fVar = this.f50851a) == null) {
            return;
        }
        try {
            this.f50853c = config;
            fVar.p(PushConstants.SP_KEY_CONFIG, new String(Base64.encode(b.b(config).getBytes(), 0)));
        } catch (Exception e11) {
            PushLogUtils.LOG.i("save config fail, e:" + e11.getMessage());
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveReportTime(long j11) {
        if (this.f50851a == null) {
            return;
        }
        PushLogUtils.LOG.g("Update reporting time，reportTime:" + j11);
        f50849f = j11;
        this.f50851a.o(PushConstants.SP_KEY_REPORT_ACTIVE_TIME, j11);
    }

    public void saveTpmsReportTime(long j11) {
        if (this.f50851a == null) {
            return;
        }
        PushLogUtils.LOG.g("Update reporting time，reportTime:" + j11);
        f50850g = j11;
        this.f50851a.o(PushConstants.SP_KEY_REPORT_TPMS_TIME, j11);
    }

    @Override // com.transsion.push.config.IDataSource
    public void saveWhiteList(ConfigInfo.Whitelist whitelist) {
        List<ConfigInfo.Apps> list;
        if (whitelist == null || (list = whitelist.apps) == null || list.size() == 0) {
            return;
        }
        try {
            if (TextUtils.isEmpty(this.f50854d)) {
                this.f50854d = b.b(whitelist);
                TCrypterSdk.c(qk.a.a(), PushConstants.SP_KEY_WHITE_LIST, this.f50854d);
                return;
            }
            List<ConfigInfo.Apps> list2 = ((ConfigInfo.Whitelist) b.a(this.f50854d, ConfigInfo.Whitelist.class)).apps;
            for (ConfigInfo.Apps apps : whitelist.apps) {
                if (!list2.contains(apps)) {
                    list2.add(apps);
                }
            }
            ConfigInfo.Whitelist whitelist2 = new ConfigInfo.Whitelist();
            whitelist2.version = whitelist.version;
            whitelist2.apps = new ArrayList(list2);
            this.f50854d = b.b(whitelist2);
            TCrypterSdk.c(qk.a.a(), PushConstants.SP_KEY_WHITE_LIST, this.f50854d);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void subscribeToTopic(final String str, final ITopicListener iTopicListener) {
        if (TextUtils.isEmpty(str)) {
            if (iTopicListener != null) {
                iTopicListener.onFail("subscribe topic is empty");
                PushLogUtils.LOG.i("subscribe topic is empty");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.config.PushRepository.1

                /* renamed from: com.transsion.push.config.PushRepository$1$a */
                /* loaded from: classes6.dex */
                class a implements ITopicListener {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ HashSet f50855a;

                    a(HashSet hashSet) {
                        this.f50855a = hashSet;
                    }

                    @Override // com.transsion.push.ITopicListener
                    public void onFail(String str) {
                        ITopicListener iTopicListener = iTopicListener;
                        if (iTopicListener != null) {
                            iTopicListener.onFail(str);
                        }
                    }

                    @Override // com.transsion.push.ITopicListener
                    public void onSuccess() {
                        if (str.contains(",")) {
                            for (String str : str.split(",")) {
                                this.f50855a.add(str);
                            }
                        } else {
                            this.f50855a.add(str);
                        }
                        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, this.f50855a);
                        ITopicListener iTopicListener = iTopicListener;
                        if (iTopicListener != null) {
                            iTopicListener.onSuccess();
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    HashSet hashSet = (HashSet) PushRepository.this.getSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, new HashSet());
                    if (!hashSet.contains(str)) {
                        PushRepository.this.f50852b.g(str, PushConstants.TOPIC_SUBSCRIBE, new a(hashSet));
                        return;
                    }
                    PushLogUtils.LOG.g("subscribe topic, " + str + " has been subscribed");
                    ITopicListener iTopicListener2 = iTopicListener;
                    if (iTopicListener2 != null) {
                        iTopicListener2.onSuccess();
                    }
                }
            });
        } else if (iTopicListener != null) {
            iTopicListener.onFail("subscribe clientId is empty");
            PushLogUtils.LOG.i("subscribe clientId is empty");
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void syncActive() {
        ConfigInfo.Whitelist whitelist;
        ConfigInfo.Config config;
        if (TextUtils.isEmpty((CharSequence) getSpValue(PushConstants.SP_KEY_FCM_TOKEN, ""))) {
            PushLogUtils.LOG.z("Token is empty");
            return;
        }
        if (this.f50852b == null) {
            PushLogUtils.LOG.z("mRemoteDataSource is null");
            return;
        }
        if (!PushManager.getInstance().getDebug() && !PushManager.getInstance().getTestEnv() && !GslbSdk.isInitSuccess(PushConstants.BASE_RELEASE_URL_V2)) {
            GslbSdk.getDomain(PushConstants.BASE_RELEASE_URL_V2, true);
        }
        ConfigInfo f11 = this.f50852b.f();
        if (f11 == null) {
            PushLogUtils.LOG.g("syncActive onFail");
            if (TextUtils.isEmpty((CharSequence) getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
                return;
            }
            c();
            return;
        }
        putSpValue(PushConstants.SP_KEY_RETRY_COUNT, 0);
        PushLogUtils.LOG.g("get config response data: " + f11.toString());
        putSpValue(PushConstants.SP_KEY_IS_NEXT_WITH_APP, Boolean.valueOf(f11.nextWithApp));
        putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.valueOf(f11.nextWithDetail));
        putSpValue(PushConstants.SP_KEY_CLIENT_ID, f11.clientId);
        putSpValue(PushConstants.SP_KEY_START_POINT_REPORT, Boolean.valueOf(f11.startPointReport));
        z.f(f11.destroyAppIds, f11.syncInfoInterval);
        PushUtils.w();
        if (f11.configRefresh && (config = f11.config) != null && config.version > 0) {
            saveConfig(config);
            putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(f11.config.destroy));
        }
        if (f11.whitelistRefresh && (whitelist = f11.whitelist) != null && whitelist.version > 0) {
            saveWhiteList(whitelist);
        }
        saveReportTime(System.currentTimeMillis() + v.b());
        putSpValue(PushConstants.SP_KEY_REPORT_ACTIVE_SUCCESS, Boolean.TRUE);
    }

    @Override // com.transsion.push.config.IDataSource
    public void syncSelfDestroying() {
        if (this.f50852b == null) {
            PushLogUtils.LOG.z("mRemoteDataSource is null");
            return;
        }
        if (!PushManager.getInstance().getDebug() && !PushManager.getInstance().getTestEnv() && !GslbSdk.isInitSuccess(PushConstants.BASE_RELEASE_URL_V2)) {
            PushLogUtils.LOG.z("gslb not inited");
            return;
        }
        Tracker.getInstance().trackReport();
        SelfDestroyInfo e11 = this.f50852b.e();
        if (e11 == null) {
            PushLogUtils.LOG.i("sync self-destroying fail");
            putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_TIME, Long.valueOf(System.currentTimeMillis() + v.e()));
            return;
        }
        PushLogUtils.LOG.g("get self-destroying response data: " + e11.toString());
        putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(e11.destroy));
        putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_INTERVAL, Integer.valueOf(e11.interval));
        putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_TIME, Long.valueOf(System.currentTimeMillis() + v.e()));
    }

    @Override // com.transsion.push.config.IDataSource
    public void unsubscribeFromTopic(final String str, final ITopicListener iTopicListener) {
        if (TextUtils.isEmpty(str)) {
            if (iTopicListener != null) {
                iTopicListener.onFail("unsubscribe topic is empty");
                PushLogUtils.LOG.i("unsubscribe topic is empty");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty((CharSequence) getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.config.PushRepository.2

                /* renamed from: com.transsion.push.config.PushRepository$2$a */
                /* loaded from: classes6.dex */
                class a implements ITopicListener {
                    a() {
                    }

                    @Override // com.transsion.push.ITopicListener
                    public void onFail(String str) {
                        ITopicListener iTopicListener = iTopicListener;
                        if (iTopicListener != null) {
                            iTopicListener.onFail(str);
                        }
                    }

                    @Override // com.transsion.push.ITopicListener
                    public void onSuccess() {
                        HashSet hashSet = (HashSet) PushRepository.this.getSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, new HashSet());
                        if (str.equals(PushConstants.SP_KEY_APP_TOPIC_UNSUBSCRIBE_ALL)) {
                            hashSet.clear();
                        } else if (str.contains(",")) {
                            for (String str : str.split(",")) {
                                hashSet.remove(str);
                            }
                        } else {
                            hashSet.remove(str);
                        }
                        PushRepository.this.putSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, hashSet);
                        ITopicListener iTopicListener = iTopicListener;
                        if (iTopicListener != null) {
                            iTopicListener.onSuccess();
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    PushRepository.this.f50852b.g(str, PushConstants.TOPIC_UNSUBSCRIBE, new a());
                }
            });
        } else if (iTopicListener != null) {
            iTopicListener.onFail("unsubscribe clientId is empty");
            PushLogUtils.LOG.i("unsubscribe clientId is empty");
        }
    }

    @Override // com.transsion.push.config.IDataSource
    public void updateNewToken(String str) {
        putSpValue(PushConstants.SP_KEY_FCM_TOKEN, str);
        putSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.TRUE);
        putSpValue(PushConstants.SP_KEY_REPORT_ACTIVE_SUCCESS, Boolean.FALSE);
    }
}
