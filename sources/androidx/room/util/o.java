package androidx.room.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: e, reason: collision with root package name */
    public static final b f14878e = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f14879a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f14880b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f14881c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f14882d;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: h, reason: collision with root package name */
        public static final C0128a f14883h = new C0128a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f14884a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14885b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f14886c;

        /* renamed from: d, reason: collision with root package name */
        public final int f14887d;

        /* renamed from: e, reason: collision with root package name */
        public final String f14888e;

        /* renamed from: f, reason: collision with root package name */
        public final int f14889f;

        /* renamed from: g, reason: collision with root package name */
        public final int f14890g;

        /* renamed from: androidx.room.util.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0128a {
            private C0128a() {
            }

            public /* synthetic */ C0128a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(String name, String type, boolean z10, int i11, String str, int i12) {
            Intrinsics.h(name, "name");
            Intrinsics.h(type, "type");
            this.f14884a = name;
            this.f14885b = type;
            this.f14886c = z10;
            this.f14887d = i11;
            this.f14888e = str;
            this.f14889f = i12;
            this.f14890g = SchemaInfoUtilKt.a(type);
        }

        public final boolean a() {
            return this.f14887d > 0;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.c(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.h(this);
        }

        public String toString() {
            return TableInfoKt.n(this);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a(a4.d database, String tableName) {
            Intrinsics.h(database, "database");
            Intrinsics.h(tableName, "tableName");
            return b(new androidx.room.driver.a(database), tableName);
        }

        public final o b(z3.b connection, String tableName) {
            Intrinsics.h(connection, "connection");
            Intrinsics.h(tableName, "tableName");
            return SchemaInfoUtilKt.g(connection, tableName);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f14891a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14892b;

        /* renamed from: c, reason: collision with root package name */
        public final String f14893c;

        /* renamed from: d, reason: collision with root package name */
        public final List f14894d;

        /* renamed from: e, reason: collision with root package name */
        public final List f14895e;

        public c(String referenceTable, String onDelete, String onUpdate, List columnNames, List referenceColumnNames) {
            Intrinsics.h(referenceTable, "referenceTable");
            Intrinsics.h(onDelete, "onDelete");
            Intrinsics.h(onUpdate, "onUpdate");
            Intrinsics.h(columnNames, "columnNames");
            Intrinsics.h(referenceColumnNames, "referenceColumnNames");
            this.f14891a = referenceTable;
            this.f14892b = onDelete;
            this.f14893c = onUpdate;
            this.f14894d = columnNames;
            this.f14895e = referenceColumnNames;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.d(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.i(this);
        }

        public String toString() {
            return TableInfoKt.o(this);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: e, reason: collision with root package name */
        public static final a f14896e = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f14897a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f14898b;

        /* renamed from: c, reason: collision with root package name */
        public final List f14899c;

        /* renamed from: d, reason: collision with root package name */
        public List f14900d;

        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public d(String name, boolean z10, List columns, List orders) {
            Intrinsics.h(name, "name");
            Intrinsics.h(columns, "columns");
            Intrinsics.h(orders, "orders");
            this.f14897a = name;
            this.f14898b = z10;
            this.f14899c = columns;
            this.f14900d = orders;
            List list = orders;
            if (list.isEmpty()) {
                int size = columns.size();
                list = new ArrayList(size);
                for (int i11 = 0; i11 < size; i11++) {
                    list.add("ASC");
                }
            }
            this.f14900d = (List) list;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.e(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.j(this);
        }

        public String toString() {
            return TableInfoKt.p(this);
        }
    }

    public o(String name, Map columns, Set foreignKeys, Set set) {
        Intrinsics.h(name, "name");
        Intrinsics.h(columns, "columns");
        Intrinsics.h(foreignKeys, "foreignKeys");
        this.f14879a = name;
        this.f14880b = columns;
        this.f14881c = foreignKeys;
        this.f14882d = set;
    }

    public static final o a(a4.d dVar, String str) {
        return f14878e.a(dVar, str);
    }

    public static final o b(z3.b bVar, String str) {
        return f14878e.b(bVar, str);
    }

    public boolean equals(Object obj) {
        return TableInfoKt.f(this, obj);
    }

    public int hashCode() {
        return TableInfoKt.k(this);
    }

    public String toString() {
        return TableInfoKt.q(this);
    }
}
