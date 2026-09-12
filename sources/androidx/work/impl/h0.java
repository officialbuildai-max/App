package androidx.work.impl;

import android.content.Context;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f15768a = new h0();

    private h0() {
    }

    public static final void c(Context context) {
        String str;
        String str2;
        String str3;
        Intrinsics.h(context, "context");
        h0 h0Var = f15768a;
        if (h0Var.b(context).exists()) {
            androidx.work.t e11 = androidx.work.t.e();
            str = i0.f15771a;
            e11.a(str, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry entry : h0Var.d(context).entrySet()) {
                File file = (File) entry.getKey();
                File file2 = (File) entry.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        androidx.work.t e12 = androidx.work.t.e();
                        str3 = i0.f15771a;
                        e12.k(str3, "Over-writing contents of " + file2);
                    }
                    String str4 = file.renameTo(file2) ? "Migrated " + file + "to " + file2 : "Renaming " + file + " to " + file2 + " failed";
                    androidx.work.t e13 = androidx.work.t.e();
                    str2 = i0.f15771a;
                    e13.a(str2, str4);
                }
            }
        }
    }

    public final File a(Context context) {
        Intrinsics.h(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        Intrinsics.g(noBackupFilesDir, "getNoBackupFilesDir(...)");
        return noBackupFilesDir;
    }

    public final File b(Context context) {
        Intrinsics.h(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.g(databasePath, "getDatabasePath(...)");
        return databasePath;
    }

    public final Map d(Context context) {
        String[] strArr;
        Intrinsics.h(context, "context");
        File b11 = b(context);
        File a11 = a(context);
        strArr = i0.f15772b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(strArr.length), 16));
        for (String str : strArr) {
            Pair a12 = TuplesKt.a(new File(b11.getPath() + str), new File(a11.getPath() + str));
            linkedHashMap.put(a12.getFirst(), a12.getSecond());
        }
        return MapsKt.p(linkedHashMap, TuplesKt.a(b11, a11));
    }
}
