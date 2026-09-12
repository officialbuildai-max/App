package androidx.room;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"androidx/room/FtsOptions$MatchInfo", "", "Landroidx/room/FtsOptions$MatchInfo;", "<init>", "(Ljava/lang/String;I)V", "FTS3", "FTS4", "room-common"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final class FtsOptions$MatchInfo {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FtsOptions$MatchInfo[] $VALUES;
    public static final FtsOptions$MatchInfo FTS3 = new FtsOptions$MatchInfo("FTS3", 0);
    public static final FtsOptions$MatchInfo FTS4 = new FtsOptions$MatchInfo("FTS4", 1);

    private static final /* synthetic */ FtsOptions$MatchInfo[] $values() {
        return new FtsOptions$MatchInfo[]{FTS3, FTS4};
    }

    static {
        FtsOptions$MatchInfo[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private FtsOptions$MatchInfo(String str, int i11) {
    }

    public static EnumEntries<FtsOptions$MatchInfo> getEntries() {
        return $ENTRIES;
    }

    public static FtsOptions$MatchInfo valueOf(String str) {
        return (FtsOptions$MatchInfo) Enum.valueOf(FtsOptions$MatchInfo.class, str);
    }

    public static FtsOptions$MatchInfo[] values() {
        return (FtsOptions$MatchInfo[]) $VALUES.clone();
    }
}
