package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
public final class FileDataSource extends f {

    /* renamed from: e, reason: collision with root package name */
    private RandomAccessFile f27293e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f27294f;

    /* renamed from: g, reason: collision with root package name */
    private long f27295g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f27296h;

    /* loaded from: classes3.dex */
    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super(exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
            super(str, th2, i11);
        }

        public FileDataSourceException(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(@Nullable Throwable th2) {
            return (th2 instanceof ErrnoException) && ((ErrnoException) th2).errno == OsConstants.EACCES;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private k0 f27297a;

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            k0 k0Var = this.f27297a;
            if (k0Var != null) {
                fileDataSource.e(k0Var);
            }
            return fileDataSource;
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile l(Uri uri) {
        try {
            return new RandomAccessFile((String) com.google.android.exoplayer2.util.a.e(uri.getPath()), CampaignEx.JSON_KEY_AD_R);
        } catch (FileNotFoundException e11) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e11, (p0.f27680a < 21 || !a.b(e11.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e11, 1004);
        } catch (SecurityException e12) {
            throw new FileDataSourceException(e12, 2006);
        } catch (RuntimeException e13) {
            throw new FileDataSourceException(e13, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        Uri uri = nVar.f27491a;
        this.f27294f = uri;
        j(nVar);
        RandomAccessFile l11 = l(uri);
        this.f27293e = l11;
        try {
            l11.seek(nVar.f27497g);
            long j11 = nVar.f27498h;
            if (j11 == -1) {
                j11 = this.f27293e.length() - nVar.f27497g;
            }
            this.f27295g = j11;
            if (j11 < 0) {
                throw new FileDataSourceException(null, null, 2008);
            }
            this.f27296h = true;
            k(nVar);
            return this.f27295g;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27294f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f27293e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e11) {
                throw new FileDataSourceException(e11, 2000);
            }
        } finally {
            this.f27293e = null;
            if (this.f27296h) {
                this.f27296h = false;
                i();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27294f;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (this.f27295g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) p0.j(this.f27293e)).read(bArr, i11, (int) Math.min(this.f27295g, i12));
            if (read > 0) {
                this.f27295g -= read;
                h(read);
            }
            return read;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }
}
