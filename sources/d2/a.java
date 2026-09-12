package d2;

import android.graphics.Bitmap;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.image.ImageDecoderException;
import androidx.media3.exoplayer.x3;
import d2.c;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class a extends SimpleDecoder implements d2.c {

    /* renamed from: o, reason: collision with root package name */
    private final b f61249o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d2.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0753a extends d {
        C0753a() {
        }

        @Override // androidx.media3.decoder.h
        public void release() {
            a.this.p(this);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        Bitmap a(byte[] bArr, int i11);
    }

    /* loaded from: classes2.dex */
    public static final class c implements c.a {

        /* renamed from: b, reason: collision with root package name */
        private final b f61251b = new b() { // from class: d2.b
            @Override // d2.a.b
            public final Bitmap a(byte[] bArr, int i11) {
                Bitmap t11;
                t11 = a.t(bArr, i11);
                return t11;
            }
        };

        @Override // d2.c.a
        public int a(r rVar) {
            String str = rVar.f10243o;
            return (str == null || !y.q(str)) ? x3.a(0) : a1.E0(rVar.f10243o) ? x3.a(4) : x3.a(1);
        }

        @Override // d2.c.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(this.f61251b, null);
        }
    }

    private a(b bVar) {
        super(new DecoderInputBuffer[1], new d[1]);
        this.f61249o = bVar;
    }

    /* synthetic */ a(b bVar, C0753a c0753a) {
        this(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bitmap t(byte[] bArr, int i11) {
        return x(bArr, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap x(byte[] bArr, int i11) {
        try {
            return w1.b.a(bArr, i11, null, -1);
        } catch (ParserException e11) {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i11 + ")", e11);
        } catch (IOException e12) {
            throw new ImageDecoderException(e12);
        }
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    public /* bridge */ /* synthetic */ d dequeueOutputBuffer() {
        return (d) super.dequeueOutputBuffer();
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    protected DecoderInputBuffer e() {
        return new DecoderInputBuffer(1);
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "BitmapFactoryImageDecoder";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public d f() {
        return new C0753a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImageDecoderException g(Throwable th2) {
        return new ImageDecoderException("Unexpected decode error", th2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ImageDecoderException h(DecoderInputBuffer decoderInputBuffer, d dVar, boolean z10) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(decoderInputBuffer.f11000c);
            androidx.media3.common.util.a.g(byteBuffer.hasArray());
            androidx.media3.common.util.a.a(byteBuffer.arrayOffset() == 0);
            dVar.f61253a = this.f61249o.a(byteBuffer.array(), byteBuffer.remaining());
            dVar.timeUs = decoderInputBuffer.f11002e;
            return null;
        } catch (ImageDecoderException e11) {
            return e11;
        }
    }
}
