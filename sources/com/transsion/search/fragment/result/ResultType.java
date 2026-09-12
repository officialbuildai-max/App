package com.transsion.search.fragment.result;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/search/fragment/result/ResultType;", "", "<init>", "(Ljava/lang/String;I)V", "SUBJECT", "STAFF", "GROUP", "VERTICAL_RANK", "TITLE", "MORE", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ResultType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResultType[] $VALUES;
    public static final ResultType SUBJECT = new ResultType("SUBJECT", 0);
    public static final ResultType STAFF = new ResultType("STAFF", 1);
    public static final ResultType GROUP = new ResultType("GROUP", 2);
    public static final ResultType VERTICAL_RANK = new ResultType("VERTICAL_RANK", 3);
    public static final ResultType TITLE = new ResultType("TITLE", 4);
    public static final ResultType MORE = new ResultType("MORE", 5);

    private static final /* synthetic */ ResultType[] $values() {
        return new ResultType[]{SUBJECT, STAFF, GROUP, VERTICAL_RANK, TITLE, MORE};
    }

    static {
        ResultType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ResultType(String str, int i11) {
    }

    public static EnumEntries<ResultType> getEntries() {
        return $ENTRIES;
    }

    public static ResultType valueOf(String str) {
        return (ResultType) Enum.valueOf(ResultType.class, str);
    }

    public static ResultType[] values() {
        return (ResultType[]) $VALUES.clone();
    }
}
