package com.transsion.ad.monopoly.plan;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlans;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: classes5.dex */
public final class AdPlanSourceManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AdPlanSourceManager f42220a = new AdPlanSourceManager();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/ad/monopoly/plan/AdPlanSourceManager$AdPlanEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AD_PLAN_DEFAULT_AD_SRC", "AD_PLAN_AD_SOURCE_PS", "AD_PLAN_AD_SOURCE_MB_PS", "AD_PLAN_AD_SOURCE_HI", "AD_PLAN_AD_SOURCE_ICON", "AD_PLAN_AD_SOURCE_PS_REFERRAL", "AD_PLAN_AD_SOURCE_H5", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class AdPlanEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AdPlanEnum[] $VALUES;
        private final String value;
        public static final AdPlanEnum AD_PLAN_DEFAULT_AD_SRC = new AdPlanEnum("AD_PLAN_DEFAULT_AD_SRC", 0, "_DefaultAdSrc");
        public static final AdPlanEnum AD_PLAN_AD_SOURCE_PS = new AdPlanEnum("AD_PLAN_AD_SOURCE_PS", 1, "AdSourcePS");
        public static final AdPlanEnum AD_PLAN_AD_SOURCE_MB_PS = new AdPlanEnum("AD_PLAN_AD_SOURCE_MB_PS", 2, "AdSourceMBPS");
        public static final AdPlanEnum AD_PLAN_AD_SOURCE_HI = new AdPlanEnum("AD_PLAN_AD_SOURCE_HI", 3, "AdSourceHI");
        public static final AdPlanEnum AD_PLAN_AD_SOURCE_ICON = new AdPlanEnum("AD_PLAN_AD_SOURCE_ICON", 4, "AdSourceIcon");
        public static final AdPlanEnum AD_PLAN_AD_SOURCE_PS_REFERRAL = new AdPlanEnum("AD_PLAN_AD_SOURCE_PS_REFERRAL", 5, "AdSourcePSReferral");
        public static final AdPlanEnum AD_PLAN_AD_SOURCE_H5 = new AdPlanEnum("AD_PLAN_AD_SOURCE_H5", 6, "AdSourceH5");

        private static final /* synthetic */ AdPlanEnum[] $values() {
            return new AdPlanEnum[]{AD_PLAN_DEFAULT_AD_SRC, AD_PLAN_AD_SOURCE_PS, AD_PLAN_AD_SOURCE_MB_PS, AD_PLAN_AD_SOURCE_HI, AD_PLAN_AD_SOURCE_ICON, AD_PLAN_AD_SOURCE_PS_REFERRAL, AD_PLAN_AD_SOURCE_H5};
        }

        static {
            AdPlanEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private AdPlanEnum(String str, int i11, String str2) {
            this.value = str2;
        }

        public static EnumEntries<AdPlanEnum> getEntries() {
            return $ENTRIES;
        }

        public static AdPlanEnum valueOf(String str) {
            return (AdPlanEnum) Enum.valueOf(AdPlanEnum.class, str);
        }

        public static AdPlanEnum[] values() {
            return (AdPlanEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private AdPlanSourceManager() {
    }

    public final boolean a(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_DEFAULT_AD_SRC.getValue());
    }

    public final boolean b(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_DEFAULT_AD_SRC.getValue());
    }

    public final boolean c(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_H5.getValue());
    }

    public final boolean d(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue());
    }

    public final boolean e(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue());
    }

    public final boolean f(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_ICON.getValue());
    }

    public final boolean g(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_ICON.getValue());
    }

    public final boolean h(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_MB_PS.getValue());
    }

    public final boolean i(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_PS.getValue());
    }

    public final boolean j(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_PS.getValue());
    }

    public final boolean k(MbAdDbPlans mbAdDbPlans) {
        return TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_PS_REFERRAL.getValue());
    }

    public final boolean l(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanEnum.AD_PLAN_AD_SOURCE_PS_REFERRAL.getValue());
    }
}
