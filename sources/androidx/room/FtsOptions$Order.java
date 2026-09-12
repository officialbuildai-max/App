package androidx.room;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"androidx/room/FtsOptions$Order", "", "Landroidx/room/FtsOptions$Order;", "<init>", "(Ljava/lang/String;I)V", "ASC", "DESC", "room-common"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final class FtsOptions$Order {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FtsOptions$Order[] $VALUES;
    public static final FtsOptions$Order ASC = new FtsOptions$Order("ASC", 0);
    public static final FtsOptions$Order DESC = new FtsOptions$Order("DESC", 1);

    private static final /* synthetic */ FtsOptions$Order[] $values() {
        return new FtsOptions$Order[]{ASC, DESC};
    }

    static {
        FtsOptions$Order[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private FtsOptions$Order(String str, int i11) {
    }

    public static EnumEntries<FtsOptions$Order> getEntries() {
        return $ENTRIES;
    }

    public static FtsOptions$Order valueOf(String str) {
        return (FtsOptions$Order) Enum.valueOf(FtsOptions$Order.class, str);
    }

    public static FtsOptions$Order[] values() {
        return (FtsOptions$Order[]) $VALUES.clone();
    }
}
