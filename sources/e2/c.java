package e2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.x;
import androidx.media3.exoplayer.i;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.x3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c extends i implements Handler.Callback {
    private x A;
    private long B;

    /* renamed from: r, reason: collision with root package name */
    private final a f61612r;

    /* renamed from: s, reason: collision with root package name */
    private final b f61613s;

    /* renamed from: t, reason: collision with root package name */
    private final Handler f61614t;

    /* renamed from: u, reason: collision with root package name */
    private final u2.b f61615u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f61616v;

    /* renamed from: w, reason: collision with root package name */
    private u2.a f61617w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f61618x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f61619y;

    /* renamed from: z, reason: collision with root package name */
    private long f61620z;

    public c(b bVar, Looper looper) {
        this(bVar, looper, a.f61611a);
    }

    public c(b bVar, Looper looper, a aVar) {
        this(bVar, looper, aVar, false);
    }

    public c(b bVar, Looper looper, a aVar, boolean z10) {
        super(5);
        this.f61613s = (b) androidx.media3.common.util.a.e(bVar);
        this.f61614t = looper == null ? null : a1.z(looper, this);
        this.f61612r = (a) androidx.media3.common.util.a.e(aVar);
        this.f61616v = z10;
        this.f61615u = new u2.b();
        this.B = C.TIME_UNSET;
    }

    private void Q(x xVar, List list) {
        for (int i11 = 0; i11 < xVar.e(); i11++) {
            r wrappedMetadataFormat = xVar.d(i11).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.f61612r.a(wrappedMetadataFormat)) {
                list.add(xVar.d(i11));
            } else {
                u2.a b11 = this.f61612r.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) androidx.media3.common.util.a.e(xVar.d(i11).getWrappedMetadataBytes());
                this.f61615u.clear();
                this.f61615u.b(bArr.length);
                ((ByteBuffer) a1.i(this.f61615u.f11000c)).put(bArr);
                this.f61615u.d();
                x a11 = b11.a(this.f61615u);
                if (a11 != null) {
                    Q(a11, list);
                }
            }
        }
    }

    private long R(long j11) {
        androidx.media3.common.util.a.g(j11 != C.TIME_UNSET);
        androidx.media3.common.util.a.g(this.B != C.TIME_UNSET);
        return j11 - this.B;
    }

    private void S(x xVar) {
        Handler handler = this.f61614t;
        if (handler != null) {
            handler.obtainMessage(1, xVar).sendToTarget();
        } else {
            T(xVar);
        }
    }

    private void T(x xVar) {
        this.f61613s.onMetadata(xVar);
    }

    private boolean U(long j11) {
        boolean z10;
        x xVar = this.A;
        if (xVar == null || (!this.f61616v && xVar.f10640b > R(j11))) {
            z10 = false;
        } else {
            S(this.A);
            this.A = null;
            z10 = true;
        }
        if (this.f61618x && this.A == null) {
            this.f61619y = true;
        }
        return z10;
    }

    private void V() {
        if (this.f61618x || this.A != null) {
            return;
        }
        this.f61615u.clear();
        s2 u11 = u();
        int N = N(u11, this.f61615u, 0);
        if (N != -4) {
            if (N == -5) {
                this.f61620z = ((r) androidx.media3.common.util.a.e(u11.f12652b)).f10248t;
                return;
            }
            return;
        }
        if (this.f61615u.isEndOfStream()) {
            this.f61618x = true;
            return;
        }
        if (this.f61615u.f11002e >= w()) {
            u2.b bVar = this.f61615u;
            bVar.f76737i = this.f61620z;
            bVar.d();
            x a11 = ((u2.a) a1.i(this.f61617w)).a(this.f61615u);
            if (a11 != null) {
                ArrayList arrayList = new ArrayList(a11.e());
                Q(a11, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.A = new x(R(this.f61615u.f11002e), arrayList);
            }
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void C() {
        this.A = null;
        this.f61617w = null;
        this.B = C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.i
    protected void F(long j11, boolean z10) {
        this.A = null;
        this.f61618x = false;
        this.f61619y = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void L(r[] rVarArr, long j11, long j12, r.b bVar) {
        this.f61617w = this.f61612r.b(rVarArr[0]);
        x xVar = this.A;
        if (xVar != null) {
            this.A = xVar.c((xVar.f10640b + this.B) - j12);
        }
        this.B = j12;
    }

    @Override // androidx.media3.exoplayer.y3
    public int a(androidx.media3.common.r rVar) {
        if (this.f61612r.a(rVar)) {
            return x3.a(rVar.N == 0 ? 4 : 2);
        }
        return x3.a(0);
    }

    @Override // androidx.media3.exoplayer.w3, androidx.media3.exoplayer.y3
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        T((x) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isEnded() {
        return this.f61619y;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        boolean z10 = true;
        while (z10) {
            V();
            z10 = U(j11);
        }
    }
}
