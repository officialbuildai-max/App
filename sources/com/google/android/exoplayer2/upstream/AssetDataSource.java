package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.p0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class AssetDataSource extends f {

    /* renamed from: e, reason: collision with root package name */
    private final AssetManager f27282e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f27283f;

    /* renamed from: g, reason: collision with root package name */
    private InputStream f27284g;

    /* renamed from: h, reason: collision with root package name */
    private long f27285h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f27286i;

    /* loaded from: classes3.dex */
    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super(iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f27282e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        try {
            Uri uri = nVar.f27491a;
            this.f27283f = uri;
            String str = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            j(nVar);
            InputStream open = this.f27282e.open(str, 1);
            this.f27284g = open;
            if (open.skip(nVar.f27497g) < nVar.f27497g) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j11 = nVar.f27498h;
            if (j11 != -1) {
                this.f27285h = j11;
            } else {
                long available = this.f27284g.available();
                this.f27285h = available;
                if (available == 2147483647L) {
                    this.f27285h = -1L;
                }
            }
            this.f27286i = true;
            k(nVar);
            return this.f27285h;
        } catch (AssetDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new AssetDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27283f = null;
        try {
            try {
                InputStream inputStream = this.f27284g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        } finally {
            this.f27284g = null;
            if (this.f27286i) {
                this.f27286i = false;
                i();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27283f;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f27285h;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        }
        int read = ((InputStream) p0.j(this.f27284g)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.f27285h;
        if (j12 != -1) {
            this.f27285h = j12 - read;
        }
        h(read);
        return read;
    }
}
