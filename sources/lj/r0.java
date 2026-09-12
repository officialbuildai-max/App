package lj;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.download.DownloadRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class r0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69051a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69052b = new a();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `download_thread_range` (`threadId`,`rangeId`,`resourceId`,`start`,`end`,`progress`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, DownloadRange downloadRange) {
            eVar.c(1, downloadRange.getThreadId());
            eVar.c(2, downloadRange.getRangeId());
            if (downloadRange.getResourceId() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, downloadRange.getResourceId());
            }
            eVar.c(4, downloadRange.getStart());
            eVar.c(5, downloadRange.getEnd());
            eVar.c(6, downloadRange.getProgress());
        }
    }

    public r0(RoomDatabase roomDatabase) {
        this.f69051a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM DOWNLOAD_THREAD_RANGE WHERE resourceId=?");
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
    public static /* synthetic */ List i(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM DOWNLOAD_THREAD_RANGE WHERE resourceId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "threadId");
            int d12 = androidx.room.util.k.d(D0, "rangeId");
            int d13 = androidx.room.util.k.d(D0, "resourceId");
            int d14 = androidx.room.util.k.d(D0, "start");
            int d15 = androidx.room.util.k.d(D0, TtmlNode.END);
            int d16 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                DownloadRange downloadRange = new DownloadRange();
                downloadRange.setThreadId((int) D0.getLong(d11));
                downloadRange.setRangeId((int) D0.getLong(d12));
                downloadRange.setResourceId(D0.isNull(d13) ? null : D0.n0(d13));
                downloadRange.setStart(D0.getLong(d14));
                downloadRange.setEnd(D0.getLong(d15));
                downloadRange.setProgress(D0.getLong(d16));
                arrayList.add(downloadRange);
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit j(DownloadRange downloadRange, z3.b bVar) {
        this.f69052b.d(bVar, downloadRange);
        return Unit.f67184a;
    }

    @Override // lj.n0
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69051a, false, true, new Function1() { // from class: lj.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h11;
                h11 = r0.h(str, (z3.b) obj);
                return h11;
            }
        }, continuation);
    }

    @Override // lj.n0
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69051a, true, false, new Function1() { // from class: lj.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List i11;
                i11 = r0.i(str, (z3.b) obj);
                return i11;
            }
        }, continuation);
    }

    @Override // lj.n0
    public Object d(final DownloadRange downloadRange, Continuation continuation) {
        downloadRange.getClass();
        return androidx.room.util.b.f(this.f69051a, false, true, new Function1() { // from class: lj.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = r0.this.j(downloadRange, (z3.b) obj);
                return j11;
            }
        }, continuation);
    }
}
