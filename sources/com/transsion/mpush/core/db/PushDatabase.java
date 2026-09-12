package com.transsion.mpush.core.db;

import a4.d;
import android.content.Context;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.q;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mn.j;
import y3.c;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/transsion/mpush/core/db/PushDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lmn/a;", "j0", "()Lmn/a;", "Lmn/j;", "k0", "()Lmn/j;", TtmlNode.TAG_P, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "MBPush_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public abstract class PushDatabase extends RoomDatabase {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: q, reason: collision with root package name */
    private static final a f47535q = new a();

    /* renamed from: r, reason: collision with root package name */
    private static volatile PushDatabase f47536r;

    /* loaded from: classes6.dex */
    public static final class a extends c {
        a() {
            super(1, 2);
        }

        @Override // y3.c
        public void a(d database) {
            Intrinsics.h(database, "database");
            if (PushDatabase.INSTANCE.c(database, "msg_standard", "push_time")) {
                return;
            }
            database.E("ALTER TABLE msg_standard ADD COLUMN push_time TEXT");
        }
    }

    /* renamed from: com.transsion.mpush.core.db.PushDatabase$b, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(d dVar, String str, String str2) {
            Cursor i02 = dVar.i0("PRAGMA table_info(" + str + ")");
            try {
                int columnIndex = i02.getColumnIndex("name");
                if (columnIndex == -1) {
                    CloseableKt.a(i02, null);
                    return false;
                }
                while (i02.moveToNext()) {
                    if (Intrinsics.c(str2, i02.getString(columnIndex))) {
                        CloseableKt.a(i02, null);
                        return true;
                    }
                }
                Unit unit = Unit.f67184a;
                CloseableKt.a(i02, null);
                return false;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(i02, th2);
                    throw th3;
                }
            }
        }

        public final PushDatabase b(Context context) {
            Intrinsics.h(context, "context");
            PushDatabase pushDatabase = PushDatabase.f47536r;
            if (pushDatabase == null) {
                synchronized (this) {
                    pushDatabase = PushDatabase.f47536r;
                    if (pushDatabase == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.g(applicationContext, "getApplicationContext(...)");
                        RoomDatabase d11 = q.a(applicationContext, PushDatabase.class, "new_sdk_push_db").b(PushDatabase.f47535q).d();
                        PushDatabase.f47536r = (PushDatabase) d11;
                        pushDatabase = (PushDatabase) d11;
                    }
                }
            }
            return pushDatabase;
        }
    }

    public abstract mn.a j0();

    public abstract j k0();
}
