package com.transsion.ga;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.os.Process;
import android.util.Log;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.taaneh.aethna;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private static volatile i f44260b;

    /* renamed from: a, reason: collision with root package name */
    private final Context f44261a;

    private i(Context context) {
        this.f44261a = context;
    }

    public static i a() {
        return f44260b;
    }

    public static void b(Context context) {
        if (f44260b == null) {
            synchronized (i.class) {
                try {
                    if (f44260b == null) {
                        f44260b = new i(context);
                    }
                } finally {
                }
            }
        }
    }

    public void c(anateh anatehVar) {
        String str;
        long j11;
        int b11 = com.transsion.athena.data.athena.b();
        if (b11 == 0 || anatehVar == null) {
            aethna.a("trackException tid not configure or e is null");
            return;
        }
        String a11 = anatehVar.a();
        if (a11.contains("addJSON") || a11.contains("updateEvents") || a11.contains("cleanupEvents")) {
            return;
        }
        TrackData add = new TrackData().add("count", 1, 1).add("eid", a11).add("pid", Process.myPid(), 2).add("extra", anatehVar.b(), 2);
        Throwable cause = anatehVar.getCause();
        if (cause == null) {
            str = null;
        } else if (cause instanceof SQLiteFullException) {
            str = cause.getClass().getName();
        } else {
            str = cause.getCause() != null ? Log.getStackTraceString(cause.getCause()) : Log.getStackTraceString(cause);
            if (str.length() > 2048) {
                str = str.substring(0, 2048);
            }
        }
        TrackData add2 = add.add("stackTrace", str);
        if (a11.contains("sql")) {
            try {
                j11 = this.f44261a.getFilesDir().getUsableSpace();
            } catch (Exception e11) {
                e11.printStackTrace();
                j11 = 0;
            }
            add2.add("usableSpace", j11);
        }
        AthenaAnalytics.K(b11).g0("ev_athena", add2, b11);
    }
}
