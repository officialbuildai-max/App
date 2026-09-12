package c4;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import c4.c;
import java.util.Arrays;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z3.e;

/* loaded from: classes2.dex */
public abstract class c implements e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f17070d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f17071a;

    /* renamed from: b, reason: collision with root package name */
    private final String f17072b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17073c;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(String str) {
            String obj = StringsKt.n1(str).toString();
            if (obj.length() < 3) {
                return false;
            }
            String substring = obj.substring(0, 3);
            Intrinsics.g(substring, "substring(...)");
            String upperCase = substring.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            int hashCode = upperCase.hashCode();
            if (hashCode != 79487) {
                if (hashCode != 81978) {
                    if (hashCode != 85954 || !upperCase.equals("WIT")) {
                        return false;
                    }
                } else if (!upperCase.equals("SEL")) {
                    return false;
                }
            } else if (!upperCase.equals("PRA")) {
                return false;
            }
            return true;
        }

        public final c a(SQLiteDatabase db2, String sql) {
            Intrinsics.h(db2, "db");
            Intrinsics.h(sql, "sql");
            return b(sql) ? new C0168c(db2, sql) : new b(db2, sql);
        }
    }

    /* loaded from: classes2.dex */
    private static final class b extends c {

        /* renamed from: e, reason: collision with root package name */
        private final SQLiteStatement f17074e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SQLiteDatabase db2, String sql) {
            super(db2, sql, null);
            Intrinsics.h(db2, "db");
            Intrinsics.h(sql, "sql");
            SQLiteStatement compileStatement = db2.compileStatement(sql);
            Intrinsics.g(compileStatement, "compileStatement(...)");
            this.f17074e = compileStatement;
        }

        @Override // z3.e
        public boolean A0() {
            k();
            this.f17074e.execute();
            return false;
        }

        @Override // z3.e
        public void a(int i11, double d11) {
            k();
            this.f17074e.bindDouble(i11, d11);
        }

        @Override // z3.e
        public void c(int i11, long j11) {
            k();
            this.f17074e.bindLong(i11, j11);
        }

        @Override // z3.e, java.lang.AutoCloseable
        public void close() {
            this.f17074e.close();
            i(true);
        }

        @Override // z3.e
        public void e(int i11, byte[] value) {
            Intrinsics.h(value, "value");
            k();
            this.f17074e.bindBlob(i11, value);
        }

        @Override // z3.e
        public void g(int i11) {
            k();
            this.f17074e.bindNull(i11);
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
            this.f17074e.bindString(i11, value);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c4.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0168c extends c {

        /* renamed from: k, reason: collision with root package name */
        public static final a f17075k = new a(null);

        /* renamed from: e, reason: collision with root package name */
        private int[] f17076e;

        /* renamed from: f, reason: collision with root package name */
        private long[] f17077f;

        /* renamed from: g, reason: collision with root package name */
        private double[] f17078g;

        /* renamed from: h, reason: collision with root package name */
        private String[] f17079h;

        /* renamed from: i, reason: collision with root package name */
        private byte[][] f17080i;

        /* renamed from: j, reason: collision with root package name */
        private Cursor f17081j;

        /* renamed from: c4.c$c$a */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0168c(SQLiteDatabase db2, String sql) {
            super(db2, sql, null);
            Intrinsics.h(db2, "db");
            Intrinsics.h(sql, "sql");
            this.f17076e = new int[0];
            this.f17077f = new long[0];
            this.f17078g = new double[0];
            this.f17079h = new String[0];
            this.f17080i = new byte[0];
        }

        private final void m(SQLiteProgram sQLiteProgram) {
            int length = this.f17076e.length;
            for (int i11 = 1; i11 < length; i11++) {
                int i12 = this.f17076e[i11];
                if (i12 == 1) {
                    sQLiteProgram.bindLong(i11, this.f17077f[i11]);
                } else if (i12 == 2) {
                    sQLiteProgram.bindDouble(i11, this.f17078g[i11]);
                } else if (i12 == 3) {
                    sQLiteProgram.bindString(i11, this.f17079h[i11]);
                } else if (i12 == 4) {
                    sQLiteProgram.bindBlob(i11, this.f17080i[i11]);
                } else if (i12 == 5) {
                    sQLiteProgram.bindNull(i11);
                }
            }
        }

        private final void n(int i11, int i12) {
            int i13 = i12 + 1;
            int[] iArr = this.f17076e;
            if (iArr.length < i13) {
                int[] copyOf = Arrays.copyOf(iArr, i13);
                Intrinsics.g(copyOf, "copyOf(...)");
                this.f17076e = copyOf;
            }
            if (i11 == 1) {
                long[] jArr = this.f17077f;
                if (jArr.length < i13) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i13);
                    Intrinsics.g(copyOf2, "copyOf(...)");
                    this.f17077f = copyOf2;
                    return;
                }
                return;
            }
            if (i11 == 2) {
                double[] dArr = this.f17078g;
                if (dArr.length < i13) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i13);
                    Intrinsics.g(copyOf3, "copyOf(...)");
                    this.f17078g = copyOf3;
                    return;
                }
                return;
            }
            if (i11 == 3) {
                String[] strArr = this.f17079h;
                if (strArr.length < i13) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i13);
                    Intrinsics.g(copyOf4, "copyOf(...)");
                    this.f17079h = (String[]) copyOf4;
                    return;
                }
                return;
            }
            if (i11 != 4) {
                return;
            }
            byte[][] bArr = this.f17080i;
            if (bArr.length < i13) {
                Object[] copyOf5 = Arrays.copyOf(bArr, i13);
                Intrinsics.g(copyOf5, "copyOf(...)");
                this.f17080i = (byte[][]) copyOf5;
            }
        }

        private final void o() {
            if (this.f17081j == null) {
                this.f17081j = d().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: c4.d
                    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                        Cursor p11;
                        p11 = c.C0168c.p(c.C0168c.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                        return p11;
                    }
                }, h(), new String[0], null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Cursor p(C0168c c0168c, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            Intrinsics.e(sQLiteQuery);
            c0168c.m(sQLiteQuery);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        private final void q(Cursor cursor, int i11) {
            if (i11 < 0 || i11 >= cursor.getColumnCount()) {
                z3.a.b(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        private final Cursor r() {
            Cursor cursor = this.f17081j;
            if (cursor != null) {
                return cursor;
            }
            z3.a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public boolean A0() {
            k();
            o();
            Cursor cursor = this.f17081j;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }

        @Override // z3.e
        public void a(int i11, double d11) {
            k();
            n(2, i11);
            this.f17076e[i11] = 2;
            this.f17078g[i11] = d11;
        }

        @Override // z3.e
        public void c(int i11, long j11) {
            k();
            n(1, i11);
            this.f17076e[i11] = 1;
            this.f17077f[i11] = j11;
        }

        @Override // z3.e, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                reset();
            }
            i(true);
        }

        @Override // z3.e
        public void e(int i11, byte[] value) {
            Intrinsics.h(value, "value");
            k();
            n(4, i11);
            this.f17076e[i11] = 4;
            this.f17080i[i11] = value;
        }

        @Override // z3.e
        public void g(int i11) {
            k();
            n(5, i11);
            this.f17076e[i11] = 5;
        }

        @Override // z3.e
        public byte[] getBlob(int i11) {
            k();
            Cursor r11 = r();
            q(r11, i11);
            byte[] blob = r11.getBlob(i11);
            Intrinsics.g(blob, "getBlob(...)");
            return blob;
        }

        @Override // z3.e
        public int getColumnCount() {
            k();
            o();
            Cursor cursor = this.f17081j;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // z3.e
        public String getColumnName(int i11) {
            k();
            o();
            Cursor cursor = this.f17081j;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            q(cursor, i11);
            String columnName = cursor.getColumnName(i11);
            Intrinsics.g(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // z3.e
        public double getDouble(int i11) {
            k();
            Cursor r11 = r();
            q(r11, i11);
            return r11.getDouble(i11);
        }

        @Override // z3.e
        public long getLong(int i11) {
            k();
            Cursor r11 = r();
            q(r11, i11);
            return r11.getLong(i11);
        }

        @Override // z3.e
        public boolean isNull(int i11) {
            k();
            Cursor r11 = r();
            q(r11, i11);
            return r11.isNull(i11);
        }

        @Override // z3.e
        public void j(int i11, String value) {
            Intrinsics.h(value, "value");
            k();
            n(3, i11);
            this.f17076e[i11] = 3;
            this.f17079h[i11] = value;
        }

        @Override // z3.e
        public String n0(int i11) {
            k();
            Cursor r11 = r();
            q(r11, i11);
            String string = r11.getString(i11);
            Intrinsics.g(string, "getString(...)");
            return string;
        }

        @Override // z3.e
        public void reset() {
            k();
            Cursor cursor = this.f17081j;
            if (cursor != null) {
                cursor.close();
            }
            this.f17081j = null;
        }
    }

    private c(SQLiteDatabase sQLiteDatabase, String str) {
        this.f17071a = sQLiteDatabase;
        this.f17072b = str;
    }

    public /* synthetic */ c(SQLiteDatabase sQLiteDatabase, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(sQLiteDatabase, str);
    }

    protected final SQLiteDatabase d() {
        return this.f17071a;
    }

    @Override // z3.e
    public /* synthetic */ boolean getBoolean(int i11) {
        return z3.d.a(this, i11);
    }

    protected final String h() {
        return this.f17072b;
    }

    protected final void i(boolean z10) {
        this.f17073c = z10;
    }

    protected final boolean isClosed() {
        return this.f17073c;
    }

    protected final void k() {
        if (this.f17073c) {
            z3.a.b(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }
}
