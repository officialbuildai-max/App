package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class y3 {

    /* renamed from: i, reason: collision with root package name */
    public static final a f23195i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f23196a;

    /* renamed from: b, reason: collision with root package name */
    private String f23197b;

    /* renamed from: c, reason: collision with root package name */
    private String f23198c;

    /* renamed from: d, reason: collision with root package name */
    private String f23199d;

    /* renamed from: e, reason: collision with root package name */
    private Double f23200e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f23201f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f23202g;

    /* renamed from: h, reason: collision with root package name */
    private String f23203h;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(List list) {
            if (list == null) {
                return CollectionsKt.l();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdsDTO adsDTO = (AdsDTO) it.next();
                y3 y3Var = new y3(0, null, null, null, null, null, null, null, 255, null);
                y3Var.b(adsDTO.getTableId());
                y3Var.h(adsDTO.getAdCreativeId());
                y3Var.j(adsDTO.getCodeSeatId());
                y3Var.l(adsDTO.getFilePath());
                y3Var.c(adsDTO.getFirstPrice());
                y3Var.g(Integer.valueOf(adsDTO.isOfflineAd() ? 1 : 0));
                y3Var.d(Integer.valueOf(adsDTO.getAdRequestVer()));
                y3Var.e(GsonUtil.d(adsDTO));
                arrayList.add(y3Var);
            }
            return arrayList;
        }
    }

    public y3() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    public y3(int i11, String str, String str2, String str3, Double d11, Integer num, Integer num2, String str4) {
        this.f23196a = i11;
        this.f23197b = str;
        this.f23198c = str2;
        this.f23199d = str3;
        this.f23200e = d11;
        this.f23201f = num;
        this.f23202g = num2;
        this.f23203h = str4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ y3(int r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.Double r15, java.lang.Integer r16, java.lang.Integer r17, java.lang.String r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto Lc
            goto Ld
        Lc:
            r2 = r11
        Ld:
            r1 = r0 & 2
            r4 = 0
            if (r1 == 0) goto L14
            r1 = r4
            goto L15
        L14:
            r1 = r12
        L15:
            r5 = r0 & 4
            if (r5 == 0) goto L1b
            r5 = r4
            goto L1c
        L1b:
            r5 = r13
        L1c:
            r6 = r0 & 8
            if (r6 == 0) goto L22
            r6 = r4
            goto L23
        L22:
            r6 = r14
        L23:
            r7 = r0 & 16
            if (r7 == 0) goto L2e
            r7 = 0
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            goto L2f
        L2e:
            r7 = r15
        L2f:
            r8 = r0 & 32
            if (r8 == 0) goto L35
            r8 = r3
            goto L37
        L35:
            r8 = r16
        L37:
            r9 = r0 & 64
            if (r9 == 0) goto L3c
            goto L3e
        L3c:
            r3 = r17
        L3e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L43
            goto L45
        L43:
            r4 = r18
        L45:
            r11 = r10
            r12 = r2
            r13 = r1
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r3
            r19 = r4
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.y3.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Integer, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String a() {
        return this.f23203h;
    }

    public final void b(int i11) {
        this.f23196a = i11;
    }

    public final void c(Double d11) {
        this.f23200e = d11;
    }

    public final void d(Integer num) {
        this.f23202g = num;
    }

    public final void e(String str) {
        this.f23203h = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y3)) {
            return false;
        }
        y3 y3Var = (y3) obj;
        return this.f23196a == y3Var.f23196a && Intrinsics.c(this.f23197b, y3Var.f23197b) && Intrinsics.c(this.f23198c, y3Var.f23198c) && Intrinsics.c(this.f23199d, y3Var.f23199d) && Intrinsics.c(this.f23200e, y3Var.f23200e) && Intrinsics.c(this.f23201f, y3Var.f23201f) && Intrinsics.c(this.f23202g, y3Var.f23202g) && Intrinsics.c(this.f23203h, y3Var.f23203h);
    }

    public final String f() {
        return this.f23197b;
    }

    public final void g(Integer num) {
        this.f23201f = num;
    }

    public final void h(String str) {
        this.f23197b = str;
    }

    public int hashCode() {
        int i11 = this.f23196a * 31;
        String str = this.f23197b;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f23198c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f23199d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Double d11 = this.f23200e;
        int hashCode4 = (hashCode3 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num = this.f23201f;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f23202g;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.f23203h;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final Integer i() {
        return this.f23202g;
    }

    public final void j(String str) {
        this.f23198c = str;
    }

    public final String k() {
        return this.f23198c;
    }

    public final void l(String str) {
        this.f23199d = str;
    }

    public final String m() {
        return this.f23199d;
    }

    public final Double n() {
        return this.f23200e;
    }

    public final int o() {
        return this.f23196a;
    }

    public final Integer p() {
        return this.f23201f;
    }

    public String toString() {
        return "AdListEntity(_id=" + this.f23196a + ", ad_creative_id=" + this.f23197b + ", codeSeatId=" + this.f23198c + ", file_path=" + this.f23199d + ", price=" + this.f23200e + ", is_offline_ad=" + this.f23201f + ", ad_request_ver=" + this.f23202g + ", ad_bean=" + this.f23203h + ')';
    }
}
