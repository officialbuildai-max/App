package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.video.PlaybackRecordDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class h implements PlaybackRecordDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43216a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43217b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f43218c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f43219d = new c();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `playback_record_table` (`subjectId`,`se`,`ep`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`rewardUnlock`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PlaybackRecordTable playbackRecordTable) {
            if (playbackRecordTable.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, playbackRecordTable.getSubjectId());
            }
            eVar.c(2, playbackRecordTable.getSe());
            eVar.c(3, playbackRecordTable.getEp());
            eVar.c(4, playbackRecordTable.getLastAdStartTimeStamp());
            eVar.c(5, playbackRecordTable.getLastAdEndTimeStamp());
            eVar.c(6, playbackRecordTable.getRewardUnlock() ? 1L : 0L);
        }
    }

    /* loaded from: classes5.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `playback_record_table` WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PlaybackRecordTable playbackRecordTable) {
            if (playbackRecordTable.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, playbackRecordTable.getSubjectId());
            }
            eVar.c(2, playbackRecordTable.getEp());
            eVar.c(3, playbackRecordTable.getSe());
        }
    }

    /* loaded from: classes5.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `playback_record_table` SET `subjectId` = ?,`se` = ?,`ep` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`rewardUnlock` = ? WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PlaybackRecordTable playbackRecordTable) {
            if (playbackRecordTable.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, playbackRecordTable.getSubjectId());
            }
            eVar.c(2, playbackRecordTable.getSe());
            eVar.c(3, playbackRecordTable.getEp());
            eVar.c(4, playbackRecordTable.getLastAdStartTimeStamp());
            eVar.c(5, playbackRecordTable.getLastAdEndTimeStamp());
            eVar.c(6, playbackRecordTable.getRewardUnlock() ? 1L : 0L);
            if (playbackRecordTable.getSubjectId() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, playbackRecordTable.getSubjectId());
            }
            eVar.c(8, playbackRecordTable.getEp());
            eVar.c(9, playbackRecordTable.getSe());
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.f43216a = roomDatabase;
    }

    public static List h() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PlaybackRecordTable i(String str, int i11, int i12, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM playback_record_table WHERE subjectId = ? AND se = ? AND ep = ? LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            D0.c(3, i12);
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "se");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d15 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d16 = androidx.room.util.k.d(D0, "rewardUnlock");
            PlaybackRecordTable playbackRecordTable = null;
            if (D0.A0()) {
                playbackRecordTable = new PlaybackRecordTable(D0.isNull(d11) ? null : D0.n0(d11), (int) D0.getLong(d12), (int) D0.getLong(d13), D0.getLong(d14), D0.getLong(d15), ((int) D0.getLong(d16)) != 0);
            }
            D0.close();
            return playbackRecordTable;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit j(PlaybackRecordTable playbackRecordTable, z3.b bVar) {
        this.f43217b.d(bVar, playbackRecordTable);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(PlaybackRecordTable playbackRecordTable, z3.b bVar) {
        this.f43219d.c(bVar, playbackRecordTable);
        return Unit.f67184a;
    }

    @Override // com.transsion.baselib.db.video.PlaybackRecordDao
    public Object a(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43216a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PlaybackRecordTable i13;
                i13 = h.i(str, i11, i12, (z3.b) obj);
                return i13;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.PlaybackRecordDao
    public Object b(PlaybackRecordTable playbackRecordTable, Continuation continuation) {
        return PlaybackRecordDao.DefaultImpls.a(this, playbackRecordTable, continuation);
    }

    @Override // com.transsion.baselib.db.video.PlaybackRecordDao
    public Object c(final PlaybackRecordTable playbackRecordTable, Continuation continuation) {
        playbackRecordTable.getClass();
        return androidx.room.util.b.f(this.f43216a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = h.this.j(playbackRecordTable, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.PlaybackRecordDao
    public Object d(final PlaybackRecordTable playbackRecordTable, Continuation continuation) {
        playbackRecordTable.getClass();
        return androidx.room.util.b.f(this.f43216a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = h.this.k(playbackRecordTable, (z3.b) obj);
                return k11;
            }
        }, continuation);
    }
}
