package c4;

import android.database.sqlite.SQLiteDatabase;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import z3.e;

/* loaded from: classes2.dex */
public final class a implements z3.b {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f17069a;

    public a(SQLiteDatabase db2) {
        Intrinsics.h(db2, "db");
        this.f17069a = db2;
    }

    @Override // z3.b
    public e D0(String sql) {
        Intrinsics.h(sql, "sql");
        if (this.f17069a.isOpen()) {
            return c.f17070d.a(this.f17069a, sql);
        }
        z3.a.b(21, "connection is closed");
        throw new KotlinNothingValueException();
    }

    @Override // z3.b, java.lang.AutoCloseable
    public void close() {
        this.f17069a.close();
    }

    public final SQLiteDatabase d() {
        return this.f17069a;
    }
}
