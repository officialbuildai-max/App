package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.a1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import w1.h;

/* loaded from: classes2.dex */
public final class AssetDataSource extends w1.a {

    /* renamed from: e, reason: collision with root package name */
    private final AssetManager f10767e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f10768f;

    /* renamed from: g, reason: collision with root package name */
    private InputStream f10769g;

    /* renamed from: h, reason: collision with root package name */
    private long f10770h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10771i;

    /* loaded from: classes2.dex */
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
        this.f10767e = context.getAssets();
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        try {
            Uri uri = hVar.f77634a;
            this.f10768f = uri;
            String str = (String) androidx.media3.common.util.a.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            f(hVar);
            InputStream open = this.f10767e.open(str, 1);
            this.f10769g = open;
            if (open.skip(hVar.f77640g) < hVar.f77640g) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j11 = hVar.f77641h;
            if (j11 != -1) {
                this.f10770h = j11;
            } else {
                long available = this.f10769g.available();
                this.f10770h = available;
                if (available == 2147483647L) {
                    this.f10770h = -1L;
                }
            }
            this.f10771i = true;
            g(hVar);
            return this.f10770h;
        } catch (AssetDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new AssetDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f10768f = null;
        try {
            try {
                InputStream inputStream = this.f10769g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        } finally {
            this.f10769g = null;
            if (this.f10771i) {
                this.f10771i = false;
                e();
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f10768f;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f10770h;
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
        int read = ((InputStream) a1.i(this.f10769g)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        long j12 = this.f10770h;
        if (j12 != -1) {
            this.f10770h = j12 - read;
        }
        d(read);
        return read;
    }
}
