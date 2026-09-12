package com.transsion.home.bean;

import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/home/bean/HomePreferencesRefreshType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ALL_TOP_TAB", "CUR_PAGE", "NO_REFRESH", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class HomePreferencesRefreshType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HomePreferencesRefreshType[] $VALUES;
    public static final HomePreferencesRefreshType ALL_TOP_TAB = new HomePreferencesRefreshType("ALL_TOP_TAB", 0, "AllTopTab");
    public static final HomePreferencesRefreshType CUR_PAGE = new HomePreferencesRefreshType("CUR_PAGE", 1, "CurPage");
    public static final HomePreferencesRefreshType NO_REFRESH = new HomePreferencesRefreshType("NO_REFRESH", 2, "NoRefresh");
    private final String value;

    private static final /* synthetic */ HomePreferencesRefreshType[] $values() {
        return new HomePreferencesRefreshType[]{ALL_TOP_TAB, CUR_PAGE, NO_REFRESH};
    }

    static {
        HomePreferencesRefreshType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private HomePreferencesRefreshType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<HomePreferencesRefreshType> getEntries() {
        return $ENTRIES;
    }

    public static HomePreferencesRefreshType valueOf(String str) {
        return (HomePreferencesRefreshType) Enum.valueOf(HomePreferencesRefreshType.class, str);
    }

    public static HomePreferencesRefreshType[] values() {
        return (HomePreferencesRefreshType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
