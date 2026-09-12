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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/home/bean/HomePreferencesShowStyle;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OPT_INSERT", "POPUP", "ENTER_POP", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class HomePreferencesShowStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HomePreferencesShowStyle[] $VALUES;
    private final String value;
    public static final HomePreferencesShowStyle OPT_INSERT = new HomePreferencesShowStyle("OPT_INSERT", 0, "OptInsert");
    public static final HomePreferencesShowStyle POPUP = new HomePreferencesShowStyle("POPUP", 1, "Popup");
    public static final HomePreferencesShowStyle ENTER_POP = new HomePreferencesShowStyle("ENTER_POP", 2, "Bootstrap");

    private static final /* synthetic */ HomePreferencesShowStyle[] $values() {
        return new HomePreferencesShowStyle[]{OPT_INSERT, POPUP, ENTER_POP};
    }

    static {
        HomePreferencesShowStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private HomePreferencesShowStyle(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<HomePreferencesShowStyle> getEntries() {
        return $ENTRIES;
    }

    public static HomePreferencesShowStyle valueOf(String str) {
        return (HomePreferencesShowStyle) Enum.valueOf(HomePreferencesShowStyle.class, str);
    }

    public static HomePreferencesShowStyle[] values() {
        return (HomePreferencesShowStyle[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
