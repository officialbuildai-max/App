package androidx.media3.exoplayer.hls;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l2.l0;
import l2.m0;
import l2.s0;

/* loaded from: classes2.dex */
public final class u implements l2.r {

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f12080i = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f12081j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    private final String f12082a;

    /* renamed from: b, reason: collision with root package name */
    private final p0 f12083b;

    /* renamed from: d, reason: collision with root package name */
    private final s.a f12085d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f12086e;

    /* renamed from: f, reason: collision with root package name */
    private l2.t f12087f;

    /* renamed from: h, reason: collision with root package name */
    private int f12089h;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f12084c = new j0();

    /* renamed from: g, reason: collision with root package name */
    private byte[] f12088g = new byte[1024];

    public u(String str, p0 p0Var, s.a aVar, boolean z10) {
        this.f12082a = str;
        this.f12083b = p0Var;
        this.f12085d = aVar;
        this.f12086e = z10;
    }

    private s0 a(long j11) {
        s0 track = this.f12087f.track(0, 3);
        track.c(new r.b().u0(MimeTypes.TEXT_VTT).j0(this.f12082a).y0(j11).N());
        this.f12087f.endTracks();
        return track;
    }

    private void g() {
        j0 j0Var = new j0(this.f12088g);
        r3.h.e(j0Var);
        long j11 = 0;
        long j12 = 0;
        for (String s11 = j0Var.s(); !TextUtils.isEmpty(s11); s11 = j0Var.s()) {
            if (s11.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f12080i.matcher(s11);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain local timestamp: " + s11, null);
                }
                Matcher matcher2 = f12081j.matcher(s11);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain media timestamp: " + s11, null);
                }
                j12 = r3.h.d((String) androidx.media3.common.util.a.e(matcher.group(1)));
                j11 = p0.h(Long.parseLong((String) androidx.media3.common.util.a.e(matcher2.group(1))));
            }
        }
        Matcher a11 = r3.h.a(j0Var);
        if (a11 == null) {
            a(0L);
            return;
        }
        long d11 = r3.h.d((String) androidx.media3.common.util.a.e(a11.group(1)));
        long b11 = this.f12083b.b(p0.l((j11 + d11) - j12));
        s0 a12 = a(b11 - d11);
        this.f12084c.U(this.f12088g, this.f12089h);
        a12.b(this.f12084c, this.f12089h);
        a12.d(b11, 1, this.f12089h, 0, null);
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        if (this.f12086e) {
            tVar = new i3.t(tVar, this.f12085d);
        }
        this.f12087f = tVar;
        tVar.f(new m0.b(C.TIME_UNSET));
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        androidx.media3.common.util.a.e(this.f12087f);
        int length = (int) sVar.getLength();
        int i11 = this.f12089h;
        byte[] bArr = this.f12088g;
        if (i11 == bArr.length) {
            this.f12088g = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f12088g;
        int i12 = this.f12089h;
        int read = sVar.read(bArr2, i12, bArr2.length - i12);
        if (read != -1) {
            int i13 = this.f12089h + read;
            this.f12089h = i13;
            if (length == -1 || i13 != length) {
                return 0;
            }
        }
        g();
        return -1;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        sVar.peekFully(this.f12088g, 0, 6, false);
        this.f12084c.U(this.f12088g, 6);
        if (r3.h.b(this.f12084c)) {
            return true;
        }
        sVar.peekFully(this.f12088g, 6, 3, false);
        this.f12084c.U(this.f12088g, 9);
        return r3.h.b(this.f12084c);
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return l2.q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return l2.q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        throw new IllegalStateException();
    }
}
