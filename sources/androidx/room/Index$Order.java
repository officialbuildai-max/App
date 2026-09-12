package androidx.room;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"androidx/room/Index$Order", "", "Landroidx/room/Index$Order;", "<init>", "(Ljava/lang/String;I)V", "ASC", "DESC", "room-common"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final class Index$Order {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Index$Order[] $VALUES;
    public static final Index$Order ASC = new Index$Order("ASC", 0);
    public static final Index$Order DESC = new Index$Order("DESC", 1);

    private static final /* synthetic */ Index$Order[] $values() {
        return new Index$Order[]{ASC, DESC};
    }

    static {
        Index$Order[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private Index$Order(String str, int i11) {
    }

    public static EnumEntries<Index$Order> getEntries() {
        return $ENTRIES;
    }

    public static Index$Order valueOf(String str) {
        return (Index$Order) Enum.valueOf(Index$Order.class, str);
    }

    public static Index$Order[] values() {
        return (Index$Order[]) $VALUES.clone();
    }
}
