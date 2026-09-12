package com.transsion.base.infras_config.model;

import com.google.gson.annotations.SerializedName;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/base/infras_config/model/ConfigInitRspCode;", "", "<init>", "(Ljava/lang/String;I)V", "IRC_UNKNOWN", "IRC_NOT_MODIFIED", "IRC_MODIFIED", "base_infras_config_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class ConfigInitRspCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfigInitRspCode[] $VALUES;

    @SerializedName("IRC_UNKNOWN")
    public static final ConfigInitRspCode IRC_UNKNOWN = new ConfigInitRspCode("IRC_UNKNOWN", 0);

    @SerializedName("IRC_NOT_MODIFIED")
    public static final ConfigInitRspCode IRC_NOT_MODIFIED = new ConfigInitRspCode("IRC_NOT_MODIFIED", 1);

    @SerializedName("IRC_MODIFIED")
    public static final ConfigInitRspCode IRC_MODIFIED = new ConfigInitRspCode("IRC_MODIFIED", 2);

    private static final /* synthetic */ ConfigInitRspCode[] $values() {
        return new ConfigInitRspCode[]{IRC_UNKNOWN, IRC_NOT_MODIFIED, IRC_MODIFIED};
    }

    static {
        ConfigInitRspCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ConfigInitRspCode(String str, int i11) {
    }

    public static EnumEntries<ConfigInitRspCode> getEntries() {
        return $ENTRIES;
    }

    public static ConfigInitRspCode valueOf(String str) {
        return (ConfigInitRspCode) Enum.valueOf(ConfigInitRspCode.class, str);
    }

    public static ConfigInitRspCode[] values() {
        return (ConfigInitRspCode[]) $VALUES.clone();
    }
}
