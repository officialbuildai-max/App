package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import w1.h;
import w1.n;

/* loaded from: classes2.dex */
public final class FileDataSource extends w1.a {

    /* renamed from: e, reason: collision with root package name */
    private RandomAccessFile f10778e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f10779f;

    /* renamed from: g, reason: collision with root package name */
    private long f10780g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10781h;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static final class a implements a.InterfaceC0099a {

        /* renamed from: a, reason: collision with root package name */
        private n f10782a;

        @Override // androidx.media3.datasource.a.InterfaceC0099a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            n nVar = this.f10782a;
            if (nVar != null) {
                fileDataSource.c(nVar);
            }
            return fileDataSource;
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile h(Uri uri) {
        try {
            return new RandomAccessFile((String) androidx.media3.common.util.a.e(uri.getPath()), CampaignEx.JSON_KEY_AD_R);
        } catch (FileNotFoundException e11) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e11, ((e11.getCause() instanceof ErrnoException) && ((ErrnoException) e11.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e11, 1004);
        } catch (SecurityException e12) {
            throw new FileDataSourceException(e12, 2006);
        } catch (RuntimeException e13) {
            throw new FileDataSourceException(e13, 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        Uri uri = hVar.f77634a;
        this.f10779f = uri;
        f(hVar);
        RandomAccessFile h11 = h(uri);
        this.f10778e = h11;
        try {
            h11.seek(hVar.f77640g);
            long j11 = hVar.f77641h;
            if (j11 == -1) {
                j11 = this.f10778e.length() - hVar.f77640g;
            }
            this.f10780g = j11;
            if (j11 < 0) {
                throw new FileDataSourceException(null, null, 2008);
            }
            this.f10781h = true;
            g(hVar);
            return this.f10780g;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f10779f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f10778e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e11) {
                throw new FileDataSourceException(e11, 2000);
            }
        } finally {
            this.f10778e = null;
            if (this.f10781h) {
                this.f10781h = false;
                e();
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f10779f;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (this.f10780g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) a1.i(this.f10778e)).read(bArr, i11, (int) Math.min(this.f10780g, i12));
            if (read > 0) {
                this.f10780g -= read;
                d(read);
            }
            return read;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }
}
