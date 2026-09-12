package com.transsion.share.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/share/bean/ShareType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DELETE", "DOWNLOAD", "COPY_LINK", "WHATSAPP", "CHECKOUT", "TELEGRAM", "REPORT", "ShareLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ShareType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShareType[] $VALUES;
    private final int value;
    public static final ShareType DELETE = new ShareType("DELETE", 0, -1);
    public static final ShareType DOWNLOAD = new ShareType("DOWNLOAD", 1, 0);
    public static final ShareType COPY_LINK = new ShareType("COPY_LINK", 2, 2);
    public static final ShareType WHATSAPP = new ShareType("WHATSAPP", 3, 4);
    public static final ShareType CHECKOUT = new ShareType("CHECKOUT", 4, 5);
    public static final ShareType TELEGRAM = new ShareType("TELEGRAM", 5, 10);
    public static final ShareType REPORT = new ShareType("REPORT", 6, 11);

    private static final /* synthetic */ ShareType[] $values() {
        return new ShareType[]{DELETE, DOWNLOAD, COPY_LINK, WHATSAPP, CHECKOUT, TELEGRAM, REPORT};
    }

    static {
        ShareType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ShareType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<ShareType> getEntries() {
        return $ENTRIES;
    }

    public static ShareType valueOf(String str) {
        return (ShareType) Enum.valueOf(ShareType.class, str);
    }

    public static ShareType[] values() {
        return (ShareType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
