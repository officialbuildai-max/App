package com.transsion.memberapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001f"}, d2 = {"Lcom/transsion/memberapi/MemberSource;", "Landroid/os/Parcelable;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SOURCE_HDDL", "SOURCE_MULTI_DL", "SOURCE_AD_DIALOG", "SOURCE_DOWNLOAD_DIALOG", "SOURCE_LANDSCAPE_PLAY", "SOURCE_OTHER_DOWNLOAD_DIALOG", "SOURCE_AD", "THREE_IN_ONE_POPUP", "SOURCE_STREAM_RESOLUTION_DIALOG", "SOURCE_STREAM_RESOLUTION_TIP", "SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR", "SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG", "SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT", "SOURCE_MEMBER_PROMOTION", "toString", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class MemberSource implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemberSource[] $VALUES;
    public static final Parcelable.Creator<MemberSource> CREATOR;
    private final String value;
    public static final MemberSource SOURCE_HDDL = new MemberSource("SOURCE_HDDL", 0, "HDDL");
    public static final MemberSource SOURCE_MULTI_DL = new MemberSource("SOURCE_MULTI_DL", 1, "Multi_DL_DIALOG");
    public static final MemberSource SOURCE_AD_DIALOG = new MemberSource("SOURCE_AD_DIALOG", 2, "AD_DIALOG");
    public static final MemberSource SOURCE_DOWNLOAD_DIALOG = new MemberSource("SOURCE_DOWNLOAD_DIALOG", 3, "DOWNLOAD_DIALOG");
    public static final MemberSource SOURCE_LANDSCAPE_PLAY = new MemberSource("SOURCE_LANDSCAPE_PLAY", 4, "LANDSCAPE_PLAY");
    public static final MemberSource SOURCE_OTHER_DOWNLOAD_DIALOG = new MemberSource("SOURCE_OTHER_DOWNLOAD_DIALOG", 5, "OTHER_DOWNLOAD_DIALOG");
    public static final MemberSource SOURCE_AD = new MemberSource("SOURCE_AD", 6, "SOURCE_AD");
    public static final MemberSource THREE_IN_ONE_POPUP = new MemberSource("THREE_IN_ONE_POPUP", 7, "THREE_IN_ONE_POPUP");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_DIALOG = new MemberSource("SOURCE_STREAM_RESOLUTION_DIALOG", 8, "STREAM_RESOLUTION_DIALOG");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_TIP = new MemberSource("SOURCE_STREAM_RESOLUTION_TIP", 9, "STREAM_RESOLUTION_TIP");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR = new MemberSource("SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR", 10, "SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG = new MemberSource("SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG", 11, "SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT = new MemberSource("SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT", 12, "SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT");
    public static final MemberSource SOURCE_MEMBER_PROMOTION = new MemberSource("SOURCE_MEMBER_PROMOTION", 13, "MEMBER_PROMOTION");

    private static final /* synthetic */ MemberSource[] $values() {
        return new MemberSource[]{SOURCE_HDDL, SOURCE_MULTI_DL, SOURCE_AD_DIALOG, SOURCE_DOWNLOAD_DIALOG, SOURCE_LANDSCAPE_PLAY, SOURCE_OTHER_DOWNLOAD_DIALOG, SOURCE_AD, THREE_IN_ONE_POPUP, SOURCE_STREAM_RESOLUTION_DIALOG, SOURCE_STREAM_RESOLUTION_TIP, SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR, SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG, SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT, SOURCE_MEMBER_PROMOTION};
    }

    static {
        MemberSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        CREATOR = new Parcelable.Creator() { // from class: com.transsion.memberapi.MemberSource.a
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MemberSource createFromParcel(Parcel parcel) {
                Intrinsics.h(parcel, "parcel");
                return MemberSource.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MemberSource[] newArray(int i11) {
                return new MemberSource[i11];
            }
        };
    }

    private MemberSource(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<MemberSource> getEntries() {
        return $ENTRIES;
    }

    public static MemberSource valueOf(String str) {
        return (MemberSource) Enum.valueOf(MemberSource.class, str);
    }

    public static MemberSource[] values() {
        return (MemberSource[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(name());
    }
}
