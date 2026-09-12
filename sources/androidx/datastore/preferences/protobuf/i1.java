package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: f, reason: collision with root package name */
    private static final i1 f8916f = new i1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    private int f8917a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f8918b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f8919c;

    /* renamed from: d, reason: collision with root package name */
    private int f8920d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8921e;

    private i1() {
        this(0, new int[8], new Object[8], true);
    }

    private i1(int i11, int[] iArr, Object[] objArr, boolean z10) {
        this.f8920d = -1;
        this.f8917a = i11;
        this.f8918b = iArr;
        this.f8919c = objArr;
        this.f8921e = z10;
    }

    private void b(int i11) {
        int[] iArr = this.f8918b;
        if (i11 > iArr.length) {
            int i12 = this.f8917a;
            int i13 = i12 + (i12 / 2);
            if (i13 >= i11) {
                i11 = i13;
            }
            if (i11 < 8) {
                i11 = 8;
            }
            this.f8918b = Arrays.copyOf(iArr, i11);
            this.f8919c = Arrays.copyOf(this.f8919c, i11);
        }
    }

    public static i1 c() {
        return f8916f;
    }

    private static int f(int[] iArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        return i12;
    }

    private static int g(Object[] objArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + objArr[i13].hashCode();
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i1 j(i1 i1Var, i1 i1Var2) {
        int i11 = i1Var.f8917a + i1Var2.f8917a;
        int[] copyOf = Arrays.copyOf(i1Var.f8918b, i11);
        System.arraycopy(i1Var2.f8918b, 0, copyOf, i1Var.f8917a, i1Var2.f8917a);
        Object[] copyOf2 = Arrays.copyOf(i1Var.f8919c, i11);
        System.arraycopy(i1Var2.f8919c, 0, copyOf2, i1Var.f8917a, i1Var2.f8917a);
        return new i1(i11, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i1 k() {
        return new i1();
    }

    private static boolean l(Object[] objArr, Object[] objArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (!objArr[i12].equals(objArr2[i12])) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(int[] iArr, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (iArr[i12] != iArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    private static void q(int i11, Object obj, Writer writer) {
        int a11 = WireFormat.a(i11);
        int b11 = WireFormat.b(i11);
        if (b11 == 0) {
            writer.writeInt64(a11, ((Long) obj).longValue());
            return;
        }
        if (b11 == 1) {
            writer.writeFixed64(a11, ((Long) obj).longValue());
            return;
        }
        if (b11 == 2) {
            writer.b(a11, (ByteString) obj);
            return;
        }
        if (b11 != 3) {
            if (b11 != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
            }
            writer.writeFixed32(a11, ((Integer) obj).intValue());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(a11);
            ((i1) obj).r(writer);
            writer.writeEndGroup(a11);
        } else {
            writer.writeEndGroup(a11);
            ((i1) obj).r(writer);
            writer.writeStartGroup(a11);
        }
    }

    void a() {
        if (!this.f8921e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int V;
        int i11 = this.f8920d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f8917a; i13++) {
            int i14 = this.f8918b[i13];
            int a11 = WireFormat.a(i14);
            int b11 = WireFormat.b(i14);
            if (b11 == 0) {
                V = CodedOutputStream.V(a11, ((Long) this.f8919c[i13]).longValue());
            } else if (b11 == 1) {
                V = CodedOutputStream.p(a11, ((Long) this.f8919c[i13]).longValue());
            } else if (b11 == 2) {
                V = CodedOutputStream.h(a11, (ByteString) this.f8919c[i13]);
            } else if (b11 == 3) {
                V = (CodedOutputStream.S(a11) * 2) + ((i1) this.f8919c[i13]).d();
            } else {
                if (b11 != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                }
                V = CodedOutputStream.n(a11, ((Integer) this.f8919c[i13]).intValue());
            }
            i12 += V;
        }
        this.f8920d = i12;
        return i12;
    }

    public int e() {
        int i11 = this.f8920d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f8917a; i13++) {
            i12 += CodedOutputStream.H(WireFormat.a(this.f8918b[i13]), (ByteString) this.f8919c[i13]);
        }
        this.f8920d = i12;
        return i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        int i11 = this.f8917a;
        return i11 == i1Var.f8917a && o(this.f8918b, i1Var.f8918b, i11) && l(this.f8919c, i1Var.f8919c, this.f8917a);
    }

    public void h() {
        if (this.f8921e) {
            this.f8921e = false;
        }
    }

    public int hashCode() {
        int i11 = this.f8917a;
        return ((((527 + i11) * 31) + f(this.f8918b, i11)) * 31) + g(this.f8919c, this.f8917a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1 i(i1 i1Var) {
        if (i1Var.equals(c())) {
            return this;
        }
        a();
        int i11 = this.f8917a + i1Var.f8917a;
        b(i11);
        System.arraycopy(i1Var.f8918b, 0, this.f8918b, this.f8917a, i1Var.f8917a);
        System.arraycopy(i1Var.f8919c, 0, this.f8919c, this.f8917a, i1Var.f8917a);
        this.f8917a = i11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.f8917a; i12++) {
            p0.d(sb2, i11, String.valueOf(WireFormat.a(this.f8918b[i12])), this.f8919c[i12]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i11, Object obj) {
        a();
        b(this.f8917a + 1);
        int[] iArr = this.f8918b;
        int i12 = this.f8917a;
        iArr[i12] = i11;
        this.f8919c[i12] = obj;
        this.f8917a = i12 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i11 = this.f8917a - 1; i11 >= 0; i11--) {
                writer.writeMessageSetItem(WireFormat.a(this.f8918b[i11]), this.f8919c[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.f8917a; i12++) {
            writer.writeMessageSetItem(WireFormat.a(this.f8918b[i12]), this.f8919c[i12]);
        }
    }

    public void r(Writer writer) {
        if (this.f8917a == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i11 = 0; i11 < this.f8917a; i11++) {
                q(this.f8918b[i11], this.f8919c[i11], writer);
            }
            return;
        }
        for (int i12 = this.f8917a - 1; i12 >= 0; i12--) {
            q(this.f8918b[i12], this.f8919c[i12], writer);
        }
    }
}
