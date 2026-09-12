package com.transsion.mbwidget.data;

import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.transsion.home.adapter.trending.adapter.SportLiveAdapter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/mbwidget/data/MatchStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "NOT_START", "ING", "ENDED", NetworkUtil.NETWORK_TYPE_UNKNOWN, "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class MatchStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MatchStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final MatchStatus NOT_START = new MatchStatus("NOT_START", 0);
    public static final MatchStatus ING = new MatchStatus("ING", 1);
    public static final MatchStatus ENDED = new MatchStatus("ENDED", 2);
    public static final MatchStatus UNKNOWN = new MatchStatus(NetworkUtil.NETWORK_TYPE_UNKNOWN, 3);

    /* renamed from: com.transsion.mbwidget.data.MatchStatus$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MatchStatus a(String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -460443627) {
                    if (hashCode != 361535485) {
                        if (hashCode == 884395540 && str.equals(SportLiveAdapter.N)) {
                            return MatchStatus.NOT_START;
                        }
                    } else if (str.equals(SportLiveAdapter.O)) {
                        return MatchStatus.ING;
                    }
                } else if (str.equals(SportLiveAdapter.P)) {
                    return MatchStatus.ENDED;
                }
            }
            return MatchStatus.UNKNOWN;
        }
    }

    private static final /* synthetic */ MatchStatus[] $values() {
        return new MatchStatus[]{NOT_START, ING, ENDED, UNKNOWN};
    }

    static {
        MatchStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private MatchStatus(String str, int i11) {
    }

    public static EnumEntries<MatchStatus> getEntries() {
        return $ENTRIES;
    }

    public static MatchStatus valueOf(String str) {
        return (MatchStatus) Enum.valueOf(MatchStatus.class, str);
    }

    public static MatchStatus[] values() {
        return (MatchStatus[]) $VALUES.clone();
    }
}
