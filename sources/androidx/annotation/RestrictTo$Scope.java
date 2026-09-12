package androidx.annotation;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"androidx/annotation/RestrictTo$Scope", "", "Landroidx/annotation/RestrictTo$Scope;", "<init>", "(Ljava/lang/String;I)V", "LIBRARY", "LIBRARY_GROUP", "LIBRARY_GROUP_PREFIX", "GROUP_ID", "TESTS", "SUBCLASSES", "annotation"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class RestrictTo$Scope {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RestrictTo$Scope[] $VALUES;
    public static final RestrictTo$Scope LIBRARY = new RestrictTo$Scope("LIBRARY", 0);
    public static final RestrictTo$Scope LIBRARY_GROUP = new RestrictTo$Scope("LIBRARY_GROUP", 1);
    public static final RestrictTo$Scope LIBRARY_GROUP_PREFIX = new RestrictTo$Scope("LIBRARY_GROUP_PREFIX", 2);

    @Deprecated
    public static final RestrictTo$Scope GROUP_ID = new RestrictTo$Scope("GROUP_ID", 3);
    public static final RestrictTo$Scope TESTS = new RestrictTo$Scope("TESTS", 4);
    public static final RestrictTo$Scope SUBCLASSES = new RestrictTo$Scope("SUBCLASSES", 5);

    private static final /* synthetic */ RestrictTo$Scope[] $values() {
        return new RestrictTo$Scope[]{LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, SUBCLASSES};
    }

    static {
        RestrictTo$Scope[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RestrictTo$Scope(String str, int i11) {
    }

    public static EnumEntries<RestrictTo$Scope> getEntries() {
        return $ENTRIES;
    }

    public static RestrictTo$Scope valueOf(String str) {
        return (RestrictTo$Scope) Enum.valueOf(RestrictTo$Scope.class, str);
    }

    public static RestrictTo$Scope[] values() {
        return (RestrictTo$Scope[]) $VALUES.clone();
    }
}
