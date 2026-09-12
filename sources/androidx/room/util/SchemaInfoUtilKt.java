package androidx.room.util;

import androidx.room.util.o;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class SchemaInfoUtilKt {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f14872a = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    public static final int a(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        if (StringsKt.c0(upperCase, "INT", false, 2, null)) {
            return 3;
        }
        if (StringsKt.c0(upperCase, "CHAR", false, 2, null) || StringsKt.c0(upperCase, "CLOB", false, 2, null) || StringsKt.c0(upperCase, "TEXT", false, 2, null)) {
            return 2;
        }
        if (StringsKt.c0(upperCase, "BLOB", false, 2, null)) {
            return 5;
        }
        return (StringsKt.c0(upperCase, "REAL", false, 2, null) || StringsKt.c0(upperCase, "FLOA", false, 2, null) || StringsKt.c0(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
    }

    private static final Map b(z3.b bVar, String str) {
        z3.e D0 = bVar.D0("PRAGMA table_info(`" + str + "`)");
        try {
            String str2 = null;
            if (!D0.A0()) {
                Map h11 = MapsKt.h();
                AutoCloseableKt.a(D0, null);
                return h11;
            }
            int a11 = k.a(D0, "name");
            int a12 = k.a(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int a13 = k.a(D0, "notnull");
            int a14 = k.a(D0, "pk");
            int a15 = k.a(D0, "dflt_value");
            Map c11 = MapsKt.c();
            while (true) {
                String n02 = D0.n0(a11);
                c11.put(n02, new o.a(n02, D0.n0(a12), D0.getLong(a13) != 0, (int) D0.getLong(a14), D0.isNull(a15) ? str2 : D0.n0(a15), 2));
                if (!D0.A0()) {
                    Map b11 = MapsKt.b(c11);
                    AutoCloseableKt.a(D0, null);
                    return b11;
                }
                str2 = null;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.a(D0, th2);
                throw th3;
            }
        }
    }

    private static final List c(z3.e eVar) {
        int a11 = k.a(eVar, "id");
        int a12 = k.a(eVar, "seq");
        int a13 = k.a(eVar, "from");
        int a14 = k.a(eVar, "to");
        List c11 = CollectionsKt.c();
        while (eVar.A0()) {
            c11.add(new e((int) eVar.getLong(a11), (int) eVar.getLong(a12), eVar.n0(a13), eVar.n0(a14)));
        }
        return CollectionsKt.H0(CollectionsKt.a(c11));
    }

    private static final Set d(z3.b bVar, String str) {
        z3.e D0 = bVar.D0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int a11 = k.a(D0, "id");
            int a12 = k.a(D0, "seq");
            int a13 = k.a(D0, "table");
            int a14 = k.a(D0, "on_delete");
            int a15 = k.a(D0, "on_update");
            List c11 = c(D0);
            D0.reset();
            Set b11 = SetsKt.b();
            while (D0.A0()) {
                if (D0.getLong(a12) == 0) {
                    int i11 = (int) D0.getLong(a11);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<e> arrayList3 = new ArrayList();
                    for (Object obj : c11) {
                        if (((e) obj).d() == i11) {
                            arrayList3.add(obj);
                        }
                    }
                    for (e eVar : arrayList3) {
                        arrayList.add(eVar.b());
                        arrayList2.add(eVar.e());
                    }
                    b11.add(new o.c(D0.n0(a13), D0.n0(a14), D0.n0(a15), arrayList, arrayList2));
                }
            }
            Set a16 = SetsKt.a(b11);
            AutoCloseableKt.a(D0, null);
            return a16;
        } finally {
        }
    }

    private static final o.d e(z3.b bVar, String str, boolean z10) {
        z3.e D0 = bVar.D0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int a11 = k.a(D0, "seqno");
            int a12 = k.a(D0, BidResponsedEx.KEY_CID);
            int a13 = k.a(D0, "name");
            int a14 = k.a(D0, CampaignEx.JSON_KEY_DESC);
            if (a11 != -1 && a12 != -1 && a13 != -1 && a14 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (D0.A0()) {
                    if (((int) D0.getLong(a12)) >= 0) {
                        int i11 = (int) D0.getLong(a11);
                        String n02 = D0.n0(a13);
                        String str2 = D0.getLong(a14) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i11), n02);
                        linkedHashMap2.put(Integer.valueOf(i11), str2);
                    }
                }
                List I0 = CollectionsKt.I0(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t11, T t12) {
                        return ComparisonsKt.d((Integer) ((Map.Entry) t11).getKey(), (Integer) ((Map.Entry) t12).getKey());
                    }
                });
                ArrayList arrayList = new ArrayList(CollectionsKt.v(I0, 10));
                Iterator it = I0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List R0 = CollectionsKt.R0(arrayList);
                List I02 = CollectionsKt.I0(linkedHashMap2.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t11, T t12) {
                        return ComparisonsKt.d((Integer) ((Map.Entry) t11).getKey(), (Integer) ((Map.Entry) t12).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList(CollectionsKt.v(I02, 10));
                Iterator it2 = I02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                o.d dVar = new o.d(str, z10, R0, CollectionsKt.R0(arrayList2));
                AutoCloseableKt.a(D0, null);
                return dVar;
            }
            AutoCloseableKt.a(D0, null);
            return null;
        } finally {
        }
    }

    private static final Set f(z3.b bVar, String str) {
        z3.e D0 = bVar.D0("PRAGMA index_list(`" + str + "`)");
        try {
            int a11 = k.a(D0, "name");
            int a12 = k.a(D0, "origin");
            int a13 = k.a(D0, "unique");
            if (a11 != -1 && a12 != -1 && a13 != -1) {
                Set b11 = SetsKt.b();
                while (D0.A0()) {
                    if (Intrinsics.c("c", D0.n0(a12))) {
                        o.d e11 = e(bVar, D0.n0(a11), D0.getLong(a13) == 1);
                        if (e11 == null) {
                            AutoCloseableKt.a(D0, null);
                            return null;
                        }
                        b11.add(e11);
                    }
                }
                Set a14 = SetsKt.a(b11);
                AutoCloseableKt.a(D0, null);
                return a14;
            }
            AutoCloseableKt.a(D0, null);
            return null;
        } finally {
        }
    }

    public static final o g(z3.b connection, String tableName) {
        Intrinsics.h(connection, "connection");
        Intrinsics.h(tableName, "tableName");
        return new o(tableName, b(connection, tableName), d(connection, tableName), f(connection, tableName));
    }
}
