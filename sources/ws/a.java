package ws;

import androidx.view.b0;
import androidx.view.t0;
import com.transsion.shorttv.utils.h;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f78066a = new b0();

    /* renamed from: b, reason: collision with root package name */
    private final b0 f78067b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private final b0 f78068c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f78069d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f78070e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private String f78071f;

    public final void b() {
        this.f78069d.q(null);
        this.f78070e.q(null);
        this.f78068c.q(Boolean.valueOf(Intrinsics.c(h.f53707a.d().getString("k_subtitle_language", ""), "off")));
        this.f78071f = null;
    }

    public final String c() {
        return this.f78071f;
    }

    public final b0 d() {
        return this.f78069d;
    }

    public final b0 e() {
        return this.f78070e;
    }

    public final b0 f() {
        return this.f78068c;
    }

    public final void g(String str) {
        this.f78071f = str;
    }
}
