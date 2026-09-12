package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsion/memberapi/MembershipDuration;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "DAY", "WEEK", "MONTH", "QUARTER", "HALF_YEAR", "YEAR", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class MembershipDuration {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MembershipDuration[] $VALUES;
    private final int value;
    public static final MembershipDuration DAY = new MembershipDuration("DAY", 0, 1);
    public static final MembershipDuration WEEK = new MembershipDuration("WEEK", 1, 2);
    public static final MembershipDuration MONTH = new MembershipDuration("MONTH", 2, 3);
    public static final MembershipDuration QUARTER = new MembershipDuration("QUARTER", 3, 4);
    public static final MembershipDuration HALF_YEAR = new MembershipDuration("HALF_YEAR", 4, 5);
    public static final MembershipDuration YEAR = new MembershipDuration("YEAR", 5, 6);

    private static final /* synthetic */ MembershipDuration[] $values() {
        return new MembershipDuration[]{DAY, WEEK, MONTH, QUARTER, HALF_YEAR, YEAR};
    }

    static {
        MembershipDuration[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private MembershipDuration(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<MembershipDuration> getEntries() {
        return $ENTRIES;
    }

    public static MembershipDuration valueOf(String str) {
        return (MembershipDuration) Enum.valueOf(MembershipDuration.class, str);
    }

    public static MembershipDuration[] values() {
        return (MembershipDuration[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
