package com.transsion.player.config;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/player/config/RenderType;", "", "<init>", "(Ljava/lang/String;I)V", "SURFACE_VIEW", "TEXTURE_VIEW", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class RenderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RenderType[] $VALUES;
    public static final RenderType SURFACE_VIEW = new RenderType("SURFACE_VIEW", 0);
    public static final RenderType TEXTURE_VIEW = new RenderType("TEXTURE_VIEW", 1);

    private static final /* synthetic */ RenderType[] $values() {
        return new RenderType[]{SURFACE_VIEW, TEXTURE_VIEW};
    }

    static {
        RenderType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RenderType(String str, int i11) {
    }

    public static EnumEntries<RenderType> getEntries() {
        return $ENTRIES;
    }

    public static RenderType valueOf(String str) {
        return (RenderType) Enum.valueOf(RenderType.class, str);
    }

    public static RenderType[] values() {
        return (RenderType[]) $VALUES.clone();
    }
}
