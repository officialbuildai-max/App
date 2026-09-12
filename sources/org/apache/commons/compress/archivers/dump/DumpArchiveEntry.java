package org.apache.commons.compress.archivers.dump;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class DumpArchiveEntry implements o00.a {

    /* renamed from: a, reason: collision with root package name */
    private String f71235a;

    /* renamed from: b, reason: collision with root package name */
    private TYPE f71236b = TYPE.UNKNOWN;

    /* renamed from: c, reason: collision with root package name */
    private Set f71237c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private final a f71238d = new a();

    /* renamed from: e, reason: collision with root package name */
    private String f71239e;

    /* renamed from: f, reason: collision with root package name */
    private int f71240f;

    /* loaded from: classes7.dex */
    public enum PERMISSION {
        SETUID(2048),
        SETGUI(1024),
        STICKY(512),
        USER_READ(256),
        USER_WRITE(128),
        USER_EXEC(64),
        GROUP_READ(32),
        GROUP_WRITE(16),
        GROUP_EXEC(8),
        WORLD_READ(4),
        WORLD_WRITE(2),
        WORLD_EXEC(1);

        private int code;

        PERMISSION(int i11) {
            this.code = i11;
        }

        public static Set<PERMISSION> find(int i11) {
            HashSet hashSet = new HashSet();
            for (PERMISSION permission : values()) {
                int i12 = permission.code;
                if ((i11 & i12) == i12) {
                    hashSet.add(permission);
                }
            }
            return hashSet.isEmpty() ? Collections.emptySet() : EnumSet.copyOf((Collection) hashSet);
        }
    }

    /* loaded from: classes7.dex */
    public enum TYPE {
        WHITEOUT(14),
        SOCKET(12),
        LINK(10),
        FILE(8),
        BLKDEV(6),
        DIRECTORY(4),
        CHRDEV(2),
        FIFO(1),
        UNKNOWN(15);

        private int code;

        TYPE(int i11) {
            this.code = i11;
        }

        public static TYPE find(int i11) {
            TYPE type = UNKNOWN;
            for (TYPE type2 : values()) {
                if (i11 == type2.code) {
                    type = type2;
                }
            }
            return type;
        }
    }

    /* loaded from: classes7.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f71241a = new byte[512];

        a() {
        }
    }

    public String a() {
        return this.f71235a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f71239e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DumpArchiveEntry dumpArchiveEntry = (DumpArchiveEntry) obj;
        return dumpArchiveEntry.f71238d != null && this.f71240f == dumpArchiveEntry.f71240f;
    }

    public int hashCode() {
        return this.f71240f;
    }

    public String toString() {
        return a();
    }
}
