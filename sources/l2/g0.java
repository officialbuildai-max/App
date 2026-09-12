package l2;

import java.io.EOFException;
import z2.h;

/* loaded from: classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f68705a = new androidx.media3.common.util.j0(10);

    public androidx.media3.common.x a(s sVar, h.a aVar) {
        androidx.media3.common.x xVar = null;
        int i11 = 0;
        while (true) {
            try {
                sVar.peekFully(this.f68705a.e(), 0, 10);
                this.f68705a.W(0);
                if (this.f68705a.K() != 4801587) {
                    break;
                }
                this.f68705a.X(3);
                int G = this.f68705a.G();
                int i12 = G + 10;
                if (xVar == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.f68705a.e(), 0, bArr, 0, 10);
                    sVar.peekFully(bArr, 10, G);
                    xVar = new z2.h(aVar).e(bArr, i12);
                } else {
                    sVar.advancePeekPosition(G);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        sVar.resetPeekPosition();
        sVar.advancePeekPosition(i11);
        return xVar;
    }
}
