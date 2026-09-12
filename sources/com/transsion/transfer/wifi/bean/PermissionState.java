package com.transsion.transfer.wifi.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/transfer/wifi/bean/PermissionState;", "", "state", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "PERMISSION_GRANTED", "PERMISSION_DENIED", "PERMISSION_REQUEST", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class PermissionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionState[] $VALUES;
    private final String state;
    public static final PermissionState PERMISSION_GRANTED = new PermissionState("PERMISSION_GRANTED", 0, "granted");
    public static final PermissionState PERMISSION_DENIED = new PermissionState("PERMISSION_DENIED", 1, "denied");
    public static final PermissionState PERMISSION_REQUEST = new PermissionState("PERMISSION_REQUEST", 2, "request");

    private static final /* synthetic */ PermissionState[] $values() {
        return new PermissionState[]{PERMISSION_GRANTED, PERMISSION_DENIED, PERMISSION_REQUEST};
    }

    static {
        PermissionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PermissionState(String str, int i11, String str2) {
        this.state = str2;
    }

    public static EnumEntries<PermissionState> getEntries() {
        return $ENTRIES;
    }

    public static PermissionState valueOf(String str) {
        return (PermissionState) Enum.valueOf(PermissionState.class, str);
    }

    public static PermissionState[] values() {
        return (PermissionState[]) $VALUES.clone();
    }

    public final String getState() {
        return this.state;
    }
}
