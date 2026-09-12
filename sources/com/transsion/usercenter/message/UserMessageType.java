package com.transsion.usercenter.message;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.usercenter.message.adapter.a;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/usercenter/message/UserMessageType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ALL", a.I, "LIKE", "LIKE_COMMENT", a.J, a.K, "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class UserMessageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserMessageType[] $VALUES;
    private final String value;
    public static final UserMessageType ALL = new UserMessageType("ALL", 0, "ALL");
    public static final UserMessageType SYSTEM = new UserMessageType(a.I, 1, a.I);
    public static final UserMessageType LIKE = new UserMessageType("LIKE", 2, "LIKE");
    public static final UserMessageType LIKE_COMMENT = new UserMessageType("LIKE_COMMENT", 3, "LIKE_COMMENT");
    public static final UserMessageType COMMENT = new UserMessageType(a.J, 4, a.J);
    public static final UserMessageType REPLY_COMMENT = new UserMessageType(a.K, 5, a.K);

    private static final /* synthetic */ UserMessageType[] $values() {
        return new UserMessageType[]{ALL, SYSTEM, LIKE, LIKE_COMMENT, COMMENT, REPLY_COMMENT};
    }

    static {
        UserMessageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private UserMessageType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<UserMessageType> getEntries() {
        return $ENTRIES;
    }

    public static UserMessageType valueOf(String str) {
        return (UserMessageType) Enum.valueOf(UserMessageType.class, str);
    }

    public static UserMessageType[] values() {
        return (UserMessageType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
