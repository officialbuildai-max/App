package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.z4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    private long f5861a;

    /* renamed from: b, reason: collision with root package name */
    private long f5862b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.ui.text.font.p f5863c;

    /* renamed from: d, reason: collision with root package name */
    private androidx.compose.ui.text.font.n f5864d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.compose.ui.text.font.o f5865e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.compose.ui.text.font.h f5866f;

    /* renamed from: g, reason: collision with root package name */
    private String f5867g;

    /* renamed from: h, reason: collision with root package name */
    private long f5868h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.compose.ui.text.style.a f5869i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.compose.ui.text.style.m f5870j;

    /* renamed from: k, reason: collision with root package name */
    private n0.i f5871k;

    /* renamed from: l, reason: collision with root package name */
    private long f5872l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.compose.ui.text.style.i f5873m;

    /* renamed from: n, reason: collision with root package name */
    private z4 f5874n;

    private g1(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var) {
        this.f5861a = j11;
        this.f5862b = j12;
        this.f5863c = pVar;
        this.f5864d = nVar;
        this.f5865e = oVar;
        this.f5866f = hVar;
        this.f5867g = str;
        this.f5868h = j13;
        this.f5869i = aVar;
        this.f5870j = mVar;
        this.f5871k = iVar;
        this.f5872l = j14;
        this.f5873m = iVar2;
        this.f5874n = z4Var;
    }

    public /* synthetic */ g1(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? androidx.compose.ui.graphics.u1.f4733b.e() : j11, (i11 & 2) != 0 ? o0.w.f70751b.a() : j12, (i11 & 4) != 0 ? null : pVar, (i11 & 8) != 0 ? null : nVar, (i11 & 16) != 0 ? null : oVar, (i11 & 32) != 0 ? null : hVar, (i11 & 64) != 0 ? null : str, (i11 & 128) != 0 ? o0.w.f70751b.a() : j13, (i11 & 256) != 0 ? null : aVar, (i11 & 512) != 0 ? null : mVar, (i11 & 1024) != 0 ? null : iVar, (i11 & 2048) != 0 ? androidx.compose.ui.graphics.u1.f4733b.e() : j14, (i11 & 4096) != 0 ? null : iVar2, (i11 & 8192) != 0 ? null : z4Var, null);
    }

    public /* synthetic */ g1(long j11, long j12, androidx.compose.ui.text.font.p pVar, androidx.compose.ui.text.font.n nVar, androidx.compose.ui.text.font.o oVar, androidx.compose.ui.text.font.h hVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, n0.i iVar, long j14, androidx.compose.ui.text.style.i iVar2, z4 z4Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, pVar, nVar, oVar, hVar, str, j13, aVar, mVar, iVar, j14, iVar2, z4Var);
    }

    public final void a(long j11) {
        this.f5872l = j11;
    }

    public final void b(androidx.compose.ui.text.style.a aVar) {
        this.f5869i = aVar;
    }

    public final void c(long j11) {
        this.f5861a = j11;
    }

    public final void d(String str) {
        this.f5867g = str;
    }

    public final void e(long j11) {
        this.f5862b = j11;
    }

    public final void f(androidx.compose.ui.text.font.n nVar) {
        this.f5864d = nVar;
    }

    public final void g(androidx.compose.ui.text.font.o oVar) {
        this.f5865e = oVar;
    }

    public final void h(androidx.compose.ui.text.font.p pVar) {
        this.f5863c = pVar;
    }

    public final void i(long j11) {
        this.f5868h = j11;
    }

    public final void j(z4 z4Var) {
        this.f5874n = z4Var;
    }

    public final void k(androidx.compose.ui.text.style.i iVar) {
        this.f5873m = iVar;
    }

    public final void l(androidx.compose.ui.text.style.m mVar) {
        this.f5870j = mVar;
    }

    public final androidx.compose.ui.text.x m() {
        return new androidx.compose.ui.text.x(this.f5861a, this.f5862b, this.f5863c, this.f5864d, this.f5865e, this.f5866f, this.f5867g, this.f5868h, this.f5869i, this.f5870j, this.f5871k, this.f5872l, this.f5873m, this.f5874n, null, null, 49152, null);
    }
}
