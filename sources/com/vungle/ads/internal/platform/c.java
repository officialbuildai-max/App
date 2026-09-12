package com.vungle.ads.internal.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.util.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class c implements d {
    public static final a Companion = new a(null);
    private static final String TAG = "AndroidPlatform";
    private com.vungle.ads.internal.model.a advertisingInfo;
    private String appSetId;
    private Integer appSetIdScope;
    private final AudioManager audioManager;
    private final Context context;
    private final boolean isSideLoaded;
    private final PowerManager powerManager;
    private final VungleThreadPoolExecutor uaExecutor;
    private String userAgent;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getCarrierName$vungle_ads_release(Context context) {
            Intrinsics.h(context, "context");
            Object systemService = context.getSystemService("phone");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getNetworkOperatorName();
        }
    }

    public c(Context context, VungleThreadPoolExecutor uaExecutor) {
        Intrinsics.h(context, "context");
        Intrinsics.h(uaExecutor, "uaExecutor");
        this.context = context;
        this.uaExecutor = uaExecutor;
        updateAppSetID();
        Object systemService = context.getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        this.powerManager = (PowerManager) systemService;
        Object systemService2 = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.f(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService2;
    }

    private final com.vungle.ads.internal.model.a getAmazonAdvertisingInfo() {
        com.vungle.ads.internal.model.a aVar = new com.vungle.ads.internal.model.a();
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            boolean z10 = true;
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                z10 = false;
            }
            aVar.setLimitAdTracking(z10);
            aVar.setAdvertisingId(Settings.Secure.getString(contentResolver, "advertising_id"));
        } catch (Settings.SettingNotFoundException e11) {
            o.Companion.w(TAG, "Error getting Amazon advertising info: Setting not found.", e11);
        } catch (Exception e12) {
            o.Companion.w(TAG, "Error getting Amazon advertising info", e12);
        }
        return aVar;
    }

    private final com.vungle.ads.internal.model.a getGoogleAdvertisingInfo() {
        com.vungle.ads.internal.model.a aVar = new com.vungle.ads.internal.model.a();
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            Intrinsics.g(advertisingIdInfo, "getAdvertisingIdInfo(context)");
            aVar.setAdvertisingId(advertisingIdInfo.getId());
            aVar.setLimitAdTracking(advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesNotAvailableException e11) {
            o.Companion.e(TAG, "Play services Not available: " + e11.getLocalizedMessage());
        } catch (Exception e12) {
            o.Companion.e(TAG, "Error getting Google advertising info: " + e12.getLocalizedMessage());
        } catch (NoClassDefFoundError e13) {
            o.Companion.e(TAG, "Play services Not available: " + e13.getLocalizedMessage());
            aVar.setAdvertisingId(Settings.Secure.getString(this.context.getContentResolver(), "advertising_id"));
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserAgentLazy$lambda-0, reason: not valid java name */
    public static final void m1067getUserAgentLazy$lambda0(c this$0, androidx.core.util.a consumer) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(consumer, "$consumer");
        e.INSTANCE.getUserAgent(this$0.context, consumer);
    }

    private final void updateAppSetID() {
        String str = this.appSetId;
        if (str == null || str.length() == 0) {
            try {
                AppSetIdClient client = AppSet.getClient(this.context);
                Intrinsics.g(client, "getClient(context)");
                Task appSetIdInfo = client.getAppSetIdInfo();
                Intrinsics.g(appSetIdInfo, "client.appSetIdInfo");
                appSetIdInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.vungle.ads.internal.platform.b
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        c.m1068updateAppSetID$lambda4(c.this, (AppSetIdInfo) obj);
                    }
                });
            } catch (Exception e11) {
                o.Companion.e(TAG, "Error getting AppSetID: " + e11.getLocalizedMessage());
            } catch (NoClassDefFoundError e12) {
                o.Companion.e(TAG, "Required libs to get AppSetID Not available: " + e12.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAppSetID$lambda-4, reason: not valid java name */
    public static final void m1068updateAppSetID$lambda4(c this$0, AppSetIdInfo appSetIdInfo) {
        Intrinsics.h(this$0, "this$0");
        if (appSetIdInfo != null) {
            this$0.appSetId = appSetIdInfo.getId();
            this$0.appSetIdScope = Integer.valueOf(appSetIdInfo.getScope());
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public com.vungle.ads.internal.model.a getAdvertisingInfo() {
        String advertisingId;
        com.vungle.ads.internal.model.a aVar = this.advertisingInfo;
        if (aVar != null && (advertisingId = aVar.getAdvertisingId()) != null && advertisingId.length() != 0) {
            return aVar;
        }
        com.vungle.ads.internal.model.a amazonAdvertisingInfo = StringsKt.H(Build.MANUFACTURER, "Amazon", true) ? getAmazonAdvertisingInfo() : getGoogleAdvertisingInfo();
        this.advertisingInfo = amazonAdvertisingInfo;
        return amazonAdvertisingInfo;
    }

    @Override // com.vungle.ads.internal.platform.d
    public String getAppSetId() {
        return this.appSetId;
    }

    @Override // com.vungle.ads.internal.platform.d
    public Integer getAppSetIdScope() {
        return this.appSetIdScope;
    }

    @Override // com.vungle.ads.internal.platform.d
    public long getBuildTime() {
        return Build.TIME;
    }

    @Override // com.vungle.ads.internal.platform.d
    public String getCarrierName() {
        String carrierName$vungle_ads_release = Companion.getCarrierName$vungle_ads_release(this.context);
        Intrinsics.g(carrierName$vungle_ads_release, "getCarrierName(context)");
        return carrierName$vungle_ads_release;
    }

    @Override // com.vungle.ads.internal.platform.d
    public long getLastBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    @Override // com.vungle.ads.internal.platform.d
    public long getOSInstallationTime() {
        Object m1185constructorimpl;
        PackageInfo packageInfo;
        PackageManager.PackageInfoFlags of2;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (Build.VERSION.SDK_INT >= 33) {
                PackageManager packageManager = this.context.getPackageManager();
                of2 = PackageManager.PackageInfoFlags.of(0L);
                packageInfo = packageManager.getPackageInfo("android", of2);
            } else {
                packageInfo = this.context.getPackageManager().getPackageInfo("android", 0);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Long.valueOf(packageInfo.firstInstallTime));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            if (m1188exceptionOrNullimpl instanceof PackageManager.NameNotFoundException) {
                o.Companion.e(TAG, "Error getting OS installation time: " + ((PackageManager.NameNotFoundException) m1188exceptionOrNullimpl).getLocalizedMessage());
            }
            m1185constructorimpl = -1L;
        }
        return ((Number) m1185constructorimpl).longValue();
    }

    @Override // com.vungle.ads.internal.platform.d
    public String getUserAgent() {
        String str = this.userAgent;
        return str == null ? System.getProperty("http.agent") : str;
    }

    @Override // com.vungle.ads.internal.platform.d
    public void getUserAgentLazy(final androidx.core.util.a consumer) {
        Intrinsics.h(consumer, "consumer");
        this.uaExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.platform.a
            @Override // java.lang.Runnable
            public final void run() {
                c.m1067getUserAgentLazy$lambda0(c.this, consumer);
            }
        });
    }

    @Override // com.vungle.ads.internal.platform.d
    public float getVolumeLevel() {
        try {
            return this.audioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isBatterySaverEnabled() {
        return this.powerManager.isPowerSaveMode();
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSdCardPresent() {
        try {
            return Intrinsics.c(Environment.getExternalStorageState(), "mounted");
        } catch (Exception e11) {
            o.Companion.e(TAG, "Acquiring external storage state failed", e11);
            return false;
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSideLoaded() {
        return this.isSideLoaded;
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSilentModeEnabled() {
        try {
            if (this.audioManager.getRingerMode() != 0) {
                if (this.audioManager.getRingerMode() != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSoundEnabled() {
        try {
            return this.audioManager.getStreamVolume(3) > 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}
