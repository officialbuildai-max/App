package com.transsion.usercenter.tvlink;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import com.transsion.mb.config.manager.ConfigBean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sm.f;

/* loaded from: classes7.dex */
public final class d extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f57623c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b0 f57624a;

    /* renamed from: b, reason: collision with root package name */
    private final LiveData f57625b;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f57626a;

        /* renamed from: b, reason: collision with root package name */
        private final String f57627b;

        public b(String tvDownloadUrl, String webLinkUrl) {
            Intrinsics.h(tvDownloadUrl, "tvDownloadUrl");
            Intrinsics.h(webLinkUrl, "webLinkUrl");
            this.f57626a = tvDownloadUrl;
            this.f57627b = webLinkUrl;
        }

        public final b a(String tvDownloadUrl, String webLinkUrl) {
            Intrinsics.h(tvDownloadUrl, "tvDownloadUrl");
            Intrinsics.h(webLinkUrl, "webLinkUrl");
            return new b(tvDownloadUrl, webLinkUrl);
        }

        public final String b() {
            return this.f57626a;
        }

        public final String c() {
            return this.f57627b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f57626a, bVar.f57626a) && Intrinsics.c(this.f57627b, bVar.f57627b);
        }

        public int hashCode() {
            return (this.f57626a.hashCode() * 31) + this.f57627b.hashCode();
        }

        public String toString() {
            return "TvLinkUrls(tvDownloadUrl=" + this.f57626a + ", webLinkUrl=" + this.f57627b + ")";
        }
    }

    public d() {
        b0 b0Var = new b0();
        this.f57624a = b0Var;
        this.f57625b = b0Var;
    }

    public final LiveData b() {
        return this.f57625b;
    }

    public final void c() {
        b0 b0Var = this.f57624a;
        f.a aVar = f.f75530c;
        ConfigBean c11 = aVar.a().c("sa_me_tv_download_url", true);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null) {
            value = "";
        }
        ConfigBean c12 = aVar.a().c("sa_me_web_link_url", true);
        String value2 = c12 != null ? c12.getValue() : null;
        b0Var.q(new b(value, value2 != null ? value2 : ""));
    }
}
