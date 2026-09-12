package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* loaded from: classes3.dex */
public final class s {

    /* renamed from: d, reason: collision with root package name */
    public static final a f23009d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final AdsDTO f23010a;

    /* renamed from: b, reason: collision with root package name */
    private float f23011b;

    /* renamed from: c, reason: collision with root package name */
    private int f23012c;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public s(AdsDTO adsDTO) {
        Intrinsics.h(adsDTO, "adsDTO");
        this.f23010a = adsDTO;
    }

    private final int a() {
        return v2.f23109a.f(this.f23010a);
    }

    private final int b(boolean z10, boolean z11) {
        return (z10 && z11) ? Random.INSTANCE.nextInt(2) == 1 ? 1 : 2 : z10 ? 1 : 2;
    }

    private final String c(float f11) {
        return v2.f23109a.b(f11);
    }

    private final String d(int i11) {
        if (i11 == 0) {
            return "0";
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            if (i11 < 1000) {
                return String.valueOf(i11);
            }
            if (i11 < 1000000) {
                return decimalFormat.format(i11 / 1000.0f) + 'K';
            }
            return decimalFormat.format(i11 / 1000000.0f) + 'M';
        } catch (Exception unused) {
            return "";
        }
    }

    private final float e() {
        return v2.f23109a.j(this.f23010a);
    }

    public final int f(int i11) {
        if (i11 != 0) {
            if (i11 == 1) {
                return R$drawable.hs_ad_score;
            }
            if (i11 == 2) {
                return R$drawable.hs_ad_download;
            }
        }
        return 0;
    }

    public final int g() {
        ConfigTotalDTO.ExtInfo m11 = k1.o().m();
        if (m11 == null) {
            m11 = new ConfigTotalDTO.ExtInfo();
        }
        float e11 = e();
        this.f23011b = e11;
        boolean z10 = e11 >= m11.getScoreCount();
        int a11 = a();
        this.f23012c = a11;
        boolean z11 = ((long) a11) >= m11.getDownloadCount();
        if (!z10 && !z11) {
            return 1;
        }
        int b11 = b(z10, z11);
        if (a7.c.p()) {
            e4.b().i("BannerStyleHelper", "score: " + this.f23011b + ", \ndownloadCount: " + this.f23012c + ", \nX: " + m11.getScoreCount() + ", \nY: " + m11.getDownloadCount() + ", \nweightOld: " + m11.getOldStyle() + ", \nweightScore: " + m11.getScoreStyle() + ", \nweightDownload: " + m11.getDownloadStyle() + ", \nrandomStyle: " + b11);
        }
        return b11;
    }

    public final String h(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? "" : d(this.f23012c) : c(this.f23011b) : "";
    }
}
