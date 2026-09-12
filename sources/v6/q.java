package v6;

import android.database.Cursor;
import androidx.room.g0;
import com.cloud.hisavana.abtestkit.db.ABRoomDatabase_Impl;

/* loaded from: classes3.dex */
public final class q implements m {

    /* renamed from: a, reason: collision with root package name */
    public final ABRoomDatabase_Impl f77190a;

    /* renamed from: b, reason: collision with root package name */
    public final n f77191b;

    /* renamed from: c, reason: collision with root package name */
    public final o f77192c;

    /* renamed from: d, reason: collision with root package name */
    public final p f77193d;

    public q(ABRoomDatabase_Impl aBRoomDatabase_Impl) {
        this.f77190a = aBRoomDatabase_Impl;
        this.f77191b = new n(aBRoomDatabase_Impl);
        this.f77192c = new o(aBRoomDatabase_Impl);
        this.f77193d = new p(aBRoomDatabase_Impl);
    }

    @Override // v6.m
    public final int a() {
        this.f77190a.j();
        a4.h b11 = this.f77193d.b();
        try {
            this.f77190a.k();
            try {
                int F = b11.F();
                this.f77190a.e0();
                return F;
            } finally {
                this.f77190a.t();
            }
        } finally {
            this.f77193d.h(b11);
        }
    }

    @Override // v6.m
    public final long a(r rVar) {
        this.f77190a.j();
        this.f77190a.k();
        try {
            long m11 = this.f77191b.m(rVar);
            this.f77190a.e0();
            return m11;
        } finally {
            this.f77190a.t();
        }
    }

    @Override // v6.m
    public final Cursor a(long j11) {
        g0 h11 = g0.h("SELECT * FROM hisavana_local_ab_room WHERE LOCAL_AB_VERSION_CODE = ?", 1);
        h11.c(1, j11);
        return this.f77190a.V(h11);
    }

    @Override // v6.m
    public final int b(r rVar) {
        this.f77190a.j();
        this.f77190a.k();
        try {
            int k11 = this.f77192c.k(rVar);
            this.f77190a.e0();
            return k11;
        } finally {
            this.f77190a.t();
        }
    }
}
