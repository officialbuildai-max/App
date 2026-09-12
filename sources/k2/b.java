package k2;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.i;
import androidx.media3.exoplayer.x3;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class b extends i {

    /* renamed from: r, reason: collision with root package name */
    private final DecoderInputBuffer f66694r;

    /* renamed from: s, reason: collision with root package name */
    private final j0 f66695s;

    /* renamed from: t, reason: collision with root package name */
    private a f66696t;

    /* renamed from: u, reason: collision with root package name */
    private long f66697u;

    public b() {
        super(6);
        this.f66694r = new DecoderInputBuffer(1);
        this.f66695s = new j0();
    }

    private float[] Q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f66695s.U(byteBuffer.array(), byteBuffer.limit());
        this.f66695s.W(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i11 = 0; i11 < 3; i11++) {
            fArr[i11] = Float.intBitsToFloat(this.f66695s.u());
        }
        return fArr;
    }

    private void R() {
        a aVar = this.f66696t;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void C() {
        R();
    }

    @Override // androidx.media3.exoplayer.i
    protected void F(long j11, boolean z10) {
        this.f66697u = Long.MIN_VALUE;
        R();
    }

    @Override // androidx.media3.exoplayer.y3
    public int a(r rVar) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(rVar.f10243o) ? x3.a(4) : x3.a(0);
    }

    @Override // androidx.media3.exoplayer.w3, androidx.media3.exoplayer.y3
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.t3.b
    public void handleMessage(int i11, Object obj) {
        if (i11 == 8) {
            this.f66696t = (a) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        while (!hasReadStreamToEnd() && this.f66697u < 100000 + j11) {
            this.f66694r.clear();
            if (N(u(), this.f66694r, 0) != -4 || this.f66694r.isEndOfStream()) {
                return;
            }
            long j13 = this.f66694r.f11002e;
            this.f66697u = j13;
            boolean z10 = j13 < w();
            if (this.f66696t != null && !z10) {
                this.f66694r.d();
                float[] Q = Q((ByteBuffer) a1.i(this.f66694r.f11000c));
                if (Q != null) {
                    ((a) a1.i(this.f66696t)).a(this.f66697u - z(), Q);
                }
            }
        }
    }
}
