package androidx.work;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/work/BackoffPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "EXPONENTIAL", "LINEAR", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class BackoffPolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackoffPolicy[] $VALUES;
    public static final BackoffPolicy EXPONENTIAL = new BackoffPolicy("EXPONENTIAL", 0);
    public static final BackoffPolicy LINEAR = new BackoffPolicy("LINEAR", 1);

    private static final /* synthetic */ BackoffPolicy[] $values() {
        return new BackoffPolicy[]{EXPONENTIAL, LINEAR};
    }

    static {
        BackoffPolicy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private BackoffPolicy(String str, int i11) {
    }

    public static EnumEntries<BackoffPolicy> getEntries() {
        return $ENTRIES;
    }

    public static BackoffPolicy valueOf(String str) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, str);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) $VALUES.clone();
    }
}
