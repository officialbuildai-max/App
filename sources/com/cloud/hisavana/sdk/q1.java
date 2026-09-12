package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class q1 {

    /* renamed from: f, reason: collision with root package name */
    public static final a f22931f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private String f22932a;

    /* renamed from: b, reason: collision with root package name */
    private Long f22933b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f22934c;

    /* renamed from: d, reason: collision with root package name */
    private String f22935d;

    /* renamed from: e, reason: collision with root package name */
    private String f22936e;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final q1 a(DiskTrackingBean bean) {
            Intrinsics.h(bean, "bean");
            q1 q1Var = new q1(null, null, null, null, null, 31, null);
            q1Var.h(bean.getUuid());
            q1Var.c(Long.valueOf(bean.getCreateTime()));
            q1Var.b(Integer.valueOf(bean.getRetryTimes().get()));
            q1Var.f(GsonUtil.d(bean));
            q1Var.d(bean.getMd5());
            return q1Var;
        }
    }

    public q1() {
        this(null, null, null, null, null, 31, null);
    }

    public q1(String uuid, Long l11, Integer num, String str, String str2) {
        Intrinsics.h(uuid, "uuid");
        this.f22932a = uuid;
        this.f22933b = l11;
        this.f22934c = num;
        this.f22935d = str;
        this.f22936e = str2;
    }

    public /* synthetic */ q1(String str, Long l11, Integer num, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0L : l11, (i11 & 4) != 0 ? 0 : num, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3);
    }

    public final Long a() {
        return this.f22933b;
    }

    public final void b(Integer num) {
        this.f22934c = num;
    }

    public final void c(Long l11) {
        this.f22933b = l11;
    }

    public final void d(String str) {
        this.f22936e = str;
    }

    public final String e() {
        return this.f22936e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q1)) {
            return false;
        }
        q1 q1Var = (q1) obj;
        return Intrinsics.c(this.f22932a, q1Var.f22932a) && Intrinsics.c(this.f22933b, q1Var.f22933b) && Intrinsics.c(this.f22934c, q1Var.f22934c) && Intrinsics.c(this.f22935d, q1Var.f22935d) && Intrinsics.c(this.f22936e, q1Var.f22936e);
    }

    public final void f(String str) {
        this.f22935d = str;
    }

    public final Integer g() {
        return this.f22934c;
    }

    public final void h(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f22932a = str;
    }

    public int hashCode() {
        int hashCode = this.f22932a.hashCode() * 31;
        Long l11 = this.f22933b;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num = this.f22934c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f22935d;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22936e;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String i() {
        return this.f22935d;
    }

    public final String j() {
        return this.f22932a;
    }

    public String toString() {
        return "RetryTrackingEntity(uuid=" + this.f22932a + ", create_time=" + this.f22933b + ", retry_times=" + this.f22934c + ", tracking_data=" + this.f22935d + ", md5=" + this.f22936e + ')';
    }
}
