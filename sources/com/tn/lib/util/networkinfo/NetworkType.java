package com.tn.lib.util.networkinfo;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/tn/lib/util/networkinfo/NetworkType;", "", "<init>", "(Ljava/lang/String;I)V", "NETWORK_ETHERNET", "NETWORK_WIFI", "NETWORK_5G", "NETWORK_4G", "NETWORK_3G", "NETWORK_2G", "NETWORK_UNKNOWN", "NETWORK_NO", "utils_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class NetworkType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetworkType[] $VALUES;
    public static final NetworkType NETWORK_ETHERNET = new NetworkType("NETWORK_ETHERNET", 0);
    public static final NetworkType NETWORK_WIFI = new NetworkType("NETWORK_WIFI", 1);
    public static final NetworkType NETWORK_5G = new NetworkType("NETWORK_5G", 2);
    public static final NetworkType NETWORK_4G = new NetworkType("NETWORK_4G", 3);
    public static final NetworkType NETWORK_3G = new NetworkType("NETWORK_3G", 4);
    public static final NetworkType NETWORK_2G = new NetworkType("NETWORK_2G", 5);
    public static final NetworkType NETWORK_UNKNOWN = new NetworkType("NETWORK_UNKNOWN", 6);
    public static final NetworkType NETWORK_NO = new NetworkType("NETWORK_NO", 7);

    private static final /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{NETWORK_ETHERNET, NETWORK_WIFI, NETWORK_5G, NETWORK_4G, NETWORK_3G, NETWORK_2G, NETWORK_UNKNOWN, NETWORK_NO};
    }

    static {
        NetworkType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private NetworkType(String str, int i11) {
    }

    public static EnumEntries<NetworkType> getEntries() {
        return $ENTRIES;
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }
}
