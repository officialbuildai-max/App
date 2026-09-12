package oj;

import androidx.room.RoomDatabase;
import androidx.room.util.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class h implements oj.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f71152a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f71153b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f71154c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `music_liked` (`subjectId`,`title`,`coverUrl`,`countryName`,`genre`,`releaseDate`,`durationSeconds`,`singerName`,`singerAvatar`,`path`,`timeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, MusicLikedDbBean musicLikedDbBean) {
            if (musicLikedDbBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, musicLikedDbBean.getSubjectId());
            }
            if (musicLikedDbBean.getTitle() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, musicLikedDbBean.getTitle());
            }
            if (musicLikedDbBean.getCoverUrl() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, musicLikedDbBean.getCoverUrl());
            }
            if (musicLikedDbBean.getCountryName() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, musicLikedDbBean.getCountryName());
            }
            if (musicLikedDbBean.getGenre() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, musicLikedDbBean.getGenre());
            }
            if (musicLikedDbBean.getReleaseDate() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, musicLikedDbBean.getReleaseDate());
            }
            eVar.c(7, musicLikedDbBean.getDurationSeconds());
            if (musicLikedDbBean.getSingerName() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, musicLikedDbBean.getSingerName());
            }
            if (musicLikedDbBean.getSingerAvatar() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, musicLikedDbBean.getSingerAvatar());
            }
            if (musicLikedDbBean.getPath() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, musicLikedDbBean.getPath());
            }
            eVar.c(11, musicLikedDbBean.getTimeStamp());
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `music_liked` SET `subjectId` = ?,`title` = ?,`coverUrl` = ?,`countryName` = ?,`genre` = ?,`releaseDate` = ?,`durationSeconds` = ?,`singerName` = ?,`singerAvatar` = ?,`path` = ?,`timeStamp` = ? WHERE `subjectId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, MusicLikedDbBean musicLikedDbBean) {
            if (musicLikedDbBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, musicLikedDbBean.getSubjectId());
            }
            if (musicLikedDbBean.getTitle() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, musicLikedDbBean.getTitle());
            }
            if (musicLikedDbBean.getCoverUrl() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, musicLikedDbBean.getCoverUrl());
            }
            if (musicLikedDbBean.getCountryName() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, musicLikedDbBean.getCountryName());
            }
            if (musicLikedDbBean.getGenre() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, musicLikedDbBean.getGenre());
            }
            if (musicLikedDbBean.getReleaseDate() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, musicLikedDbBean.getReleaseDate());
            }
            eVar.c(7, musicLikedDbBean.getDurationSeconds());
            if (musicLikedDbBean.getSingerName() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, musicLikedDbBean.getSingerName());
            }
            if (musicLikedDbBean.getSingerAvatar() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, musicLikedDbBean.getSingerAvatar());
            }
            if (musicLikedDbBean.getPath() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, musicLikedDbBean.getPath());
            }
            eVar.c(11, musicLikedDbBean.getTimeStamp());
            if (musicLikedDbBean.getSubjectId() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, musicLikedDbBean.getSubjectId());
            }
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.f71152a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit n(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM music_liked WHERE subjectId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
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
    public static /* synthetic */ List o(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM music_liked ORDER BY timeStamp DESC");
        try {
            int d11 = k.d(D0, "subjectId");
            int d12 = k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d13 = k.d(D0, "coverUrl");
            int d14 = k.d(D0, "countryName");
            int d15 = k.d(D0, "genre");
            int d16 = k.d(D0, "releaseDate");
            int d17 = k.d(D0, "durationSeconds");
            int d18 = k.d(D0, "singerName");
            int d19 = k.d(D0, "singerAvatar");
            int d20 = k.d(D0, "path");
            int d21 = k.d(D0, "timeStamp");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                arrayList.add(new MusicLikedDbBean(D0.isNull(d11) ? null : D0.n0(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15), D0.isNull(d16) ? null : D0.n0(d16), (int) D0.getLong(d17), D0.isNull(d18) ? null : D0.n0(d18), D0.isNull(d19) ? null : D0.n0(d19), D0.isNull(d20) ? null : D0.n0(d20), D0.getLong(d21)));
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer p(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT COUNT(*) FROM music_liked");
        try {
            Integer num = null;
            if (D0.A0() && !D0.isNull(0)) {
                num = Integer.valueOf((int) D0.getLong(0));
            }
            return num;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MusicLikedDbBean q(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM music_liked WHERE subjectId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "subjectId");
            int d12 = k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d13 = k.d(D0, "coverUrl");
            int d14 = k.d(D0, "countryName");
            int d15 = k.d(D0, "genre");
            int d16 = k.d(D0, "releaseDate");
            int d17 = k.d(D0, "durationSeconds");
            int d18 = k.d(D0, "singerName");
            int d19 = k.d(D0, "singerAvatar");
            int d20 = k.d(D0, "path");
            int d21 = k.d(D0, "timeStamp");
            MusicLikedDbBean musicLikedDbBean = null;
            if (D0.A0()) {
                musicLikedDbBean = new MusicLikedDbBean(D0.isNull(d11) ? null : D0.n0(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), D0.isNull(d15) ? null : D0.n0(d15), D0.isNull(d16) ? null : D0.n0(d16), (int) D0.getLong(d17), D0.isNull(d18) ? null : D0.n0(d18), D0.isNull(d19) ? null : D0.n0(d19), D0.isNull(d20) ? null : D0.n0(d20), D0.getLong(d21));
            }
            D0.close();
            return musicLikedDbBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(MusicLikedDbBean musicLikedDbBean, z3.b bVar) {
        this.f71153b.d(bVar, musicLikedDbBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(List list, z3.b bVar) {
        this.f71153b.c(bVar, list);
        return Unit.f67184a;
    }

    @Override // oj.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f71152a, true, false, new Function1() { // from class: oj.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Integer p11;
                p11 = h.p((z3.b) obj);
                return p11;
            }
        }, continuation);
    }

    @Override // oj.a
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.f71152a, false, true, new Function1() { // from class: oj.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = h.this.s(list, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // oj.a
    public Object c(Continuation continuation) {
        return androidx.room.util.b.f(this.f71152a, true, false, new Function1() { // from class: oj.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List o11;
                o11 = h.o((z3.b) obj);
                return o11;
            }
        }, continuation);
    }

    @Override // oj.a
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f71152a, false, true, new Function1() { // from class: oj.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n11;
                n11 = h.n(str, (z3.b) obj);
                return n11;
            }
        }, continuation);
    }

    @Override // oj.a
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f71152a, true, false, new Function1() { // from class: oj.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MusicLikedDbBean q11;
                q11 = h.q(str, (z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // oj.a
    public Object f(final MusicLikedDbBean musicLikedDbBean, Continuation continuation) {
        musicLikedDbBean.getClass();
        return androidx.room.util.b.f(this.f71152a, false, true, new Function1() { // from class: oj.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r11;
                r11 = h.this.r(musicLikedDbBean, (z3.b) obj);
                return r11;
            }
        }, continuation);
    }
}
