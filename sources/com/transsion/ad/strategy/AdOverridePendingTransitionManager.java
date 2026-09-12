package com.transsion.ad.strategy;

import com.transsion.ad.R$anim;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: classes5.dex */
public final class AdOverridePendingTransitionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AdOverridePendingTransitionManager f42265a = new AdOverridePendingTransitionManager();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/ad/strategy/AdOverridePendingTransitionManager$AdOverridePendingTransitionEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OVERRIDE_PENDING_TRANSITION_1", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class AdOverridePendingTransitionEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AdOverridePendingTransitionEnum[] $VALUES;
        public static final AdOverridePendingTransitionEnum OVERRIDE_PENDING_TRANSITION_1 = new AdOverridePendingTransitionEnum("OVERRIDE_PENDING_TRANSITION_1", 0);

        private static final /* synthetic */ AdOverridePendingTransitionEnum[] $values() {
            return new AdOverridePendingTransitionEnum[]{OVERRIDE_PENDING_TRANSITION_1};
        }

        static {
            AdOverridePendingTransitionEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private AdOverridePendingTransitionEnum(String str, int i11) {
        }

        public static EnumEntries<AdOverridePendingTransitionEnum> getEntries() {
            return $ENTRIES;
        }

        public static AdOverridePendingTransitionEnum valueOf(String str) {
            return (AdOverridePendingTransitionEnum) Enum.valueOf(AdOverridePendingTransitionEnum.class, str);
        }

        public static AdOverridePendingTransitionEnum[] values() {
            return (AdOverridePendingTransitionEnum[]) $VALUES.clone();
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42266a;

        static {
            int[] iArr = new int[AdOverridePendingTransitionEnum.values().length];
            try {
                iArr[AdOverridePendingTransitionEnum.OVERRIDE_PENDING_TRANSITION_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f42266a = iArr;
        }
    }

    private AdOverridePendingTransitionManager() {
    }

    public final Pair a(AdOverridePendingTransitionEnum adOverridePendingTransitionEnum) {
        int i11 = adOverridePendingTransitionEnum == null ? -1 : a.f42266a[adOverridePendingTransitionEnum.ordinal()];
        if (i11 == -1) {
            return null;
        }
        if (i11 == 1) {
            return new Pair(Integer.valueOf(R$anim.slide_in_from_top), Integer.valueOf(R$anim.no_anim));
        }
        throw new NoWhenBranchMatchedException();
    }
}
