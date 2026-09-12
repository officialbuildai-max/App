package androidx.room;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"androidx/room/BuiltInTypeConverters$State", "", "Landroidx/room/BuiltInTypeConverters$State;", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "INHERITED", "room-common"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final class BuiltInTypeConverters$State {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BuiltInTypeConverters$State[] $VALUES;
    public static final BuiltInTypeConverters$State ENABLED = new BuiltInTypeConverters$State("ENABLED", 0);
    public static final BuiltInTypeConverters$State DISABLED = new BuiltInTypeConverters$State("DISABLED", 1);
    public static final BuiltInTypeConverters$State INHERITED = new BuiltInTypeConverters$State("INHERITED", 2);

    private static final /* synthetic */ BuiltInTypeConverters$State[] $values() {
        return new BuiltInTypeConverters$State[]{ENABLED, DISABLED, INHERITED};
    }

    static {
        BuiltInTypeConverters$State[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private BuiltInTypeConverters$State(String str, int i11) {
    }

    public static EnumEntries<BuiltInTypeConverters$State> getEntries() {
        return $ENTRIES;
    }

    public static BuiltInTypeConverters$State valueOf(String str) {
        return (BuiltInTypeConverters$State) Enum.valueOf(BuiltInTypeConverters$State.class, str);
    }

    public static BuiltInTypeConverters$State[] values() {
        return (BuiltInTypeConverters$State[]) $VALUES.clone();
    }
}
