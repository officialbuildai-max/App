package com.transsion.ad.db.scene;

import androidx.room.RoomDatabase;
import androidx.room.util.k;
import com.transsion.ad.db.scene.AdSceneLimitDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class g implements AdSceneLimitDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f42166a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f42167b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f42168c = new b();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `ad_scene_limit_table` (`sceneId`,`lastDisplayAdDate`,`lastDisplayAdTimestamp`,`displayTimes`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AdSceneLimit adSceneLimit) {
            if (adSceneLimit.getSceneId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, adSceneLimit.getSceneId());
            }
            if (adSceneLimit.getLastDisplayAdDate() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, adSceneLimit.getLastDisplayAdDate());
            }
            eVar.c(3, adSceneLimit.getLastDisplayAdTimestamp());
            eVar.c(4, adSceneLimit.getDisplayTimes());
        }
    }

    /* loaded from: classes5.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `ad_scene_limit_table` SET `sceneId` = ?,`lastDisplayAdDate` = ?,`lastDisplayAdTimestamp` = ?,`displayTimes` = ? WHERE `sceneId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AdSceneLimit adSceneLimit) {
            if (adSceneLimit.getSceneId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, adSceneLimit.getSceneId());
            }
            if (adSceneLimit.getLastDisplayAdDate() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, adSceneLimit.getLastDisplayAdDate());
            }
            eVar.c(3, adSceneLimit.getLastDisplayAdTimestamp());
            eVar.c(4, adSceneLimit.getDisplayTimes());
            if (adSceneLimit.getSceneId() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, adSceneLimit.getSceneId());
            }
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.f42166a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(String str, String str2, long j11, long j12, int i11, Continuation continuation) {
        return AdSceneLimitDao.DefaultImpls.a(this, str, str2, j11, j12, i11, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(String str, String str2, Continuation continuation) {
        return AdSceneLimitDao.DefaultImpls.b(this, str, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AdSceneLimit p(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM ad_scene_limit_table WHERE sceneId = ? LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "sceneId");
            int d12 = k.d(D0, "lastDisplayAdDate");
            int d13 = k.d(D0, "lastDisplayAdTimestamp");
            int d14 = k.d(D0, "displayTimes");
            AdSceneLimit adSceneLimit = null;
            if (D0.A0()) {
                adSceneLimit = new AdSceneLimit(D0.isNull(d11) ? null : D0.n0(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.getLong(d13), (int) D0.getLong(d14));
            }
            D0.close();
            return adSceneLimit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit q(AdSceneLimit adSceneLimit, z3.b bVar) {
        this.f42167b.d(bVar, adSceneLimit);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(String str, String str2, long j11, Continuation continuation) {
        return AdSceneLimitDao.DefaultImpls.c(this, str, str2, j11, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(AdSceneLimit adSceneLimit, z3.b bVar) {
        this.f42168c.c(bVar, adSceneLimit);
        return Unit.f67184a;
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f42166a, true, false, new Function1() { // from class: com.transsion.ad.db.scene.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AdSceneLimit p11;
                p11 = g.p(str, (z3.b) obj);
                return p11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object b(final String str, final String str2, final long j11, final long j12, final int i11, Continuation continuation) {
        return androidx.room.util.b.e(this.f42166a, new Function1() { // from class: com.transsion.ad.db.scene.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object n11;
                n11 = g.this.n(str, str2, j11, j12, i11, (Continuation) obj);
                return n11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object c(final String str, final String str2, final long j11, Continuation continuation) {
        return androidx.room.util.b.e(this.f42166a, new Function1() { // from class: com.transsion.ad.db.scene.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object r11;
                r11 = g.this.r(str, str2, j11, (Continuation) obj);
                return r11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object d(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.e(this.f42166a, new Function1() { // from class: com.transsion.ad.db.scene.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object o11;
                o11 = g.this.o(str, str2, (Continuation) obj);
                return o11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object e(final AdSceneLimit adSceneLimit, Continuation continuation) {
        adSceneLimit.getClass();
        return androidx.room.util.b.f(this.f42166a, false, true, new Function1() { // from class: com.transsion.ad.db.scene.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = g.this.q(adSceneLimit, (z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.scene.AdSceneLimitDao
    public Object f(final AdSceneLimit adSceneLimit, Continuation continuation) {
        adSceneLimit.getClass();
        return androidx.room.util.b.f(this.f42166a, false, true, new Function1() { // from class: com.transsion.ad.db.scene.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = g.this.s(adSceneLimit, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }
}
