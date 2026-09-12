package androidx.room.driver;

import a4.f;
import a4.g;
import a4.h;
import android.database.Cursor;
import java.util.Arrays;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z3.e;

/* loaded from: classes2.dex */
public abstract class d implements e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f14745d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final a4.d f14746a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14747b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14748c;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int c(String str) {
            int i11;
            int length = str.length() - 2;
            if (length < 0) {
                return -1;
            }
            int i12 = 0;
            while (i12 < length) {
                char charAt = str.charAt(i12);
                if (Intrinsics.j(charAt, 32) > 0) {
                    if (charAt == '-') {
                        if (str.charAt(i12 + 1) != '-') {
                            return i12;
                        }
                        i12 = StringsKt.n0(str, '\n', i12 + 2, false, 4, null);
                        if (i12 < 0) {
                            return -1;
                        }
                    } else {
                        if (charAt != '/') {
                            return i12;
                        }
                        int i13 = i12 + 1;
                        if (str.charAt(i13) != '*') {
                            return i12;
                        }
                        do {
                            i13 = StringsKt.n0(str, '*', i13 + 1, false, 4, null);
                            if (i13 >= 0) {
                                i11 = i13 + 1;
                                if (i11 >= length) {
                                    break;
                                }
                            } else {
                                return -1;
                            }
                        } while (str.charAt(i11) != '/');
                        i12 = i13 + 2;
                    }
                }
                i12++;
            }
            return -1;
        }

        private final boolean d(String str) {
            int hashCode = str.hashCode();
            return hashCode == 79487 ? str.equals("PRA") : !(hashCode == 81978 ? !str.equals("SEL") : !(hashCode == 85954 && str.equals("WIT")));
        }

        public final d a(a4.d db2, String sql) {
            Intrinsics.h(db2, "db");
            Intrinsics.h(sql, "sql");
            String upperCase = StringsKt.n1(sql).toString().toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            String b11 = b(upperCase);
            if (b11 != null && d(b11)) {
                return new b(db2, sql);
            }
            return new c(db2, sql);
        }

        public final String b(String sql) {
            Intrinsics.h(sql, "sql");
            int c11 = c(sql);
            if (c11 < 0 || c11 > sql.length()) {
                return null;
            }
            String substring = sql.substring(c11, Math.min(c11 + 3, sql.length()));
            Intrinsics.g(substring, "substring(...)");
            return substring;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends d {

        /* renamed from: k, reason: collision with root package name */
        public static final a f14749k = new a(null);

        /* renamed from: e, reason: collision with root package name */
        private int[] f14750e;

        /* renamed from: f, reason: collision with root package name */
        private long[] f14751f;

        /* renamed from: g, reason: collision with root package name */
        private double[] f14752g;

        /* renamed from: h, reason: collision with root package name */
        private String[] f14753h;

        /* renamed from: i, reason: collision with root package name */
        private byte[][] f14754i;

        /* renamed from: j, reason: collision with root package name */
        private Cursor f14755j;

        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* renamed from: androidx.room.driver.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0124b implements g {
            C0124b() {
            }

            @Override // a4.g
            public void b(f statement) {
                Intrinsics.h(statement, "statement");
                int length = b.this.f14750e.length;
                for (int i11 = 1; i11 < length; i11++) {
                    int i12 = b.this.f14750e[i11];
                    if (i12 == 1) {
                        statement.c(i11, b.this.f14751f[i11]);
                    } else if (i12 == 2) {
                        statement.a(i11, b.this.f14752g[i11]);
                    } else if (i12 == 3) {
                        String str = b.this.f14753h[i11];
                        Intrinsics.e(str);
                        statement.y(i11, str);
                    } else if (i12 == 4) {
                        byte[] bArr = b.this.f14754i[i11];
                        Intrinsics.e(bArr);
                        statement.e(i11, bArr);
                    } else if (i12 == 5) {
                        statement.g(i11);
                    }
                }
            }

            @Override // a4.g
            public String d() {
                return b.this.h();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a4.d db2, String sql) {
            super(db2, sql, null);
            Intrinsics.h(db2, "db");
            Intrinsics.h(sql, "sql");
            this.f14750e = new int[0];
            this.f14751f = new long[0];
            this.f14752g = new double[0];
            this.f14753h = new String[0];
            this.f14754i = new byte[0];
        }

        private final void r(int i11, int i12) {
            int i13 = i12 + 1;
            int[] iArr = this.f14750e;
            if (iArr.length < i13) {
                int[] copyOf = Arrays.copyOf(iArr, i13);
                Intrinsics.g(copyOf, "copyOf(...)");
                this.f14750e = copyOf;
            }
            if (i11 == 1) {
                long[] jArr = this.f14751f;
                if (jArr.length < i13) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i13);
                    Intrinsics.g(copyOf2, "copyOf(...)");
                    this.f14751f = copyOf2;
                    return;
                }
                return;
            }
            if (i11 == 2) {
                double[] dArr = this.f14752g;
                if (dArr.length < i13) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i13);
                    Intrinsics.g(copyOf3, "copyOf(...)");
                    this.f14752g = copyOf3;
                    return;
                }
                return;
            }
            if (i11 == 3) {
                String[] strArr = this.f14753h;
                if (strArr.length < i13) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i13);
                    Intrinsics.g(copyOf4, "copyOf(...)");
                    this.f14753h = (String[]) copyOf4;
                    return;
                }
                return;
            }
            if (i11 != 4) {
                return;
            }
            byte[][] bArr = this.f14754i;
            if (bArr.length < i13) {
                Object[] copyOf5 = Arrays.copyOf(bArr, i13);
                Intrinsics.g(copyOf5, "copyOf(...)");
                this.f14754i = (byte[][]) copyOf5;
            }
        }

        private final void s() {
            if (this.f14755j == null) {
                this.f14755j = d().b0(new C0124b());
            }
        }

        private final void t(Cursor cursor, int i11) {
            if (i11 < 0 || i11 >= cursor.getColumnCount()) {
                z3.a.b(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        private final Cursor u() {
            Cursor cursor = this.f14755j;
            if (cursor != null) {
                return cursor;
            }
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public boolean A0() {
            k();
            s();
            Cursor cursor = this.f14755j;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }

        @Override // z3.e
        public void a(int i11, double d11) {
            k();
            r(2, i11);
            this.f14750e[i11] = 2;
            this.f14752g[i11] = d11;
        }

        @Override // z3.e
        public void c(int i11, long j11) {
            k();
            r(1, i11);
            this.f14750e[i11] = 1;
            this.f14751f[i11] = j11;
        }

        @Override // z3.e, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                q();
                reset();
            }
            i(true);
        }

        @Override // z3.e
        public void e(int i11, byte[] value) {
            Intrinsics.h(value, "value");
            k();
            r(4, i11);
            this.f14750e[i11] = 4;
            this.f14754i[i11] = value;
        }

        @Override // z3.e
        public void g(int i11) {
            k();
            r(5, i11);
            this.f14750e[i11] = 5;
        }

        @Override // z3.e
        public byte[] getBlob(int i11) {
            k();
            Cursor u11 = u();
            t(u11, i11);
            byte[] blob = u11.getBlob(i11);
            Intrinsics.g(blob, "getBlob(...)");
            return blob;
        }

        @Override // z3.e
        public int getColumnCount() {
            k();
            s();
            Cursor cursor = this.f14755j;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // z3.e
        public String getColumnName(int i11) {
            k();
            s();
            Cursor cursor = this.f14755j;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            t(cursor, i11);
            String columnName = cursor.getColumnName(i11);
            Intrinsics.g(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // z3.e
        public double getDouble(int i11) {
            k();
            Cursor u11 = u();
            t(u11, i11);
            return u11.getDouble(i11);
        }

        @Override // z3.e
        public long getLong(int i11) {
            k();
            Cursor u11 = u();
            t(u11, i11);
            return u11.getLong(i11);
        }

        @Override // z3.e
        public boolean isNull(int i11) {
            k();
            Cursor u11 = u();
            t(u11, i11);
            return u11.isNull(i11);
        }

        @Override // z3.e
        public void j(int i11, String value) {
            Intrinsics.h(value, "value");
            k();
            r(3, i11);
            this.f14750e[i11] = 3;
            this.f14753h[i11] = value;
        }

        @Override // z3.e
        public String n0(int i11) {
            k();
            Cursor u11 = u();
            t(u11, i11);
            String string = u11.getString(i11);
            Intrinsics.g(string, "getString(...)");
            return string;
        }

        public void q() {
            k();
            this.f14750e = new int[0];
            this.f14751f = new long[0];
            this.f14752g = new double[0];
            this.f14753h = new String[0];
            this.f14754i = new byte[0];
        }

        @Override // z3.e
        public void reset() {
            k();
            Cursor cursor = this.f14755j;
            if (cursor != null) {
                cursor.close();
            }
            this.f14755j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends d {

        /* renamed from: e, reason: collision with root package name */
        private final h f14757e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a4.d db2, String sql) {
            super(db2, sql, null);
            Intrinsics.h(db2, "db");
            Intrinsics.h(sql, "sql");
            this.f14757e = db2.W(sql);
        }

        @Override // z3.e
        public boolean A0() {
            k();
            this.f14757e.execute();
            return false;
        }

        @Override // z3.e
        public void a(int i11, double d11) {
            k();
            this.f14757e.a(i11, d11);
        }

        @Override // z3.e
        public void c(int i11, long j11) {
            k();
            this.f14757e.c(i11, j11);
        }

        @Override // z3.e, java.lang.AutoCloseable
        public void close() {
            this.f14757e.close();
            i(true);
        }

        @Override // z3.e
        public void e(int i11, byte[] value) {
            Intrinsics.h(value, "value");
            k();
            this.f14757e.e(i11, value);
        }

        @Override // z3.e
        public void g(int i11) {
            k();
            this.f14757e.g(i11);
        }

        @Override // z3.e
        public byte[] getBlob(int i11) {
            k();
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public int getColumnCount() {
            k();
            return 0;
        }

        @Override // z3.e
        public String getColumnName(int i11) {
            k();
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public double getDouble(int i11) {
            k();
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public long getLong(int i11) {
            k();
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public boolean isNull(int i11) {
            k();
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public void j(int i11, String value) {
            Intrinsics.h(value, "value");
            k();
            this.f14757e.y(i11, value);
        }

        @Override // z3.e
        public String n0(int i11) {
            k();
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public void reset() {
        }
    }

    private d(a4.d dVar, String str) {
        this.f14746a = dVar;
        this.f14747b = str;
    }

    public /* synthetic */ d(a4.d dVar, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, str);
    }

    protected final a4.d d() {
        return this.f14746a;
    }

    @Override // z3.e
    public /* synthetic */ boolean getBoolean(int i11) {
        return z3.d.a(this, i11);
    }

    protected final String h() {
        return this.f14747b;
    }

    protected final void i(boolean z10) {
        this.f14748c = z10;
    }

    protected final boolean isClosed() {
        return this.f14748c;
    }

    protected final void k() {
        if (this.f14748c) {
            z3.a.b(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }
}
