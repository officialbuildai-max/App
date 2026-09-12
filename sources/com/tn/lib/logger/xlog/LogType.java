package com.tn.lib.logger.xlog;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/tn/lib/logger/xlog/LogType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_XLOG", "TYPE_LOGCAT", "report_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class LogType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LogType[] $VALUES;
    public static final LogType TYPE_XLOG = new LogType("TYPE_XLOG", 0);
    public static final LogType TYPE_LOGCAT = new LogType("TYPE_LOGCAT", 1);

    private static final /* synthetic */ LogType[] $values() {
        return new LogType[]{TYPE_XLOG, TYPE_LOGCAT};
    }

    static {
        LogType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LogType(String str, int i11) {
    }

    public static EnumEntries<LogType> getEntries() {
        return $ENTRIES;
    }

    public static LogType valueOf(String str) {
        return (LogType) Enum.valueOf(LogType.class, str);
    }

    public static LogType[] values() {
        return (LogType[]) $VALUES.clone();
    }
}
