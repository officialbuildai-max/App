package com.transsion.ad.strategy;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class AdUrlParameterManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AdUrlParameterManager f42267a = new AdUrlParameterManager();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/strategy/AdUrlParameterManager$UrlParameterReplaceEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GAID", "CUSTOM_USER_ID", "TIME_STAMP", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class UrlParameterReplaceEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UrlParameterReplaceEnum[] $VALUES;
        private final String value;
        public static final UrlParameterReplaceEnum GAID = new UrlParameterReplaceEnum("GAID", 0, "GAID");
        public static final UrlParameterReplaceEnum CUSTOM_USER_ID = new UrlParameterReplaceEnum("CUSTOM_USER_ID", 1, "CUSTOM_USER_ID");
        public static final UrlParameterReplaceEnum TIME_STAMP = new UrlParameterReplaceEnum("TIME_STAMP", 2, "TIME_STAMP");

        private static final /* synthetic */ UrlParameterReplaceEnum[] $values() {
            return new UrlParameterReplaceEnum[]{GAID, CUSTOM_USER_ID, TIME_STAMP};
        }

        static {
            UrlParameterReplaceEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private UrlParameterReplaceEnum(String str, int i11, String str2) {
            this.value = str2;
        }

        public static EnumEntries<UrlParameterReplaceEnum> getEntries() {
            return $ENTRIES;
        }

        public static UrlParameterReplaceEnum valueOf(String str) {
            return (UrlParameterReplaceEnum) Enum.valueOf(UrlParameterReplaceEnum.class, str);
        }

        public static UrlParameterReplaceEnum[] values() {
            return (UrlParameterReplaceEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f42268a;

        /* renamed from: b, reason: collision with root package name */
        private final String f42269b;

        /* renamed from: c, reason: collision with root package name */
        private final String f42270c;

        public a(String key, String value, String type) {
            Intrinsics.h(key, "key");
            Intrinsics.h(value, "value");
            Intrinsics.h(type, "type");
            this.f42268a = key;
            this.f42269b = value;
            this.f42270c = type;
        }

        public final String a() {
            return this.f42268a;
        }

        public final String b() {
            return this.f42270c;
        }

        public final String c() {
            return this.f42269b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f42268a, aVar.f42268a) && Intrinsics.c(this.f42269b, aVar.f42269b) && Intrinsics.c(this.f42270c, aVar.f42270c);
        }

        public int hashCode() {
            return (((this.f42268a.hashCode() * 31) + this.f42269b.hashCode()) * 31) + this.f42270c.hashCode();
        }

        public String toString() {
            return "UrlParameterReplaceEntity(key=" + this.f42268a + ", value=" + this.f42269b + ", type=" + this.f42270c + ")";
        }
    }

    private AdUrlParameterManager() {
    }

    public final boolean a(String str) {
        Object m1185constructorimpl;
        boolean z10;
        try {
            Result.Companion companion = Result.INSTANCE;
            z10 = false;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (str != null && str.length() != 0) {
            String queryParameter = Uri.parse(str).getQueryParameter("mb_system_browser");
            if (queryParameter != null && StringsKt.H(queryParameter, "true", true)) {
                z10 = true;
            }
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(z10));
            if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
                m1185constructorimpl = Boolean.FALSE;
            }
            return ((Boolean) m1185constructorimpl).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b(String url, String str) {
        Intrinsics.h(url, "url");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (TextUtils.isEmpty(url)) {
                return url;
            }
            List<a> g11 = com.transsion.ad.scene.b.f42256a.g();
            if (g11.isEmpty()) {
                return url;
            }
            Uri parse = Uri.parse(url);
            Intrinsics.g(parse, "parse(...)");
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            String str2 = url;
            for (a aVar : g11) {
                if (queryParameterNames.contains(aVar.a()) && Intrinsics.c(parse.getQueryParameter(aVar.a()), aVar.c())) {
                    String b11 = aVar.b();
                    if (Intrinsics.c(b11, UrlParameterReplaceEnum.GAID.getValue())) {
                        String c11 = aVar.c();
                        String e11 = DeviceUtil.e();
                        Intrinsics.g(e11, "getGAId(...)");
                        str2 = StringsKt.Q(str2, c11, e11, false, 4, null);
                    } else if (Intrinsics.c(b11, UrlParameterReplaceEnum.CUSTOM_USER_ID.getValue())) {
                        str2 = StringsKt.Q(str2, aVar.c(), "custom_use_id_ashdjhv1234dhb", false, 4, null);
                    } else if (Intrinsics.c(b11, UrlParameterReplaceEnum.TIME_STAMP.getValue())) {
                        str2 = StringsKt.Q(str2, aVar.c(), String.valueOf(System.currentTimeMillis()), false, 4, null);
                    }
                }
            }
            oi.a aVar2 = oi.a.f71145a;
            if (str == null) {
                str = "";
            }
            oi.a.o(aVar2, str, "AdUrlParameterReplaceManager --> replaceParameter() --> url = " + url + " --> replaceList = " + g11 + " --> newUrl = " + ((Object) str2), 0, false, 12, null);
            return str2;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) == null) {
                url = m1185constructorimpl;
            }
            return url;
        }
    }
}
