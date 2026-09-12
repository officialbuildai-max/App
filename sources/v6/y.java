package v6;

import android.database.Cursor;
import androidx.room.g0;
import com.cloud.hisavana.abtestkit.db.ABRoomDatabase_Impl;
import v6.s;

/* loaded from: classes3.dex */
public final class y implements s {

    /* renamed from: a, reason: collision with root package name */
    public final ABRoomDatabase_Impl f77196a;

    /* renamed from: b, reason: collision with root package name */
    public final t f77197b;

    /* renamed from: c, reason: collision with root package name */
    public final v f77198c;

    /* renamed from: d, reason: collision with root package name */
    public final w f77199d;

    /* renamed from: e, reason: collision with root package name */
    public final x f77200e;

    public y(ABRoomDatabase_Impl aBRoomDatabase_Impl) {
        this.f77196a = aBRoomDatabase_Impl;
        this.f77197b = new t(aBRoomDatabase_Impl);
        new u(aBRoomDatabase_Impl);
        this.f77198c = new v(aBRoomDatabase_Impl);
        this.f77199d = new w(aBRoomDatabase_Impl);
        this.f77200e = new x(aBRoomDatabase_Impl);
    }

    @Override // v6.s
    public final int a() {
        this.f77196a.j();
        a4.h b11 = this.f77199d.b();
        try {
            this.f77196a.k();
            try {
                int F = b11.F();
                this.f77196a.e0();
                return F;
            } finally {
                this.f77196a.t();
            }
        } finally {
            this.f77199d.h(b11);
        }
    }

    @Override // v6.s
    public final long a(z zVar) {
        this.f77196a.k();
        try {
            long b11 = s.a.b(this, zVar);
            this.f77196a.e0();
            return b11;
        } finally {
            this.f77196a.t();
        }
    }

    @Override // v6.s
    public final Cursor b() {
        return this.f77196a.V(g0.h("SELECT * FROM hisavana_ab_room", 0));
    }

    @Override // v6.s
    public final void b(z zVar) {
        this.f77196a.k();
        try {
            s.a.a(this, zVar);
            this.f77196a.e0();
        } finally {
            this.f77196a.t();
        }
    }
}
