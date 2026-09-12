package com.transsion.baselib.db.video;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class q implements ShortTVPlayDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43259a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43260b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f43261c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f43262d = new c();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `short_tv_play` (`subjectId`,`id`,`ep`,`se`,`totalEp`,`progress`,`title`,`description`,`coverUrl`,`thumbnail`,`videoId`,`videoUrl`,`timeStamp`,`subtitleSelectId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTVPlayBean.getSubjectId());
            }
            if (shortTVPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, shortTVPlayBean.getId());
            }
            eVar.c(3, shortTVPlayBean.getEp());
            eVar.c(4, shortTVPlayBean.getSe());
            eVar.c(5, shortTVPlayBean.getTotalEp());
            eVar.c(6, shortTVPlayBean.getProgress());
            if (shortTVPlayBean.getTitle() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, shortTVPlayBean.getTitle());
            }
            if (shortTVPlayBean.getDescription() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, shortTVPlayBean.getDescription());
            }
            if (shortTVPlayBean.getCoverUrl() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, shortTVPlayBean.getCoverUrl());
            }
            if (shortTVPlayBean.getThumbnail() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, shortTVPlayBean.getThumbnail());
            }
            if (shortTVPlayBean.getVideoId() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, shortTVPlayBean.getVideoId());
            }
            if (shortTVPlayBean.getVideoUrl() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, shortTVPlayBean.getVideoUrl());
            }
            eVar.c(13, shortTVPlayBean.getTimeStamp());
            if (shortTVPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, shortTVPlayBean.getSubtitleSelectId());
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `short_tv_play` WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTVPlayBean.getSubjectId());
            }
        }
    }

    /* loaded from: classes5.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `short_tv_play` SET `subjectId` = ?,`id` = ?,`ep` = ?,`se` = ?,`totalEp` = ?,`progress` = ?,`title` = ?,`description` = ?,`coverUrl` = ?,`thumbnail` = ?,`videoId` = ?,`videoUrl` = ?,`timeStamp` = ?,`subtitleSelectId` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, ShortTVPlayBean shortTVPlayBean) {
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, shortTVPlayBean.getSubjectId());
            }
            if (shortTVPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, shortTVPlayBean.getId());
            }
            eVar.c(3, shortTVPlayBean.getEp());
            eVar.c(4, shortTVPlayBean.getSe());
            eVar.c(5, shortTVPlayBean.getTotalEp());
            eVar.c(6, shortTVPlayBean.getProgress());
            if (shortTVPlayBean.getTitle() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, shortTVPlayBean.getTitle());
            }
            if (shortTVPlayBean.getDescription() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, shortTVPlayBean.getDescription());
            }
            if (shortTVPlayBean.getCoverUrl() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, shortTVPlayBean.getCoverUrl());
            }
            if (shortTVPlayBean.getThumbnail() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, shortTVPlayBean.getThumbnail());
            }
            if (shortTVPlayBean.getVideoId() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, shortTVPlayBean.getVideoId());
            }
            if (shortTVPlayBean.getVideoUrl() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, shortTVPlayBean.getVideoUrl());
            }
            eVar.c(13, shortTVPlayBean.getTimeStamp());
            if (shortTVPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, shortTVPlayBean.getSubtitleSelectId());
            }
            if (shortTVPlayBean.getSubjectId() == null) {
                eVar.g(15);
            } else {
                eVar.j(15, shortTVPlayBean.getSubjectId());
            }
        }
    }

    public q(RoomDatabase roomDatabase) {
        this.f43259a = roomDatabase;
    }

    public static List r() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(ShortTVPlayBean shortTVPlayBean, z3.b bVar) {
        this.f43261c.c(bVar, shortTVPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit t(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM SHORT_TV_PLAY");
        try {
            D0.A0();
            return Unit.f67184a;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ShortTVPlayBean u(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM SHORT_TV_PLAY WHERE subjectId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, "totalEp");
            int d16 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d17 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d18 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d19 = androidx.room.util.k.d(D0, "coverUrl");
            int d20 = androidx.room.util.k.d(D0, "thumbnail");
            int d21 = androidx.room.util.k.d(D0, "videoId");
            int d22 = androidx.room.util.k.d(D0, "videoUrl");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            ShortTVPlayBean shortTVPlayBean = null;
            if (D0.A0()) {
                shortTVPlayBean = new ShortTVPlayBean(D0.isNull(d11) ? null : D0.n0(d11), D0.isNull(d12) ? null : D0.n0(d12), (int) D0.getLong(d13), (int) D0.getLong(d14), (int) D0.getLong(d15), D0.getLong(d16), D0.isNull(d17) ? null : D0.n0(d17), D0.isNull(d18) ? null : D0.n0(d18), D0.isNull(d19) ? null : D0.n0(d19), D0.isNull(d20) ? null : D0.n0(d20), D0.isNull(d21) ? null : D0.n0(d21), D0.isNull(d22) ? null : D0.n0(d22), D0.getLong(d23), D0.isNull(d24) ? null : D0.n0(d24));
            }
            D0.close();
            return shortTVPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List v(int i11, int i12, z3.b bVar) {
        int i13;
        ArrayList arrayList;
        String n02;
        z3.e D0 = bVar.D0("SELECT * FROM SHORT_TV_PLAY WHERE coverUrl IS NOT NULL AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM SHORT_TV_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, "totalEp");
            int d16 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d17 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d18 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d19 = androidx.room.util.k.d(D0, "coverUrl");
            int d20 = androidx.room.util.k.d(D0, "thumbnail");
            int d21 = androidx.room.util.k.d(D0, "videoId");
            int d22 = androidx.room.util.k.d(D0, "videoUrl");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            ArrayList arrayList2 = new ArrayList();
            while (D0.A0()) {
                String n03 = D0.isNull(d11) ? null : D0.n0(d11);
                if (D0.isNull(d12)) {
                    i13 = d24;
                    arrayList = arrayList2;
                    n02 = null;
                } else {
                    i13 = d24;
                    arrayList = arrayList2;
                    n02 = D0.n0(d12);
                }
                int i14 = (int) D0.getLong(d13);
                int i15 = d12;
                int i16 = d13;
                int i17 = (int) D0.getLong(d14);
                int i18 = d14;
                int i19 = i13;
                int i20 = d11;
                ShortTVPlayBean shortTVPlayBean = new ShortTVPlayBean(n03, n02, i14, i17, (int) D0.getLong(d15), D0.getLong(d16), D0.isNull(d17) ? null : D0.n0(d17), D0.isNull(d18) ? null : D0.n0(d18), D0.isNull(d19) ? null : D0.n0(d19), D0.isNull(d20) ? null : D0.n0(d20), D0.isNull(d21) ? null : D0.n0(d21), D0.isNull(d22) ? null : D0.n0(d22), D0.getLong(d23), D0.isNull(i19) ? null : D0.n0(i19));
                ArrayList arrayList3 = arrayList;
                arrayList3.add(shortTVPlayBean);
                d11 = i20;
                d24 = i19;
                d13 = i16;
                d14 = i18;
                arrayList2 = arrayList3;
                d12 = i15;
            }
            return arrayList2;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit w(ShortTVPlayBean shortTVPlayBean, z3.b bVar) {
        this.f43260b.d(bVar, shortTVPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit x(long j11, int i11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE SHORT_TV_PLAY SET progress = ?, ep = ? WHERE subjectId = ?");
        try {
            D0.c(1, j11);
            D0.c(2, i11);
            if (str == null) {
                D0.g(3);
            } else {
                D0.j(3, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y(ShortTVPlayBean shortTVPlayBean, z3.b bVar) {
        this.f43262d.c(bVar, shortTVPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit z(String str, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE SHORT_TV_PLAY SET subtitleSelectId = ? WHERE subjectId = ? ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f43259a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t11;
                t11 = q.t((z3.b) obj);
                return t11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f43259a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z10;
                z10 = q.z(str2, str, (z3.b) obj);
                return z10;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object d(final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43259a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List v11;
                v11 = q.v(i12, i11, (z3.b) obj);
                return v11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43259a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ShortTVPlayBean u11;
                u11 = q.u(str, (z3.b) obj);
                return u11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object f(final ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        shortTVPlayBean.getClass();
        return androidx.room.util.b.f(this.f43259a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w11;
                w11 = q.this.w(shortTVPlayBean, (z3.b) obj);
                return w11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object g(ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        return ShortTVPlayDao.DefaultImpls.a(this, shortTVPlayBean, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object h(final String str, final int i11, final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f43259a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x10;
                x10 = q.x(j11, i11, str, (z3.b) obj);
                return x10;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object i(final ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        shortTVPlayBean.getClass();
        return androidx.room.util.b.f(this.f43259a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = q.this.y(shortTVPlayBean, (z3.b) obj);
                return y10;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.ShortTVPlayDao
    public Object j(final ShortTVPlayBean shortTVPlayBean, Continuation continuation) {
        shortTVPlayBean.getClass();
        return androidx.room.util.b.f(this.f43259a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = q.this.s(shortTVPlayBean, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }
}
