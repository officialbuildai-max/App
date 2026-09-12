package o9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.util.d0;
import g9.a0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class m {

    /* renamed from: d, reason: collision with root package name */
    private static final com.google.common.base.o f70990d = com.google.common.base.o.f(':');

    /* renamed from: e, reason: collision with root package name */
    private static final com.google.common.base.o f70991e = com.google.common.base.o.f('*');

    /* renamed from: a, reason: collision with root package name */
    private final List f70992a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f70993b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f70994c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f70995a;

        /* renamed from: b, reason: collision with root package name */
        public final long f70996b;

        /* renamed from: c, reason: collision with root package name */
        public final int f70997c;

        public a(int i11, long j11, int i12) {
            this.f70995a = i11;
            this.f70996b = j11;
            this.f70997c = i12;
        }
    }

    private void a(g9.m mVar, a0 a0Var) {
        d0 d0Var = new d0(8);
        mVar.readFully(d0Var.d(), 0, 8);
        this.f70994c = d0Var.q() + 8;
        if (d0Var.n() != 1397048916) {
            a0Var.f63492a = 0L;
        } else {
            a0Var.f63492a = mVar.getPosition() - (this.f70994c - 12);
            this.f70993b = 2;
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

    private void d(g9.m mVar, a0 a0Var) {
        long length = mVar.getLength();
        int i11 = this.f70994c - 20;
        d0 d0Var = new d0(i11);
        mVar.readFully(d0Var.d(), 0, i11);
        for (int i12 = 0; i12 < i11 / 12; i12++) {
            d0Var.Q(2);
            short s11 = d0Var.s();
            if (s11 == 2192 || s11 == 2816 || s11 == 2817 || s11 == 2819 || s11 == 2820) {
                this.f70992a.add(new a(s11, (length - this.f70994c) - d0Var.q(), d0Var.q()));
            } else {
                d0Var.Q(8);
            }
        }
        if (this.f70992a.isEmpty()) {
            a0Var.f63492a = 0L;
        } else {
            this.f70993b = 3;
            a0Var.f63492a = ((a) this.f70992a.get(0)).f70996b;
        }
    }

    private void e(g9.m mVar, List list) {
        long position = mVar.getPosition();
        int length = (int) ((mVar.getLength() - mVar.getPosition()) - this.f70994c);
        d0 d0Var = new d0(length);
        mVar.readFully(d0Var.d(), 0, length);
        for (int i11 = 0; i11 < this.f70992a.size(); i11++) {
            a aVar = (a) this.f70992a.get(i11);
            d0Var.P((int) (aVar.f70996b - position));
            d0Var.Q(4);
            int q11 = d0Var.q();
            int b11 = b(d0Var.A(q11));
            int i12 = aVar.f70997c - (q11 + 8);
            if (b11 == 2192) {
                list.add(f(d0Var, i12));
            } else if (b11 != 2816 && b11 != 2817 && b11 != 2819 && b11 != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(d0 d0Var, int i11) {
        ArrayList arrayList = new ArrayList();
        List i12 = f70991e.i(d0Var.A(i11));
        for (int i13 = 0; i13 < i12.size(); i13++) {
            List i14 = f70990d.i((CharSequence) i12.get(i13));
            if (i14.size() != 3) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong((String) i14.get(0)), Long.parseLong((String) i14.get(1)), 1 << (Integer.parseInt((String) i14.get(2)) - 1)));
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedContainer(null, e11);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(g9.m mVar, a0 a0Var, List list) {
        int i11 = this.f70993b;
        long j11 = 0;
        if (i11 == 0) {
            long length = mVar.getLength();
            if (length != -1 && length >= 8) {
                j11 = length - 8;
            }
            a0Var.f63492a = j11;
            this.f70993b = 1;
        } else if (i11 == 1) {
            a(mVar, a0Var);
        } else if (i11 == 2) {
            d(mVar, a0Var);
        } else {
            if (i11 != 3) {
                throw new IllegalStateException();
            }
            e(mVar, list);
            a0Var.f63492a = 0L;
        }
        return 1;
    }

    public void g() {
        this.f70992a.clear();
        this.f70993b = 0;
    }
}
