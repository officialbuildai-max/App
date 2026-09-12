package com.cloud.tmc.miniapp.defaultimpl;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.ad.athena.PostConstant;
import com.cloud.tmc.ad.utils.GPSTracker;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.athena.Constants;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.launcherlib.LauncherFrameworkConstants;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.model.ZipFileInfo;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AthenaReport implements ReportProxy {
    public static final OooO00o Companion = new OooO00o();
    public static AtomicBoolean OooO0OO = new AtomicBoolean(false);
    public static AtomicBoolean OooO0Oo = new AtomicBoolean(false);
    public static AtomicBoolean OooO0o0 = new AtomicBoolean(false);
    public final ConcurrentHashMap<String, UniqueIdBean> OooO00o = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, LazyGetPkgInfoBean> OooO0O0 = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public static final class LazyGetPkgInfoBean extends BaseBean {
        private String info;
        private AtomicBoolean requesting;

        public LazyGetPkgInfoBean() {
            this(null, null, 3, null);
        }

        public LazyGetPkgInfoBean(AtomicBoolean requesting, String info) {
            Intrinsics.h(requesting, "requesting");
            Intrinsics.h(info, "info");
            this.requesting = requesting;
            this.info = info;
        }

        public /* synthetic */ LazyGetPkgInfoBean(AtomicBoolean atomicBoolean, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i11 & 2) != 0 ? "" : str);
        }

        public static /* synthetic */ LazyGetPkgInfoBean copy$default(LazyGetPkgInfoBean lazyGetPkgInfoBean, AtomicBoolean atomicBoolean, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                atomicBoolean = lazyGetPkgInfoBean.requesting;
            }
            if ((i11 & 2) != 0) {
                str = lazyGetPkgInfoBean.info;
            }
            return lazyGetPkgInfoBean.copy(atomicBoolean, str);
        }

        public final AtomicBoolean component1() {
            return this.requesting;
        }

        public final String component2() {
            return this.info;
        }

        public final LazyGetPkgInfoBean copy(AtomicBoolean requesting, String info) {
            Intrinsics.h(requesting, "requesting");
            Intrinsics.h(info, "info");
            return new LazyGetPkgInfoBean(requesting, info);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LazyGetPkgInfoBean)) {
                return false;
            }
            LazyGetPkgInfoBean lazyGetPkgInfoBean = (LazyGetPkgInfoBean) obj;
            return Intrinsics.c(this.requesting, lazyGetPkgInfoBean.requesting) && Intrinsics.c(this.info, lazyGetPkgInfoBean.info);
        }

        public final String getInfo() {
            return this.info;
        }

        public final AtomicBoolean getRequesting() {
            return this.requesting;
        }

        public int hashCode() {
            return this.info.hashCode() + (this.requesting.hashCode() * 31);
        }

        public final void setInfo(String str) {
            Intrinsics.h(str, "<set-?>");
            this.info = str;
        }

        public final void setRequesting(AtomicBoolean atomicBoolean) {
            Intrinsics.h(atomicBoolean, "<set-?>");
            this.requesting = atomicBoolean;
        }

        public String toString() {
            return "LazyGetPkgInfoBean(requesting=" + this.requesting + ", info=" + this.info + ")";
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public static final class UniqueIdBean extends BaseBean {
        private AtomicBoolean requesting;
        private String uniqueId;

        public UniqueIdBean() {
            this(null, null, 3, null);
        }

        public UniqueIdBean(AtomicBoolean requesting, String uniqueId) {
            Intrinsics.h(requesting, "requesting");
            Intrinsics.h(uniqueId, "uniqueId");
            this.requesting = requesting;
            this.uniqueId = uniqueId;
        }

        public /* synthetic */ UniqueIdBean(AtomicBoolean atomicBoolean, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i11 & 2) != 0 ? "" : str);
        }

        public static /* synthetic */ UniqueIdBean copy$default(UniqueIdBean uniqueIdBean, AtomicBoolean atomicBoolean, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                atomicBoolean = uniqueIdBean.requesting;
            }
            if ((i11 & 2) != 0) {
                str = uniqueIdBean.uniqueId;
            }
            return uniqueIdBean.copy(atomicBoolean, str);
        }

        public final AtomicBoolean component1() {
            return this.requesting;
        }

        public final String component2() {
            return this.uniqueId;
        }

        public final UniqueIdBean copy(AtomicBoolean requesting, String uniqueId) {
            Intrinsics.h(requesting, "requesting");
            Intrinsics.h(uniqueId, "uniqueId");
            return new UniqueIdBean(requesting, uniqueId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UniqueIdBean)) {
                return false;
            }
            UniqueIdBean uniqueIdBean = (UniqueIdBean) obj;
            return Intrinsics.c(this.requesting, uniqueIdBean.requesting) && Intrinsics.c(this.uniqueId, uniqueIdBean.uniqueId);
        }

        public final AtomicBoolean getRequesting() {
            return this.requesting;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public int hashCode() {
            return this.uniqueId.hashCode() + (this.requesting.hashCode() * 31);
        }

        public final void setRequesting(AtomicBoolean atomicBoolean) {
            Intrinsics.h(atomicBoolean, "<set-?>");
            this.requesting = atomicBoolean;
        }

        public final void setUniqueId(String str) {
            Intrinsics.h(str, "<set-?>");
            this.uniqueId = str;
        }

        public String toString() {
            return "UniqueIdBean(requesting=" + this.requesting + ", uniqueId=" + this.uniqueId + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OooO00o(AthenaReport this$0, App app, Ref.ObjectRef lazyGetPkgInfoBean) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(lazyGetPkgInfoBean, "$lazyGetPkgInfoBean");
        this$0.OooO00o(app, (LazyGetPkgInfoBean) lazyGetPkgInfoBean.element);
    }

    public static final /* synthetic */ AtomicBoolean access$getMainProcessInitAthenaFlag$cp() {
        return OooO0OO;
    }

    public static final /* synthetic */ AtomicBoolean access$getMiniProcessInitAthenaFlag$cp() {
        return OooO0Oo;
    }

    public static final /* synthetic */ AtomicBoolean access$getZeroProcessInitAthenaFlag$cp() {
        return OooO0o0;
    }

    public final String OooO00o(String str) {
        String str2;
        try {
            TmcLogger.d("AthenaReport", "realPagePath:" + str);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int o02 = StringsKt.o0(str, UrlUtils.QUESTION_MARK, 0, false, 6, null);
            if (o02 > 0) {
                str2 = str.substring(0, o02);
                Intrinsics.g(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (!StringsKt.c0(str2, "http", false, 2, null)) {
                return str2;
            }
            Object fromJson = GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_ATHENA_REPORT_PATHS, MiniAppConfigHelper.DEFAULT_ATHENA_REPORT_PATHS), new TypeToken<Map<String, ? extends String>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.AthenaReport$getMatchPagePath$pathMap$1
            }.getType());
            Intrinsics.g(fromJson, "fromJson(paths, object :…ring, String>>() {}.type)");
            for (Map.Entry entry : ((Map) fromJson).entrySet()) {
                if (StringsKt.c0(str2, (CharSequence) entry.getKey(), false, 2, null)) {
                    return (String) entry.getValue();
                }
            }
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.cloud.tmc.miniapp.defaultimpl.AthenaReport$LazyGetPkgInfoBean, java.lang.Object] */
    public final void OooO00o(final App app) {
        try {
            if (AppPrepareUtils.INSTANCE.isShellType(app != null ? app.getAppModel() : null)) {
                String appId = app != null ? app.getAppId() : null;
                if (appId == null) {
                    return;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r32 = this.OooO0O0.get(appId);
                objectRef.element = r32;
                if (r32 == 0) {
                    ?? lazyGetPkgInfoBean = new LazyGetPkgInfoBean(null, null, 3, null);
                    objectRef.element = lazyGetPkgInfoBean;
                    this.OooO0O0.put(appId, lazyGetPkgInfoBean);
                }
                if (TextUtils.isEmpty(((LazyGetPkgInfoBean) objectRef.element).getInfo()) && !((LazyGetPkgInfoBean) objectRef.element).getRequesting().get()) {
                    ((LazyGetPkgInfoBean) objectRef.element).getRequesting().set(true);
                    if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                        ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                AthenaReport.OooO00o(AthenaReport.this, app, objectRef);
                            }
                        });
                    } else {
                        OooO00o(app, (LazyGetPkgInfoBean) objectRef.element);
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("AthenaReport", "getOfflinePackageInfo", th2);
        }
    }

    public final void OooO00o(App app, LazyGetPkgInfoBean lazyGetPkgInfoBean) {
        String appId;
        AtomicBoolean requesting;
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable unused) {
                return;
            }
        } else {
            appId = null;
        }
        List<ZipFileInfo> offlinePackageDownloadInfo = OfflineManager.getOfflinePackageDownloadInfo(appId);
        if (offlinePackageDownloadInfo == null) {
            if (lazyGetPkgInfoBean == null || (requesting = lazyGetPkgInfoBean.getRequesting()) == null) {
                return;
            }
            requesting.set(false);
            return;
        }
        boolean booleanValue = app != null ? app.getBooleanValue(TmcConstants.KEY_DISABLE_OFFLINE_PROCESSOR) : false;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(offlinePackageDownloadInfo, 10));
        Iterator<T> it = offlinePackageDownloadInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(MapsKt.j(TuplesKt.a("key", ((ZipFileInfo) it.next()).getUrl()), TuplesKt.a("useStatus", Boolean.valueOf(!booleanValue))));
        }
        if (lazyGetPkgInfoBean != null) {
            lazyGetPkgInfoBean.setInfo(TmcGsonUtilsKt.toJson(arrayList));
            lazyGetPkgInfoBean.getRequesting().set(false);
            TmcLogger.d("seven", "info:" + lazyGetPkgInfoBean.getInfo());
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public /* bridge */ /* synthetic */ Triple checkReportIntercept(String str, Boolean bool) {
        return checkReportIntercept(str, bool.booleanValue());
    }

    public Triple<Boolean, Boolean, Boolean> checkReportIntercept(String str, boolean z10) {
        com.cloud.tmc.miniapp.utils.athena.strategy.OooO00o OooO00o2 = com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o(str, z10);
        return new Triple<>(Boolean.valueOf(OooO00o2 != null ? OooO00o2.OooO00o : false), Boolean.valueOf(OooO00o2 != null ? OooO00o2.OooO0O0 : false), Boolean.valueOf(OooO00o2 != null ? OooO00o2.OooO0OO : false));
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void forceAthenaReport(String appId, String tag, int i11, Bundle bundle) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(tag, "tag");
        Intrinsics.h(bundle, "bundle");
        try {
            com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO0O0(tag, i11, getAthenaCommonBundle(appId, bundle, tag));
        } catch (Throwable th2) {
            TmcLogger.e("AthenaReport", "forceAthenaReport", th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02da A[Catch: all -> 0x02d4, TryCatch #1 {all -> 0x02d4, blocks: (B:167:0x02cf, B:157:0x02da, B:159:0x02e9, B:160:0x02ef), top: B:166:0x02cf }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle getAthenaCommonBundle(java.lang.String r17, android.os.Bundle r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.defaultimpl.AthenaReport.getAthenaCommonBundle(java.lang.String, android.os.Bundle, java.lang.String):android.os.Bundle");
    }

    public final Bundle getBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("session_id", PostConstant.getSessionId());
            bundle.putString("sdk_version", ((IAdManagerProxy) TmcProxy.get(IAdManagerProxy.class)).getAdSdkFrameworkVersion());
            bundle.putLong("sdk_version_int", ((IAdManagerProxy) TmcProxy.get(IAdManagerProxy.class)).getAdSdkFrameworkVersionInt());
            bundle.putString("user_agent", PostConstant.getUserAgent());
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, PostConstant.getType());
            bundle.putString("make", PostConstant.getMake());
            bundle.putString("ostype", "Android");
            bundle.putInt("screen_width", PostConstant.getScreenWidth());
            bundle.putInt("screen_height", PostConstant.getScreenHeight());
            bundle.putInt("screen_density", PostConstant.getScreenDensity());
            DeviceUtil deviceUtil = DeviceUtil.INSTANCE;
            bundle.putString("base_station", deviceUtil.getGsmCellLocation());
            bundle.putDouble("latitude", GPSTracker.getLatitude());
            bundle.putDouble("longitude", GPSTracker.getLongitude());
            bundle.putLong("coordtime", GPSTracker.getCoordTime());
            bundle.putString("oneid", "");
            bundle.putInt("turn_off_per_ads", deviceUtil.getGaidStatus());
        } catch (Throwable th2) {
            TmcLogger.e("AthenaReport", "getBundle fail: " + th2);
        }
        return bundle;
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public String getVaid() {
        try {
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(ByteAppManager.getSApplication(), LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, TmcConstants.ATHENA_VAID);
            return string == null ? "0000-0000-0000-0000" : string;
        } catch (Exception unused) {
            return "0000-0000-0000-0000";
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void mfahCacheDataReport(String str) {
        Unit unit;
        if (str != null) {
            try {
                com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o(str);
                unit = Unit.f67184a;
            } catch (Throwable th2) {
                TmcLogger.e("AthenaReport", th2);
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            TmcLogger.d("AthenaReport", "mfahCacheDataReport: appId is null");
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void report(String str, String str2, Bundle bundle) {
        report(str, str2, bundle, Integer.valueOf(Constants.MINI_APPID));
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void report(String str, String str2, Bundle bundle, Integer num) {
        int i11;
        if (str2 != null) {
            try {
                Bundle athenaCommonBundle = getAthenaCommonBundle(str, bundle, str2);
                if (num == null || (i11 = num.intValue()) == 0) {
                    i11 = Constants.MINI_APPID;
                }
                com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o(str2, i11, athenaCommonBundle, str);
            } catch (Throwable th2) {
                TmcLogger.e("AthenaReport", "report: ", th2);
            }
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ReportProxy
    public void reportAd(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            try {
                Bundle bundle2 = new Bundle();
                App app = null;
                App findApp = TextUtils.isEmpty(str) ? null : ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                if (findApp != null) {
                    app = findApp;
                } else if (!TextUtils.isEmpty(str)) {
                    app = ((VirtualAppManager) TmcProxy.get(VirtualAppManager.class)).findApp(str);
                }
                if (app != null) {
                    String appId = app.getAppId();
                    if (appId == null) {
                        appId = "";
                    }
                    bundle2.putString("mini_program_id", appId);
                }
                bundle2.putString("host_package_name", String.valueOf(ByteAppManager.getSApplication().getPackageName()));
                bundle2.putAll(bundle);
                Bundle bundle3 = getBundle(bundle2);
                TraceLog.i("reportBussinessData", bundle3 + " =====> " + str2);
                com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o.OooO00o(str2, Constants.AD_APPID, bundle3, str);
            } catch (Throwable th2) {
                TmcLogger.e("AthenaReport", "reportAd: ", th2);
            }
        }
    }
}
