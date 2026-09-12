package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/memberapi/MembershipDetailType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "GUEST", "TRIAL", "SUBSCRIPTION_MEMBER", "FINANCIAL_MEMBER", "EXPIRED", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class MembershipDetailType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MembershipDetailType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final MembershipDetailType GUEST = new MembershipDetailType("GUEST", 0);
    public static final MembershipDetailType TRIAL = new MembershipDetailType("TRIAL", 1);
    public static final MembershipDetailType SUBSCRIPTION_MEMBER = new MembershipDetailType("SUBSCRIPTION_MEMBER", 2);
    public static final MembershipDetailType FINANCIAL_MEMBER = new MembershipDetailType("FINANCIAL_MEMBER", 3);
    public static final MembershipDetailType EXPIRED = new MembershipDetailType("EXPIRED", 4);

    /* renamed from: com.transsion.memberapi.MembershipDetailType$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MembershipDetailType a(MemberInfo memberInfo) {
            return (memberInfo == null || !memberInfo.isActive()) ? (memberInfo == null || memberInfo.getMemberType() != 0) ? MembershipDetailType.EXPIRED : MembershipDetailType.GUEST : memberInfo.getMemberType() == 1 ? MembershipDetailType.TRIAL : memberInfo.isAutoRenew() ? MembershipDetailType.SUBSCRIPTION_MEMBER : MembershipDetailType.FINANCIAL_MEMBER;
        }
    }

    private static final /* synthetic */ MembershipDetailType[] $values() {
        return new MembershipDetailType[]{GUEST, TRIAL, SUBSCRIPTION_MEMBER, FINANCIAL_MEMBER, EXPIRED};
    }

    static {
        MembershipDetailType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private MembershipDetailType(String str, int i11) {
    }

    public static EnumEntries<MembershipDetailType> getEntries() {
        return $ENTRIES;
    }

    public static MembershipDetailType valueOf(String str) {
        return (MembershipDetailType) Enum.valueOf(MembershipDetailType.class, str);
    }

    public static MembershipDetailType[] values() {
        return (MembershipDetailType[]) $VALUES.clone();
    }
}
