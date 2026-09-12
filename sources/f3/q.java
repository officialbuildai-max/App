package f3;

import a3.c;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.j0;
import java.util.ArrayList;
import java.util.List;
import l2.l0;

/* loaded from: classes2.dex */
final class q {

    /* renamed from: d, reason: collision with root package name */
    private static final com.google.common.base.o f62405d = com.google.common.base.o.f(':');

    /* renamed from: e, reason: collision with root package name */
    private static final com.google.common.base.o f62406e = com.google.common.base.o.f('*');

    /* renamed from: a, reason: collision with root package name */
    private final List f62407a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f62408b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f62409c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f62410a;

        /* renamed from: b, reason: collision with root package name */
        public final long f62411b;

        /* renamed from: c, reason: collision with root package name */
        public final int f62412c;

        public a(int i11, long j11, int i12) {
            this.f62410a = i11;
            this.f62411b = j11;
            this.f62412c = i12;
        }
    }

    private void a(l2.s sVar, l0 l0Var) {
        j0 j0Var = new j0(8);
        sVar.readFully(j0Var.e(), 0, 8);
        this.f62409c = j0Var.u() + 8;
        if (j0Var.q() != 1397048916) {
            l0Var.f68743a = 0L;
        } else {
            l0Var.f68743a = sVar.getPosition() - (this.f62409c - 12);
            this.f62408b = 2;
        }
    }

    private static int b(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c11 = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 2192;
            case 1:
                return 2819;
            case 2:
                return 2816;
            case 3:
                return 2820;
            case 4:
                return 2817;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
        }
    }

    private void d(l2.s sVar, l0 l0Var) {
        long length = sVar.getLength();
        int i11 = this.f62409c - 20;
        j0 j0Var = new j0(i11);
        sVar.readFully(j0Var.e(), 0, i11);
        for (int i12 = 0; i12 < i11 / 12; i12++) {
            j0Var.X(2);
            short w11 = j0Var.w();
            if (w11 == 2192 || w11 == 2816 || w11 == 2817 || w11 == 2819 || w11 == 2820) {
                this.f62407a.add(new a(w11, (length - this.f62409c) - j0Var.u(), j0Var.u()));
            } else {
                j0Var.X(8);
            }
        }
        if (this.f62407a.isEmpty()) {
            l0Var.f68743a = 0L;
        } else {
            this.f62408b = 3;
            l0Var.f68743a = ((a) this.f62407a.get(0)).f62411b;
        }
    }

    private void e(l2.s sVar, List list) {
        long position = sVar.getPosition();
        int length = (int) ((sVar.getLength() - sVar.getPosition()) - this.f62409c);
        j0 j0Var = new j0(length);
        sVar.readFully(j0Var.e(), 0, length);
        for (int i11 = 0; i11 < this.f62407a.size(); i11++) {
            a aVar = (a) this.f62407a.get(i11);
            j0Var.W((int) (aVar.f62411b - position));
            j0Var.X(4);
            int u11 = j0Var.u();
            int b11 = b(j0Var.E(u11));
            int i12 = aVar.f62412c - (u11 + 8);
            if (b11 == 2192) {
                list.add(f(j0Var, i12));
            } else if (b11 != 2816 && b11 != 2817 && b11 != 2819 && b11 != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static a3.c f(j0 j0Var, int i11) {
        ArrayList arrayList = new ArrayList();
        List i12 = f62406e.i(j0Var.E(i11));
        for (int i13 = 0; i13 < i12.size(); i13++) {
            List i14 = f62405d.i((CharSequence) i12.get(i13));
            if (i14.size() != 3) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            try {
                arrayList.add(new c.a(Long.parseLong((String) i14.get(0)), Long.parseLong((String) i14.get(1)), 1 << (Integer.parseInt((String) i14.get(2)) - 1)));
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedContainer(null, e11);
            }
        }
        return new a3.c(arrayList);
    }

    public int c(l2.s sVar, l0 l0Var, List list) {
        int i11 = this.f62408b;
        long j11 = 0;
        if (i11 == 0) {
            long length = sVar.getLength();
            if (length != -1 && length >= 8) {
                j11 = length - 8;
            }
            l0Var.f68743a = j11;
            this.f62408b = 1;
        } else if (i11 == 1) {
            a(sVar, l0Var);
        } else if (i11 == 2) {
            d(sVar, l0Var);
        } else {
            if (i11 != 3) {
                throw new IllegalStateException();
            }
            e(sVar, list);
            l0Var.f68743a = 0L;
        }
        return 1;
    }

    public void g() {
        this.f62407a.clear();
        this.f62408b = 0;
    }
}
