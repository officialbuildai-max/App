package com.transsion.baseui.util;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f43569a = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(String str) {
            long parseLong = Long.parseLong(str);
            if (parseLong < 0) {
                return "-";
            }
            if (parseLong < 1000) {
                return str.toString();
            }
            if (1000 <= parseLong && parseLong < 1000001) {
                return new BigDecimal(str).divide(new BigDecimal("1000")).setScale(1, RoundingMode.HALF_UP) + CampaignEx.JSON_KEY_AD_K;
            }
            if (parseLong < 1000000) {
                return str.toString();
            }
            return new BigDecimal(str).divide(new BigDecimal("1000000")).setScale(1, RoundingMode.HALF_UP) + "m";
        }

        public final String a(String str) {
            if (str == null) {
                return "0";
            }
            try {
                return b(str);
            } catch (Exception e11) {
                e11.printStackTrace();
                return str;
            }
        }
    }
}
