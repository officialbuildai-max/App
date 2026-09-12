package g9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.b;
import java.io.EOFException;

/* loaded from: classes4.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f63600a = new com.google.android.exoplayer2.util.d0(10);

    public Metadata a(m mVar, b.a aVar) {
        Metadata metadata = null;
        int i11 = 0;
        while (true) {
            try {
                mVar.peekFully(this.f63600a.d(), 0, 10);
                this.f63600a.P(0);
                if (this.f63600a.G() != 4801587) {
                    break;
                }
                this.f63600a.Q(3);
                int C = this.f63600a.C();
                int i12 = C + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.f63600a.d(), 0, bArr, 0, 10);
                    mVar.peekFully(bArr, 10, C);
                    metadata = new com.google.android.exoplayer2.metadata.id3.b(aVar).e(bArr, i12);
                } else {
                    mVar.advancePeekPosition(C);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i11);
        return metadata;
    }
}
