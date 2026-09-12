package com.google.firebase.logger;

import com.hisavana.common.tracking.TrackingKey;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"com/google/firebase/logger/Logger$Level", "", "Lcom/google/firebase/logger/Logger$Level;", "", TrackingKey.PRIORITY, "<init>", "(Ljava/lang/String;II)V", "I", "getPriority$com_google_firebase_firebase_common", "()I", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "com.google.firebase-firebase-common"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes4.dex */
public final class Logger$Level {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Logger$Level[] $VALUES;
    private final int priority;
    public static final Logger$Level VERBOSE = new Logger$Level("VERBOSE", 0, 2);
    public static final Logger$Level DEBUG = new Logger$Level("DEBUG", 1, 3);
    public static final Logger$Level INFO = new Logger$Level("INFO", 2, 4);
    public static final Logger$Level WARN = new Logger$Level("WARN", 3, 5);
    public static final Logger$Level ERROR = new Logger$Level("ERROR", 4, 6);

    private static final /* synthetic */ Logger$Level[] $values() {
        return new Logger$Level[]{VERBOSE, DEBUG, INFO, WARN, ERROR};
    }

    static {
        Logger$Level[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private Logger$Level(String str, int i11, int i12) {
        this.priority = i12;
    }

    public static EnumEntries<Logger$Level> getEntries() {
        return $ENTRIES;
    }

    public static Logger$Level valueOf(String str) {
        return (Logger$Level) Enum.valueOf(Logger$Level.class, str);
    }

    public static Logger$Level[] values() {
        return (Logger$Level[]) $VALUES.clone();
    }

    /* renamed from: getPriority$com_google_firebase_firebase_common, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }
}
