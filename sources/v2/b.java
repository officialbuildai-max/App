package v2;

import androidx.media3.common.util.i0;
import androidx.media3.common.x;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import u2.c;

/* loaded from: classes2.dex */
public final class b extends c {
    private static x c(i0 i0Var) {
        i0Var.r(12);
        int d11 = (i0Var.d() + i0Var.h(12)) - 4;
        i0Var.r(44);
        i0Var.s(i0Var.h(12));
        i0Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (i0Var.d() >= d11) {
                break;
            }
            i0Var.r(48);
            int h11 = i0Var.h(8);
            i0Var.r(4);
            int d12 = i0Var.d() + i0Var.h(12);
            String str2 = null;
            while (i0Var.d() < d12) {
                int h12 = i0Var.h(8);
                int h13 = i0Var.h(8);
                int d13 = i0Var.d() + h13;
                if (h12 == 2) {
                    int h14 = i0Var.h(16);
                    i0Var.r(8);
                    if (h14 != 3) {
                    }
                    while (i0Var.d() < d13) {
                        str = i0Var.l(i0Var.h(8), StandardCharsets.US_ASCII);
                        int h15 = i0Var.h(8);
                        for (int i11 = 0; i11 < h15; i11++) {
                            i0Var.s(i0Var.h(8));
                        }
                    }
                } else if (h12 == 21) {
                    str2 = i0Var.l(h13, StandardCharsets.US_ASCII);
                }
                i0Var.p(d13 * 8);
            }
            i0Var.p(d12 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new a(h11, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new x(arrayList);
    }

    @Override // u2.c
    protected x b(u2.b bVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new i0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
