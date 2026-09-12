package com.transsion.mpush.core.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJx\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u000204J\u0013\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000204HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000204R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001e¨\u0006?"}, d2 = {"Lcom/transsion/mpush/core/config/PushConfig;", "Landroid/os/Parcelable;", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, "", "startTime", "", "endTime", "pushGap", "brightScreen", "unlock", "floatingWindow", "ring", "shock", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getStartTime", "()Ljava/lang/String;", "setStartTime", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getPushGap", "setPushGap", "getBrightScreen", "()Ljava/lang/Boolean;", "setBrightScreen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUnlock", "setUnlock", "getFloatingWindow", "setFloatingWindow", "getRing", "setRing", "getShock", "setShock", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/transsion/mpush/core/config/PushConfig;", "describeContents", "", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "MBPush_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final /* data */ class PushConfig implements Parcelable {
    public static final Parcelable.Creator<PushConfig> CREATOR = new Creator();
    private Boolean brightScreen;
    private boolean enable;
    private String endTime;
    private Boolean floatingWindow;
    private String pushGap;
    private Boolean ring;
    private Boolean shock;
    private String startTime;
    private Boolean unlock;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes6.dex */
    public static final class Creator implements Parcelable.Creator<PushConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushConfig createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            Intrinsics.h(parcel, "parcel");
            boolean z10 = parcel.readInt() != 0;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PushConfig(z10, readString, readString2, readString3, valueOf, valueOf2, valueOf3, valueOf4, valueOf5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushConfig[] newArray(int i11) {
            return new PushConfig[i11];
        }
    }

    public PushConfig() {
        this(false, null, null, null, null, null, null, null, null, 511, null);
    }

    public PushConfig(boolean z10, String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.enable = z10;
        this.startTime = str;
        this.endTime = str2;
        this.pushGap = str3;
        this.brightScreen = bool;
        this.unlock = bool2;
        this.floatingWindow = bool3;
        this.ring = bool4;
        this.shock = bool5;
    }

    public /* synthetic */ PushConfig(boolean z10, String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? PrepareException.ERROR_MANIFEST_INFO : str, (i11 & 4) != 0 ? "22" : str2, (i11 & 8) != 0 ? "2" : str3, (i11 & 16) != 0 ? null : bool, (i11 & 32) != 0 ? null : bool2, (i11 & 64) != 0 ? null : bool3, (i11 & 128) != 0 ? null : bool4, (i11 & 256) == 0 ? bool5 : null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPushGap() {
        return this.pushGap;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getBrightScreen() {
        return this.brightScreen;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getUnlock() {
        return this.unlock;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getFloatingWindow() {
        return this.floatingWindow;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getRing() {
        return this.ring;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getShock() {
        return this.shock;
    }

    public final PushConfig copy(boolean enable, String startTime, String endTime, String pushGap, Boolean brightScreen, Boolean unlock, Boolean floatingWindow, Boolean ring, Boolean shock) {
        return new PushConfig(enable, startTime, endTime, pushGap, brightScreen, unlock, floatingWindow, ring, shock);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushConfig)) {
            return false;
        }
        PushConfig pushConfig = (PushConfig) other;
        return this.enable == pushConfig.enable && Intrinsics.c(this.startTime, pushConfig.startTime) && Intrinsics.c(this.endTime, pushConfig.endTime) && Intrinsics.c(this.pushGap, pushConfig.pushGap) && Intrinsics.c(this.brightScreen, pushConfig.brightScreen) && Intrinsics.c(this.unlock, pushConfig.unlock) && Intrinsics.c(this.floatingWindow, pushConfig.floatingWindow) && Intrinsics.c(this.ring, pushConfig.ring) && Intrinsics.c(this.shock, pushConfig.shock);
    }

    public final Boolean getBrightScreen() {
        return this.brightScreen;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Boolean getFloatingWindow() {
        return this.floatingWindow;
    }

    public final String getPushGap() {
        return this.pushGap;
    }

    public final Boolean getRing() {
        return this.ring;
    }

    public final Boolean getShock() {
        return this.shock;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final Boolean getUnlock() {
        return this.unlock;
    }

    public int hashCode() {
        int a11 = e.a(this.enable) * 31;
        String str = this.startTime;
        int hashCode = (a11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.endTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pushGap;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.brightScreen;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.unlock;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.floatingWindow;
        int hashCode6 = (hashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.ring;
        int hashCode7 = (hashCode6 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.shock;
        return hashCode7 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public final void setBrightScreen(Boolean bool) {
        this.brightScreen = bool;
    }

    public final void setEnable(boolean z10) {
        this.enable = z10;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setFloatingWindow(Boolean bool) {
        this.floatingWindow = bool;
    }

    public final void setPushGap(String str) {
        this.pushGap = str;
    }

    public final void setRing(Boolean bool) {
        this.ring = bool;
    }

    public final void setShock(Boolean bool) {
        this.shock = bool;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final void setUnlock(Boolean bool) {
        this.unlock = bool;
    }

    public String toString() {
        return "PushConfig(enable=" + this.enable + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", pushGap=" + this.pushGap + ", brightScreen=" + this.brightScreen + ", unlock=" + this.unlock + ", floatingWindow=" + this.floatingWindow + ", ring=" + this.ring + ", shock=" + this.shock + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.enable ? 1 : 0);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.pushGap);
        Boolean bool = this.brightScreen;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.unlock;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.floatingWindow;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.ring;
        if (bool4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.shock;
        if (bool5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool5.booleanValue() ? 1 : 0);
        }
    }
}
