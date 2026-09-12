package androidx.work;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/work/ExistingPeriodicWorkPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "REPLACE", "KEEP", "UPDATE", "CANCEL_AND_REENQUEUE", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class ExistingPeriodicWorkPolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $VALUES;

    @Deprecated
    public static final ExistingPeriodicWorkPolicy REPLACE = new ExistingPeriodicWorkPolicy("REPLACE", 0);
    public static final ExistingPeriodicWorkPolicy KEEP = new ExistingPeriodicWorkPolicy("KEEP", 1);
    public static final ExistingPeriodicWorkPolicy UPDATE = new ExistingPeriodicWorkPolicy("UPDATE", 2);
    public static final ExistingPeriodicWorkPolicy CANCEL_AND_REENQUEUE = new ExistingPeriodicWorkPolicy("CANCEL_AND_REENQUEUE", 3);

    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $values() {
        return new ExistingPeriodicWorkPolicy[]{REPLACE, KEEP, UPDATE, CANCEL_AND_REENQUEUE};
    }

    static {
        ExistingPeriodicWorkPolicy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ExistingPeriodicWorkPolicy(String str, int i11) {
    }

    public static EnumEntries<ExistingPeriodicWorkPolicy> getEntries() {
        return $ENTRIES;
    }

    public static ExistingPeriodicWorkPolicy valueOf(String str) {
        return (ExistingPeriodicWorkPolicy) Enum.valueOf(ExistingPeriodicWorkPolicy.class, str);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) $VALUES.clone();
    }
}
