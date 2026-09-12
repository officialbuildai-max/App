package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class d implements IShortTvFavoriteStateDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43185a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43186b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f43187c = new b();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `ShortTvFavoriteState` (`subjectId`,`favoriteNum`,`hasFavorite`,`favoriteTime`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTvFavoriteState shortTvFavoriteState) {
            if (shortTvFavoriteState.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTvFavoriteState.getSubjectId());
            }
            if (shortTvFavoriteState.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, shortTvFavoriteState.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteState.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteState.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, shortTvFavoriteState.getFavoriteTime());
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `ShortTvFavoriteState` SET `subjectId` = ?,`favoriteNum` = ?,`hasFavorite` = ?,`favoriteTime` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTvFavoriteState shortTvFavoriteState) {
            if (shortTvFavoriteState.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTvFavoriteState.getSubjectId());
            }
            if (shortTvFavoriteState.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, shortTvFavoriteState.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteState.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteState.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, shortTvFavoriteState.getFavoriteTime());
            }
            if (shortTvFavoriteState.getSubjectId() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, shortTvFavoriteState.getSubjectId());
            }
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f43185a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(ShortTvFavoriteState shortTvFavoriteState, z3.b bVar) {
        this.f43186b.d(bVar, shortTvFavoriteState);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ShortTvFavoriteState j(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM ShortTvFavoriteState WHERE subjectId=?");
        boolean z10 = true;
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "favoriteNum");
            int d13 = androidx.room.util.k.d(D0, "hasFavorite");
            int d14 = androidx.room.util.k.d(D0, "favoriteTime");
            ShortTvFavoriteState shortTvFavoriteState = null;
            String n02 = null;
            if (D0.A0()) {
                ShortTvFavoriteState shortTvFavoriteState2 = new ShortTvFavoriteState();
                shortTvFavoriteState2.setSubjectId(D0.isNull(d11) ? null : D0.n0(d11));
                shortTvFavoriteState2.setFavoriteNum(D0.isNull(d12) ? null : D0.n0(d12));
                if (((int) D0.getLong(d13)) == 0) {
                    z10 = false;
                }
                shortTvFavoriteState2.setHasFavorite(z10);
                if (!D0.isNull(d14)) {
                    n02 = D0.n0(d14);
                }
                shortTvFavoriteState2.setFavoriteTime(n02);
                shortTvFavoriteState = shortTvFavoriteState2;
            }
            D0.close();
            return shortTvFavoriteState;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(ShortTvFavoriteState shortTvFavoriteState, z3.b bVar) {
        this.f43187c.c(bVar, shortTvFavoriteState);
        return Unit.f67184a;
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43185a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ShortTvFavoriteState j11;
                j11 = d.j(str, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object b(final ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        shortTvFavoriteState.getClass();
        return androidx.room.util.b.f(this.f43185a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = d.this.k(shortTvFavoriteState, (z3.b) obj);
                return k11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object c(final ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        shortTvFavoriteState.getClass();
        return androidx.room.util.b.f(this.f43185a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i11;
                i11 = d.this.i(shortTvFavoriteState, (z3.b) obj);
                return i11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.IShortTvFavoriteStateDao
    public Object d(ShortTvFavoriteState shortTvFavoriteState, Continuation continuation) {
        return IShortTvFavoriteStateDao.DefaultImpls.a(this, shortTvFavoriteState, continuation);
    }
}
