package com.tn.lib.net.annotation;

import com.google.android.gms.stats.CodePackage;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/tn/lib/net/annotation/ApiType;", "", "<init>", "(Ljava/lang/String;I)V", CodePackage.COMMON, "WITH_DOT", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class ApiType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiType[] $VALUES;
    public static final ApiType COMMON = new ApiType(CodePackage.COMMON, 0);
    public static final ApiType WITH_DOT = new ApiType("WITH_DOT", 1);

    private static final /* synthetic */ ApiType[] $values() {
        return new ApiType[]{COMMON, WITH_DOT};
    }

    static {
        ApiType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ApiType(String str, int i11) {
    }

    public static EnumEntries<ApiType> getEntries() {
        return $ENTRIES;
    }

    public static ApiType valueOf(String str) {
        return (ApiType) Enum.valueOf(ApiType.class, str);
    }

    public static ApiType[] values() {
        return (ApiType[]) $VALUES.clone();
    }
}
