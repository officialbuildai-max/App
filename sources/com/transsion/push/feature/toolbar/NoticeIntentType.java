package com.transsion.push.feature.toolbar;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/push/feature/toolbar/NoticeIntentType;", "", "<init>", "(Ljava/lang/String;I)V", "SEARCH", "TOP_10", "SETTING", "CONTENT", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class NoticeIntentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NoticeIntentType[] $VALUES;
    public static final NoticeIntentType SEARCH = new NoticeIntentType("SEARCH", 0);
    public static final NoticeIntentType TOP_10 = new NoticeIntentType("TOP_10", 1);
    public static final NoticeIntentType SETTING = new NoticeIntentType("SETTING", 2);
    public static final NoticeIntentType CONTENT = new NoticeIntentType("CONTENT", 3);

    private static final /* synthetic */ NoticeIntentType[] $values() {
        return new NoticeIntentType[]{SEARCH, TOP_10, SETTING, CONTENT};
    }

    static {
        NoticeIntentType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private NoticeIntentType(String str, int i11) {
    }

    public static EnumEntries<NoticeIntentType> getEntries() {
        return $ENTRIES;
    }

    public static NoticeIntentType valueOf(String str) {
        return (NoticeIntentType) Enum.valueOf(NoticeIntentType.class, str);
    }

    public static NoticeIntentType[] values() {
        return (NoticeIntentType[]) $VALUES.clone();
    }
}
