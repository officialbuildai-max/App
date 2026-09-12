package com.transsion.baselib.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import com.cloud.config.utils.CommonUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.member.MemberResolutionDao;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import com.transsion.baselib.db.video.PlaybackRecordDao;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 72\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H&¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H&¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H&¢\u0006\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/transsion/baselib/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Ljj/a;", "o1", "()Ljj/a;", "Llj/c;", "p1", "()Llj/c;", "Lrj/a;", "w1", "()Lrj/a;", "Llj/v0;", "z1", "()Llj/v0;", "Llj/n0;", "q1", "()Llj/n0;", "Lcom/transsion/baselib/db/video/e1;", "E1", "()Lcom/transsion/baselib/db/video/e1;", "Lcom/transsion/baselib/db/video/ShortTVPlayDao;", "x1", "()Lcom/transsion/baselib/db/video/ShortTVPlayDao;", "Llj/d1;", "A1", "()Llj/d1;", "Lcom/transsion/baselib/db/video/IShortTvFavoriteStateDao;", "y1", "()Lcom/transsion/baselib/db/video/IShortTvFavoriteStateDao;", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "D1", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "Lcom/transsion/baselib/db/video/PlaybackRecordDao;", "v1", "()Lcom/transsion/baselib/db/video/PlaybackRecordDao;", "Loj/a;", "t1", "()Loj/a;", "Lcom/transsion/baselib/db/place/PlaceDao;", "u1", "()Lcom/transsion/baselib/db/place/PlaceDao;", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayDao;", "C1", "()Lcom/transsion/baselib/db/video/UGCVideoDetailPlayDao;", "Lcom/transsion/baselib/db/video/UGCCollectionVideoGroupDao;", "B1", "()Lcom/transsion/baselib/db/video/UGCCollectionVideoGroupDao;", "Lcom/transsion/baselib/db/member/MemberResolutionDao;", "s1", "()Lcom/transsion/baselib/db/member/MemberResolutionDao;", "Lmj/a;", "r1", "()Lmj/a;", TtmlNode.TAG_P, "g1", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public abstract class AppDatabase extends RoomDatabase {

    /* renamed from: q, reason: collision with root package name */
    private static volatile AppDatabase f43094q;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r, reason: collision with root package name */
    private static final k f43096r = new k();

    /* renamed from: s, reason: collision with root package name */
    private static final v f43098s = new v();

    /* renamed from: t, reason: collision with root package name */
    private static final g0 f43100t = new g0();

    /* renamed from: u, reason: collision with root package name */
    private static final r0 f43102u = new r0();

    /* renamed from: v, reason: collision with root package name */
    private static final b1 f43104v = new b1();

    /* renamed from: w, reason: collision with root package name */
    private static final c1 f43106w = new c1();

    /* renamed from: x, reason: collision with root package name */
    private static final d1 f43108x = new d1();

    /* renamed from: y, reason: collision with root package name */
    private static final e1 f43109y = new e1();

    /* renamed from: z, reason: collision with root package name */
    private static final f1 f43110z = new f1();
    private static final a A = new a();
    private static final b B = new b();
    private static final c C = new c();
    private static final d D = new d();
    private static final e E = new e();
    private static final f F = new f();
    private static final g G = new g();
    private static final h H = new h();
    private static final i I = new i();
    private static final j J = new j();
    private static final l K = new l();
    private static final m L = new m();
    private static final n M = new n();
    private static final o N = new o();
    private static final p O = new p();
    private static final q P = new q();
    private static final r Q = new r();
    private static final s R = new s();
    private static final t S = new t();
    private static final u T = new u();
    private static final w U = new w();
    private static final x V = new x();
    private static final y W = new y();
    private static final z X = new z();
    private static final a0 Y = new a0();
    private static final b0 Z = new b0();

    /* renamed from: a0, reason: collision with root package name */
    private static final c0 f43077a0 = new c0();

    /* renamed from: b0, reason: collision with root package name */
    private static final d0 f43078b0 = new d0();

    /* renamed from: c0, reason: collision with root package name */
    private static final e0 f43079c0 = new e0();

    /* renamed from: d0, reason: collision with root package name */
    private static final f0 f43080d0 = new f0();

    /* renamed from: e0, reason: collision with root package name */
    private static final h0 f43081e0 = new h0();

    /* renamed from: f0, reason: collision with root package name */
    private static final i0 f43082f0 = new i0();

    /* renamed from: g0, reason: collision with root package name */
    private static final j0 f43083g0 = new j0();

    /* renamed from: h0, reason: collision with root package name */
    private static final k0 f43084h0 = new k0();

    /* renamed from: i0, reason: collision with root package name */
    private static final l0 f43085i0 = new l0();

    /* renamed from: j0, reason: collision with root package name */
    private static final m0 f43086j0 = new m0();

    /* renamed from: k0, reason: collision with root package name */
    private static final n0 f43087k0 = new n0();

    /* renamed from: l0, reason: collision with root package name */
    private static final o0 f43088l0 = new o0();

    /* renamed from: m0, reason: collision with root package name */
    private static final p0 f43089m0 = new p0();

    /* renamed from: n0, reason: collision with root package name */
    private static final q0 f43090n0 = new q0();

    /* renamed from: o0, reason: collision with root package name */
    private static final s0 f43091o0 = new s0();

    /* renamed from: p0, reason: collision with root package name */
    private static final t0 f43093p0 = new t0();

    /* renamed from: q0, reason: collision with root package name */
    private static final u0 f43095q0 = new u0();

    /* renamed from: r0, reason: collision with root package name */
    private static final v0 f43097r0 = new v0();

    /* renamed from: s0, reason: collision with root package name */
    private static final w0 f43099s0 = new w0();

    /* renamed from: t0, reason: collision with root package name */
    private static final x0 f43101t0 = new x0();

    /* renamed from: u0, reason: collision with root package name */
    private static final y0 f43103u0 = new y0();

    /* renamed from: v0, reason: collision with root package name */
    private static final z0 f43105v0 = new z0();

    /* renamed from: w0, reason: collision with root package name */
    private static final a1 f43107w0 = new a1();

    /* loaded from: classes5.dex */
    public static final class a extends y3.c {
        a() {
            super(10, 11);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS DOWNLOAD_THREAD_RANGE (`threadId` INTEGER NOT NULL, `rangeId` INTEGER NOT NULL, `resourceId` TEXT, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`threadId`, `rangeId`))");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectName TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD lastPlayTimeStamp INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD fileType INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* loaded from: classes5.dex */
    public static final class a0 extends y3.c {
        a0() {
            super(34, 35);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS VIDEO_DETAIL_PLAY (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class a1 extends y3.c {
        a1() {
            super(58, 59);
        }

        @Override // y3.c
        public void a(a4.d db2) {
            Intrinsics.h(db2, "db");
            db2.E("CREATE TABLE IF NOT EXISTS playback_record_table (\n    subjectId TEXT NOT NULL,\n    ep INTEGER NOT NULL,\n    se INTEGER NOT NULL,\n    lastAdStartTimeStamp INTEGER NOT NULL DEFAULT 0,\n    lastAdEndTimeStamp INTEGER NOT NULL DEFAULT 0,\n    rewardUnlock INTEGER NOT NULL DEFAULT 0,\n    PRIMARY KEY(subjectId, ep, se)\n)");
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends y3.c {
        b() {
            super(11, 12);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE AUDIO ADD subjectTitle TEXT");
            database.E("ALTER TABLE AUDIO ADD se INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE AUDIO ADD ep INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class b0 extends y3.c {
        b0() {
            super(35, 36);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD subtitleSelectId TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class b1 extends y3.c {
        b1() {
            super(5, 6);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS `DOWNLOAD_SUBTITLE_TABLE` (`resourceId` TEXT NOT NULL, `postId` TEXT, `url` TEXT, `path` TEXT, `lan` TEXT, `lanName` TEXT NOT NULL, `size` INTEGER,`delayDuration` INTEGER, `status` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD episode INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends y3.c {
        c() {
            super(12, 13);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD ep INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD se INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD videoWidth INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD videoHeight INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class c0 extends y3.c {
        c0() {
            super(36, 37);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE NON_AD_PLANS ADD adShowLevel TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD filterClientVersion TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD adPlanCreateTime TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD appStarDesc TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD appSizeDesc TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class c1 extends y3.c {
        c1() {
            super(6, 7);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD pageFrom TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD lastPageFrom TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectId TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends y3.c {
        d() {
            super(13, 14);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD totalEpisode INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d0 extends y3.c {
        d0() {
            super(37, 38);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD averageHueLight TEXT");
            database.E("CREATE TABLE IF NOT EXISTS VIDEO_DETAIL_PLAY_NEW (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER DEFAULT 0, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL DEFAULT 0, `playMode` TEXT NOT NULL DEFAULT `2`, `downloadUrl` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`subjectId`, `ep`, `se`))");
            database.E("INSERT OR IGNORE INTO `VIDEO_DETAIL_PLAY_NEW` (subjectId, id, ep, se, progress, title, coverUrl, thumbnail, videoUrl, timeStamp, subtitleSelectId) SELECT subjectId, id, ep, se, progress, title, coverUrl, thumbnail, videoUrl, timeStamp, subtitleSelectId FROM `VIDEO_DETAIL_PLAY`");
            database.E("INSERT OR IGNORE INTO `VIDEO_DETAIL_PLAY_NEW` (subjectId, id, ep, se, progress, title, coverUrl, thumbnail, videoUrl, timeStamp, subtitleSelectId, totalDuration, averageHueLight, subjectType, hasDelete, playMode, downloadUrl, downloadFilePath, downloadSize) SELECT subjectId, resourceId, ep, se, progress, subjectName, cover, thumbnail, url, lastPlayTimeStamp, subtitleSelectId, duration, averageHueLight, subjectType, 0, 1, url, path, size FROM `download_table` WHERE (type in (2,3,5)) AND fileType = 1 AND lastPlayTimeStamp > 0 ORDER BY updateTimeStamp DESC");
            database.E("DROP TABLE VIDEO_DETAIL_PLAY");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY_NEW RENAME TO VIDEO_DETAIL_PLAY");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d1 extends y3.c {
        d1() {
            super(7, 8);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS PERMANENT_MSG (`id` INTEGER NOT NULL, `deep_link_list` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `style` TEXT, `title` TEXT, PRIMARY KEY(`id`))");
            database.E("CREATE TABLE IF NOT EXISTS MSG (`id` INTEGER NOT NULL, `deep_link` TEXT, `desc` TEXT, `image_list` TEXT, `message_id` TEXT, `style` TEXT, `title` TEXT, `source` TEXT, `type` TEXT, `receive_time` INTEGER, `msg_status` INTEGER NOT NULL, `show_time` INTEGER, `force_show` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends y3.c {
        e() {
            super(14, 15);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD downloadErrorCount INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subtitleStarted INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class e0 extends y3.c {
        e0() {
            super(38, 39);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD genre TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class e1 extends y3.c {
        e1() {
            super(8, 9);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE MSG ADD `has_screen_on` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends y3.c {
        f() {
            super(15, 16);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD resolution INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class f0 extends y3.c {
        f0() {
            super(39, 40);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN dubs TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class f1 extends y3.c {
        f1() {
            super(9, 10);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS CONSUME_BEAN (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updateTimeStamp` INTEGER NOT NULL,`dataType` INTEGER NOT NULL,`appVersion` INTEGER NOT NULL, `consumeJson` TEXT)");
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends y3.c {
        g() {
            super(16, 17);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD multiresolution INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class g0 extends y3.c {
        g0() {
            super(3, 4);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD resourceId TEXT");
        }
    }

    /* renamed from: com.transsion.baselib.db.AppDatabase$g1, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: com.transsion.baselib.db.AppDatabase$g1$a */
        /* loaded from: classes5.dex */
        public static final class a extends RoomDatabase.b {
            a() {
            }

            @Override // androidx.room.RoomDatabase.b
            public void a(a4.d db2) {
                Intrinsics.h(db2, "db");
                super.a(db2);
                a.C0856a.f(lg.a.f68962a, "database", "onCreate db_name is=" + db2.getPath(), false, 4, null);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AppDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            return (AppDatabase) androidx.room.q.a(applicationContext, AppDatabase.class, "oneroom-db").c().b(AppDatabase.f43096r, AppDatabase.f43098s, AppDatabase.f43100t, AppDatabase.f43102u, AppDatabase.f43104v, AppDatabase.f43106w, AppDatabase.f43108x, AppDatabase.f43109y, AppDatabase.f43110z, AppDatabase.A, AppDatabase.B, AppDatabase.C, AppDatabase.D, AppDatabase.E, AppDatabase.F, AppDatabase.G, AppDatabase.H, AppDatabase.I, AppDatabase.J, AppDatabase.K, AppDatabase.L, AppDatabase.M, AppDatabase.N, AppDatabase.O, AppDatabase.P, AppDatabase.Q, AppDatabase.R, AppDatabase.S, AppDatabase.T, AppDatabase.U, AppDatabase.V, AppDatabase.W, AppDatabase.X, AppDatabase.Y, AppDatabase.Z, AppDatabase.f43077a0, AppDatabase.f43078b0, AppDatabase.f43079c0, AppDatabase.f43080d0, AppDatabase.f43081e0, AppDatabase.f43082f0, AppDatabase.f43083g0, AppDatabase.f43084h0, AppDatabase.f43085i0, AppDatabase.f43086j0, AppDatabase.f43087k0, AppDatabase.f43088l0, AppDatabase.f43089m0, AppDatabase.f43090n0, AppDatabase.f43091o0, AppDatabase.f43093p0, AppDatabase.f43095q0, AppDatabase.f43097r0, AppDatabase.f43099s0, AppDatabase.f43101t0, AppDatabase.f43103u0, AppDatabase.f43105v0, AppDatabase.f43107w0).a(new a()).d();
        }

        public final AppDatabase b(Context context) {
            Intrinsics.h(context, "context");
            AppDatabase appDatabase = AppDatabase.f43094q;
            if (appDatabase == null) {
                synchronized (this) {
                    appDatabase = AppDatabase.f43094q;
                    if (appDatabase == null) {
                        AppDatabase a11 = AppDatabase.INSTANCE.a(context);
                        AppDatabase.f43094q = a11;
                        appDatabase = a11;
                    }
                }
            }
            return appDatabase;
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends y3.c {
        h() {
            super(17, 18);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD resourcePosition INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class h0 extends y3.c {
        h0() {
            super(40, 41);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD subjectDurationSeconds INTEGER DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectDurationSeconds INTEGER DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends y3.c {
        i() {
            super(18, 19);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD uploadBy TEXT ");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD sourceUrl TEXT ");
        }
    }

    /* loaded from: classes5.dex */
    public static final class i0 extends y3.c {
        i0() {
            super(41, 42);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD lastAdStartTimeStamp INTEGER");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD lastAdEndTimeStamp INTEGER");
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends y3.c {
        j() {
            super(19, 20);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE MSG ADD built_in INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class j0 extends y3.c {
        j0() {
            super(42, 43);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN currentDubLanCode TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN currentDubLanName TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class k extends y3.c {
        k() {
            super(1, 2);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN postId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN ops TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class k0 extends y3.c {
        k0() {
            super(43, 44);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS MUSIC_LIKED (`subjectId` TEXT NOT NULL, `title` TEXT, `coverUrl` TEXT, `countryName` TEXT, `genre` TEXT, `releaseDate` TEXT, `durationSeconds` INTEGER NOT NULL DEFAULT 0, `singerName` TEXT, `singerAvatar` TEXT, `path` TEXT, `timeStamp` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`subjectId`))");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD ops TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class l extends y3.c {
        l() {
            super(20, 21);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS VIDEO_LAND_AD (`resourceId` TEXT NOT NULL, `startAdDayKey` INTEGER NOT NULL, `endAdDayKey` INTEGER NOT NULL, PRIMARY KEY(`resourceId`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class l0 extends y3.c {
        l0() {
            super(44, 45);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN restrictLevel TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN releaseDate TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN countryName TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN subtitles TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN imdbRate TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN seNum INTEGER");
        }
    }

    /* loaded from: classes5.dex */
    public static final class m extends y3.c {
        m() {
            super(21, 22);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD urlCreateAt INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subtitleSelectId TEXT");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD subtitleName TEXT");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD type INTEGER NOT NULL DEFAULT 1");
            database.E("CREATE TABLE IF NOT EXISTS SUBTITLE_LANGUAGE_MAP_TABLE (`lan` TEXT NOT NULL, `lanName` TEXT NOT NULL, `inSearch` INTEGER NOT NULL, PRIMARY KEY(`lan`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class m0 extends y3.c {
        m0() {
            super(45, 46);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS `place_list` (`latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `name` TEXT, `address` TEXT, `distance` TEXT, PRIMARY KEY(`latitude`, `longitude`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class n extends y3.c {
        n() {
            super(22, 23);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE MSG ADD permanent_msg_status INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class n0 extends y3.c {
        n0() {
            super(46, 47);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN lastAdStartTimeStamp INTEGER");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN lastAdEndTimeStamp INTEGER");
        }
    }

    /* loaded from: classes5.dex */
    public static final class o extends y3.c {
        o() {
            super(23, 24);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD taskId TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD sessionTime INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class o0 extends y3.c {
        o0() {
            super(47, 48);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardPlayed INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardUnlock INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD COLUMN rewardFree INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class p extends y3.c {
        p() {
            super(24, 25);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD reportStatus INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD downloadHeaderSize INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class p0 extends y3.c {
        p0() {
            super(48, 49);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE SHORT_TV_PLAY ADD subtitleSelectId TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class q extends y3.c {
        q() {
            super(25, 26);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD fileCharsetName TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class q0 extends y3.c {
        q0() {
            super(49, 50);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE VIDEO_DETAIL_PLAY ADD ops TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class r extends y3.c {
        r() {
            super(26, 27);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD rootPath TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD rootPathType INTEGER NOT NULL DEFAULT 1");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD thumbnail TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD isTransferFailed INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD isClosedTransferFailed INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class r0 extends y3.c {
        r0() {
            super(4, 5);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE AUDIO ADD COLUMN resourceId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN postId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN subjectId TEXT");
            database.E("ALTER TABLE AUDIO ADD COLUMN groupId TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class s extends y3.c {
        s() {
            super(27, 28);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD subjectId TEXT");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD ep INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD se INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE DOWNLOAD_SUBTITLE_TABLE ADD resolution INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes5.dex */
    public static final class s0 extends y3.c {
        s0() {
            super(50, 51);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoCollectionId TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoId TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoPosition INTEGER");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoType TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoName TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoCollectionName TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN subtitleIdType TEXT");
            database.E("CREATE TABLE IF NOT EXISTS `ugc_collection_video_group` (`collectionId` TEXT NOT NULL, `ugcVideoIds` TEXT NOT NULL, PRIMARY KEY(`collectionId`))");
            database.E("CREATE TABLE IF NOT EXISTS `ugc_video_detail_play` (`collectionId` TEXT NOT NULL, `ugcVideoId` TEXT NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `position` INTEGER NOT NULL, `type` TEXT, `timeStamp` INTEGER NOT NULL, `subtitleSelectId` TEXT, `totalDuration` INTEGER, `subjectDurationSeconds` INTEGER, `averageHueLight` TEXT, `subjectType` INTEGER, `hasDelete` INTEGER NOT NULL, `playMode` TEXT NOT NULL, `downloadUrl` TEXT, `downloadResid` TEXT, `downloadFilePath` TEXT, `downloadSize` INTEGER NOT NULL, `lastAdStartTimeStamp` INTEGER, `lastAdEndTimeStamp` INTEGER, `rewardPlayed` INTEGER NOT NULL, `rewardUnlock` INTEGER NOT NULL, `rewardFree` INTEGER NOT NULL,`ops` TEXT,  PRIMARY KEY(`collectionId`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class t extends y3.c {
        t() {
            super(28, 29);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE SUBTITLE_LANGUAGE_MAP_TABLE ADD lanIOS3 TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class t0 extends y3.c {
        t0() {
            super(51, 52);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoTrackId TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoParentVideoId TEXT");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoParentTrackId TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class u extends y3.c {
        u() {
            super(29, 30);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS SHORT_TV_PLAY (`subjectId` TEXT NOT NULL, `id` TEXT NOT NULL, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `totalEp` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `title` TEXT, `description` TEXT, `coverUrl` TEXT, `thumbnail` TEXT, `videoId` TEXT, `videoUrl` TEXT, `timeStamp` INTEGER NOT NULL, PRIMARY KEY(`subjectId`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class u0 extends y3.c {
        u0() {
            super(52, 53);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoEpTitle TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class v extends y3.c {
        v() {
            super(2, 3);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD isRead INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* loaded from: classes5.dex */
    public static final class v0 extends y3.c {
        v0() {
            super(53, 54);
        }

        @Override // y3.c
        public void a(a4.d db2) {
            Intrinsics.h(db2, "db");
            db2.E("CREATE TABLE IF NOT EXISTS member_resolution (\n    subjectId TEXT NOT NULL,\n    ep INTEGER NOT NULL,\n    se INTEGER NOT NULL,\n    vipResolutionTip INTEGER DEFAULT 0,\n    isUnlock INTEGER DEFAULT 0,\n    PRIMARY KEY(subjectId, ep, se)\n)");
        }
    }

    /* loaded from: classes5.dex */
    public static final class w extends y3.c {
        w() {
            super(30, 31);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS NON_AD_PLANS (`id` TEXT NOT NULL, `version` TEXT, `name` TEXT, `startTime` TEXT, `endTime` TEXT, `extraConfig` TEXT, `displayTimes` INTEGER, `showedTimes` INTEGER, `showDate` TEXT, `advertiserName` TEXT, `advertiserAvatar` TEXT, `advertiserAvatarPath` TEXT, `brand` TEXT, `denyBrand` TEXT, `model` TEXT, `denyModel` TEXT, `country` TEXT, `scenes` TEXT, `adMaterialList` TEXT, PRIMARY KEY(`id`))");
            database.E("CREATE TABLE IF NOT EXISTS LOCAL_MCC (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Country` TEXT NOT NULL, `Mcc` TEXT NOT NULL, `Iso` TEXT NOT NULL, `CountryCode` TEXT NOT NULL)");
        }
    }

    /* loaded from: classes5.dex */
    public static final class w0 extends y3.c {
        w0() {
            super(54, 55);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD ugcVideoIsVertical INTEGER NOT NULL DEFAULT 0");
            database.E("ALTER TABLE ugc_video_detail_play ADD COLUMN uid TEXT");
            database.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userName TEXT");
            database.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userAvatar TEXT");
            database.E("ALTER TABLE ugc_video_detail_play ADD COLUMN description TEXT");
            database.E("ALTER TABLE ugc_video_detail_play ADD COLUMN videoStyle TEXT");
        }
    }

    /* loaded from: classes5.dex */
    public static final class x extends y3.c {
        x() {
            super(31, 32);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE NON_AD_PLANS ADD adPlanUpdateTime TEXT");
            database.E("ALTER TABLE NON_AD_PLANS ADD sort INTEGER");
        }
    }

    /* loaded from: classes5.dex */
    public static final class x0 extends y3.c {
        x0() {
            super(55, 56);
        }

        @Override // y3.c
        public void a(a4.d db2) {
            boolean b11;
            boolean b12;
            boolean b13;
            boolean b14;
            boolean b15;
            boolean b16;
            boolean b17;
            Intrinsics.h(db2, "db");
            b11 = ij.a.b(db2, "DOWNLOAD_TABLE", "ugcVideoIsVertical");
            if (!b11) {
                db2.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoIsVertical INTEGER NOT NULL DEFAULT 0");
            }
            b12 = ij.a.b(db2, "DOWNLOAD_TABLE", "originData");
            if (!b12) {
                db2.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN originData TEXT");
            }
            b13 = ij.a.b(db2, "ugc_video_detail_play", CommonUtils.PARAM_UID);
            if (!b13) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN uid TEXT");
            }
            b14 = ij.a.b(db2, "ugc_video_detail_play", "userName");
            if (!b14) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userName TEXT");
            }
            b15 = ij.a.b(db2, "ugc_video_detail_play", "userAvatar");
            if (!b15) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userAvatar TEXT");
            }
            b16 = ij.a.b(db2, "ugc_video_detail_play", TrackingKey.DESCRIPTION);
            if (!b16) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN description TEXT");
            }
            b17 = ij.a.b(db2, "ugc_video_detail_play", "videoStyle");
            if (!b17) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN videoStyle TEXT");
            }
            db2.E("CREATE TABLE IF NOT EXISTS home_preferences_interval_time (\n    id TEXT NOT NULL,\n    showTime INTEGER NOT NULL,\n    closeTime INTEGER NOT NULL,\n    chooseTime INTEGER NOT NULL,\n    showIntervalSeconds INTEGER NOT NULL,\n    closeIntervalSeconds INTEGER NOT NULL,\n    chooseIntervalSeconds INTEGER NOT NULL,\n    PRIMARY KEY(id)\n)");
        }
    }

    /* loaded from: classes5.dex */
    public static final class y extends y3.c {
        y() {
            super(32, 33);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE DOWNLOAD_TABLE ADD subjectType INTEGER NOT NULL DEFAULT 1");
        }
    }

    /* loaded from: classes5.dex */
    public static final class y0 extends y3.c {
        y0() {
            super(56, 57);
        }

        @Override // y3.c
        public void a(a4.d db2) {
            boolean b11;
            boolean b12;
            boolean b13;
            boolean b14;
            boolean b15;
            boolean b16;
            Intrinsics.h(db2, "db");
            b11 = ij.a.b(db2, "DOWNLOAD_TABLE", "ugcVideoIsVertical");
            if (!b11) {
                db2.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN ugcVideoIsVertical INTEGER NOT NULL DEFAULT 0");
            }
            b12 = ij.a.b(db2, "ugc_video_detail_play", CommonUtils.PARAM_UID);
            if (!b12) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN uid TEXT");
            }
            b13 = ij.a.b(db2, "ugc_video_detail_play", "userName");
            if (!b13) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userName TEXT");
            }
            b14 = ij.a.b(db2, "ugc_video_detail_play", "userAvatar");
            if (!b14) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN userAvatar TEXT");
            }
            b15 = ij.a.b(db2, "ugc_video_detail_play", TrackingKey.DESCRIPTION);
            if (!b15) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN description TEXT");
            }
            b16 = ij.a.b(db2, "ugc_video_detail_play", "videoStyle");
            if (!b16) {
                db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN videoStyle TEXT");
            }
            db2.E("ALTER TABLE download_table ADD COLUMN ugcCateLev1Id INTEGER");
            db2.E("ALTER TABLE download_table ADD COLUMN ugcCateLev2Id INTEGER");
            db2.E("ALTER TABLE download_table ADD COLUMN ugcCateLev3Id INTEGER");
            db2.E("ALTER TABLE download_table ADD COLUMN ugcCateLev4Id INTEGER");
            db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev1Id INTEGER");
            db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev2Id INTEGER");
            db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev3Id INTEGER");
            db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN cateLev4Id INTEGER");
        }
    }

    /* loaded from: classes5.dex */
    public static final class z extends y3.c {
        z() {
            super(33, 34);
        }

        @Override // y3.c
        public void a(a4.d database) {
            Intrinsics.h(database, "database");
            database.E("CREATE TABLE IF NOT EXISTS ShortTvFavoriteState (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER not null default 0,`favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
        }
    }

    /* loaded from: classes5.dex */
    public static final class z0 extends y3.c {
        z0() {
            super(57, 58);
        }

        @Override // y3.c
        public void a(a4.d db2) {
            Intrinsics.h(db2, "db");
            db2.E("ALTER TABLE download_table ADD COLUMN kidId TEXT");
            db2.E("ALTER TABLE ugc_video_detail_play ADD COLUMN kidId TEXT");
        }
    }

    public abstract lj.d1 A1();

    public abstract UGCCollectionVideoGroupDao B1();

    public abstract UGCVideoDetailPlayDao C1();

    public abstract VideoDetailPlayDao D1();

    public abstract com.transsion.baselib.db.video.e1 E1();

    public abstract jj.a o1();

    public abstract lj.c p1();

    public abstract lj.n0 q1();

    public abstract mj.a r1();

    public abstract MemberResolutionDao s1();

    public abstract oj.a t1();

    public abstract PlaceDao u1();

    public abstract PlaybackRecordDao v1();

    public abstract rj.a w1();

    public abstract ShortTVPlayDao x1();

    public abstract IShortTvFavoriteStateDao y1();

    public abstract lj.v0 z1();
}
