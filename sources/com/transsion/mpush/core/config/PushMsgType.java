package com.transsion.mpush.core.config;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/mpush/core/config/PushMsgType;", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "LOCAL_PUSH", "DOWNLOAD_PUSH", "PERMANENT", "TOP10_PUSH", "SUBJECT_SEEKING", "ONLINE_JSON_PUSH", "FIREBASE_PUSH", "MBPush_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class PushMsgType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PushMsgType[] $VALUES;
    private final String type;
    public static final PushMsgType LOCAL_PUSH = new PushMsgType("LOCAL_PUSH", 0, "1");
    public static final PushMsgType DOWNLOAD_PUSH = new PushMsgType("DOWNLOAD_PUSH", 1, "4");
    public static final PushMsgType PERMANENT = new PushMsgType("PERMANENT", 2, "5");
    public static final PushMsgType TOP10_PUSH = new PushMsgType("TOP10_PUSH", 3, PrepareException.ERROR_NO_URL);
    public static final PushMsgType SUBJECT_SEEKING = new PushMsgType("SUBJECT_SEEKING", 4, "10");
    public static final PushMsgType ONLINE_JSON_PUSH = new PushMsgType("ONLINE_JSON_PUSH", 5, PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY);
    public static final PushMsgType FIREBASE_PUSH = new PushMsgType("FIREBASE_PUSH", 6, "101");

    private static final /* synthetic */ PushMsgType[] $values() {
        return new PushMsgType[]{LOCAL_PUSH, DOWNLOAD_PUSH, PERMANENT, TOP10_PUSH, SUBJECT_SEEKING, ONLINE_JSON_PUSH, FIREBASE_PUSH};
    }

    static {
        PushMsgType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PushMsgType(String str, int i11, String str2) {
        this.type = str2;
    }

    public static EnumEntries<PushMsgType> getEntries() {
        return $ENTRIES;
    }

    public static PushMsgType valueOf(String str) {
        return (PushMsgType) Enum.valueOf(PushMsgType.class, str);
    }

    public static PushMsgType[] values() {
        return (PushMsgType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
