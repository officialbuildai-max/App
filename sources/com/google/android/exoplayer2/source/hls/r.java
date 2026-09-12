package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.a0;
import g9.b0;
import g9.e0;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class r implements g9.l {

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f26241g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f26242h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    private final String f26243a;

    /* renamed from: b, reason: collision with root package name */
    private final l0 f26244b;

    /* renamed from: d, reason: collision with root package name */
    private g9.n f26246d;

    /* renamed from: f, reason: collision with root package name */
    private int f26248f;

    /* renamed from: c, reason: collision with root package name */
    private final d0 f26245c = new d0();

    /* renamed from: e, reason: collision with root package name */
    private byte[] f26247e = new byte[1024];

    public r(String str, l0 l0Var) {
        this.f26243a = str;
        this.f26244b = l0Var;
    }

    private e0 a(long j11) {
        e0 track = this.f26246d.track(0, 3);
        track.e(new o1.b().e0(MimeTypes.TEXT_VTT).V(this.f26243a).i0(j11).E());
        this.f26246d.endTracks();
        return track;
    }

    private void e() {
        d0 d0Var = new d0(this.f26247e);
        ka.i.e(d0Var);
        long j11 = 0;
        long j12 = 0;
        for (String p11 = d0Var.p(); !TextUtils.isEmpty(p11); p11 = d0Var.p()) {
            if (p11.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f26241g.matcher(p11);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer(p11.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(p11) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "), null);
                }
                Matcher matcher2 = f26242h.matcher(p11);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer(p11.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(p11) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "), null);
                }
                j12 = ka.i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
                j11 = l0.f(Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1))));
            }
        }
        Matcher a11 = ka.i.a(d0Var);
        if (a11 == null) {
            a(0L);
            return;
        }
        long d11 = ka.i.d((String) com.google.android.exoplayer2.util.a.e(a11.group(1)));
        long b11 = this.f26244b.b(l0.j((j11 + d11) - j12));
        e0 a12 = a(b11 - d11);
        this.f26245c.N(this.f26247e, this.f26248f);
        a12.c(this.f26245c, this.f26248f);
        a12.d(b11, 1, this.f26248f, 0, null);
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.f26246d = nVar;
        nVar.d(new b0.b(C.TIME_UNSET));
    }

    @Override // g9.l
    public int c(g9.m mVar, a0 a0Var) {
        com.google.android.exoplayer2.util.a.e(this.f26246d);
        int length = (int) mVar.getLength();
        int i11 = this.f26248f;
        byte[] bArr = this.f26247e;
        if (i11 == bArr.length) {
            this.f26247e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f26247e;
        int i12 = this.f26248f;
        int read = mVar.read(bArr2, i12, bArr2.length - i12);
        if (read != -1) {
            int i13 = this.f26248f + read;
            this.f26248f = i13;
            if (length == -1 || i13 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        mVar.peekFully(this.f26247e, 0, 6, false);
        this.f26245c.N(this.f26247e, 6);
        if (ka.i.b(this.f26245c)) {
            return true;
        }
        mVar.peekFully(this.f26247e, 6, 3, false);
        this.f26245c.N(this.f26247e, 9);
        return ka.i.b(this.f26245c);
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        throw new IllegalStateException();
    }
}
