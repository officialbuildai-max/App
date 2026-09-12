package oy;

import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import sm.f;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: k, reason: collision with root package name */
    public static final a f72324k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f72325a = "GET";

    /* renamed from: b, reason: collision with root package name */
    private int f72326b = 60000;

    /* renamed from: c, reason: collision with root package name */
    private int f72327c = 60000;

    /* renamed from: d, reason: collision with root package name */
    private int f72328d = 1;

    /* renamed from: e, reason: collision with root package name */
    private int f72329e = ((DownloadExecutor.f58756a.a() / 2) + 2) / this.f72328d;

    /* renamed from: f, reason: collision with root package name */
    private int f72330f = 3;

    /* renamed from: g, reason: collision with root package name */
    private int f72331g = 5;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f72332h = LazyKt.b(new Function0() { // from class: oy.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            double c11;
            c11 = c.c(c.this);
            return Double.valueOf(c11);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f72333i = LazyKt.b(new Function0() { // from class: oy.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long k11;
            k11 = c.k();
            return Long.valueOf(k11);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final int f72334j = -1;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double c(c cVar) {
        return cVar.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k() {
        Long x10;
        ConfigBean c11 = f.f75530c.a().c("downloadRangeSize", true);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null || value.length() == 0 || (x10 = StringsKt.x(value)) == null) {
            return 5242880L;
        }
        return x10.longValue();
    }

    private final double l() {
        Double s11;
        ConfigBean c11 = f.f75530c.a().c("download_speed_limit_ratio", true);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null || (s11 = StringsKt.s(value)) == null) {
            return 0.3d;
        }
        return RangesKt.k(s11.doubleValue(), 0.0d, 1.0d);
    }

    public final double d() {
        return ((Number) this.f72332h.getValue()).doubleValue();
    }

    public final int e() {
        return this.f72328d;
    }

    public final int f() {
        return this.f72329e;
    }

    public final long g() {
        return ((Number) this.f72333i.getValue()).longValue();
    }

    public final int h() {
        return this.f72334j;
    }

    public final int i() {
        return this.f72331g;
    }

    public final int j() {
        return this.f72330f;
    }

    public final void m(int i11) {
        this.f72328d = i11;
    }
}
