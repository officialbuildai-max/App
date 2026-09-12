package androidx.room.util;

import androidx.room.util.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class TableInfoKt {
    private static final boolean a(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            int i14 = i13 + 1;
            if (i13 == 0 && charAt != '(') {
                return false;
            }
            if (charAt == '(') {
                i12++;
            } else if (charAt == ')' && i12 - 1 == 0 && i13 != str.length() - 1) {
                return false;
            }
            i11++;
            i13 = i14;
        }
        return i12 == 0;
    }

    public static final boolean b(String current, String str) {
        Intrinsics.h(current, "current");
        if (Intrinsics.c(current, str)) {
            return true;
        }
        if (!a(current)) {
            return false;
        }
        String substring = current.substring(1, current.length() - 1);
        Intrinsics.g(substring, "substring(...)");
        return Intrinsics.c(StringsKt.n1(substring).toString(), str);
    }

    public static final boolean c(o.a aVar, Object obj) {
        Intrinsics.h(aVar, "<this>");
        if (aVar == obj) {
            return true;
        }
        if (!(obj instanceof o.a)) {
            return false;
        }
        o.a aVar2 = (o.a) obj;
        if (aVar.a() != aVar2.a() || !Intrinsics.c(aVar.f14884a, aVar2.f14884a) || aVar.f14886c != aVar2.f14886c) {
            return false;
        }
        String str = aVar.f14888e;
        String str2 = aVar2.f14888e;
        if (aVar.f14889f == 1 && aVar2.f14889f == 2 && str != null && !b(str, str2)) {
            return false;
        }
        if (aVar.f14889f == 2 && aVar2.f14889f == 1 && str2 != null && !b(str2, str)) {
            return false;
        }
        int i11 = aVar.f14889f;
        return (i11 == 0 || i11 != aVar2.f14889f || (str == null ? str2 == null : b(str, str2))) && aVar.f14890g == aVar2.f14890g;
    }

    public static final boolean d(o.c cVar, Object obj) {
        Intrinsics.h(cVar, "<this>");
        if (cVar == obj) {
            return true;
        }
        if (!(obj instanceof o.c)) {
            return false;
        }
        o.c cVar2 = (o.c) obj;
        if (Intrinsics.c(cVar.f14891a, cVar2.f14891a) && Intrinsics.c(cVar.f14892b, cVar2.f14892b) && Intrinsics.c(cVar.f14893c, cVar2.f14893c) && Intrinsics.c(cVar.f14894d, cVar2.f14894d)) {
            return Intrinsics.c(cVar.f14895e, cVar2.f14895e);
        }
        return false;
    }

    public static final boolean e(o.d dVar, Object obj) {
        Intrinsics.h(dVar, "<this>");
        if (dVar == obj) {
            return true;
        }
        if (!(obj instanceof o.d)) {
            return false;
        }
        o.d dVar2 = (o.d) obj;
        if (dVar.f14898b == dVar2.f14898b && Intrinsics.c(dVar.f14899c, dVar2.f14899c) && Intrinsics.c(dVar.f14900d, dVar2.f14900d)) {
            return StringsKt.W(dVar.f14897a, "index_", false, 2, null) ? StringsKt.W(dVar2.f14897a, "index_", false, 2, null) : Intrinsics.c(dVar.f14897a, dVar2.f14897a);
        }
        return false;
    }

    public static final boolean f(o oVar, Object obj) {
        Set set;
        Intrinsics.h(oVar, "<this>");
        if (oVar == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar2 = (o) obj;
        if (!Intrinsics.c(oVar.f14879a, oVar2.f14879a) || !Intrinsics.c(oVar.f14880b, oVar2.f14880b) || !Intrinsics.c(oVar.f14881c, oVar2.f14881c)) {
            return false;
        }
        Set set2 = oVar.f14882d;
        if (set2 == null || (set = oVar2.f14882d) == null) {
            return true;
        }
        return Intrinsics.c(set2, set);
    }

    public static final String g(Collection collection) {
        Intrinsics.h(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return StringsKt.j(CollectionsKt.s0(collection, ",\n", "\n", "\n", 0, null, null, 56, null), null, 1, null) + "},";
    }

    public static final int h(o.a aVar) {
        Intrinsics.h(aVar, "<this>");
        return (((((aVar.f14884a.hashCode() * 31) + aVar.f14890g) * 31) + (aVar.f14886c ? 1231 : 1237)) * 31) + aVar.f14887d;
    }

    public static final int i(o.c cVar) {
        Intrinsics.h(cVar, "<this>");
        return (((((((cVar.f14891a.hashCode() * 31) + cVar.f14892b.hashCode()) * 31) + cVar.f14893c.hashCode()) * 31) + cVar.f14894d.hashCode()) * 31) + cVar.f14895e.hashCode();
    }

    public static final int j(o.d dVar) {
        Intrinsics.h(dVar, "<this>");
        return ((((((StringsKt.W(dVar.f14897a, "index_", false, 2, null) ? -1184239155 : dVar.f14897a.hashCode()) * 31) + (dVar.f14898b ? 1 : 0)) * 31) + dVar.f14899c.hashCode()) * 31) + dVar.f14900d.hashCode();
    }

    public static final int k(o oVar) {
        Intrinsics.h(oVar, "<this>");
        return (((oVar.f14879a.hashCode() * 31) + oVar.f14880b.hashCode()) * 31) + oVar.f14881c.hashCode();
    }

    private static final void l(Collection collection) {
        StringsKt.j(CollectionsKt.s0(collection, ",", null, null, 0, null, null, 62, null), null, 1, null);
        StringsKt.j(" }", null, 1, null);
    }

    private static final void m(Collection collection) {
        StringsKt.j(CollectionsKt.s0(collection, ",", null, null, 0, null, null, 62, null), null, 1, null);
        StringsKt.j("},", null, 1, null);
    }

    public static final String n(o.a aVar) {
        Intrinsics.h(aVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |Column {\n            |   name = '");
        sb2.append(aVar.f14884a);
        sb2.append("',\n            |   type = '");
        sb2.append(aVar.f14885b);
        sb2.append("',\n            |   affinity = '");
        sb2.append(aVar.f14890g);
        sb2.append("',\n            |   notNull = '");
        sb2.append(aVar.f14886c);
        sb2.append("',\n            |   primaryKeyPosition = '");
        sb2.append(aVar.f14887d);
        sb2.append("',\n            |   defaultValue = '");
        String str = aVar.f14888e;
        if (str == null) {
            str = "undefined";
        }
        sb2.append(str);
        sb2.append("'\n            |}\n        ");
        return StringsKt.j(StringsKt.p(sb2.toString(), null, 1, null), null, 1, null);
    }

    public static final String o(o.c cVar) {
        Intrinsics.h(cVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |ForeignKey {\n            |   referenceTable = '");
        sb2.append(cVar.f14891a);
        sb2.append("',\n            |   onDelete = '");
        sb2.append(cVar.f14892b);
        sb2.append("',\n            |   onUpdate = '");
        sb2.append(cVar.f14893c);
        sb2.append("',\n            |   columnNames = {");
        m(CollectionsKt.H0(cVar.f14894d));
        Unit unit = Unit.f67184a;
        sb2.append(unit);
        sb2.append("\n            |   referenceColumnNames = {");
        l(CollectionsKt.H0(cVar.f14895e));
        sb2.append(unit);
        sb2.append("\n            |}\n        ");
        return StringsKt.j(StringsKt.p(sb2.toString(), null, 1, null), null, 1, null);
    }

    public static final String p(o.d dVar) {
        Intrinsics.h(dVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |Index {\n            |   name = '");
        sb2.append(dVar.f14897a);
        sb2.append("',\n            |   unique = '");
        sb2.append(dVar.f14898b);
        sb2.append("',\n            |   columns = {");
        m(dVar.f14899c);
        Unit unit = Unit.f67184a;
        sb2.append(unit);
        sb2.append("\n            |   orders = {");
        l(dVar.f14900d);
        sb2.append(unit);
        sb2.append("\n            |}\n        ");
        return StringsKt.j(StringsKt.p(sb2.toString(), null, 1, null), null, 1, null);
    }

    public static final String q(o oVar) {
        List l11;
        Intrinsics.h(oVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |TableInfo {\n            |    name = '");
        sb2.append(oVar.f14879a);
        sb2.append("',\n            |    columns = {");
        sb2.append(g(CollectionsKt.I0(oVar.f14880b.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((o.a) t11).f14884a, ((o.a) t12).f14884a);
            }
        })));
        sb2.append("\n            |    foreignKeys = {");
        sb2.append(g(oVar.f14881c));
        sb2.append("\n            |    indices = {");
        Set set = oVar.f14882d;
        if (set == null || (l11 = CollectionsKt.I0(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((o.d) t11).f14897a, ((o.d) t12).f14897a);
            }
        })) == null) {
            l11 = CollectionsKt.l();
        }
        sb2.append(g(l11));
        sb2.append("\n            |}\n        ");
        return StringsKt.p(sb2.toString(), null, 1, null);
    }
}
