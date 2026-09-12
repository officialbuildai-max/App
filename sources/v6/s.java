package v6;

import android.database.Cursor;
import android.util.Log;
import androidx.room.g0;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.hisavana.common.tracking.TrackingKey;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public interface s {

    /* loaded from: classes3.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static void a(y yVar, z entity) {
            Intrinsics.h(entity, "entity");
            long layerId = entity.getLayerId();
            g0 h11 = g0.h("SELECT * FROM hisavana_ab_room WHERE layer_id = ?", 1);
            h11.c(1, layerId);
            yVar.f77196a.j();
            Cursor g11 = androidx.room.util.b.g(yVar.f77196a, h11, false, null);
            try {
                int e11 = androidx.room.util.a.e(g11, ClientABTestDTOKt.LAYER_ID);
                int e12 = androidx.room.util.a.e(g11, TrackingKey.REQUEST_TIME);
                int e13 = androidx.room.util.a.e(g11, "ab_info");
                if (g11.moveToFirst()) {
                    r4 = new z(g11.getLong(e11), g11.getLong(e12), g11.isNull(e13) ? null : g11.getString(e13));
                }
                g11.close();
                h11.release();
                if (Log.isLoggable("ADSDK", 3)) {
                    com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "OnlineABDao Query whether the " + entity.getLayerId() + " exists in the database = " + r4);
                }
                if (r4 == null) {
                    yVar.a(entity);
                    return;
                }
                long layerId2 = entity.getLayerId();
                long requestTime = entity.getRequestTime();
                yVar.f77196a.j();
                a4.h b11 = yVar.f77200e.b();
                b11.c(1, requestTime);
                b11.c(2, layerId2);
                try {
                    yVar.f77196a.k();
                    try {
                        b11.F();
                        yVar.f77196a.e0();
                    } finally {
                        yVar.f77196a.t();
                    }
                } finally {
                    yVar.f77200e.h(b11);
                }
            } catch (Throwable th2) {
                g11.close();
                h11.release();
                throw th2;
            }
        }

        public static long b(y yVar, z entity) {
            Intrinsics.h(entity, "entity");
            yVar.f77196a.j();
            yVar.f77196a.k();
            try {
                long m11 = yVar.f77197b.m(entity);
                yVar.f77196a.e0();
                yVar.f77196a.t();
                int i11 = 0;
                g0 h11 = g0.h("SELECT COUNT(*) FROM hisavana_ab_room", 0);
                yVar.f77196a.j();
                Cursor g11 = androidx.room.util.b.g(yVar.f77196a, h11, false, null);
                try {
                    int i12 = g11.moveToFirst() ? g11.getInt(0) : 0;
                    g11.close();
                    h11.release();
                    if (i12 >= 20) {
                        yVar.f77196a.j();
                        a4.h b11 = yVar.f77198c.b();
                        b11.c(1, i12 - 10);
                        try {
                            yVar.f77196a.k();
                            try {
                                i11 = b11.F();
                                yVar.f77196a.e0();
                            } finally {
                            }
                        } finally {
                            yVar.f77198c.h(b11);
                        }
                    }
                    if (Log.isLoggable("ADSDK", 3)) {
                        com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "OnlineABDao delCount = " + i11 + " and upsertId = " + m11);
                    }
                    return m11;
                } catch (Throwable th2) {
                    g11.close();
                    h11.release();
                    throw th2;
                }
            } finally {
            }
        }
    }

    int a();

    long a(z zVar);

    Cursor b();

    void b(z zVar);
}
