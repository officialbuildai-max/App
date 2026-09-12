package ma;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.y2;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class b extends h {

    /* renamed from: n, reason: collision with root package name */
    private final DecoderInputBuffer f69548n;

    /* renamed from: o, reason: collision with root package name */
    private final d0 f69549o;

    /* renamed from: p, reason: collision with root package name */
    private long f69550p;

    /* renamed from: q, reason: collision with root package name */
    private a f69551q;

    /* renamed from: r, reason: collision with root package name */
    private long f69552r;

    public b() {
        super(6);
        this.f69548n = new DecoderInputBuffer(1);
        this.f69549o = new d0();
    }

    private void A() {
        a aVar = this.f69551q;
        if (aVar != null) {
            aVar.b();
        }
    }

    private float[] z(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f69549o.N(byteBuffer.array(), byteBuffer.limit());
        this.f69549o.P(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i11 = 0; i11 < 3; i11++) {
            fArr[i11] = Float.intBitsToFloat(this.f69549o.q());
        }
        return fArr;
    }

    @Override // com.google.android.exoplayer2.z2
    public int a(o1 o1Var) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(o1Var.f25550l) ? y2.a(4) : y2.a(0);
    }

    @Override // com.google.android.exoplayer2.x2, com.google.android.exoplayer2.z2
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.h, com.google.android.exoplayer2.s2.b
    public void handleMessage(int i11, Object obj) {
        if (i11 == 8) {
            this.f69551q = (a) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.h
    protected void p() {
        A();
    }

    @Override // com.google.android.exoplayer2.h
    protected void r(long j11, boolean z10) {
        this.f69552r = Long.MIN_VALUE;
        A();
    }

    @Override // com.google.android.exoplayer2.x2
    public void render(long j11, long j12) {
        while (!hasReadStreamToEnd() && this.f69552r < 100000 + j11) {
            this.f69548n.b();
            if (w(k(), this.f69548n, 0) != -4 || this.f69548n.h()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.f69548n;
            this.f69552r = decoderInputBuffer.f24899e;
            if (this.f69551q != null && !decoderInputBuffer.g()) {
                this.f69548n.n();
                float[] z10 = z((ByteBuffer) p0.j(this.f69548n.f24897c));
                if (z10 != null) {
                    ((a) p0.j(this.f69551q)).a(this.f69552r - this.f69550p, z10);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.h
    protected void v(o1[] o1VarArr, long j11, long j12) {
        this.f69550p = j12;
    }
}
