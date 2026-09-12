package b4;

import android.database.sqlite.SQLiteStatement;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class j extends i implements a4.h {

    /* renamed from: b, reason: collision with root package name */
    private final SQLiteStatement f16305b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SQLiteStatement delegate) {
        super(delegate);
        Intrinsics.h(delegate, "delegate");
        this.f16305b = delegate;
    }

    @Override // a4.h
    public int F() {
        return this.f16305b.executeUpdateDelete();
    }

    @Override // a4.h
    public long R() {
        return this.f16305b.executeInsert();
    }

    @Override // a4.h
    public void execute() {
        this.f16305b.execute();
    }
}
