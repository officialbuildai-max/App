package d2;

import androidx.media3.common.r;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.g;
import d2.a;

/* loaded from: classes2.dex */
public interface c extends g {

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f61252a = new a.c();

        int a(r rVar);

        c b();
    }

    void b(DecoderInputBuffer decoderInputBuffer);

    @Override // androidx.media3.decoder.g
    d dequeueOutputBuffer();
}
