package com.transsion.lib_web.domain;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/transsion/lib_web/domain/LoadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "LOADING", "SUCCESS", "FAILED", "SUBSEQUENT", "lib_web_release"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class LoadStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoadStatus[] $VALUES;
    public static final LoadStatus INIT = new LoadStatus("INIT", 0);
    public static final LoadStatus LOADING = new LoadStatus("LOADING", 1);
    public static final LoadStatus SUCCESS = new LoadStatus("SUCCESS", 2);
    public static final LoadStatus FAILED = new LoadStatus("FAILED", 3);
    public static final LoadStatus SUBSEQUENT = new LoadStatus("SUBSEQUENT", 4);

    private static final /* synthetic */ LoadStatus[] $values() {
        return new LoadStatus[]{INIT, LOADING, SUCCESS, FAILED, SUBSEQUENT};
    }

    static {
        LoadStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LoadStatus(String str, int i11) {
    }

    public static EnumEntries<LoadStatus> getEntries() {
        return $ENTRIES;
    }

    public static LoadStatus valueOf(String str) {
        return (LoadStatus) Enum.valueOf(LoadStatus.class, str);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) $VALUES.clone();
    }
}
