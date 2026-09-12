package androidx.media3.exoplayer.mediacodec;

import android.media.LoudnessCodecController;
import android.media.LoudnessCodecController$OnLoudnessCodecUpdateListener;
import android.media.MediaCodec;
import android.os.Bundle;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f12320a;

    /* renamed from: b, reason: collision with root package name */
    private final b f12321b;

    /* renamed from: c, reason: collision with root package name */
    private LoudnessCodecController f12322c;

    /* loaded from: classes2.dex */
    class a implements LoudnessCodecController$OnLoudnessCodecUpdateListener {
        a() {
        }

        public Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec, Bundle bundle) {
            return p.this.f12321b.a(bundle);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f12324a = new b() { // from class: androidx.media3.exoplayer.mediacodec.q
            @Override // androidx.media3.exoplayer.mediacodec.p.b
            public final Bundle a(Bundle bundle) {
                return r.a(bundle);
            }
        };

        Bundle a(Bundle bundle);
    }

    public p() {
        this(b.f12324a);
    }

    public p(b bVar) {
        this.f12320a = new HashSet();
        this.f12321b = bVar;
    }

    public void b(MediaCodec mediaCodec) {
        boolean addMediaCodec;
        LoudnessCodecController loudnessCodecController = this.f12322c;
        if (loudnessCodecController != null) {
            addMediaCodec = loudnessCodecController.addMediaCodec(mediaCodec);
            if (!addMediaCodec) {
                return;
            }
        }
        androidx.media3.common.util.a.g(this.f12320a.add(mediaCodec));
    }

    public void c() {
        this.f12320a.clear();
        LoudnessCodecController loudnessCodecController = this.f12322c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    public void d(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!this.f12320a.remove(mediaCodec) || (loudnessCodecController = this.f12322c) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void e(int i11) {
        LoudnessCodecController create;
        boolean addMediaCodec;
        LoudnessCodecController loudnessCodecController = this.f12322c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f12322c = null;
        }
        create = LoudnessCodecController.create(i11, MoreExecutors.a(), new a());
        this.f12322c = create;
        Iterator it = this.f12320a.iterator();
        while (it.hasNext()) {
            addMediaCodec = create.addMediaCodec((MediaCodec) it.next());
            if (!addMediaCodec) {
                it.remove();
            }
        }
    }
}
