package com.transsion.home.p004enum;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/transsion/home/enum/HomeTabType;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "TRENDING", "SUBJECT", "H5TAB", "SUB_OPERATION", "SUB_ROOM", "TV_CHANNEL_TAB", "SUB_SPORTS_LIVE", "SUB_NOVEL", "SHORT_TV_TAB", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class HomeTabType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HomeTabType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final HomeTabType TRENDING = new HomeTabType("TRENDING", 0, "TrenTab");
    public static final HomeTabType SUBJECT = new HomeTabType("SUBJECT", 1, "SubjTab");
    public static final HomeTabType H5TAB = new HomeTabType("H5TAB", 2, "H5Tab");
    public static final HomeTabType SUB_OPERATION = new HomeTabType("SUB_OPERATION", 3, "OperateTab");
    public static final HomeTabType SUB_ROOM = new HomeTabType("SUB_ROOM", 4, "CommunityTab");
    public static final HomeTabType TV_CHANNEL_TAB = new HomeTabType("TV_CHANNEL_TAB", 5, "TVChannelTab");
    public static final HomeTabType SUB_SPORTS_LIVE = new HomeTabType("SUB_SPORTS_LIVE", 6, "LiveTab");
    public static final HomeTabType SUB_NOVEL = new HomeTabType("SUB_NOVEL", 7, "NovelTab");
    public static final HomeTabType SHORT_TV_TAB = new HomeTabType("SHORT_TV_TAB", 8, "ShortTvTab");

    /* renamed from: com.transsion.home.enum.HomeTabType$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HomeTabType a(String str) {
            Object obj;
            Iterator<E> it = HomeTabType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.c(((HomeTabType) obj).getValue(), str)) {
                    break;
                }
            }
            return (HomeTabType) obj;
        }
    }

    private static final /* synthetic */ HomeTabType[] $values() {
        return new HomeTabType[]{TRENDING, SUBJECT, H5TAB, SUB_OPERATION, SUB_ROOM, TV_CHANNEL_TAB, SUB_SPORTS_LIVE, SUB_NOVEL, SHORT_TV_TAB};
    }

    static {
        HomeTabType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private HomeTabType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<HomeTabType> getEntries() {
        return $ENTRIES;
    }

    public static HomeTabType valueOf(String str) {
        return (HomeTabType) Enum.valueOf(HomeTabType.class, str);
    }

    public static HomeTabType[] values() {
        return (HomeTabType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
