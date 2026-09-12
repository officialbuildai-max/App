package com.transsion.shorttv.db;

import androidx.room.RoomDatabase;
import androidx.room.util.k;
import com.transsion.shorttv.db.ShortTvFavoriteDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class i implements ShortTvFavoriteDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f53084a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f53085b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f53086c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `short_tv_favorite_state` (`subjectId`,`favoriteNum`,`hasFavorite`,`favoriteTime`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTvFavoriteStateBean shortTvFavoriteStateBean) {
            if (shortTvFavoriteStateBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTvFavoriteStateBean.getSubjectId());
            }
            if (shortTvFavoriteStateBean.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, shortTvFavoriteStateBean.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteStateBean.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteStateBean.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, shortTvFavoriteStateBean.getFavoriteTime());
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `short_tv_favorite_state` SET `subjectId` = ?,`favoriteNum` = ?,`hasFavorite` = ?,`favoriteTime` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTvFavoriteStateBean shortTvFavoriteStateBean) {
            if (shortTvFavoriteStateBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTvFavoriteStateBean.getSubjectId());
            }
            if (shortTvFavoriteStateBean.getFavoriteNum() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, shortTvFavoriteStateBean.getFavoriteNum());
            }
            eVar.c(3, shortTvFavoriteStateBean.getHasFavorite() ? 1L : 0L);
            if (shortTvFavoriteStateBean.getFavoriteTime() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, shortTvFavoriteStateBean.getFavoriteTime());
            }
            if (shortTvFavoriteStateBean.getSubjectId() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, shortTvFavoriteStateBean.getSubjectId());
            }
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.f53084a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(ShortTvFavoriteStateBean shortTvFavoriteStateBean, z3.b bVar) {
        this.f53085b.d(bVar, shortTvFavoriteStateBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ShortTvFavoriteStateBean j(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM short_tv_favorite_state WHERE subjectId=?");
        boolean z10 = true;
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "subjectId");
            int d12 = k.d(D0, "favoriteNum");
            int d13 = k.d(D0, "hasFavorite");
            int d14 = k.d(D0, "favoriteTime");
            ShortTvFavoriteStateBean shortTvFavoriteStateBean = null;
            String n02 = null;
            if (D0.A0()) {
                String n03 = D0.isNull(d11) ? null : D0.n0(d11);
                String n04 = D0.isNull(d12) ? null : D0.n0(d12);
                if (((int) D0.getLong(d13)) == 0) {
                    z10 = false;
                }
                if (!D0.isNull(d14)) {
                    n02 = D0.n0(d14);
                }
                shortTvFavoriteStateBean = new ShortTvFavoriteStateBean(n03, n04, z10, n02);
            }
            D0.close();
            return shortTvFavoriteStateBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(ShortTvFavoriteStateBean shortTvFavoriteStateBean, z3.b bVar) {
        this.f53086c.c(bVar, shortTvFavoriteStateBean);
        return Unit.f67184a;
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f53084a, true, false, new Function1() { // from class: com.transsion.shorttv.db.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ShortTvFavoriteStateBean j11;
                j11 = i.j(str, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object b(final ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
        shortTvFavoriteStateBean.getClass();
        return androidx.room.util.b.f(this.f53084a, false, true, new Function1() { // from class: com.transsion.shorttv.db.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = i.this.k(shortTvFavoriteStateBean, (z3.b) obj);
                return k11;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object c(final ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
        shortTvFavoriteStateBean.getClass();
        return androidx.room.util.b.f(this.f53084a, false, true, new Function1() { // from class: com.transsion.shorttv.db.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i11;
                i11 = i.this.i(shortTvFavoriteStateBean, (z3.b) obj);
                return i11;
            }
        }, continuation);
    }

    @Override // com.transsion.shorttv.db.ShortTvFavoriteDao
    public Object d(ShortTvFavoriteStateBean shortTvFavoriteStateBean, Continuation continuation) {
        return ShortTvFavoriteDao.DefaultImpls.a(this, shortTvFavoriteStateBean, continuation);
    }
}
