package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import androidx.datastore.preferences.protobuf.h0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements Writer {

    /* renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f8927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8928a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f8928a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8928a[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8928a[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8928a[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8928a[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8928a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8928a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8928a[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8928a[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8928a[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8928a[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8928a[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private k(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) w.b(codedOutputStream, "output");
        this.f8927a = codedOutputStream2;
        codedOutputStream2.f8757a = this;
    }

    private void A(int i11, f0 f0Var, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < f0Var.size()) {
                this.f8927a.D0(i11, f0Var.getLong(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < f0Var.size(); i14++) {
            i13 += CodedOutputStream.z(f0Var.getLong(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < f0Var.size()) {
            this.f8927a.E0(f0Var.getLong(i12));
            i12++;
        }
    }

    private void B(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.D0(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.z(((Long) list.get(i14)).longValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.E0(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    private void C(int i11, Object obj) {
        if (obj instanceof String) {
            this.f8927a.R0(i11, (String) obj);
        } else {
            this.f8927a.l0(i11, (ByteString) obj);
        }
    }

    private void D(int i11, v vVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < vVar.size()) {
                this.f8927a.J0(i11, vVar.getInt(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < vVar.size(); i14++) {
            i13 += CodedOutputStream.J(vVar.getInt(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < vVar.size()) {
            this.f8927a.K0(vVar.getInt(i12));
            i12++;
        }
    }

    private void E(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.J0(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.J(((Integer) list.get(i14)).intValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.K0(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    private void F(int i11, f0 f0Var, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < f0Var.size()) {
                this.f8927a.L0(i11, f0Var.getLong(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < f0Var.size(); i14++) {
            i13 += CodedOutputStream.L(f0Var.getLong(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < f0Var.size()) {
            this.f8927a.M0(f0Var.getLong(i12));
            i12++;
        }
    }

    private void G(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.L0(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.L(((Long) list.get(i14)).longValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.M0(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    private void H(int i11, v vVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < vVar.size()) {
                this.f8927a.N0(i11, vVar.getInt(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < vVar.size(); i14++) {
            i13 += CodedOutputStream.N(vVar.getInt(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < vVar.size()) {
            this.f8927a.O0(vVar.getInt(i12));
            i12++;
        }
    }

    private void J(int i11, f0 f0Var, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < f0Var.size()) {
                this.f8927a.P0(i11, f0Var.getLong(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < f0Var.size(); i14++) {
            i13 += CodedOutputStream.P(f0Var.getLong(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < f0Var.size()) {
            this.f8927a.Q0(f0Var.getLong(i12));
            i12++;
        }
    }

    private void K(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.P0(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.P(((Long) list.get(i14)).longValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.Q0(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    private void L(int i11, v vVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < vVar.size()) {
                this.f8927a.U0(i11, vVar.getInt(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < vVar.size(); i14++) {
            i13 += CodedOutputStream.U(vVar.getInt(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < vVar.size()) {
            this.f8927a.V0(vVar.getInt(i12));
            i12++;
        }
    }

    private void N(int i11, f0 f0Var, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < f0Var.size()) {
                this.f8927a.W0(i11, f0Var.getLong(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < f0Var.size(); i14++) {
            i13 += CodedOutputStream.W(f0Var.getLong(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < f0Var.size()) {
            this.f8927a.X0(f0Var.getLong(i12));
            i12++;
        }
    }

    private void O(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.W0(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.W(((Long) list.get(i14)).longValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.X0(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public static k g(CodedOutputStream codedOutputStream) {
        k kVar = codedOutputStream.f8757a;
        return kVar != null ? kVar : new k(codedOutputStream);
    }

    private void h(int i11, f fVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < fVar.size()) {
                this.f8927a.h0(i11, fVar.getBoolean(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < fVar.size(); i14++) {
            i13 += CodedOutputStream.f(fVar.getBoolean(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < fVar.size()) {
            this.f8927a.i0(fVar.getBoolean(i12));
            i12++;
        }
    }

    private void i(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.h0(i11, ((Boolean) list.get(i12)).booleanValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.f(((Boolean) list.get(i14)).booleanValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.i0(((Boolean) list.get(i12)).booleanValue());
            i12++;
        }
    }

    private void j(int i11, boolean z10, Object obj, h0.a aVar) {
        this.f8927a.T0(i11, 2);
        this.f8927a.V0(h0.b(aVar, Boolean.valueOf(z10), obj));
        h0.e(this.f8927a, aVar, Boolean.valueOf(z10), obj);
    }

    private void k(int i11, h0.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            iArr[i12] = ((Integer) it.next()).intValue();
            i12++;
        }
        Arrays.sort(iArr);
        for (int i13 = 0; i13 < size; i13++) {
            int i14 = iArr[i13];
            Object obj = map.get(Integer.valueOf(i14));
            this.f8927a.T0(i11, 2);
            this.f8927a.V0(h0.b(aVar, Integer.valueOf(i14), obj));
            h0.e(this.f8927a, aVar, Integer.valueOf(i14), obj);
        }
    }

    private void l(int i11, h0.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            jArr[i12] = ((Long) it.next()).longValue();
            i12++;
        }
        Arrays.sort(jArr);
        for (int i13 = 0; i13 < size; i13++) {
            long j11 = jArr[i13];
            Object obj = map.get(Long.valueOf(j11));
            this.f8927a.T0(i11, 2);
            this.f8927a.V0(h0.b(aVar, Long.valueOf(j11), obj));
            h0.e(this.f8927a, aVar, Long.valueOf(j11), obj);
        }
    }

    private void m(int i11, h0.a aVar, Map map) {
        switch (a.f8928a[aVar.f8863a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    j(i11, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    j(i11, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                k(i11, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                l(i11, aVar, map);
                return;
            case 12:
                n(i11, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f8863a);
        }
    }

    private void n(int i11, h0.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            strArr[i12] = (String) it.next();
            i12++;
        }
        Arrays.sort(strArr);
        for (int i13 = 0; i13 < size; i13++) {
            String str = strArr[i13];
            Object obj = map.get(str);
            this.f8927a.T0(i11, 2);
            this.f8927a.V0(h0.b(aVar, str, obj));
            h0.e(this.f8927a, aVar, str, obj);
        }
    }

    private void o(int i11, l lVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < lVar.size()) {
                this.f8927a.n0(i11, lVar.getDouble(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < lVar.size(); i14++) {
            i13 += CodedOutputStream.k(lVar.getDouble(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < lVar.size()) {
            this.f8927a.o0(lVar.getDouble(i12));
            i12++;
        }
    }

    private void p(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.n0(i11, ((Double) list.get(i12)).doubleValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.k(((Double) list.get(i14)).doubleValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.o0(((Double) list.get(i12)).doubleValue());
            i12++;
        }
    }

    private void q(int i11, v vVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < vVar.size()) {
                this.f8927a.p0(i11, vVar.getInt(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < vVar.size(); i14++) {
            i13 += CodedOutputStream.m(vVar.getInt(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < vVar.size()) {
            this.f8927a.q0(vVar.getInt(i12));
            i12++;
        }
    }

    private void r(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.p0(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.m(((Integer) list.get(i14)).intValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.q0(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    private void s(int i11, v vVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < vVar.size()) {
                this.f8927a.r0(i11, vVar.getInt(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < vVar.size(); i14++) {
            i13 += CodedOutputStream.o(vVar.getInt(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < vVar.size()) {
            this.f8927a.s0(vVar.getInt(i12));
            i12++;
        }
    }

    private void t(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.r0(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.o(((Integer) list.get(i14)).intValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.s0(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    private void u(int i11, f0 f0Var, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < f0Var.size()) {
                this.f8927a.t0(i11, f0Var.getLong(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < f0Var.size(); i14++) {
            i13 += CodedOutputStream.q(f0Var.getLong(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < f0Var.size()) {
            this.f8927a.u0(f0Var.getLong(i12));
            i12++;
        }
    }

    private void v(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.t0(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.q(((Long) list.get(i14)).longValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.u0(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    private void w(int i11, t tVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < tVar.size()) {
                this.f8927a.v0(i11, tVar.getFloat(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < tVar.size(); i14++) {
            i13 += CodedOutputStream.s(tVar.getFloat(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < tVar.size()) {
            this.f8927a.w0(tVar.getFloat(i12));
            i12++;
        }
    }

    private void x(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.v0(i11, ((Float) list.get(i12)).floatValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.s(((Float) list.get(i14)).floatValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.w0(((Float) list.get(i12)).floatValue());
            i12++;
        }
    }

    private void y(int i11, v vVar, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < vVar.size()) {
                this.f8927a.B0(i11, vVar.getInt(i12));
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < vVar.size(); i14++) {
            i13 += CodedOutputStream.x(vVar.getInt(i14));
        }
        this.f8927a.V0(i13);
        while (i12 < vVar.size()) {
            this.f8927a.C0(vVar.getInt(i12));
            i12++;
        }
    }

    private void z(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.B0(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.x(((Integer) list.get(i14)).intValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.C0(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public void I(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.N0(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.N(((Integer) list.get(i14)).intValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.O0(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public void M(int i11, List list, boolean z10) {
        int i12 = 0;
        if (!z10) {
            while (i12 < list.size()) {
                this.f8927a.U0(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.f8927a.T0(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            i13 += CodedOutputStream.U(((Integer) list.get(i14)).intValue());
        }
        this.f8927a.V0(i13);
        while (i12 < list.size()) {
            this.f8927a.V0(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void a(int i11, List list, b1 b1Var) {
        for (int i12 = 0; i12 < list.size(); i12++) {
            e(i11, list.get(i12), b1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void b(int i11, ByteString byteString) {
        this.f8927a.l0(i11, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void c(int i11, Object obj, b1 b1Var) {
        this.f8927a.F0(i11, (n0) obj, b1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void d(int i11, h0.a aVar, Map map) {
        if (this.f8927a.b0()) {
            m(i11, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f8927a.T0(i11, 2);
            this.f8927a.V0(h0.b(aVar, entry.getKey(), entry.getValue()));
            h0.e(this.f8927a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void e(int i11, Object obj, b1 b1Var) {
        this.f8927a.y0(i11, (n0) obj, b1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void f(int i11, List list, b1 b1Var) {
        for (int i12 = 0; i12 < list.size(); i12++) {
            c(i11, list.get(i12), b1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBool(int i11, boolean z10) {
        this.f8927a.h0(i11, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBoolList(int i11, List list, boolean z10) {
        if (list instanceof f) {
            h(i11, (f) list, z10);
        } else {
            i(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytesList(int i11, List list) {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f8927a.l0(i11, (ByteString) list.get(i12));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDouble(int i11, double d11) {
        this.f8927a.n0(i11, d11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDoubleList(int i11, List list, boolean z10) {
        if (list instanceof l) {
            o(i11, (l) list, z10);
        } else {
            p(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEndGroup(int i11) {
        this.f8927a.T0(i11, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnum(int i11, int i12) {
        this.f8927a.p0(i11, i12);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnumList(int i11, List list, boolean z10) {
        if (list instanceof v) {
            q(i11, (v) list, z10);
        } else {
            r(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32(int i11, int i12) {
        this.f8927a.r0(i11, i12);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32List(int i11, List list, boolean z10) {
        if (list instanceof v) {
            s(i11, (v) list, z10);
        } else {
            t(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64(int i11, long j11) {
        this.f8927a.t0(i11, j11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64List(int i11, List list, boolean z10) {
        if (list instanceof f0) {
            u(i11, (f0) list, z10);
        } else {
            v(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloat(int i11, float f11) {
        this.f8927a.v0(i11, f11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloatList(int i11, List list, boolean z10) {
        if (list instanceof t) {
            w(i11, (t) list, z10);
        } else {
            x(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32(int i11, int i12) {
        this.f8927a.B0(i11, i12);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32List(int i11, List list, boolean z10) {
        if (list instanceof v) {
            y(i11, (v) list, z10);
        } else {
            z(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64(int i11, long j11) {
        this.f8927a.D0(i11, j11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64List(int i11, List list, boolean z10) {
        if (list instanceof f0) {
            A(i11, (f0) list, z10);
        } else {
            B(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageSetItem(int i11, Object obj) {
        if (obj instanceof ByteString) {
            this.f8927a.I0(i11, (ByteString) obj);
        } else {
            this.f8927a.H0(i11, (n0) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32(int i11, int i12) {
        this.f8927a.J0(i11, i12);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32List(int i11, List list, boolean z10) {
        if (list instanceof v) {
            D(i11, (v) list, z10);
        } else {
            E(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64(int i11, long j11) {
        this.f8927a.L0(i11, j11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64List(int i11, List list, boolean z10) {
        if (list instanceof f0) {
            F(i11, (f0) list, z10);
        } else {
            G(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32(int i11, int i12) {
        this.f8927a.N0(i11, i12);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32List(int i11, List list, boolean z10) {
        if (list instanceof v) {
            H(i11, (v) list, z10);
        } else {
            I(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64(int i11, long j11) {
        this.f8927a.P0(i11, j11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64List(int i11, List list, boolean z10) {
        if (list instanceof f0) {
            J(i11, (f0) list, z10);
        } else {
            K(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStartGroup(int i11) {
        this.f8927a.T0(i11, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeString(int i11, String str) {
        this.f8927a.R0(i11, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStringList(int i11, List list) {
        int i12 = 0;
        if (!(list instanceof b0)) {
            while (i12 < list.size()) {
                this.f8927a.R0(i11, (String) list.get(i12));
                i12++;
            }
        } else {
            b0 b0Var = (b0) list;
            while (i12 < list.size()) {
                C(i11, b0Var.getRaw(i12));
                i12++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32(int i11, int i12) {
        this.f8927a.U0(i11, i12);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32List(int i11, List list, boolean z10) {
        if (list instanceof v) {
            L(i11, (v) list, z10);
        } else {
            M(i11, list, z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64(int i11, long j11) {
        this.f8927a.W0(i11, j11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64List(int i11, List list, boolean z10) {
        if (list instanceof f0) {
            N(i11, (f0) list, z10);
        } else {
            O(i11, list, z10);
        }
    }
}
