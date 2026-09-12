package com.transsion.base.report.athena;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/transsion/base/report/athena/ClickType;", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DEFAULT", "TAB", "CONTENT", "FEATURE", "DOWNLOAD", "report_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class ClickType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClickType[] $VALUES;
    private final String type;
    public static final ClickType DEFAULT = new ClickType("DEFAULT", 0, "click");
    public static final ClickType TAB = new ClickType("TAB", 1, "tab_click");
    public static final ClickType CONTENT = new ClickType("CONTENT", 2, "content_click");
    public static final ClickType FEATURE = new ClickType("FEATURE", 3, "feature_click");
    public static final ClickType DOWNLOAD = new ClickType("DOWNLOAD", 4, "download_click");

    private static final /* synthetic */ ClickType[] $values() {
        return new ClickType[]{DEFAULT, TAB, CONTENT, FEATURE, DOWNLOAD};
    }

    static {
        ClickType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ClickType(String str, int i11, String str2) {
        this.type = str2;
    }

    public static EnumEntries<ClickType> getEntries() {
        return $ENTRIES;
    }

    public static ClickType valueOf(String str) {
        return (ClickType) Enum.valueOf(ClickType.class, str);
    }

    public static ClickType[] values() {
        return (ClickType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
