package com.transsion.shorttv.db;

import androidx.room.RoomDatabase;
import androidx.room.util.k;
import com.transsion.shorttv.db.ShortTvAdUnlockDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class d implements ShortTvAdUnlockDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f53072a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f53073b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f53074c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `short_tv_ad_unlock_state` (`subjectId`,`unlockedEps`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, e eVar2) {
            if (eVar2.a() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, eVar2.a());
            }
            if (eVar2.b() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, eVar2.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `short_tv_ad_unlock_state` SET `subjectId` = ?,`unlockedEps` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, e eVar2) {
            if (eVar2.a() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, eVar2.a());
            }
            if (eVar2.b() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, eVar2.b());
            }
            if (eVar2.a() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, eVar2.a());
            }
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f53072a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(e eVar, z3.b bVar) {
        this.f53073b.d(bVar, eVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e j(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM short_tv_ad_unlock_state WHERE subjectId=?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "subjectId");
            int d12 = k.d(D0, "unlockedEps");
            e eVar = null;
            String n02 = null;
            if (D0.A0()) {
                String n03 = D0.isNull(d11) ? null : D0.n0(d11);
                if (!D0.isNull(d12)) {
                    n02 = D0.n0(d12);
                }
                eVar = new e(n03, n02);
            }
            D0.close();
            return eVar;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(e eVar, z3.b bVar) {
        this.f53074c.c(bVar, eVar);
        return Unit.f67184a;
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f53072a, true, false, new Function1() { // from class: com.transsion.shorttv.db.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                e j11;
                j11 = d.j(str, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object b(e eVar, Continuation continuation) {
        return ShortTvAdUnlockDao.DefaultImpls.a(this, eVar, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object c(final e eVar, Continuation continuation) {
        eVar.getClass();
        return androidx.room.util.b.f(this.f53072a, false, true, new Function1() { // from class: com.transsion.shorttv.db.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = d.this.k(eVar, (z3.b) obj);
                return k11;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvAdUnlockDao
    public Object d(final e eVar, Continuation continuation) {
        eVar.getClass();
        return androidx.room.util.b.f(this.f53072a, false, true, new Function1() { // from class: com.transsion.shorttv.db.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i11;
                i11 = d.this.i(eVar, (z3.b) obj);
                return i11;
            }
        }, continuation);
    }
}
