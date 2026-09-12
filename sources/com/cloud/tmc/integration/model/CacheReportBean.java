package com.cloud.tmc.integration.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/cloud/tmc/integration/model/CacheReportBean;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", NotificationCompat.CATEGORY_EVENT, "isMfah", "", "data", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "getEvent", "setEvent", "()Z", "setMfah", "(Z)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final /* data */ class CacheReportBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String appId;
    private Bundle data;
    private String event;
    private boolean isMfah;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/cloud/tmc/integration/model/CacheReportBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/cloud/tmc/integration/model/CacheReportBean;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/cloud/tmc/integration/model/CacheReportBean;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* renamed from: com.cloud.tmc.integration.model.CacheReportBean$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion implements Parcelable.Creator<CacheReportBean> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CacheReportBean createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new CacheReportBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CacheReportBean[] newArray(int size) {
            return new CacheReportBean[size];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CacheReportBean(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.lang.String r0 = r5.readString()
            java.lang.String r1 = ""
            if (r0 != 0) goto Le
            r0 = r1
        Le:
            java.lang.String r2 = r5.readString()
            if (r2 != 0) goto L15
            goto L16
        L15:
            r1 = r2
        L16:
            byte r2 = r5.readByte()
            if (r2 == 0) goto L1e
            r2 = 1
            goto L1f
        L1e:
            r2 = 0
        L1f:
            java.lang.Class<android.os.Bundle> r3 = android.os.Bundle.class
            java.lang.ClassLoader r3 = r3.getClassLoader()
            android.os.Bundle r5 = r5.readBundle(r3)
            if (r5 != 0) goto L30
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
        L30:
            r4.<init>(r0, r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.model.CacheReportBean.<init>(android.os.Parcel):void");
    }

    public CacheReportBean(String appId, String event, boolean z10, Bundle data) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(event, "event");
        Intrinsics.h(data, "data");
        this.appId = appId;
        this.event = event;
        this.isMfah = z10;
        this.data = data;
    }

    public static /* synthetic */ CacheReportBean copy$default(CacheReportBean cacheReportBean, String str, String str2, boolean z10, Bundle bundle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cacheReportBean.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = cacheReportBean.event;
        }
        if ((i11 & 4) != 0) {
            z10 = cacheReportBean.isMfah;
        }
        if ((i11 & 8) != 0) {
            bundle = cacheReportBean.data;
        }
        return cacheReportBean.copy(str, str2, z10, bundle);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsMfah() {
        return this.isMfah;
    }

    /* renamed from: component4, reason: from getter */
    public final Bundle getData() {
        return this.data;
    }

    public final CacheReportBean copy(String appId, String event, boolean isMfah, Bundle data) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(event, "event");
        Intrinsics.h(data, "data");
        return new CacheReportBean(appId, event, isMfah, data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheReportBean)) {
            return false;
        }
        CacheReportBean cacheReportBean = (CacheReportBean) other;
        return Intrinsics.c(this.appId, cacheReportBean.appId) && Intrinsics.c(this.event, cacheReportBean.event) && this.isMfah == cacheReportBean.isMfah && Intrinsics.c(this.data, cacheReportBean.data);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Bundle getData() {
        return this.data;
    }

    public final String getEvent() {
        return this.event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.appId.hashCode() * 31) + this.event.hashCode()) * 31;
        boolean z10 = this.isMfah;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        return ((hashCode + i11) * 31) + this.data.hashCode();
    }

    public final boolean isMfah() {
        return this.isMfah;
    }

    public final void setAppId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appId = str;
    }

    public final void setData(Bundle bundle) {
        Intrinsics.h(bundle, "<set-?>");
        this.data = bundle;
    }

    public final void setEvent(String str) {
        Intrinsics.h(str, "<set-?>");
        this.event = str;
    }

    public final void setMfah(boolean z10) {
        this.isMfah = z10;
    }

    public String toString() {
        return "CacheReportBean(appId=" + this.appId + ", event=" + this.event + ", isMfah=" + this.isMfah + ", data=" + this.data + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.h(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.event);
        parcel.writeByte(this.isMfah ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.data);
    }
}
