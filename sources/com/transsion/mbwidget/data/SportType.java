package com.transsion.mbwidget.data;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/transsion/mbwidget/data/SportType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "FOOTBALL", "CRICKET", "BASKETBALL", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class SportType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SportType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final SportType FOOTBALL = new SportType("FOOTBALL", 0);
    public static final SportType CRICKET = new SportType("CRICKET", 1);
    public static final SportType BASKETBALL = new SportType("BASKETBALL", 2);

    /* renamed from: com.transsion.mbwidget.data.SportType$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SportType a(String str) {
            String str2;
            if (str != null) {
                str2 = str.toLowerCase(Locale.ROOT);
                Intrinsics.g(str2, "toLowerCase(...)");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                return null;
            }
            int hashCode = str2.hashCode();
            if (hashCode == 394668909) {
                if (str2.equals("football")) {
                    return SportType.FOOTBALL;
                }
                return null;
            }
            if (hashCode == 727149765) {
                if (str2.equals("basketball")) {
                    return SportType.BASKETBALL;
                }
                return null;
            }
            if (hashCode == 1032299505 && str2.equals("cricket")) {
                return SportType.CRICKET;
            }
            return null;
        }
    }

    private static final /* synthetic */ SportType[] $values() {
        return new SportType[]{FOOTBALL, CRICKET, BASKETBALL};
    }

    static {
        SportType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private SportType(String str, int i11) {
    }

    public static EnumEntries<SportType> getEntries() {
        return $ENTRIES;
    }

    public static SportType valueOf(String str) {
        return (SportType) Enum.valueOf(SportType.class, str);
    }

    public static SportType[] values() {
        return (SportType[]) $VALUES.clone();
    }
}
