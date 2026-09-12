package androidx.room.support;

import a4.e;
import android.content.Context;
import android.util.Log;
import androidx.room.RoomDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class m implements a4.e, androidx.room.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f14857a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14858b;

    /* renamed from: c, reason: collision with root package name */
    private final File f14859c;

    /* renamed from: d, reason: collision with root package name */
    private final Callable f14860d;

    /* renamed from: e, reason: collision with root package name */
    private final int f14861e;

    /* renamed from: f, reason: collision with root package name */
    private final a4.e f14862f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.room.c f14863g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14864h;

    /* loaded from: classes2.dex */
    public static final class a extends e.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f14865c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i11, int i12) {
            super(i12);
            this.f14865c = i11;
        }

        @Override // a4.e.a
        public void d(a4.d db2) {
            Intrinsics.h(db2, "db");
        }

        @Override // a4.e.a
        public void f(a4.d db2) {
            Intrinsics.h(db2, "db");
            int i11 = this.f14865c;
            if (i11 < 1) {
                db2.S(i11);
            }
        }

        @Override // a4.e.a
        public void g(a4.d db2, int i11, int i12) {
            Intrinsics.h(db2, "db");
        }
    }

    public m(Context context, String str, File file, Callable callable, int i11, a4.e delegate) {
        Intrinsics.h(context, "context");
        Intrinsics.h(delegate, "delegate");
        this.f14857a = context;
        this.f14858b = str;
        this.f14859c = file;
        this.f14860d = callable;
        this.f14861e = i11;
        this.f14862f = delegate;
    }

    private final void b(File file, boolean z10) {
        ReadableByteChannel newChannel;
        if (this.f14858b != null) {
            newChannel = Channels.newChannel(this.f14857a.getAssets().open(this.f14858b));
        } else if (this.f14859c != null) {
            newChannel = new FileInputStream(this.f14859c).getChannel();
        } else {
            Callable callable = this.f14860d;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                newChannel = Channels.newChannel((InputStream) callable.call());
            } catch (Exception e11) {
                throw new IOException("inputStreamCallable exception on call", e11);
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f14857a.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        Intrinsics.e(channel);
        androidx.room.util.d.a(newChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        Intrinsics.e(createTempFile);
        h(createTempFile, z10);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final a4.e d(File file) {
        try {
            int h11 = androidx.room.util.b.h(file);
            return new b4.h().a(e.b.f230f.a(this.f14857a).d(file.getAbsolutePath()).c(new a(h11, RangesKt.f(h11, 1))).b());
        } catch (IOException e11) {
            throw new RuntimeException("Malformed database file, unable to read version.", e11);
        }
    }

    private final void h(File file, boolean z10) {
        androidx.room.c cVar = this.f14863g;
        if (cVar == null) {
            Intrinsics.z("databaseConfiguration");
            cVar = null;
        }
        if (cVar.f14668q == null) {
            return;
        }
        a4.e d11 = d(file);
        try {
            a4.d writableDatabase = z10 ? d11.getWritableDatabase() : d11.getReadableDatabase();
            androidx.room.c cVar2 = this.f14863g;
            if (cVar2 == null) {
                Intrinsics.z("databaseConfiguration");
                cVar2 = null;
            }
            RoomDatabase.e eVar = cVar2.f14668q;
            Intrinsics.e(eVar);
            eVar.a(writableDatabase);
            Unit unit = Unit.f67184a;
            CloseableKt.a(d11, null);
        } finally {
        }
    }

    private final void k(boolean z10) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        File databasePath = this.f14857a.getDatabasePath(databaseName);
        androidx.room.c cVar = this.f14863g;
        androidx.room.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.z("databaseConfiguration");
            cVar = null;
        }
        d4.a aVar = new d4.a(databaseName, this.f14857a.getFilesDir(), cVar.f14674w);
        try {
            d4.a.c(aVar, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    Intrinsics.e(databasePath);
                    b(databasePath, z10);
                    aVar.d();
                    return;
                } catch (IOException e11) {
                    throw new RuntimeException("Unable to copy database file.", e11);
                }
            }
            try {
                Intrinsics.e(databasePath);
                int h11 = androidx.room.util.b.h(databasePath);
                if (h11 == this.f14861e) {
                    aVar.d();
                    return;
                }
                androidx.room.c cVar3 = this.f14863g;
                if (cVar3 == null) {
                    Intrinsics.z("databaseConfiguration");
                } else {
                    cVar2 = cVar3;
                }
                if (cVar2.e(h11, this.f14861e)) {
                    aVar.d();
                    return;
                }
                if (this.f14857a.deleteDatabase(databaseName)) {
                    try {
                        b(databasePath, z10);
                        Unit unit = Unit.f67184a;
                    } catch (IOException e12) {
                        Log.w("ROOM", "Unable to copy database file.", e12);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar.d();
                return;
            } catch (IOException e13) {
                Log.w("ROOM", "Unable to read database version.", e13);
                aVar.d();
                return;
            }
        } catch (Throwable th2) {
            aVar.d();
            throw th2;
        }
        aVar.d();
        throw th2;
    }

    @Override // a4.e, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.f14864h = false;
    }

    @Override // a4.e
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.d
    public a4.e getDelegate() {
        return this.f14862f;
    }

    @Override // a4.e
    public a4.d getReadableDatabase() {
        if (!this.f14864h) {
            k(false);
            this.f14864h = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @Override // a4.e
    public a4.d getWritableDatabase() {
        if (!this.f14864h) {
            k(true);
            this.f14864h = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void i(androidx.room.c databaseConfiguration) {
        Intrinsics.h(databaseConfiguration, "databaseConfiguration");
        this.f14863g = databaseConfiguration;
    }

    @Override // a4.e
    public void setWriteAheadLoggingEnabled(boolean z10) {
        getDelegate().setWriteAheadLoggingEnabled(z10);
    }
}
