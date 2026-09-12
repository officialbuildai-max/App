package s9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.common.base.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class a extends g {
    private static Metadata c(c0 c0Var) {
        c0Var.r(12);
        int d11 = (c0Var.d() + c0Var.h(12)) - 4;
        c0Var.r(44);
        c0Var.s(c0Var.h(12));
        c0Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (c0Var.d() >= d11) {
                break;
            }
            c0Var.r(48);
            int h11 = c0Var.h(8);
            c0Var.r(4);
            int d12 = c0Var.d() + c0Var.h(12);
            String str2 = null;
            while (c0Var.d() < d12) {
                int h12 = c0Var.h(8);
                int h13 = c0Var.h(8);
                int d13 = c0Var.d() + h13;
                if (h12 == 2) {
                    int h14 = c0Var.h(16);
                    c0Var.r(8);
                    if (h14 != 3) {
                    }
                    while (c0Var.d() < d13) {
                        str = c0Var.l(c0Var.h(8), c.f30280a);
                        int h15 = c0Var.h(8);
                        for (int i11 = 0; i11 < h15; i11++) {
                            c0Var.s(c0Var.h(8));
                        }
                    }
                } else if (h12 == 21) {
                    str2 = c0Var.l(h13, c.f30280a);
                }
                c0Var.p(d13 * 8);
            }
            c0Var.p(d12 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new AppInfoTable(h11, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // com.google.android.exoplayer2.metadata.g
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new c0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
