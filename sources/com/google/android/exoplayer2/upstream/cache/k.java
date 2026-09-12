package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f27414a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f27415b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f27416c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f27417d;

    /* renamed from: e, reason: collision with root package name */
    private c f27418e;

    /* renamed from: f, reason: collision with root package name */
    private c f27419f;

    /* loaded from: classes3.dex */
    private static final class a implements c {

        /* renamed from: e, reason: collision with root package name */
        private static final String[] f27420e = {"id", "key", TtmlNode.TAG_METADATA};

        /* renamed from: a, reason: collision with root package name */
        private final f9.a f27421a;

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray f27422b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        private String f27423c;

        /* renamed from: d, reason: collision with root package name */
        private String f27424d;

        public a(f9.a aVar) {
            this.f27421a = aVar;
        }

        private void i(SQLiteDatabase sQLiteDatabase, j jVar) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            k.t(jVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(jVar.f27407a));
            contentValues.put("key", jVar.f27408b);
            contentValues.put(TtmlNode.TAG_METADATA, byteArray);
            sQLiteDatabase.replaceOrThrow((String) com.google.android.exoplayer2.util.a.e(this.f27424d), null, contentValues);
        }

        private static void j(f9.a aVar, String str) {
            try {
                String n11 = n(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    f9.c.c(writableDatabase, 1, str);
                    l(writableDatabase, n11);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase, int i11) {
            sQLiteDatabase.delete((String) com.google.android.exoplayer2.util.a.e(this.f27424d), "id = ?", new String[]{Integer.toString(i11)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor m() {
            return this.f27421a.getReadableDatabase().query((String) com.google.android.exoplayer2.util.a.e(this.f27424d), f27420e, null, null, null, null, null);
        }

        private static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void o(SQLiteDatabase sQLiteDatabase) {
            f9.c.d(sQLiteDatabase, 1, (String) com.google.android.exoplayer2.util.a.e(this.f27423c), 1);
            l(sQLiteDatabase, (String) com.google.android.exoplayer2.util.a.e(this.f27424d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f27424d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public boolean a() {
            return f9.c.b(this.f27421a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f27423c)) != -1;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void b(HashMap hashMap) {
            if (this.f27422b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f27421a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i11 = 0; i11 < this.f27422b.size(); i11++) {
                    try {
                        j jVar = (j) this.f27422b.valueAt(i11);
                        if (jVar == null) {
                            k(writableDatabase, this.f27422b.keyAt(i11));
                        } else {
                            i(writableDatabase, jVar);
                        }
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f27422b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void c(long j11) {
            String hexString = Long.toHexString(j11);
            this.f27423c = hexString;
            this.f27424d = n(hexString);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void d(HashMap hashMap) {
            try {
                SQLiteDatabase writableDatabase = this.f27421a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, (j) it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f27422b.clear();
                    writableDatabase.endTransaction();
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void e(HashMap hashMap, SparseArray sparseArray) {
            com.google.android.exoplayer2.util.a.g(this.f27422b.size() == 0);
            try {
                if (f9.c.b(this.f27421a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f27423c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f27421a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        o(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                Cursor m11 = m();
                while (m11.moveToNext()) {
                    try {
                        j jVar = new j(m11.getInt(0), (String) com.google.android.exoplayer2.util.a.e(m11.getString(1)), k.q(new DataInputStream(new ByteArrayInputStream(m11.getBlob(2)))));
                        hashMap.put(jVar.f27408b, jVar);
                        sparseArray.put(jVar.f27407a, jVar.f27408b);
                    } finally {
                    }
                }
                m11.close();
            } catch (SQLiteException e11) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e11);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void f() {
            j(this.f27421a, (String) com.google.android.exoplayer2.util.a.e(this.f27423c));
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void g(j jVar, boolean z10) {
            if (z10) {
                this.f27422b.delete(jVar.f27407a);
            } else {
                this.f27422b.put(jVar.f27407a, null);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void h(j jVar) {
            this.f27422b.put(jVar.f27407a, jVar);
        }
    }

    /* loaded from: classes3.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f27425a;

        /* renamed from: b, reason: collision with root package name */
        private final Cipher f27426b;

        /* renamed from: c, reason: collision with root package name */
        private final SecretKeySpec f27427c;

        /* renamed from: d, reason: collision with root package name */
        private final SecureRandom f27428d;

        /* renamed from: e, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.b f27429e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f27430f;

        /* renamed from: g, reason: collision with root package name */
        private r f27431g;

        public b(File file, byte[] bArr, boolean z10) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            com.google.android.exoplayer2.util.a.g((bArr == null && z10) ? false : true);
            if (bArr != null) {
                com.google.android.exoplayer2.util.a.a(bArr.length == 16);
                try {
                    cipher = k.a();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
                    throw new IllegalStateException(e11);
                }
            } else {
                com.google.android.exoplayer2.util.a.a(!z10);
                cipher = null;
                secretKeySpec = null;
            }
            this.f27425a = z10;
            this.f27426b = cipher;
            this.f27427c = secretKeySpec;
            this.f27428d = z10 ? new SecureRandom() : null;
            this.f27429e = new com.google.android.exoplayer2.util.b(file);
        }

        private int i(j jVar, int i11) {
            int i12;
            int hashCode;
            int hashCode2 = (jVar.f27407a * 31) + jVar.f27408b.hashCode();
            if (i11 < 2) {
                long a11 = l.a(jVar.d());
                i12 = hashCode2 * 31;
                hashCode = (int) (a11 ^ (a11 >>> 32));
            } else {
                i12 = hashCode2 * 31;
                hashCode = jVar.d().hashCode();
            }
            return i12 + hashCode;
        }

        private j j(int i11, DataInputStream dataInputStream) {
            o q11;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i11 < 2) {
                long readLong = dataInputStream.readLong();
                n nVar = new n();
                n.g(nVar, readLong);
                q11 = o.f27434c.c(nVar);
            } else {
                q11 = k.q(dataInputStream);
            }
            return new j(readInt, readUTF, q11);
        }

        private boolean k(HashMap hashMap, SparseArray sparseArray) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.f27429e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.f27429e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.f27426b == null) {
                            p0.n(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.f27426b.init(2, (Key) p0.j(this.f27427c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f27426b));
                        } catch (InvalidAlgorithmParameterException e11) {
                            e = e11;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e12) {
                            e = e12;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.f27425a) {
                        this.f27430f = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i11 = 0;
                    for (int i12 = 0; i12 < readInt2; i12++) {
                        j j11 = j(readInt, dataInputStream);
                        hashMap.put(j11.f27408b, j11);
                        sparseArray.put(j11.f27407a, j11.f27408b);
                        i11 += i(j11, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    boolean z10 = dataInputStream.read() == -1;
                    if (readInt3 == i11 && z10) {
                        p0.n(dataInputStream);
                        return true;
                    }
                    p0.n(dataInputStream);
                    return false;
                }
                p0.n(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    p0.n(dataInputStream2);
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    p0.n(dataInputStream2);
                }
                throw th;
            }
        }

        private void l(j jVar, DataOutputStream dataOutputStream) {
            dataOutputStream.writeInt(jVar.f27407a);
            dataOutputStream.writeUTF(jVar.f27408b);
            k.t(jVar.d(), dataOutputStream);
        }

        private void m(HashMap hashMap) {
            r rVar;
            DataOutputStream dataOutputStream;
            Closeable closeable = null;
            try {
                OutputStream f11 = this.f27429e.f();
                r rVar2 = this.f27431g;
                if (rVar2 == null) {
                    this.f27431g = new r(f11);
                } else {
                    rVar2.b(f11);
                }
                rVar = this.f27431g;
                dataOutputStream = new DataOutputStream(rVar);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                dataOutputStream.writeInt(2);
                int i11 = 0;
                dataOutputStream.writeInt(this.f27425a ? 1 : 0);
                if (this.f27425a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) p0.j(this.f27428d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) p0.j(this.f27426b)).init(1, (Key) p0.j(this.f27427c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(rVar, this.f27426b));
                    } catch (InvalidAlgorithmParameterException e11) {
                        e = e11;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e12) {
                        e = e12;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(hashMap.size());
                for (j jVar : hashMap.values()) {
                    l(jVar, dataOutputStream);
                    i11 += i(jVar, 2);
                }
                dataOutputStream.writeInt(i11);
                this.f27429e.b(dataOutputStream);
                p0.n(null);
            } catch (Throwable th3) {
                th = th3;
                closeable = dataOutputStream;
                p0.n(closeable);
                throw th;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public boolean a() {
            return this.f27429e.c();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void b(HashMap hashMap) {
            if (this.f27430f) {
                d(hashMap);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void c(long j11) {
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void d(HashMap hashMap) {
            m(hashMap);
            this.f27430f = false;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void e(HashMap hashMap, SparseArray sparseArray) {
            com.google.android.exoplayer2.util.a.g(!this.f27430f);
            if (k(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.f27429e.a();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void f() {
            this.f27429e.a();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void g(j jVar, boolean z10) {
            this.f27430f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void h(j jVar) {
            this.f27430f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface c {
        boolean a();

        void b(HashMap hashMap);

        void c(long j11);

        void d(HashMap hashMap);

        void e(HashMap hashMap, SparseArray sparseArray);

        void f();

        void g(j jVar, boolean z10);

        void h(j jVar);
    }

    public k(f9.a aVar, File file, byte[] bArr, boolean z10, boolean z11) {
        com.google.android.exoplayer2.util.a.g((aVar == null && file == null) ? false : true);
        this.f27414a = new HashMap();
        this.f27415b = new SparseArray();
        this.f27416c = new SparseBooleanArray();
        this.f27417d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, CachedContentIndex.FILE_NAME), bArr, z10) : null;
        if (aVar2 == null || (bVar != null && z11)) {
            this.f27418e = (c) p0.j(bVar);
            this.f27419f = aVar2;
        } else {
            this.f27418e = aVar2;
            this.f27419f = bVar;
        }
    }

    static /* synthetic */ Cipher a() {
        return i();
    }

    private j d(String str) {
        int l11 = l(this.f27415b);
        j jVar = new j(l11, str);
        this.f27414a.put(str, jVar);
        this.f27415b.put(l11, str);
        this.f27417d.put(l11, true);
        this.f27418e.h(jVar);
        return jVar;
    }

    private static Cipher i() {
        if (p0.f27680a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    static int l(SparseArray sparseArray) {
        int size = sparseArray.size();
        int i11 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i11 < size && i11 == sparseArray.keyAt(i11)) {
            i11++;
        }
        return i11;
    }

    public static boolean o(String str) {
        return str.startsWith(CachedContentIndex.FILE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o q(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < readInt; i11++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                throw new IOException("Invalid value size: " + readInt2);
            }
            int min = Math.min(readInt2, 10485760);
            byte[] bArr = p0.f27685f;
            int i12 = 0;
            while (i12 != readInt2) {
                int i13 = i12 + min;
                bArr = Arrays.copyOf(bArr, i13);
                dataInputStream.readFully(bArr, i12, min);
                min = Math.min(readInt2 - i13, 10485760);
                i12 = i13;
            }
            hashMap.put(readUTF, bArr);
        }
        return new o(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(o oVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry> d11 = oVar.d();
        dataOutputStream.writeInt(d11.size());
        for (Map.Entry entry : d11) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void e(String str, n nVar) {
        j m11 = m(str);
        if (m11.b(nVar)) {
            this.f27418e.h(m11);
        }
    }

    public int f(String str) {
        return m(str).f27407a;
    }

    public j g(String str) {
        return (j) this.f27414a.get(str);
    }

    public Collection h() {
        return Collections.unmodifiableCollection(this.f27414a.values());
    }

    public m j(String str) {
        j g11 = g(str);
        return g11 != null ? g11.d() : o.f27434c;
    }

    public String k(int i11) {
        return (String) this.f27415b.get(i11);
    }

    public j m(String str) {
        j jVar = (j) this.f27414a.get(str);
        return jVar == null ? d(str) : jVar;
    }

    public void n(long j11) {
        c cVar;
        this.f27418e.c(j11);
        c cVar2 = this.f27419f;
        if (cVar2 != null) {
            cVar2.c(j11);
        }
        if (this.f27418e.a() || (cVar = this.f27419f) == null || !cVar.a()) {
            this.f27418e.e(this.f27414a, this.f27415b);
        } else {
            this.f27419f.e(this.f27414a, this.f27415b);
            this.f27418e.d(this.f27414a);
        }
        c cVar3 = this.f27419f;
        if (cVar3 != null) {
            cVar3.f();
            this.f27419f = null;
        }
    }

    public void p(String str) {
        j jVar = (j) this.f27414a.get(str);
        if (jVar != null && jVar.g() && jVar.i()) {
            this.f27414a.remove(str);
            int i11 = jVar.f27407a;
            boolean z10 = this.f27417d.get(i11);
            this.f27418e.g(jVar, z10);
            if (z10) {
                this.f27415b.remove(i11);
                this.f27417d.delete(i11);
            } else {
                this.f27415b.put(i11, null);
                this.f27416c.put(i11, true);
            }
        }
    }

    public void r() {
        r4 it = ImmutableSet.copyOf((Collection) this.f27414a.keySet()).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    public void s() {
        this.f27418e.b(this.f27414a);
        int size = this.f27416c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f27415b.remove(this.f27416c.keyAt(i11));
        }
        this.f27416c.clear();
        this.f27417d.clear();
    }
}
