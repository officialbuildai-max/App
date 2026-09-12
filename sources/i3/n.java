package i3;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l2.h0;
import l2.l0;
import l2.s0;

/* loaded from: classes2.dex */
public class n implements l2.r {

    /* renamed from: a, reason: collision with root package name */
    private final s f65029a;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.r f65031c;

    /* renamed from: d, reason: collision with root package name */
    private final List f65032d;

    /* renamed from: g, reason: collision with root package name */
    private s0 f65035g;

    /* renamed from: h, reason: collision with root package name */
    private int f65036h;

    /* renamed from: i, reason: collision with root package name */
    private int f65037i;

    /* renamed from: j, reason: collision with root package name */
    private long[] f65038j;

    /* renamed from: k, reason: collision with root package name */
    private long f65039k;

    /* renamed from: b, reason: collision with root package name */
    private final d f65030b = new d();

    /* renamed from: f, reason: collision with root package name */
    private byte[] f65034f = a1.f10437f;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f65033e = new j0();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final long f65040a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f65041b;

        private b(long j11, byte[] bArr) {
            this.f65040a = j11;
            this.f65041b = bArr;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return Long.compare(this.f65040a, bVar.f65040a);
        }
    }

    public n(s sVar, androidx.media3.common.r rVar) {
        this.f65029a = sVar;
        this.f65031c = rVar != null ? rVar.b().u0("application/x-media3-cues").S(rVar.f10243o).W(sVar.c()).N() : null;
        this.f65032d = new ArrayList();
        this.f65037i = 0;
        this.f65038j = a1.f10438g;
        this.f65039k = C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(e eVar) {
        b bVar = new b(eVar.f65020b, this.f65030b.a(eVar.f65019a, eVar.f65021c));
        this.f65032d.add(bVar);
        long j11 = this.f65039k;
        if (j11 == C.TIME_UNSET || eVar.f65020b >= j11) {
            l(bVar);
        }
    }

    private void h() {
        try {
            long j11 = this.f65039k;
            this.f65029a.a(this.f65034f, 0, this.f65036h, j11 != C.TIME_UNSET ? s.b.c(j11) : s.b.b(), new androidx.media3.common.util.m() { // from class: i3.m
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    n.this.g((e) obj);
                }
            });
            Collections.sort(this.f65032d);
            this.f65038j = new long[this.f65032d.size()];
            for (int i11 = 0; i11 < this.f65032d.size(); i11++) {
                this.f65038j[i11] = ((b) this.f65032d.get(i11)).f65040a;
            }
            this.f65034f = a1.f10437f;
        } catch (RuntimeException e11) {
            throw ParserException.createForMalformedContainer("SubtitleParser failed.", e11);
        }
    }

    private boolean i(l2.s sVar) {
        byte[] bArr = this.f65034f;
        if (bArr.length == this.f65036h) {
            this.f65034f = Arrays.copyOf(bArr, bArr.length + 1024);
        }
        byte[] bArr2 = this.f65034f;
        int i11 = this.f65036h;
        int read = sVar.read(bArr2, i11, bArr2.length - i11);
        if (read != -1) {
            this.f65036h += read;
        }
        long length = sVar.getLength();
        return (length != -1 && ((long) this.f65036h) == length) || read == -1;
    }

    private boolean j(l2.s sVar) {
        return sVar.skip((sVar.getLength() > (-1L) ? 1 : (sVar.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(sVar.getLength()) : 1024) == -1;
    }

    private void k() {
        long j11 = this.f65039k;
        for (int h11 = j11 == C.TIME_UNSET ? 0 : a1.h(this.f65038j, j11, true, true); h11 < this.f65032d.size(); h11++) {
            l((b) this.f65032d.get(h11));
        }
    }

    private void l(b bVar) {
        androidx.media3.common.util.a.i(this.f65035g);
        int length = bVar.f65041b.length;
        this.f65033e.T(bVar.f65041b);
        this.f65035g.b(this.f65033e, length);
        this.f65035g.d(bVar.f65040a, 1, length, 0, null);
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        androidx.media3.common.util.a.g(this.f65037i == 0);
        s0 track = tVar.track(0, 3);
        this.f65035g = track;
        androidx.media3.common.r rVar = this.f65031c;
        if (rVar != null) {
            track.c(rVar);
            tVar.endTracks();
            tVar.f(new h0(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        }
        this.f65037i = 1;
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        int i11 = this.f65037i;
        androidx.media3.common.util.a.g((i11 == 0 || i11 == 5) ? false : true);
        if (this.f65037i == 1) {
            int d11 = sVar.getLength() != -1 ? Ints.d(sVar.getLength()) : 1024;
            if (d11 > this.f65034f.length) {
                this.f65034f = new byte[d11];
            }
            this.f65036h = 0;
            this.f65037i = 2;
        }
        if (this.f65037i == 2 && i(sVar)) {
            h();
            this.f65037i = 4;
        }
        if (this.f65037i == 3 && j(sVar)) {
            k();
            this.f65037i = 4;
        }
        return this.f65037i == 4 ? -1 : 0;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        return true;
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
        if (this.f65037i == 5) {
            return;
        }
        this.f65029a.reset();
        this.f65037i = 5;
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        int i11 = this.f65037i;
        androidx.media3.common.util.a.g((i11 == 0 || i11 == 5) ? false : true);
        this.f65039k = j12;
        if (this.f65037i == 2) {
            this.f65037i = 1;
        }
        if (this.f65037i == 4) {
            this.f65037i = 3;
        }
    }
}
