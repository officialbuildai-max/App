package com.transsion.player.ui.render;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/player/ui/render/RenderScaleMode;", "", "<init>", "(Ljava/lang/String;I)V", "SCREEN_SCALE_DEFAULT", "SCREEN_SCALE_ORIGINAL", "SCREEN_SCALE_16_9", "SCREEN_SCALE_4_3", "SCREEN_SCALE_MATCH_PARENT", "SCREEN_SCALE_CENTER_CROP", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RenderScaleMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RenderScaleMode[] $VALUES;
    public static final RenderScaleMode SCREEN_SCALE_DEFAULT = new RenderScaleMode("SCREEN_SCALE_DEFAULT", 0);
    public static final RenderScaleMode SCREEN_SCALE_ORIGINAL = new RenderScaleMode("SCREEN_SCALE_ORIGINAL", 1);
    public static final RenderScaleMode SCREEN_SCALE_16_9 = new RenderScaleMode("SCREEN_SCALE_16_9", 2);
    public static final RenderScaleMode SCREEN_SCALE_4_3 = new RenderScaleMode("SCREEN_SCALE_4_3", 3);
    public static final RenderScaleMode SCREEN_SCALE_MATCH_PARENT = new RenderScaleMode("SCREEN_SCALE_MATCH_PARENT", 4);
    public static final RenderScaleMode SCREEN_SCALE_CENTER_CROP = new RenderScaleMode("SCREEN_SCALE_CENTER_CROP", 5);

    private static final /* synthetic */ RenderScaleMode[] $values() {
        return new RenderScaleMode[]{SCREEN_SCALE_DEFAULT, SCREEN_SCALE_ORIGINAL, SCREEN_SCALE_16_9, SCREEN_SCALE_4_3, SCREEN_SCALE_MATCH_PARENT, SCREEN_SCALE_CENTER_CROP};
    }

    static {
        RenderScaleMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RenderScaleMode(String str, int i11) {
    }

    public static EnumEntries<RenderScaleMode> getEntries() {
        return $ENTRIES;
    }

    public static RenderScaleMode valueOf(String str) {
        return (RenderScaleMode) Enum.valueOf(RenderScaleMode.class, str);
    }

    public static RenderScaleMode[] values() {
        return (RenderScaleMode[]) $VALUES.clone();
    }
}
