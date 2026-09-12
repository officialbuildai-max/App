package androidx.room;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class a0 {
    public static final void a(RoomDatabase roomDatabase, c configuration) {
        Intrinsics.h(roomDatabase, "<this>");
        Intrinsics.h(configuration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set B = roomDatabase.B();
        int size = configuration.f14670s.size();
        boolean[] zArr = new boolean[size];
        Iterator it = B.iterator();
        while (true) {
            int i11 = -1;
            if (!it.hasNext()) {
                int size2 = configuration.f14670s.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i12 = size2 - 1;
                        if (size2 >= size || !zArr[size2]) {
                            break;
                        } else if (i12 < 0) {
                            break;
                        } else {
                            size2 = i12;
                        }
                    }
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                }
                for (y3.c cVar : roomDatabase.n(linkedHashMap)) {
                    if (!configuration.f14655d.c(cVar.f78946a, cVar.f78947b)) {
                        configuration.f14655d.a(cVar);
                    }
                }
                return;
            }
            KClass kClass = (KClass) it.next();
            int size3 = configuration.f14670s.size() - 1;
            if (size3 >= 0) {
                while (true) {
                    int i13 = size3 - 1;
                    if (kClass.d(configuration.f14670s.get(size3))) {
                        zArr[size3] = true;
                        i11 = size3;
                        break;
                    } else if (i13 < 0) {
                        break;
                    } else {
                        size3 = i13;
                    }
                }
            }
            if (i11 < 0) {
                throw new IllegalArgumentException(("A required auto migration spec (" + kClass.f() + ") is missing in the database configuration.").toString());
            }
            linkedHashMap.put(kClass, configuration.f14670s.get(i11));
        }
    }

    public static final void b(Set migrationStartAndEndVersions, Set migrationsNotRequiredFrom) {
        Intrinsics.h(migrationStartAndEndVersions, "migrationStartAndEndVersions");
        Intrinsics.h(migrationsNotRequiredFrom, "migrationsNotRequiredFrom");
        if (migrationStartAndEndVersions.isEmpty()) {
            return;
        }
        Iterator it = migrationStartAndEndVersions.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (migrationsNotRequiredFrom.contains(Integer.valueOf(intValue))) {
                throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: " + intValue).toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[LOOP:1: B:5:0x003b->B:17:0x006c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.room.RoomDatabase r9, androidx.room.c r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.util.Map r0 = r9.E()
            java.util.List r1 = r10.f14669r
            int r1 = r1.size()
            boolean[] r1 = new boolean[r1]
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r2 = r0.hasNext()
            r3 = -1
            if (r2 == 0) goto La6
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            kotlin.reflect.KClass r4 = (kotlin.reflect.KClass) r4
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L3b:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L1e
            java.lang.Object r5 = r2.next()
            kotlin.reflect.KClass r5 = (kotlin.reflect.KClass) r5
            java.util.List r6 = r10.f14669r
            java.util.Collection r6 = (java.util.Collection) r6
            int r6 = r6.size()
            int r6 = r6 + r3
            if (r6 < 0) goto L69
        L52:
            int r7 = r6 + (-1)
            java.util.List r8 = r10.f14669r
            java.lang.Object r8 = r8.get(r6)
            boolean r8 = r5.d(r8)
            if (r8 == 0) goto L64
            r7 = 1
            r1[r6] = r7
            goto L6a
        L64:
            if (r7 >= 0) goto L67
            goto L69
        L67:
            r6 = r7
            goto L52
        L69:
            r6 = r3
        L6a:
            if (r6 < 0) goto L76
            java.util.List r7 = r10.f14669r
            java.lang.Object r6 = r7.get(r6)
            r9.h(r5, r6)
            goto L3b
        L76:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "A required type converter ("
            r9.append(r10)
            java.lang.String r10 = r5.f()
            r9.append(r10)
            java.lang.String r10 = ") for "
            r9.append(r10)
            java.lang.String r10 = r4.f()
            r9.append(r10)
            java.lang.String r10 = " is missing in the database configuration."
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        La6:
            java.util.List r9 = r10.f14669r
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            int r9 = r9 + r3
            if (r9 < 0) goto Lde
        Lb1:
            int r0 = r9 + (-1)
            boolean r2 = r1[r9]
            if (r2 == 0) goto Lbc
            if (r0 >= 0) goto Lba
            goto Lde
        Lba:
            r9 = r0
            goto Lb1
        Lbc:
            java.util.List r10 = r10.f14669r
            java.lang.Object r9 = r10.get(r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected type converter "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9)
            throw r10
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.a0.c(androidx.room.RoomDatabase, androidx.room.c):void");
    }
}
