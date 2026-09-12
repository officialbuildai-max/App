package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.home.p004enum.BottomTabType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/memberapi/MemberType;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "GUEST", "TRIAL", BottomTabType.TAB_CODE_PREMIUM, "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class MemberType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemberType[] $VALUES;
    private final int value;
    public static final MemberType GUEST = new MemberType("GUEST", 0, 0);
    public static final MemberType TRIAL = new MemberType("TRIAL", 1, 1);
    public static final MemberType PREMIUM = new MemberType(BottomTabType.TAB_CODE_PREMIUM, 2, 2);

    private static final /* synthetic */ MemberType[] $values() {
        return new MemberType[]{GUEST, TRIAL, PREMIUM};
    }

    static {
        MemberType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private MemberType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<MemberType> getEntries() {
        return $ENTRIES;
    }

    public static MemberType valueOf(String str) {
        return (MemberType) Enum.valueOf(MemberType.class, str);
    }

    public static MemberType[] values() {
        return (MemberType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
