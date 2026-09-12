package s3;

import android.util.SparseArray;
import androidx.media3.common.r;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import s3.l0;

/* loaded from: classes2.dex */
public final class j implements l0.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f75109a;

    /* renamed from: b, reason: collision with root package name */
    private final List f75110b;

    public j() {
        this(0);
    }

    public j(int i11) {
        this(i11, ImmutableList.of());
    }

    public j(int i11, List list) {
        this.f75109a = i11;
        this.f75110b = list;
    }

    private g0 b(l0.b bVar) {
        return new g0(d(bVar), "video/mp2t");
    }

    private n0 c(l0.b bVar) {
        return new n0(d(bVar), "video/mp2t");
    }

    private List d(l0.b bVar) {
        String str;
        int i11;
        if (e(32)) {
            return this.f75110b;
        }
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(bVar.f75171e);
        List list = this.f75110b;
        while (j0Var.a() > 0) {
            int H = j0Var.H();
            int f11 = j0Var.f() + j0Var.H();
            if (H == 134) {
                list = new ArrayList();
                int H2 = j0Var.H() & 31;
                for (int i12 = 0; i12 < H2; i12++) {
                    String E = j0Var.E(3);
                    int H3 = j0Var.H();
                    boolean z10 = (H3 & 128) != 0;
                    if (z10) {
                        i11 = H3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i11 = 1;
                    }
                    byte H4 = (byte) j0Var.H();
                    j0Var.X(1);
                    list.add(new r.b().u0(str).j0(E).O(i11).g0(z10 ? androidx.media3.common.util.j.e((H4 & 64) != 0) : null).N());
                }
            }
            j0Var.W(f11);
        }
        return list;
    }

    private boolean e(int i11) {
        return (i11 & this.f75109a) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0030. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0033. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    @Override // s3.l0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s3.l0 a(int r6, s3.l0.b r7) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.j.a(int, s3.l0$b):s3.l0");
    }

    @Override // s3.l0.c
    public SparseArray createInitialPayloadReaders() {
        return new SparseArray();
    }
}
