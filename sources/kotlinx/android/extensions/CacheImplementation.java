package kotlinx.android.extensions;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class CacheImplementation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CacheImplementation[] $VALUES;
    private static final CacheImplementation DEFAULT;
    public static final CacheImplementation HASH_MAP;
    public static final CacheImplementation NO_CACHE;
    public static final CacheImplementation SPARSE_ARRAY = new CacheImplementation("SPARSE_ARRAY", 0);

    private static final /* synthetic */ CacheImplementation[] $values() {
        return new CacheImplementation[]{SPARSE_ARRAY, HASH_MAP, NO_CACHE};
    }

    static {
        CacheImplementation cacheImplementation = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = cacheImplementation;
        NO_CACHE = new CacheImplementation("NO_CACHE", 2);
        CacheImplementation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
        DEFAULT = cacheImplementation;
    }

    private CacheImplementation(String str, int i11) {
    }

    public static EnumEntries<CacheImplementation> getEntries() {
        return $ENTRIES;
    }

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }
}
