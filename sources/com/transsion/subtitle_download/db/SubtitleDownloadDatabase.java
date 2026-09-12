package com.transsion.subtitle_download.db;

import a4.d;
import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.q;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/transsion/subtitle_download/db/SubtitleDownloadDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lmu/a;", "l0", "()Lmu/a;", TtmlNode.TAG_P, "d", "SubtitleDownload_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public abstract class SubtitleDownloadDatabase extends RoomDatabase {

    /* renamed from: q, reason: collision with root package name */
    private static volatile SubtitleDownloadDatabase f55127q;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r, reason: collision with root package name */
    private static final a f55128r = new a();

    /* renamed from: s, reason: collision with root package name */
    private static final b f55129s = new b();

    /* renamed from: t, reason: collision with root package name */
    private static final c f55130t = new c();

    /* loaded from: classes6.dex */
    public static final class a extends y3.c {
        a() {
            super(1, 2);
        }

        @Override // y3.c
        public void a(d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN failCount INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends y3.c {
        b() {
            super(2, 3);
        }

        @Override // y3.c
        public void a(d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN ugcVideoId TEXT");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN ugcVideoCollectionId TEXT");
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends y3.c {
        c() {
            super(3, 4);
        }

        @Override // y3.c
        public void a(d database) {
            Intrinsics.h(database, "database");
            database.E("ALTER TABLE ST_DOWNLOAD_TABLE ADD COLUMN ops TEXT");
        }
    }

    /* renamed from: com.transsion.subtitle_download.db.SubtitleDownloadDatabase$d, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* renamed from: com.transsion.subtitle_download.db.SubtitleDownloadDatabase$d$a */
        /* loaded from: classes6.dex */
        public static final class a extends RoomDatabase.b {
            a() {
            }

            @Override // androidx.room.RoomDatabase.b
            public void a(d db2) {
                Intrinsics.h(db2, "db");
                super.a(db2);
                com.transsion.subtitle_download.utils.b.f55167a.b("SubtitleDownloadDataBase --> getInstance() --> buildDatabase() --> onCreate() --> db_name is = " + db2.getPath());
            }

            @Override // androidx.room.RoomDatabase.b
            public void e(d db2) {
                Intrinsics.h(db2, "db");
                super.e(db2);
                com.transsion.subtitle_download.utils.b.f55167a.b("SubtitleDownloadDataBase --> getInstance() --> buildDatabase() --> onOpen()");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SubtitleDownloadDatabase a(Context context) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            return (SubtitleDownloadDatabase) q.a(applicationContext, SubtitleDownloadDatabase.class, "oneroom-subtitle-db").c().b(SubtitleDownloadDatabase.f55128r, SubtitleDownloadDatabase.f55129s, SubtitleDownloadDatabase.f55130t).a(new a()).d();
        }

        public final SubtitleDownloadDatabase b(Context context) {
            Intrinsics.h(context, "context");
            SubtitleDownloadDatabase subtitleDownloadDatabase = SubtitleDownloadDatabase.f55127q;
            if (subtitleDownloadDatabase == null) {
                synchronized (this) {
                    subtitleDownloadDatabase = SubtitleDownloadDatabase.f55127q;
                    if (subtitleDownloadDatabase == null) {
                        SubtitleDownloadDatabase a11 = SubtitleDownloadDatabase.INSTANCE.a(context);
                        SubtitleDownloadDatabase.f55127q = a11;
                        subtitleDownloadDatabase = a11;
                    }
                }
            }
            return subtitleDownloadDatabase;
        }
    }

    public abstract mu.a l0();
}
