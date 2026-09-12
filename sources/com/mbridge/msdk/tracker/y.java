package com.mbridge.msdk.tracker;

import android.database.Cursor;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.List;

/* loaded from: classes5.dex */
class y {
    public static long a(int i11, long j11, long j12) {
        if (i11 <= 0 || j11 == 0 || i11 <= 10) {
            return j12;
        }
        if (i11 <= 20) {
            return 60000L;
        }
        if (i11 <= 30) {
            return TmcConstants.DEBUG_REQUEST_TIME_INTERVAL;
        }
        if (i11 <= 40) {
            return 180000L;
        }
        return i11 <= 50 ? 240000L : 300000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Cursor cursor) {
        try {
            if (!a((Object) cursor) || cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(e eVar) {
        return a((Object) eVar) && eVar.c() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj) {
        return obj != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<i> list) {
        if (b((List<?>) list)) {
            return false;
        }
        for (i iVar : list) {
            if (!b(iVar)) {
                e a11 = iVar.a();
                if (!b(a11) && a11.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.mbridge.msdk.tracker.i> b(android.database.Cursor r19) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.y.b(android.database.Cursor):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Object obj) {
        return obj == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(List<?> list) {
        return list == null || list.isEmpty();
    }
}
