package com.transsion.usercenterapi;

import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.usercenter.message.adapter.a;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/usercenterapi/ReportType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", NetworkUtil.NETWORK_TYPE_UNKNOWN, "USER", "POST", "GROUP", "SUBJECT", a.J, "STAFF", "UFC_VIDEO", "UserCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class ReportType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReportType[] $VALUES;
    private final String value;
    public static final ReportType UNKNOWN = new ReportType(NetworkUtil.NETWORK_TYPE_UNKNOWN, 0, "TYPE_UNKNOWN");
    public static final ReportType USER = new ReportType("USER", 1, "TYPE_USER");
    public static final ReportType POST = new ReportType("POST", 2, "TYPE_POST");
    public static final ReportType GROUP = new ReportType("GROUP", 3, "TYPE_GROUP");
    public static final ReportType SUBJECT = new ReportType("SUBJECT", 4, "TYPE_SUBJECT");
    public static final ReportType COMMENT = new ReportType(a.J, 5, "TYPE_COMMENT");
    public static final ReportType STAFF = new ReportType("STAFF", 6, "TYPE_STAFF");
    public static final ReportType UFC_VIDEO = new ReportType("UFC_VIDEO", 7, "TYPE_UGC_VIDEO");

    private static final /* synthetic */ ReportType[] $values() {
        return new ReportType[]{UNKNOWN, USER, POST, GROUP, SUBJECT, COMMENT, STAFF, UFC_VIDEO};
    }

    static {
        ReportType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ReportType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<ReportType> getEntries() {
        return $ENTRIES;
    }

    public static ReportType valueOf(String str) {
        return (ReportType) Enum.valueOf(ReportType.class, str);
    }

    public static ReportType[] values() {
        return (ReportType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
