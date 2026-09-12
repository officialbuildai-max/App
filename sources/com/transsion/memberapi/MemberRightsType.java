package com.transsion.memberapi;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/transsion/memberapi/MemberRightsType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "baisc", "pro", "feature", "toString", "", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class MemberRightsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemberRightsType[] $VALUES;
    private final int value;
    public static final MemberRightsType baisc = new MemberRightsType("baisc", 0, 1);
    public static final MemberRightsType pro = new MemberRightsType("pro", 1, 2);
    public static final MemberRightsType feature = new MemberRightsType("feature", 2, 3);

    private static final /* synthetic */ MemberRightsType[] $values() {
        return new MemberRightsType[]{baisc, pro, feature};
    }

    static {
        MemberRightsType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private MemberRightsType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<MemberRightsType> getEntries() {
        return $ENTRIES;
    }

    public static MemberRightsType valueOf(String str) {
        return (MemberRightsType) Enum.valueOf(MemberRightsType.class, str);
    }

    public static MemberRightsType[] values() {
        return (MemberRightsType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.value);
    }
}
