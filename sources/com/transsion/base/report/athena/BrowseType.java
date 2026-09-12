package com.transsion.base.report.athena;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/base/report/athena/BrowseType;", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DEFAULT", "TAB", "CONTENT", "FEATURE", "report_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class BrowseType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BrowseType[] $VALUES;
    private final String type;
    public static final BrowseType DEFAULT = new BrowseType("DEFAULT", 0, "browse");
    public static final BrowseType TAB = new BrowseType("TAB", 1, "tab_browse");
    public static final BrowseType CONTENT = new BrowseType("CONTENT", 2, "content_browse");
    public static final BrowseType FEATURE = new BrowseType("FEATURE", 3, "feature_browse");

    private static final /* synthetic */ BrowseType[] $values() {
        return new BrowseType[]{DEFAULT, TAB, CONTENT, FEATURE};
    }

    static {
        BrowseType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private BrowseType(String str, int i11, String str2) {
        this.type = str2;
    }

    public static EnumEntries<BrowseType> getEntries() {
        return $ENTRIES;
    }

    public static BrowseType valueOf(String str) {
        return (BrowseType) Enum.valueOf(BrowseType.class, str);
    }

    public static BrowseType[] values() {
        return (BrowseType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
