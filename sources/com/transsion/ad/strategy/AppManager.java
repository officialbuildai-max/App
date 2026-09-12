package com.transsion.ad.strategy;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class AppManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AppManager f42271a = new AppManager();

    /* renamed from: b, reason: collision with root package name */
    private static AppEnum f42272b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/ad/strategy/AppManager$AppEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP_MOVIE_BOX", "APP_NOVEL_HUB", "APP_WOW_FM", "APP_MB_TV", "APP_HOLA", "APP_GO_DRAMA", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class AppEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AppEnum[] $VALUES;
        private final String value;
        public static final AppEnum APP_MOVIE_BOX = new AppEnum("APP_MOVIE_BOX", 0, "movie_box");
        public static final AppEnum APP_NOVEL_HUB = new AppEnum("APP_NOVEL_HUB", 1, "novel_hub");
        public static final AppEnum APP_WOW_FM = new AppEnum("APP_WOW_FM", 2, "wow_fm");
        public static final AppEnum APP_MB_TV = new AppEnum("APP_MB_TV", 3, "movie_tv");
        public static final AppEnum APP_HOLA = new AppEnum("APP_HOLA", 4, TmcConstants.START_FROM_HOLA);
        public static final AppEnum APP_GO_DRAMA = new AppEnum("APP_GO_DRAMA", 5, "go_drama");

        private static final /* synthetic */ AppEnum[] $values() {
            return new AppEnum[]{APP_MOVIE_BOX, APP_NOVEL_HUB, APP_WOW_FM, APP_MB_TV, APP_HOLA, APP_GO_DRAMA};
        }

        static {
            AppEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private AppEnum(String str, int i11, String str2) {
            this.value = str2;
        }

        public static EnumEntries<AppEnum> getEntries() {
            return $ENTRIES;
        }

        public static AppEnum valueOf(String str) {
            return (AppEnum) Enum.valueOf(AppEnum.class, str);
        }

        public static AppEnum[] values() {
            return (AppEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private AppManager() {
    }

    public final String a() {
        String value;
        AppEnum appEnum = f42272b;
        if (appEnum != null && (value = appEnum.getValue()) != null) {
            return value;
        }
        String string = f.f42286a.c().getString("mmkv_key_app_name", "none");
        return string == null ? "default_null" : string;
    }

    public final void b(AppEnum app) {
        Intrinsics.h(app, "app");
        f42272b = app;
        f.f42286a.c().putString("mmkv_key_app_name", app.getValue());
    }
}
