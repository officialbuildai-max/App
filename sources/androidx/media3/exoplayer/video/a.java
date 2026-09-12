package androidx.media3.exoplayer.video;

import androidx.media3.container.ObuParser;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private ObuParser.d f13156a;

    private boolean a(ObuParser.c cVar, boolean z10) {
        ObuParser.d dVar;
        int i11 = cVar.f10652a;
        if (i11 == 2 || i11 == 15) {
            return true;
        }
        if (i11 == 3 && !z10) {
            return false;
        }
        if ((i11 != 6 && i11 != 3) || (dVar = this.f13156a) == null) {
            return false;
        }
        ObuParser.b b11 = ObuParser.b.b(dVar, cVar);
        return (b11 == null || b11.a()) ? false : true;
    }

    private void e(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (((ObuParser.c) list.get(i11)).f10652a == 1) {
                this.f13156a = ObuParser.d.a((ObuParser.c) list.get(i11));
            }
        }
    }

    public void b(ByteBuffer byteBuffer) {
        e(ObuParser.e(byteBuffer));
    }

    public void c() {
        this.f13156a = null;
    }

    public int d(ByteBuffer byteBuffer, boolean z10) {
        List e11 = ObuParser.e(byteBuffer);
        e(e11);
        int size = e11.size() - 1;
        int i11 = 0;
        while (size >= 0 && a((ObuParser.c) e11.get(size), z10)) {
            if (((ObuParser.c) e11.get(size)).f10652a == 6 || ((ObuParser.c) e11.get(size)).f10652a == 3) {
                i11++;
            }
            size--;
        }
        return (i11 > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((ObuParser.c) e11.get(size)).f10653b.limit() : byteBuffer.position();
    }
}
