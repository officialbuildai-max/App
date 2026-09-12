package org.apache.commons.compress.archivers.zip;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f71256a = new ConcurrentHashMap();

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f71257b = new a(0);

        /* renamed from: c, reason: collision with root package name */
        public static final a f71258c = new a(1);

        /* renamed from: d, reason: collision with root package name */
        public static final a f71259d = new a(2);

        /* renamed from: a, reason: collision with root package name */
        private final int f71260a;

        private a(int i11) {
            this.f71260a = i11;
        }

        public t a(byte[] bArr, int i11, int i12, boolean z10, int i13) {
            int i14 = this.f71260a;
            if (i14 == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bad extra field starting at ");
                sb2.append(i11);
                sb2.append(".  Block length of ");
                sb2.append(i13);
                sb2.append(" bytes exceeds remaining data of ");
                sb2.append(i12 - 4);
                sb2.append(" bytes.");
                throw new ZipException(sb2.toString());
            }
            if (i14 == 1) {
                return null;
            }
            if (i14 != 2) {
                throw new ZipException("Unknown UnparseableExtraField key: " + this.f71260a);
            }
            i iVar = new i();
            if (z10) {
                iVar.parseFromLocalFileData(bArr, i11, i12);
            } else {
                iVar.parseFromCentralDirectoryData(bArr, i11, i12);
            }
            return iVar;
        }
    }

    static {
        d(b.class);
        d(X5455_ExtendedTimestamp.class);
        d(X7875_NewUnix.class);
        d(d.class);
        d(h.class);
        d(g.class);
        d(q.class);
        d(k.class);
        d(l.class);
        d(m.class);
        d(n.class);
        d(o.class);
        d(p.class);
        d(f.class);
    }

    public static t a(ZipShort zipShort) {
        t b11 = b(zipShort);
        if (b11 != null) {
            return b11;
        }
        j jVar = new j();
        jVar.b(zipShort);
        return jVar;
    }

    public static t b(ZipShort zipShort) {
        Class cls = (Class) f71256a.get(zipShort);
        if (cls != null) {
            return (t) cls.newInstance();
        }
        return null;
    }

    public static t c(t tVar, byte[] bArr, int i11, int i12, boolean z10) {
        try {
            if (z10) {
                tVar.parseFromLocalFileData(bArr, i11, i12);
            } else {
                tVar.parseFromCentralDirectoryData(bArr, i11, i12);
            }
            return tVar;
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ((ZipException) new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(tVar.getHeaderId().getValue())).initCause(e11));
        }
    }

    public static void d(Class cls) {
        try {
            f71256a.put(((t) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException unused3) {
            throw new RuntimeException(cls + " is not a concrete class");
        }
    }
}
