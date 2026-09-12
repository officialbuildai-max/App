package com.cloud.config.bean;

import android.util.Log;
import com.cloud.config.utils.CommonUtils;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/cloud/config/bean/ConditionInfo;", "", "conditionParams", "", "Lcom/cloud/config/bean/ConditionParam;", "defaultCacheFileUrl", "", "(Ljava/util/List;Ljava/lang/String;)V", "_conditionParam", "get_conditionParam", "()Lcom/cloud/config/bean/ConditionParam;", "set_conditionParam", "(Lcom/cloud/config/bean/ConditionParam;)V", "getConditionParams", "()Ljava/util/List;", "getDefaultCacheFileUrl", "()Ljava/lang/String;", "matchCacheUrl", "getMatchCacheUrl", "component1", "component2", "copy", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "hashCode", "", "toString", "config_release"}, k = 1, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final /* data */ class ConditionInfo {
    private ConditionParam _conditionParam;
    private final List<ConditionParam> conditionParams;
    private final String defaultCacheFileUrl;

    public ConditionInfo(List<ConditionParam> list, String str) {
        this.conditionParams = list;
        this.defaultCacheFileUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionInfo copy$default(ConditionInfo conditionInfo, List list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = conditionInfo.conditionParams;
        }
        if ((i11 & 2) != 0) {
            str = conditionInfo.defaultCacheFileUrl;
        }
        return conditionInfo.copy(list, str);
    }

    public final List<ConditionParam> component1() {
        return this.conditionParams;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDefaultCacheFileUrl() {
        return this.defaultCacheFileUrl;
    }

    public final ConditionInfo copy(List<ConditionParam> conditionParams, String defaultCacheFileUrl) {
        return new ConditionInfo(conditionParams, defaultCacheFileUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConditionInfo)) {
            return false;
        }
        ConditionInfo conditionInfo = (ConditionInfo) other;
        return Intrinsics.c(this.conditionParams, conditionInfo.conditionParams) && Intrinsics.c(this.defaultCacheFileUrl, conditionInfo.defaultCacheFileUrl);
    }

    public final List<ConditionParam> getConditionParams() {
        return this.conditionParams;
    }

    public final String getDefaultCacheFileUrl() {
        return this.defaultCacheFileUrl;
    }

    public final String getMatchCacheUrl() {
        List<String> phoneLanguage;
        List<String> phoneBrand;
        List<String> phoneModel;
        List<String> osVersion;
        List<String> mcc;
        try {
            List<ConditionParam> list = this.conditionParams;
            Iterator<ConditionParam> it = list == null ? null : list.iterator();
            if (it != null) {
                while (it.hasNext()) {
                    ConditionParam next = it.next();
                    ConditionParamX conditionParam = next.getConditionParam();
                    if (conditionParam != null && (mcc = conditionParam.getMcc()) != null) {
                        List<String> list2 = mcc;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            for (String str : list2) {
                                if (!Intrinsics.c(str, "") && !Intrinsics.c(str, "*") && !Intrinsics.c(str, CommonUtils.INSTANCE.getMcc())) {
                                }
                            }
                        }
                        XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, "CloudConfigResponse --> mcc不匹配");
                    }
                    ConditionParamX conditionParam2 = next.getConditionParam();
                    if (conditionParam2 != null && (osVersion = conditionParam2.getOsVersion()) != null) {
                        List<String> list3 = osVersion;
                        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                            for (String str2 : list3) {
                                if (!Intrinsics.c(str2, "") && !Intrinsics.c(str2, "*") && !Intrinsics.c(str2, CommonUtils.INSTANCE.getVersion())) {
                                }
                            }
                        }
                        XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, "CloudConfigResponse --> osVersion不匹配");
                    }
                    ConditionParamX conditionParam3 = next.getConditionParam();
                    if (conditionParam3 != null && (phoneModel = conditionParam3.getPhoneModel()) != null) {
                        List<String> list4 = phoneModel;
                        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                            for (String str3 : list4) {
                                if (!Intrinsics.c(str3, "") && !Intrinsics.c(str3, "*") && !Intrinsics.c(str3, CommonUtils.INSTANCE.getModel())) {
                                }
                            }
                        }
                        XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, "CloudConfigResponse --> phoneModel不匹配");
                    }
                    ConditionParamX conditionParam4 = next.getConditionParam();
                    if (conditionParam4 != null && (phoneBrand = conditionParam4.getPhoneBrand()) != null) {
                        List<String> list5 = phoneBrand;
                        if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                            for (String str4 : list5) {
                                if (!Intrinsics.c(str4, "") && !Intrinsics.c(str4, "*") && !Intrinsics.c(str4, CommonUtils.INSTANCE.getBrand())) {
                                }
                            }
                        }
                        XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, "CloudConfigResponse --> phoneBrand不匹配");
                    }
                    ConditionParamX conditionParam5 = next.getConditionParam();
                    if (conditionParam5 != null && (phoneLanguage = conditionParam5.getPhoneLanguage()) != null) {
                        List<String> list6 = phoneLanguage;
                        if (!(list6 instanceof Collection) || !list6.isEmpty()) {
                            for (String str5 : list6) {
                                if (!Intrinsics.c(str5, "") && !Intrinsics.c(str5, "*") && !Intrinsics.c(str5, CommonUtils.INSTANCE.getSystemLanguage())) {
                                }
                            }
                        }
                        XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, "CloudConfigResponse --> phoneLanguage不匹配");
                    }
                    ShuntInfo shuntInfo = next.getShuntInfo();
                    if (shuntInfo != null && shuntInfo.isShuntOpen()) {
                        this._conditionParam = next;
                        return CommonUtils.SHUNT_OPEN_FLAG;
                    }
                    return next.getCacheFileUrl();
                }
            }
            return this.defaultCacheFileUrl;
        } catch (Throwable th2) {
            XLogUtil.INSTANCE.getLog().i(XLogUtil.TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public final ConditionParam get_conditionParam() {
        return this._conditionParam;
    }

    public int hashCode() {
        List<ConditionParam> list = this.conditionParams;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.defaultCacheFileUrl;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void set_conditionParam(ConditionParam conditionParam) {
        this._conditionParam = conditionParam;
    }

    public String toString() {
        return "ConditionInfo(conditionParams=" + this.conditionParams + ", defaultCacheFileUrl=" + ((Object) this.defaultCacheFileUrl) + ')';
    }
}
