package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.util.a1;
import androidx.media3.database.DatabaseIOException;
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
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f10923a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f10924b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f10925c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f10926d;

    /* renamed from: e, reason: collision with root package name */
    private c f10927e;

    /* renamed from: f, reason: collision with root package name */
    private c f10928f;

    /* loaded from: classes2.dex */
    private static final class a implements c {

        /* renamed from: e, reason: collision with root package name */
        private static final String[] f10929e = {"id", "key", TtmlNode.TAG_METADATA};

        /* renamed from: a, reason: collision with root package name */
        private final v1.a f10930a;

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray f10931b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        private String f10932c;

        /* renamed from: d, reason: collision with root package name */
        private String f10933d;

        public a(v1.a aVar) {
            this.f10930a = aVar;
        }

        private void i(SQLiteDatabase sQLiteDatabase, j jVar) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            k.r(jVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(jVar.f10916a));
            contentValues.put("key", jVar.f10917b);
            contentValues.put(TtmlNode.TAG_METADATA, byteArray);
            sQLiteDatabase.replaceOrThrow((String) androidx.media3.common.util.a.e(this.f10933d), null, contentValues);
        }

        private static void j(v1.a aVar, String str) {
            try {
                String n11 = n(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    v1.c.c(writableDatabase, 1, str);
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
            sQLiteDatabase.delete((String) androidx.media3.common.util.a.e(this.f10933d), "id = ?", new String[]{Integer.toString(i11)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor m() {
            return this.f10930a.getReadableDatabase().query((String) androidx.media3.common.util.a.e(this.f10933d), f10929e, null, null, null, null, null);
        }

        private static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void o(SQLiteDatabase sQLiteDatabase) {
            v1.c.d(sQLiteDatabase, 1, (String) androidx.media3.common.util.a.e(this.f10932c), 1);
            l(sQLiteDatabase, (String) androidx.media3.common.util.a.e(this.f10933d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f10933d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // androidx.media3.datasource.cache.k.c
        public boolean a() {
            try {
                return v1.c.b(this.f10930a.getReadableDatabase(), 1, (String) androidx.media3.common.util.a.e(this.f10932c)) != -1;
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void b(HashMap hashMap) {
            if (this.f10931b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f10930a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i11 = 0; i11 < this.f10931b.size(); i11++) {
                    try {
                        j jVar = (j) this.f10931b.valueAt(i11);
                        if (jVar == null) {
                            k(writableDatabase, this.f10931b.keyAt(i11));
                        } else {
                            i(writableDatabase, jVar);
                        }
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f10931b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void c(long j11) {
            String hexString = Long.toHexString(j11);
            this.f10932c = hexString;
            this.f10933d = n(hexString);
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void d(HashMap hashMap) {
            try {
                SQLiteDatabase writableDatabase = this.f10930a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, (j) it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f10931b.clear();
                    writableDatabase.endTransaction();
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void e(HashMap hashMap, SparseArray sparseArray) {
            androidx.media3.common.util.a.g(this.f10931b.size() == 0);
            try {
                if (v1.c.b(this.f10930a.getReadableDatabase(), 1, (String) androidx.media3.common.util.a.e(this.f10932c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f10930a.getWritableDatabase();
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
                        j jVar = new j(m11.getInt(0), (String) androidx.media3.common.util.a.e(m11.getString(1)), k.o(new DataInputStream(new ByteArrayInputStream(m11.getBlob(2)))));
                        hashMap.put(jVar.f10917b, jVar);
                        sparseArray.put(jVar.f10916a, jVar.f10917b);
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

        @Override // androidx.media3.datasource.cache.k.c
        public void f() {
            j(this.f10930a, (String) androidx.media3.common.util.a.e(this.f10932c));
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void g(j jVar, boolean z10) {
            if (z10) {
                this.f10931b.delete(jVar.f10916a);
            } else {
                this.f10931b.put(jVar.f10916a, null);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void h(j jVar) {
            this.f10931b.put(jVar.f10916a, jVar);
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f10934a;

        /* renamed from: b, reason: collision with root package name */
        private final Cipher f10935b;

        /* renamed from: c, reason: collision with root package name */
        private final SecretKeySpec f10936c;

        /* renamed from: d, reason: collision with root package name */
        private final SecureRandom f10937d;

        /* renamed from: e, reason: collision with root package name */
        private final androidx.media3.common.util.b f10938e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f10939f;

        /* renamed from: g, reason: collision with root package name */
        private r f10940g;

        public b(File file, byte[] bArr, boolean z10) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            androidx.media3.common.util.a.g((bArr == null && z10) ? false : true);
            if (bArr != null) {
                androidx.media3.common.util.a.a(bArr.length == 16);
                try {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
                    throw new IllegalStateException(e11);
                }
            } else {
                androidx.media3.common.util.a.a(!z10);
                cipher = null;
                secretKeySpec = null;
            }
            this.f10934a = z10;
            this.f10935b = cipher;
            this.f10936c = secretKeySpec;
            this.f10937d = z10 ? new SecureRandom() : null;
            this.f10938e = new androidx.media3.common.util.b(file);
        }

        private int i(j jVar, int i11) {
            int i12;
            int hashCode;
            int hashCode2 = (jVar.f10916a * 31) + jVar.f10917b.hashCode();
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
            o o11;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i11 < 2) {
                long readLong = dataInputStream.readLong();
                n nVar = new n();
                n.g(nVar, readLong);
                o11 = o.f10943c.c(nVar);
            } else {
                o11 = k.o(dataInputStream);
            }
            return new j(readInt, readUTF, o11);
        }

        private boolean k(HashMap hashMap, SparseArray sparseArray) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.f10938e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.f10938e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.f10935b == null) {
                            a1.m(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.f10935b.init(2, (Key) a1.i(this.f10936c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f10935b));
                        } catch (InvalidAlgorithmParameterException e11) {
                            e = e11;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e12) {
                            e = e12;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.f10934a) {
                        this.f10939f = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i11 = 0;
                    for (int i12 = 0; i12 < readInt2; i12++) {
                        j j11 = j(readInt, dataInputStream);
                        hashMap.put(j11.f10917b, j11);
                        sparseArray.put(j11.f10916a, j11.f10917b);
                        i11 += i(j11, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    boolean z10 = dataInputStream.read() == -1;
                    if (readInt3 == i11 && z10) {
                        a1.m(dataInputStream);
                        return true;
                    }
                    a1.m(dataInputStream);
                    return false;
                }
                a1.m(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    a1.m(dataInputStream2);
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    a1.m(dataInputStream2);
                }
                throw th;
            }
        }

        private void l(j jVar, DataOutputStream dataOutputStream) {
            dataOutputStream.writeInt(jVar.f10916a);
            dataOutputStream.writeUTF(jVar.f10917b);
            k.r(jVar.d(), dataOutputStream);
        }

        private void m(HashMap hashMap) {
            r rVar;
            DataOutputStream dataOutputStream;
            Closeable closeable = null;
            try {
                OutputStream f11 = this.f10938e.f();
                r rVar2 = this.f10940g;
                if (rVar2 == null) {
                    this.f10940g = new r(f11);
                } else {
                    rVar2.b(f11);
                }
                rVar = this.f10940g;
                dataOutputStream = new DataOutputStream(rVar);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                dataOutputStream.writeInt(2);
                int i11 = 0;
                dataOutputStream.writeInt(this.f10934a ? 1 : 0);
                if (this.f10934a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) a1.i(this.f10937d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) a1.i(this.f10935b)).init(1, (Key) a1.i(this.f10936c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(rVar, this.f10935b));
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
                this.f10938e.b(dataOutputStream);
                a1.m(null);
            } catch (Throwable th3) {
                th = th3;
                closeable = dataOutputStream;
                a1.m(closeable);
                throw th;
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public boolean a() {
            return this.f10938e.c();
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void b(HashMap hashMap) {
            if (this.f10939f) {
                d(hashMap);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void c(long j11) {
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void d(HashMap hashMap) {
            m(hashMap);
            this.f10939f = false;
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void e(HashMap hashMap, SparseArray sparseArray) {
            androidx.media3.common.util.a.g(!this.f10939f);
            if (k(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.f10938e.a();
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void f() {
            this.f10938e.a();
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void g(j jVar, boolean z10) {
            this.f10939f = true;
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void h(j jVar) {
            this.f10939f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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

    public k(v1.a aVar, File file, byte[] bArr, boolean z10, boolean z11) {
        androidx.media3.common.util.a.g((aVar == null && file == null) ? false : true);
        this.f10923a = new HashMap();
        this.f10924b = new SparseArray();
        this.f10925c = new SparseBooleanArray();
        this.f10926d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, CachedContentIndex.FILE_NAME), bArr, z10) : null;
        if (aVar2 == null || (bVar != null && z11)) {
            this.f10927e = (c) a1.i(bVar);
            this.f10928f = aVar2;
        } else {
            this.f10927e = aVar2;
            this.f10928f = bVar;
        }
    }

    private j c(String str) {
        int j11 = j(this.f10924b);
        j jVar = new j(j11, str);
        this.f10923a.put(str, jVar);
        this.f10924b.put(j11, str);
        this.f10926d.put(j11, true);
        this.f10927e.h(jVar);
        return jVar;
    }

    static int j(SparseArray sparseArray) {
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

    public static boolean m(String str) {
        return str.startsWith(CachedContentIndex.FILE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o o(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < readInt; i11++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                throw new IOException("Invalid value size: " + readInt2);
            }
            int min = Math.min(readInt2, 10485760);
            byte[] bArr = a1.f10437f;
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
    public static void r(o oVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry> d11 = oVar.d();
        dataOutputStream.writeInt(d11.size());
        for (Map.Entry entry : d11) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void d(String str, n nVar) {
        j k11 = k(str);
        if (k11.b(nVar)) {
            this.f10927e.h(k11);
        }
    }

    public int e(String str) {
        return k(str).f10916a;
    }

    public j f(String str) {
        return (j) this.f10923a.get(str);
    }

    public Collection g() {
        return Collections.unmodifiableCollection(this.f10923a.values());
    }

    public m h(String str) {
        j f11 = f(str);
        return f11 != null ? f11.d() : o.f10943c;
    }

    public String i(int i11) {
        return (String) this.f10924b.get(i11);
    }

    public j k(String str) {
        j jVar = (j) this.f10923a.get(str);
        return jVar == null ? c(str) : jVar;
    }

    public void l(long j11) {
        c cVar;
        this.f10927e.c(j11);
        c cVar2 = this.f10928f;
        if (cVar2 != null) {
            cVar2.c(j11);
        }
        if (this.f10927e.a() || (cVar = this.f10928f) == null || !cVar.a()) {
            this.f10927e.e(this.f10923a, this.f10924b);
        } else {
            this.f10928f.e(this.f10923a, this.f10924b);
            this.f10927e.d(this.f10923a);
        }
        c cVar3 = this.f10928f;
        if (cVar3 != null) {
            cVar3.f();
            this.f10928f = null;
        }
    }

    public void n(String str) {
        j jVar = (j) this.f10923a.get(str);
        if (jVar != null && jVar.g() && jVar.i()) {
            this.f10923a.remove(str);
            int i11 = jVar.f10916a;
            boolean z10 = this.f10926d.get(i11);
            this.f10927e.g(jVar, z10);
            if (z10) {
                this.f10924b.remove(i11);
                this.f10926d.delete(i11);
            } else {
                this.f10924b.put(i11, null);
                this.f10925c.put(i11, true);
            }
        }
    }

    public void p() {
        r4 it = ImmutableSet.copyOf((Collection) this.f10923a.keySet()).iterator();
        while (it.hasNext()) {
            n((String) it.next());
        }
    }

    public void q() {
        this.f10927e.b(this.f10923a);
        int size = this.f10925c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f10924b.remove(this.f10925c.keyAt(i11));
        }
        this.f10925c.clear();
        this.f10926d.clear();
    }
}
