package androidx.room.support;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.room.support.AutoClosingRoomOpenHelper;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper implements a4.e, androidx.room.d {

    /* renamed from: a, reason: collision with root package name */
    private final a4.e f14827a;

    /* renamed from: b, reason: collision with root package name */
    private final AutoCloser f14828b;

    /* renamed from: c, reason: collision with root package name */
    private final AutoClosingSupportSQLiteDatabase f14829c;

    /* loaded from: classes2.dex */
    public static final class AutoClosingSupportSQLiteDatabase implements a4.d {

        /* renamed from: a, reason: collision with root package name */
        private final AutoCloser f14830a;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            Intrinsics.h(autoCloser, "autoCloser");
            this.f14830a = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit m(int i11, a4.d db2) {
            Intrinsics.h(db2, "db");
            db2.S(i11);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit n(String str, a4.d db2) {
            Intrinsics.h(db2, "db");
            db2.E(str);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit o(String str, Object[] objArr, a4.d db2) {
            Intrinsics.h(db2, "db");
            db2.J(str, objArr);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long p(String str, int i11, ContentValues contentValues, a4.d db2) {
            Intrinsics.h(db2, "db");
            return db2.j0(str, i11, contentValues);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object r(a4.d it) {
            Intrinsics.h(it, "it");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int s(String str, int i11, ContentValues contentValues, String str2, Object[] objArr, a4.d db2) {
            Intrinsics.h(db2, "db");
            return db2.f0(str, i11, contentValues, str2, objArr);
        }

        @Override // a4.d
        public void A() {
            try {
                this.f14830a.j().A();
            } catch (Throwable th2) {
                this.f14830a.g();
                throw th2;
            }
        }

        @Override // a4.d
        public List D() {
            return (List) this.f14830a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.jvm.internal.PropertyReference1
                public Object get(Object obj) {
                    return ((a4.d) obj).D();
                }
            });
        }

        @Override // a4.d
        public void E(final String sql) {
            Intrinsics.h(sql, "sql");
            this.f14830a.h(new Function1() { // from class: androidx.room.support.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n11;
                    n11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.n(sql, (a4.d) obj);
                    return n11;
                }
            });
        }

        @Override // a4.d
        public void I() {
            a4.d i11 = this.f14830a.i();
            Intrinsics.e(i11);
            i11.I();
        }

        @Override // a4.d
        public void J(final String sql, final Object[] bindArgs) {
            Intrinsics.h(sql, "sql");
            Intrinsics.h(bindArgs, "bindArgs");
            this.f14830a.h(new Function1() { // from class: androidx.room.support.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o11;
                    o11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.o(sql, bindArgs, (a4.d) obj);
                    return o11;
                }
            });
        }

        @Override // a4.d
        public void K() {
            try {
                this.f14830a.j().K();
            } catch (Throwable th2) {
                this.f14830a.g();
                throw th2;
            }
        }

        @Override // a4.d
        public void L() {
            try {
                a4.d i11 = this.f14830a.i();
                Intrinsics.e(i11);
                i11.L();
            } finally {
                this.f14830a.g();
            }
        }

        @Override // a4.d
        public void S(final int i11) {
            this.f14830a.h(new Function1() { // from class: androidx.room.support.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit m11;
                    m11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.m(i11, (a4.d) obj);
                    return m11;
                }
            });
        }

        @Override // a4.d
        public a4.h W(String sql) {
            Intrinsics.h(sql, "sql");
            return new a(sql, this.f14830a);
        }

        @Override // a4.d
        public /* synthetic */ void Y() {
            a4.c.a(this);
        }

        @Override // a4.d
        public Cursor b0(a4.g query) {
            Intrinsics.h(query, "query");
            try {
                return new b(this.f14830a.j().b0(query), this.f14830a);
            } catch (Throwable th2) {
                this.f14830a.g();
                throw th2;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f14830a.f();
        }

        @Override // a4.d
        public Cursor e0(a4.g query, CancellationSignal cancellationSignal) {
            Intrinsics.h(query, "query");
            try {
                return new b(this.f14830a.j().e0(query, cancellationSignal), this.f14830a);
            } catch (Throwable th2) {
                this.f14830a.g();
                throw th2;
            }
        }

        @Override // a4.d
        public int f0(final String table, final int i11, final ContentValues values, final String str, final Object[] objArr) {
            Intrinsics.h(table, "table");
            Intrinsics.h(values, "values");
            return ((Number) this.f14830a.h(new Function1() { // from class: androidx.room.support.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int s11;
                    s11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.s(table, i11, values, str, objArr, (a4.d) obj);
                    return Integer.valueOf(s11);
                }
            })).intValue();
        }

        @Override // a4.d
        public String getPath() {
            return (String) this.f14830a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.jvm.internal.PropertyReference1
                public Object get(Object obj) {
                    return ((a4.d) obj).getPath();
                }
            });
        }

        @Override // a4.d
        public int getVersion() {
            return ((Number) this.f14830a.h(new MutablePropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.jvm.internal.MutablePropertyReference1
                public Object get(Object obj) {
                    return Integer.valueOf(((a4.d) obj).getVersion());
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.jvm.internal.MutablePropertyReference1
                public void set(Object obj, Object obj2) {
                    ((a4.d) obj).S(((Number) obj2).intValue());
                }
            })).intValue();
        }

        @Override // a4.d
        public Cursor i0(String query) {
            Intrinsics.h(query, "query");
            try {
                return new b(this.f14830a.j().i0(query), this.f14830a);
            } catch (Throwable th2) {
                this.f14830a.g();
                throw th2;
            }
        }

        @Override // a4.d
        public boolean isOpen() {
            a4.d i11 = this.f14830a.i();
            if (i11 != null) {
                return i11.isOpen();
            }
            return false;
        }

        @Override // a4.d
        public long j0(final String table, final int i11, final ContentValues values) {
            Intrinsics.h(table, "table");
            Intrinsics.h(values, "values");
            return ((Number) this.f14830a.h(new Function1() { // from class: androidx.room.support.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long p11;
                    p11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.p(table, i11, values, (a4.d) obj);
                    return Long.valueOf(p11);
                }
            })).longValue();
        }

        public final void q() {
            this.f14830a.h(new Function1() { // from class: androidx.room.support.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object r11;
                    r11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.r((a4.d) obj);
                    return r11;
                }
            });
        }

        @Override // a4.d
        public boolean s0() {
            if (this.f14830a.i() == null) {
                return false;
            }
            return ((Boolean) this.f14830a.h(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // a4.d
        public boolean w0() {
            return ((Boolean) this.f14830a.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.jvm.internal.PropertyReference1
                public Object get(Object obj) {
                    return Boolean.valueOf(((a4.d) obj).w0());
                }
            })).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements a4.h {

        /* renamed from: h, reason: collision with root package name */
        public static final C0127a f14831h = new C0127a(null);

        /* renamed from: a, reason: collision with root package name */
        private final String f14832a;

        /* renamed from: b, reason: collision with root package name */
        private final AutoCloser f14833b;

        /* renamed from: c, reason: collision with root package name */
        private int[] f14834c;

        /* renamed from: d, reason: collision with root package name */
        private long[] f14835d;

        /* renamed from: e, reason: collision with root package name */
        private double[] f14836e;

        /* renamed from: f, reason: collision with root package name */
        private String[] f14837f;

        /* renamed from: g, reason: collision with root package name */
        private byte[][] f14838g;

        /* renamed from: androidx.room.support.AutoClosingRoomOpenHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0127a {
            private C0127a() {
            }

            public /* synthetic */ C0127a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(String sql, AutoCloser autoCloser) {
            Intrinsics.h(sql, "sql");
            Intrinsics.h(autoCloser, "autoCloser");
            this.f14832a = sql;
            this.f14833b = autoCloser;
            this.f14834c = new int[0];
            this.f14835d = new long[0];
            this.f14836e = new double[0];
            this.f14837f = new String[0];
            this.f14838g = new byte[0];
        }

        private final void k(a4.f fVar) {
            int length = this.f14834c.length;
            for (int i11 = 1; i11 < length; i11++) {
                int i12 = this.f14834c[i11];
                if (i12 == 1) {
                    fVar.c(i11, this.f14835d[i11]);
                } else if (i12 == 2) {
                    fVar.a(i11, this.f14836e[i11]);
                } else if (i12 == 3) {
                    String str = this.f14837f[i11];
                    Intrinsics.e(str);
                    fVar.y(i11, str);
                } else if (i12 == 4) {
                    byte[] bArr = this.f14838g[i11];
                    Intrinsics.e(bArr);
                    fVar.e(i11, bArr);
                } else if (i12 == 5) {
                    fVar.g(i11);
                }
            }
        }

        private final void m(int i11, int i12) {
            int i13 = i12 + 1;
            int[] iArr = this.f14834c;
            if (iArr.length < i13) {
                int[] copyOf = Arrays.copyOf(iArr, i13);
                Intrinsics.g(copyOf, "copyOf(...)");
                this.f14834c = copyOf;
            }
            if (i11 == 1) {
                long[] jArr = this.f14835d;
                if (jArr.length < i13) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i13);
                    Intrinsics.g(copyOf2, "copyOf(...)");
                    this.f14835d = copyOf2;
                    return;
                }
                return;
            }
            if (i11 == 2) {
                double[] dArr = this.f14836e;
                if (dArr.length < i13) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i13);
                    Intrinsics.g(copyOf3, "copyOf(...)");
                    this.f14836e = copyOf3;
                    return;
                }
                return;
            }
            if (i11 == 3) {
                String[] strArr = this.f14837f;
                if (strArr.length < i13) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i13);
                    Intrinsics.g(copyOf4, "copyOf(...)");
                    this.f14837f = (String[]) copyOf4;
                    return;
                }
                return;
            }
            if (i11 != 4) {
                return;
            }
            byte[][] bArr = this.f14838g;
            if (bArr.length < i13) {
                Object[] copyOf5 = Arrays.copyOf(bArr, i13);
                Intrinsics.g(copyOf5, "copyOf(...)");
                this.f14838g = (byte[][]) copyOf5;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit n(a4.h statement) {
            Intrinsics.h(statement, "statement");
            statement.execute();
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long o(a4.h obj) {
            Intrinsics.h(obj, "obj");
            return obj.R();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int p(a4.h obj) {
            Intrinsics.h(obj, "obj");
            return obj.F();
        }

        private final Object q(final Function1 function1) {
            return this.f14833b.h(new Function1() { // from class: androidx.room.support.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object r11;
                    r11 = AutoClosingRoomOpenHelper.a.r(AutoClosingRoomOpenHelper.a.this, function1, (a4.d) obj);
                    return r11;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object r(a aVar, Function1 function1, a4.d db2) {
            Intrinsics.h(db2, "db");
            a4.h W = db2.W(aVar.f14832a);
            aVar.k(W);
            return function1.invoke(W);
        }

        @Override // a4.h
        public int F() {
            return ((Number) q(new Function1() { // from class: androidx.room.support.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int p11;
                    p11 = AutoClosingRoomOpenHelper.a.p((a4.h) obj);
                    return Integer.valueOf(p11);
                }
            })).intValue();
        }

        @Override // a4.h
        public long R() {
            return ((Number) q(new Function1() { // from class: androidx.room.support.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long o11;
                    o11 = AutoClosingRoomOpenHelper.a.o((a4.h) obj);
                    return Long.valueOf(o11);
                }
            })).longValue();
        }

        @Override // a4.f
        public void a(int i11, double d11) {
            m(2, i11);
            this.f14834c[i11] = 2;
            this.f14836e[i11] = d11;
        }

        @Override // a4.f
        public void c(int i11, long j11) {
            m(1, i11);
            this.f14834c[i11] = 1;
            this.f14835d[i11] = j11;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            l();
        }

        @Override // a4.f
        public void e(int i11, byte[] value) {
            Intrinsics.h(value, "value");
            m(4, i11);
            this.f14834c[i11] = 4;
            this.f14838g[i11] = value;
        }

        @Override // a4.h
        public void execute() {
            q(new Function1() { // from class: androidx.room.support.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n11;
                    n11 = AutoClosingRoomOpenHelper.a.n((a4.h) obj);
                    return n11;
                }
            });
        }

        @Override // a4.f
        public void g(int i11) {
            m(5, i11);
            this.f14834c[i11] = 5;
        }

        public void l() {
            this.f14834c = new int[0];
            this.f14835d = new long[0];
            this.f14836e = new double[0];
            this.f14837f = new String[0];
            this.f14838g = new byte[0];
        }

        @Override // a4.f
        public void y(int i11, String value) {
            Intrinsics.h(value, "value");
            m(3, i11);
            this.f14834c[i11] = 3;
            this.f14837f[i11] = value;
        }
    }

    /* loaded from: classes2.dex */
    private static final class b implements Cursor {

        /* renamed from: a, reason: collision with root package name */
        private final Cursor f14839a;

        /* renamed from: b, reason: collision with root package name */
        private final AutoCloser f14840b;

        public b(Cursor delegate, AutoCloser autoCloser) {
            Intrinsics.h(delegate, "delegate");
            Intrinsics.h(autoCloser, "autoCloser");
            this.f14839a = delegate;
            this.f14840b = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f14839a.close();
            this.f14840b.g();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i11, CharArrayBuffer charArrayBuffer) {
            this.f14839a.copyStringToBuffer(i11, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.f14839a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i11) {
            return this.f14839a.getBlob(i11);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f14839a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f14839a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f14839a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i11) {
            return this.f14839a.getColumnName(i11);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f14839a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f14839a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i11) {
            return this.f14839a.getDouble(i11);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f14839a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i11) {
            return this.f14839a.getFloat(i11);
        }

        @Override // android.database.Cursor
        public int getInt(int i11) {
            return this.f14839a.getInt(i11);
        }

        @Override // android.database.Cursor
        public long getLong(int i11) {
            return this.f14839a.getLong(i11);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return this.f14839a.getNotificationUri();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f14839a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i11) {
            return this.f14839a.getShort(i11);
        }

        @Override // android.database.Cursor
        public String getString(int i11) {
            return this.f14839a.getString(i11);
        }

        @Override // android.database.Cursor
        public int getType(int i11) {
            return this.f14839a.getType(i11);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f14839a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f14839a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f14839a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f14839a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f14839a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f14839a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i11) {
            return this.f14839a.isNull(i11);
        }

        @Override // android.database.Cursor
        public boolean move(int i11) {
            return this.f14839a.move(i11);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f14839a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f14839a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f14839a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i11) {
            return this.f14839a.moveToPosition(i11);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f14839a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f14839a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f14839a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.f14839a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f14839a.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            this.f14839a.setExtras(bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f14839a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f14839a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f14839a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(a4.e delegate, AutoCloser autoCloser) {
        Intrinsics.h(delegate, "delegate");
        Intrinsics.h(autoCloser, "autoCloser");
        this.f14827a = delegate;
        this.f14828b = autoCloser;
        this.f14829c = new AutoClosingSupportSQLiteDatabase(autoCloser);
        autoCloser.l(getDelegate());
    }

    @Override // a4.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f14829c.close();
    }

    public final AutoCloser d() {
        return this.f14828b;
    }

    @Override // a4.e
    public String getDatabaseName() {
        return this.f14827a.getDatabaseName();
    }

    @Override // androidx.room.d
    public a4.e getDelegate() {
        return this.f14827a;
    }

    @Override // a4.e
    public a4.d getReadableDatabase() {
        this.f14829c.q();
        return this.f14829c;
    }

    @Override // a4.e
    public a4.d getWritableDatabase() {
        this.f14829c.q();
        return this.f14829c;
    }

    @Override // a4.e
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f14827a.setWriteAheadLoggingEnabled(z10);
    }
}
