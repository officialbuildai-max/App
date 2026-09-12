package com.transsion.home.p004enum;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsion/home/enum/BottomTabType;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", BottomTabType.TAB_CODE_HOME, "SHORT_TV", "H5TAB", "OPERATION", "DOWNLOAD", BottomTabType.TAB_CODE_PREMIUM, "ROOM", BottomTabType.TAB_CODE_NOVEL, BottomTabType.TAB_CODE_SUBSCRIPTION, BottomTabType.TAB_CODE_ME, "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class BottomTabType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BottomTabType[] $VALUES;
    public static final String TAB_CODE_COMMUNITY = "COMMUNITY";
    public static final String TAB_CODE_DOWNLOAD = "DOWNLOADS";
    public static final String TAB_CODE_MUSIC = "MUSIC";
    public static final String TAB_CODE_SHORT_TV = "SHORTTV";
    public static final String TAB_OPEN_TYPE_LAND_PAGE = "NEW_PAGE";
    public static final String TAB_OPEN_TYPE_TAB = "REDIRECT";
    private final String value;
    public static final String TAB_CODE_HOME = "HOME";
    public static final BottomTabType HOME = new BottomTabType(TAB_CODE_HOME, 0, "BT_HOME");
    public static final BottomTabType SHORT_TV = new BottomTabType("SHORT_TV", 1, "BT_SHORTTV");
    public static final BottomTabType H5TAB = new BottomTabType("H5TAB", 2, "BT_H5");
    public static final BottomTabType OPERATION = new BottomTabType("OPERATION", 3, "BT_OPERATE");
    public static final BottomTabType DOWNLOAD = new BottomTabType("DOWNLOAD", 4, "BT_DOWNLOADS");
    public static final String TAB_CODE_PREMIUM = "PREMIUM";
    public static final BottomTabType PREMIUM = new BottomTabType(TAB_CODE_PREMIUM, 5, "BT_PREMIUM");
    public static final BottomTabType ROOM = new BottomTabType("ROOM", 6, "BT_COMMUNITY");
    public static final String TAB_CODE_NOVEL = "NOVEL";
    public static final BottomTabType NOVEL = new BottomTabType(TAB_CODE_NOVEL, 7, "BT_NOVEL");
    public static final String TAB_CODE_SUBSCRIPTION = "SUBSCRIPTION";
    public static final BottomTabType SUBSCRIPTION = new BottomTabType(TAB_CODE_SUBSCRIPTION, 8, "BT_SUBSCRIPTION");
    public static final String TAB_CODE_ME = "ME";
    public static final BottomTabType ME = new BottomTabType(TAB_CODE_ME, 9, "BT_ME");

    private static final /* synthetic */ BottomTabType[] $values() {
        return new BottomTabType[]{HOME, SHORT_TV, H5TAB, OPERATION, DOWNLOAD, PREMIUM, ROOM, NOVEL, SUBSCRIPTION, ME};
    }

    static {
        BottomTabType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private BottomTabType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<BottomTabType> getEntries() {
        return $ENTRIES;
    }

    public static BottomTabType valueOf(String str) {
        return (BottomTabType) Enum.valueOf(BottomTabType.class, str);
    }

    public static BottomTabType[] values() {
        return (BottomTabType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
