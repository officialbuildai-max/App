package com.transsion.shorttv_pugc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006("}, d2 = {"Lcom/transsion/shorttv_pugc/bean/PlayListIcon;", "Landroid/os/Parcelable;", TtmlNode.ATTR_TTS_COLOR, "", "iconUrl", "isPic", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "()Ljava/lang/Boolean;", "setPic", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "setName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/transsion/shorttv_pugc/bean/PlayListIcon;", "describeContents", "", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final /* data */ class PlayListIcon implements Parcelable {
    public static final Parcelable.Creator<PlayListIcon> CREATOR = new a();
    private String color;
    private String iconUrl;
    private Boolean isPic;
    private String name;

    /* loaded from: classes6.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListIcon createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.h(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PlayListIcon(readString, readString2, valueOf, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListIcon[] newArray(int i11) {
            return new PlayListIcon[i11];
        }
    }

    public PlayListIcon(String str, String str2, Boolean bool, String str3) {
        this.color = str;
        this.iconUrl = str2;
        this.isPic = bool;
        this.name = str3;
    }

    public static /* synthetic */ PlayListIcon copy$default(PlayListIcon playListIcon, String str, String str2, Boolean bool, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = playListIcon.color;
        }
        if ((i11 & 2) != 0) {
            str2 = playListIcon.iconUrl;
        }
        if ((i11 & 4) != 0) {
            bool = playListIcon.isPic;
        }
        if ((i11 & 8) != 0) {
            str3 = playListIcon.name;
        }
        return playListIcon.copy(str, str2, bool, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsPic() {
        return this.isPic;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final PlayListIcon copy(String color, String iconUrl, Boolean isPic, String name) {
        return new PlayListIcon(color, iconUrl, isPic, name);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayListIcon)) {
            return false;
        }
        PlayListIcon playListIcon = (PlayListIcon) other;
        return Intrinsics.c(this.color, playListIcon.color) && Intrinsics.c(this.iconUrl, playListIcon.iconUrl) && Intrinsics.c(this.isPic, playListIcon.isPic) && Intrinsics.c(this.name, playListIcon.name);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.color;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isPic;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.name;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final Boolean isPic() {
        return this.isPic;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPic(Boolean bool) {
        this.isPic = bool;
    }

    public String toString() {
        return "PlayListIcon(color=" + this.color + ", iconUrl=" + this.iconUrl + ", isPic=" + this.isPic + ", name=" + this.name + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int i11;
        Intrinsics.h(dest, "dest");
        dest.writeString(this.color);
        dest.writeString(this.iconUrl);
        Boolean bool = this.isPic;
        if (bool == null) {
            i11 = 0;
        } else {
            dest.writeInt(1);
            i11 = bool.booleanValue();
        }
        dest.writeInt(i11);
        dest.writeString(this.name);
    }
}
