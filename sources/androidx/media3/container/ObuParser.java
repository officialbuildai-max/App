package androidx.media3.container;

import androidx.media3.common.util.i0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ObuParser {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NotYetImplementedException extends Exception {
        private NotYetImplementedException() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f10651a;

        private b(d dVar, c cVar) {
            int i11 = cVar.f10652a;
            androidx.media3.common.util.a.a(i11 == 6 || i11 == 3);
            byte[] bArr = new byte[Math.min(4, cVar.f10653b.remaining())];
            cVar.f10653b.asReadOnlyBuffer().get(bArr);
            i0 i0Var = new i0(bArr);
            ObuParser.f(dVar.f10654a);
            if (i0Var.g()) {
                this.f10651a = false;
                return;
            }
            int h11 = i0Var.h(2);
            boolean g11 = i0Var.g();
            ObuParser.f(dVar.f10655b);
            if (!g11) {
                this.f10651a = true;
                return;
            }
            boolean g12 = (h11 == 3 || h11 == 0) ? true : i0Var.g();
            i0Var.q();
            ObuParser.f(!dVar.f10657d);
            if (i0Var.g()) {
                ObuParser.f(!dVar.f10658e);
                i0Var.q();
            }
            ObuParser.f(dVar.f10656c);
            if (h11 != 3) {
                i0Var.q();
            }
            i0Var.r(dVar.f10659f);
            if (h11 != 2 && h11 != 0 && !g12) {
                i0Var.r(3);
            }
            this.f10651a = ((h11 == 3 || h11 == 0) ? 255 : i0Var.h(8)) != 0;
        }

        public static b b(d dVar, c cVar) {
            try {
                return new b(dVar, cVar);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        public boolean a() {
            return this.f10651a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10652a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteBuffer f10653b;

        private c(int i11, ByteBuffer byteBuffer) {
            this.f10652a = i11;
            this.f10653b = byteBuffer;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f10654a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10655b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10656c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10657d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10658e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10659f;

        private d(c cVar) {
            androidx.media3.common.util.a.a(cVar.f10652a == 1);
            byte[] bArr = new byte[cVar.f10653b.remaining()];
            cVar.f10653b.asReadOnlyBuffer().get(bArr);
            i0 i0Var = new i0(bArr);
            i0Var.r(4);
            boolean g11 = i0Var.g();
            this.f10654a = g11;
            ObuParser.f(g11);
            if (i0Var.g()) {
                b(i0Var);
                boolean g12 = i0Var.g();
                this.f10655b = g12;
                if (g12) {
                    i0Var.r(47);
                }
            } else {
                this.f10655b = false;
            }
            boolean g13 = i0Var.g();
            int h11 = i0Var.h(5);
            for (int i11 = 0; i11 <= h11; i11++) {
                i0Var.r(12);
                if (i0Var.h(5) > 7) {
                    i0Var.q();
                }
                ObuParser.f(this.f10655b);
                if (g13 && i0Var.g()) {
                    i0Var.r(4);
                }
            }
            int h12 = i0Var.h(4);
            int h13 = i0Var.h(4);
            i0Var.r(h12 + 1);
            i0Var.r(h13 + 1);
            boolean g14 = i0Var.g();
            this.f10656c = g14;
            ObuParser.f(g14);
            i0Var.r(3);
            i0Var.r(4);
            boolean g15 = i0Var.g();
            if (g15) {
                i0Var.r(2);
            }
            if (i0Var.g()) {
                this.f10657d = true;
            } else {
                this.f10657d = i0Var.g();
            }
            if (!this.f10657d) {
                this.f10658e = true;
            } else if (i0Var.g()) {
                this.f10658e = true;
            } else {
                this.f10658e = i0Var.g();
            }
            if (g15) {
                this.f10659f = i0Var.h(3) + 1;
            } else {
                this.f10659f = 0;
            }
        }

        public static d a(c cVar) {
            try {
                return new d(cVar);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        private static void b(i0 i0Var) {
            i0Var.r(64);
            if (i0Var.g()) {
                ObuParser.d(i0Var);
            }
        }
    }

    private static int c(ByteBuffer byteBuffer) {
        int i11 = 0;
        for (int i12 = 0; i12 < 8; i12++) {
            byte b11 = byteBuffer.get();
            i11 |= (b11 & Byte.MAX_VALUE) << (i12 * 7);
            if ((b11 & 128) == 0) {
                break;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(i0 i0Var) {
        int i11 = 0;
        while (!i0Var.g()) {
            i11++;
        }
        if (i11 < 32) {
            i0Var.r(i11);
        }
    }

    public static List e(ByteBuffer byteBuffer) {
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (asReadOnlyBuffer.hasRemaining()) {
            byte b11 = asReadOnlyBuffer.get();
            int i11 = (b11 >> 3) & 15;
            if (((b11 >> 2) & 1) != 0) {
                asReadOnlyBuffer.get();
            }
            int c11 = ((b11 >> 1) & 1) != 0 ? c(asReadOnlyBuffer) : asReadOnlyBuffer.remaining();
            ByteBuffer duplicate = asReadOnlyBuffer.duplicate();
            duplicate.limit(asReadOnlyBuffer.position() + c11);
            arrayList.add(new c(i11, duplicate));
            asReadOnlyBuffer.position(asReadOnlyBuffer.position() + c11);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(boolean z10) {
        if (z10) {
            throw new NotYetImplementedException();
        }
    }
}
